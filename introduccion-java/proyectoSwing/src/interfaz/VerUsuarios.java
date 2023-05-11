package interfaz;

import entidades.personas.ListaUsuarios;
import entidades.personas.Persona;
import entidades.vehiculos.ListaVehiculos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VerUsuarios {
    private JPanel panelPrincipal;
    private JTable tablaUsuarios;
    private JScrollPane panelTablaUsuarios;
    private JLabel tituloUsuarios;
    private JPanel wrapperTitulo;
    private JPanel wrapperPanelTablaUsuarios;

    public void refrezcarTabla(ListaUsuarios listaDeUsuarios){
        DefaultTableModel modeloTabla = new DefaultTableModel(null, new String[] {"ID", "Nombre", "Apellido", "Departamento", "Número de hijos", "Fecha de nacimiento", "Vehículos"}){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        for(Persona usuario : listaDeUsuarios.getUsuarios()){
            Object[] datosPersona = {
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getDptoResidencia(),
                    usuario.getCantidadHijos(),
                    usuario.getFechaNacimiento(),
                    usuario.getVehiculos().getCantidad()
            };

            modeloTabla.addRow(datosPersona);
        }

        MouseListener[] listeners = tablaUsuarios.getMouseListeners();
        for (MouseListener listener : listeners) {
            tablaUsuarios.removeMouseListener(listener);
        }

        this.tablaUsuarios.setModel(modeloTabla);

        this.tablaUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int columna = tablaUsuarios.columnAtPoint(e.getPoint());
                int fila = tablaUsuarios.rowAtPoint(e.getPoint());

                int idUsuario = (int) modeloTabla.getValueAt(fila, 0);
                Persona usuario = listaDeUsuarios.getUsuarioPorId(idUsuario);

                int indiceColumnaVehiculos = 6;
                if(SwingUtilities.isLeftMouseButton(e) && columna == indiceColumnaVehiculos && usuario.getVehiculos().getCantidad() > 0){
                    mostrarDescripciones(usuario.getNombre(), usuario.getApellido(), usuario.getVehiculos());
                }
            }
        });
    }

    private void mostrarDescripciones(String nombreUsuario, String apellidoUsuario, ListaVehiculos vehiculos){
        JFrame marco = new JFrame();
        marco.setTitle("Vehículos de " + nombreUsuario + " " + apellidoUsuario);
        marco.setSize(400, 300);
        marco.setLocationRelativeTo(null);

        JList<String> listaDescripciones = new JList<>(vehiculos.getDescripciones());

        JScrollPane panelScrolleable = new JScrollPane(listaDescripciones);
        marco.add(panelScrolleable);

        marco.setVisible(true);
    }

    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }
}

