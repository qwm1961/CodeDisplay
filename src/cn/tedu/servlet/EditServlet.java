package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.bean.Page;
import cn.tedu.bean.School;
import cn.tedu.service.SchoolService;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String m=req.getParameter("m");
		switch(m) {
		case"1":
			
			String sid = req.getParameter("id");
			int id = Integer.parseInt(sid);
			
			SchoolService scService3 = new SchoolService();
			School list= scService3.selectSid(id);
			
			//System.out.println(list);
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("School/edit.jsp").forward(req, resp);
			
			break;
			
		case"2":
			
			String sid2 = req.getParameter("id");
			int id2 = Integer.parseInt(sid2);
			
			String Sname = req.getParameter("schName");
			
			String Nassistance = req.getParameter("Nassistance");
			int Nassis = Integer.parseInt(Nassistance);
			
			String Gaid = req.getParameter("Gaid");
			int Gd = Integer.parseInt(Gaid);
			
			String Countent = req.getParameter("Countent");
			String History = req.getParameter("History");
			
			// 把参数封装为一个school对象
			School school2 = new School();
			school2.setSid(id2);
			school2.setSname(Sname);
			school2.setNassistance(Nassis);
			school2.setGaid(Gd);
			school2.setCountent(Countent);
			school2.setHistory(History);
			
			
			SchoolService scService4 = new SchoolService();
			String result2 = scService4.editSchool(school2);
			
			System.out.println(school2);
			
			if(result2.equals("修改成功")) {
				req.getRequestDispatcher("EditServlet?m=7").forward(req, resp);
			}
			
			// 把执行结果渲染到页面
			PrintWriter out = resp.getWriter();
			out.write(result2);
			out.close();
			
			break;
		case"3":
			
			String sid3 = req.getParameter("id");
			int id3 = Integer.parseInt(sid3);
			
			SchoolService scService5 = new SchoolService();
			School list2= scService5.selectSid(id3);
			
			//System.out.println(list);
			
			req.setAttribute("list", list2);
			req.getRequestDispatcher("School/show.jsp").forward(req, resp);
			
			break;
			
		case"4":
			String sid4 = req.getParameter("id");
			int id4 = Integer.parseInt(sid4);
			
			SchoolService scService6 = new SchoolService();
			String d= scService6.deleteSid(id4);
			
			if(d.equals("删除成功") ) {
				req.getRequestDispatcher("EditServlet?m=7").forward(req, resp);
			}else {
				PrintWriter out2 = resp.getWriter();
				out2.print(d);
				out2.close();
			}
			break;
			
		case"5":
			
			String param = req.getParameter("param");
			SchoolService scService7 = new SchoolService();
			List<School> list4 = scService7.selectSchool(param);
			if (list4 !=null) {
				req.setAttribute("list", list4);
				req.getRequestDispatcher("School/index.jsp").forward(req, resp);
			} else {
				PrintWriter out3 = resp.getWriter();
				out3.print("抱歉，没有找到，请重试！");
				out3.close();
			}
			
			break;
			
		case"6":
			String Sname2 = req.getParameter("schName");
			
			String Nassistance2 = req.getParameter("Nassistance");
			int Nassis2 = Integer.parseInt(Nassistance2);
			
			String Gaid2 = req.getParameter("Gaid");
			int Gd2 = Integer.parseInt(Gaid2);
			
			String Countent2 = req.getParameter("Countent");
			String History2 = req.getParameter("History");

			// 把参数封装为一个school对象
			School school = new School();
			school.setSname(Sname2);
			school.setNassistance(Nassis2);
			school.setGaid(Gd2);
			school.setCountent(Countent2);
			school.setHistory(History2);
			
			// 调用service的方法，把学校存储到数据库
			SchoolService scService = new SchoolService();
			String result = scService.add(school);
			
			if(result.equals("添加成功")) {
				// 把请求转发到index.jsp
				req.getRequestDispatcher("ListSchoolServlet").forward(req, resp);
			}
			
			// 把执行结果渲染到页面
			PrintWriter out4 = resp.getWriter();
			out4.write(result);
			out4.close();
			break;
			
		case"7":
			String index = req.getParameter("index");
			// 创建页码对象
			Page p = new Page();
					
			if(index != null) {
				p.setIndex(Integer.parseInt(index));
			}
			
			// 分页查询所有学校
			SchoolService scService2 = new SchoolService();
			List<School> list1 = scService2.findAllSchoolByPage();
			
			// 查询总共有多少数据
			List<School> total = scService2.findAllSchoolByPage();
			p.setTotalRows(total.size());
			
			req.setAttribute("page", p);
			req.setAttribute("list", list1);
			req.getRequestDispatcher("School/index.jsp").forward(req, resp);
			break;
		}
		
	}
	
}
