package cafe;

import cafe.dao.MenuDAO;
import cafe.vo.MenuVO;

import java.util.*;

public class CafeMain {
    public static void main(String[] args) {
//        masterSelect();
        customerSelect();
    }
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
        System.out.println("========== [메뉴판] ==========");
        System.out.println("(메뉴번호)   (메뉴명)   (메뉴금액)");
        List<MenuVO> list = dao.menuSelect();
        dao.menuSelectRst(list);
        System.out.println("=============================");
        System.out.println();
        System.out.print("[1]주문하기, [2]나가기 : ");
        while(true) {
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    System.out.println();
                    dao.customerOrder();
                    break;
                case 2:
                    System.out.println("다음에 또 오세요^^");
                    return;
            } // switch(sel)

            while (true) {
                System.out.print("[1]주문 추가하기 [2]장바구니 가기 [3]주문 종료 : ");
                int add_sel = sc.nextInt();
                switch(add_sel) {
                    case 1:
                        dao.customerOrder();
                        break;
                    case 2:
                        dao.printBasket();
                        break;
                    case 3:
                        System.out.println("주문을 종료 합니다");
                        return;
                } // switch(add_sel)
            }
        }
    } // customerSelect()
} // CafeMain의 끝