/*
 * JSP generated by Resin-3.1.8 (built Mon, 17 Nov 2008 12:15:21 PST)
 */

package _jsp._include;
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

public class _menu__jsp extends com.caucho.jsp.JavaPage
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
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      
String systemName = SysConfig.getConfig("system.systemName");
String root = SysConfig.getConfig("system.root");
String email = SysConfig.getConfig("system.email");

request.setAttribute("systemName", systemName);
request.setAttribute("root", root); 
request.setAttribute("email", email); 

      out.write(_jsp_string1, 0, _jsp_string1.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string2, 0, _jsp_string2.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string3, 0, _jsp_string3.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string4, 0, _jsp_string4.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string5, 0, _jsp_string5.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
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
    manager.addTaglibFunctions(_jsp_functionMap, "en", "/WEB-INF/enums");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${root }");
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("include/menu.jsp"), 1974802514033345985L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jspf/import.jsp"), 7536529205141102298L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }
  private static com.caucho.el.Expr _caucho_expr_0;

  private final static char []_jsp_string2;
  private final static char []_jsp_string0;
  private final static char []_jsp_string4;
  private final static char []_jsp_string1;
  private final static char []_jsp_string5;
  private final static char []_jsp_string3;
  static {
    _jsp_string2 = "/service.jsp\">\u89e3\u5bc6\u670d\u52a1</a>\r\n		            <li id=\"register\"><a href=\"".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n    \r\n".toCharArray();
    _jsp_string4 = "/guide.jsp\">\u4f7f\u7528\u6307\u5357</a>\r\n		            <li id=\"login\"><a href=\"".toCharArray();
    _jsp_string1 = "\r\n\r\n<div id=\"header\">\r\n		<div id=\"logo\">\r\n			<a id=\"logo_text\" href=\"/\">Labview.help</a>\r\n			<div id=\"description\">.</div>\r\n		</div>\r\n		<div id=\"header_meta\" >\r\n			<div id=\"header_search_area\">\r\n				<form id=\"searchform\" action=\"#\" method=\"get\">\r\n					<div>\r\n						<input id=\"search_input\" name=\"s\" onfocus=\"this.value=''; changefc('#333');\" type=\"text\" value=\"Search\" /></div>\r\n					<div>\r\n						<input id=\"search_button\" alt=\"Search from this blog.\" src=\"/img/search_button.gif\" title=\"Search from this blog.\" type=\"image\" /></div>\r\n				</form>\r\n			</div>\r\n<!-- JiaThis Button BEGIN -->\r\n\r\n<div class=\"jiathis_style_32x32\" style=\"position: relative;float: left;\">\r\n	<a class=\"jiathis_button_tsina\"></a>\r\n	<a class=\"jiathis_button_weixin\"></a>\r\n	<a class=\"jiathis_button_douban\"></a>\r\n	<a href=\"http://www.jiathis.com/share\" class=\"jiathis jiathis_txt jtico jtico_jiathis\" target=\"_blank\"></a>\r\n</div>\r\n<script type=\"text/javascript\" src=\"http://v3.jiathis.com/code_mini/jia.js\" charset=\"utf-8\"></script>\r\n<!-- JiaThis Button END -->\r\n		</div>\r\n		\r\n            <!-- END #header_meta -->\r\n            <div class=\"header_menu\">\r\n	            <ul id=\"menu\" class=\"menu\">\r\n		            <li id=\"index\"><a href=\"/\">\u9996\u9875</a></li>\r\n                    <li id=\"service\"><a href=\"".toCharArray();
    _jsp_string5 = "/login.jsp\">\u6211\u7684\u8d26\u53f7</a></li>\r\n	            </ul>\r\n            </div>\r\n            <!-- END #header_menu -->\r\n	</div>".toCharArray();
    _jsp_string3 = "/register.jsp\">\u6ce8\u518c\u8d26\u53f7</a></li>\r\n		            <li id=\"guide\"><a href=\"".toCharArray();
  }
}
