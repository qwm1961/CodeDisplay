<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="cn.tedu.bean.Page" %>
<%@ page import="cn.tedu.bean.School"%>
<%@ page import="java.util.List" %>
<%
	List<School> list = (List<School>)request.getAttribute("list");
	Page p = (Page)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>

<title></title>
<meta charset="UTF-8"><!-- 8080/css/bootstrap.css -->
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
	<form class="form-inline definewidth m20" action="EditServlet" method="get">
		<input type="hidden" name="m" value="5">
		学校名称： <input type="text" name="param" id="param" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		
		<button type="button" class="btn btn-success" id="addnew">新增学校</button>
	</form>
	
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>学校编号</th>
				<th>学校名称</th>
				<th>需要援助</th>
				<th>前往援助</th>
				<th>管理操作</th>
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
			<td><%=list.get(i).getSid() %></td>
			<td style="max-width: 220px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
				<a title="点击查看详情" href="EditServlet?m=3&id=<%=list.get(i).getSid() %>">
					<%=list.get(i).getSname() %>
				</a>
			</td>
			<td>
				<%=list.get(i).getNassistance() %>
			</td>
			<td>
				<%=list.get(i).getGaid() %>
			</td>
			<td>
				 <a class="option-button" href="EditServlet?m=1&id=<%=list.get(i).getSid() %>">编辑</a>
				|<a class="option-button" href="EditServlet?m=4&id=<%=list.get(i).getSid() %>">删除</a>
				|<a class="option-button" href="EditServlet?m=3&id=<%=list.get(i).getSid() %>">查看</a>
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
		window.location.href = "School/add.jsp";
	});
    
    /* function select(){
    	var param = document.getElementById("param").value;
    	var param2 = "param=" + param;
    	$.ajax({
    		url:"EditServlet?m=5",
    		type:"post",
    		data:param2,
    		success:function(res){
    			window.location.reload();
    		},
    		error:function(){
    			alert("网络异常");
    		}
    	});
    } */
</script>
</html>