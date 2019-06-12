/**
 *
 */
package com.sukkiri.test6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author user2
 *
 */
public class DBConnector {
	// 接続の確立を行うクラス
	private static String driverName = "org.h2.Driver";
	private static String driverURL = "jdbc:h2:~/db/rpgdb";

	public Connection getConnention() {
		Connection con = null; // 接続初期化
		try {
			Class.forName(driverName); //jdbc driver確認
			con = DriverManager.getConnection(driverURL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
