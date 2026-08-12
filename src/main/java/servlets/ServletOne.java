//package servlets;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/servlet-one")
//public class ServletOne extends HttpServlet {
//    public ServletOne() {
//        super();
//    }
//    public void init() {}
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
