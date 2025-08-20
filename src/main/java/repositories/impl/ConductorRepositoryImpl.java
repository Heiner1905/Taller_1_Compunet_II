package repositories.impl;

import model.Conductor;
import org.springframework.stereotype.Repository;
import repositories.IConductorRepository;

import java.util.ArrayList;
import java.util.List;

@Repository("conductorRepositoryImpl")
public class ConductorRepositoryImpl implements IConductorRepository {

    private List<Conductor> conductores = new ArrayList<>();

    @Override
    public List<Conductor> findAll() {
        return conductores;
    }

    @Override
    public void addConductor(Conductor conductor) {
        conductores.add(conductor);
    }

    @Override
    public Conductor findConductorByNumeroDeIdentificacion(String numeroDeIdentificacion) {
        Conductor conductorReturn = null;
        for (Conductor conductor : conductores) {
            if(conductor.getNumeroDeIdentificacion().equalsIgnoreCase(numeroDeIdentificacion)){
                conductorReturn = conductor;
            }
        }
        return conductorReturn;
    }
}
