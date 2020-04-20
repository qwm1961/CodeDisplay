<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	
    <title></title>
    <meta charset="utf-8" />
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
<form action="../EditServlet?m=6" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td class="tableleft">学校名称</td>
        <td ><input type="text" id="schName" name="schName"/></td>
    </tr>
    <tr>
        <td class="tableleft">需要援助</td>
        <td >
        	<input type="radio" name="Nassistance" value="1" checked/> 是
        	&nbsp;&nbsp;&nbsp;&nbsp;
           	<input type="radio" name="Nassistance" value="0" /> 否	
        </td>
    </tr>
    <tr>
        <td class="tableleft">前往援助</td>
        <td >
        	<input type="radio" name="Gaid" value="1" checked/> 是
        	&nbsp;&nbsp;&nbsp;&nbsp;
           	<input type="radio" name="Gaid" value="0" /> 否
        </td>
    </tr>
    <tr>
    	<td class="tableleft">详细信息</td>
    	<td>
    		<div>
		    	<textarea rows="5" name="Countent" cols="5"></textarea>
	    	</div>	
    	</td>
    </tr>
    <tr>
    	<td class="tableleft">援藏历史</td>
		<td>
    	<div>
		    <textarea rows="5" name="History" cols="5"></textarea>
	    </div>
		</td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" id="submit-button" class="btn btn-primary" >保存</button> &nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
<script type="text/javascript">
	$("#backid").click(function(){
		window.location.href = "../EditServlet?m=7";
	});
</script>
</html>