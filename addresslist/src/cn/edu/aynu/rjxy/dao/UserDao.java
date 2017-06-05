package cn.edu.aynu.rjxy.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.aynu.rjxy.bean.User;
import cn.edu.aynu.rjxy.utils.JDBCUtils;

/**
 * 对user表的查询
 * @author Administrator
 *
 */
public class UserDao {
	private  QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 根据用户名和用户密码查询
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public User findByCid(String username,String password) throws SQLException{
		String sql = "select * from user where username=?&&password=?";
		User u = qr.query(sql, new BeanHandler<User>(User.class), username,password);
		return u;
	}
	/**
	 * 注册
	 * @param c
	 * @throws SQLException 
	 */
	public void register(User u) throws SQLException{
		String sql = "insert into user(username,password) values(?,?)";
		qr.update(sql, u.getUsername(),u.getPassword());
	}
}
