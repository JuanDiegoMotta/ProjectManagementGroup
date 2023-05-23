/**
* 
*/
package pmg.vista;

import javax.swing.*;

import pmg.controlador.ListenerBotonAtras;
import pmg.controlador.ListenerBotonBaja;
import pmg.controlador.ListenerInterrog;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clase de la VentanaPI_Baja, que permite dar de baja un proyecto integrador según su código.
 * 
 * @author PMG
 *
 */
public class VentanaPI_Baja extends JFrame {
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

	// Getters
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JLabel getAviso() {
		return aviso;
	}

	public String getCodigo() {
		return txtCod.getText();
	}

	/**
	 * Constructor de la clase VentanaAlumnos_Baja
	 * 
	 * @param titulo Título de la ventana de la aplicación.
	 */
	public VentanaPI_Baja(String titulo) {
		super(titulo);
		getContentPane().setBackground(Color.decode("#A9B2AC"));
		inicializarComponentes();
	}

	/**
	 * Método que se encarga de inicializar los componentes gráficos a nuestra aplicación.
	 */
	public void inicializarComponentes() {

		// Configuramos el layout a null.
		getContentPane().setLayout(null);

		// Se sale determina que hace la app al cerrar la ventana
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
		lblTxtBaja = new JLabel("Introduce el código del proyecto que quieres");
		lblTxtBaja.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTxtBaja.setBounds(115, 21, 353, 36);
		getContentPane().add(lblTxtBaja);

		// Se agrega la etiqueta txtBaja1
		lblTxtBaja1 = new JLabel("dar de baja");
		lblTxtBaja1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTxtBaja1.setBounds(233, 53, 95, 36);
		getContentPane().add(lblTxtBaja1);

		// Se agrega el area de texto para introducir el código
		txtCod = new JTextField();
		txtCod.setBounds(189, 100, 174, 20);
		getContentPane().add(txtCod);

		// Creamos botón para borrar el alumno
		btnBorrar = new JButton();
		btnBorrar.setBackground(Color.decode("#BCD0C7"));
		btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrar.setFocusable(false);
		btnBorrar.setBounds(246, 131, 54, 48);
		getContentPane().add(btnBorrar);
		basura = new ImageIcon();
		btnBorrar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/trash.png")));

		// Creamos botón para la consulta de alumnos
		btnConsulta = new JButton("?");
		btnConsulta.setBackground(Color.decode("#BCD0C7"));
		btnConsulta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnConsulta.setFocusable(false);
		btnConsulta.setBounds(102, 246, 46, 36);
		getContentPane().add(btnConsulta);

		// Se agrega la etiqueta de la consulta de alumnos
		lblConsulta = new JLabel("¿Quieres consultar los proyectos existentes?");
		lblConsulta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblConsulta.setBounds(169, 246, 353, 36);
		getContentPane().add(lblConsulta);

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(42, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Inicializamos aviso
		aviso = new JLabel("");
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		aviso.setBounds(62, 209, 433, 26);
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
	 * Método que mostrará a través de un label si el PI ha sido borrado o no
	 * 
	 * @param caso booleano (true o false)
	 */
	public void mostrarAviso(boolean caso) {
		if (caso) {
			aviso.setText("PI borrado correctamente");
		} else {
			aviso.setText("Error al borrar el PI");
		}
	}

	// Getter del botón consulta
	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 * 
	 * @param ba Clase ListenerBotonAtras
	 * @param bb Clase ListenerBotonBaja
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerBotonBaja bb, ListenerInterrog bc) {
		btnAtras.addActionListener(ba);
		btnBorrar.addActionListener(bb);
		btnConsulta.addActionListener(bc);
	}

}
