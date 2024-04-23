package com.ohgiraffers.section01.xml;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
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

            switch (no) {
                case 1:
                    ifSubMenu();
                    break;
                case 2:
                    chooseSubMenu();
                    break;
                case 3:
                    foreachSubMenu();
                    break;
                case 4:
                    trimSubMenu();
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
                    menuService.searchMenu(inputSearchCriteria());
                    break;
                case 9:
                    return;
                default:
                    return;

            }
        } while (true);
    }


    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 메뉴의 최대 금액을 입력: ");

//        int price = sc.nextInt();
//        return price;
        return sc.nextInt();
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준을 입력해주세요(name || category): ");
        String condition = sc.nextLine();
        System.out.print("검색어를 입력해주세요: ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("===== choose SubMenu =====");
            System.out.println("1. 카테고리 상위 분류별 메뉴(식사, 음료, 디저트)");
            System.out.println("9. 이전 창으로...");
            System.out.print("메뉴 선택: ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.searchMenuBySupCategory(inputSupCategory());
                    break;
                case 9:
                    return;
                default:
                    return;

            }
        } while (true);
    }

    private static SearchCriteria inputSupCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류별 메뉴(식사, 음료, 디저트): ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static void foreachSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("===== Foreach Submenu =====");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 입력: ");

            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.searchMenuByRandomMenuCode(generateRandomMenuCodeList());
                    break;
                case 9:
                    return;
                default:
                    return;

            }
        } while (true);
    }

    /* 설명. 1부터 21까지 5개의 중복되지 않는 번호를 생성하여 list로 반환하는 메소드*/

    private static List<Integer> generateRandomMenuCodeList() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 5) {
            int temp = (int) (Math.random() * 21) + 1;
            set.add(temp);
        }

        /* 설명. set을 List 형태로 바꿔서 오름차순 정렬*/
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

    private static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("===== Trim Submenu =====");
            System.out.println("1. 검색조건이 있는 경우 메뉴 코드로 조회(없으면 전체 조회)");
            System.out.println("2. 메뉴 혹은 카테고리로 조회(메뉴와 카테고리 둘다 일치하는 경우 검색 그리고 검색 조건이 없는 경우 전체 검색)");
            System.out.println("3. 원하는 메뉴 정보만 수정");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 입력: ");

            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuService.searchMenuByCodeOrSearchAll(inputAllOrOne());
                    break;
                case 2:
                    menuService.serchMenuByNameOrCategory(inputSearchCriteriaMap());
                    break;
                case 3:
                    menuService.modifyMenu(inputChangeInfo());
                    break;
                case 9:
                    return;
                default:
                    return;

            }
        } while (true);

    }

    private static SearchCriteria inputAllOrOne() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색조건을 입력하시겠습니까?(Y or N): ");
        boolean hasSearchValue = "y".equals(sc.nextLine()) ? true : false;


        SearchCriteria searchCriteria = new SearchCriteria();
        if (hasSearchValue) {
            System.out.print(("검색할 메뉴 코드를 입력하세요: "));
            String menuCode = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(menuCode);
        }

        return searchCriteria;
    }

    /* 설명. SearchCriteria 개념을 이번에는 DTO가 아닌 Map으로 작성*/

    private static Map<String, Object> inputSearchCriteriaMap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색조건을 입력하세요(categor or name or none): ");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        if ("category".equals(condition)) {
            System.out.print(("검색할 메뉴 카테고리를 입력하세요: "));
            int categoryValue = sc.nextInt();
            criteria.put("categoryValue", categoryValue);
        } else if ("name".equals(condition)) {
            System.out.print(("검색할 메뉴 이름을 입력하세요: "));
            String nameValue = sc.nextLine();
            criteria.put("nameValue", nameValue);
        } else if ("both".equals(condition)) {
            System.out.print(("검색할 메뉴 이름을 입력하세요: "));
            String nameValue = sc.nextLine();
            System.out.print(("검색할 메뉴 코드를 입력하세요: "));
            int categoryValue = sc.nextInt();
            criteria.put("nameValue", nameValue);
            criteria.put("categoryValue", categoryValue);
        }


        return criteria;
    }

    private static Map<String, Object> inputChangeInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴 코드를 입력하세요: ");
        int menuCode = sc.nextInt();
        System.out.print("변경할 메뉴 이름을 입력하세요: ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.print("변경할 판매 여부를 결정해 주세요(Y/N): ");
        String orderableStatus = sc.nextLine().toUpperCase();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("menuCode", menuCode);
        criteria.put("menuName", menuName);
        criteria.put("orderableStatus", orderableStatus);

        return criteria;
    }
}
