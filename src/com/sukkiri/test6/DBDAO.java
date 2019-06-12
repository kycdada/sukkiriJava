/**
 *
 */
package com.sukkiri.test6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author user2
 *
 */
public class DBDAO {

	/**
	 * @param args
	 */
	DBConnector db = new DBConnector();
	Connection con = db.getConnention();
	private String sql = "create table if not exists item("
			+ "NAME varchar(255),"
			+ "PRICE int,"
			+ "WEIGHT int)";

	public String sqlTEST() {
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			int i = ps.executeUpdate();

			if (i != 0) {
				System.out.println("tableを作成しました。");
			} else {
				System.out.println("既にtableは存在します。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "test";
	}

}
