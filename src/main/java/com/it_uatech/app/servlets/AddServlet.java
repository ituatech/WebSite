package com.it_uatech.app.servlets;

import com.it_uatech.app.entities.User;
import com.it_uatech.app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/add.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        if (!name.isEmpty() && !password.isEmpty()) {
            User user = new User(name, password);
            Model model = Model.getInstance();
            model.add(user);
            req.setAttribute("userName", name);
        } else{
            if (name.isEmpty()) {
                req.setAttribute("errorName", "User name not exist!");
            }else {
                if (password.isEmpty()) {
                    req.setAttribute("errorName", "User password not exist!");
                }
            }
        }
        doGet(req, resp);
    }

}
