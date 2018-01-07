package com.salat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/salat")
public class App extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ServletOutputStream os = res.getOutputStream(); 
        os.println("Got it!");
    }
}
