package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vehiculo;
import org.springframework.context.ApplicationContext;
import services.IVehiculoService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listarVehiculos", value = "/listar-vehiculos")
public class ListarVehiculos extends HttpServlet {
    ApplicationContext context;
    IVehiculoService vehiculoService;
    @Override
    public void init() throws ServletException {
        super.init();
        context=(ApplicationContext) getServletContext().getAttribute("springContext");
        vehiculoService = (IVehiculoService) context.getBean("vehiculoServiceImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Vehiculo> vehiculos=vehiculoService.findAll();
        req.setAttribute("vehiculos",vehiculos);
        req.getRequestDispatcher("listarVehiculos.jsp").forward(req,resp);
    }
}
