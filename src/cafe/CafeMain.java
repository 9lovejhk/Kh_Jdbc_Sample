package cafe;

import cafe.dao.MenuDAO;
import cafe.vo.MenuVO;

import java.util.*;

public class CafeMain {
    public static void main(String[] args) {
        masterSelect();
//        customerSelect();
    }

    public static void masterSelect() {
        Scanner sc = new Scanner(System.in);
        MenuDAO dao = new MenuDAO();
        while(true) {
            System.out.println("========== [관리자 계정] ==========");
            System.out.print("[1]메뉴판 보기\n[2]메뉴 추가하기\n[3]메뉴 삭제하기\n[4]메뉴 정보 수정하기\n[5]일별 주문내역 조회\n[6]총 주문내역 조회\n[7]일별 메뉴당 매출 조회\n[8]작업 종료\n");
            System.out.print("▶▶ 선택 : ");
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
                    dao.dailySales();
                    break;
                case 6 :
                    dao.totalSales();
                    break;
                case 7 :
                    dao.dailyMenuSales();
                    break;
                case 8 :
                    System.out.println("관리자 계정 로그아웃");
                    return;
            }
        }
    }

    public static void customerSelect() {
        Scanner sc = new Scanner(System.in);
        MenuDAO dao = new MenuDAO();
        List<MenuVO> list = dao.menuSelect();
        dao.menuSelectRst(list);
        System.out.println();
        System.out.print("[1]주문하기\n[2]장바구니 보기\n[3]결제하기\n");
        System.out.print("▶▶ 선택 : ");
        while(true) {
            int sel = sc.nextInt();
            switch(sel) {
                case 1:
                    System.out.println();
                    dao.customerOrder();
                    break;
                case 2:
                    dao.printBasket();
                    break;
                case 3:
                    System.out.println("다음에 또 오세요^^");
                    return;
            } // switch(sel)

            while (true) {
                System.out.println();
                System.out.print("[1]주문 추가하기 [2]장바구니 가기 [3]결제하기 : ");
                int add_sel = sc.nextInt();
                switch(add_sel) {
                    case 1:
                        dao.customerOrder();
                        break;
                    case 2:
                        dao.printBasket();
                        break;
                    case 3:
                        System.out.println("결제가 완료되었습니다.");
                        dao.endOrder();
                        return;
                } // switch(add_sel)
            }
        }
    } // customerSelect()
} // CafeMain의 끝