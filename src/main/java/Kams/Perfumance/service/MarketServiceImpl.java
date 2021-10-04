package Kams.Perfumance.service;


import Kams.Perfumance.mapper.MarketMapper;
import Kams.Perfumance.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    MarketMapper marketMapper;

    @Override
    public void goodsPosting() {
//        marketMapper.goodsUpload();
    };

}
