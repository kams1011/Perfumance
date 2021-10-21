package Kams.Perfumance.service;


import Kams.Perfumance.mapper.FileMapper;
import Kams.Perfumance.vo.FileVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    FileMapper fileMapper;

    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }


    @Override
    public List<FileVO> getGoodsFile(int gno){

        return fileMapper.selectFileByGno(gno);
    }


}
