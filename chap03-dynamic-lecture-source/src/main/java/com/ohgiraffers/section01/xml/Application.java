package com.ohgiraffers.section01.xml;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("====== Mybatis Run ======");
            System.out.println("1. if 확인");
            System.out.println("2. choose 확인");
            System.out.println("3. foreach 확인");
            System.out.println("4. trim 확인");
            System.out.println("9. 종료");
            System.out.print("메뉴 선택: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    ifSubMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("번호를 다시 입력해주세요.");
            }
        } while (true);

    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("===== if SubMenu =====");
            System.out.println("1. 원하는 금액대 적합한 추천 메뉴 리스트");
            System.out.println("2. 메뉴 이름 또는 카테고리명으로 검색하여 메뉴리스트 조회");
            System.out.println("9. 이전 창으로...");
            System.out.print("메뉴 선택: ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.findMenuByPrice(inputPrice());
                    break;
                case 2:
                    break;
                case 9:
                    return;
                default:
                    return;

            }
        }while (true);
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 메뉴의 최대 금액을 입력: ");

//        int price = sc.nextInt();
//        return price;
        return sc.nextInt();
    }
}
