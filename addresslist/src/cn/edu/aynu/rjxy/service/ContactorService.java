package cn.edu.aynu.rjxy.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.aynu.rjxy.bean.Contactor;
import cn.edu.aynu.rjxy.dao.ContactorDao;

/**
 * 联系人功能处理
 * @author Administrator
 *
 */
public class ContactorService {
	//创建ContactorDao对象
	ContactorDao dao = new ContactorDao();
	/**
	 * 添加联系人
	 * @param c
	 */
	public void add(Contactor c,int userId){
		try {
			dao.insert(c,userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 删除联系人
	 * @param cid
	 */
	public void delete(int id){
		try {
			dao.delete(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 加载（查询）联系人
	 * @param cid
	 */
	public List<Contactor> load(int userId){
		try {
			return dao.findAll(userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 加载（查询）联系人（为修改做准备）
	 * @param cid
	 */
	public Contactor loadById(int id){
		try {
			return dao.findByCid(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 编辑（修改）联系人信息
	 * @param c
	 */
	public void edit(Contactor c,int userId){
		try {
			dao.update(c,userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
