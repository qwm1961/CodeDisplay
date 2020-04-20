package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.bean.Admin;
import cn.tedu.bean.Needs;
import cn.tedu.bean.School;
import cn.tedu.service.NeedsService;
import cn.tedu.service.SchoolService;

@WebServlet("/NeedsMangementServlet")
public class NeedsMangementServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String m=req.getParameter("m");
		switch(m) {
		case"1":
			HttpSession session=req.getSession();
			Admin ad=(Admin)session.getAttribute("loginUser");
			String crname=ad.getUname();
			
			String title = req.getParameter("Title");
			
			String state = req.getParameter("State");
			int sta = Integer.parseInt(state);
			
			String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String nschool = req.getParameter("Nschool");
			
			System.out.println(nschool+"***********");
			String information = req.getParameter("Information");
			
			System.out.println(information+"-------------------");
			/**
			 * 获取创建者
			 */
			
			Needs needs = new Needs();
			needs.setTitle(title);
			needs.setState(sta);
			needs.setCreatetime(createtime);
			needs.setNschool(nschool);
			needs.setInformation(information);
			needs.setCrname(crname);
			NeedsService nService = new NeedsService();
			String result = nService.add(needs);
			
			if (result.equals("添加成功")) {
				req.getRequestDispatcher("ListNeedServlet?m=1").forward(req, resp);
			}
			// 把执行结果渲染到页面
			PrintWriter out4 = resp.getWriter();
			out4.write(result);
			out4.close();
			
			break;
			
		case"2":
			String nid = req.getParameter("id");
			int Id = Integer.parseInt(nid);
			
			String Title = req.getParameter("title");
			String State = req.getParameter("level");
			int State2 = Integer.parseInt(State);
			
			String Nschool = req.getParameter("Nschool");
			String Information = req.getParameter("information");
			
			Needs needs3 = new Needs();
			needs3.setId(Id);
			needs3.setTitle(Title);
			needs3.setState(State2);
			needs3.setNschool(Nschool);
			needs3.setInformation(Information);
			
			NeedsService nService2 = new NeedsService();
			String result2 = nService2.editNeeds(needs3);
			
			if (result2.equals("修改成功")) {
				req.getRequestDispatcher("ListNeedServlet?m=1").forward(req, resp);
			}
			// 把执行结果渲染到页面
			PrintWriter out = resp.getWriter();
			out.write(result2);
			out.close();
			
			break;
			
		case"3":
			String nid2 = req.getParameter("id");
			int Id2 = Integer.parseInt(nid2);
			
			NeedsService nService4 = new NeedsService();
			String result3 = nService4.deletNeed(Id2);
			
			if (result3.equals("删除成功")) {
				req.getRequestDispatcher("ListNeedServlet?m=1").forward(req, resp);
			}else {
				PrintWriter out2 = resp.getWriter();
				out2.write(result3);
				out2.close();
			}
			break;
			
		case"4":
			String nid3 = req.getParameter("id");
			int Id3 = Integer.parseInt(nid3);
			
			NeedsService nService5 = new NeedsService();
			Needs list3 = nService5.selectNedById(Id3);
			
			req.setAttribute("list", list3);
			req.getRequestDispatcher("Need/show.jsp").forward(req, resp);
			break;
			
		case"5":
			String param = req.getParameter("param");
			NeedsService nService6 = new NeedsService();
			List<Needs> list = nService6.selectTitle(param);
			
			SchoolService schService2 = new SchoolService();
			List<School> list4 = schService2.selectNedSchool();
			
			if (list !=null) {
				req.setAttribute("list", list);
				req.setAttribute("list2", list4);
				req.getRequestDispatcher("Need/index.jsp").forward(req, resp);
			} else {
				PrintWriter out3 = resp.getWriter();
				out3.print("抱歉，没有找到，请重试！");
				out3.close();
			}
			break;
		}
	}
	
}
