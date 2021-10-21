package Kams.Perfumance.mapper;

import Kams.Perfumance.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {


    public List<FileVO> selectFileByGno(int gno);

}
