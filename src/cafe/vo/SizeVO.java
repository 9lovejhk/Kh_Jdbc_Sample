package cafe.vo;

public class SizeVO {
    private String menuSize;
    private int sizePrice;

    public SizeVO(String menuSize, int sizePrice) {
        this.menuSize = menuSize;
        this.sizePrice = sizePrice;
    }

    public String getMenuSize() {
        return menuSize;
    }

    public void setMenuSize(String menuSize) {
        this.menuSize = menuSize;
    }

    public int getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(int sizePrice) {
        this.sizePrice = sizePrice;
    }
}
