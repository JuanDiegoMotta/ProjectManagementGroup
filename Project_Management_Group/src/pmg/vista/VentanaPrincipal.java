/**
 * 
 */
package pmg.vista;

import javax.swing.*;

import pmg.controlador.ListenerMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

/**
 * Clase de la ventana gráfica principal que contiene el menú
 * 
 * @author PMG
 *
 */
public class VentanaPrincipal extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnPI;
	private JMenu mnAlumnos;
	private JMenu mnAreas;
	private JMenuItem mnAyuda;
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
	private ImageIcon logo;
	private JMenuItem pi_asociar;
	private ImageIcon fondo;
	private JLabel lblFondo;
	JMenuItem ayudaMenuItem;

	// Getters necesarios
	public JMenuItem getAyudaMenuItem() {
		return ayudaMenuItem;
	}

	/**
	 * Constructor de la clase VentanaPrincipal
	 * 
	 * @param titulo titulo de la ventana principal
	 */
	public VentanaPrincipal() {
//		super(titulo);
		inicializarComponentes();
	}

	// Getters de los MenuItems que se usarán en el controlador ListenerMenu
	public JMenuItem getMnAyuda() {
		return mnAyuda;
	}

	public JMenuItem getPi_alta() {
		return pi_alta;
	}

	public JMenuItem getPi_baja() {
		return pi_baja;
	}

	public JMenuItem getPi_edicion() {
		return pi_edicion;
	}

	public JMenuItem getPi_consulta() {
		return pi_consulta;
	}

	public JMenuItem getAlumnos_alta() {
		return alumnos_alta;
	}

	public JMenuItem getAlumnos_baja() {
		return alumnos_baja;
	}

	public JMenuItem getAlumnos_edicion() {
		return alumnos_edicion;
	}

	public JMenuItem getAlumnos_consulta() {
		return alumnos_consulta;
	}

	public JMenuItem getArea_alta() {
		return area_alta;
	}

	public JMenuItem getArea_baja() {
		return area_baja;
	}

	public JMenuItem getArea_edicion() {
		return area_edicion;
	}

	public JMenuItem getPi_asociar() {
		return pi_asociar;
	}

	/**
	 * Método que se encarga de inicializar los componentes gráficos a nuestra aplicación.
	 */
	public void inicializarComponentes() {
		// Configuramos el layout a null
		getContentPane().setLayout(null);

		// Se determina que hace al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = new Dimension(600, 400);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

		crearMenu();

		// Texto de bienvenida
		JTextArea txtrBienvenidoAProject = new JTextArea();
		txtrBienvenidoAProject.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtrBienvenidoAProject.setText("BIENVENIDO A PROJECT MANAGEMENT GROUP");
		txtrBienvenidoAProject.setLineWrap(true);
		txtrBienvenidoAProject.setBounds(97, 161, 379, 50);
		txtrBienvenidoAProject.setEditable(false);
		txtrBienvenidoAProject.setOpaque(false);
		getContentPane().add(txtrBienvenidoAProject);
		
		// Texto de bienvenida
		JTextArea txtrBienvenidoAProject1 = new JTextArea();
		txtrBienvenidoAProject1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtrBienvenidoAProject1.setText("ESTAREMOS ENCANTADOS DE SERVIRLE");
		txtrBienvenidoAProject1.setLineWrap(true);
		txtrBienvenidoAProject1.setBounds(138, 208, 285, 50);
		txtrBienvenidoAProject1.setEditable(false);
		txtrBienvenidoAProject1.setOpaque(false);
		getContentPane().add(txtrBienvenidoAProject1);

		// Aquí iría el logo
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(169, 81, 200, 60);
		getContentPane().add(lblNewLabel);
		logo = new ImageIcon("../img/logoPMG.png");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoPMG.png")));
		
		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));

		setSize(600, 400);
	}

	/**
	 * Método que crea el menú
	 */
	public void crearMenu() {

		// Se crea el JMenuBar
		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(Color.decode("#898980"));
		setJMenuBar(menuBar);

		// El primer JMenu es el de Proyectos integradores -> PI
		mnPI = new JMenu("PI");
		mnPI.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnPI.setForeground(new Color(255, 255, 255));
		menuBar.add(mnPI);

		// Añadimos los items (pestañas desplegables) al mnPI
		pi_alta = new JMenuItem("Alta");
		pi_alta.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pi_alta.setForeground(new Color(255, 255, 255));
		pi_alta.setBackground(Color.decode("#898980"));
		mnPI.add(pi_alta);

		pi_baja = new JMenuItem("Baja");
		pi_baja.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pi_baja.setForeground(new Color(255, 255, 255));
		pi_baja.setBackground(Color.decode("#898980"));
		mnPI.add(pi_baja);

		pi_edicion = new JMenuItem("Editar");
		pi_edicion.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pi_edicion.setForeground(new Color(255, 255, 255));
		pi_edicion.setBackground(Color.decode("#898980"));
		mnPI.add(pi_edicion);

		pi_consulta = new JMenuItem("Consultar");
		pi_consulta.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pi_consulta.setForeground(new Color(255, 255, 255));
		pi_consulta.setBackground(Color.decode("#898980"));
		mnPI.add(pi_consulta);

		pi_asociar = new JMenuItem("Asociar alumno");
		pi_asociar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pi_asociar.setForeground(new Color(255, 255, 255));
		pi_asociar.setBackground(Color.decode("#898980"));
		mnPI.add(pi_asociar);

		// Creamos el otro JMenu de Alumnos
		mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnAlumnos.setForeground(new Color(255, 255, 255));
		menuBar.add(mnAlumnos);

		// Añadimos items a mnAlumnos
		alumnos_alta = new JMenuItem("Alta");
		alumnos_alta.setFont(new Font("Segoe UI", Font.BOLD, 13));
		alumnos_alta.setForeground(new Color(255, 255, 255));
		alumnos_alta.setBackground(Color.decode("#898980"));
		mnAlumnos.add(alumnos_alta);

		alumnos_baja = new JMenuItem("Baja");
		alumnos_baja.setFont(new Font("Segoe UI", Font.BOLD, 13));
		alumnos_baja.setForeground(new Color(255, 255, 255));
		alumnos_baja.setBackground(Color.decode("#898980"));
		mnAlumnos.add(alumnos_baja);

		alumnos_edicion = new JMenuItem("Editar");
		alumnos_edicion.setFont(new Font("Segoe UI", Font.BOLD, 13));
		alumnos_edicion.setForeground(new Color(255, 255, 255));
		alumnos_edicion.setBackground(Color.decode("#898980"));
		mnAlumnos.add(alumnos_edicion);

		alumnos_consulta = new JMenuItem("Consultar");
		alumnos_consulta.setFont(new Font("Segoe UI", Font.BOLD, 13));
		alumnos_consulta.setForeground(new Color(255, 255, 255));
		alumnos_consulta.setBackground(Color.decode("#898980"));
		mnAlumnos.add(alumnos_consulta);

		// Creamos otro JMenu de Areas
		mnAreas = new JMenu("Areas");
		mnAreas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnAreas.setForeground(new Color(255, 255, 255));
		menuBar.add(mnAreas);

		// Añadimos items a mnAreas
		area_alta = new JMenuItem("Alta");
		area_alta.setFont(new Font("Segoe UI", Font.BOLD, 13));
		area_alta.setForeground(new Color(255, 255, 255));
		area_alta.setBackground(Color.decode("#898980"));
		mnAreas.add(area_alta);

		area_baja = new JMenuItem("Baja");
		area_baja.setFont(new Font("Segoe UI", Font.BOLD, 13));
		area_baja.setForeground(new Color(255, 255, 255));
		area_baja.setBackground(Color.decode("#898980"));
		mnAreas.add(area_baja);

		area_edicion = new JMenuItem("Editar");
		area_edicion.setFont(new Font("Segoe UI", Font.BOLD, 13));
		area_edicion.setForeground(new Color(255, 255, 255));
		area_edicion.setBackground(Color.decode("#898980"));
		mnAreas.add(area_edicion);

		// Creamos otro JMenu de Ayuda
		mnAyuda = new JMenuItem("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnAyuda.setForeground(new Color(255, 255, 255));
		mnAyuda.setBackground(Color.decode("#898980"));
		menuBar.add(mnAyuda);

		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
	}

	/**
	 * Método para hacer visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Método para asociar Listeners a la ventana
	 * 
	 * @param listener Clase ListenerMenu
	 */
	public void setListenerMenu(ListenerMenu listener) {
		pi_alta.addActionListener(listener);
		pi_baja.addActionListener(listener);
		pi_edicion.addActionListener(listener);
		pi_consulta.addActionListener(listener);
		pi_asociar.addActionListener(listener);
		alumnos_alta.addActionListener(listener);
		alumnos_baja.addActionListener(listener);
		alumnos_edicion.addActionListener(listener);
		alumnos_consulta.addActionListener(listener);
		area_alta.addActionListener(listener);
		area_baja.addActionListener(listener);
		area_edicion.addActionListener(listener);
		mnAyuda.addActionListener(listener);
	}

}
