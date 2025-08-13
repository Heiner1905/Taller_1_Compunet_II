package repositories;

import model.Conductor;

import java.util.List;

public interface IConductorRepository {

    List<Conductor> findAll();

    void addConductor(Conductor conductor);

    Conductor findConductorByNumeroDeIdentificacion(String numeroDeIdentificacion);
}
