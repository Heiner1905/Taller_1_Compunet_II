package servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class SpringContextLoader implements ServletContextListener {

    private ApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        sce.getServletContext().setAttribute("springContext", context);
        System.out.println("Spring ApplicationContext cargado en el inicio de la app");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("Spring ApplicationContext destruido");
    }
}
