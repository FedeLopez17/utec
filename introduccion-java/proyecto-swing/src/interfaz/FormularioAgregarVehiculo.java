package interfaz;

import entidades.vehiculos.*;
import excepciones.IdEnUsoException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioAgregarVehiculo {
    private JPanel panelPrincipal;
    private JTabbedPane tabbedPaneVehiculos;
    private JPanel panelAuto;
    private JPanel panelAvion;
    private JPanel panelBarco;
    private JPanel wrapperIdAuto;
    private JPanel wrapperColorAuto;
    private JPanel wrapperCantPuertas;
    private JPanel wrapperTransmicion;
    private JTextField inputIdAuto;
    private JComboBox inputColorAuto;
    private JLabel etiquetaIdAuto;
    private JLabel etiquetaColorAuto;
    private JSpinner inputCantPuertas;
    private JLabel etiquetaCantPuertas;
    private JComboBox inputTransmicion;
    private JLabel etiquetaTransmicion;
    private JButton agregarButtonAuto;
    private JPanel wrapperColorAvion;
    private JPanel wrapperIdAvion;
    private JComboBox inputColorAvion;
    private JLabel etiquetaColorAvion;
    private JPanel wrapperLongitud;
    private JTextField inputLongitud;
    private JLabel etiquetaLongitud;
    private JPanel wrapperCantPasajeros;
    private JTextField inputCantPasajeros;
    private JLabel etiquetaCantPasajeros;
    private JPanel wrapperIdBarco;
    private JTextField inputIdBarco;
    private JLabel etiquetaIdBarco;
    private JPanel wrapperColorBarco;
    private JComboBox inputColorBarco;
    private JLabel etiquetaColorBarco;
    private JTextField inputIdAvion;
    private JLabel etiquetaIdAvion;
    private JPanel wrapperEslora;
    private JTextField inputEslora;
    private JLabel etiquetaEslora;
    private JPanel wrapperManga;
    private JTextField inputManga;
    private JLabel etiquetaManga;
    private JPanel wrapperNombreBarco;
    private JTextField inputNombreBarco;
    private JLabel etiquetaNombreBarco;
    private JPanel wrapperMarcaAuto;
    private JComboBox inputMarcaAuto;
    private JLabel etiquetaMarcaAuto;
    private JPanel panelMoto;
    private JPanel wrapperIdMoto;
    private JTextField inputIdMoto;
    private JLabel etiquetaIdMoto;
    private JPanel wrapperMarcaMoto;
    private JComboBox inputMarcaMoto;
    private JLabel etiquetaMarcaMoto;
    private JPanel wrapperColorMoto;
    private JComboBox inputColorMoto;
    private JLabel etiquetaColorMoto;
    private JPanel wrapperTipoDeMoto;
    private JComboBox inputTipoDeMoto;
    private JLabel etiquetaTipoDeMoto;
    private JPanel wrapperCilindradaMoto;
    private JComboBox inputCilindradaMoto;
    private JLabel etiquetaCilindradaMoto;
    private JButton agregarButtonMoto;
    private JButton agregarButtonAvion;
    private JButton agregarButtonBarco;
    private JPanel wrapperTabbedPane;

    JFrame marco;

    private Color colorBordeTextFieldInvalido = Color.RED;
    private Color colorFondoTextFieldInvalido = Color.PINK;

    private JTextField[] camposTextField = {
            this.inputIdAuto,
            this.inputIdMoto,
            this.inputIdAvion,
            this.inputLongitud,
            this.inputCantPasajeros,
            this.inputIdBarco,
            this.inputNombreBarco,
            this.inputEslora,
            this.inputManga
    };

    private ListaVehiculos listaVehiculos;
    private DefaultListModel<String> modelolistaVehiculos;

    public FormularioAgregarVehiculo(ListaVehiculos listaVehiculos, DefaultListModel<String> modelolistaVehiculos){
        this.listaVehiculos = listaVehiculos;
        this.modelolistaVehiculos = modelolistaVehiculos;
        delimitarSpinnerPuertasAuto();
        agregarEventListeners();
        marco = new JFrame();
        marco.setContentPane(this.panelPrincipal);
        marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        marco.pack();
        marco.setLocationRelativeTo(null);
        marco.setSize(400, 650);
        marco.setVisible(true);
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
    private void delimitarSpinnerPuertasAuto(){
        // Delimitar rango
        this.inputCantPuertas.setModel(new SpinnerNumberModel(4, 2, 8,1));
        // Evitar que se pueda ingresar texto
        this.inputCantPuertas.setEditor(new JSpinner.DefaultEditor(this.inputCantPuertas));
    }

    private void agregarEventListeners(){
        agregarListenersCamposDeTexto();
        agregarEventListenerBotonAuto();
        agregarEventListenerBotonMoto();
        agregarEventListenerBotonAvion();
        agregarEventListenerBotonBarco();
    }

    private int getId(JTextField input) throws IdEnUsoException {
        int id = Integer.parseInt(input.getText());
        boolean idEnUso = this.listaVehiculos.getVehiculoPorId(id) != null;
        if(idEnUso){
            throw new IdEnUsoException();
        }

        return id;
    }
    private void agregarEventListenerBotonAuto(){
        this.agregarButtonAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos = true;

                int id = -1;
                try{
                    id = getId(inputIdAuto);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputIdAuto);
                    datosValidos = false;
                } catch(IdEnUsoException ex){
                    marcarComoInvalido(inputIdAuto);
                    datosValidos = false;
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                String marca = (String) inputMarcaAuto.getSelectedItem();
                String color = (String) inputColorAuto.getSelectedItem();
                byte numeroDePuertas = ((Number) inputCantPuertas.getValue()).byteValue();
                String transmicion = (String) inputTransmicion.getSelectedItem();

                if(datosValidos){
                    Auto auto = new Auto(id, color, marca, numeroDePuertas, transmicion);
                    listaVehiculos.add(auto);
                    modelolistaVehiculos.addElement(auto.toString());
                    marco.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

    private void agregarEventListenerBotonMoto(){
        this.agregarButtonMoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos = true;

                int id = -1;
                try{
                    id = getId(inputIdMoto);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputIdMoto);
                    datosValidos = false;
                } catch(IdEnUsoException ex){
                    marcarComoInvalido(inputIdMoto);
                    datosValidos = false;
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                String marca = (String) inputMarcaMoto.getSelectedItem();
                String tipo = (String) inputTipoDeMoto.getSelectedItem();
                String color = (String) inputColorMoto.getSelectedItem();
                String cilindrada = (String) inputTipoDeMoto.getSelectedItem();

                if(datosValidos){
                    Moto moto = new Moto(id, color, marca, cilindrada, tipo);
                    listaVehiculos.add(moto);
                    modelolistaVehiculos.addElement(moto.toString());
                    marco.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void agregarEventListenerBotonAvion(){
        this.agregarButtonAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos = true;

                int id = -1;
                try{
                    id = getId(inputIdAvion);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputIdAvion);
                    datosValidos = false;
                } catch(IdEnUsoException ex){
                    marcarComoInvalido(inputIdAvion);
                    datosValidos = false;
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                String color = (String) inputColorAvion.getSelectedItem();

                int longitud = -1;
                try{
                    longitud = Integer.parseInt(inputLongitud.getText());
                    desmarcarComoInvalido(inputLongitud);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputLongitud);
                    datosValidos = false;
                }

                int cantPasajeros = -1;
                try{
                    cantPasajeros = Integer.parseInt(inputCantPasajeros.getText());
                    desmarcarComoInvalido(inputCantPasajeros);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputCantPasajeros);
                    datosValidos = false;
                }

                if(datosValidos){
                    Avion avion = new Avion(id, color, longitud, cantPasajeros);
                    listaVehiculos.add(avion);
                    modelolistaVehiculos.addElement(avion.toString());
                    marco.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void agregarEventListenerBotonBarco(){
        this.agregarButtonBarco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos = true;

                int id = -1;
                try{
                    id = getId(inputIdBarco);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputIdBarco);
                    datosValidos = false;
                } catch(IdEnUsoException ex){
                    marcarComoInvalido(inputIdBarco);
                    datosValidos = false;
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                String nombre = inputNombreBarco.getText();
                if(nombre.isEmpty()){
                    marcarComoInvalido(inputNombreBarco);
                    datosValidos = false;
                }

                String color = (String) inputColorBarco.getSelectedItem();

                int eslora = -1;
                try{
                    eslora = Integer.parseInt(inputEslora.getText());
                    desmarcarComoInvalido(inputEslora);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputEslora);
                    datosValidos = false;
                }

                int manga = -1;
                try{
                    manga = Integer.parseInt(inputManga.getText());
                    desmarcarComoInvalido(inputManga);
                } catch(NumberFormatException ex){
                    marcarComoInvalido(inputManga);
                    datosValidos = false;
                }

                if(datosValidos){
                    Barco barco = new Barco(id, color, nombre, eslora, manga);
                    listaVehiculos.add(barco);
                    modelolistaVehiculos.addElement(barco.toString());
                    marco.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor rellene los campos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
}
