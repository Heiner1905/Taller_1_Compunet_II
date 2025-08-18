package model;

public class Vehiculo {
    private String id;
    private String placa;
    private int cilindraje;
    private TipoDeCombustible tipoDeCombustible;
    private String numeroDeMotor;
    private String marca;
    private int modelo;

    private Conductor conductor;

    public Vehiculo(String id, String placa, int cilindraje, TipoDeCombustible tipoDeCombustible, String numeroDeMotor, String marca, int modelo, Conductor conductor) {
        this.id = id;
        this.placa = placa;
        this.cilindraje = cilindraje;
        this.tipoDeCombustible = tipoDeCombustible;
        this.numeroDeMotor = numeroDeMotor;
        this.marca = marca;
        this.modelo = modelo;
        this.conductor = conductor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public TipoDeCombustible getTipoDeCombustible() {
        return tipoDeCombustible;
    }

    public void setTipoDeCombustible(TipoDeCombustible tipoDeCombustible) {
        this.tipoDeCombustible = tipoDeCombustible;
    }

    public String getNumeroDeMotor() {
        return numeroDeMotor;
    }

    public void setNumeroDeMotor(String numeroDeMotor) {
        this.numeroDeMotor = numeroDeMotor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public Conductor getConductor(){
        return this.conductor;
    }

    public void setConductor(Conductor conductor){
        this.conductor = conductor;
    }
}
