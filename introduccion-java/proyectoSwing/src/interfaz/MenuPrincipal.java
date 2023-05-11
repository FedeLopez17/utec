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

    private JFrame marco;

    private ListaUsuarios listaPersonas;

    public MenuPrincipal(){
        this.listaPersonas = new ListaUsuarios();

        marco = new JFrame();
        marco.setContentPane(this.panelPrincipalMenu);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        marco.setLocationRelativeTo(null);
        marco.setSize(900, 900);
        marco.setVisible(true);

        RegistrarUsuario interfazRegistrarUsuario = new RegistrarUsuario(this.listaPersonas);
        VerUsuarios interfazVerUsuarios = new VerUsuarios();

        CardLayout cardLayout = new CardLayout();
        panelContenidoPrincipal.setLayout(cardLayout);

        panelContenidoPrincipal.add(interfazRegistrarUsuario.getPanelPrincipal(), "registrarUsuario");
        panelContenidoPrincipal.add(interfazVerUsuarios.getPanelPrincipal(), "verUsuarios");


        this.botonRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenidoPrincipal, "registrarUsuario");
            }
        });

        this.botonVerUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazVerUsuarios.refrezcarTabla(listaPersonas);
                cardLayout.show(panelContenidoPrincipal, "verUsuarios");
            }
        });
    }
}
