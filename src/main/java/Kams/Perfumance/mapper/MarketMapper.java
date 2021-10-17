package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.Criteria;
import Kams.Perfumance.vo.FileVO;
import Kams.Perfumance.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketMapper{

    int goodsRegister(GoodsVO goodsVO);

    int fileInfoInsert(FileVO fileVO);

    List<GoodsVO> getListWithPaging(Criteria cri);

}
