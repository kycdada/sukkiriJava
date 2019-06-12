/**
 *
 */
package com.sukkiri.test6;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

/**
 * @author user2
 *
 */
public class NetworkSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// java.net.URl
		// html取得
		URL url = null;
		try {
			url = new URL("http://dokojava.jp");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try (InputStream is = url.openStream();) {
			// バイトStreamを文字列に
			InputStreamReader inputReader = new InputStreamReader(is);
			int data = inputReader.read();
			while (data != -1) {
				System.out.print((char) data);
				data = inputReader.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Socket

		try (Socket sock = new Socket("dokojava.jp", 80);
				InputStream iss = sock.getInputStream();
				OutputStream oss = sock.getOutputStream();) {
			oss.write("GET /index.html HTTP/1.0\r\n".getBytes()); // HTTP要求を送信
			oss.write("\r\n".getBytes());
			oss.flush();

			int data = iss.read(); // 応答を受信

			while (data != -1) {
				System.out.print((char) data);
				data = iss.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ServerSocket 通信を待ち受ける側
		System.out.println("起動完了");
		try (ServerSocket svSock = new ServerSocket(39648);) { // 待ち受けポート
			Socket sock = svSock.accept(); // 呼び出すと、誰かから接続されるまで待ち続ける。
			System.out.println(sock.getInetAddress() + "から接続");
			sock.getOutputStream().write("WELCOME".getBytes());
			sock.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
