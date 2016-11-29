<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jspf/import.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta name="robots" content="noarchive" />
    
    <title>
	OpenVPN for Windows - IPv6VPN
</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="apple-touch-icon" sizes="180x180" href="/icon/180x180.png" />
    <link rel="icon" sizes="192x192" href="/icon/192x192.png" />
    <!--[if lt IE 7]>
    <link href="/css/ie6.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <script src="/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    
    <script src="/js/jscript.js" type="text/javascript"></script>
    
<meta content="OpenVPN,Win,Windows,IPv6,VPN" name="keywords" />

</head>

<body>

<div id="wrapper">
	<!-- #header -->
	<c:import url="/include/menu.jsp"></c:import>
	<script type="text/javascript">
		document.getElementById("guide").setAttribute('class','current_page_item');
	</script>
	<!-- #header -->
	<div id="contents" class="clearfix">
		<div id="left_col">
            

<div class="post">
    <h2 class="post_title">OpenVPN for Windows</h2>
    <ul class="post_info">
        <li>Last Updated: Oct 10, 2016</li>
    </ul>
    <div class="post_content">
        <p><b>提示:&nbsp;&nbsp;</b>OpenVPN 适合在已接入 IPv6 网络的高校范围使用。电信宽带等 IPv4 网络用户也可以使用（仅限 Pro 套餐）。
        </p><br />
        <p><b>第一步:&nbsp;&nbsp;</b> 下载安装 IPv6VPN.NET 定制版 OpenVPN 客户端：
        <a target="_blank" href="/downloads/auth/openvpn/openvpn-2.3.12-ipv6vpn.net-x86_64.exe">64位</a>&nbsp;&nbsp;<a target="_blank" href="/downloads/auth/openvpn/openvpn-2.3.12-ipv6vpn.net-i686.exe">32位</a><br />
        （定制版内置了证书和配置文件，增加了 IPv6 DNS 设置用以加速域名解析，其他与原版没有差别）
        <img src="/images/t_openvpn_windows_1.jpg" alt="" class="aligncenter size-full wp-image-535"/>
        （或者，你可以从 OpenVPN 官网下载客户端(2.3.9或更新版本)，然后下载 <a target="_blank" href="/downloads/auth/openvpn/configs/cert.zip">证书</a> 及 <a target="_blank" href="/config/openvpn">配置文件</a> ，解压后放到安装目录config文件夹下。）
        </p><br />
        <p><b>第二步:&nbsp;&nbsp;</b> 找到桌面上新出现的 openvpn-gui 快捷方式，双击运行。启动后右击任务栏中的图标，根据所处网络选择合适的配置文件（例如 IPv6_US 是指通过 IPv6 网络连接 US 服务器）。然后点 Connect，输入用户名密码。稍等片刻后，开始畅游全球网络。
        <br /><img src="/images/t_openvpn_windows_2.jpg" alt="" class="aligncenter size-full wp-image-535"/>
        </p><br />
        <p><b>进阶设置:&nbsp;&nbsp;</b> 请点击 <a href="/config/openvpn">这里</a> 查看可选配置文件。如果你是高校用户，推荐使用为高校定制的配置文件，这样可以在连上VPN的同时访问学校内网。</p><br />
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
