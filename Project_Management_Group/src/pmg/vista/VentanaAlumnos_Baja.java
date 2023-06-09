/**
 * 
 */
package pmg.vista;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import pmg.controlador.ListenerBotonAtras;
import pmg.controlador.ListenerBotonBaja;
import pmg.controlador.ListenerInterrog;

/**
 * @author juanm
 * 
 * Clase de la ventana gráfica Alumnos que da de baja al alumno según sucódigo.
 *
 */
public class VentanaAlumnos_Baja extends JFrame {

	static final int ANCHO = 600;
	static final int ALTO = 400;
	private JLabel lblTxtBaja;
	private JLabel lblTxtBaja1;
	private JTextField txtCod;
	private JButton btnBorrar;
	private JButton btnConsulta;
	private JLabel lblConsulta;
	private JButton btnAtras;
	private ImageIcon basura;
	private JLabel aviso;
	private ImageIcon fondo;
	private JLabel lblFondo;

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	/**
	 * Constructor de la clase VentanaAlumnos_Baja
	 * 
	 * @param titulo Título de la ventana de la aplicación.
	 */
	public VentanaAlumnos_Baja(String titulo) {
		super(titulo);
		inicializarComponentes();
	}

	/**
	 * Método que se encarga de inicializar los componentes gráficos a nuestra aplicación.
	 */
	public void inicializarComponentes() {

		// Configuramos el layout a null.
		getContentPane().setLayout(null);

		// Determina que hace la app al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Se declara el tamaño de la ventana con los valores estáticos
		setSize(ANCHO, ALTO);

		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = new Dimension(ANCHO, ALTO);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

		// Se agrega la etiqueta txtBaja
		lblTxtBaja = new JLabel("Introduce el código del alumno que quieres");
		lblTxtBaja.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTxtBaja.setBounds(118, 34, 353, 36);
		getContentPane().add(lblTxtBaja);

		// Se agrega la etiqueta txtBaja1
		lblTxtBaja1 = new JLabel("dar de baja");
		lblTxtBaja1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTxtBaja1.setBounds(236, 66, 95, 36);
		getContentPane().add(lblTxtBaja1);

		// Se agrega el area de texto para introducir el código
		txtCod = new JTextField();
		txtCod.setBounds(192, 113, 174, 20);
		getContentPane().add(txtCod);

		// Creamos botón para borrar el alumno
		btnBorrar = new JButton();
		btnBorrar.setBackground(Color.decode("#BCD0C7"));
		btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrar.setFocusable(false);
		btnBorrar.setBounds(249, 144, 54, 48);
		getContentPane().add(btnBorrar);
		basura = new ImageIcon();
		btnBorrar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/trash.png")));

		// Creamos botón para la consulta de alumnos
		btnConsulta = new JButton("?");
		btnConsulta.setBackground(Color.decode("#BCD0C7"));
		btnConsulta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnConsulta.setFocusable(false);
		btnConsulta.setBounds(91, 227, 46, 36);
		getContentPane().add(btnConsulta);

		// Se agrega la etiqueta de la consulta de alumnos
		lblConsulta = new JLabel("¿Quieres consultar los alumnos existentes?");
		lblConsulta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblConsulta.setBounds(157, 227, 353, 36);
		getContentPane().add(lblConsulta);

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(42, 300, 100, 30);
		getContentPane().add(btnAtras);

		// Se crea la Jlabel que nos dará el aviso de si se ha borrado o no
		aviso = new JLabel();
		aviso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		aviso.setBounds(180, 276, 314, 30);
		getContentPane().add(aviso);
		
		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));
	}

	/**
	 * Método que hace visible la pantalla
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Método que muestra el aviso de si se ha borrado o no el alumno correctamente
	 * @param caso correspondiente
	 */
	public void mostrarAviso(boolean caso) {
		if (caso) {
			aviso.setText("Alumno borrado correctamente");
		} else {
			aviso.setText("Error al borrar el alumno");
		}
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerBotonBaja bb, ListenerInterrog bc) {
		btnAtras.addActionListener(ba);
		btnBorrar.addActionListener(bb);
		btnConsulta.addActionListener(bc);
	}

	/**
	 * Getter del código generado automáticamente del alumno
	 * 
	 * @return codigo del alumno generado
	 */
	public String getCodigo() {

		String codigo = txtCod.getText();

		return codigo;
	}

	/**
	 * Getter del aviso que nos muestra por pantalla al realizar la acción de baja
	 * 
	 * @return aviso correspondiente
	 */
	public JLabel getAviso() {
		return aviso;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

}
