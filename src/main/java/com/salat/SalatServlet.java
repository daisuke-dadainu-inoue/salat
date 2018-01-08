package com.salat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/")
public class SalatServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ServletOutputStream os = res.getOutputStream();
        os.println("index.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");

        res.sendRedirect("index.jsp");
    }
}
