package repositories.impl;

import model.Vehiculo;
import repositories.IVehiculoRepository;

import java.util.List;

public class VehiculoRepositoryImpl implements IVehiculoRepository {
    @Override
    public List<Vehiculo> findAll() {
        return List.of();
    }

    @Override
    public Vehiculo findByPlaca(String placa) {
        return null;
    }

    @Override
    public void addVehiculoToConductor(Vehiculo vehiculo) {

    }

    @Override
    public void deleteVehiculoByPlaca(String placa) {

    }
}
