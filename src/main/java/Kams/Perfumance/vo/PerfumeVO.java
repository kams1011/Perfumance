package Kams.Perfumance.vo;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class PerfumeVO {

    String name;
    String manufacturer;
    String top;
    String middle;
    String base;
    String price;
    int size;
    String picture;


    @Builder
    public PerfumeVO(String name, String manufacturer, String top, String middle, String base, String price, int size, String picture){
        this.name = name;
        this.manufacturer = manufacturer;
        this.top = top;
        this.middle = middle;
        this.base = base;
        this.price = price;
        this.size = size;
        this.picture = picture;
    }
}
