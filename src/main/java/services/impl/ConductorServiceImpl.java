package services.impl;

import model.Conductor;
import model.TipoDeCargo;
import model.TipoDeID;
import repositories.IConductorRepository;
import services.IConductorService;

import java.util.List;
import java.util.UUID;

import exceptions.ConductorNotFoundException;
import exceptions.ConductorNotValidException;

public class ConductorServiceImpl implements IConductorService {

    private IConductorRepository conductorRepository;

    public ConductorServiceImpl(IConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    @Override
    public List<Conductor> findAll() {
        List<Conductor> conductores = conductorRepository.findAll();
        return conductores;
    }

    @Override
    public void addConductor(String nombre, int cargo, int tipoDeIdentificacion,  String numeroDeIdentificacion) {
        TipoDeCargo cargoEnum = null;
        TipoDeID idEnum = null;
        //Validaciones de los atributos
        if (nombre == null || nombre.isBlank()){
            throw new ConductorNotValidException("El nombre del conductor no puede estar vacío");
        } else if(!nombre.matches("^[A-Za-zÁÉÍÓÚÑ ]+$")){
            throw new ConductorNotValidException("El nombre del conductor no cumple con los caracteres valido (letras)");
        }
        //
        switch (cargo) {
            case 1 -> cargoEnum = TipoDeCargo.SUPERVISOR;
            case 2 -> cargoEnum = TipoDeCargo.CONDUCTOR;
            case 3 -> cargoEnum = TipoDeCargo.AYUDANTE;        
            default -> throw new ConductorNotValidException("El tipo de cargo no esta dentro de las opciones");
        }
        //
        if (numeroDeIdentificacion == null || numeroDeIdentificacion.isBlank()){
            throw new ConductorNotValidException("El numero de identificación no puede estar vacío");
        }
        //
        switch (tipoDeIdentificacion) {
            case 1 :
                idEnum = TipoDeID.CC;
                if(!numeroDeIdentificacion.matches("^[0-9]{6,10}$")){
                    throw new ConductorNotValidException("El numero de CC no cumple con el formato requerido");
                }
            break;
            case 2:
                idEnum = TipoDeID.CE;
                if(!numeroDeIdentificacion.matches("^[A-Z0-9]{6,15}$")){
                    throw new ConductorNotValidException("El numero de CE no cumple con el formato requerido");
                }
            break;
            case 3: 
                idEnum = TipoDeID.NIT;
                if(!numeroDeIdentificacion.matches("^[0-9]{9,10}$")){
                    throw new ConductorNotValidException("El numero de NIT no cumple con el formato requerido");
                }
            break;
            case 4: 
                idEnum = TipoDeID.PASAPORTE;
                if(!numeroDeIdentificacion.matches("^[A-Z0-9]{6,12}$")){
                    throw new ConductorNotValidException("El numero de pasaporte no cumple con el formato requerido");
                }
            break;
            default:
                throw new ConductorNotValidException("El tipo de identificación no esta dentro de las opciones");
        }
        //
        for (Conductor conductor : conductorRepository.findAll()) {
            if (conductor.getNumeroDeIdentificacion().equalsIgnoreCase(numeroDeIdentificacion)) {
                throw new ConductorNotValidException("Ya existe un conductor con ese número de identificación");
            }
        }
        //
        String id = UUID.randomUUID().toString();
        //
        conductorRepository.addConductor(new Conductor(id, nombre, cargoEnum, idEnum, numeroDeIdentificacion));
    }

    @Override
    public Conductor findConductorByNumeroDeIdentificacion(String numeroDeIdentificacion, int tipoDeIdentificacion) {
        if(numeroDeIdentificacion == null || numeroDeIdentificacion.isBlank()){
            throw new ConductorNotValidException("El numero de identificación no puede estar vacío");
        }
        //
        switch (tipoDeIdentificacion) {
            case 1 :
                if(!numeroDeIdentificacion.matches("^[0-9]{6,10}$")){
                    throw new ConductorNotValidException("El numero de CC no cumple con el formato requerido");
                }
            break;
            case 2:
                if(!numeroDeIdentificacion.matches("^[A-Z0-9]{6,15}$")){
                    throw new ConductorNotValidException("El numero de CE no cumple con el formato requerido");
                }
            break;
            case 3:
                if(!numeroDeIdentificacion.matches("^[0-9]{9,10}$")){
                    throw new ConductorNotValidException("El numero de NIT no cumple con el formato requerido");
                }
            break;
            case 4: 
                if(!numeroDeIdentificacion.matches("^[A-Z0-9]{6,12}$")){
                    throw new ConductorNotValidException("El numero de pasaporte no cumple con el formato requerido");
                }
            break;
            default:
                throw new ConductorNotValidException("El tipo de identificación no esta dentro de las opciones");
        }
        //
        Conductor conductorReturn = conductorRepository.findConductorByNumeroDeIdentificacion(numeroDeIdentificacion);
        if(conductorReturn == null){
                throw new ConductorNotFoundException("El conductor que esta buscando no existe");
        }
        return conductorReturn;
    }
}
