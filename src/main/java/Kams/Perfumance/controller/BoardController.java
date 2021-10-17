package Kams.Perfumance.controller;


import Kams.Perfumance.service.BoardService;
import Kams.Perfumance.service.MarketService;
import Kams.Perfumance.vo.Criteria;
import Kams.Perfumance.vo.FileVO;
import Kams.Perfumance.vo.GoodsVO;
import Kams.Perfumance.vo.PerfumeVO;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    MarketService marketService;

    @Autowired
    BoardService boardService;

    @GetMapping("market")
    public String market(){ return "board/market"; }

    @GetMapping("info")
    public String info(){
        return "board/info";
    }

    @GetMapping("post")
    public String post(){ return "board/post"; }

    @GetMapping("perfumelist")
    public String list(@ModelAttribute("criteria") Criteria cri, Model model) throws Exception{

        List<PerfumeVO> boardList = boardService.getBoardList(cri);

        model.addAttribute("boardList", boardList);

        return "board/perfumelist";
    }

    @GetMapping("detail")
    public String detail(@RequestParam("perfumeName") String perfumeName, Model model){

        PerfumeVO pvo = boardService.getPerfumeInfo(perfumeName);
        model.addAttribute(pvo.getPicture());
        model.addAttribute(pvo.getPicture());
        model.addAttribute(pvo.getPicture());
        model.addAttribute(pvo.getPicture());
        model.addAttribute(pvo.getPicture());
        model.addAttribute(pvo.getPicture());

        return "board/info";
    }

    @PostMapping("posting")
    public String uploadForm(@RequestPart("uploadFile") MultipartFile[] uploadFile, Principal principal, String goodsName, String[] manufacturer,
                             String expiryDt, String price, String contact, String address, String usableCapacity, String title, String explanation){
        Date date = new Date();
        boolean isContact; //대면 여부 체크 변수
        int intPrice = Integer.parseInt(price);
        int intCapacity = Integer.parseInt(usableCapacity);
        String validManufact;  //배열로 오는 제조사 유효성검사 변수
        
        if(manufacturer[0].equals("기타")){
            validManufact=manufacturer[1];
        }else{
            validManufact=manufacturer[0];
        }


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
                 .manufacturer(validManufact)
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


    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName){
        File file = new File("c:\\upload\\"+fileName);
        ResponseEntity<byte[]> result = null;

        try{
            HttpHeaders header = new HttpHeaders();

            header.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
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
