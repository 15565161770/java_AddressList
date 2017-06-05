package cn.edu.aynu.rjxy.service;

import java.sql.SQLException;

import cn.edu.aynu.rjxy.bean.User;
import cn.edu.aynu.rjxy.dao.UserDao;


/**
 * 
 * @author Administrator
 *
 */
public class UserService {
	//创建ContactorDao对象
	UserDao dao = new UserDao();
	/**
	 * 根据用户名和密码查询用户
	 * @param cid
	 */
	public User login(String username,String password){
		try {
			return dao.findByCid(username,password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 注册
	 * @param c
	 */
	public void register(User u){
		try {
			dao.register(u);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
