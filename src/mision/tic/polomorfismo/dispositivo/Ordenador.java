package mision.tic.polomorfismo.dispositivo;

public class Ordenador extends Dispositivo {

    private boolean gamer;
    private boolean portatil;

    public Ordenador(double precio, String marca, String garantia, String gama, String sistemaOperativo,boolean gamer,boolean portatil) {
        super(precio, marca, garantia, gama, sistemaOperativo);
        this.gamer = gamer;
        this.portatil = portatil;
    }

    public boolean isGamer() {
        return gamer;
    }

    public void setGamer(boolean gamer) {
        this.gamer = gamer;
    }

    public boolean isPortatil() {
        return portatil;
    }

    public void setPortatil(boolean portatil) {
        this.portatil = portatil;
    }
}
