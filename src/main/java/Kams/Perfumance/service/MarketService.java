package Kams.Perfumance.service;


import Kams.Perfumance.vo.FileVO;
import Kams.Perfumance.vo.GoodsVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarketService {


    public int goodsPosting(GoodsVO goodsVO);

    public void fileSave(FileVO fileVO);

    public List<GoodsVO> getGoodsList(String perfumeName);

    public GoodsVO getGoodsInfo(int gno);

}
