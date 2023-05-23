/**
 * 
 */
package pmg.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import pmg.controlador.*;

/**
 * @author juanm
 * 
 *         Clase de la ventana gráfica Alumnos que edita al alumno según su
 *         código.
 *
 */

public class VentanaAlumnos_Edicion extends JFrame {
	// Labels
	private JLabel lblNombre;
	private JLabel lblNumExp;
	private JLabel lblArea;
	private JLabel lblCod;
	private JLabel lblAviso;
	// Otros JComponents
	private JTextField txtNombre;
	private JTextField txtNumExp;
	private JTextField txtCod;
	private JComboBox<String> cmbxArea;
	private JButton btnAtras;
	private JButton btnGuardar;
	private JButton btnRellenar;
	private ImageIcon rellenar;
	private ImageIcon fondo;
	private JLabel lblFondo;
	private ArrayList<String> areasList;

	// Getters necesarios
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnRellenar() {
		return btnRellenar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtNumExp() {
		return txtNumExp;
	}

	public JTextField getTxtCod() {
		return txtCod;
	}

	public JComboBox<String> getCmbxArea() {
		return cmbxArea;
	}

	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setAreasList(ArrayList<String> areas) {
		areasList = areas;
	}

	/**
	 * Constructor de VentanaAlumnos_Edicion con parámetros
	 * 
	 * @param titulo título de la ventana
	 */
	public VentanaAlumnos_Edicion(String titulo) {
		super(titulo);
		inicializarComponentes();
	}

	/**
	 * Método encargado de inicializar todos los componentes de la ventana
	 */
	public void inicializarComponentes() {
		// Configuramos layout a absoluto
		getContentPane().setLayout(null);

		// Le damos tamaño y posición a la ventana
		setSize(600, 400);
		setLocationRelativeTo(null);

		// Inicializamos y situamos los JComponent
		lblNombre = new JLabel("Nombre y apellido:");
		lblNombre.setBounds(107, 114, 131, 30);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblNombre);

		// Creamos txtNombre
		txtNombre = new JTextField();
		txtNombre.setBounds(270, 121, 137, 20);
		getContentPane().add(txtNombre);

		lblNumExp = new JLabel("Número Expediente:");
		lblNumExp.setBounds(107, 154, 156, 30);
		lblNumExp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblNumExp);

		// Creamos txtNumExt
		txtNumExp = new JTextField();
		txtNumExp.setBounds(268, 162, 138, 20);
		getContentPane().add(txtNumExp);

		// Creamos lblArea
		lblArea = new JLabel("Área:");
		lblArea.setBounds(210, 189, 42, 30);
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblArea);

		// Creamos el JComboBox cmbxArea y le añadimos los datos
		lblCod = new JLabel("Introduce el código:");
		lblCod.setBounds(107, 73, 137, 30);
		lblCod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblCod);

		txtCod = new JTextField();
		txtCod.setBounds(270, 81, 137, 20);
		getContentPane().add(txtCod);

		cmbxArea = new JComboBox<String>();
		cmbxArea.setBounds(269, 196, 68, 20);
		getContentPane().add(cmbxArea);

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(52, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Creamos botón alta y lo agregamos a la ventana
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardar.setBackground(Color.decode("#BCD0C7"));
		btnGuardar.setFocusable(false);
		btnGuardar.setBounds(419, 300, 120, 30);
		getContentPane().add(btnGuardar);

		btnRellenar = new JButton();
		btnRellenar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRellenar.setBackground(Color.decode("#BCD0C7"));
		btnRellenar.setBounds(417, 73, 36, 30);
		btnRellenar.setFocusable(false);
		getContentPane().add(btnRellenar);
		rellenar = new ImageIcon();
		btnRellenar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/rellenar.png")));

		lblAviso = new JLabel("");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(52, 258, 458, 14);
		getContentPane().add(lblAviso);

		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));

	}

	/**
	 * Método que hace visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerMostrar lm) {
		btnAtras.addActionListener(ba);
		btnRellenar.addActionListener(lm);
	}

	/**
	 * Método que rellena el ComboBox de areas con las areas en areasList
	 */
	public void rellenarComboBox() {
		if (cmbxArea.getItemCount()>0) {
			cmbxArea.removeAllItems();
		}
		for (String area : areasList) {
			cmbxArea.addItem(area);
		}
	}
}
