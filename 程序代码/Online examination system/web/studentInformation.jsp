<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Exam" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Student" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.StudentScore" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
        <link rel="shortcut icon" href="media/image/laboratory.ico" />
    </head>
    <%
        Student student = (Student) request.getSession().getAttribute("user");
        ArrayList<Exam> exams = (ArrayList<Exam>) request.getAttribute("exams");
        ArrayList<Exam> noAttendExams = (ArrayList<Exam>) request.getAttribute("noAttendExams");
        ArrayList<StudentScore> studentScores = (ArrayList<StudentScore>) request.getAttribute("studentScores");
    %>
    <body class="page-header-fixed page-full-width">
        <div class="header navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="brand" href="index.jsp">
                        <img src="media/image/logo.png" alt="logo" />
                    </a>

                    <div class="navbar hor-menu hidden-phone hidden-tablet">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li class="visible-phone visible-tablet">
                                    <form class="sidebar-search">
                                        <div class="input-box">
                                            <a href="javascript:;" class="remove"></a>
                                            <input type="text" placeholder="Search..." />
                                            <input type="button" class="submit" value=" " />
                                        </div>
                                    </form>
                                </li>

                                <li>
                                    <a href="showExamList.do">考试首页</a>
                                </li>

                                <li class="active">
                                    <a href="showExamScore.do">查看过往成绩</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                        <img src="media/image/menu-toggler.png" alt="" />
                    </a>

                    <ul class="nav pull-right">
                        <li class="dropdown user">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img alt="" src="media/image/avatar1_small.jpg" />
                            <span class="username"><%=student.getUserName()%></span>
                            <i class="icon-angle-down"></i>
                            </a>

                            <ul class="dropdown-menu">
                                <li class="divider"></li>
                                <li><a href="index.jsp"><i class="icon-key"></i> 注销</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="page-container row-fluid" >
            <div class="page-content">
                <div id="portlet-config" class="modal hide">
                    <div class="modal-header">
                        <button data-dismiss="modal" class="close" type="button"></button>
                        <h3>portlet Settings</h3>
                    </div>
                    <div class="modal-body">
                        <p>Here will be a configuration form</p>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row-fluid" style="margin-top: 20px;">
                        <div class="span12">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption"><i class="icon-reorder"></i>成绩查看</div>
                                    <div class="tools">
                                        <a href="javascript:;" class="collapse"></a>
                                        <a href="javascript:;" class="remove"></a>
                                    </div>
                                </div>


                                <div class="portlet-body form">
                                    <table class="table table-striped table-bordered table-advance table-hover">
                                        <thead>
                                            <tr>
                                                <th><i class="icon-reorder"></i> 测试ID</th>
                                                <th class="hidden-phone"><i class="icon-sitemap"></i> 测试名</th>
                                                <th><i class="icon-bookmark"></i> 测试时间</th>
                                                <th><i class="icon-bookmark"></i> 总分</th>
                                                <th><i class="icon-bookmark"></i> 分数</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for(StudentScore studentScore : studentScores) {
                                                    Exam exam = student.queryExam(studentScore.getExamID());
                                                    double allScore = exam.onechoiceNumber * exam.onechoiceScore +
                                                            exam.morechoiceNumber * exam.morechoiceScore + exam.judgeNumber * exam.judgeScore;
                                                    double score = studentScore.getScore();
                                            %>
                                                    <tr>
                                                        <td><%=exam.examID%></td>
                                                        <td class="hidden-phone"><%=exam.examName%></td>
                                                        <td><%=exam.examTime%></td>
                                                        <td><%=allScore%></td>
                                                        <td><%=score%> </td>
                                                        <td>
                                                            <%
                                                                if(score >= allScore * 0.8) {
                                                            %>
                                                                    <span class="label label-success label-mini">良好</span>
                                                            <%
                                                                } else if(score >= allScore * 0.6) {
                                                            %>
                                                                    <span class="label label-warning label-mini">合格</span>
                                                            <%
                                                                } else {
                                                            %>
                                                                    <span class="label label-danger label-mini">不合格</span>
                                                            <%
                                                                }
                                                            %>
                                                        </td>
                                                    </tr>
                                            <%
                                                }
                                            %>
                                            <%
                                                for(Exam exam : noAttendExams) {
                                                    double allScore = exam.onechoiceNumber * exam.onechoiceScore +
                                                            exam.morechoiceNumber * exam.morechoiceScore + exam.judgeNumber * exam.judgeScore;
                                            %>
                                            <tr>
                                                <td><%=exam.examID%></td>
                                                <td class="hidden-phone"><%=exam.examName%></td>
                                                <td><%=exam.examTime%></td>
                                                <td><%=allScore%></td>
                                                <td>?</td>
                                                <td><span class="label label-success label-mini">未参加</span></td>
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
        <script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
        <script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
        <script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="media/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="media/js/excanvas.min.js"></script>
        <script src="media/js/respond.min.js"></script>
        <script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
        <script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>
        <script src="media/js/app.js"></script>
        <script>
            jQuery(document).ready(function() {
               App.init();
            });
        </script>
        <script language="javascript">
            //防止页面后退
            history.pushState(null, null, document.URL);
            window.addEventListener('popstate', function () {
                history.pushState(null, null, document.URL);
            });

            document.onkeydown = function() {
                if(event.keyCode==116) {
                    event.keyCode=0;
                    event.returnValue = false;
                }
            }

            document.oncontextmenu = function() {
                event.returnValue = false;
            }

            function submitPapar(){
                document.examPapar.submit();
            }

        </script>
    </body>
</html>