package services;

import model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> findAll();

    Vehiculo findByPlaca(String placa);

    void addVehiculoToConductor(String placa, int cilindraje, int tipoDeCombustible, String numeroDeMotor, String marca, int modelo, String conductorID, int tipoIDConductor);

    void deleteVehiculo(String placa);

    List<Vehiculo> getRemovedVehiculos();

    void init();

    void destroy();
}
