/*
 * JSP generated by Resin-3.1.8 (built Mon, 17 Nov 2008 12:15:21 PST)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import com.joe.myvideo.util.SysConfig;
import com.joe.myvideo.util.SpringCtxUtils;

public class _login__jsp extends com.caucho.jsp.JavaPage
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
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      
String systemName = SysConfig.getConfig("system.systemName");
String root = SysConfig.getConfig("system.root");

request.setAttribute("systemName", systemName);
request.setAttribute("root", root);

      out.write(_jsp_string1, 0, _jsp_string1.length);
      if (_jsp_ImportTag_0 == null) {
        _jsp_ImportTag_0 = new org.apache.taglibs.standard.tag.rt.core.ImportTag();
        _jsp_ImportTag_0.setPageContext(pageContext);
        _jsp_ImportTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_ImportTag_0.setUrl("/include/menu.jsp");
      javax.servlet.jsp.JspWriter _jsp_writer1 = out;
      try {
        _jsp_ImportTag_0.doStartTag();
        _jsp_ImportTag_0.doEndTag();
      } catch (Throwable _jsp_exn_4) {
        pageContext.setWriter(_jsp_writer1);
        out = _jsp_writer1;
        _jsp_ImportTag_0.doCatch(_jsp_exn_4);
      } finally {
        _jsp_ImportTag_0.doFinally();
      }
      out.write(_jsp_string2, 0, _jsp_string2.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string3, 0, _jsp_string3.length);
      _caucho_expr_1.print(out, _jsp_env, false);
      out.write(_jsp_string4, 0, _jsp_string4.length);
      if (_jsp_ImportTag_0 == null) {
        _jsp_ImportTag_0 = new org.apache.taglibs.standard.tag.rt.core.ImportTag();
        _jsp_ImportTag_0.setPageContext(pageContext);
        _jsp_ImportTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_ImportTag_0.setUrl("/include/footer.jsp");
      javax.servlet.jsp.JspWriter _jsp_writer6 = out;
      try {
        _jsp_ImportTag_0.doStartTag();
        _jsp_ImportTag_0.doEndTag();
      } catch (Throwable _jsp_exn_9) {
        pageContext.setWriter(_jsp_writer6);
        out = _jsp_writer6;
        _jsp_ImportTag_0.doCatch(_jsp_exn_9);
      } finally {
        _jsp_ImportTag_0.doFinally();
      }
      out.write(_jsp_string5, 0, _jsp_string5.length);
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
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${requestScope.root }");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${requestScope.msg }");
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("login.jsp"), -8399851833569795838L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("jspf/import.jsp"), -1886185392234924169L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(mergePath.lookup("jar:file:/G:/joe/20161128/myvideo/target/maven01/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld"), -172467247438851137L, false);
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

  private final static char []_jsp_string0;
  private final static char []_jsp_string3;
  private final static char []_jsp_string5;
  private final static char []_jsp_string1;
  private final static char []_jsp_string4;
  private final static char []_jsp_string2;
  static {
    _jsp_string0 = "\r\n\r\n\r\n\r\n\r\n    \r\n".toCharArray();
    _jsp_string3 = "/user/login.do\" id=\"signinform\" method=\"post\">\r\n						<div style=\"margin-top: 60px;\">\r\n							<div class=\"field-validation-error\" id=\"validationSummary\" style=\"height:18px;margin-left:48px;\">\r\n								".toCharArray();
    _jsp_string5 = "\r\n	<!-- END #footer -->\r\n</div>\r\n<!-- END #wrapper -->\r\n</body>\r\n\r\n</html>\r\n".toCharArray();
    _jsp_string1 = "\r\n\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\r\n    <meta name=\"robots\" content=\"noarchive\" />\r\n    \r\n    <title>\r\n    \r\n	\u767b\u5165\u5e10\u53f7 - Labview\r\n\r\n</title>\r\n    <link href=\"/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/icon/180x180.png\" />\r\n    <link rel=\"icon\" sizes=\"192x192\" href=\"/icon/192x192.png\" />\r\n    <!--[if lt IE 7]>\r\n    <link href=\"/css/ie6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n    <![endif]-->\r\n    <script src=\"/js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\r\n    \r\n    <script src=\"/js/jscript.js\" type=\"text/javascript\"></script>\r\n    \r\n    \r\n<meta content=\"\u767b\u5165labview.help\uff0c\u8d26\u53f7\u767b\u9646\u3001\u767b\u9646\u7ba1\u7406\u6e90\u7801\u6587\u4ef6\u3002\" name=\"description\" />\r\n<meta content=\"\u767b\u5165,labview,labview.help,\u6e90\u7801\u89e3\u7801,\u5bc6\u7801\u7834\u89e3,\u5f00\u6e90\u514d\u8d39\" name=\"keywords\" />\r\n    <script type=\"text/javascript\">\r\n        function submitCheck() {\r\n            $('#error_u').text('');\r\n            $('#error_p').text('');\r\n            if ($('#UserName').val() == '') {\r\n                $('#error_u').text('\u8bf7\u8f93\u5165\u7528\u6237\u540d');\r\n                return false;\r\n            }\r\n            if ($('#Password').val() == '') {\r\n                $('#error_p').text('\u8bf7\u8f93\u5165\u5bc6\u7801');\r\n                return false;\r\n            }\r\n            return true;\r\n        }\r\n        function submit() {\r\n            if (!submitCheck()) return;\r\n            document.getElementById('signinform').submit();\r\n            $(\".box_btn a\").attr('href', 'javascript:void(null)');\r\n        }\r\n    </script>\r\n\r\n    <script type=\"text/javascript\">\r\n        $(document).ready(function () {\r\n            $(\"#wrapper\").append(\"<script type=\\\"text/javascript\\\">window.scrollTo(0, 230);<\\/script>\");\r\n        });\r\n    </script>\r\n\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"wrapper\">\r\n	<!-- #header -->\r\n	".toCharArray();
    _jsp_string4 = "\r\n							</div><br/>\r\n							<label for=\"UserName\">\u7528\u6237\u540d</label><input autofocus=\"autofocus\" id=\"UserName\" name=\"UserName\" type=\"text\" value=\"\" /><span id=\"error_u\"></span><br/>\r\n							<label for=\"Password\">\u5bc6\u7801</label><input id=\"Password\" name=\"Password\" onkeypress=\"if (event.keyCode==13) { submit(); }\" type=\"password\" /><span id=\"error_p\"></span>\r\n                            \r\n						</div>\r\n						<div class=\"box_btn\" style=\"padding-left:24px;\">\r\n							<a class=\"box_btn_s\" id=\"btn_signin\" href=\"javascript:submit();\">\u767b\u5165</a>\r\n                            \r\n                            <a id=\"box_btn_star\" style=\"width:48px;text-decoration:none;\" href=\"/account/signup\">\u6ce8\u518c\u5e10\u53f7</a>\r\n                            \r\n						</div>\r\n                    </form>\r\n                    </div>\r\n                    <div class=\"clear\"></div>\r\n\r\n	                        </div>\r\n	                        <div id=\"box_bottom\"></div>\r\n                        </div>\r\n                        \r\n                    </div>\r\n\r\n		</div>\r\n		<!-- END #left_col -->\r\n		<div id=\"right_col\">\r\n            \r\n\r\n			\r\n		</div>\r\n		<!-- END #right_col -->\r\n	</div>\r\n	<!-- END #contents -->\r\n	".toCharArray();
    _jsp_string2 = "\r\n	<script type=\"text/javascript\">\r\n		document.getElementById(\"login\").setAttribute('class','current_page_item');\r\n	</script>\r\n	<!-- #header -->\r\n	<div id=\"contents\" class=\"clearfix\">\r\n		<div id=\"left_col\">\r\n            \r\n                    <div id=\"box\">\r\n                        <h1 class=\"box_title\">\u767b\u5165\u5e10\u53f7 Sign In</h1>\r\n                        <div>\r\n	                        <div id=\"box_top\"></div>\r\n	                        <div id=\"box_body\">\r\n                            \r\n                    <div id=\"box_img\"><img src=\"/img/box_img.png\" alt=\"\" /></div>\r\n					<div id=\"box_content\">\r\n                    <form action=\"".toCharArray();
  }
}
