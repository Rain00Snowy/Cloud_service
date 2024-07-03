package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import ynu.edu.dto.PicDto;
import ynu.edu.service.AliyunOssPicStorageService;
import ynu.edu.service.UserService;
import ynu.edu.dto.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/oss/pictures")
@CrossOrigin()
@RefreshScope

public class AliyunOssPicStorageController {

    private final AliyunOssPicStorageService aliyunOssService;

    public AliyunOssPicStorageController(AliyunOssPicStorageService aliyunOssService) {
        this.aliyunOssService = aliyunOssService;
    }

    @PostMapping("/uploadPic")
    @ResponseBody
    public CommonResult handleUploadImage(@RequestParam("image") MultipartFile image,
                                          @RequestParam("userId")String userId) {
        System.out.println("uploadPic");
        return aliyunOssService.handleUploadImage(image,userId);
//        return CommonResult.builder().code(0).data("a").msg("上传成功").build();
    }

    @PostMapping("/deletePic")
    @ResponseBody
    public void deletePicByKey(@RequestParam("picKey") String picKey) {
        System.out.println("deletePic");
        aliyunOssService.deletePicByKey(picKey);
    }

    @GetMapping("/getPicById")
    @ResponseBody
    public CommonResult getPicByUserId(String userId) {
        System.out.println("getPicById");
        return aliyunOssService.getPicByUserId(userId);
    }
    @PostMapping("/upgradePic")
    @ResponseBody
    public CommonResult updateImage(@RequestParam("image")MultipartFile image ,String userId,String picKey){
        System.out.println("upgradePic");
//        上传新图片，删除原图片
        aliyunOssService.deletePicByKey(picKey);
        return  aliyunOssService.handleUploadImage(image,userId);

    }

}
