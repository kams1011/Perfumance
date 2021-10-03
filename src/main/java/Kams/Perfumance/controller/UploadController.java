package Kams.Perfumance.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("uploadFormAction")
    public String uploadForm(@RequestPart("uploadFile") MultipartFile[] uploadFile, MultipartHttpServletRequest request){
        System.out.println("uploadFile은 : " + uploadFile);
        System.out.println("request는 : " + request);
        String uploadFolder = "c:\\upload";
        File uploadPath = new File(uploadFolder, getFolder()); //uploadFolder에 getFolder의 리턴값을 객체로 생성한다.

        if(!uploadPath.exists()) {
            uploadPath.mkdirs();
        } //존재하지 않은 부모 폴더까지 포함하여 해당 경로에 폴더를 만든다.

        for (MultipartFile multipartFile : uploadFile){
            String uploadFileName = multipartFile.getOriginalFilename();
            System.out.println(uploadFileName);
            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);

            File saveFile = new File(uploadPath, uploadFileName); //uploadPath에 uploadFileName 객체를 생성한다.
            try{
                multipartFile.transferTo(saveFile);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return "/board/post";


    }


    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //특정 날짜 형식으로 출력하게 해주는 클래스

        Date date = new Date();

        String str = sdf.format(date);

        return str.replace("-", File.separator); //파일 경로를 환경별로 다르게 적용시켜줌
    }



}
