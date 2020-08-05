package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import util.DBUtil;
import vo.LendBuyTJ;
import vo.buyColl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TongJiDao {
	private static final QueryRunner runner = new QueryRunner(DBUtil.getDS());

	public static ArrayList<LendBuyTJ> GetLendTJInfo() throws SQLException {
		ArrayList<LendBuyTJ> list = new ArrayList<LendBuyTJ>();

		String sql = "select substring(lend_time,6,2) month, count(1) count,sum(price) total_price from collection_lend cl left join collection c on cl.collection_id=c.collection_id group by substring(lend_time,6,2)";
		System.out.println(sql);

		list = runner.query(sql, new ResultSetHandler<ArrayList<LendBuyTJ>>() {
			public ArrayList<LendBuyTJ> handle(ResultSet rs) throws SQLException {
				ArrayList<LendBuyTJ> list = new ArrayList<LendBuyTJ>();
				while (rs.next()) {
					LendBuyTJ bc = new LendBuyTJ();
					String sta = "";
					bc.setMonth(rs.getString("month"));
					bc.setCount(rs.getString("count"));
					bc.setTotal_price(rs.getString("total_price"));

					list.add(bc);

				}


				return list;


			}
		});
		return list;
	}

	public static ArrayList<LendBuyTJ> GetBuyTJInfo() throws SQLException {
		ArrayList<LendBuyTJ> list = new ArrayList<LendBuyTJ>();

		String sql = "select substring(cl.in_time,6,2) month, count(1) count,sum(price) total_price from collection_buy cl left join collection c on cl.collection_id=c.collection_id group by substring(cl.in_time,6,2)";
		System.out.println(sql);

		list = runner.query(sql, new ResultSetHandler<ArrayList<LendBuyTJ>>() {
			public ArrayList<LendBuyTJ> handle(ResultSet rs) throws SQLException {
				ArrayList<LendBuyTJ> list = new ArrayList<LendBuyTJ>();
				while (rs.next()) {
					LendBuyTJ bc = new LendBuyTJ();
					String sta = "";
					bc.setMonth(rs.getString("month"));
					bc.setCount(rs.getString("count"));
					bc.setTotal_price(rs.getString("total_price"));

					list.add(bc);

				}


				return list;


			}
		});
		return list;
	}
}
