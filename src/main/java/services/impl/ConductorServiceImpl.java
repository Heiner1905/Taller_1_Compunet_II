package services.impl;

import model.Conductor;
import services.IConductorService;

import java.util.List;

public class ConductorServiceImpl implements IConductorService {

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
