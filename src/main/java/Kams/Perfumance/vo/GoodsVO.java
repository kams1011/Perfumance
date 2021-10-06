package Kams.Perfumance.vo;


import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class GoodsVO {

    int gno;                //글 번호
    String id;              //판매자 id
    String manufacturer;    // 제조사
    String goodsName;       //판매물품이름
    String expiryDt;        //유통기한
    int price;              //판매가격
    boolean contact;        //대면여부
    String address;         //판매장소
    int usableCapacity;     //잔여용량
    String title;           //글 제목
    String explanation;     //판매물품 설명
    String status;          //판매상태 -> 1,2,3등으로 구분해서 하자
    Date writeDt;           //작성일
    Date modifyDt;          //수정일


    @Builder
    public GoodsVO(int gno, String id, String goodsName, String manufacturer,  String expiryDt, int price, boolean contact, String address,
                   int usableCapacity, String title, String explanation, String status, Date writeDt, Date modifyDt){
        this.gno = gno;
        this.id = id;
        this.goodsName = goodsName;
        this.manufacturer = manufacturer;
        this.expiryDt = expiryDt;
        this.price = price;
        this.contact = contact;
        this.address = address;
        this.usableCapacity = usableCapacity;
        this.title = title;
        this.explanation = explanation;
        this.status = status;
        this.writeDt = writeDt;
        this.modifyDt = modifyDt;
    }

}
