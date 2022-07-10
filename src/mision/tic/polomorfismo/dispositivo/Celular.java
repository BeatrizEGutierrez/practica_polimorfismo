package mision.tic.polomorfismo.dispositivo;

import mision.tic.polomorfismo.interfaces.IMovil;

public class Celular extends Dispositivo implements IMovil {

    private String operador;
    private boolean dobleSim;

    public Celular(double precio, String marca, String garantia, String gama, String sistemaOperativo, String operador, boolean dobleSim) {
        super(precio, marca, garantia, gama, sistemaOperativo);
        this.operador = operador;
        this.dobleSim = dobleSim;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public boolean isDobleSim() {
        return dobleSim;
    }

    public void setDobleSim(boolean dobleSim) {
        this.dobleSim = dobleSim;
    }

    @Override
    public void realizarLLamada(String numero) {
        System.out.println("Realizando llamada: " + numero);
    }
}
