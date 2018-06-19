/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import FiltroDAO.filtroDAO;
import Modelo.alumno;
import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblcarnet);
        container.add(lblNombres);
        container.add(lblApellidos);
        container.add(lblUniversidad);
        container.add(lblEdad);
        container.add(carnet);
        container.add(nombre);
        container.add(apellidos);
        container.add(edad);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(limpiar);
        container.add(table);
        container.add(eliminar);
        container.add(Universidad);
        setSize(800, 600);
        eventos();

    }

    public final void agregarLabels() {
        lblcarnet = new JLabel("Carnet");
        lblNombres = new JLabel("Nombres");
        lblApellidos = new JLabel("Apellidos");
        lblUniversidad = new JLabel("Universidad");
        lblEdad = new JLabel("Edad");
        lblcarnet.setBounds(10, 10, ANCHOC, ALTOC);
        lblNombres.setBounds(5, 60, ANCHOC, ALTOC);
        lblApellidos.setBounds(500, 60, ANCHOC, ALTOC);
        lblEdad.setBounds(10, 90, ANCHOC, ALTOC);
        lblUniversidad.setBounds(10, 120, ANCHOC, ALTOC);
    }

    public final void formulario() {
        carnet = new JTextField();
        Universidad = new JComboBox();
        nombre = new JTextField();
        apellidos = new JTextField();
        edad = new JTextField();

        si = new JRadioButton("Si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("limpiar");
        table = new JPanel();
        Universidad.addItem("UCA");
        Universidad.addItem("UDB");
        Universidad.addItem("UFG");
        Universidad.addItem("UGB");
        estado = new ButtonGroup();
        estado.add(si);
        estado.add(no);
        carnet.setBounds(140, 10, ANCHOC, ALTOC);
        nombre.setBounds(140, 60, ANCHOC, ALTOC);
        edad.setBounds(140,90,ANCHOC, ALTOC);
        Universidad.setBounds(140,130,ANCHOC, ALTOC);
        apellidos.setBounds(555, 60, ANCHOC, ALTOC);
        si.setBounds(140, 160, 50, ALTOC);
        no.setBounds(210, 160, 50, ALTOC);
        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 210, ANCHOC, ALTOC);
        actualizar.setBounds(150, 210, ANCHOC, ALTOC);
        eliminar.setBounds(300, 210, ANCHOC, ALTOC);
        limpiar.setBounds(450, 210, ANCHOC, ALTOC);
        resultados = new JTable();
        table.setBounds(10, 300, 500, 200);
        table.add(new JScrollPane(resultados));

    }

    public void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        tm.addColumn("Carnet");
        tm.addColumn("Nombre");
        tm.addColumn("apellidos");
        tm.addColumn("Universidad");
        tm.addColumn("estado");
        filtroDAO fd = new filtroDAO();
        ArrayList<alumno> alumnos = fd.readAll();
        for (alumno i : alumnos) {
            tm.addRow(new Object[]{i.getCarnet(), i.getNombre(), i.getApellidos(), i.getUniversidad()});
        }

        resultados.setModel(tm);

    }

    public void eventos() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                filtroDAO fd = new filtroDAO();
                alumno a = new alumno(Integer.parseInt(carnet.getText()), nombre.getText(), apellidos.getText(), Universidad.getSelectedItem().toString(), Integer.parseInt(edad.getText()), true);

                if (no.isSelected()) {
                    a.setEstado(false);
                }
                if (fd.create(a)) {
                    JOptionPane.showMessageDialog(null, "alumno agregado con exito");
                                     limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar el alumno");
                }
            }

        });

        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtroDAO fd = new filtroDAO();
                alumno a = new alumno(Integer.parseInt(carnet.getText()), nombre.getText(), apellidos.getText(), Universidad.getSelectedItem().toString(), Integer.parseInt(edad.getText()), true);

                if (no.isSelected()) {
                    a.setEstado(false);
                }
                if (fd.create(a)) {
                    JOptionPane.showMessageDialog(null, "alumno agregado con exito");
                                      limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar el alumno");
                }
            }

        });
         eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtroDAO fd = new filtroDAO();
                if (fd.delete(carnet.getText())) {
                    JOptionPane.showMessageDialog(null, "alumno eliminado");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar el alumno");
                }
            }
            
        });
     buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                filtroDAO fd = new filtroDAO();
                alumno f = fd.read(carnet.getText());
                if (f == null) {
                    JOptionPane.showMessageDialog(null, "El alumno que busca no se ha encontrdo");
                } else {
                    carnet.setText(Integer.toString(f.getCarnet()));
                    Universidad.setSelectedItem(f.getUniversidad());
                    nombre.setText((f.getNombre()));
                    apellidos.setText(f.getApellidos());
                    edad.setText(Integer.toString(f.getEdad()));
                    if (f.isEstado()) {
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }
            }
            
        });
     limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarCampos();
            }
            
        });
    }
   public void limpiarCampos() {
        carnet.setText("");
        Universidad.setSelectedItem("UCA");
        nombre.setText("");
        apellidos.setText("");
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
