package Kams.Perfumance.service;


import Kams.Perfumance.mapper.BoardMapper;
import Kams.Perfumance.mapper.MarketMapper;
import Kams.Perfumance.vo.Criteria;
import Kams.Perfumance.vo.PerfumeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<PerfumeVO> getBoardList(Criteria cri) {
        List<PerfumeVO> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount(cri);

        if (boardTotalCount > 0) {
            boardList = boardMapper.selectBoardList(cri);
        }

        return boardList;
    }


    @Override
    public PerfumeVO getPerfumeInfo(String perfumeName) {

        return boardMapper.perfumeInfo(perfumeName);
    }
}
