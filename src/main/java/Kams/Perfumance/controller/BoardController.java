package Kams.Perfumance.controller;


import Kams.Perfumance.service.MarketService;
import Kams.Perfumance.vo.FileVO;
import Kams.Perfumance.vo.GoodsVO;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    MarketService marketService;

    @GetMapping("market")
    public String market(){ return "board/market"; }

    @GetMapping("details")
    public String details(){
        return "board/details";
    }

    @GetMapping("result")
    public String result(){
        return "board/result";
    }

    @GetMapping("goodsdetail")
    public String goodsDetail(){ return "board/goodsdetail"; }

    @GetMapping("post")
    public String post(){ return "board/post"; }

    @PostMapping("posting")
    public String uploadForm(@RequestPart("uploadFile") MultipartFile[] uploadFile, Principal principal, String goodsName, String manufacturer,
                             String expiryDt, String price, String contact, String address, String usableCapacity, String title, String explanation){

        Date date = new Date();
        boolean isContact; //대면 여부 체크 변수
        int intPrice = Integer.parseInt(price);
        int intCapacity = Integer.parseInt(usableCapacity);


        if(!contact.equals("대면")){
            isContact=false;  //비대면이다.
            address=null;
        }else{
            isContact=true;  //대면이다.
        }


     try {
         GoodsVO goodsVO = GoodsVO.builder()
                 .id(principal.getName())
                 .title(title)
                 .goodsName(goodsName)
                 .manufacturer(manufacturer)
                 .expiryDt(expiryDt)
                 .price(intPrice)
                 .contact(isContact)
                 .address(address)
                 .usableCapacity(intCapacity)
                 .explanation(explanation)
                 .status("판매중")
                 .writeDt(date)
                 .modifyDt(null)
                 .build();

         marketService.goodsPosting(goodsVO); // DB에 파일 유무와 관계 없이 goods 정보를 INSERT한다.

         if (!uploadFile[0].isEmpty()) { //만약 파일이 업로드 됐다면
             fileUpload(uploadFile);     //파일을 저장하고
             for (int i = 0; i < uploadFile.length; i++) { //파일 갯수만큼 DB에 insert한다.
                 FileVO fileVO = FileVO.builder()
                         .gno(goodsVO.getGno())
                         .bno(null)
                         .name(uploadFile[i].getOriginalFilename())
                         .path("c:\\upload\\" + getFolder())
                         .size(uploadFile[i].getSize() / 1024)
                         .extension(uploadFile[i].getContentType())
                         .regDt(goodsVO.getWriteDt())
                         .modifyDt(null)
                         .delDt(null)
                         .build();
                 marketService.fileSave(fileVO);
             }
         }
     }catch(Exception e){
         e.printStackTrace();
     }
        return "/board/post";
    }

    //폴더 생성 메서드
    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //특정 날짜 형식으로 출력하게 해주는 클래스

        Date date = new Date();

        String str = sdf.format(date);

        return str.replace("-", File.separator); //파일 경로를 환경별로 다르게 적용시켜줌
    }



    //파일업로드 메서드
    private void fileUpload(MultipartFile[] uploadFile){
        try {
            //이하 사진업로드
            String uploadFolder = "c:\\upload";
            File uploadPath = new File(uploadFolder, getFolder()); //uploadFolder에 getFolder의 리턴값을 객체로 생성한다.
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            } //존재하지 않은 부모 폴더까지 포함하여 해당 경로에 폴더를 만든다.

            for (MultipartFile multipartFile : uploadFile) {
                String uploadFileName = multipartFile.getOriginalFilename();
                uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
                UUID uuid = UUID.randomUUID();
                uploadFileName = uuid.toString() + "_" + uploadFileName;

                try {
                    File saveFile = new File(uploadPath, uploadFileName); //uploadPath에 uploadFileName 객체를 생성한다.
                    multipartFile.transferTo(saveFile);
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                    //파일을 출력해준다.
                    Thumbnailator.createThumbnail(new FileInputStream(saveFile.getAbsolutePath()), thumbnail, 100, 100);

                    thumbnail.close();
                    //Image IO로도 만들어보기.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }








}
