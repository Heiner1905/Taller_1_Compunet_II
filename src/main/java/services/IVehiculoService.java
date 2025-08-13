package services;

import model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> findAll();

    Vehiculo findByPlaca(String placa);

    void addVehiculoToConductor(Vehiculo vehiculo);

    void deleteVehiculoByPlaca(String placa);
}
