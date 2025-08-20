package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.IVehiculoService;
import services.impl.VehiculoServiceImpl;

import java.io.IOException;

@WebServlet(name = "agregarVehiculo", value = "/agregar-vehiculo")
public class AgregarVehiculo extends HttpServlet {

    private IVehiculoService vehiculoService;
    ApplicationContext context;
    @Override
    public void init() {
        context = (ApplicationContext) getServletContext().getAttribute("springContext");
        vehiculoService = (IVehiculoService) context.getBean("vehiculoServiceImpl");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("agregarVehiculo.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String placa = request.getParameter("placa");
            int cilindraje = Integer.parseInt(request.getParameter("cilindraje"));
            int tipoCombustible = Integer.parseInt(request.getParameter("tipoCombustible"));
            String numeroMotor = request.getParameter("numeroMotor");
            String marca = request.getParameter("marca");
            int modelo = Integer.parseInt(request.getParameter("modelo"));
            String conductorID = request.getParameter("conductorID");
            int tipoIDConductor = Integer.parseInt(request.getParameter("tipoIDConductor"));

            vehiculoService.addVehiculoToConductor(placa, cilindraje, tipoCombustible, numeroMotor, marca, modelo, conductorID, tipoIDConductor);

            request.setAttribute("mensaje", "El vehiculo con la placa "+placa+" fue agregado correctamente");
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
