package house_sale.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;

public class House_sale {
    private int house_ID;
    @NotNull
    private int house_size;
    @NotNull
    private String house_type;
    @NotNull
    private int house_floor_num;
    @NotNull
    private String house_place;
    @NotNull
    private Date house_build_year;
    @NotNull
    private int house_state;
    @NotNull
    private String house_standard;
    @NotNull
    private long house_price;
    @NotNull
    private String house_owner;


    public House_sale() {
        super();
    }

    public House_sale(int house_ID, int house_size, String house_type, int house_floor_num, String house_place,
                      Date house_build_year, int house_state, String house_standard, long house_price, String house_owner) {
        super();
        this.house_ID = house_ID;
        this.house_size = house_size;
        this.house_type = house_type;
        this.house_floor_num = house_floor_num;
        this.house_place = house_place;
        this.house_build_year = house_build_year;
        this.house_state = house_state;
        this.house_standard = house_standard;
        this.house_price = house_price;
        this.house_owner = house_owner;
    }

    public String getHouse_owner() {
        return house_owner;
    }

    public void setHouse_owner(String house_owner) {
        this.house_owner = house_owner;
    }

    public int getHouse_size() {
        return house_size;
    }

    public void setHouse_size(int house_size) {
        this.house_size = house_size;
    }

    public int getHouse_ID() {
        return house_ID;
    }

    public void setHouse_ID(int house_ID) {
        this.house_ID = house_ID;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public int getHouse_floor_num() {
        return house_floor_num;
    }

    public void setHouse_floor_num(int house_floor_num) {
        this.house_floor_num = house_floor_num;
    }

    public String getHouse_place() {
        return house_place;
    }

    public void setHouse_place(String house_place) {
        this.house_place = house_place;
    }

    public Date getHouse_build_year() {
        return house_build_year;
    }

    public void setHouse_build_year(Date house_build_year) {
        this.house_build_year = house_build_year;
    }

    public int getHouse_state() {
        return house_state;
    }

    public void setHouse_state(int house_state) {
        this.house_state = house_state;
    }

    public String getHouse_standard() {
        return house_standard;
    }

    public void setHouse_standard(String house_standard) {
        this.house_standard = house_standard;
    }

    public long getHouse_price() {
        return house_price;
    }

    public void setHouse_price(long house_price) {
        this.house_price = house_price;
    }

}
