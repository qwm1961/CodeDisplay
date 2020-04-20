<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@ page import="cn.tedu.bean.School" %>
<%@ page import="java.util.List" %>
<%
	List<School> list = (List<School>)request.getAttribute("list");
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
<form action="./NeedsMangementServlet?m=1" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td class="tableleft">标题</td>
        <td ><input type="text" id="title" name="Title" value="" style="width: 360px;"/></td>
    </tr>
    <tr>
        <td class="tableleft">紧急状态</td>
        <td >
        	<input type="radio" value="2" name="State" checked/> 非常紧急
        	&nbsp;&nbsp;&nbsp;&nbsp;
           	<input type="radio" value="1" name="State"/> 紧急
        </td>
    </tr>
    <tr>
    	<td class="tableleft">选择学校</td>
    	<td>
    		<select name="Nschool">
    			<%
    				int n = list.size();
    				for(int i=0;i < n;i++){
    			%>
    			<option value="<%=list.get(i).getSname() %>"><%=list.get(i).getSname() %></option>
    			<%
    				}
    			%>
    		</select>
    	</td>
    </tr>
    <tr>
    	<td class="tableleft" >详细信息</td>
    	<td>
    		<div>
		    	<textarea rows="5" name="Information" cols="5"></textarea>
	    	</div>
    	</td>
    </tr>
   
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" id="submit-button" class="btn btn-primary">保存</button>
            &nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
<script type="text/javascript">
    
</script>
</html>