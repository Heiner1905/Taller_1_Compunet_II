package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@WebServlet(name = "menuDeConductores", value = "/menu-de-conductores")
public class MenuDeConductores extends HttpServlet {
    ApplicationContext context;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Simplemente reenvías al JSP
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("springContext");
        req.getRequestDispatcher("menuConductores.jsp").forward(req, resp);
    }
}
