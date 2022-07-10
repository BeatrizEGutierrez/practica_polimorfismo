package mision.tic.polomorfismo.tienda;

import mision.tic.polomorfismo.dispositivo.Celular;
import mision.tic.polomorfismo.dispositivo.Dispositivo;
import mision.tic.polomorfismo.dispositivo.Ordenador;
import mision.tic.polomorfismo.dispositivo.Tablet;
import mision.tic.polomorfismo.interfaces.IMovil;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private final List<Dispositivo> dispositivoList = new ArrayList<>();

    public Tienda() {
        Dispositivo dispositivo1 = new Celular(2500000D, "Samsung", "1 año", "alta","Android","Claro", false);
        Dispositivo dispositivo2 = new Ordenador(3000000D,"Hp", "1 año", "Alta", "Windows", true, true);
        Dispositivo dispositivo3 = new Ordenador(1500000D,"Acer", "1 año", "Media", "Windows", false, false);
        Dispositivo dispositivo4 = new Tablet(2000000D,"Huawei", "1 año", "Alta", "Android",  false);

        dispositivoList.add(dispositivo1);
        dispositivoList.add(dispositivo2);
        dispositivoList.add(dispositivo3);
        dispositivoList.add(dispositivo4);

        IMovil iMovil = new Celular(2500000D, "Samsung", "1 año", "alta","Android","Claro", false);
        IMovil iMovil2 = new Tablet(2000000D,"Huawei", "1 año", "Alta", "Android",  false);

        List<IMovil> iMovilList = new ArrayList<>();
        iMovilList.add(iMovil);
        iMovilList.add(iMovil2);

        for (IMovil iMovilTest : iMovilList) {
            iMovilTest.realizarLLamada("31254212");
        }
    }

    public List<Dispositivo> listarDispositivos() {
        return dispositivoList;
    }
}
