package mision.tic.polomorfismo.dispositivo;

import mision.tic.polomorfismo.interfaces.IMovil;

public class Tablet extends Dispositivo implements IMovil {

    private boolean puertoSim;

    public Tablet(double precio, String marca, String garantia, String gama, String sistemaOperativo, boolean puertoSim) {
        super(precio, marca, garantia, gama, sistemaOperativo);
        this.puertoSim = puertoSim;
    }

    public boolean isPuertoSim() {
        return puertoSim;
    }

    public void setPuertoSim(boolean puertoSim) {
        this.puertoSim = puertoSim;
    }

    @Override
    public void realizarLLamada(String numero) {
        if (puertoSim) {
            System.out.println("Realizando llamada: " + numero);
        } else {
            System.out.println("Este dispositivo no puede realizar llamadas");
        }
    }
}

