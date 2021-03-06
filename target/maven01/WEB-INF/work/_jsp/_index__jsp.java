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

public class _index__jsp extends com.caucho.jsp.JavaPage
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
String email = SysConfig.getConfig("system.email");

request.setAttribute("systemName", systemName);
request.setAttribute("root", root); 
request.setAttribute("email", email); 

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
      if (_jsp_ImportTag_0 == null) {
        _jsp_ImportTag_0 = new org.apache.taglibs.standard.tag.rt.core.ImportTag();
        _jsp_ImportTag_0.setPageContext(pageContext);
        _jsp_ImportTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_ImportTag_0.setUrl("/include/right.jsp");
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
      out.write(_jsp_string3, 0, _jsp_string3.length);
      if (_jsp_ImportTag_0 == null) {
        _jsp_ImportTag_0 = new org.apache.taglibs.standard.tag.rt.core.ImportTag();
        _jsp_ImportTag_0.setPageContext(pageContext);
        _jsp_ImportTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_ImportTag_0.setUrl("/include/footer.jsp");
      javax.servlet.jsp.JspWriter _jsp_writer11 = out;
      try {
        _jsp_ImportTag_0.doStartTag();
        _jsp_ImportTag_0.doEndTag();
      } catch (Throwable _jsp_exn_14) {
        pageContext.setWriter(_jsp_writer11);
        out = _jsp_writer11;
        _jsp_ImportTag_0.doCatch(_jsp_exn_14);
      } finally {
        _jsp_ImportTag_0.doFinally();
      }
      out.write(_jsp_string4, 0, _jsp_string4.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("index.jsp"), 5755718067208967320L, false);
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

  private final static char []_jsp_string0;
  private final static char []_jsp_string1;
  private final static char []_jsp_string4;
  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  static {
    _jsp_string0 = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n    \r\n".toCharArray();
    _jsp_string1 = "\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\r\n    <meta name=\"robots\" content=\"noarchive\" />\r\n    \r\n    <title>\r\n	Labview - \u63d0\u4f9blabview\u7834\u89e3\u5bc6\u7801_\u6e90\u7801\u5bc6\u7801\u7834\u89e3_labview\u514d\u8d39\u89e3\u7801\u670d\u52a1\r\n	</title>\r\n    <link href=\"/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/img/180x180.png\" />\r\n    <link rel=\"icon\" sizes=\"192x192\" href=\"/img/192x192.png\" />\r\n    <!--[if lt IE 7]>\r\n    <link href=\"/content/css/ie6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n    <![endif]-->\r\n    <script src=\"/js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\r\n    \r\n    <script src=\"/js/jscript.js\" type=\"text/javascript\"></script>\r\n    \r\n<meta content=\"labview\u63d0\u4f9b\u514d\u8d39\u6e90\u7801\u5bc6\u7801\u7834\u89e3\u3001labview\u8d44\u6599\u4e0b\u8f7d\u3001labview\u5b66\u4e60\u4ea4\u6d41\uff0c\u670d\u52a1\u4e8e\u5e7f\u5927\u7684labview\u5de5\u7a0b\u5e08\u3002\" name=\"description\" />\r\n<meta content=\"labview,labview\u89e3\u7801,\u5bc6\u7801\u7834\u89e3,labview\u8d44\u6599\u4e0b\u8f7d,labview\u793e\u533a,labview\u5b66\u4e60\u4ea4\u6d41,\u6e90\u7801\u4e0b\u8f7d\" name=\"keywords\" />\r\n<style type=\"text/css\" >\r\n    h3 { color: #336699; font-weight: normal;}\r\n    #left_col { padding-bottom: 0px; }\r\n    ol li { line-height: 200%; }\r\n</style>\r\n\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"wrapper\">\r\n	<!-- #header -->\r\n	".toCharArray();
    _jsp_string4 = "\r\n	<!-- END #footer -->\r\n</div>\r\n<!-- END #wrapper -->\r\n</body>\r\n\r\n</html>\r\n".toCharArray();
    _jsp_string3 = "\r\n		<!-- END #right_col -->\r\n	</div>\r\n	<!-- END #contents -->\r\n	".toCharArray();
    _jsp_string2 = "\r\n	<script type=\"text/javascript\">\r\n		document.getElementById(\"index\").setAttribute('class','current_page_item');\r\n	</script>\r\n	<!-- #header -->\r\n	<div id=\"contents\" class=\"clearfix\">\r\n		<div id=\"left_col\">\r\n            \r\n\r\n                <div class=\"post\" style=\"line-height: 200%;\">\r\n                    <div>\r\n                    	<img src=\"/img/index_focuse.jpeg\" alt=\"labview.help\u89e3\u5bc6\u670d\u52a1\" width=\"100%\"/>\r\n                    </div>\r\n                    <h3>labview.help\u662f\u4ec0\u4e48\u7f51\u7ad9\uff1f</h3>\r\n                    <ol>\r\n                        <li>labview\u63d0\u4f9bvi\u5bc6\u7801\u7834\u89e3\u529f\u80fd\uff0c\u7834\u89e3\u6210\u529f\u7387\u9ad8\uff0c\u901f\u5ea6\u5feb\u3002</li>\r\n                        <li>labview\u63d0\u4f9b\u5b66\u4e60\u89c6\u9891\u4e0b\u8f7d\uff0c\u5927\u91cf\u6e90\u7801\u8d44\u6599\u8d60\u9001\uff08\u672a\u5f00\u653e\uff09\u3002</li>\r\n                        <li>labview\u4e3a\u5e7f\u5927labview\u5de5\u4f5c\u8005\u548c\u7231\u597d\u8005\u63d0\u4f9b\u4ea4\u6d41\u5e73\u53f0\u3002</li>\r\n                    </ol>\r\n\r\n                    <h3>\u6211\u4eec\u7684\u4f18\u52bf</h3>\r\n                    <div>\r\n                    <b>\u7b80\u5355\u6613\u7528</b>\uff1a\u4e0a\u4f20-->\u89e3\u5bc6-->\u4e0b\u8f7d\u3002<br />\r\n                    <b>\u9690\u79c1\u5b89\u5168</b>\uff1a\u8d26\u53f7\u767b\u5f55\uff0c\u7edd\u4e0d\u5916\u6cc4\u4efb\u4f55\u4e00\u4f4d\u7528\u6237\u6587\u4ef6\u3002<br />\r\n                    <b>\u4e0d\u9650\u6b21\u6570</b>\uff1a\u4efb\u610f\u4e0a\u4f20\uff0c\u4e0d\u9650\u5236\u6b21\u6570\uff0c\u4f46\u4e0d\u80fd\u4e0a\u4f20\u7684\u6587\u4ef6\u4e0d\u80fd\u8fc7\u5927\uff0c\u4ee5\u514d\u5f71\u54cd\u5176\u4ed6\u7f51\u53cb\u89e3\u5bc6\u3002\r\n                    </div>\r\n                    <br />\r\n                    \r\n                </div>\r\n\r\n\r\n		</div>\r\n		<!-- END #left_col -->\r\n		".toCharArray();
  }
}
