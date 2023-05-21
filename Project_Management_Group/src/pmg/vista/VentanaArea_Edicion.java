/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

import pmg.controlador.*;

/**
 * Clase VentanaArea_Edicion
 * 
 * @author Pablo
 *
 */
public class VentanaArea_Edicion extends JFrame {

	private JTextField txtNombreCorto;
	private JTextArea txtDescripcion;
	private JLabel LNombre;
	private JLabel LDescripcion;
	private JButton atras;
	private JButton btnGuardar;
	private JLabel LCodigo;
	private JButton btnRellenar;
	private ImageIcon rellenar;
	private JLabel lblAviso;
	
	//Getters necesarios
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnRellenar() {
		return btnRellenar;
	}
	public JTextField getTxtNombreCorto() {
		return txtNombreCorto;
	}

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}
	
	public JLabel getLblAviso() {
		return lblAviso;
	}

	/**
	 * Constructor de la clase VentanaArea_Edicion
	 * 
	 * @param titulo Titulo de la ventana
	 */
	public VentanaArea_Edicion(String titulo) {
		super(titulo);
		inicializarComponentes();
	}

	/**
	 * Método para inicializar componentes de la ventana, esta ventana construirá
	 * las cosas de la ventana VentanaArea_Edicion
	 */
	private void inicializarComponentes() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Se agrega nombreCorto
		txtNombreCorto = new JTextField();
		txtNombreCorto.setBounds(282, 73, 131, 22);
		getContentPane().add(txtNombreCorto);

		// Se agrega LNombre
		LNombre = new JLabel("Nombre corto: ");
		LNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		LNombre.setBounds(137, 69, 120, 22);
		getContentPane().add(LNombre);

//		Se agrega LDescripcion
		LDescripcion = new JLabel("Descripción: ");
		LDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		LDescripcion.setBounds(152, 113, 100, 22);
		getContentPane().add(LDescripcion);

//		Se agrega descripcion
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setBounds(282, 115, 131, 69);
		getContentPane().add(txtDescripcion);

//		Se agrega botón de atrás
		atras = new JButton("ATRÁS");
		atras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		atras.setBounds(42, 300, 120, 30);
		getContentPane().add(atras);

//		Se agrega botón guardar
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardar.setBounds(419, 300, 120, 30);
		getContentPane().add(btnGuardar);

//		Se agrega el botón de rellenar
		btnRellenar = new JButton();
		btnRellenar.setBounds(433, 59, 42, 42);
		btnRellenar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(btnRellenar);
		rellenar = new ImageIcon();
		btnRellenar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/rellenar.png")));
		
		lblAviso = new JLabel("");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(42, 241, 497, 14);
		getContentPane().add(lblAviso);

		setSize(600, 400);
		setLocationRelativeTo(null);
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
	public void setControlador(ListenerBotonAtras ba, ListenerMostrar lm) {
		atras.addActionListener(ba);
		btnRellenar.addActionListener(lm);
	}

}
