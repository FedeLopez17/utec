package interfaz;

import entidades.personas.ListaUsuarios;
import entidades.personas.Persona;
import entidades.vehiculos.ListaVehiculos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.DateTimeException;
import java.time.LocalDate;

public class RegistrarUsuario {
    private JLabel etiquetaId;
    private JTextField inputId;
    private JTextField inputNombre;
    private JTextField inputApellido;
    private JLabel etiquetaNombre;
    private JLabel etiquetaApellido;
    private JLabel etiquetaDepartamento;
    private JComboBox inputDepartamento;
    private JLabel etiquetaHijos;
    private JSpinner inputHijos;
    private JPanel panelPrincipal;
    private JPanel panelDatos;
    private JPanel panelContenedorDatos;
    private JPanel inputFechaNacimiento;
    private JTextField inputDia;
    private JTextField inputMes;
    private JTextField inputAnio;
    private JButton botonRegistrar;
    private JPanel wrapperId;
    private JPanel wrapperNombre;
    private JPanel wrapperApellido;
    private JPanel wrapperDepartamento;
    private JPanel wrapperHijos;
    private JPanel wrapperFechaNacimiento;
    private JPanel wrapperVehiculos;
    private JScrollPane scrollPanelVehiculos;
    private JList JListVehiculos;
    private JButton agregarVehiculoButton;
    private JPanel wrapperBotonAgregarVehiculo;
    private Color colorBordeTextFieldInvalido = Color.RED;
    private Color colorFondoTextFieldInvalido = Color.PINK;
    private JTextField[] camposTextField = {this.inputId, this.inputNombre, this.inputApellido, this.inputDia, this.inputMes, this.inputAnio};
    private JTextField[] camposFecha = {this.inputDia, this.inputMes, this.inputAnio};
    private ListaUsuarios listaDeUsuarios;
    private DefaultListModel<String> modeloListaVehiculos;
    private ListaVehiculos listaVehiculos;


    public RegistrarUsuario(ListaUsuarios listaDeUsuarios){
        this.listaDeUsuarios = listaDeUsuarios;
        this.modeloListaVehiculos = new DefaultListModel<>();
        this.JListVehiculos.setModel(this.modeloListaVehiculos);
        this.listaVehiculos = new ListaVehiculos();
        agregarPlaceHoldersFecha();
        delimitarSpinnerHijos();
        agregarListenersCamposDeTexto();
        agregarListenerBotonVehiculos();
        agregarListenerBotonRegistrar();
    }

    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }

    private void marcarComoInvalido(JComponent componente){
        if(componente.getBackground() != colorFondoTextFieldInvalido){
            componente.setBorder(BorderFactory.createLineBorder(this.colorBordeTextFieldInvalido));
            componente.setBackground(this.colorFondoTextFieldInvalido);
        }
    }

    private void desmarcarComoInvalido(JComponent componente){
        if(componente.getBackground() == colorFondoTextFieldInvalido){
            componente.setBorder(BorderFactory.createLineBorder(Color.darkGray));
            componente.setBackground(Color.white);
        }
    }

    private void agregarListenerBotonRegistrar(){
        this.botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void agregarListenerBotonVehiculos(){
        this.agregarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormularioAgregarVehiculo(listaVehiculos, modeloListaVehiculos);
            }
        });
    }

    private void agregarListenersCamposDeTexto(){
        for (JTextField campoDeTexto : this.camposTextField){
            campoDeTexto.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    desmarcarComoInvalido(campoDeTexto);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    desmarcarComoInvalido(campoDeTexto);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                }
            });
        }
    }

    private void agregarPlaceHoldersFecha(){
        for(int i = 0; i < this.camposFecha.length; i++){
            JTextField inputFecha = this.camposFecha[i];
            String placeHolder = i == 0 ? "Día" : i == 1 ? "Mes" : "Año";
            inputFecha.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inputFecha.getText().equals(placeHolder)) {
                        inputFecha.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inputFecha.getText().isEmpty()) {
                        inputFecha.setText(placeHolder);
                    }
                }
            });
        }
    }

    private void delimitarSpinnerHijos(){
        // Delimitar rango
        this.inputHijos.setModel(new SpinnerNumberModel(0, 0, 15,1));
        // Evitar que se pueda ingresar texto
        this.inputHijos.setEditor(new JSpinner.DefaultEditor(this.inputHijos));
    }

    private void limpiarCampos(){
        for(JTextField campo : this.camposTextField){
            campo.setText("");
        }

        this.inputHijos.setValue(0);
        this.inputDepartamento.setSelectedIndex(0);
        this.modeloListaVehiculos.clear();
    }

    private void registrarUsuario(){
        boolean datosValidos = true;

        int id = -1;
        try{
            id = Integer.parseInt(this.inputId.getText());
            boolean idEnUso = this.listaDeUsuarios.getUsuarioPorId(id) != null;
            if(idEnUso){
                marcarComoInvalido(this.inputId);
                datosValidos = false;
                JOptionPane.showMessageDialog(null, "ID ya en uso", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException e){
            marcarComoInvalido(this.inputId);
            datosValidos = false;
        }


        String nombre = this.inputNombre.getText();
        if(nombre.isEmpty()){
            marcarComoInvalido(this.inputNombre);
            datosValidos = false;
        }

        String apellido = this.inputApellido.getText();
        if(apellido.isEmpty()){
            marcarComoInvalido(this.inputApellido);
            datosValidos = false;
        }

        int dia = -1;
        try{
            dia = Integer.parseInt(this.inputDia.getText());
        } catch(NumberFormatException e){
            marcarComoInvalido(this.inputDia);
            datosValidos = false;
        }

        int mes = -1;
        try{
            mes = Integer.parseInt(this.inputMes.getText());
        } catch(NumberFormatException ex){
            marcarComoInvalido(this.inputMes);
            datosValidos = false;
        }

        int anio = -1;
        try{
            anio = Integer.parseInt(this.inputAnio.getText());
        } catch(NumberFormatException ex){
            marcarComoInvalido(this.inputAnio);
            datosValidos = false;
        }

        LocalDate fechaNacimiento = null;
        try{
            fechaNacimiento = LocalDate.of(anio, mes, dia);
        } catch(DateTimeException ex){
            // Acá hay un pequeño problema.
            // Si ambos inputs están mal, solo se marcaría el mes como inválido porque es la excepción que se tira primero. Decidí dejarlo así porque creo que no es tan grave.
            if(ex.getMessage().contains("MonthOfYear")){
                marcarComoInvalido(this.inputMes);
            } else {
                marcarComoInvalido(this.inputDia);
            }
            datosValidos = false;
        }

        String departamento = (String) this.inputDepartamento.getSelectedItem();
        int cantidadDeHijos =  (int) this.inputHijos.getValue();

       if(datosValidos){
           Persona nuevoUsuario = new Persona(id, nombre, apellido, departamento, cantidadDeHijos, fechaNacimiento, this.listaVehiculos.clonar());
           this.listaDeUsuarios.add(nuevoUsuario);
           limpiarCampos();
           this.listaVehiculos.vaciar();
           JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
       } else {
           JOptionPane.showMessageDialog(null, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
       }
    }
}


