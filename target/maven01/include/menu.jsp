<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jspf/import.jsp" %>

<%
User user = (User)request.getSession().getAttribute("currentUser");
pageContext.setAttribute("user", user);
%>
<div id="header">
		<div id="logo">
			<a id="logo_text" href="/">Labview.help</a>
			<div id="description">键盘上，指尖的舞蹈；字母中，跳跃的音符！</div>
		</div>
		<div id="header_meta" >
			<div id="header_search_area">
					<div id="face">
						<img alt="face" src="/img/face.jpg" width="60px" class="face_pic">
					</div>
					<div id="face_tips">
						<c:choose>
							<c:when test="${!empty user }">
								<a>欢迎:${user.username }</a>
							</c:when>
							<c:otherwise>
								<a>你还没登陆哦！</a>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="tips">
						<c:choose>
							<c:when test="${!empty user }">
								<a href="${root }/user/out.do" title="退出登录">退出登录</a>
							</c:when>
							<c:otherwise>
								<a href="${root }/login.jsp" title="登录">登录</a>&nbsp;&nbsp;
								<a href="${root }/register.jsp" title="注册">注册</a>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="jiathis_style" style="position: relative;float: left;right: 150px;width: 380px;/*!  */bottom: 3px;">
						<span class="jiathis_txt">分享到：</span>
						<a class="jiathis_button_tsina">新浪微博</a>
						<a class="jiathis_button_weixin">微信</a>
						<a class="jiathis_button_cqq">QQ好友</a>
						<a class="jiathis_button_fav">收藏夹</a>
						<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank">更多</a>
					</div>
					<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
			</div>

		</div>
		
		
            <!-- END #header_meta -->
            <div class="header_menu">
	            <ul id="menu" class="menu">
		            <li id="index"><a href="/">首页</a></li>
                    <li id="service"><a href="${root }/service.jsp">解密服务</a>
		            <li id="register"><a href="${root }/register.jsp">注册账号</a></li>
		            <li id="guide"><a href="${root }/guide.jsp">使用指南</a>
		            <li id="login"><a href="${root }/login.jsp">我的账号</a></li>
	            </ul>
            </div>
            <!-- END #header_menu -->
	</div>