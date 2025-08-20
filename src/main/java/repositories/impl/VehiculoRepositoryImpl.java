package repositories.impl;

import model.Vehiculo;
import org.springframework.stereotype.Repository;
import repositories.IVehiculoRepository;
import java.util.ArrayList;
import java.util.List;

@Repository("vehiculoRepositoryImpl")
public class VehiculoRepositoryImpl implements IVehiculoRepository {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    private List<Vehiculo> vehiculosRemoved = new ArrayList<>();

    @Override
    public List<Vehiculo> getRemovedVehiculos (){
        return vehiculosRemoved;
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculos;
    }

    @Override
    public Vehiculo findByPlaca(String placa) {
        Vehiculo vehiculoReturn = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoReturn = vehiculo;
            }
        }
        return vehiculoReturn;
    }

    @Override
    public void addVehiculoToConductor(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public void deleteVehiculo(Vehiculo vehiculo) {
        vehiculosRemoved.add(vehiculo);
        vehiculos.remove(vehiculo);
    }
}
