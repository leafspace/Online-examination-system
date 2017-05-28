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

                                <li class="active">
                                    <a href="showExamList.do">考试首页</a>
                                </li>

                                <li>
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
                                    <div class="caption"><i class="icon-reorder"></i>参加考试</div>
                                    <div class="tools">
                                        <a href="javascript:;" class="collapse"></a>
                                        <a href="javascript:;" class="remove"></a>
                                    </div>
                                </div>

                                <div class="portlet-body form">
                                    <div style="width:80%; font-size:16px; margin-top:20px; margin-bottom:20px; margin-left: 10%; margin-right: 10%">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考试是对学习情况的综合检测，不仅是一场文化知识的考试，更是一场道德品质的检测。创造公平、公正的考试环境是我们共同的责任。用实际行动维护考试的公平、公正，是我们每一位学生的义务。我们应该用诚信的考试构筑诚实的人生。让我们牢记“诚实为人、诚信考试”，努力营造公平、公正的考试环境!
                                        <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        本人将严格遵守《常熟理工学院学生考试管理办法》：<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        一.自觉遵守考场规定，不出现以下违纪情况：<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        1.携带规定以外的物品进入考场，未放在指定位置，且不听监考人员劝告;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        2.不按指定位置就坐，不听从监考人员调动;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        3.考试开始信号发出前答题或者考试结束信号发出后继续答题;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        4.在考场喧哗、吸烟或者实施其他影响考场秩序的行为;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        5.未经监考人员同意在考试过程中擅自进出、离开考场;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        6.擅自将试卷、答卷(含答题纸、答题卡等，下同)、草稿纸等考试用纸带出考场;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        7.用规定以外的笔或者纸答题或者在试卷规定以外的地方书写姓名、考号或者以其他方式在答卷上标记信息;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        8.其他违反考场规则但尚未构成作弊的行为。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        二.不出现以下考试作弊现象：<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        1.携带规定以外的与考试内容相关的材料的;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        2.抄袭或者协助他人抄袭试题答案或者与考试内容相关的资料的;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        3.故意销毁试卷、答卷、物证或者考试材料的;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        4.在答卷上填写与本人身份不符的姓名、考号(学号)等信息的;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        5.交换试卷、答卷、草稿纸的;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        6.评卷过程中被发现同一科目同一考场有两份以上(含两份)答卷答案雷同的;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        7.因保管不善等原因造成试卷、答题纸及草稿纸等物品在考试过程中或交卷时被他人利用，视为双方作弊;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        8.请他人代考或代他人考试;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        9.涂改他人试卷姓名占为己有;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        10.组织、参与团伙作弊;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        11.抢夺、窃取他人试卷、答卷或者强迫他人为自己抄袭提供方便的;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        我承诺在考试过程中自觉遵守，诚信考试，绝不作弊。若有违反考场规则有关规定，则自愿接受有关规定的处理。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </div>
                                    <form action="attendExam.do" class="form-horizontal">
                                        <div class="control-group">
                                            <label class="control-label">考试列表</label>
                                            <div class="controls">
                                                <select class="span6 m-wrap" data-placeholder="选择一个考试" tabindex="1" name="examID">
                                                    <%
                                                        for(Exam exam : noAttendExams) {
                                                    %>
                                                            <option value="<%=exam.examID%>"><%=exam.examName%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-actions">
                                            <button type="submit" class="btn blue">参加</button>
                                            <button type="button" class="btn" onclick="window.location.href='index.jsp'">退出</button>
                                        </div>
                                    </form>
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
    </body>
</html>