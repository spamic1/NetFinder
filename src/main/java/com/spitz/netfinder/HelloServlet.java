package com.spitz.netfinder;

import java.io.*;

import com.spitz.netfinder.repository.IPersonRepository;
import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    @Inject
    IPersonRepository personRepository;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        //out.println("<h1>" + personRepository.findById(1L).toString() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}