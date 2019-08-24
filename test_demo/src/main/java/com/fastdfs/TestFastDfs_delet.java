package com.fastdfs;

import org.csource.fastdfs.*;

/**
 * @author 王建兵
 * @Classname TestFastDfs_upload
 * @Description TODO
 * @Date 2019/7/22 14:11
 * @Created by Administrator
 */
public class TestFastDfs_delet {
    //测试删除上传的
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
            // 6、使用 StorageClient 对象删除图片。
           int temp=storageClient.delete_file ("group1","M00/00/00/wKgBHl01y2aAVloIAARn7KhRceQ123.jpg");
            System.out.println("删除成功:"+temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
