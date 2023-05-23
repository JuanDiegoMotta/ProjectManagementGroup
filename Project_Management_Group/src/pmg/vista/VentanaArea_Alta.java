/**
 * 
 */
package pmg.vista;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

import pmg.controlador.*;
import pmg.modelo.*;

/**
 * Clase de la ventana gráfica Áreas, que da de alta un área con su nombre corto y una pequeña descripción.
 * 
 * @author PMG
 *
 */
public class VentanaArea_Alta extends JFrame {
	private JTextField nombreCorto;
	private JTextArea descripcion;
	private JLabel LNombre;
	private JLabel LDescripcion;
	private JLabel mensaje;
	private JLabel aviso;
	private JButton atras;
	private JButton alta;
	private ImageIcon fondo;
	private JLabel lblFondo;

	/**
	 * Constructor de la clase VentanaArea_Alta
	 * 
	 * @param titulo Título de la ventana alta de áreas
	 */
	public VentanaArea_Alta(String titulo) {
		super(titulo);
		inicializarComponentes();

	}

	// Getters necesarios
	public JButton getBtnAlta() {
		return alta;
	}

	public JLabel getMensaje() {
		return mensaje;
	}

	public JLabel getAviso() {
		return aviso;
	}

	/**
	 * Método que se encarga de inicializar los componentes gráficos a nuestra aplicación.
	 */
	private void inicializarComponentes() {

		// Configuramos el layout a null.
		getContentPane().setLayout(null);
		
		// Determina que hace la app al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Se agrega nombreCorto
		nombreCorto = new JTextField();
		nombreCorto.setBounds(282, 72, 131, 25);
		getContentPane().add(nombreCorto);

		// Se agrega LNombre
		LNombre = new JLabel("Nombre corto: ");
		LNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		LNombre.setBounds(137, 71, 117, 22);
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
		mensaje = new JLabel("");
		mensaje.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mensaje.setBounds(182, 229, 254, 22);
		getContentPane().add(mensaje);

//		Se agrega aviso
		aviso = new JLabel("");
		aviso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		aviso.setBounds(199, 252, 214, 22);
		getContentPane().add(aviso);

//		Se agrega el botón de atrás
		atras = new JButton("ATRÁS");
		atras.setBackground(Color.decode("#BCD0C7"));
		atras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		atras.setFocusable(false);
		atras.setBounds(52, 300, 120, 30);
		getContentPane().add(atras);

//		Se agrega el botón de alta
		alta = new JButton("ALTA");
		alta.setBackground(Color.decode("#BCD0C7"));
		alta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		alta.setFocusable(false);
		alta.setBounds(419, 300, 120, 30);
		getContentPane().add(alta);
		
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
	 * Método que recoge los datos de los txtField, crea un objeto DatosAltaArea y
	 * lo devuelve
	 * 
	 * @return objeto de DatosAltaArea
	 */
	public DatosAltaArea getDatos() {

		JTextField[] textFields = { nombreCorto };

		for (JTextField textField : textFields) {
			if (textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Falta el nombre corto por completar");
				return null; // Si hay un campo vacío, retornamos null o puedes manejarlo de otra manera
								// según tu lógica
			}
		}

		String nombre_corto = nombreCorto.getText();
		String cod_area = generarCodigo();
		String descripcion = this.descripcion.getText();
		DatosAltaArea datos = new DatosAltaArea(nombre_corto, cod_area, descripcion);
		return datos;
	}

	/**
	 * Método que genera un código alfanumérico de 6 caracteres
	 * 
	 * @return una String con ese código
	 */
	public String generarCodigo() {

		StringBuilder codigo = new StringBuilder();
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int index = rand.nextInt(caracteres.length());
			codigo.append(caracteres.charAt(index));
		}
		mensaje.setText("Código de área generado: " + codigo.toString());
		return codigo.toString();
	}

	/**
	 * Actualiza el texto del componente de aviso y el componente lblCod en función
	 * del resultado.
	 *
	 * @param caso indica si la operación fue exitosa (true) o no (false)
	 */
	public void mostrarAviso(boolean caso) {
		if (caso) {
			aviso.setText("Área añadida correctamente");
		} else {
			aviso.setText("Error al añadir el área");
			mensaje.setText("");
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
	public void setControlador(ListenerBotonAtras ba, ListenerBotonAlta bal) {
		atras.addActionListener(ba);
		alta.addActionListener(bal);
	}

}