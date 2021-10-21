package Kams.Perfumance.service;


import Kams.Perfumance.vo.FileVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {


    public List<FileVO> getGoodsFile(int gno);
}
