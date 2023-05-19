package interfaz;

import entidades.personas.ListaUsuarios;

import javax.swing.*;

public class Dashboard {
    private JPanel panelPrincipal;
    private JPanel wrapperPanelDashboard;
    private JPanel wrapperFiguras;
    private JLabel promedioVehiculos;
    private JLabel cantidadUsuarios;
    private JPanel wrapperPromedioVehiculos;
    private JPanel wrapperCantidadUsuarios;
    private JPanel wrapperDepartamento;
    private JLabel departamentoConMasUsuarios;
    private JLabel valorPromedioVehiculos;
    private JLabel valorCantidadUsuarios;
    private JLabel valorDepartamentoConMasUsuarios;

    public Dashboard(ListaUsuarios usuarios){
        actualizarInformacion(usuarios);
        agregarIconos();
    }

    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }

    public void actualizarInformacion(ListaUsuarios usuarios){
        double promedioVehiculos = usuarios.getPromedioVehiculos();
        this.valorPromedioVehiculos.setText(Double.isNaN(promedioVehiculos) ? "N/A" : String.valueOf(promedioVehiculos));
        this.valorCantidadUsuarios.setText(String.valueOf(usuarios.getCantidad()));
        this.valorDepartamentoConMasUsuarios.setText(usuarios.getDepartamentoConMasUsuarios());
    }

    private void agregarIconos(){
        ImageIcon iconoAuto = new ImageIcon("src/imagenes/auto.png");
        promedioVehiculos.setIcon(iconoAuto);

        ImageIcon iconoUsuarios = new ImageIcon("src/imagenes/usuarios.png");
        cantidadUsuarios.setIcon(iconoUsuarios);

        ImageIcon iconoUruguay = new ImageIcon("src/imagenes/uruguay.png");
        departamentoConMasUsuarios.setIcon(iconoUruguay);

        JLabel[] labelsIconos = {promedioVehiculos, cantidadUsuarios, departamentoConMasUsuarios};
        for(JLabel label: labelsIconos){
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
        }

    }
}
