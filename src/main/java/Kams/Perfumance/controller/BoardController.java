package Kams.Perfumance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {



    @GetMapping("market")
    public String market(){ return "board/market"; }

    @GetMapping("details")
    public String details(){
        return "board/details";
    }

    @GetMapping("result")
    public String result(){
        return "board/result";
    }

    @GetMapping("goodsdetail")
    public String goodsDetail(){ return "board/goodsdetail"; }

    @GetMapping("post")
    public String post(){ return "board/post"; }
}
