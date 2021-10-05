package Kams.Perfumance.vo;


import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Getter
public class FileVO {

    int fno;            //파일 번호(인조키)
    Integer gno;            // 거래제품 번호
    Integer bno;            // 게시글 번호
    String name;        //파일 이름
    String path;        //파일 경로
    long size;        //파일 사이즈
    String extension;   //파일 확장자
    Date regDt;       //파일 등록일자
    Date modifyDt;    //파일 수정일자
    Date delDt;       //파일 삭제일자


    @Builder
    public FileVO(int fno, Integer gno, Integer bno, String name, String path, long size, String extension, Date regDt, Date modifyDt, Date delDt){
        this.fno=fno;
        this.gno=gno;
        this.bno=bno;
        this.name=name;
        this.path=path;
        this.size=size;
        this.extension=extension;
        this.regDt=regDt;
        this.modifyDt=modifyDt;
        this.delDt=delDt;
    }

}
