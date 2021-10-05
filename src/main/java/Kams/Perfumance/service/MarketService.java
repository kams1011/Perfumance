package Kams.Perfumance.service;


import Kams.Perfumance.vo.GoodsVO;
import org.springframework.stereotype.Service;

@Service
public interface MarketService {


    public void goodsPosting(GoodsVO goodsVO);

}
