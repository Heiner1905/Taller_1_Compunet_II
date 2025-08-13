package repositories;

import model.Vehiculo;

import java.util.List;

public interface IVehiculoRepository {

    List<Vehiculo> findAll();

    Vehiculo findByPlaca(String placa);

    void addVehiculoToConductor(Vehiculo vehiculo);

    void deleteVehiculoByPlaca(String placa);
}
