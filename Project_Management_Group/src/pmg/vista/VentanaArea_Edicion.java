/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

import pmg.controlador.ListenerBotonAtras;


/**
 * Clase VentanaArea_Edicion
 * @author Pablo
 *
 */
public class VentanaArea_Edicion extends JFrame implements iVentana{

	private JTextField nombreCorto;
	private JTextArea descripcion;
	private JLabel LNombre;
	private JLabel LDescripcion;
	private JButton atras;
	private JButton alta;
	private JLabel LCodigo;
	private JButton btnRellenar;
	private ImageIcon rellenar;

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
		nombreCorto.setBounds(282, 73, 131, 22);
		getContentPane().add(nombreCorto);

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
		descripcion = new JTextArea();
		descripcion.setBounds(282, 115, 131, 69);
		getContentPane().add(descripcion);

//		Se agrega botón de atrás
		atras = new JButton("ATRÁS");
		atras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		atras.setBounds(42, 300, 120, 30);
		getContentPane().add(atras);

//		Se agrega botón guardar
		alta = new JButton("GUARDAR");
		alta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		alta.setBounds(419, 300, 120, 30);
		getContentPane().add(alta);

//		Se agrega el botón de rellenar
		btnRellenar = new JButton();
		btnRellenar.setBounds(433, 59, 42, 42);
		btnRellenar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(btnRellenar);
		rellenar = new ImageIcon();
		btnRellenar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/rellenar.png")));

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
	public void setControlador(ListenerBotonAtras ba) {
		atras.addActionListener(ba);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
