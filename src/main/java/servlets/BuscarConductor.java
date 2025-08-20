package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Conductor;
import model.Vehiculo;
import org.springframework.context.ApplicationContext;
import services.IConductorService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "buscarConductor", value = "/buscar-conductor")
public class BuscarConductor extends HttpServlet {

    ApplicationContext context;
    IConductorService conductorService;
    @Override
    public void init() throws ServletException {
        context = (ApplicationContext) getServletContext().getAttribute("springContext");
        conductorService = (IConductorService) context.getBean("conductorServiceImpl");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/buscarConductor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cedula = request.getParameter("numeroDeIdentificacion");
        int tipoId = Integer.parseInt(request.getParameter("tipoDeIdentificacion"));

        try {
            Conductor conductor = conductorService.findConductorByNumeroDeIdentificacion(cedula, tipoId);
            List<Vehiculo> vehiculos = conductor.getVehiculos();

            request.setAttribute("conductor", conductor);
            request.setAttribute("vehiculos", vehiculos);
            request.getRequestDispatcher("/resultadoVehiculos.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
