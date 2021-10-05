package Kams.Perfumance.service;


import Kams.Perfumance.mapper.MarketMapper;
import Kams.Perfumance.mapper.MemberMapper;
import Kams.Perfumance.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService {

    MarketMapper marketMapper;

    public MarketServiceImpl(MarketMapper marketMapper) {
        this.marketMapper = marketMapper;
    }

    @Override
    public void goodsPosting(GoodsVO goodsVO) {
        marketMapper.postRegister(goodsVO);
    };

}
