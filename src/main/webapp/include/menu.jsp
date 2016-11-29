<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jspf/import.jsp" %>
<div id="header">
		<div id="logo">
			<a id="logo_text" href="/">Labview.help</a>
			<div id="description">.</div>
		</div>
		<div id="header_meta" >
			<div id="header_search_area">
				<form id="searchform" action="#" method="get">
					<div>
						<input id="search_input" name="s" onfocus="this.value=''; changefc('#333');" type="text" value="Search" /></div>
					<div>
						<input id="search_button" alt="Search from this blog." src="/img/search_button.gif" title="Search from this blog." type="image" /></div>
				</form>
			</div>
<!-- JiaThis Button BEGIN -->

<div class="jiathis_style_32x32" style="position: relative;float: left;">
	<a class="jiathis_button_tsina"></a>
	<a class="jiathis_button_weixin"></a>
	<a class="jiathis_button_douban"></a>
	<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
</div>
<script type="text/javascript" src="http://v3.jiathis.com/code_mini/jia.js" charset="utf-8"></script>
<!-- JiaThis Button END -->
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