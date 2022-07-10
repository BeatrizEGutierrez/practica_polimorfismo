package mision.tic.polomorfismo;

import mision.tic.polomorfismo.forms.FrmTienda;
import mision.tic.polomorfismo.tienda.Tienda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmTienda(new Tienda()).setVisible(true));
    }
}
