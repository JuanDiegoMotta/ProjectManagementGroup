/**
 * 
 */
package pmg.vista;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

/**
 * Clase de la ventana gráfica principal que contiene el menú
 * @author juanm
 *
 */
public class VentanaPrincipal extends JFrame implements iVentana{
	private JMenuBar menuBar;
	private JMenu mnPI;
	private JMenu mnAlumnos;
	private JMenu mnAreas;
	private JMenu mnAyuda;
	private JMenuItem pi_alta;
	private JMenuItem pi_baja;
	private JMenuItem pi_edicion;
	private JMenuItem pi_consulta;
	private JMenuItem alumnos_alta;
	private JMenuItem alumnos_baja;
	private JMenuItem alumnos_edicion;
	private JMenuItem alumnos_consulta;
	private JMenuItem area_alta;
	private JMenuItem area_baja;
	private JMenuItem area_edicion;
	private JScrollPane scrpContenedor;
	
	/**
	 * Constructor con parámetros de VentanaPrincipal
	 * @param titulo titulo de la ventana principal
	 */
	public VentanaPrincipal() {
//		super(titulo);
		inicializarComponentes();	
	}
	
	/**
	 * Método que inicializa los componentes
	 */
	public void inicializarComponentes() {
		//Configuramos el layout a null
		getContentPane().setLayout(null);
		
		//Se determina que hace al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		// Se obtienen las dimensiones en pixels de la ventana.       
		Dimension ventana = new Dimension(600, 400);               
		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
			
		crearMenu();
		
		//Texto de bienvenida
		JTextArea txtrBienvenidoAProject = new JTextArea();
		txtrBienvenidoAProject.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtrBienvenidoAProject.setText("BIENVENIDO A PROJECT MANAGEMENT GROUP, ESTAMOS ENCANTADOS DE SERVIRTE.");
		txtrBienvenidoAProject.setLineWrap(true);
		txtrBienvenidoAProject.setBackground(UIManager.getColor("Button.background"));
		txtrBienvenidoAProject.setBounds(128, 174, 322, 50);
		getContentPane().add(txtrBienvenidoAProject);
		
		//Aquí iría el logo
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(265, 113, 46, 14);
		getContentPane().add(lblNewLabel);
		
		
		setSize(600,400);
	}
	
	/**
	 * Método que crea el menú
	 */
	public void crearMenu() {
		//Se crea el JMenuBar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//El primer JMenu es el de Proyectos integradores -> PI
		mnPI = new JMenu("PI");
		menuBar.add(mnPI);
		
		//Añadimos los items (pestañas desplegables) al mnPI
		pi_alta = new JMenuItem("Alta");
		mnPI.add(pi_alta);
		
		pi_baja = new JMenuItem("Baja");
		mnPI.add(pi_baja);
		
		pi_edicion = new JMenuItem("Editar");
		mnPI.add(pi_edicion);
		
		pi_consulta = new JMenuItem("Consultar");
		mnPI.add(pi_consulta);
		
		//Creamos el otro JMenu de Alumnos
		mnAlumnos = new JMenu("Alumnos");
		menuBar.add(mnAlumnos);
		
		//Añadimos items a mnAlumnos
		alumnos_alta = new JMenuItem("Alta");
		mnAlumnos.add(alumnos_alta);
		
		alumnos_baja = new JMenuItem("Baja");
		mnAlumnos.add(alumnos_baja);
		
		alumnos_edicion = new JMenuItem("Editar");
		mnAlumnos.add(alumnos_edicion);
		
		alumnos_consulta= new JMenuItem("Consultar");
		mnAlumnos.add(alumnos_consulta);
		
		//Creamos otro JMenu de Areas
		mnAreas = new JMenu("Areas");
		menuBar.add(mnAreas);
		
		//Añadimos items a mnAreas
		area_alta = new JMenuItem("Alta");
		mnAreas.add(area_alta);
		
		area_baja = new JMenuItem("Baja");
		mnAreas.add(area_baja);
		
		area_edicion = new JMenuItem("Editar");
		mnAreas.add(area_edicion);
		
		//Creamos otro JMenu de Ayuda
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
