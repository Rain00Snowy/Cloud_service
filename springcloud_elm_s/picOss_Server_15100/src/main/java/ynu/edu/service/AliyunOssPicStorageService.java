package ynu.edu.service;

import com.aliyun.oss.model.OSSObjectSummary;
import jakarta.annotation.Resource;
import ynu.edu.dto.CommonResult;
import ynu.edu.config.AliyunOSSConfig;
import ynu.edu.domin.User;
import ynu.edu.dto.PicDto;
import ynu.edu.util.AliyunOssUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AliyunOssPicStorageService {
    private final AliyunOssUtil aliyunOssUtil;
    private final AliyunOSSConfig aliyunOssConfig;
    @Resource
    UserService userService;

    public AliyunOssPicStorageService(AliyunOssUtil aliyunOssUtil, AliyunOSSConfig aliyunOssConfig) {
        this.aliyunOssUtil = aliyunOssUtil;
        this.aliyunOssConfig = aliyunOssConfig;
    }

    public CommonResult handleUploadImage(MultipartFile multipartFile,String userId) {

        if (!isImageByMultipartFile(multipartFile)) {
            return CommonResult.builder().code(1).msg("上传失败！文件类型错误！").build();
        }
        String fileName = multipartFile.getOriginalFilename().replaceAll(" +", "");
        String key = getKey(fileName);
        String picUrl = getPicUrl(key);
        User user = new User();
        user.setUserId(userId);
        user.setUserImg(picUrl);
        userService.updateUser(user);
        try {
            aliyunOssUtil.upLoadFile(key, multipartFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.builder().code(0).data(new PicDto(picUrl, key)).msg("上传成功").build();
    }

    //列举出当前目录下的所有图片

    public CommonResult listPicturesByFileHost(String fileHost) {
        List<OSSObjectSummary> ossObjectSummaries = aliyunOssUtil.listFilesByFileHost(fileHost);
        List<PicDto> picDtos = new ArrayList<>();
        // 过滤出来所有图片地址
        ossObjectSummaries.forEach(ossObjectSummary -> {
            String key = ossObjectSummary.getKey();
            if (isImageByFileKey(key)) {
                picDtos.add(new PicDto(getPicUrl(key), key));
            }
        });
        return CommonResult.builder().code(0).data(picDtos).msg("查询当前目录下的所有图片成功！").build();

    }
    public CommonResult getPicByUserId(String userId) {
        String picUrl=userService.getUserById(userId).getUserImg();

        return CommonResult.builder().code(0).data(picUrl).msg("用户图片！").build();

    }

    public void deletePicByKey(String key) {
        aliyunOssUtil.deleteFileByKey(key);
    }

    public String getPicUrl(String key) {
        return "https://" + aliyunOssConfig.getBucketName() + "." + aliyunOssConfig.getEndpoint() + "/" + key;
    }

    public String getKey(String fileName) {
        LocalDateTime dt = LocalDateTime.now();
        LocalDate date = dt.toLocalDate();
        return aliyunOssConfig.getFileHost() + "/" + (date + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + fileName);
    }

    private static boolean isImageByFileKey(String key) {
        String picRegex = "([^\\s]+(\\.(?i)(/bmp|jpg|gif|png))$)";
        Pattern pattern = Pattern.compile(picRegex);
        Matcher matcher = pattern.matcher(key);
        return matcher.matches();
    }

    private static boolean isImageByMultipartFile(MultipartFile multipartFile) {
        return !multipartFile.isEmpty() && multipartFile.getContentType().startsWith("image");
    }


}
