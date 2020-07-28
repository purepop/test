import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        response.getWriter().write("first maven project");
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException
    {
        doGet(request, response);
    }
}