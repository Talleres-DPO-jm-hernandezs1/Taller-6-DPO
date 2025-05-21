package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
    	this.ventanaPrincipal = principal;
        setTitle("Agregar Restaurante");
        setLayout(new BorderLayout());


        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);


        JPanel panelSur = new JPanel(new BorderLayout());

        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this);  

        panelSur.add(panelDetalles, BorderLayout.CENTER);
        panelSur.add(panelBotones, BorderLayout.EAST);

        add(panelSur, BorderLayout.SOUTH);


        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }


    public void agregarRestaurante( )
    {
    	String nombre = panelDetalles.getNombre();
        int calificacion = panelDetalles.getCalificacion();
        boolean visitado = panelDetalles.getVisitado();

        int[] coordenadas = panelMapa.getCoordenadas();
        int x = coordenadas[0];
        int y = coordenadas[1];

        ventanaPrincipal.agregarRestaurante(nombre, calificacion, x, y, visitado);
        dispose();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
