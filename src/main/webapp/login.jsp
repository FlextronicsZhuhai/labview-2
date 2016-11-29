<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jspf/import.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta name="robots" content="noarchive" />
    
    <title>
    
	登入帐号 - Labview

</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="apple-touch-icon" sizes="180x180" href="/icon/180x180.png" />
    <link rel="icon" sizes="192x192" href="/icon/192x192.png" />
    <!--[if lt IE 7]>
    <link href="/css/ie6.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <script src="/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    
    <script src="/js/jscript.js" type="text/javascript"></script>
    
    
<meta content="登入labview.help，账号登陆、登陆管理源码文件。" name="description" />
<meta content="登入,labview,labview.help,源码解码,密码破解,开源免费" name="keywords" />
    <script type="text/javascript">
        function submitCheck() {
            $('#error_u').text('');
            $('#error_p').text('');
            if ($('#UserName').val() == '') {
                $('#error_u').text('请输入用户名');
                return false;
            }
            if ($('#Password').val() == '') {
                $('#error_p').text('请输入密码');
                return false;
            }
            return true;
        }
        function submit() {
            if (!submitCheck()) return;
            document.getElementById('signinform').submit();
            $(".box_btn a").attr('href', 'javascript:void(null)');
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
		document.getElementById("login").setAttribute('class','current_page_item');
	</script>
	<!-- #header -->
	<div id="contents" class="clearfix">
		<div id="left_col">
            
                    <div id="box">
                        <h1 class="box_title">登入帐号 Sign In</h1>
                        <div>
	                        <div id="box_top"></div>
	                        <div id="box_body">
                            
                    <div id="box_img"><img src="/img/box_img.png" alt="" /></div>
					<div id="box_content">
                    <form action="${requestScope.root }/user/login.do" id="signinform" method="post">
						<div style="margin-top: 60px;">
							<div class="field-validation-error" id="validationSummary" style="height:18px;margin-left:48px;">
								${requestScope.msg }
							</div><br/>
							<label for="UserName">用户名</label><input autofocus="autofocus" id="UserName" name="UserName" type="text" value="" /><span id="error_u"></span><br/>
							<label for="Password">密码</label><input id="Password" name="Password" onkeypress="if (event.keyCode==13) { submit(); }" type="password" /><span id="error_p"></span>
                            
						</div>
						<div class="box_btn" style="padding-left:24px;">
							<a class="box_btn_s" id="btn_signin" href="javascript:submit();">登入</a>
                            
                            <a id="box_btn_star" style="width:48px;text-decoration:none;" href="/account/signup">注册帐号</a>
                            
						</div>
                    </form>
                    </div>
                    <div class="clear"></div>

	                        </div>
	                        <div id="box_bottom"></div>
                        </div>
                        
                    </div>

		</div>
		<!-- END #left_col -->
		<div id="right_col">
            

			
		</div>
		<!-- END #right_col -->
	</div>
	<!-- END #contents -->
	<c:import url="/include/footer.jsp"></c:import>
	<!-- END #footer -->
</div>
<!-- END #wrapper -->
</body>

</html>
