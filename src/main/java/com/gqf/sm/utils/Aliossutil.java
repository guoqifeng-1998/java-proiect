package com.gqf.sm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName AliOSSUtil
 * @Description TODO
 * @Author gqfeng
 * @Date 2020/11/19
 **/
public class Aliossutil {
    public static String ossUpload(File file){
        String bucketDomain = "https://jkuzi.oss-cn-beijing.aliyuncs.com/";
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4G2fsEqmAzRdwNWaeFXj";
        String accessKeySecret = "FHLvz1AYPsQVDIVsHeagrlVcHStYXP";
        String bucketName = "jkuzi";
        String fileDir = "img/";
        String fileName = file.getName();
        String filekey = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName,fileDir + filekey,file);
        ossClient.shutdown();
        return  bucketDomain + fileDir + filekey;
    }

    public static void main(String[] args) {
        File file = new File("D:\\tools\\you.jpg");
        String url = ossUpload(file);
        System.out.println(url);
    }
}
