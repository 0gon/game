package 메소드모음;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import 객체모음.Student;

public class Inventory {
	Student s;
	String type;

	public Inventory(Student s, String type) {
		this.s = s;
		this.type = type;
	}

	public List<Boolean> ItemAcquisition(String type) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Boolean> l = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from (SELECT * FROM item where type = ?) a left join  inventory b on a.no = b.itemNo and b.studentId = ? group by a.no;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, type);
			stmt.setString(2, s.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("studentId") == null) {
					l.add(false);
				} else {
					l.add(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return l;
	}
}
