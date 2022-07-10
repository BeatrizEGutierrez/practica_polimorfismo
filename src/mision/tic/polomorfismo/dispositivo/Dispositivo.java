package mision.tic.polomorfismo.dispositivo;

public abstract class Dispositivo {

    private double precio;
    private String marca;
    private String garantia;
    private String gama;
    private String sistemaOperativo;

    public Dispositivo(double precio, String marca, String garantia, String gama, String sistemaOperativo) {
        this.precio = precio;
        this.marca = marca;
        this.garantia = garantia;
        this.gama = gama;
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
}
