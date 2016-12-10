<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jspf/import.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta name="robots" content="noarchive" />
    
    <title>
    注册帐号 - ${requestScope.systemName }
</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="apple-touch-icon" sizes="180x180" href="/img/180x180.png" />
    <link rel="icon" sizes="192x192" href="/img/192x192.png" />
    <!--[if lt IE 7]>
    <link href="/content/css/ie6.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <script src="/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="/js/jscript.js" type="text/javascript"></script>
    
    
<meta content="注册帐号使用IPv6VPN的服务。IPv6VPN是基于OpenVPN、利用IPv6访问全球v4网络的解决方案，适合拥有IPv6网络环境的高校学生、教师和科研单位。" name="description" />
<meta content="注册,帐号,IPv6,VPN,EDU,教育网,OpenVPN,PPTP" name="keywords" />
    <script type="text/javascript">
        var userExists = false;
        var inValidUserName = false;
        var tryLater = false;

        
        function checkUserName() {
            inValidUserName = true;
            $('#error_u').text('');
            var u = $('#UserName').val();
            if (u.length <= 1 || u.length > 10) {
                $('#error_u').text('长度须为2-10位');
                return;
            }
            inValidUserName = false;
            userExists = false;
            tryLater = false;
            $.post('${root}/user/checkusername.do', { "userName" : u }, function (data) {
                if (data == '1') {
                    userExists = true;
                    $('#error_u').text('该用户名已注册');
                }
                else if (data == '2') {
                    inValidUserName = true;
                    $('#error_u').text('格式不正确');
                }
                else if (data == '3') {
                    tryLater = true;
                    $('#error_u').text('请稍后再试');
                }
                else { $('#error_u').text('用户名可用'); }
            });
        }
        var inValidPassword =false;
        function checkPassword() {
        	$('#error_p').text('');
        	var p = $('#Password').val();
        	var pattern = /^[a-zA-Z0-9_]{6,12}$/;
        	
        	inValidPassword =false;
        	if (!pattern.test(p)) {
        		inValidPassword = true;
        		$('#error_p').text('密码格式不正确');
            }else{
            	$('#error_p').text('密码格式正确');
            }
        }
        var inValidEmail = false;
        function checkEmail() {
        	$('#error_e').text('');
        	var p = $('#Email').val();
        	var pattern = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
        	
        	inValidEmail = false;
        	if (!pattern.test(p)) {
        		inValidEmail = true;
        		$('#error_e').text('邮箱格式不正确');
            }else{
            	$('#error_e').text('邮箱格式正确');
            }
        }
        
        function checkRePassword() {
        	if ($('#ConfirmPassword').val() != $('#Password').val()) { 
        		$('#error_rp').text('密码不一致');
        	}else{
        		$('#error_rp').text('密码一致');
        	}
        }

        function submitCheck() {
            clearErrors();

            if ($('#UserName').val() == '') { addError('请输入用户名'); return false; }
            if (inValidUserName) { addError('用户名格式不正确'); return false; }
            if (userExists) { addError('该用户名已注册'); return false; }
            if (tryLater) { addError('请稍后再试'); return false; }
            if ($('#Password').val() == '') { addError('请输入密码'); return false; }
            if (inValidPassword) { $('#error_p').text('密码格式不正确'); return false; }
            if ($('#ConfirmPassword').val() != $('#Password').val()) { addError('两次输入的密码不一致'); return false; }
            if ($('#Email').val() == '') { addError('请输入常用邮箱'); return false; }
            if (inValidEmail) { $('#error_e').text('邮箱格式不正确'); return false; }
            return true;
        }
        function submit() {
            if (!submitCheck()) return;
            document.getElementById('signupform').submit();
            $(".box_btn a").attr('href', 'javascript:void(null)');
        }
        function clearFields() {
            var key = $('#signup_step2 input').first().val();
            $('#signup_step2 input').val('');
            $('#signup_step2 input').first().val(key);
        }

    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#wrapper").append("<script type=\"text/javascript\">window.scrollTo(0, 230);<\/script>");
        });
    </script>

</head>

<body>

<div id="wrapper">
	<!-- #header -->
	<c:import url="/include/menu.jsp"></c:import>
	<script type="text/javascript">
		document.getElementById("register").setAttribute('class','current_page_item');
	</script>
	<!-- #header -->
	<div id="contents" class="clearfix">
		<div id="left_col">
            
                    <div id="box">
                        <h1 class="box_title">注册帐号 Sign Up</h1>
                        <div>
	                        <div id="box_top"></div>
	                        <div id="box_body">
                            
                    <form action="${requestScope.root }/user/register.do" id="signupform" method="post">
                    <div id="box_img_s">
                        
                        <img src="/img/box_img.png" alt="" />
                        
                    </div>
					<div id="box_content">
                        <div id="signup_step2">
						<div style="margin-top: 40px;">
							<div class="field-validation-error" id="validationSummary" style="height:18px;margin-left:48px;">
								${requestScope.msg }
							</div><br/>
							<label for="UserName">用户名</label><input id="UserName" name="UserName" onchange="javascript:checkUserName('')" type="text" value="" /><span id="error_u">字母开头，2-10位</span><br/>
							<label for="Password">密码</label><input id="Password" name="Password" type="password"  onchange="javascript:checkPassword('')"/><span id="error_p">6-12位</span><br/>
							<label for="ConfirmPassword">确认密码</label><input id="ConfirmPassword" name="ConfirmPassword" type="password" onchange="javascript:checkRePassword('')"/><span id="error_rp"></span><br/>
							<label for="Email">常用邮箱</label><input id="Email" name="Email" type="text" value="" onchange="javascript:checkEmail('')"/><span id="error_e">用于接收服务通知</span><br/>
						</div>

						<div class="box_btn" style="margin-left:48px;">
							<a class="box_btn_s" href="javascript:submit();">提交</a>
							<a class="box_btn_c" href="javascript:clearFields();">清空</a>
						</div>
                        </div>
                    </div>
                    <div class="clear"></div>
                    </form>
	                        </div>
	                        <div id="box_bottom"></div>
                        </div>
                        
                    </div>

		</div>
		<!-- END #left_col -->
		<c:import url="/include/right.jsp"></c:import>
		<!-- END #right_col -->
	</div>
	<!-- END #contents -->
	<c:import url="/include/footer.jsp"></c:import>
	<!-- END #footer -->
</div>
<!-- END #wrapper -->
</body>

</html>
