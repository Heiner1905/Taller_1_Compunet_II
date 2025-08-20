package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.IConductorRepository;
import repositories.IVehiculoRepository;
import repositories.impl.ConductorRepositoryImpl;
import repositories.impl.VehiculoRepositoryImpl;
import services.IConductorService;
import services.IVehiculoService;
import services.impl.ConductorServiceImpl;
import services.impl.VehiculoServiceImpl;

@Configuration
public class AppConfig {


    @Bean(name = "conductorRepositoryImpl")
    public IConductorRepository conductorRepository() {
        return new ConductorRepositoryImpl();
    }

    @Bean(name = "vehiculoRepositoryImpl")
    public IVehiculoRepository vehiculoRepository() {
        return new VehiculoRepositoryImpl();
    }

    @Bean(name = "conductorServiceImpl", initMethod = "init", destroyMethod = "destroy")
    public IConductorService conductorService() {
        return new ConductorServiceImpl(conductorRepository());
    }

    @Bean(name = "vehiculoServiceImpl", initMethod = "init", destroyMethod = "destroy")
    public IVehiculoService vehiculoService() {
        return new VehiculoServiceImpl(vehiculoRepository(), conductorService());
    }
}
