package com.seongjun.mission01;

public class Restaurant {

    private Chef chef;

    public Restaurant(){
    }

    public Restaurant(Chef chef) {
        this.chef = chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public void serve() {
        System.out.println("레스토랑에서 요리를 제공합니다.");
        chef.cook();
    }
}
