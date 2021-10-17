package Kams.Perfumance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("goodslist")
    public String goodsList(){

        return "goods/goodslist";
    }

    @GetMapping("goodsdetail")
    public String goodsDetail(){ return "goods/goodsdetail"; }


}
