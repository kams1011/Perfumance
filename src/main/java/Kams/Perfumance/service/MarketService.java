package Kams.Perfumance.service;


import Kams.Perfumance.vo.FileVO;
import Kams.Perfumance.vo.GoodsVO;
import org.springframework.stereotype.Service;

@Service
public interface MarketService {


    public int goodsPosting(GoodsVO goodsVO);

    public void fileSave(FileVO fileVO);

}
