package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.Criteria;
import Kams.Perfumance.vo.PerfumeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {


    public List<PerfumeVO> selectBoardList(Criteria cri);

    public int selectBoardTotalCount(Criteria criteria);

    public PerfumeVO perfumeInfo(String perfumeName);


}
