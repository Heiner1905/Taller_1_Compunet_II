package services.impl;

import model.Conductor;
import model.TipoDeCombustible;
import model.Vehiculo;
import repositories.IConductorRepository;
import repositories.IVehiculoRepository;
import services.IConductorService;
import services.IVehiculoService;
import exceptions.*;

import java.time.Year;
import java.util.List;
import java.util.UUID;



public class VehiculoServiceImpl implements IVehiculoService {

    private IVehiculoRepository vehiculoRepository;
    private IConductorService conductorService;

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository, IConductorService conductorService) {
        this.vehiculoRepository = vehiculoRepository;
        this.conductorService = conductorService;

    }
    @Override
    public List<Vehiculo> findAll() {
        List<Vehiculo> vehiculosFromRepository = vehiculoRepository.findAll();
        return vehiculosFromRepository;
    }

    @Override
    public List<Vehiculo> getRemovedVehiculos(){
        return vehiculoRepository.getRemovedVehiculos();
    }

    @Override
    public Vehiculo findByPlaca(String placa) {
        Vehiculo vehiculoReturn;
        List<Vehiculo> vehiculosRemoved = getRemovedVehiculos();
        //Validaciones de la placa
        if (placa == null || placa.isBlank()){
            throw new InvalidPlacaException("La placa no puede estar vacia");
        }
        if(!placa.toUpperCase().matches("^[A-Z]{3}[0-9]{3}$")){
            throw new InvalidPlacaException("La placa no cumple con el formato (eje: FUL519)");
        }
        //Validaciones del vehiculo
        for (Vehiculo vehiculo : vehiculosRemoved) {
            if(vehiculo.getPlaca().equalsIgnoreCase(placa)){
                throw new VehiculoRemovedException("El vehiculo con la placa " +placa+" fue eliminado. No esta disponible");
            }
        }
        //
        vehiculoReturn = vehiculoRepository.findByPlaca(placa);
        //
        if (vehiculoReturn == null){
            throw new VehiculoNotFoundException("Él vehiculo con la placa " + placa + " no ha sido encontrado");
        }
        return vehiculoReturn;
    }

    @Override
    public void addVehiculoToConductor(String placa, int cilindraje, int tipoDeCombustible, String numeroDeMotor, String marca, int modelo, String conductorID, int tipoIDConductor) {
        TipoDeCombustible tipoDeCombustibleEnum;
        //Validaciones del vehiculo
        if (placa == null || placa.isBlank()){
            throw new VehiculoNotValidException("La placa del vehiculo no puede estar vacía");
        } else if(!placa.toUpperCase().matches("^[A-Z]{3}[0-9]{3}$")){
            throw new VehiculoNotValidException("La placa del vehiculo no cumple con el formato requerido (Ej: FUL519)");
        } 

        for (Vehiculo vehiculo : vehiculoRepository.findAll()) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)){
                throw new VehiculoNotValidException("El vehiculo con placa "+ placa +" ya existe");
            }
        }
        //
        if (cilindraje<=0){
            throw new VehiculoNotValidException("El cinlindraje del vehiculo no puede ser menor o igual a cero");
        }
        //
        switch (tipoDeCombustible) {
            case 1 -> tipoDeCombustibleEnum = TipoDeCombustible.GASOLINA;
            case 2 -> tipoDeCombustibleEnum = TipoDeCombustible.DIESEL;
            case 3 -> tipoDeCombustibleEnum = TipoDeCombustible.ELECTRICO;
            case 4 -> tipoDeCombustibleEnum = TipoDeCombustible.HIBRIDO;
            default -> throw new VehiculoNotValidException("El tipo de combustible no está dentro de las opciones");
        }

        //
        if (numeroDeMotor == null || numeroDeMotor.isBlank()){
            throw new VehiculoNotValidException("El numero de motor del vehiculo no puede estar vacío");
        } else if (!numeroDeMotor.matches("^[A-Z0-9]{12}$")){
            throw new VehiculoNotValidException("El numero de motor no es valido. Deben ser 12 caracteres alfanumericos");
        }
        //
        if (marca == null || marca.isBlank()){
            throw new VehiculoNotValidException("La marca del vehiculo no puede estar vacía");
        }
        //
        int currentYear = Year.now().getValue();
        if (modelo < 1980 || modelo > currentYear+1){
            throw new VehiculoNotValidException("El modelo del vehiculo no es valido");
        }
        //
        String id = UUID.randomUUID().toString();
        //Obtenemos el conductor
        Conductor conductor = conductorService.findConductorByNumeroDeIdentificacion(conductorID, tipoIDConductor);
        //Creamos el vehiculo
        Vehiculo vehiculo = new Vehiculo(id, placa, cilindraje, tipoDeCombustibleEnum, numeroDeMotor, marca, modelo, conductor);
        //Guardamos el vehiculo
        vehiculoRepository.addVehiculoToConductor(vehiculo);
        conductor.getVehiculos().add(vehiculo);
    }

    @Override
    public void deleteVehiculo(String placa) {
        Vehiculo vehiculo = findByPlaca(placa);
        Conductor conductor = vehiculo.getConductor();
        //
        conductor.getVehiculos().remove(vehiculo);
        vehiculoRepository.deleteVehiculo(vehiculo);
    }
}
