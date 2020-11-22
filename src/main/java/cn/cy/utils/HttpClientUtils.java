package cn.cy.utils;


import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {

    //https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=20
    public static void main(String[] args) {


    }





    public static String doHttpGet (String url) {
        String result = "";
        //创建一个http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //创建一个get请求
        HttpGet httpGet = new HttpGet(url);
        //User-Agent ：客户端请求工具信息（浏览器信息）
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36 Edg/86.0.622.69");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
//            System.out.println("响应状态:"+response.getStatusLine());
            HttpEntity entity = response.getEntity();
//            System.out.println("返回类型："+entity.getContentType());
//            System.out.println("返回的html："+EntityUtils.toString(entity));
            result = EntityUtils.toString(entity);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
