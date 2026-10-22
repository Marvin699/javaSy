package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/BCDServlet")
public class BCDServlet extends HttpServlet {
    public BCDServlet() {
        super();
        System.out.println("执行BCDServlet的构造方法！");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("执行BCDServlet的init()初始化方法！");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("执行BCDServlet的destroy()销毁方法！");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行BCDServlet的doGet()方法！");
        System.out.println("====获取路径信息====");
        System.out.println(request.getContextPath());
        System.out.println(request.getServletContext().getRealPath(""));
        System.out.println(request.getServletContext().getRealPath("/b/c"));
        System.out.println(request.getServletContext().getRealPath("b/c"));
        System.out.println(request.getServletContext().getRealPath("/index.html"));
        System.out.println(request.getServletContext().getRealPath("index.html"));
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getServletPath());
        System.out.println("最简单的方法是通过参数名，获取该参数名对应的值");
        String name = request.getParameter("name");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("你好，" + name);
        System.out.println("你的兴趣爱好有：");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("使用getParameterNames()方法获取所有参数名，再通过参数名，获取该参数名对应的所有参数值");
        java.util.Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            System.out.println("参数" + paramName + "有以下值");
            for (String paramValue : paramValues) {
                System.out.println(paramValue);
            }
        }
        System.out.println("使用getParameterMap()方法获取所有参数名，以及对应的所有参数值");
        java.util.Map<String, String[]> paramMap = request.getParameterMap();
        for (java.util.Map.Entry<String, String[]> mapEntry : paramMap.entrySet()) {
            String paramName = mapEntry.getKey();
            String[] paramValues = mapEntry.getValue();
            System.out.println("参数" + paramName + "有以下值");
            for (String paramValue : paramValues) {
                System.out.println(paramValue);
            }
        }
        System.out.println("获取" + request.getMethod() + "请求行信息");
        System.out.println(request.getScheme());
        System.out.println(request.getMethod());
        System.out.println(request.getProtocol());
        System.out.println(request.getQueryString());
        String zhangsanURLEncodedString = java.net.URLEncoder.encode("xhj", "UTF-8");
        String zhangsan = java.net.URLDecoder.decode(zhangsanURLEncodedString, "UTF-8");
        System.out.println(zhangsan + "<->" + zhangsanURLEncodedString);
        System.out.println("获取GET请求头信息");
        String userAgentValue = request.getHeader("user-agent");
        System.out.println("user-agent请求头的值是：" + userAgentValue);
        java.util.Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            java.util.Enumeration<String> headerValues = request.getHeaders(headerName);
            System.out.println("请求头：" + headerName + "，对应的请求头值有：");
            while (headerValues.hasMoreElements()) {
                String headerValue = headerValues.nextElement();
                System.out.println(headerValue);
            }
        }
        System.out.println("获取Web服务器主机以及浏览器主机信息");
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
        System.out.println(request.getLocalAddr());
        System.out.println(request.getLocalPort());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
        java.util.Locale browserLocale = request.getLocale();
        System.out.println(browserLocale + "#" + browserLocale.getCountry() + "#" + browserLocale.getISO3Country());
        java.util.Enumeration<java.util.Locale> browserLocales = request.getLocales();
        while (browserLocales.hasMoreElements()) {
            java.util.Locale locale = browserLocales.nextElement();
            System.out.println(locale + "#" + locale.getCountry() + "#" + locale.getISO3Country());
        }
        System.out.println("获取URL Mappings信息");
        javax.servlet.http.HttpServletMapping mapping = request.getHttpServletMapping();
        String mapName = mapping.getMappingMatch().name();
        String value = mapping.getMatchValue();
        String pattern = mapping.getPattern();
        String servletName = mapping.getServletName();
        System.out.println("Servlet名是：" + servletName);
        System.out.println("URL映射类型是：" + mapName);
        System.out.println("URL匹配的值是：" + value);
        System.out.println("URL匹配规则是：" + pattern);
        System.out.println("Web项目的根目录或者部署后的绝对物理路径是：" + request.getServletContext().getRealPath(""));
        System.out.println("BCDServlet的doGet()方法执行完毕！");
        System.out.println("通过请求转发request请求对象读取共享的属性信息");
        System.out.println("请求转发的类型是：" + request.getDispatcherType());
        Map<String, Object> map = (Map<String, Object>) request.getAttribute("map");
        String message = (String) map.get("message");
        String status = (String) map.get("status");
        ArrayList<String> list = (ArrayList<String>) map.get("list");
        System.out.println("message：" + message);
        System.out.println("status：" + status);
        for (String l : list) {
            System.out.println(l);

        }
    }
        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            System.out.println("执行BCDServlet的doPost()方法！");
            System.out.println("BCDServlet的doPost()方法执行完毕！");
        }
    }