package Kams.Perfumance.mapper;


import Kams.Perfumance.vo.Criteria;
import Kams.Perfumance.vo.PerfumeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    public List<PerfumeVO> selectPerfumeList(Criteria cri);

    public int selectPerfumeTotalCount(); //향수 전체 갯수 가져오기

    public PerfumeVO perfumeInfo(String perfumeName);

    public List<PerfumeVO> selectPerfumeBySearch(HashMap<String, Object> perfumeInfo);

    public int countResult(String perfumeName);

    public int insertPerfumeData(Map<String, String> perfumeData);

}
