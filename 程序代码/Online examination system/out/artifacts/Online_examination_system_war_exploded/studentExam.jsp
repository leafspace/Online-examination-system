<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Question" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Student" %>
<%@ page import="cn.cslg.Online_examination_system.ToolBean.Exam" %>
<%@ page import="java.text.SimpleDateFormat" %>

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
        <style>
            #nav { width:150px; height: 80px; border: 1px solid #D4CD49; background-color: #ABF3CB; position:fixed; right:0; top:30% }
        </style>
    </head>
    <%
        Date finishDate = (Date) request.getSession().getAttribute("finishDate");
        Exam exam = (Exam) request.getSession().getAttribute("exam");
        Student student = (Student) request.getSession().getAttribute("user");
        ArrayList<Question> oneChoicePapar = (ArrayList<Question>) request.getSession().getAttribute("oneChoicePapar");
        ArrayList<Question> moreChoicePapar = (ArrayList<Question>) request.getSession().getAttribute("moreChoicePapar");
        ArrayList<Question> judgePapar = (ArrayList<Question>) request.getSession().getAttribute("judgePapar");

        String finishTime = new SimpleDateFormat("HH:mm:ss").format(finishDate);
    %>
    <body class="page-header-fixed page-full-width">
        <div id="nav">
            <div style="width: 100%; height: 50%; font-size:14px; text-align: center;">
                考试剩余时间
            </div>
            <div id="clock" style="width: 100%; height: 50%; font-size:14px; text-align: center;">
            </div>
        </div>
        <div class="header navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="brand" href="#">
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
                                    <a href="#">考试中</a>
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
                                    <div class="caption"><i class="icon-reorder"></i>答题</div>
                                    <div class="tools">
                                        <a href="javascript:;" class="collapse"></a>
                                        <a href="javascript:;" class="remove"></a>
                                    </div>
                                </div>

                                <div class="portlet-body form">
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="portlet_tab1">
                                            <form action="sendPapar.do" class="form-horizontal" name="examPapar" method="post">
                                                <%
                                                    for(int i = 0; i < oneChoicePapar.size(); ++i) {
                                                        Question question = oneChoicePapar.get(i);
                                                        int[] randomNumber = student.randomOptions("OneChoice");
                                                %>
                                                        <div class="control-group">
                                                            <div class="controls">
                                                                <label class="" style="float: inherit; text-align: left;"><%=i+1%>.(单选题)<%=question.question%></label>
                                                                <%
                                                                    for(int j = 0; j < randomNumber.length; ++j) {
                                                                        char value = (char) ('A' + randomNumber[j] - 1);
                                                                        String questionStr = "";
                                                                        switch (value)
                                                                        {
                                                                            case 'A' : questionStr = question.A; break;
                                                                            case 'B' : questionStr = question.B; break;
                                                                            case 'C' : questionStr = question.C; break;
                                                                            case 'D' : questionStr = question.D; break;
                                                                            default: break;
                                                                        }
                                                                        questionStr = ((char)('A' + j)) + "." + questionStr;
                                                                %>
                                                                        <label class="radio line"><div class="radio"><span><input type="radio" name="oneChoice<%=question.getQuestionID()%>" value="<%=value%>"></span></div><%=questionStr%></label>
                                                                <%
                                                                    }
                                                                %>
                                                            </div>
                                                        </div>

                                                        <hr class="line">
                                                <%
                                                    }
                                                %>

                                                <%
                                                    for(int i = 0; i < moreChoicePapar.size(); ++i) {
                                                        Question question = moreChoicePapar.get(i);
                                                        int[] randomNumber = student.randomOptions("MoreChoice");
                                                %>
                                                        <div class="control-group">
                                                            <div class="controls">
                                                                <label class="" style="float: inherit; text-align: left;"><%=i+1%>.(多选题)<%=question.question%></label>
                                                                <%
                                                                    for(int j = 0; j < randomNumber.length; ++j) {
                                                                        char value = (char) ('A' + randomNumber[j] - 1);
                                                                        String questionStr = "";
                                                                        switch (value)
                                                                        {
                                                                            case 'A' : questionStr = question.A; break;
                                                                            case 'B' : questionStr = question.B; break;
                                                                            case 'C' : questionStr = question.C; break;
                                                                            case 'D' : questionStr = question.D; break;
                                                                            case 'E' : questionStr = question.E; break;
                                                                            default: break;
                                                                        }
                                                                        questionStr = ((char)('A' + j)) + "." + questionStr;
                                                                %>
                                                                <label class="checkbox line"><div class="checkbox" style="float: left;"><span class=""><input type="checkbox" name="moreChoice<%=question.getQuestionID()%>" value="<%=value%>"></span></div> <%=questionStr%></label>
                                                                <%
                                                                    }
                                                                %>
                                                            </div>
                                                        </div>

                                                        <hr class="line">
                                                <%
                                                    }
                                                %>

                                                <%
                                                    for(int i = 0; i < judgePapar.size(); ++i) {
                                                        Question question = judgePapar.get(i);
                                                %>
                                                        <div class="control-group">
                                                            <div class="controls">
                                                                <label class="" style="float: inherit; text-align: left;"><%=i+1%>.(判断题)<%=question.question%></label>
                                                                <label class="radio line"><div class="radio"><span><input type="radio" name="judge<%=question.getQuestionID()%>" value="对"></span></div>对</label>
                                                                <label class="radio line"><div class="radio"><span><input type="radio" name="judge<%=question.getQuestionID()%>" value="错"></span></div>错</label>
                                                            </div>
                                                        </div>

                                                        <hr class="line">
                                                <%
                                                    }
                                                %>

                                                <div class="form-actions">
                                                    <button type="submit" class="btn blue"><i class="icon-ok"></i> 提交</button>
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

        <script>
            var hourtime = "<%=finishTime%>";
            var endTime = new Date(new Date().toLocaleDateString()+" "+ hourtime);

            function displayTime() {
                var elt = document.getElementById("clock");
                var now = new Date();
                var leftTime = endTime.getTime() - now.getTime();
                if(leftTime < 0) {
                    elt.innerHTML = "Over";
                    submitPapar();
                } else {
                    leftTime = parseInt(leftTime / 1000);
                    var o = Math.floor(leftTime / 3600);
                    var m = Math.floor(leftTime / 60 % 60);
                    var s = leftTime % 60;
                    elt.innerHTML = o + "小时:" + m + "分:" + s + "秒";
                    setTimeout(displayTime, 100);
                }
            }
            displayTime();
        </script>
    </body>
</html>