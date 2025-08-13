package services;

import model.Conductor;

import java.util.List;

public interface IConductorService {

    List<Conductor> findAll();

    void addConductor(Conductor conductor);

    Conductor findConductorByNumeroDeIdentificacion(String numeroDeIdentificacion);
}
