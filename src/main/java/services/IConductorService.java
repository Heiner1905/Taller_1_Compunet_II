package services;

import model.Conductor;

import java.util.List;

public interface IConductorService {

    List<Conductor> findAll();

    void addConductor(String nombre, int cargo, int tipoDeIdentificacion,  String numeroDeIdentificacion);

    Conductor findConductorByNumeroDeIdentificacion(String numeroDeIdentificacion, int tipoDeIdentificacion);

    void init();

    void destroy();
}
