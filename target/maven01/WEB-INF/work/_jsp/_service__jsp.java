/*
 * JSP generated by Resin-3.1.8 (built Mon, 17 Nov 2008 12:15:21 PST)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.joe.myvideo.service.impl.ZipFileServiceImpl;
import com.joe.myvideo.entity.ZipFile;
import java.util.List;
import com.joe.myvideo.service.ZipFileService;
import com.joe.myvideo.util.StringUtils;
import java.util.HashMap;
import java.util.Map;
import com.joe.myvideo.entity.User;
import com.joe.myvideo.util.SysConfig;
import com.joe.myvideo.util.SpringCtxUtils;

public class _service__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.PageContext _jsp_parentContext = pageContext;
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jsp_ImportTag_0 = null;
    com.caucho.jsp.IteratorLoopSupportTag _jsp_loop_0 = null;
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      
String systemName = SysConfig.getConfig("system.systemName");
String root = SysConfig.getConfig("system.root");
String email = SysConfig.getConfig("system.email");

request.setAttribute("systemName", systemName);
request.setAttribute("root", root); 
request.setAttribute("email", email); 

      out.write(_jsp_string1, 0, _jsp_string1.length);
      
	User user = (User)request.getSession().getAttribute("currentUser");
	int pageNo = StringUtils.getInt(request.getParameter("pageNo"), 1); 
	int status = StringUtils.getInt(request.getParameter("status"), 6); 
	/* int pageSize = StringUtils.getInt(request.getParameter("pageSize"), 5);  */
	int pageSize = 5;
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
			pageContext.setAttribute("pageCount", pageCount);
			if(pageNo > pageCount){
				pageNo = pageCount;
			}
		}
		
		params.put("begin", pageSize*(pageNo-1));
		params.put("end", pageSize*(pageNo-1)+pageSize);
		//params.put("orderBy", orderBy);
		params.put("order", order);
		
		List<ZipFile> zips = zipFileService.pageList(params);
		pageContext.setAttribute("zips", zips);
		pageContext.setAttribute("userId", id);
		pageContext.setAttribute("pageNo", pageNo);
		
		
	}

      out.write(_jsp_string2, 0, _jsp_string2.length);
      if (_jsp_ImportTag_0 == null) {
        _jsp_ImportTag_0 = new org.apache.taglibs.standard.tag.rt.core.ImportTag();
        _jsp_ImportTag_0.setPageContext(pageContext);
        _jsp_ImportTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_ImportTag_0.setUrl("/include/menu.jsp");
      javax.servlet.jsp.JspWriter _jsp_writer2 = out;
      try {
        _jsp_ImportTag_0.doStartTag();
        _jsp_ImportTag_0.doEndTag();
      } catch (Throwable _jsp_exn_5) {
        pageContext.setWriter(_jsp_writer2);
        out = _jsp_writer2;
        _jsp_ImportTag_0.doCatch(_jsp_exn_5);
      } finally {
        _jsp_ImportTag_0.doFinally();
      }
      out.write(_jsp_string3, 0, _jsp_string3.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string4, 0, _jsp_string4.length);
      if (_jsp_loop_0 == null)
        _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
      java.lang.Object _jsp_items_6 = _caucho_expr_1.evalObject(_jsp_env);
      java.util.Iterator _jsp_iter_6 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_6);
      _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
      Object _jsp_status_6 = pageContext.putAttribute("s", _jsp_loop_0);
      Object _jsp_oldVar_6 = pageContext.getAttribute("zip");
      while (_jsp_iter_6.hasNext()) {
        Object _jsp_i_6 = _jsp_iter_6.next();
        pageContext.setAttribute("zip", _jsp_i_6);
        _jsp_loop_0.setCurrent(_jsp_i_6, _jsp_iter_6.hasNext());
        out.write(_jsp_string5, 0, _jsp_string5.length);
        _caucho_expr_2.print(out, _jsp_env, false);
        out.write(_jsp_string6, 0, _jsp_string6.length);
        _caucho_expr_3.print(out, _jsp_env, false);
        out.write(_jsp_string6, 0, _jsp_string6.length);
        _caucho_expr_4.print(out, _jsp_env, false);
        out.write(_jsp_string6, 0, _jsp_string6.length);
        _caucho_expr_5.print(out, _jsp_env, false);
        out.write(_jsp_string7, 0, _jsp_string7.length);
        _caucho_expr_0.print(out, _jsp_env, false);
        out.write(_jsp_string8, 0, _jsp_string8.length);
        _caucho_expr_6.print(out, _jsp_env, false);
        out.write(_jsp_string9, 0, _jsp_string9.length);
        _caucho_expr_7.print(out, _jsp_env, false);
        out.write(_jsp_string10, 0, _jsp_string10.length);
        _caucho_expr_8.print(out, _jsp_env, false);
        out.write(_jsp_string11, 0, _jsp_string11.length);
        _caucho_expr_0.print(out, _jsp_env, false);
        out.write(_jsp_string8, 0, _jsp_string8.length);
        _caucho_expr_6.print(out, _jsp_env, false);
        out.write(_jsp_string9, 0, _jsp_string9.length);
        _caucho_expr_7.print(out, _jsp_env, false);
        out.write(_jsp_string12, 0, _jsp_string12.length);
        _caucho_expr_0.print(out, _jsp_env, false);
        out.write(_jsp_string8, 0, _jsp_string8.length);
        _caucho_expr_6.print(out, _jsp_env, false);
        out.write(_jsp_string9, 0, _jsp_string9.length);
        _caucho_expr_7.print(out, _jsp_env, false);
        out.write(_jsp_string13, 0, _jsp_string13.length);
      }
      pageContext.pageSetOrRemove("zip", _jsp_oldVar_6);
      pageContext.removeAttribute("s");
      out.write(_jsp_string14, 0, _jsp_string14.length);
      if (_caucho_expr_9.evalBoolean(_jsp_env)) {
        out.write(_jsp_string15, 0, _jsp_string15.length);
      }
      else if (_caucho_expr_10.evalBoolean(_jsp_env)) {
        out.write(_jsp_string16, 0, _jsp_string16.length);
        _caucho_expr_11.print(out, _jsp_env, false);
        out.write(_jsp_string17, 0, _jsp_string17.length);
        _caucho_expr_12.print(out, _jsp_env, false);
        out.write(_jsp_string18, 0, _jsp_string18.length);
      }
      else if (_caucho_expr_13.evalBoolean(_jsp_env)) {
        out.write(_jsp_string19, 0, _jsp_string19.length);
      }
      else if (_caucho_expr_14.evalBoolean(_jsp_env)) {
        out.write(_jsp_string16, 0, _jsp_string16.length);
        _caucho_expr_11.print(out, _jsp_env, false);
        out.write(_jsp_string17, 0, _jsp_string17.length);
        _caucho_expr_15.print(out, _jsp_env, false);
        out.write(_jsp_string20, 0, _jsp_string20.length);
      }
      out.write(_jsp_string21, 0, _jsp_string21.length);
      _caucho_expr_11.print(out, _jsp_env, false);
      out.write(_jsp_string17, 0, _jsp_string17.length);
      _caucho_expr_15.print(out, _jsp_env, false);
      out.write(_jsp_string22, 0, _jsp_string22.length);
      _caucho_expr_16.print(out, _jsp_env, false);
      out.write(_jsp_string23, 0, _jsp_string23.length);
      if (_jsp_ImportTag_0 == null) {
        _jsp_ImportTag_0 = new org.apache.taglibs.standard.tag.rt.core.ImportTag();
        _jsp_ImportTag_0.setPageContext(pageContext);
        _jsp_ImportTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_ImportTag_0.setUrl("/include/right.jsp");
      javax.servlet.jsp.JspWriter _jsp_writer8 = out;
      try {
        _jsp_ImportTag_0.doStartTag();
        _jsp_ImportTag_0.doEndTag();
      } catch (Throwable _jsp_exn_11) {
        pageContext.setWriter(_jsp_writer8);
        out = _jsp_writer8;
        _jsp_ImportTag_0.doCatch(_jsp_exn_11);
      } finally {
        _jsp_ImportTag_0.doFinally();
      }
      out.write(_jsp_string24, 0, _jsp_string24.length);
      if (_jsp_ImportTag_0 == null) {
        _jsp_ImportTag_0 = new org.apache.taglibs.standard.tag.rt.core.ImportTag();
        _jsp_ImportTag_0.setPageContext(pageContext);
        _jsp_ImportTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_ImportTag_0.setUrl("/include/footer.jsp");
      javax.servlet.jsp.JspWriter _jsp_writer13 = out;
      try {
        _jsp_ImportTag_0.doStartTag();
        _jsp_ImportTag_0.doEndTag();
      } catch (Throwable _jsp_exn_16) {
        pageContext.setWriter(_jsp_writer13);
        out = _jsp_writer13;
        _jsp_ImportTag_0.doCatch(_jsp_exn_16);
      } finally {
        _jsp_ImportTag_0.doFinally();
      }
      out.write(_jsp_string25, 0, _jsp_string25.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      if (_jsp_ImportTag_0 != null)
        _jsp_ImportTag_0.release();
      _jsp_application.getJspApplicationContext().freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.server.util.CauchoSystem.getVersionId() != 1886798272571451039L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Dependency depend;
      depend = (com.caucho.vfs.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void init(ServletConfig config)
    throws ServletException
  {
    com.caucho.server.webapp.WebApp webApp
      = (com.caucho.server.webapp.WebApp) config.getServletContext();
    super.init(config);
    com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
    manager.addTaglibFunctions(_jsp_functionMap, "c", "http://java.sun.com/jsp/jstl/core");
    manager.addTaglibFunctions(_jsp_functionMap, "fn", "http://java.sun.com/jsp/jstl/functions");
    manager.addTaglibFunctions(_jsp_functionMap, "en", "/WEB-INF/enums");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${requestScope.root }");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${zips}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${zip.id }");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${zip.originName }");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${zip.sizeString }");
    _caucho_expr_5 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${en:getZip(zip.status)}");
    _caucho_expr_6 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${zip.id}");
    _caucho_expr_7 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userId}");
    _caucho_expr_8 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${zip.status == 1?\"\u5237\u65b0\":\"\u89e3\u5bc6\" }");
    _caucho_expr_9 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageNo lt 1}");
    _caucho_expr_10 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageNo gt 1}");
    _caucho_expr_11 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${requseScope.root }");
    _caucho_expr_12 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageNo-1}");
    _caucho_expr_13 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageNo gt pageCount}");
    _caucho_expr_14 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageNo lt pageCount}");
    _caucho_expr_15 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageNo+1}");
    _caucho_expr_16 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${requestScope.email }");
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("service.jsp"), 3677898302532795677L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jspf/import.jsp"), -1238381277323064527L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(mergePath.lookup("jar:file:/C:/Users/zhoucijoe/git/labview/target/maven01/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld"), -172467247438851137L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(org.apache.taglibs.standard.tag.rt.core.ImportTag.class, 6027995467445314107L));
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(org.apache.taglibs.standard.tei.ImportTEI.class, 7046138242264411925L));
  }

  static {
    try {
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;
  private static com.caucho.el.Expr _caucho_expr_4;
  private static com.caucho.el.Expr _caucho_expr_5;
  private static com.caucho.el.Expr _caucho_expr_6;
  private static com.caucho.el.Expr _caucho_expr_7;
  private static com.caucho.el.Expr _caucho_expr_8;
  private static com.caucho.el.Expr _caucho_expr_9;
  private static com.caucho.el.Expr _caucho_expr_10;
  private static com.caucho.el.Expr _caucho_expr_11;
  private static com.caucho.el.Expr _caucho_expr_12;
  private static com.caucho.el.Expr _caucho_expr_13;
  private static com.caucho.el.Expr _caucho_expr_14;
  private static com.caucho.el.Expr _caucho_expr_15;
  private static com.caucho.el.Expr _caucho_expr_16;

  private final static char []_jsp_string12;
  private final static char []_jsp_string5;
  private final static char []_jsp_string15;
  private final static char []_jsp_string16;
  private final static char []_jsp_string0;
  private final static char []_jsp_string8;
  private final static char []_jsp_string7;
  private final static char []_jsp_string20;
  private final static char []_jsp_string3;
  private final static char []_jsp_string25;
  private final static char []_jsp_string6;
  private final static char []_jsp_string2;
  private final static char []_jsp_string21;
  private final static char []_jsp_string10;
  private final static char []_jsp_string19;
  private final static char []_jsp_string18;
  private final static char []_jsp_string14;
  private final static char []_jsp_string17;
  private final static char []_jsp_string11;
  private final static char []_jsp_string24;
  private final static char []_jsp_string4;
  private final static char []_jsp_string9;
  private final static char []_jsp_string13;
  private final static char []_jsp_string23;
  private final static char []_jsp_string22;
  private final static char []_jsp_string1;
  static {
    _jsp_string12 = "&opera=download\">\u4e0b\u8f7d</a>\r\n	        					<a href=\"".toCharArray();
    _jsp_string5 = "\r\n	        			<tr>\r\n	        				<td>".toCharArray();
    _jsp_string15 = "<font class=\"before\">\u4e0a\u4e00\u9875</font>".toCharArray();
    _jsp_string16 = "<a class=\"before\" href=\"".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n    \r\n".toCharArray();
    _jsp_string8 = "/zipfile/opera.do?zipId=".toCharArray();
    _jsp_string7 = "</td>\r\n	        				<td>\r\n	        					<a href=\"".toCharArray();
    _jsp_string20 = "\">\u4e0b\u4e00\u9875</a>".toCharArray();
    _jsp_string3 = "\r\n	<script type=\"text/javascript\">\r\n		document.getElementById(\"service\").setAttribute('class','current_page_item');\r\n	</script>\r\n	<!-- #header -->\r\n	\r\n	<div id=\"contents\" class=\"clearfix\">\r\n		<div id=\"left_col\">\r\n            \r\n<div class=\"post\">\r\n    <h2 class=\"post_title\">Labview \u89e3\u5bc6\u670d\u52a1</h2>\r\n    <ul class=\"post_info\">\r\n        <li>Last Updated: Oct 10, 2016</li>\r\n    </ul>\r\n    <div class=\"post_content\">\r\n        <h3>\u4e0a\u4f20\u5f85\u89e3\u5bc6\u6587\u4ef6</h3>\r\n			<div class=\"upload\">\r\n				 <img src=\"/img/upload.jpg\" width=\"80\" height=\"86\" alt=\"\" />\r\n			</div>\r\n			<form action=\"".toCharArray();
    _jsp_string25 = "\r\n	<!-- END #footer -->\r\n</div>\r\n<!-- END #wrapper -->\r\n</body>\r\n\r\n</html>\r\n".toCharArray();
    _jsp_string6 = "</td>\r\n	        				<td>".toCharArray();
    _jsp_string2 = "\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\r\n    <meta name=\"robots\" content=\"noarchive\" />\r\n    \r\n    <title>\r\n	\u670d\u52a1\u5957\u9910 - IPv6VPN\r\n</title>\r\n    <link href=\"/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n    <link href=\"/css/upload.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/img/180x180.png\" />\r\n    <link rel=\"icon\" sizes=\"192x192\" href=\"/img/192x192.png\" />\r\n    <!--[if lt IE 7]>\r\n    <link href=\"/content/css/ie6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n    <![endif]-->\r\n    <script src=\"/js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\r\n    \r\n    <script src=\"/js/jscript.js\" type=\"text/javascript\"></script>\r\n    \r\n<meta content=\"IPv6VPN\u662f\u57fa\u4e8eOpenVPN\u3001\u5229\u7528IPv6\u8bbf\u95ee\u5168\u7403v4\u7f51\u7edc\u7684\u4e0a\u7f51\u89e3\u51b3\u65b9\u6848\uff0c\u9002\u5408\u62e5\u6709IPv6\u7f51\u7edc\u73af\u5883\u7684\u9ad8\u6821\u5b66\u751f\u3001\u6559\u5e08\u548c\u79d1\u7814\u5355\u4f4d\u3002\" name=\"description\" />\r\n<meta content=\"IPv6,VPN,EDU,\u4e0a\u7f51,\u6559\u80b2\u7f51,OpenVPN,IPSec,IKEv2\" name=\"keywords\" />\r\n<style type=\"text/css\" >\r\n    h3 { color: #336699; font-size: 16px; font-weight: normal; margin: 22px 0 4px 0; }\r\n    h3 span { font-family:  Consolas, Monaco, Arial, Helvetica, sans-serif; }\r\n    #left_col { padding-bottom: 6px; }\r\n    .post_content { margin: 0; line-height: 175%; }\r\n    .post_content ul { margin-bottom: 4px; }\r\n    .post_content ul li { margin: 4px 0 4px 0; line-height: 150%; }\r\n    .price { margin-bottom: 4px; }\r\n    .price span { margin-right: 8px; font-size: 12px; color: #555;}\r\n    .ut { margin-top: 6px; margin-bottom: 6px; }\r\n    \r\n    .upload {\r\n    clear: both;\r\n    border-top: 1px solid #ccc;\r\n    border-left: 1px solid #ccc;\r\n    border-right: 1px solid #ccc; \r\n    border-bottom: 1px solid #ccc;\r\n    margin: 0 28px;\r\n    height: 80px;\r\n    width:80px;\r\n    padding: 0 10px;\r\n    float:left;\r\n    }\r\n    .upload_title {\r\n    top:25px;\r\n	margin:auto;\r\n    position: relative;\r\n	}\r\n \r\n	\r\n	.fileBox{\r\n	clear: both;\r\n    border-top: 1px solid #ccc;\r\n    border-left: 1px solid #ccc;\r\n    border-right: 1px solid #ccc; \r\n    border-bottom: 1px solid #ccc;\r\n    margin: 0 ,0;\r\n    height: 300px;\r\n    width: 520px;\r\n    float:left;\r\n    position: relative;\r\n	margin-left: 28px;\r\n	} \r\n	\r\n</style>\r\n<script type=\"text/javascript\">\r\nfunction submitCheck() {\r\n	var val = $(\"#file\").val();\r\n	var fileend = val.substring(val.indexOf(\".\")); \r\n	if(fileend.length > 0){\r\n		if(fileend== \".zip\"){\r\n			return true;\r\n			\r\n		}else{\r\n			alert(\"\u6587\u4ef6\u683c\u5f0f\u4e0d\u6b63\u786e\");\r\n			return false;\r\n		}\r\n	}else{\r\n		alert(\"\u8bf7\u9009\u62e9\u6587\u4ef6\");\r\n		return false;\r\n	}\r\n}\r\nfunction submitqq() {\r\n    if (!submitCheck()) {\r\n    	return false;\r\n    }\r\n    document.getElementById('signupform').submit();\r\n    $(\"#submit\").attr('disabled', 'disabled');\r\n}\r\n</script>\r\n\r\n<script>\r\n$(function(){\r\n	$(\"input[type=file]\").change(function(){$(this).parents(\".uploader\").find(\".filename\").val($(this).val());});\r\n	$(\"input[type=file]\").each(function(){\r\n	if($(this).val()==\"\"){$(this).parents(\".uploader\").find(\".filename\").val(\"\u672a\u9009\u62e9\u4efb\u4f55\u6587\u4ef6\");}\r\n	});\r\n});\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"wrapper\">\r\n	<!-- #header -->\r\n	".toCharArray();
    _jsp_string21 = "\r\n        		\r\n        		<a class=\"after\"  href=\"".toCharArray();
    _jsp_string10 = "&opera=decode\">".toCharArray();
    _jsp_string19 = "<font class=\"before\">\u4e0b\u4e00\u9875</font>".toCharArray();
    _jsp_string18 = "\">\u4e0a\u4e00\u9875</a>".toCharArray();
    _jsp_string14 = "\r\n        		</table>\r\n        		".toCharArray();
    _jsp_string17 = "/service.jsp?pageNo=".toCharArray();
    _jsp_string11 = "</a>\r\n	        					<a href=\"".toCharArray();
    _jsp_string24 = "\r\n		<!-- END #right_col -->\r\n	</div>\r\n	<!-- END #contents -->\r\n	".toCharArray();
    _jsp_string4 = "/zipfile/upload.do\" onsubmit=\"return submitqq();\" id=\"signupform\" method=\"post\" enctype=\"multipart/form-data\">\r\n				<div class=\"uploader white\">\r\n						<input type=\"file\" name=\"zipFile\" style=\"	\r\nfloat: left;\r\nheight: 32px;\r\nwidth: 180px;\r\nmargin-right: 80px;\r\nmargin-top:2px;\r\noverflow: hidden; \" id=\"file\"/>\r\n						<input type=\"text\" class=\"filename\" readonly=\"readonly\" />\r\n						<!-- <input type=\"button\" name=\"file\" class=\"button\" value=\"\u6d4f\u89c8\u6587\u4ef6\"/> -->\r\n						<input type=\"submit\"  class=\"button\" value=\"\u4e0a\u4f20\u89e3\u5bc6\"  id=\"submit\"/>\r\n				      	<ul>\r\n							<li style=\"line-height: 150%; color: gray;\">\u89e3\u5bc6\u6210\u529f\u540e\u8bf7\u5728\u4e0b\u65b9\u4e0b\u8f7d\u60a8\u7684\u6587\u4ef6</li>\r\n							<li style=\"line-height: 150%; color: gray;\">\u8bf7\u9009\u62e9zip\u683c\u5f0f\u7684\u6587\u4ef6\uff0c\u5355\u4e2a\u6587\u4ef6\u4e0d\u53ef\u5927\u4e8e50M</li>\r\n						</ul>\r\n				 </div>\r\n			</form>\r\n        \r\n        <h3>\u4e0b\u8f7d\u5df2\u89e3\u5bc6\u6587\u4ef6</h3>\r\n        	<div class=\"fileBox\">\r\n        		<table width=\"100%\">\r\n        			<tr>\r\n	        			<td width=\"10%\">\u5e8f\u53f7</td>\r\n	        			<td width=\"30%\">\u6587\u4ef6\u540d</td>\r\n	        			<td width=\"15%\">\u5927\u5c0f</td>\r\n	        			<td width=\"15%\">\u72b6\u6001</td>\r\n	        			<td width=\"20%\">\u64cd\u4f5c</td>\r\n	        		</tr>\r\n        			".toCharArray();
    _jsp_string9 = "&userId=".toCharArray();
    _jsp_string13 = "&opera=delete\">\u5220\u9664</a>\r\n	        				</td>\r\n	        			</tr>\r\n        			".toCharArray();
    _jsp_string23 = "</li>\r\n			</ul>\r\n        </div>\r\n    </div>\r\n</div>\r\n\r\n		</div>\r\n		<!-- END #left_col -->\r\n			".toCharArray();
    _jsp_string22 = " \"></a>\r\n        	</div>\r\n        <br />\r\n        <div style=\"clear:both\"></div>\r\n        <h3>\u8bf4\u660e\uff1a</h3>\r\n        <div>\r\n        	<ul class=\"remar\">\r\n				<li>1\u3001\u89e3\u5bc6\u6210\u529f\u540e\u8bf7\u5728\u4e0b\u65b9\u4e0b\u8f7d\u60a8\u7684\u6587\u4ef6</li>\r\n				<li>2\u3001\u8bf7\u9009\u62e9zip\u683c\u5f0f\u7684\u6587\u4ef6\uff0c\u5355\u4e2a\u6587\u4ef6\u4e0d\u53ef\u5927\u4e8e50M</li>\r\n				<li>3\u3001\u4e3a\u4e86\u8282\u7ea6\u7a7a\u95f4\uff0c\u6bcf\u4f4d\u7528\u6237\u4ec5\u80fd\u540c\u65f6\u5728\u670d\u52a1\u4e0a\u4fdd\u7559\u4e94\u4e2a\u6587\u4ef6\u3002</li>\r\n				<li>4\u3001\u89e3\u5bc6\u9700\u8981\u6d88\u8017\u5f88\u5927\u670d\u52a1\u5668\u6027\u80fd\uff0c\u6240\u4ee5\u5927\u4e8e20M\u6587\u4ef6\u9700\u8981\u4eba\u5de5\u89e3\u5bc6\u3002</li>\r\n				<li>5\u3001\u5176\u4ed6\u95ee\u9898\u8bf7\u8054\u7cfb\u6211\u4eec\uff0c\u7535\u5b50\u90ae\u7bb1\uff1a".toCharArray();
    _jsp_string1 = "\r\n\r\n".toCharArray();
  }
}
