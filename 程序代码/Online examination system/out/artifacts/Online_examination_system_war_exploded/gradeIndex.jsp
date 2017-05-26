<%@ page import="cn.cslg.Online_examination_system.ToolBean.Teacher" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Grade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />
		<title>在线考试系统 | 教师管理页 - 班级管理</title>
		<meta content="width=device-width, initial-scale=1.0" name="viewport" />
		<meta content="" name="description" />
		<meta content="" name="author" />

		<link href="../media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="../media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
		<link href="../media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		<link href="../media/css/style-metro.css" rel="stylesheet" type="text/css"/>
		<link href="../media/css/style.css" rel="stylesheet" type="text/css"/>
		<link href="../media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
		<link href="../media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
		<link href="../media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
		<link href="../media/css/jquery.fancybox.css" rel="stylesheet" />
		<link href="../media/css/chosen.css" rel="stylesheet" type="text/css"/>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="../media/image/laboratory.ico" />
	</head>

	<%
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		ArrayList<Grade> grades = (ArrayList<Grade>) request.getAttribute("grades");
		pageContext.setAttribute("teacher", teacher);
		pageContext.setAttribute("grades", grades);
	%>

	<body class="page-header-fixed">
		<div class="header navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="brand" href="#"><img src="../media/image/logo.png" alt="logo" /></a>

					<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
					<img src="../media/image/menu-toggler.png" alt="" />
					</a>

					<ul class="nav pull-right">
						<li class="dropdown user">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img alt="" src="../media/image/avatar1_small.jpg" />
							<span class="username">username</span>
							<i class="icon-angle-down"></i>
							</a>

							<ul class="dropdown-menu">
								<li class="divider"></li>
								<li><a href="#"><i class="icon-key"></i> 注销</a></li>
							</ul>

						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="page-container row-fluid">
			<div class="page-sidebar nav-collapse collapse">
				<ul class="page-sidebar-menu">
					<li>
						<div class="sidebar-toggler hidden-phone"></div>
					</li>

					<li>
						<form class="sidebar-search">
							<div class="input-box">
								<a href="javascript:;" class="remove"></a>
								<input type="text" placeholder="搜索..." />
								<input type="button" class="submit" value=" " />

							</div>

						</form>
					</li>

					<li class="start">
						<a href="#">
							<i class="icon-home"></i>
							<span class="title">首页</span>
						</a>
					</li>

					<li class="active ">
						<a class="active" href="javascript:;">
							<i class="icon-sitemap"></i>
							<span class="title">功能列表</span>
							<span class="arrow "></span>
						</a>

						<ul class="sub-menu">

							<li>
								<a href="javascript:;">
									课程管理
									<span class="arrow"></span>
								</a>
								<ul class="sub-menu">
									<li><a href="#">题库管理</a></li>
								</ul>
							</li>

							<li class="active">
								<a href="javascript:;">
									班级管理
									<span class="arrow"></span>
								</a>
								<ul class="sub-menu">
									<li><a href="#">学生管理</a></li>
								</ul>
							</li>

							<li>
								<a href="javascript:;">
									考试管理
									<span class="arrow"></span>
								</a>
								<ul class="sub-menu">
									<li><a href="#">学生成绩查看</a></li>
								</ul>
							</li>
						</ul>
					</li>

					<li class="last ">

						<a href="#">

						<i class="icon-bar-chart"></i>

						<span class="title">反馈</span>

						</a>

					</li>

				</ul>

				<!-- END SIDEBAR MENU -->

			</div>

			<!-- END SIDEBAR -->

			<!-- BEGIN PAGE -->

			<div class="page-content">

				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				<div id="portlet-config" class="modal hide">

					<div class="modal-header">

						<button data-dismiss="modal" class="close" type="button"></button>

						<h3>portlet Settings</h3>

					</div>

					<div class="modal-body">

						<p>Here will be a configuration form</p>

					</div>

				</div>

				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				<!-- BEGIN PAGE CONTAINER-->

				<div class="container-fluid">

					<!-- BEGIN PAGE HEADER-->

					<div class="row-fluid">
						<div class="span12">
							<div class="color-panel hidden-phone">
								<div class="color-mode-icons icon-color"></div>
								<div class="color-mode-icons icon-color-close"></div>
								<div class="color-mode">
									<p>更换颜色</p>
									<ul class="inline">
										<li class="color-black current color-default" data-style="default"></li>
										<li class="color-blue" data-style="blue"></li>
										<li class="color-brown" data-style="brown"></li>
										<li class="color-purple" data-style="purple"></li>
										<li class="color-grey" data-style="grey"></li>
										<li class="color-white color-light" data-style="light"></li>
									</ul>
								</div>
							</div>

							<h3 class="page-title">
								教师管理功能
							</h3>

							<ul class="breadcrumb">
								<li>
									<i class="icon-home"></i>
									<a href="#">主页</a>
									<i class="icon-angle-right"></i>
								</li>

								<li>
									<a href="#">班级管理</a>
									<i class="icon-angle-right"></i>
								</li>
								<li><a href="#">班级查看</a></li>

							</ul>
						</div>
					</div>

					<div class="row-fluid">
						<div class="span12">
							<div class="portlet box purple">
								<div class="portlet-title">
									<div class="caption"><i class="icon-reorder"></i>班级管理</div>
									<div class="tools">
										<a href="javascript:;" class="collapse"></a>
										<a href="javascript:;" class="remove"></a>
									</div>

								</div>

								<div class="portlet-body">
                                    <div class="row-fluid">

                                        <div class="clearfix space5"></div>
                                        <a href="uploadGrade.jsp" class="btn pull-right green"><i class="icon-plus"></i> 添加班级</a>

                                    </div>
                                    <hr class="clearfix" />
                                    <%
                                        for(int i = 0; i <= grades.size() / 4; ++i) {
                                    %>

                                    <div class="row-fluid">
                                        <%
                                            int max;
                                            if(i == grades.size() / 4) {
                                                max = grades.size() % 4;
                                            } else {
                                                max = 4;
                                            }
                                            for(int j = 0; j < max; ++j) {
                                                Grade grade = grades.get(i*4+j);
                                        %>
                                        <div class="span3">
                                            <div class="item">
                                                <div class="zoom">
                                                    <div class="classbackground" onclick="window.location.href='showGradeInfo.do?gradeID=<%=grade.getGradeID()%>&type=show'" >
                                                        <div class="textshow">
                                                            <h3><%=grade.getGradeName()%></h3>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="details">
                                                    <a href="showGradeInfo.do?gradeID=<%=grade.getGradeID()%>&type=update" class="icon"><i class="icon-pencil"></i></a>
                                                    <a href="deleteGrade.do?gradeID=<%=grade.getGradeID()%>" class="icon"><i class="icon-remove"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                            }

                                        %>
                                    </div>

                                    <%
                                        }
                                    %>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="footer">
			<div class="footer-inner">
				2017 &copy; Metronic by keenthemes.Collect from
				<a href="#" >Model</a>
				- More Templates <a href="#" >Model</a>
			</div>

			<div class="footer-tools">
				<span class="go-top">
				<i class="icon-angle-up"></i>
				</span>
			</div>
		</div>

		<script src="../media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
		<script src="../media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
		<script src="../media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
		<script src="../media/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="../media/js/excanvas.min.js"></script>
		<script src="../media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
		<script src="../media/js/jquery.blockui.min.js" type="text/javascript"></script>
		<script src="../media/js/jquery.cookie.min.js" type="text/javascript"></script>
		<script src="../media/js/jquery.uniform.min.js" type="text/javascript" ></script>
		<script src="../media/js/jquery.fancybox.pack.js"></script>
		<script type="text/javascript" src="../media/js/chosen.jquery.min.js"></script>
		<script src="../media/js/app.js"></script>
		<script src="../media/js/gallery.js"></script>
		<script>
			jQuery(document).ready(function() {
			   App.init();
			   Gallery.init();
			});
		</script>
	</body>
</html>