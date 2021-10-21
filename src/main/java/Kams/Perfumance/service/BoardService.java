package Kams.Perfumance.service;


import Kams.Perfumance.vo.Criteria;
import Kams.Perfumance.vo.PerfumeVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface BoardService {

   public List<PerfumeVO> getBoardList(Criteria cri);

   public PerfumeVO getPerfumeInfo(String perfumeName);

   public int getBoardTotalCount();

   public List<PerfumeVO> perfumeSearch(HashMap<String, Object> perfumeInfo);

   public int getCount(String perfumeName);
}
