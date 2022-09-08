package cafe.vo;

public class MenuVO {
    private int menu_num;
    private String menu;
    private int menu_price;

    public MenuVO(int menu_num, String menu, int menu_price) {
        this.menu_num = menu_num;
        this.menu = menu;
        this.menu_price = menu_price;
    }

    public int getMenu_num() {
        return menu_num;
    }

    public void setMenu_num(int menu_num) {
        this.menu_num = menu_num;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(int menu_price) {
        this.menu_price = menu_price;
    }
}
