package cafe;

import cafe.dao.MenuDAO;
import cafe.vo.MenuVO;

import java.util.*;

public class CafeMain {
    public static void main(String[] args) {
//        masterSelect();
        customerSelect();
    }

    // 보이시나요,,,,



    public static void masterSelect() {
        Scanner sc = new Scanner(System.in);
        MenuDAO dao = new MenuDAO();
        while(true) {
            System.out.println("========== [MENU TABLE] ==========");
            System.out.println("▶▶ 실행할 작업을 선택하세요");
            System.out.println("[1]메뉴판 보기, [2]메뉴 추가하기, [3]메뉴 삭제하기, [4]메뉴 정보 수정하기, [5]작업 종료 : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    List<MenuVO> list = dao.menuSelect();
                    dao.menuSelectRst(list);
                    break;
                case 2 :
                    dao.menuInsert();
                    break;
                case 3 :
                    dao.menuDelete();
                    break;
                case 4 :
                    dao.menuUpdate();
                    break;
                case 5 :
                    System.out.println("작업을 종료 합니다.");
                    return;
            }
        }
    }

    public static void customerSelect() {
        Scanner sc = new Scanner(System.in);
        MenuDAO dao = new MenuDAO();
        while(true) {
            System.out.println("========== [주문창] ==========");
            System.out.println("▼ 실행할 작업을 선택하세요 ▼");
            List<MenuVO> list = dao.menuSelect();
            dao.menuSelectRst(list);
            System.out.println("[1]아메리카노, [2]라떼 : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1:

                    break;
                case 2 :
                    dao.menuInsert();
                    break;
                case 3 :
                    dao.menuDelete();
                    break;
                case 4 :
                    dao.menuUpdate();
                    break;
                case 5 :
                    System.out.println("메뉴를 종료 합니다");
                    return;
            }
        }
    }
} // CafeMain의 끝