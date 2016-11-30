<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/jspf/import.jsp" %>
<%
	User user = (User)request.getSession().getAttribute("currentUser");
	int pageNo = StringUtils.getInt(request.getParameter("pageNo"), 1); 
	int status = StringUtils.getInt(request.getParameter("status"), 6); 
	int pageSize = StringUtils.getInt(request.getParameter("pageSize"), 5); 
	String orderBy = StringUtils.get(request.getParameter("orderBy"), "createAt"); 
	String order = StringUtils.get(request.getParameter("order"), "desc");
	if(user != null){
		int id = user.getId();
		Map<String,Object> params = new HashMap<String,Object>();
		ZipFileServiceImpl zipFileService = SpringCtxUtils.getBean(ZipFileServiceImpl.class);
		params.put("userId", user.getId());
		params.put("status", status);
		int total = zipFileService.getTatolCount(params);
		if(total > 0){
			int pageCount = total / pageSize + (total % pageSize == 0 ? 0 : 1);
			if(pageNo > pageCount){
				pageNo = pageCount;
			}
		}
		
		params.put("begin", pageSize*(pageNo-1)+1);
		params.put("end", pageSize*(pageNo-1)+pageSize);
		//params.put("orderBy", orderBy);
		params.put("order", order);
		
		List<ZipFile> zips = zipFileService.pageList(params);
		pageContext.setAttribute("zips", zips);
		pageContext.setAttribute("userId", id);
		pageContext.setAttribute("pageNo", pageNo);
		
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <meta name="robots" content="noarchive" />
    
    <title>
	服务套餐 - IPv6VPN
</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <link href="/css/upload.css" rel="stylesheet" type="text/css" />
    <link rel="apple-touch-icon" sizes="180x180" href="/img/180x180.png" />
    <link rel="icon" sizes="192x192" href="/img/192x192.png" />
    <!--[if lt IE 7]>
    <link href="/content/css/ie6.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <script src="/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    
    <script src="/js/jscript.js" type="text/javascript"></script>
    
<meta content="IPv6VPN是基于OpenVPN、利用IPv6访问全球v4网络的上网解决方案，适合拥有IPv6网络环境的高校学生、教师和科研单位。" name="description" />
<meta content="IPv6,VPN,EDU,上网,教育网,OpenVPN,IPSec,IKEv2" name="keywords" />
<style type="text/css" >
    h3 { color: #336699; font-size: 16px; font-weight: normal; margin: 22px 0 4px 0; }
    h3 span { font-family:  Consolas, Monaco, Arial, Helvetica, sans-serif; }
    #left_col { padding-bottom: 6px; }
    .post_content { margin: 0; line-height: 175%; }
    .post_content ul { margin-bottom: 4px; }
    .post_content ul li { margin: 4px 0 4px 0; line-height: 150%; }
    .price { margin-bottom: 4px; }
    .price span { margin-right: 8px; font-size: 12px; color: #555;}
    .ut { margin-top: 6px; margin-bottom: 6px; }
    
    .upload {
    clear: both;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
    border-right: 1px solid #ccc; 
    border-bottom: 1px solid #ccc;
    margin: 0 28px;
    height: 80px;
    width:80px;
    padding: 0 10px;
    float:left;
    }
    .upload_title {
    top:25px;
	margin:auto;
    position: relative;
	}
 
	
	.fileBox{
	clear: both;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
    border-right: 1px solid #ccc; 
    border-bottom: 1px solid #ccc;
    margin: 0 ,0;
    height: 300px;
    width: 520px;
    float:left;
    position: relative;
	margin-left: 28px;
	} 
	
</style>
<script type="text/javascript">
function submitCheck() {
	var val = $("#file").val();
	var fileend = val.substring(val.indexOf(".")); 
	if(fileend.length > 0){
		if(fileend== ".zip"){
			return true;
			
		}else{
			alert("文件格式不正确");
			return false;
		}
	}else{
		alert("请选择文件");
		return false;
	}
}
function submitqq() {
    if (!submitCheck()) {
    	return false;
    }
    document.getElementById('signupform').submit();
    $("#submit").attr('disabled', 'disabled');
}
</script>

<script>
$(function(){
	$("input[type=file]").change(function(){$(this).parents(".uploader").find(".filename").val($(this).val());});
	$("input[type=file]").each(function(){
	if($(this).val()==""){$(this).parents(".uploader").find(".filename").val("未选择任何文件");}
	});
});
</script>
</head>

<body>

<div id="wrapper">
	<!-- #header -->
	<c:import url="/include/menu.jsp"></c:import>
	<script type="text/javascript">
		document.getElementById("service").setAttribute('class','current_page_item');
	</script>
	<!-- #header -->
	
	<div id="contents" class="clearfix">
		<div id="left_col">
            
<div class="post">
    <h2 class="post_title">Labview 解密服务</h2>
    <ul class="post_info">
        <li>Last Updated: Oct 10, 2016</li>
    </ul>
    <div class="post_content">
        <h3>上传待解密文件</h3>
			<div class="upload">
				 <img src="/img/upload.jpg" width="80" height="86" alt="" />
			</div>
			<form action="${requestScope.root }/zipfile/upload.do" onsubmit="return submitqq();" id="signupform" method="post" enctype="multipart/form-data">
				<div class="uploader white">
						<input type="file" name="zipFile" style="	
float: left;
height: 32px;
width: 180px;
margin-right: 80px;
margin-top:2px;
overflow: hidden; " id="file"/>
						<input type="text" class="filename" readonly="readonly" />
						<!-- <input type="button" name="file" class="button" value="浏览文件"/> -->
						<input type="submit"  class="button" value="上传解密"  id="submit"/>
				      	<ul>
							<li style="line-height: 150%; color: gray;">解密成功后请在下方下载您的文件</li>
							<li style="line-height: 150%; color: gray;">请选择zip格式的文件，单个文件不可大于50M</li>
						</ul>
				 </div>
			</form>
        
        <h3>下载已解密文件</h3>
        	<div class="fileBox">
        		<table width="100%">
        			<tr>
	        			<td width="10%">序号</td>
	        			<td width="30%">文件名</td>
	        			<td width="15%">大小</td>
	        			<td width="15%">状态</td>
	        			<td width="20%">操作</td>
	        		</tr>
        			<c:forEach var="zip" items="${zips}" varStatus="s">
	        			<tr>
	        				<td>${zip.id }</td>
	        				<td>${zip.originName }</td>
	        				<td>${zip.sizeString }</td>
	        				<td>${en:getZip(zip.status)}</td>
	        				<td>
	        					<a href="${requestScope.root }/zipfile/opera.do?zipId=${zip.id}&userId=${userId}&opera=decode">${zip.status == 1?"刷新":"解密" }</a>
	        					<a href="${requestScope.root }/zipfile/opera.do?zipId=${zip.id}&userId=${userId}&opera=download">下载</a>
	        					<a href="${requestScope.root }/zipfile/opera.do?zipId=${zip.id}&userId=${userId}&opera=delete">删除</a>
	        				</td>
	        			</tr>
        			</c:forEach>
        		</table>
        		<p style="margin-bottom: 0px">上一页</p>
        	</div>
        <br />
        <div style="clear:both"></div>
        <h3>说明：</h3>
        <div style="font-size:10px;">
        	<ul  style="font-size:12px;list-style-type:none;padding: 0 0 0 28px;">
				<li>1、解密成功后请在下方下载您的文件</li>
				<li>2、请选择zip格式的文件，单个文件不可大于50M</li>
				<li>3、为了节约空间，每位用户仅能同时在服务上保留五个文件。</li>
				<li>4、解密需要消耗很大服务器性能，所以大于20M文件需要人工解密。</li>
				<li>5、其他问题请联系我们，电子邮箱：${requestScope.email }</li>
			</ul>
        </div>
    </div>
</div>

		</div>
		<!-- END #left_col -->
		<div id="right_col">
                    <div class="side_box" style="line-height: 200%;">
                    <h3 class="side_title side_title_f">联系我们 Contact US</h3>
                    <span style="font-family: Consolas, Monaco, Arial, Helvetica, sans-serif;">Email: ${requestScope.email }</span><br />
                    </div>
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
