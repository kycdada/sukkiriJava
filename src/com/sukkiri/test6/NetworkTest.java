/**
 *
 */
package com.sukkiri.test6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author user2
 *
 */
public class NetworkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// question 11-1
		URL url = null;
		try {
			url = new URL("http://dokojava.jp/favicon.ico");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (InputStream is = url.openStream();
				BufferedInputStream bs = new BufferedInputStream(is);
				FileOutputStream fos = new FileOutputStream("c:\\Users\\user2\\dj.ico");
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {

			// データ読み込み
			int data = bs.read();
			List<Integer> dataList = new ArrayList<>();
			while (data != -1) {
				dataList.add(data);
				data = bs.read();
			}

			// データ書き出し
			dataList.stream().forEach(content -> {
				try {
					fos.write(content);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// question 11-2
		try(Socket socket = new Socket("smtp.example.com", 60025);
		OutputStream ossk = socket.getOutputStream();
		BufferedOutputStream bossk = new BufferedOutputStream(ossk);) {

		bossk.write(
				"HELO example.com\r\nMAIL FROM: asaka@example.com\r\nRCPT To: minato@example.com\r\nDATA\r\nFrom: asaka@example.com\r\nSubject: Please send me your RPG\r\nHello minato. I would like to play your RPG.\r\nCould you please send it to me ?\r\n.\r\nQUIT".getBytes());
		bossk.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
