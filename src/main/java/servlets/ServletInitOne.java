//package servlets;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet("/servlet-init-one")
//public class ServletInitOne extends HttpServlet {
//    public ServletInitOne() {
//        super();
//    }
//    public void init() throws ServletException {}
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().print("This is " + this.getClass().getName() + ", using the GET method");
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().print("This is " + this.getClass().getName() + ", using the POST method");
//    }
//
//    public void destroy() {
//        super.destroy();
//    }
//}
