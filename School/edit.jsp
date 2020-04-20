<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tedu.bean.School"%>
<%@ page import="java.util.List" %>
<%
	School list = (School)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/common.js"></script> 
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form action="EditServlet?m=2" method="post" class="definewidth m20">
<table class="table table-bordered table-hover ">
    <tr>
        <td width="10%" class="tableleft">学校编号</td>
        <td><input type="text" id="id" name="id" value="<%=list.getSid() %>" readonly="readonly"/></td>
    </tr>
    <tr>
        <td class="tableleft">学校名称</td>
        <td ><input type="text" id="schName" name="schName" value="<%=list.getSname()%>"/></td>
    </tr>
    <tr>
        <td class="tableleft">需要援助</td>
        <td >
      	<%
      		int n = list.getNassistance();
      		if(n == 1){
      	%>
        	<input type="radio" value="<%=list.getNassistance() %>" name="Nassistance" checked/> 是
        	<input type="radio" value="<%=list.getNassistance() %>" name="Nassistance" /> 否
        <%
      		}
        %>
        <%
        	if(n == 0){
        %>
	        <input type="radio" value="<%=list.getNassistance() %>" name="Nassistance" /> 是
	        <input type="radio" value="<%=list.getNassistance() %>" name="Nassistance" checked/> 否
        <%
      		}
        %>
        </td>
    </tr>
    
    <tr>
        <td class="tableleft">前往援助</td>
        <td >
        <%
      		int g = list.getGaid();
        	
      		if(g == 1){
      	%>
			<input type="radio" value="<%=list.getGaid() %>" name="Gaid" checked/> 是
			<input type="radio" value="<%=list.getGaid() %>" name="Gaid" /> 否
        <%
      		}
      	%>
      	<%
      		if(g == 0){
        %>
        	<input type="radio" value="<%=list.getGaid() %>" name="Gaid" /> 是
        	<input type="radio" value="<%=list.getGaid() %>" name="Gaid" checked/> 否
        <%
      		}
        %>
        </td>
    </tr>
    <tr>
    	<td class="tableleft">详细信息</td>
    	<td>
    		<div>
		    	<textarea rows="5" cols="5" name="Countent" value=""><%=list.getCountent()%></textarea>
	    	</div>
    	</td>
    </tr>
    <tr>
    	<td class="tableleft">援藏历史</td>
    	<td>
    		<textarea rows="5" cols="5" name="History" value=""><%=list.getHistory() %></textarea>
    	</td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" id="submit-button" class="btn btn-primary">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
<script type="text/javascript">
$("#backid").click(function(){
	window.location.href = "EditServlet?m=7";
});
</script>
</html>