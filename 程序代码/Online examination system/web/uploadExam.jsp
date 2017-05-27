<%@ page import="cn.cslg.Online_examination_system.ToolBean.Teacher" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Question" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.QuestionBank" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Grade" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />
		<title>Metronic | Form Stuff - Form Components</title>
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
		<link rel="stylesheet" type="text/css" href="media/css/bootstrap-fileupload.css" />
		<link rel="stylesheet" type="text/css" href="media/css/jquery.gritter.css" />
		<link rel="stylesheet" type="text/css" href="media/css/chosen.css" />
		<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />
		<link rel="stylesheet" type="text/css" href="media/css/jquery.tagsinput.css" />
		<link rel="stylesheet" type="text/css" href="media/css/clockface.css" />
		<link rel="stylesheet" type="text/css" href="media/css/bootstrap-wysihtml5.css" />
		<link rel="stylesheet" type="text/css" href="media/css/datepicker.css" />
		<link rel="stylesheet" type="text/css" href="media/css/timepicker.css" />
		<link rel="stylesheet" type="text/css" href="media/css/colorpicker.css" />
		<link rel="stylesheet" type="text/css" href="media/css/bootstrap-toggle-buttons.css" />
		<link rel="stylesheet" type="text/css" href="media/css/daterangepicker.css" />
		<link rel="stylesheet" type="text/css" href="media/css/datetimepicker.css" />
		<link rel="stylesheet" type="text/css" href="media/css/multi-select-metro.css" />
		<link href="media/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
		<link rel="shortcut icon" href="media/image/favicon.ico" />
	</head>
    <%
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ArrayList<QuestionBank> questionBanks = teacher.queryAllQuestionBank();
        ArrayList<Grade> grades = teacher.queryAllGrade();
        pageContext.setAttribute("teacher", teacher);
        pageContext.setAttribute("questionBanks", questionBanks);
        pageContext.setAttribute("grades", grades);
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
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">
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
                                    <a href="showExam.do">主页</a>
                                    <span class="icon-angle-right"></span>
                                </li>
                                <li>
                                    <a href="#">考试管理</a>
                                    <span class="icon-angle-right"></span>
                                </li>
                                <li><a href="#">编辑考试</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="row-fluid">

                        <div class="span12">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption"><i class="icon-reorder"></i>添加考试</div>
                                    <div class="tools">
                                        <a href="javascript:;" class="collapse"></a>
                                        <a href="javascript:;" class="remove"></a>
                                    </div>
                                </div>
                                <div class="portlet-body form">
                                    <form action="addExam.do" class="form-horizontal" method="post">
                                        <div class="control-group">
                                            <label class="control-label">考试名</label>
                                            <div class="controls">
                                                <input type="text" class="span6 m-wrap" name="examName" />
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label">题库</label>
                                            <div class="controls">
                                                <select class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1" name="questionBankID">
                                                    <%
                                                        for(QuestionBank questionBank : questionBanks) {
                                                    %>
                                                            <option value="<%=questionBank.getQuestionBankID()%>"><%=questionBank.getQuestionBankName()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label">班级</label>
                                            <div class="controls">
                                                <select multiple="multiple" id="my_multi_select1" name="gradeIDs">
                                                    <%
                                                        for(Grade grade : grades) {
                                                    %>
                                                            <option value="<%=grade.getGradeID()%>"><%=grade.getGradeName()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label">考试日期</label>
                                            <div class="controls">
                                                <div class="input-append date date-picker" data-date="01/1/2017" data-date-format="dd/mm/yyyy" data-date-viewmode="years">
                                                    <input class="m-wrap m-ctrl-medium date-picker" readonly size="16" type="text" placeholder="请选择考试日期" name="examDate" value="" />
                                                    <span class="add-on"><i class="icon-calendar"></i></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label">考试时间</label>
                                            <div class="controls">
                                                <div class="input-append bootstrap-timepicker-component">
                                                    <input class="m-wrap m-ctrl-small timepicker-24" type="text" placeholder="请选择考试时间" name="examTime"/>
                                                    <span class="add-on"><i class="icon-time"></i></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <table style="width: 60%">
                                                <tr>
                                                    <td><label class="control-label">考试持续时间</label></td>
                                                    <td><input type="text" class="m-wrap" placeholder="单位（分钟）" name="examMinutes" /></td>
                                                    <td><label class="control-label">交卷限制时间</label></td>
                                                    <td><input type="text" class="m-wrap" placeholder="单位（分钟）" name="examStratMinutes" /></td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="control-group">
                                            <table style="width: 60%">
                                                <tr>
                                                    <td><label class="control-label">单选题数量</label></td>
                                                    <td><input type="text" class="m-wrap" name="oneChoiceNumber" /></td>
                                                    <td><label class="control-label">单选题分值</label></td>
                                                    <td><input type="text" class="m-wrap" name="oneChoiceScore" /></td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="control-group">
                                            <table style="width: 60%">
                                                <tr>
                                                    <td><label class="control-label">判断题数量</label></td>
                                                    <td><input type="text" class="m-wrap" name="judgeNumber" /></td>
                                                    <td><label class="control-label">判断题分值</label></td>
                                                    <td><input type="text" class="m-wrap" name="judgeScore" /></td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="control-group">
                                            <table style="width: 60%">
                                                <tr>
                                                    <td><label class="control-label">多选题</label></td>
                                                    <td><input type="text" class="m-wrap" name="moreChoiceNumber" /></td>
                                                    <td><label class="control-label">多选题分值</label></td>
                                                    <td><input type="text" class="m-wrap" name="moreChoiceScore" /></td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="form-actions">
                                            <button type="submit" class="btn blue">提交</button>
                                            <button type="button" class="btn" onclick="window.location.href='showExam.do'">取消</button>
                                        </div>

                                    </form>
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
        <script src="media/js/respond.min.js"></script>
        <script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
        <script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>
        <script type="text/javascript" src="media/js/ckeditor.js"></script>
        <script type="text/javascript" src="media/js/bootstrap-fileupload.js"></script>
        <script type="text/javascript" src="media/js/chosen.jquery.min.js"></script>
        <script type="text/javascript" src="media/js/select2.min.js"></script>
        <script type="text/javascript" src="media/js/wysihtml5-0.3.0.js"></script>
        <script type="text/javascript" src="media/js/bootstrap-wysihtml5.js"></script>
        <script type="text/javascript" src="media/js/jquery.tagsinput.min.js"></script>
        <script type="text/javascript" src="media/js/jquery.toggle.buttons.js"></script>
        <script type="text/javascript" src="media/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="media/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="media/js/clockface.js"></script>
        <script type="text/javascript" src="media/js/date.js"></script>
        <script type="text/javascript" src="media/js/daterangepicker.js"></script>
        <script type="text/javascript" src="media/js/bootstrap-colorpicker.js"></script>
        <script type="text/javascript" src="media/js/bootstrap-timepicker.js"></script>
        <script type="text/javascript" src="media/js/jquery.inputmask.bundle.min.js"></script>
        <script type="text/javascript" src="media/js/jquery.input-ip-address-control-1.0.min.js"></script>
        <script type="text/javascript" src="media/js/jquery.multi-select.js"></script>
        <script src="media/js/bootstrap-modal.js" type="text/javascript" ></script>
        <script src="media/js/bootstrap-modalmanager.js" type="text/javascript" ></script>
        <script src="media/js/app.js"></script>
        <script src="media/js/form-components.js"></script>
        <script>
            jQuery(document).ready(function() {
               App.init();
               FormComponents.init();
            });
        </script>
    </body>
</html>