/**
 *
 */
package com.sukkiri.test5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * @author user2
 *
 */
public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String from = args[0];
		String to = args[1];
		try (FileInputStream is = new FileInputStream(from);
				BufferedInputStream br = new BufferedInputStream(is);
				FileOutputStream os = new FileOutputStream(to);
				BufferedOutputStream bo = new BufferedOutputStream(os);
				GZIPOutputStream gout = new GZIPOutputStream(bo);) {
			int data;
			while ((data = br.read()) != -1) {
				// bo.write(data);
				// bo.flush();
				gout.write(data);
				gout.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
