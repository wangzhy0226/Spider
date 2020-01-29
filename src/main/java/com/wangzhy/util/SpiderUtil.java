package com.wangzhy.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 爬虫工具类
 * @author wangzhy
 * @since 2020年1月30日
 */
public class SpiderUtil {

	/**
	 * 下载图片
	 * @param url	图片链接
	 * @param dirname 文件夹名称
	 * @param imgname 图片名称
	 * @throws IOException
	 */
	public static void saveMzituImg(String url, String dirname, String imgname) throws IOException {
		File file = new File("D:\\pic\\" + dirname);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("Host", "i5.meizitu.net");
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0");
		httpget.setHeader("Accept", "image/webp,*/*");
		httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		httpget.setHeader("Accept-Encoding", "gzip, deflate, br");
		httpget.setHeader("Connection", "keep-alive");
		httpget.setHeader("Referer", " https://www.mzitu.com/197933/11");
		httpget.setHeader("Cache-Control", "max-age=0, no-cache");

		CloseableHttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		InputStream imageInputStream = entity.getContent();
		if (!file.exists()) {
			file.mkdir();
		}

		OutputStream imageoutputStream = new FileOutputStream(new File("D:\\pic\\" + dirname + "\\" + imgname + ".jpg"));
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = imageInputStream.read(b)) != -1) {
			imageoutputStream.write(b, 0, len);
		}
	}

}
