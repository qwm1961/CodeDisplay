
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@page import="java.util.List"%>
<%@page import="cn.tedu.bean.Needs"%>
<%@ page import="cn.tedu.bean.School" %>
<%
	Needs list = (Needs)request.getAttribute("list");
	List<School> list2 = (List<School>)request.getAttribute("list2");
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/common.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
 
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
<form action="NeedsMangementServlet?m=2" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">需求编号</td>
        <td><input type="text" readonly="readonly" name="id" value="<%=list.getId()%>"/></td>
    </tr>
    <tr>
        <td class="tableleft">标题</td>
        <td ><input type="text" name="title" value="<%=list.getTitle()%>" style="width: 300px;"/></td>
    </tr>
    <tr>
        <td class="tableleft">紧急状态</td>
        <td >
        	<%
	      		int n = list.getState();
	      		if(n == 2){
      		%>
        	<input type="radio" id="level" name="level" value="2" checked/> 非常紧急
        	&nbsp;&nbsp;&nbsp;&nbsp;
           	<input type="radio" id="level" name="level" value="1" /> 紧急
           	<%
      			}
        	%>
        	<%
	      		int m = list.getState();
	      		if(m == 1){
      		%>
        	<input type="radio" id="level" name="level" value="2" /> 非常紧急
        	&nbsp;&nbsp;&nbsp;&nbsp;
           	<input type="radio" id="level" name="level" value="1" checked/> 紧急
           	<%
      			}
        	%>
        </td>
    </tr>
    <tr>
    	<td class="tableleft">选择学校</td>
    	<td>
    		<select name="Nschool">
    		<%
    			int j = list2.size();
    			for(int i=0;i < j;i++){
    		%>
    			<option value="<%=list2.get(i).getSname() %>" ><%=list2.get(i).getSname() %></option>
    		<%
    			}
    		%>
    		</select>
    	</td>
    </tr>
    <tr>
    	<td class="tableleft">详细信息</td>
    	<td>
    		<div>
		    	<textarea rows="5" value="<%=list.getInformation()%>" name="information" cols="5"></textarea>
	    	</div>
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
    
</script>
</html>