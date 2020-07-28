package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/newServlet")
public class newServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        response.getWriter().write("new Servlet");
    }
    public void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}