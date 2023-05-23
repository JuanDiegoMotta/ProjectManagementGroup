/**
 * 
 */
package pmg.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.*;
import pmg.controlador.*;
import pmg.modelo.*;

/**
 * Clase de la ventana gráfica Alumnos que da de alta al alumno según su código
 * 
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
	private ImageIcon fondo;
	private JLabel lblFondo;
	private ArrayList<String> areasList;

	/**
	 * Método que crea una nueva instancia de la ventana de alta de alumnos con el título.
	 *
	 * @param titulo el título de la ventana alta de alumnos
	 */
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
	
	public void setAreasList(ArrayList<String> areas) {
		areasList = areas;
	}

	public void inicializarComponentes() {
		// Configuramos layout a absoluto
		getContentPane().setLayout(null);

		// Le damos tamaño y posición a la ventana
		setSize(600, 400);
		setLocationRelativeTo(null);

		// Inicializamos y situamos los JComponent
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(179, 67, 100, 30);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(270, 74, 137, 25);
		getContentPane().add(txtNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(179, 108, 70, 30);
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(270, 115, 137, 25);
		getContentPane().add(txtApellido);

		lblNumExp = new JLabel("Numero Expediente:");
		lblNumExp.setBounds(102, 153, 156, 30);
		lblNumExp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblNumExp);

		txtNumExp = new JTextField();
		txtNumExp.setBounds(269, 160, 138, 25);
		getContentPane().add(txtNumExp);

		lblArea = new JLabel("Área:");
		lblArea.setBounds(202, 200, 42, 30);
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblArea);

		lblCod = new JLabel("");
		lblCod.setBounds(177, 300, 230, 30);
		getContentPane().add(lblCod);

		cmbxArea = new JComboBox<String>();
		cmbxArea.setBounds(270, 207, 138, 25);
		getContentPane().add(cmbxArea);

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setFocusable(false);
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setBounds(52, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Creamos botón alta y lo agregamos a la ventana
		btnAlta = new JButton("ALTA");
		btnAlta.setBackground(Color.decode("#BCD0C7"));
		btnAlta.setFocusable(false);
		btnAlta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAlta.setBounds(419, 300, 120, 30);
		getContentPane().add(btnAlta);

		aviso = new JLabel();
		aviso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		aviso.setBounds(142, 245, 314, 30);
		getContentPane().add(aviso);
		
		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));
	}

	/**
	 * Método que establece los controladores de eventos para los botones.
	 *
	 * @param ba el controlador para el botón atrás
	 * @param bal el controlador para el botón alta
	 */
	
	public void setControlador(ListenerBotonAtras ba, ListenerBotonAlta bal) {
		btnAtras.addActionListener(ba);
		btnAlta.addActionListener(bal);
	}

	/**
	 * Método que genera un código alfanumérico de 6 caracteres y lo añade a la label lblCod.
	 *
	 * @return el código generado
	 */
	public String generarCodigo() {

		StringBuilder codigo = new StringBuilder();
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int index = rand.nextInt(caracteres.length());
			codigo.append(caracteres.charAt(index));
		}
		lblCod.setText("Código de alumno generado: " + codigo.toString());
		return codigo.toString();
	}

	/**
	 * Método que obtiene los datos ingresados en los campos de texto del alta del alumno.
	 * Si algún campo está vacío, muestra un mensaje de error y retorna null.
	 *
	 * @return los datos ingresados en forma de objeto DatosAltaAlumno, o null si algún campo está vacío
	 */
	public DatosAltaAlumno getDatos() {

		JTextField[] textFields = { txtNombre, txtApellido, txtNumExp };

		for (JTextField textField : textFields) {
			if (textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Faltan campos por completar");
				return null; // Si hay un campo vacío, retornamos null o puedes manejarlo de otra manera
								// según tu lógica
			}
		}

		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String nombreCompleto = nombre + " " + apellido;
		String numExp = txtNumExp.getText();
		String area = cmbxArea.getSelectedItem().toString();
		String codAlumno = generarCodigo();

		DatosAltaAlumno datos = new DatosAltaAlumno(nombreCompleto, numExp, codAlumno, area);

		return datos;
	}

	/**
	 * Actualiza el texto del componente de aviso y el componente lblCod en función del resultado.
	 *
	 * @param caso indica si la operación fue exitosa (true) o no (false)
	 */
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
	
	/**
	 * Método que rellena el ComboBox de areas con las areas en areasList
	 */
	public void rellenarComboBox() {
		if (cmbxArea.getItemCount()>0) {
			cmbxArea.removeAllItems();
		}
		for(String area: areasList) {			
			cmbxArea.addItem(area);
		}
	}
}
