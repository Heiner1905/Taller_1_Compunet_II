package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Conductor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.IConductorService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listarConductores", value = "/listar-todos-los-conductores")
public class ListarConductores extends HttpServlet {
    private ApplicationContext context;
    private IConductorService conductorService;

    @Override
    public void init() throws ServletException {
        super.init();
        context=(ApplicationContext) getServletContext().getAttribute("springContext");
        conductorService = (IConductorService) context.getBean("conductorServiceImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Conductor> conductores = conductorService.findAll();
        req.setAttribute("conductores", conductores);
        req.getRequestDispatcher("listarConductores.jsp").forward(req, resp);
    }

}
