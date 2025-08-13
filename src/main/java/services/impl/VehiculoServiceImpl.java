package services.impl;

import model.Vehiculo;
import services.IVehiculoService;

import java.util.List;

public class VehiculoServiceImpl implements IVehiculoService {

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
