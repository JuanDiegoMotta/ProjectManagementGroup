/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.*;
import pmg.controlador.*;
import pmg.modelo.*;

/**
 * Clase de la ventana gráfica Alumnos que da de alta al alumno según su código
 * @author juanm 
 *
 */
public class VentanaAlumnos_Alta extends JFrame {
	// Labels
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblNumExp;
	private JLabel lblArea;
	private JLabel lblCod;
	// Otros JComponents
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNumExp;
	private JTextField txtCp;
	private JComboBox<String> cmbxArea;
	private JButton btnAtras;
	private JButton btnAlta;
	private JLabel aviso;

	public VentanaAlumnos_Alta(String titulo) {
		super(titulo);
		inicializarComponentes();
	}

	// Getters necesarios
	public JButton getBtnAlta() {
		return btnAlta;
	}
	public JLabel getAviso() {
		return aviso;
	}
	public JLabel getLblCod() {
		return lblCod;
	}

	public void inicializarComponentes() {
		// Configuramos layout a absoluto
		getContentPane().setLayout(null);

		// Le damos tamaño y posición a la ventana
		setSize(600, 400);
		setLocationRelativeTo(null);

		// Inicializamos y situamos los JComponent
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(183, 20, 100, 30);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(270, 27, 137, 20);
		getContentPane().add(txtNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(183, 62, 70, 30);
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(270, 69, 137, 20);
		getContentPane().add(txtApellido);

		lblNumExp = new JLabel("Numero Expediente:");
		lblNumExp.setBounds(109, 101, 156, 30);
		lblNumExp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblNumExp);

		txtNumExp = new JTextField();
		txtNumExp.setBounds(270, 108, 138, 20);
		getContentPane().add(txtNumExp);

		lblArea = new JLabel("Área:");
		lblArea.setBounds(206, 142, 42, 30);
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblArea);

		lblCod = new JLabel("");
		lblCod.setBounds(152, 197, 321, 30);
		getContentPane().add(lblCod);

		cmbxArea = new JComboBox<String>();
		cmbxArea.addItem("DAW");
		cmbxArea.addItem("DAM");
		cmbxArea.addItem("ASIR");
		cmbxArea.addItem("A3DV");
		cmbxArea.setBounds(270, 149, 138, 20);
		getContentPane().add(cmbxArea);

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setBounds(52, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Creamos botón alta y lo agregamos a la ventana
		btnAlta = new JButton("ALTA");
		btnAlta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAlta.setBounds(419, 300, 120, 30);
		getContentPane().add(btnAlta);

		aviso = new JLabel();
		aviso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		aviso.setBounds(183, 249, 314, 30);
		getContentPane().add(aviso);
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerBotonAlta bal) {
		btnAtras.addActionListener(ba);
		btnAlta.addActionListener(bal);
	}

	public String generarCodigo() {

		StringBuilder codigo = new StringBuilder();
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int index = rand.nextInt(caracteres.length());
			codigo.append(caracteres.charAt(index));
		}
		lblCod.setText("Código de alumno generado: "+codigo.toString());
		return codigo.toString();
	}

	/**
	 * Método que recoge y devuelve los datos introducidos en las etiquetas
	 */
	public DatosAltaAlumno getDatos() {

		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String nombreCompleto = nombre + " " + apellido;
		String numExp = txtNumExp.getText();
		String area = cmbxArea.getSelectedItem().toString();
		String codAlumno = generarCodigo();

		DatosAltaAlumno datos = new DatosAltaAlumno(nombreCompleto, numExp, area, codAlumno);

		return datos;
	}

	public void mostrarAviso(boolean caso) {
		if (caso) {
			aviso.setText("Alumno añadido correctamente");
		} else {
			aviso.setText("Error al añadir el alumno");
			lblCod.setText("");
		}

	}

	/**
	 * Método que hace visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}
}
