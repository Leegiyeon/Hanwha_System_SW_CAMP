package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("====== Mapper Elements Test ======");
        System.out.println("1. <resultMap> Test");
        System.out.println("9. 프로그램 종료");
        System.out.print("번호를 입력해주세요: ");
        int no = sc.nextInt();

        switch (no){
            case 1:
                resultMapSubMenu();
                break;
            case 9:
                System.out.println("프로그램 종료");
                return;
            default:
                System.out.println("번호를 다시 입력해주세요.");
                break;
        }


    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();
        do {
            System.out.println("====== <resultMap> SubMenu ======");
            System.out.println("1. <resultMap> Test");
            System.out.println("2. <association> Test");            // Memo. Employee 기준 Department
            System.out.println("3. <collection> Test");             // Memo. Department 기준 Employee
            System.out.println("9. 이전 메뉴");
            System.out.print("번호를 입력해주세요: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    elementService.selectResultMapTest();
                    break;
                case 2:
                    elementService.selectAssociationTest();
                    break;
                case 3:
                    elementService.selectCollectionTest();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("번호를 다시 입력해주세요.");
                    break;
            }
        } while (true);
    }
}
