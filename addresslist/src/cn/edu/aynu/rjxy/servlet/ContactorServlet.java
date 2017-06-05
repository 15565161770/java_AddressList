package cn.edu.aynu.rjxy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.aynu.rjxy.bean.Contactor;
import cn.edu.aynu.rjxy.bean.User;
import cn.edu.aynu.rjxy.service.ContactorService;
import cn.edu.aynu.rjxy.service.UserService;
import cn.edu.aynu.rjxy.utils.CommonsUtils;
/**
 * 处理联系人请求
 * @author Administrator
 *
 */
public class ContactorServlet extends HttpServlet {
	private ContactorService cs = new ContactorService();
	private UserService us = new UserService();
	private int userId;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * 通过获取表单中的隐藏字段method或者超链接中的method参数的值来区分调用执行那个方法来处理这个请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理中文乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取隐藏字段method的值，并把它转换为int型
		int method = Integer.parseInt(request.getParameter("method"));
		
		switch(method){
			case 1: this.register(request, response);
					break;
			case 2: this.login(request, response);
					break;
			case 3: this.query(request, response);
					break;
			case 4: this.add(request, response);
					break;
			case 5: this.loadForUpdate(request, response);
					break;
			case 6: this.edit(request, response);
				    break;
			case 7:	this.delete(request, response);
					break;
		}
		
		
	}
	/**
	 * 处理注册的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//使用CommonUtils工具类将请求数据封装到bean中
		User u = CommonsUtils.toBean(request.getParameterMap(), User.class);
		//执行添加客户业务
		us.register(u);
		//输出添加成功提示
		response.getWriter().print("注册成功,三秒钟自动跳转到登录界面");
		response.setHeader("Refresh","3;url=/addresslist/jsp/top.jsp");  

	}
	/**
	 * 处理登录的请求 method=2
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从请求中解析用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//执行加载业务
		User u = us.login(username, password);
		if (u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", u.getId());
			response.getWriter().print("登录成功"+u.getId());
			//通过请求转发将pb带到list.jsp上去
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		}else{
			response.getWriter().print("登录失败，即将跳转到登录页面，请重新登录......");
			response.setHeader("Refresh","3;url=/addresslist/jsp/top.jsp");  

		}
		
	}
	/**
	 * 处理查看联系人的请求 method=3
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		 userId = (Integer) session.getAttribute("userId");
		//执行查询业务
		List<Contactor> list = cs.load(userId);
		//将list存放到request域中
		request.setAttribute("contactorList", list);
		System.out.println(list.size());
		//通过请求转发将查询结果带到list.jsp页面上显示
		request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		
	}
	/**
	 * 处理添加客户的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		userId = (Integer) session.getAttribute("userId");
		//使用CommonUtils工具类将请求数据封装到bean中
		Contactor c = CommonsUtils.toBean(request.getParameterMap(), Contactor.class);
		//执行添加客户业务
		cs.add(c,userId);
		//输出添加成功提示
		response.getWriter().print("添加成功,三秒后跳转到功能界面......");
		response.setHeader("Refresh","3;url=/addresslist/jsp/list.jsp");  
	}
	/**
	 * 处理加载某一个客户的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadForUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//从请求中获取客户的cid
		String ids = request.getParameter("id");
		int id = Integer.valueOf(ids);
		//执行加载业务
		Contactor c = cs.loadById(id);
		//将Customer对象c保存在request域中
		request.setAttribute("contactor", c);
		//通过请求转发将customer对象显示在list.jsp页面上
		request.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);

	}
	/**
	 * 处理更改某一联系人的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		userId = (Integer) session.getAttribute("userId");
		//使用CommonUtils工具类将请求数据封装到bean中
		Contactor c = CommonsUtils.toBean(request.getParameterMap(), Contactor.class);
		//执行更改业务
		cs.edit(c,userId);
		//给客户端发送更改成功提示
		response.getWriter().print("更改成功,三秒后跳转到功能界面......");
		response.setHeader("Refresh","3;url=/addresslist/jsp/list.jsp");  

	}
	/**
	 * 处理删除某一联系人的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//从请求中获取cid
		String cid = request.getParameter("id");
		int id = Integer.valueOf(cid);
		//执行删除客户业务
		cs.delete(id);
		//给客户端发送删除成功提示
		response.getWriter().print("删除成功,三秒后跳转到功能界面......");
	    response.setHeader("Refresh","3;url=/addresslist/jsp/list.jsp");  


}

}
