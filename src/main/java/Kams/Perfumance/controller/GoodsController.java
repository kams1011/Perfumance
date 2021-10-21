package Kams.Perfumance.controller;


import Kams.Perfumance.mapper.MarketMapper;
import Kams.Perfumance.service.FileService;
import Kams.Perfumance.service.MarketService;
import Kams.Perfumance.vo.FileVO;
import Kams.Perfumance.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MarketService marketService;

    @Autowired
    FileService fileService;

    @GetMapping("goodslist")
    public String goodsList(){

        return "goods/goodslist";
    }

    @GetMapping("goodsdetail")
    public String goodsDetail(int gno, Model model){
        GoodsVO goodsVO = marketService.getGoodsInfo(gno);
        List<FileVO> fileVO =  fileService.getGoodsFile(gno);
        model.addAttribute("goods", goodsVO);
        model.addAttribute("file", fileVO);
        System.out.println(fileVO.size());


        return "goods/goodsdetail";

    }




}
