/**
 * 
 */
package pmg.vista;

import java.awt.Color;
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
	private ImageIcon fondo;
	private JLabel lblFondo;
	
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
		txtNombreCorto.setBounds(282, 72, 131, 25);
		getContentPane().add(txtNombreCorto);

		// Se agrega LNombre
		LNombre = new JLabel("Nombre corto: ");
		LNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		LNombre.setBounds(137, 71, 120, 22);
		getContentPane().add(LNombre);

//		Se agrega LDescripcion
		LDescripcion = new JLabel("Descripción: ");
		LDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		LDescripcion.setBounds(148, 131, 100, 22);
		getContentPane().add(LDescripcion);

//		Se agrega descripcion
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setBounds(282, 131, 131, 69);
		getContentPane().add(txtDescripcion);

//		Se agrega botón de atrás
		atras = new JButton("ATRÁS");
		atras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		atras.setBackground(Color.decode("#BCD0C7"));
		atras.setFocusable(false);
		atras.setBounds(42, 300, 120, 30);
		getContentPane().add(atras);

//		Se agrega botón guardar
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardar.setBackground(Color.decode("#BCD0C7"));
		btnGuardar.setFocusable(false);
		btnGuardar.setBounds(419, 300, 120, 30);
		getContentPane().add(btnGuardar);

//		Se agrega el botón de rellenar
		btnRellenar = new JButton();
		btnRellenar.setBounds(423, 67, 36, 30);
		btnRellenar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRellenar.setBackground(Color.decode("#BCD0C7"));
		btnRellenar.setFocusable(false);
		getContentPane().add(btnRellenar);
		rellenar = new ImageIcon();
		btnRellenar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/rellenar.png")));
		
		lblAviso = new JLabel("");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(108, 242, 362, 30);
		getContentPane().add(lblAviso);
		
		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));

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
	public void setControlador(ListenerBotonAtras ba, ListenerMostrar lm, ListenerGuardar lg) {
		atras.addActionListener(ba);
		btnRellenar.addActionListener(lm);
		btnGuardar.addActionListener(lg);
	}
	/**
	 * Actualiza el texto del componente de aviso en función del resultado.
	 *
	 * @param caso indica si la operación fue exitosa (true) o no (false)
	 */
	public void mostrarAviso(boolean caso) {
		if (caso) {
			lblAviso.setText("Área editada correctamente");
		} else {
			lblAviso.setText("Error al editar el área");
		}
	}

}
