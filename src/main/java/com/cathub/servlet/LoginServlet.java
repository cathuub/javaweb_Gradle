package com.cathub.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //从前端获取password和id信息
        String userCode=req.getParameter("userCode");
        String password=req.getParameter("password");

        //下面进行数据判断
        if (userCode==null){
            req.setAttribute("error","用户名为空");
        }else if (password==null){
            req.setAttribute("error","密码为空");
        }else {//进行用户名和密码判断
            if ("admin".equals(userCode)&&"1234567".equals(password)){

                //存入session中，之后需要改成token
                //HttpSession session = req.getSession(false);
                //session.setAttribute("userSession","admin");
                resp.sendRedirect("jsp/frame.jsp");
                return;
            }else{
                req.setAttribute("error","用户名或者密码错误");
            }
        }
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }
}
