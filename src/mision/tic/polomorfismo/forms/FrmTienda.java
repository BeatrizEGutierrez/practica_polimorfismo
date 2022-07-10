package mision.tic.polomorfismo.forms;

import mision.tic.polomorfismo.dispositivo.Celular;
import mision.tic.polomorfismo.dispositivo.Dispositivo;
import mision.tic.polomorfismo.dispositivo.Ordenador;
import mision.tic.polomorfismo.dispositivo.Tablet;
import mision.tic.polomorfismo.tienda.Tienda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;
public class FrmTienda extends JFrame {

    private final Tienda tienda;
    private final List<Dispositivo> carritoCompra;

    public FrmTienda(Tienda tienda) {
        iniciarComponentes();
        this.tienda = tienda;
        this.carritoCompra = new ArrayList<>();
    }

    private void iniciarComponentes() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 300));
        setMaximumSize(new Dimension(600, 300));

        btnListar.addActionListener(this.btnListarClik());
        btnAgregarAlCarrito.addActionListener(this.btnAgregarAlCarritoClick());
        btnComprar.addActionListener(this.btnComprarClick());

        pnlBotones.setLayout(new BoxLayout(pnlBotones, BoxLayout.X_AXIS));
        pnlBotones.add(btnListar);
        pnlBotones.add(Box.createRigidArea(new Dimension(5, 0)));
        pnlBotones.add(btnAgregarAlCarrito);
        pnlBotones.add(Box.createRigidArea(new Dimension(5, 0)));
        pnlBotones.add(btnComprar);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Precio", "Marca", "Garantia", "Gama", "sistemaOperativo"});
        tblListaProductos.setModel(tableModel);
        tblListaProductos.addMouseListener(this.mouseListenerTable());

        jScrollPane.setViewportView(tblListaProductos);

        lblInformacion.setMinimumSize(new Dimension(400, 22));

        pnlContenedor.setLayout(new BoxLayout(pnlContenedor, BoxLayout.Y_AXIS));
        pnlContenedor.add(Box.createRigidArea(new Dimension(0, 5)));
        pnlContenedor.add(pnlBotones);
        pnlContenedor.add(Box.createRigidArea(new Dimension(0, 5)));
        pnlContenedor.add(jScrollPane);
        pnlContenedor.add(Box.createRigidArea(new Dimension(0, 5)));
        pnlContenedor.add(lblInformacion);
        pnlContenedor.add(Box.createRigidArea(new Dimension(0, 5)));

        getContentPane().add(pnlContenedor);
    }

    private ActionListener btnListarClik() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Dispositivo> dispositivoList = tienda.listarDispositivos();

                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setColumnIdentifiers(new String[]{"Precio", "Marca", "Garantia", "Gama", "sistemaOperativo"});

                for(Dispositivo dispositivo : dispositivoList) {
                    tableModel.addRow(new Object[]{dispositivo.getPrecio(), dispositivo.getMarca(), dispositivo.getGarantia(), dispositivo.getGama(), dispositivo.getSistemaOperativo()});
                }

                tblListaProductos.setModel(tableModel);
            }
        };
    }

    private ActionListener btnAgregarAlCarritoClick() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = tblListaProductos.getSelectedRow();
                Dispositivo dispositivo = tienda.listarDispositivos().get(index);
                carritoCompra.add(dispositivo);

                JOptionPane.showMessageDialog(null,"El dispositivo: " + dispositivo.getMarca() + " fue agregado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        };
    }

    private ActionListener btnComprarClick(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double total = 0;

                for(Dispositivo dispositivo : carritoCompra) {
                    total += dispositivo.getPrecio();
                }

                JOptionPane.showMessageDialog(null, "El total de la compra es " + total + ", gracias por su compra", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                carritoCompra.clear();
            }
        };
    }

    private MouseListener mouseListenerTable() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int index = tblListaProductos.getSelectedRow();
                Dispositivo dispositivo = tienda.listarDispositivos().get(index);

                if(dispositivo instanceof Celular) {
                    Celular celular = (Celular) dispositivo;
                    lblInformacion.setText("Informacion: " + "tipo: celular, operador: " + celular.getOperador() + ", Es doble sim: " + celular.isDobleSim());
                }

                if(dispositivo instanceof Ordenador) {
                    Ordenador ordenador = (Ordenador) dispositivo;
                    lblInformacion.setText("Informacion: " + "tipo: ordenador, es gamer: " + ordenador.isGamer() + ", Es portatil: " + ordenador.isPortatil());
                }

                if (dispositivo instanceof Tablet) {
                    Tablet tablet = (Tablet) dispositivo;
                    lblInformacion.setText("Informacion: " + "tipo: tablet, tiene puerto sim: " + tablet.isPuertoSim());
                }
            }
        };
    }

    public final JPanel pnlBotones = new JPanel();
    public final JPanel pnlContenedor = new JPanel();
    public final JTable tblListaProductos = new JTable();
    public final JScrollPane jScrollPane = new JScrollPane();
    public final JButton btnListar = new JButton("Listar");
    public final JButton btnAgregarAlCarrito = new JButton("Agregar al carrito");
    public final JButton btnComprar = new JButton("Comprar");
    private final JLabel lblInformacion = new JLabel("Informacion: ");
}
