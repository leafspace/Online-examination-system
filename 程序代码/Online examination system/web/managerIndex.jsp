<%@ page import="cn.cslg.Online_examination_system.ToolBean.Manager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Teacher" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>管理员控制台</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/animate.min.css" rel="stylesheet"/>
        <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>
        <link href="assets/css/demo.css" rel="stylesheet" />
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/themify-icons.css" rel="stylesheet">
    </head>
    <%
        Manager manager = (Manager) request.getSession().getAttribute("user");
        ArrayList<Teacher> teachers = (ArrayList<Teacher>) request.getAttribute("teachers");
    %>
    <body>
        <div class="wrapper">
            <div class="sidebar" data-background-color="white" data-active-color="danger">
                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="#" class="simple-text">
                            功能菜单
                        </a>
                    </div>

                    <ul class="nav">
                        <li class="active">
                            <a href="managerIndex.jsp">
                                <i class="ti-view-list-alt"></i>
                                <p>管理列表</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="main-panel">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar bar1"></span>
                                <span class="icon-bar bar2"></span>
                                <span class="icon-bar bar3"></span>
                            </button>
                            <a class="navbar-brand" href="#">教师列表</a>
                        </div>
                        <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="uploadTeacher.jsp" class="dropdown-toggle" >
                                        <i class="ti-plus"></i>
                                        <p>添加教师</p>
                                    </a>
                                </li>
                            </ul>
                    </div>
                </nav>

                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card card-plain">
                                    <div class="header">
                                        <h4 class="title">您可控的教师列表</h4>
                                        <p class="category">试试看管理操作</p>
                                    </div>
                                    <div class="content table-responsive table-full-width">
                                        <table class="table table-hover">
                                            <thead>
                                                <th>ID</th>
                                                <th>姓名</th>
                                                <th>密码</th>
                                                <th>身份</th>
                                                <th>管理操作</th>
                                            </thead>
                                            <tbody>
                                                <%
                                                    for(Teacher teacher : teachers) {
                                                %>
                                                        <tr>
                                                            <td><%=teacher.getUserID()%></td>
                                                            <td><%=teacher.getUserName()%></td>
                                                            <td><%=teacher.getPassword()%></td>
                                                            <td>教师</td>
                                                            <td><a href="dobeTeacher.do?userID=<%=teacher.getUserID()%>"><span class="ti-user"> 代替我</span></a></td>
                                                        </tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>

                <footer class="footer">
                    <div class="container-fluid">

                        <div class="copyright pull-right">
                            2017 &copy; Metronic by keenthemes.Collect from
                        <a href="#" >Model</a>
                        - More Templates <a href="#" >Model</a>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-checkbox-radio.js"></script>
	<script src="assets/js/chartist.min.js"></script>
    <script src="assets/js/bootstrap-notify.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>
	<script src="assets/js/paper-dashboard.js"></script>
	<script src="assets/js/demo.js"></script>
</html>
