<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
	<head>
		<meta charset="utf-8" />
		<title>在线考试系统 | 学生考试</title>
		<meta content="width=device-width, initial-scale=1.0" name="viewport" />
		<meta content="" name="description" />
		<meta content="" name="author" />
		<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
		<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		<link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>
		<link href="media/css/style.css" rel="stylesheet" type="text/css"/>
		<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
		<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
		<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
		<link href="media/css/error.css" rel="stylesheet" type="text/css"/>
		<link rel="shortcut icon" href="media/image/laboratory.ico" />
	</head>
    <% response.setHeader("Refresh","3;URL='showExamList.do'");%>
	<body class="page-404-full-page">
		<div class="row-fluid">
			<div class="span12 page-404">
				<div class="number">
					Sorry
				</div>
				<div class="details">
					<h3><%=request.getAttribute("error")%></h3>
					<p>
						三秒后为您跳转到主页.<br />
						或点击<a href="showExamList.do">这里</a>
					</p>
				</div>
			</div>
		</div>
		<script src="media/js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="media/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="media/js/excanvas.js"></script>
		<script src="media/js/respond.js"></script>
		<script src="media/js/breakpoints.js" type="text/javascript"></script>
		<script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>
		<script src="media/js/app.js"></script>
		<script>
			jQuery(document).ready(function() {
			   App.init();
			});
		</script>
	</body>
</html>