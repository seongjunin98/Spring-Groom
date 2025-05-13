package com.seongjun.springdatajpa.menu.controller;

import com.seongjun.springdatajpa.menu.model.dto.CategoryDTO;
import com.seongjun.springdatajpa.menu.model.dto.MenuDTO;
import com.seongjun.springdatajpa.menu.model.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
// 필드에 final 붙은 객체를 자동으로 생성자 주입을 해준다.
@RequiredArgsConstructor    // DI 의존성 주입
public class MenuController {

    private final MenuService menuService;

    // 특정 메뉴를 조회하는 메소드
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {

        MenuDTO foundMenu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", foundMenu);

        return "menu/detail";
    }

    // 메뉴 전체조회를 실행하는 핸들러 메소드
    @GetMapping("/list")
    public String findMenuList(Model model) {

        List<MenuDTO> menuList = menuService.findAllMenu();

        model.addAttribute("menuList", menuList);

        return "menu/List";

    }

    @GetMapping("/querymethod")
    public void queryMethodSubPage() {}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam int menuPrice, Model model) {
        System.out.println("menuPrice = " + menuPrice);

        List<MenuDTO> menuList = menuService.findMenuByPrice(menuPrice);

        model.addAttribute("menuList", menuList);
        model.addAttribute("menuPrice", menuPrice);

        return "menu/searchResult";

    }

    @GetMapping("/regist")
    private void registPage() {}

    // 페이지를 return 하는 메소드가 아닌
    // data 만 리턴하는 메소드로 만들 것이다.
    // Rest_API
    @GetMapping("/category")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute MenuDTO modifyMenu) {
        menuService.modify(modifyMenu);

        return "redirect:/menu/" + modifyMenu.getMenuCode();
    }

}
