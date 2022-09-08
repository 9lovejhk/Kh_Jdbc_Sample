package cafe.dao;
import cafe.util.Common;
import cafe.vo.MenuVO;

import java.sql.*;

import java.util.*;
//룰룰랄라 신나는 시간 \(@^0^@)/(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ヽ(✿ﾟ▽ﾟ)ノ

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
        System.out.print("메뉴명 : ");
        String name = sc.next();
        System.out.print("메뉴금액 : ");
        int price = sc.nextInt();

        String sql = "UPDATE MENU SET 메뉴명 = ?, 메뉴금액 = ? WHERE 메뉴명 = ?";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,price);
            pstmt.setString(3,name);
            int ret = pstmt.executeUpdate();
            System.out.println("Return : " + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void menuSelectRst (List<MenuVO> list) {
        for(MenuVO e : list) {
            System.out.print(e.getMenu_num() + " ");
            System.out.print(e.getMenu() + " ");
            System.out.print(e.getMenu_price() + " ");
            System.out.println();
        }
    }

    public void customerOrder() {
        System.out.println("▶▶ 메뉴 주문 ㄱㄱ");
        System.out.print("메뉴번호 : ");
        int no = sc.nextInt();
        System.out.print("사이즈 : ");
        String name = sc.next();
        System.out.print("옵션 : ");
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
}
