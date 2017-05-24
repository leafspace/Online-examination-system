<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />
		<title>在线考试系统 | 登陆</title>
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

		<link href="media/css/login-soft.css" rel="stylesheet" type="text/css"/>
		<link rel="shortcut icon" href="media/image/laboratory.ico" />
	</head>

	<body class="login">
		<div class="logo">
			<h3 style="color: #fff">在线考试系统</h3>
		</div>

		<div class="content">
			<form class="form-vertical login-form" action="/login.do" method="post">
				<logic:notEmpty name="error">
					<div class="alert alert-error hide" style="display: block;">
						<button class="close" data-dismiss="alert"></button>
						<span><bean:write name="error" /></span>
					</div>
				</logic:notEmpty>
				<h3 class="form-title">登陆你的账户</h3>

				<div class="alert alert-error hide">
					<button class="close" data-dismiss="alert"></button>
					<span>请输入用户名或密码.</span>
				</div>

				<div class="control-group">
					<label class="control-label visible-ie8 visible-ie9">用户名</label>
					<div class="controls">
						<div class="input-icon left">
							<i class="icon-user"></i>
							<input class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="username"
							<logic:notEmpty name="username">value="<bean:write name="username" />"</logic:notEmpty> />
						</div>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label visible-ie8 visible-ie9">密码</label>
					<div class="controls">
						<div class="input-icon left">
							<i class="icon-lock"></i>
							<input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password"/>
						</div>
					</div>
				</div>

				<div class="form-actions">
					<label class="checkbox">
					<input type="checkbox" name="remember" value="on"/> 请记住我
					</label>
					<button type="submit" class="btn blue pull-right">
					登陆 <i class="m-icon-swapright m-icon-white"></i>
					</button>
				</div>

				<div class="forget-password">
					<h4>忘记密码 ?</h4>
					<p>
						别担心, 点击 <a href="javascript:;" class="" id="forget-password" onclick="resetPassword()">这里</a>
						来重置你的密码。
					</p>
				</div>

				<div class="create-account">
					<p>
						账号登陆失败 ?&nbsp;
						<a href="#"  class="">联系管理员</a>
					</p>
				</div>
			</form>

			<form class="form-vertical forget-form" action="/sendEmail.do" method="post">
				<h3 class="">忘记密码 ?</h3>
				<p>输入你的校园邮箱来重置密码.</p>
				<div class="control-group">
					<div class="controls">
						<div class="input-icon left">
							<i class="icon-envelope"></i>
							<input class="m-wrap placeholder-no-fix" type="text" placeholder="test@example.com" name="eMail" />
						</div>
					</div>
				</div>

				<div class="form-actions">
					<button type="button" id="back-btn" class="btn" onclick="backLogin()">
					<i class="m-icon-swapleft"></i> 返回
					</button>
					<button type="submit" class="btn blue pull-right">
					提交 <i class="m-icon-swapright m-icon-white"></i>
					</button>
				</div>
			</form>
		</div>

		<div class="copyright">
			2017 &copy; Metronic - Admin Dashboard Template.
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
		<script src="media/js/jquery.validate.min.js" type="text/javascript"></script>
		<script src="media/js/jquery.backstretch.min.js" type="text/javascript"></script>
		<script src="media/js/app.js" type="text/javascript"></script>
		<script src="media/js/login-soft.js" type="text/javascript"></script>

		<script>
			jQuery(document).ready(function() {
			  App.init();
			  Login.init();
			});

            function resetPassword() {
                jQuery('.login-form').hide();
                jQuery('.forget-form').show();
            }

            function backLogin() {
                jQuery('.login-form').show();
                jQuery('.forget-form').hide();
            }
		</script>
		</body>
</html>