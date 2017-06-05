package cn.edu.aynu.rjxy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.aynu.rjxy.bean.Contactor;
import cn.edu.aynu.rjxy.utils.JDBCUtils;

/**
 * 对linkman表的增删改查
 * @author Administrator
 *
 */
public class ContactorDao {
	private  QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 添加联系人
	 * @param c
	 * @throws SQLException 
	 */
	public void insert(Contactor c,int userId) throws SQLException{
		String sql = "insert into linkman(name,tel,address,zipcode,userId) values(?,?,?,?,?)";
		qr.update(sql, c.getName(),c.getTel(),c.getAddress(),c.getZipcode(),userId);
	}
	/**
	 * 删除联系人
	 * @param cid
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException{
		String sql = "delete from linkman where id=?";
		qr.update(sql, id);
	}
	/**
	 * 修改联系人
	 * @param c
	 * @throws SQLException
	 */
	public void update(Contactor c,int userId) throws SQLException{
		String sql = "update linkman set name=?,tel=?,address=?,zipcode=?,userId=? where id=?";
		qr.update(sql, c.getName(),c.getTel(),c.getAddress(),c.getZipcode(),userId,c.getId());
	}
	/**
	 * 根据userId查询联系人
	 * @throws SQLException 
	 * 
	 */
	public List<Contactor> findAll(int userId) throws SQLException{
		String sql = "select * from linkman where userId = ?";
		List<Contactor> list = qr.query(sql, new BeanListHandler<Contactor>(Contactor.class),userId);
		return list;
		
	}
	/**
	 * 根据id查询某个联系人
	 * @throws SQLException 
	 * 
	 */
	public Contactor findByCid(int id) throws SQLException{
		String sql = "select * from linkman where id=?";
		Contactor c = qr.query(sql, new BeanHandler<Contactor>(Contactor.class), id);
		return c;
	}
	
}
