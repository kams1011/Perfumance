package Kams.Perfumance.service;


import Kams.Perfumance.mapper.BoardMapper;
import Kams.Perfumance.mapper.MarketMapper;
import Kams.Perfumance.vo.Criteria;
import Kams.Perfumance.vo.PerfumeVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
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

        int boardTotalCount = boardMapper.selectPerfumeTotalCount();

        if (boardTotalCount > 0) {
            boardList = boardMapper.selectPerfumeList(cri);
        }

        return boardList;
    }


    @Override
    public PerfumeVO getPerfumeInfo(String perfumeName) {

        return boardMapper.perfumeInfo(perfumeName);
    }


    @Override
    public int  getBoardTotalCount(){

        return boardMapper.selectPerfumeTotalCount();

    }

    @Override
    public List<PerfumeVO> perfumeSearch(HashMap<String, Object> perfumeInfo){

        return boardMapper.selectPerfumeBySearch(perfumeInfo);
    }

    @Override
    public int getCount(String perfumeName){

        return boardMapper.countResult(perfumeName);
    }

    @Override
    public void insertData(){

        String url = "https://www.fragrantica.com/notes/"; //크롤링할 url지정
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
        Map<String, String> perfumeData = new HashMap<>();

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements categories= doc.select(".text-center > h2"); // 이게 카테고리
        Elements notes;


        for(int i=0; i< categories.size(); i++) {
            if(i<9){
                notes = doc.select("#groupnotes_group_0"+(i+1)+"_title").next().next().select("a");
            }else{
                notes = doc.select("#groupnotes_group_"+(i+1)+"_title").next().next().select("a");
            }
            perfumeData.put("category", categories.get(i).text());

            for(int j=0; j<notes.size(); j++){
                perfumeData.put("notes", notes.get(j).text());
                boardMapper.insertPerfumeData(perfumeData);
            }
        }
    }
}
