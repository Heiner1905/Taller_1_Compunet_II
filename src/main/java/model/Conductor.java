package model;

import java.util.ArrayList;
import java.util.List;

public class Conductor {
    private String id;
    private String nombre;
    private TipoDeCargo cargo;
    private TipoDeID tipoDeIdentificacion;
    private String numeroDeIdentificacion;

    //Relation 1:N
    private List<Vehiculo> vehiculos;

    public Conductor(String id, String nombre, TipoDeCargo cargo, TipoDeID tipoDeIdentificacion,  String numeroDeIdentificacion) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.numeroDeIdentificacion = numeroDeIdentificacion;
        this.vehiculos = new ArrayList<>();
    }

    public List<Vehiculo> getVehiculos(){
        return vehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDeCargo getCargo() {
        return cargo;
    }

    public void setCargo(TipoDeCargo cargo) {
        this.cargo = cargo;
    }

    public TipoDeID getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(TipoDeID tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public String getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public void setNumeroDeIdentificacion(String numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }
}
