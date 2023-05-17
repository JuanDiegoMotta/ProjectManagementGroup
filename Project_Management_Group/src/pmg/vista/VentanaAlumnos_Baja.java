/**
 * 
 */
package pmg.vista;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import pmg.controlador.ListenerBotonAtras;

/**
 * @author juanm
 * 
 * Clase de la ventana gráfica Alumnos que da de baja al alumno según su código.
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
	
	/**
	 * Constructor con parámetros de VentanaAlumnos_Baja
	 * @param titulo Título de la ventana de la aplicación.
	 */
	public VentanaAlumnos_Baja (String titulo) {
		super (titulo);
		inicializarComponentes();
	}
	
	/**
	 * Método que inicializa los componentes
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
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
			
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
		btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrar.setBounds(249, 144, 54, 48);
		getContentPane().add(btnBorrar);
		basura = new ImageIcon();
		btnBorrar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/trash.png")));
		
		// Creamos botón para la consulta de alumnos
		btnConsulta = new JButton("?");
		btnConsulta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnConsulta.setBounds(91, 227, 46, 36);
		getContentPane().add(btnConsulta);
		
		// Se agrega la etiqueta de la consulta de alumnos
		lblConsulta = new JLabel("¿Quieres consultar los alumnos existentes?");
		lblConsulta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblConsulta.setBounds(143, 227, 353, 36);
		getContentPane().add(lblConsulta);
		
		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setBounds(42, 300, 100, 30);
		getContentPane().add(btnAtras);
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
	public void setControlador(ListenerBotonAtras ba) {
		btnAtras.addActionListener(ba);
	}


}
