package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vehiculo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.IVehiculoService;
import services.impl.VehiculoServiceImpl;

import java.io.IOException;

@WebServlet(name = "buscarVehiculo", value = "/buscar-vehiculo")
public class BuscarVehiculo extends HttpServlet {

    private IVehiculoService vehiculoService;
    private ApplicationContext context;
    @Override
    public void init() {
        context = (ApplicationContext) getServletContext().getAttribute("springContext");
        vehiculoService = (IVehiculoService) context.getBean("vehiculoServiceImpl");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("buscarVehiculo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String placa = request.getParameter("placa");

            Vehiculo vehiculo = vehiculoService.findByPlaca(placa);

            request.setAttribute("vehiculo", vehiculo);
            request.getRequestDispatcher("resultadoVehiculoByPlaca.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
