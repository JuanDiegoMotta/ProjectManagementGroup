/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;

import javax.swing.*;


/**
 * Clase VentanaArea_Alta
 * @author Pablo
 *
 */
public class VentanaArea_Alta extends JFrame implements iVentana{
	private JTextField nombreCorto;
	private JTextArea descripcion;
	private JLabel LNombre;
	private JLabel LDescripcion;
	private JLabel mensaje;
	private JButton atras;
	private JButton alta;

	/**
	 * Constructor de la clase VentanaArea_Alta
	 * @param titulo
	 */
	public VentanaArea_Alta(String titulo) {
		super(titulo);
		inicializarComponentes();

	}

	/**
	 * Método para inicializar componentes de la ventana, esta ventana construirá las cosas de la ventana VentanaArea_Alta
	 */
	private void inicializarComponentes() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Se agrega nombreCorto
		nombreCorto = new JTextField();
		nombreCorto.setBounds(282, 81, 131, 22);
		getContentPane().add(nombreCorto);

		// Se agrega LNombre
		LNombre = new JLabel("Nombre Corto: ");
		LNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		LNombre.setBounds(128, 79, 117, 22);
		getContentPane().add(LNombre);
		
//		Se agrega LDescripción
		LDescripcion = new JLabel("Descripción: ");
		LDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		LDescripcion.setBounds(148, 131, 109, 22);
		getContentPane().add(LDescripcion);

//		Se agrega descripción
		descripcion = new JTextArea();
		descripcion.setBounds(282, 131, 131, 69);
		getContentPane().add(descripcion);

//		Se agrega mensaje
		mensaje = new JLabel("Aquí irá el mensaje de que el código ha sigo generado");
		mensaje.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mensaje.setBounds(94, 240, 413, 22);
		getContentPane().add(mensaje);

//		Se agrega el botón de atrás
		atras = new JButton("ATRÁS");
		atras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		atras.setBounds(52, 300, 120, 30);
		getContentPane().add(atras);

//		Se agrega el botón de alta
		alta = new JButton("ALTA");
		alta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		alta.setBounds(419, 300, 120, 30);
		getContentPane().add(alta);

		setSize(600, 400);
		setLocationRelativeTo(null);
	}

	/**
	 * Método que hace visible la pantalla
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}