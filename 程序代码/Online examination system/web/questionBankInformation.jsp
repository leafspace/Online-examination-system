<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Teacher" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Question" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.QuestionBank" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <title>在线考试系统 | 教师管理页 - 题库管理</title>
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
        <link href="media/css/jquery.fancybox.css" rel="stylesheet" />
        <link href="media/css/chosen.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="media/image/laboratory.ico" />
    </head>
    <%
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        QuestionBank questionBank = (QuestionBank) request.getAttribute("questionBank");
        ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
    %>

    <body class="page-header-fixed">
    <div class="header navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="brand" href="index.jsp"><img src="media/image/logo.png" alt="logo" /></a>

                <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                    <img src="media/image/menu-toggler.png" alt="" />
                </a>

                <ul class="nav pull-right">
                    <li class="dropdown user">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img alt="" src="media/image/avatar1_small.jpg" />
                            <span class="username"><%=teacher.getUserName()%></span>
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
                            <input type="button" class="submit" />
                        </div>
                    </form>
                </li>

                <li class="start">
                    <a href="showCourse.do">
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
                                <li><a href="showCourse.do">查看课程</a></li>
                                <li><a href="courseInformation.jsp?type=add">添加课程</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="javascript:;">
                                班级管理
                                <span class="arrow"></span>
                            </a>
                            <ul class="sub-menu">
                                <li><a href="showGrade.do">查看班级</a></li>
                                <li><a href="uploadGrade.jsp">添加班级</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="javascript:;">
                                考试管理
                                <span class="arrow"></span>
                            </a>
                            <ul class="sub-menu">
                                <li><a href="showExam.do">查看考试</a></li>
                                <li><a href="uploadExam.jsp">添加考试</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>

                <li class="last ">
                    <a href="showContact.do">
                        <i class="icon-bar-chart"></i>
                        <span class="title">反馈</span>
                    </a>
                </li>
            </ul>
        </div>

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
                                <a href="showCourse.do">主页</a>
                                <span class="icon-angle-right"></span>
                            </li>
                            <li>
                                <a href="#">题库管理</a>
                                <span class="icon-angle-right"></span>
                            </li>
                            <li><a href="#">查看题库</a></li>
                        </ul>
                    </div>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                        <div class="portlet box blue tabbable">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="icon-reorder"></i>
                                    <span class="hidden-480">查看题库</span>
                                </div>
                            </div>

                            <div class="portlet-body form">
                                <div class="tabbable portlet-tabs">
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a href="#portlet_tab1" data-toggle="tab">默认</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="portlet_tab1">
                                            <form class="form-horizontal" action="" method="post">
                                                <input type="hidden" name="type" value="" >
                                                <div class="control-group">
                                                    <label class="control-label">题库名</label>
                                                    <div class="controls">
                                                        <input type="text" class="m-wrap huge" name="questionBankName" readonly="readonly" value="<%=questionBank.getQuestionBankName()%>" />
                                                    </div>
                                                </div>

                                                <div class="control-group">
                                                    <div id="tab_1" class="tab-pane active">
                                                        <div style="height: auto;" id="accordion1" class="accordion in collapse">
                                                            <%
                                                                for(int i = 0; i < questions.size(); ++i) {
                                                            %>
                                                            <div class="accordion-group">
                                                                <div class="accordion-heading">
                                                                    <a href="#collapse_<%=i%>" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle collapsed">
                                                                        问题<%=i+1%>&nbsp(ID:<%=questions.get(i).getQuestionID()%>)&nbsp:&nbsp<%=questions.get(i).question%>
                                                                    </a>
                                                                </div>

                                                                <div class="accordion-body collapse" id="collapse_<%=i%>" >
                                                                    <div class="accordion-inner">
                                                                        <table class="table table-striped table-hover">
                                                                            <thead>
                                                                            <tr>
                                                                                <th>问题</th>
                                                                                <th>类型</th>
                                                                                <th>A选项</th>
                                                                                <th>B选项</th>
                                                                                <th>C选项</th>
                                                                                <th>D选项</th>
                                                                                <th>E选项</th>
                                                                                <th>回答</th>
                                                                            </tr>
                                                                            </thead>
                                                                            <tbody>

                                                                            <tr>
                                                                                <td><%=questions.get(i).question%></td>
                                                                                <td>
                                                                                    <%=questions.get(i).getQuestionType().equals("Judge")?"判断":questions.get(i).getQuestionType().equals("MoreChoice")?"多选":"单选"%>
                                                                                </td>
                                                                                <td><%=questions.get(i).A%></td>
                                                                                <td><%=questions.get(i).B%></td>
                                                                                <td><%=questions.get(i).C%></td>
                                                                                <td><%=questions.get(i).D%></td>
                                                                                <td><%=questions.get(i).E%></td>
                                                                                <td><%=questions.get(i).answer%></td>
                                                                            </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <%
                                                                }
                                                            %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
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

    <script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
    <script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
    <script src="media/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="media/js/excanvas.min.js"></script>
    <script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
    <script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>
    <script src="media/js/jquery.fancybox.pack.js"></script>
    <script type="text/javascript" src="media/js/chosen.jquery.min.js"></script>
    <script src="media/js/app.js"></script>
    <script src="media/js/gallery.js"></script>
    <script>
        jQuery(document).ready(function() {
            App.init();
            Gallery.init();
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