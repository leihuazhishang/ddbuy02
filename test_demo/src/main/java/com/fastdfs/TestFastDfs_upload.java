package com.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname TestFastDfs_upload
 * @Description TODO
 * @Date 2019/7/22 14:11
 * @Created by Administrator
 */
public class TestFastDfs_upload {
    //测试文件上传
    public static void main(String[] args) {
        try {
            //1.加载配置文件
            ClientGlobal.init("fastdfs.properties");
            // 2、创建一个 TrackerClient 对象。直接 new 一个。
            TrackerClient trackerClient = new TrackerClient();
            // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
            TrackerServer trackerServer = trackerClient.getConnection();
            // 4、创建一个 StorageServer 的引用，值为 null
            StorageServer storageServer = null;
            // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            // 6、使用 StorageClient 对象上传图片。
            String[] strings = storageClient.upload_file("D://16.jpg", "jpg",null);
            System.out.println("上传成功");
            System.out.println("上传文件的相关信息");
            for (String info:strings) {
                System.out.println(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
