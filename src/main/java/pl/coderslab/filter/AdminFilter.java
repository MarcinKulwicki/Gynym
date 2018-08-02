//package pl.coderslab.filter;
//
//import pl.coderslab.entity.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "AdminFilter" ,urlPatterns = "/admin/*")
//public class AdminFilter implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        HttpSession sess = request.getSession();
//
//        if(sess.getAttribute("UserLogged") == null ) {
//            response.sendRedirect("/user");
//            return;
//        }
//        if(!((User)sess.getAttribute("UserLogged")).getUsername().equals("admin")){
//            response.sendRedirect("/user");
//            return;
//        }
//
//        chain.doFilter(req, resp);
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
