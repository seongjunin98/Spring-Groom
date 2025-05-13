package com.seongjun.springdatajpa.menu.model.service;

import com.seongjun.springdatajpa.menu.model.dto.CategoryDTO;
import com.seongjun.springdatajpa.menu.model.dto.MenuDTO;
import com.seongjun.springdatajpa.menu.model.entity.Category;
import com.seongjun.springdatajpa.menu.model.entity.Menu;
import com.seongjun.springdatajpa.menu.model.repository.CategoryRepository;
import com.seongjun.springdatajpa.menu.model.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository repository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public MenuDTO findMenuByCode(int menuCode) {

        /*
        * Service 레이어에서는 Controller 계층에서 전달 받은
        * DTO 타입의 객체를 Entity 타입으로 변환을 할 것이다.
        * modelmapper 라이브러리 사용으로 편하게 변환
        * */

        //기대값은 Menu -> 실제 값은 Optional<Menu>
        //따라서 finById 메소드는 에러 헨들링을 반드시 구현하게 만들어두었다.
        Menu foundMenu = repository.findById(menuCode)
                                    .orElseThrow(IllegalArgumentException::new);

        // 엔티티 타입을 조회해왔는데 실제 리턴 타입은 DTO 타입이다.
        // 따라서 이제 필요한 것이 Entity 타입을 DTO 로 변환해야 하는 과정이 필요
        // 1번째 인자 -> 변환 대상 // 2번째 인자 -> 대상 타입
        return modelMapper.map(foundMenu, MenuDTO.class);
        
    }

    public List<MenuDTO> findAllMenu() {

        List<Menu> menuList = repository.findAll();

        // 이전 findById 는 하나의 행

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    public List<MenuDTO> findMenuByPrice(int menuPrice) {

        /*
        * JapRepository 에서 구현 된 querymethod 만 사용하는 것이 아닌
        * 우리가 커스터마이징을 해 볼 수 있다.
        * */
        List<Menu> menuList = repository.findByMenuPriceGreaterThan(menuPrice);

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> findAllCategory() {

        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }
    @Transactional
    public void modify(MenuDTO modifyMenu) {

        // 수정하기 위해 찾아오기
        Menu foundMenu = repository.findById(modifyMenu.getMenuCode()).orElseThrow(IllegalArgumentException::new);

        // builder 패턴 -> Entity는 안전해야 될 객체 Setter 메소드 남발 x
        // 메뉴 이름만 수정 후 인스턴스 다시 생성 -> 다른 값들은 그대로
        foundMenu = foundMenu.toBuilder().menuName(modifyMenu.getMenuName()).build();

        // 빌드한 메뉴 객체 다시 저장
        repository.save(foundMenu);
    }
}
