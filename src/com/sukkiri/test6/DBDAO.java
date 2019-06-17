/**
 *
 */
package com.sukkiri.test6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sukkiri.test7.util.ItemDTO;

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

	private String sql2 = "INSERT INTO item(NAME, PRICE, WEIGHT) VALUES(?,?,?)";
	private String sql3 = "SELECT * FROM item";

	public String sqlTEST() {

		ItemDTO item = new ItemDTO();
		item.setName("test");
		item.setPrice(154);
		item.setWeight(500);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps2 = con.prepareStatement(sql2);
			PreparedStatement ps3 = con.prepareStatement(sql3);

			// ?埋め
			ps2.setString(1, item.getName());
			ps2.setInt(2, item.getPrice());
			ps2.setInt(3, item.getWeight());

			int i = ps.executeUpdate();
			int i2 = ps2.executeUpdate();
			ResultSet rs = ps3.executeQuery();

			// 結果を表示
			while (rs.next()) {
				ItemDTO addItem = new ItemDTO();
				addItem.setName(rs.getString("NAME"));
				addItem.setPrice(rs.getInt("PRICE"));
				addItem.setWeight(rs.getInt("WEIGHT"));

				System.out.println(addItem.getName());
				System.out.println(addItem.getPrice());
				System.out.println(addItem.getWeight());
			}

			// close 書いた方が無難 カーソルが残る場合があり、最大カーソル数に引っかかることがあるらしい。
			ps.close();
			ps2.close();
			ps3.close();
			rs.close();

			// トランザクションコミット
			con.commit();

			if (i != 0 && i2 != 0 && rs != null) {
				System.out.println("tableを作成しました。");
			} else {
				System.out.println("既にtableは存在します。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException back) {
				back.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "test";
	}

}
