package repositories.impl;

import model.Conductor;
import repositories.IConductorRepository;

import java.util.List;

public class ConductorRepositoryImpl implements IConductorRepository {
    @Override
    public List<Conductor> findAll() {
        return List.of();
    }

    @Override
    public void addConductor(Conductor conductor) {

    }

    @Override
    public Conductor findConductorByNumeroDeIdentificacion(String numeroDeIdentificacion) {
        return null;
    }
}
