package interfaz;

import entidades.personas.ListaUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private JPanel panelPrincipalMenu;
    private JButton botonVerUsuarios;
    private JButton botonRegistrarUsuario;
    private JPanel selectorDePantallas;
    private JPanel panelContenidoPrincipal;
    private JButton botonDashboard;

    private JFrame marco;

    private ListaUsuarios listaPersonas;
    private Color fondoSeleccionado = new Color(35, 54, 102);
    private Color foregroundSeleccionado = new Color(255, 255, 255);

    public MenuPrincipal(ListaUsuarios listaPersonas){
        inicializarMenu(listaPersonas);
    }

    public MenuPrincipal(){
        inicializarMenu(new ListaUsuarios());
    }

    private void inicializarMenu(ListaUsuarios listaPersonas){
        this.listaPersonas = listaPersonas;

        marco = new JFrame();
        marco.setContentPane(this.panelPrincipalMenu);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        UIDefaults defaultNimbus = UIManager.getLookAndFeelDefaults();
        defaultNimbus.put("Button.focus", new Color(0, 0, 0, 0));
        marco.setLocationRelativeTo(null);
        marco.setSize(900, 900);
        marco.setVisible(true);

        RegistrarUsuario interfazRegistrarUsuario = new RegistrarUsuario(this.listaPersonas);
        VerUsuarios interfazVerUsuarios = new VerUsuarios(this.listaPersonas);
        Dashboard interfazDashboard = new Dashboard(this.listaPersonas);

        CardLayout cardLayout = new CardLayout();
        panelContenidoPrincipal.setLayout(cardLayout);

        panelContenidoPrincipal.add(interfazDashboard.getPanelPrincipal(), "dashboard");
        panelContenidoPrincipal.add(interfazRegistrarUsuario.getPanelPrincipal(), "registrarUsuario");
        panelContenidoPrincipal.add(interfazVerUsuarios.getPanelPrincipal(), "verUsuarios");

        this.botonDashboard.setBackground(this.fondoSeleccionado);
        this.botonDashboard.setForeground(this.foregroundSeleccionado);

        this.botonRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColorBotones(botonRegistrarUsuario);
                cardLayout.show(panelContenidoPrincipal, "registrarUsuario");
            }
        });

        this.botonVerUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColorBotones(botonVerUsuarios);
                interfazVerUsuarios.refrezcarTabla(listaPersonas);
                cardLayout.show(panelContenidoPrincipal, "verUsuarios");
            }
        });

        this.botonDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColorBotones(botonDashboard);
                interfazDashboard.actualizarInformacion(listaPersonas);
                cardLayout.show(panelContenidoPrincipal, "dashboard");
            }
        });
    }

    private void cambiarColorBotones(JButton botonSeleccionado){
        JButton[] botones = {this.botonDashboard, this.botonRegistrarUsuario, this.botonVerUsuarios};
        for(JButton boton : botones){
            if(boton == botonSeleccionado){
                boton.setBackground(this.fondoSeleccionado);
                boton.setForeground(this.foregroundSeleccionado);
            } else {
                boton.setBackground(null);
                boton.setForeground(null);
            }
        }
    }
}
