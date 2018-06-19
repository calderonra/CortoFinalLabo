/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LN710Q
 */
public class ventana extends JFrame {

    public JLabel lblcarnet, lblNombres, lblApellidos, lblUniversidad, lblEdad;
    public JTextField carnet, nombre, apellidos, edad;
    public JComboBox Universidad;

    ButtonGroup estado = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;

    public JPanel table;

    public JButton buscar, eliminar, insertar, limpiar, actualizar;

    private static final int ANCHOC = 130, ALTOC = 30;

    DefaultTableModel tm;

    public ventana() {
        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //agregarLabels();
        //formulario();
        //llenarTabla();
        Container container = getContentPane();
        container.add(lblcarnet);
        container.add(lblNombres);
        container.add(lblApellidos);
        container.add(lblUniversidad);
        container.add(carnet);
        container.add(nombre);
        container.add(apellidos);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(limpiar);
        container.add(table);
        container.add(eliminar);
        setSize(800, 600);
        //eventos();

    }
   public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ventana().setVisible(true);
            }
            
        });
    }
}
