package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.IConductorService;

import java.io.IOException;

@WebServlet(name = "agregarConductor", value = "/agregar-conductor")
public class AgregarConductor extends HttpServlet {

    private IConductorService conductorService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("springContext");
        conductorService = (IConductorService) context.getBean("conductorServiceImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Cuando el usuario entra por primera vez (GET), solo le muestro el formulario
        req.getRequestDispatcher("/agregarConductor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        int cargo = Integer.parseInt(req.getParameter("cargo"));
        int tipoDeIdentificacion = Integer.parseInt(req.getParameter("tipoDeIdentificacion"));
        String numeroDeIdentificacion = req.getParameter("numeroDeIdentificacion");

        try {
            conductorService.addConductor(nombre, cargo, tipoDeIdentificacion, numeroDeIdentificacion);
            resp.sendRedirect("menu-de-conductores"); // redirige al listado
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}

