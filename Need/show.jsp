<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="cn.tedu.bean.Needs"%>

<%
	Needs list = (Needs)request.getAttribute("list");
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
<form action="ListNeedServlet?m=1" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">需求编号</td>
        <td><%=list.getId() %></td>
    </tr>
    <tr>
        <td class="tableleft">标题</td>
        <td ><%=list.getTitle() %></td>
    </tr>
    <tr>
        <td class="tableleft">紧急状态</td>
        <td >
        	<% int n = list.getState();
        		if(n == 2){
        	%>
        		非常紧急
        	<%
        		}
        	%>
        	<% 
        		if (n == 1){
        	 %>
        	 	紧急
        	 <%
        		}
        	 %>
        </td>
    </tr>
    <tr>
    	<td class="tableleft">学校</td>
    	<td>
    		<%=list.getNschool() %>
    		<%-- <%=list2.get(i).getSname() %> --%>
    	</td>
    </tr>
    <tr>
    	<td class="tableleft">详细信息</td>
    	<td>
    		<%=list.getInformation() %>
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