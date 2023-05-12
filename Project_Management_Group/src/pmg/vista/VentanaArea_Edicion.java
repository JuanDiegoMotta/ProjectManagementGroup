/**
 * 
 */
package pmg.vista;

import java.awt.Font;

import javax.swing.*;


/**
 * Clase VentanaArea_Edicion
 * @author Pablo
 *
 */
public class VentanaArea_Edicion extends JFrame {

	private JTextField nombreCorto;
	private JTextArea descripcion;
	private JLabel LNombre;
	private JLabel LDescripcion;
	private JButton atras;
	private JButton alta;
	private JLabel LCodigo;
	private JButton rellenar;

	/**
	 * Constructor de la clase VentanaArea_Edicion
	 * @param titulo
	 */
	public VentanaArea_Edicion(String titulo) {
		super(titulo);
		inicializarComponentes();

	}

	/**
	 * Método para inicializar componentes de la ventana, esta ventana construirá las cosas de la ventana VentanaArea_Edicion
	 */
	private void inicializarComponentes() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Se agrega nombreCorto
		nombreCorto = new JTextField();
		nombreCorto.setBounds(282, 115, 131, 22);
		getContentPane().add(nombreCorto);

		// Se agrega LNombre
		LNombre = new JLabel("Introduce el nombre corto: ");
		LNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		LNombre.setBounds(42, 111, 220, 22);
		getContentPane().add(LNombre);

//		Se agrega LDescripcion
		LDescripcion = new JLabel("Descripción: ");
		LDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		LDescripcion.setBounds(150, 167, 109, 22);
		getContentPane().add(LDescripcion);

//		Se agrega descripcion
		descripcion = new JTextArea();
		descripcion.setBounds(282, 169, 131, 69);
		getContentPane().add(descripcion);

//		Se agrega botón de atrás
		atras = new JButton("ATRÁS");
		atras.setFont(new Font("Segoe UI", Font.BOLD, 16));
		atras.setBounds(42, 300, 100, 30);
		getContentPane().add(atras);

//		Se agrega botón guardar
		alta = new JButton("GUARDAR");
		alta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		alta.setBounds(430, 300, 109, 30);
		getContentPane().add(alta);

//		Se agrega el botón de rellenar
		rellenar = new JButton("R");
		rellenar.setBounds(435, 101, 42, 42);
		rellenar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		getContentPane().add(rellenar);

		setSize(600, 400);
		setLocationRelativeTo(null);
	}

	/**
	 * Método que hace visible la pantalla
	 */
	public void hacerVisible() {
		setVisible(true);
	}
}
