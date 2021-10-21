package Kams.Perfumance.service;


import Kams.Perfumance.mapper.MarketMapper;
import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.FileVO;
import Kams.Perfumance.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {

    MarketMapper marketMapper;

    public MarketServiceImpl(MarketMapper marketMapper) {
        this.marketMapper = marketMapper;
    }

    @Override
    public int goodsPosting(GoodsVO goodsVO) {
        return marketMapper.goodsRegister(goodsVO);
    }


    @Override
    public void fileSave(FileVO fileVO) {
        marketMapper.fileInfoInsert(fileVO);
    }


    @Override
    public List<GoodsVO> getGoodsList(String perfumeName){

        return marketMapper.getGoodsListByPerfumeName(perfumeName);
    }

    @Override
    public GoodsVO getGoodsInfo(int gno){
        return marketMapper.getGoodsInfoByGno(gno);
    }
}
