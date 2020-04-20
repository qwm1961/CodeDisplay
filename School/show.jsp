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
<form action="EditServlet?m=7" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover ">
	
    <tr>
        <td width="10%" class="tableleft">学校编号</td>
        <td><%=list.getSid() %></td>
    </tr>
    <tr>
        <td class="tableleft">学校名称</td>
        <td ><%=list.getSname() %></td>
    </tr>
    <tr>
        <td class="tableleft">需要援助</td>
        <td >
        	<%=list.getNassistance() %>
        </td>
    </tr>
    
    <tr>
        <td class="tableleft">前往援助</td>
        <td >
        	<%=list.getGaid() %>
        </td>
    </tr>
    <tr>
    	<td class="tableleft">详细信息</td>
    	<td>
    		<%=list.getCountent() %>
    	</td>
    </tr>
    <tr>
    	<td class="tableleft">援藏历史</td>
    	<td>
    		<%=list.getHistory() %>
    	</td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
<script type="text/javascript">
    
</script>
</html>