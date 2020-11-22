package cn.cy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;



public class FileUtils {

    /**
     * 根据图片url下载图片
     * @param urlString url
     * @param saveFolderPath 保存的文件夹地址
     * @param fileName 文件名（不带后缀）
     */
    public void downloadImgByUrl(String urlString, String saveFolderPath,String fileName) throws Exception {
        //提取url的图片后缀
        String suffix = urlString.substring(urlString.lastIndexOf("."), urlString.length());
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        if(!new File(saveFolderPath).exists()){
            new File(saveFolderPath).mkdirs();
        }
        String filename = saveFolderPath+File.separator+fileName+suffix;  //下载路径及下载图片名称
        File file = new File(filename);
        FileOutputStream os = new FileOutputStream(file, true);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }


}
