<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tedu.bean.Page" %>
<%@ page import="cn.tedu.bean.Needs" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.tedu.bean.School" %>
<%@ page import="java.util.List" %>
<%
	List<Needs> list = (List<Needs>)request.getAttribute("list");
	System.out.print(list);
	List<School> list2 = (List<School>)request.getAttribute("list2");
	Page p = (Page)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<title>需求管理</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/ckform.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/common.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
.option-button:hover {
	color:red;
}
</style>
</head>
<body>
	<form class="form-inline definewidth m20" action="NeedsMangementServlet" method="get">
	<input type="hidden" name="m" value="5">
		标题： 
		<input type="text" name="param" id="param" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">发布需求</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>编号</th>
				<th>标题</th>
				<th>紧急状态</th>
				<th>发布学校</th>
				<th>阅读量</th>
				<th>发布时间</th>
				<th>发布者</th>
				<th>操作</th>
			</tr>
		</thead>
		<%
			int max = 5;
			if(list.size() < 5){
				max = list.size();
			}
			for(int i = 0; i < max; i++){
		%>
		<tr>
			<td><%=list.get(i).getId() %></td>
			<td style="max-width: 220px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
				<a title="点击查看全文" href="NeedsMangementServlet?m=4&id=<%=list.get(i).getId() %>">
					<%=list.get(i).getTitle() %>
				</a>
			</td>
			<td><%=list.get(i).getState() %></td>
			<td style="max-width: 120px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"><%=list.get(i).getNschool() %></td>
			<td><%=list.get(i).getReadnum() %></td>
			<td><%=list.get(i).getCreatetime() %></td>
			<td><%=list.get(i).getCrname() %></td>
			<td>
				 <a class="option-button" href="ListNeedServlet?m=3&id=<%=list.get(i).getId() %>">编辑</a>
				|<a class="option-button" href="NeedsMangementServlet?m=3&id=<%=list.get(i).getId() %>">删除</a>
				|<a class="option-button" href="NeedsMangementServlet?m=4&id=<%=list.get(i).getId() %>">查看</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<div class="inline pull-right page">
		10 条记录 1/2页 
		<a href='#'>首页</a>
		<a href='#'>上一页</a>
		<a href='#'>下一页</a>
		<a href='#'>尾页</a>
	</div>
</body>
<script>
    $("#addnew").click(function(){
		window.location.href = "ListNeedServlet?m=2";
	});
</script>
</html>