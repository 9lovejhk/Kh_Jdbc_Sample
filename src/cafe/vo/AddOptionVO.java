package cafe.vo;

public class AddOptionVO {
    private int option_num;
    private String option;
    private int option_price;

    public AddOptionVO(int option_num, String option, int option_price) {
        this.option_num = option_num;
        this.option = option;
        this.option_price = option_price;
    }

    public int getOption_num() {
        return option_num;
    }

    public void setOption_num(int option_num) {
        this.option_num = option_num;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getOption_price() {
        return option_price;
    }

    public void setOption_price(int option_price) {
        this.option_price = option_price;
    }
}
