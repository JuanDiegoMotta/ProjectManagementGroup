package pmg.vista;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import pmg.controlador.ListenerBotonAtras;
import pmg.controlador.ListenerBotonBaja;

/**
 * Clase de la ventana gráfica áreas que da de baja el área según su código.
 * 
 * @author PMG
 *
 */
public class VentanaArea_Baja extends JFrame {

	static final int ANCHO = 600;
	static final int ALTO = 400;
	private JLabel lblTxtBaja;
	private JLabel lblTxtBaja1;
	private JTextField txtNombreCorto;
	private JButton btnBorrar;
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

	/**
	 * Constructor de la clase VentanaArea_Baja
	 * 
	 * @param titulo Título de la ventana baja de áreas
	 */
	public VentanaArea_Baja(String titulo) {
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

		// Se agrega la etiqueta lblTxtBaja
		lblTxtBaja = new JLabel("Introduce el nombre corto del área que quieres");
		lblTxtBaja.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTxtBaja.setBounds(115, 34, 321, 36);
		getContentPane().add(lblTxtBaja);

		// Se agrega la etiqueta lblTxtBaja1
		lblTxtBaja1 = new JLabel("dar de baja");
		lblTxtBaja1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTxtBaja1.setBounds(236, 66, 95, 36);
		getContentPane().add(lblTxtBaja1);

		// Se agrega el area de texto para introducir el código
		txtNombreCorto = new JTextField();
		txtNombreCorto.setBounds(192, 113, 174, 25);
		getContentPane().add(txtNombreCorto);

		// Creamos botón para borrar el área
		btnBorrar = new JButton();
		btnBorrar.setBackground(Color.decode("#BCD0C7"));
		btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrar.setFocusable(false);
		btnBorrar.setBounds(250, 152, 54, 48);
		getContentPane().add(btnBorrar);
		basura = new ImageIcon();
		btnBorrar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/trash.png")));

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(52, 300, 120, 30);
		getContentPane().add(btnAtras);

		aviso = new JLabel("");
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setBounds(88, 248, 385, 14);
		getContentPane().add(aviso);
		
		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));
	}

	/**
	 * Método que devuelve el nombre corto del área introducido por el usuario
	 * 
	 * @return nombre corto área (String)
	 */
	public String getNombreCorto() {
		String nombreCorto = txtNombreCorto.getText();
		return nombreCorto;
	}

	/**
	 * Método que mostrará a través de un label si el área ha sido borrada o no
	 * 
	 * @param caso booleano (true o false)
	 */
	public void mostrarAviso(boolean caso) {
		if (caso) {
			aviso.setText("Área borrada correctamente");
		} else {
			aviso.setText("Error al borrar el área");
		}

	}

	/**
	 * Método que hace visible la pantalla
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerBotonBaja bb) {
		btnAtras.addActionListener(ba);
		btnBorrar.addActionListener(bb);
	}
}
