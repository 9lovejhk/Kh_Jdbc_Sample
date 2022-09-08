package cafe.dao;

import cafe.util.Common;
import cafe.vo.*;

import java.sql.*;
import java.util.*;

public class MenuDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<MenuVO> menuSelect() {
        List<MenuVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            // DB에 SQL문을 전달하여 실행시키고 결과 값을 반환 받기 위해 사용
            stmt = conn.createStatement();
            String sql = "SELECT * FROM MENU";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int num = rs.getInt("메뉴번호");
                String menu = rs.getString("메뉴명");
                int menu_price = rs.getInt("메뉴금액");

                MenuVO vo = new MenuVO(num, menu, menu_price);

                list.add(vo); // 생성된 객체를 리스트에 저장
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void menuSelectRst (List<MenuVO> list) {
        System.out.println("========== [메뉴판] ==========");
        System.out.println("(메뉴번호)   (메뉴명)   (메뉴금액)");
        for(MenuVO e : list) {
            System.out.printf("%7d  ", e.getMenu_num());
            System.out.printf("%10s", e.getMenu());
            System.out.printf("%9d", e.getMenu_price());
            System.out.println();
        }
        System.out.println();
    }

    public void menuInsert() {
        System.out.println("▶▶ 추가할 메뉴에 대한 정보를 입력하세요");
        System.out.print("메뉴번호 : ");
        int no = sc.nextInt();
        System.out.print("메뉴명 : ");
        String name = sc.next();
        System.out.print("메뉴금액 : ");
        int price = sc.nextInt();

        String sql = "INSERT INTO MENU(메뉴번호, 메뉴명, 메뉴금액) "
                + "VALUES(?, ?, ?)";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            pstmt.setString(2, name);
            pstmt.setInt(3, price);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void menuDelete() {
        System.out.print("▶▶ 삭제를 메뉴를 선택하세요 : ");
        String name = sc.next();

        String sql = "DELETE FROM MENU WHERE 메뉴명 = ?";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            int ret = pstmt.executeUpdate();
            System.out.println("Return : " + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void menuUpdate() {
        System.out.println("▶▶ 금액을 변경할 메뉴를 선택하세요");
        System.out.print("메뉴번호 : ");
        int no = sc.nextInt();
        System.out.print("메뉴명 : ");
        String name = sc.next();
        System.out.print("메뉴금액 : ");
        int price = sc.nextInt();

        String sql = "UPDATE MENU SET 메뉴명 = ?, 메뉴금액 = ? WHERE 메뉴번호 = ?";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,price);
            pstmt.setInt(3,no);
            int ret = pstmt.executeUpdate();
            System.out.println("Return : " + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }


    public List<SizeVO> sizeSelect() {
        List<SizeVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            // DB에 SQL문을 전달하여 실행시키고 결과 값을 반환 받기 위해 사용
            stmt = conn.createStatement();
            String sql = "SELECT * FROM OPTION_SIZE";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String option_size = rs.getString("사이즈");
                int size_price = rs.getInt("사이즈금액");

                SizeVO vo = new SizeVO(option_size, size_price);

                list.add(vo); // 생성된 객체를 리스트에 저장
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void sizeSelectRst (List<SizeVO> list) {
        System.out.println("(사이즈) (사이즈금액)");
        for(SizeVO e : list) {
            System.out.printf("%4s\t\t", e.getMenuSize());
            System.out.print(e.getSizePrice() + " ");
            System.out.println();
        }
    }


    public List<AddOptionVO> addOptionSelect() {
        List<AddOptionVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            // DB에 SQL문을 전달하여 실행시키고 결과 값을 반환 받기 위해 사용
            stmt = conn.createStatement();
            String sql = "SELECT * FROM OPTION_ADD";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int no = rs.getInt("옵션번호");
                String add = rs.getString("옵션추가");
                int option_price = rs.getInt("옵션추가금액");

                AddOptionVO vo = new AddOptionVO(no, add, option_price);

                list.add(vo); // 생성된 객체를 리스트에 저장
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addOptionSelectRst (List<AddOptionVO> list) {
        System.out.println("(옵션번호) (옵션추가) (옵션추가금액)");
        for(AddOptionVO e : list) {
            System.out.printf("%7d  ", e.getOption_num());
            System.out.printf("%-10s", e.getOption());
            System.out.printf("%-5d", e.getOption_price());
            System.out.println();
        }
    }


    public void customerOrder() {
        MenuDAO dao = new MenuDAO();
        System.out.println("========== [주문하기] ==========");
        System.out.print("▶▶ 메뉴번호 : ");
        int menuNo = sc.nextInt();

        List<SizeVO> list_size = dao.sizeSelect();
        dao.sizeSelectRst(list_size);
        System.out.print("▶▶ 사이즈(S, M, L) : ");
        String menuSize = sc.next();

        List<AddOptionVO> list_option = dao.addOptionSelect();
        dao.addOptionSelectRst(list_option);
        System.out.print("▶▶ 옵션번호 : ");
        int optionNo = sc.nextInt();

        System.out.print("▶▶ 수량 : ");
        int quantity = sc.nextInt();

        String sql = "INSERT INTO CUSTOMER_ORDER(메뉴번호, 사이즈, 옵션번호, 수량) "
                + "VALUES(?, ?, ?, ?)";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, menuNo);
            pstmt.setString(2, menuSize);
            pstmt.setInt(3, optionNo);
            pstmt.setInt(4, quantity);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printBasket() {
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql_basket = "SELECT 메뉴명, CUSTOMER_ORDER.사이즈, 옵션추가, 수량, ((메뉴금액+사이즈금액+옵션추가금액)*수량) 합계 " +
                    "FROM CUSTOMER_ORDER, MENU, OPTION_ADD, OPTION_SIZE " +
                    "WHERE CUSTOMER_ORDER.메뉴번호 = MENU.메뉴번호 " +
                    "AND CUSTOMER_ORDER.옵션번호 = OPTION_ADD.옵션번호 " +
                    "AND CUSTOMER_ORDER.사이즈 = OPTION_SIZE.사이즈";
            rs = stmt.executeQuery(sql_basket);

            System.out.println();
            int total = 0;
            System.out.println("=============== [장바구니] ===============");
            System.out.println("  (메뉴명)  (사이즈) (선택한 옵션) (수량) (합계)");
            while (rs.next()) {
                System.out.printf("%10s ", rs.getString("메뉴명"));
                System.out.printf("%5s   ", rs.getString("사이즈"));
                System.out.printf("%-10s", rs.getString("옵션추가"));
                System.out.printf("%4d", rs.getInt("수량"));
                System.out.printf("%9d", rs.getInt("합계"));
                total += rs.getInt("합계");
                System.out.println();
            }
            System.out.println("결제할 금액은 " + total + "원 입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);
    }

    public void endOrder() {
        MenuDAO dao = new MenuDAO();

        String sql = "DELETE FROM CUSTOMER_ORDER";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}