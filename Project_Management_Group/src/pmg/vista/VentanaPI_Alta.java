/**
 * 
 */
package pmg.vista;

import javax.swing.*;

import pmg.controlador.*;
import pmg.modelo.*;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

/**
 * Clase de la ventana gráfica que da de alta los proyectos integradores
 * 
 * @author juanm
 *
 */
public class VentanaPI_Alta extends JFrame {
	// Labels
	private JLabel lblGrupo;
	private JLabel lblCurso;
//	private JLabel lblComponentes;
	private JLabel lblNota;
	private JLabel lblAno;
	private JLabel lblArea;
	private JLabel lblCod;
	private JLabel lblURL;
	// Otros JComponents
	private JTextField txtNombre;
	private JSpinner spnrCurso;
//	private JList<Alumno> listAlumnos;
	private JSpinner spnrNota;
	private JComboBox<String> cmbxAno;
	private JComboBox<String> cmbxArea;
	private JButton btnAtras;
	private JButton btnAlta;
	private JTextField txtURL;
	private JLabel lblAviso;

	public VentanaPI_Alta(String titulo) {
		super(titulo);
		inicializarComponentes();
	}

	// Getter del botón alta
	public JButton getBtnAlta() {
		return btnAlta;
	}

	public JLabel getLblCod() {
		return lblCod;
	}

	public JLabel getLblAviso() {
		return lblAviso;
	}

	/**
	 * Método para inicializar los componentes de la ventana
	 */
	public void inicializarComponentes() {
		// Configuramos layout a absoluto
		getContentPane().setLayout(null);

		// Le damos tamaño y posición a la ventana
		setSize(600, 400);
		setLocationRelativeTo(null);

		// Inicializamos y situamos los JComponent
		lblGrupo = new JLabel("Nombre del grupo:");
		lblGrupo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGrupo.setBounds(133, 22, 130, 30);
		getContentPane().add(lblGrupo);

		// Inicializamos lblCurso
		lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCurso.setBounds(221, 102, 42, 30);
		getContentPane().add(lblCurso);

		// Inicializamos lblNota
		lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNota.setBounds(221, 141, 42, 30);
		getContentPane().add(lblNota);

		// Inicializamos lblAno
		lblAno = new JLabel("Año:");
		lblAno.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAno.setBounds(221, 182, 42, 30);
		getContentPane().add(lblAno);

		// Inicializamos lblArea
		lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArea.setBounds(221, 223, 37, 30);
		getContentPane().add(lblArea);

		// Inicializamos lblCod
		lblCod = new JLabel("Aquí iría el código generado automáticamente (al pulsar el botón)");
		lblCod.setForeground(new Color(192, 192, 192));
		lblCod.setBounds(133, 264, 321, 30);
		getContentPane().add(lblCod);

		// Inicializamos txtNombre
		txtNombre = new JTextField();
		txtNombre.setBounds(320, 22, 100, 30);
		getContentPane().add(txtNombre);

		// Inicializamos spnrCurso
		spnrCurso = new JSpinner();
		spnrCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spnrCurso.setBounds(320, 102, 30, 30);
		getContentPane().add(spnrCurso);

		// Inicializamos spnrNota
		spnrNota = new JSpinner();
		spnrNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spnrNota.setBounds(320, 143, 30, 30);
		getContentPane().add(spnrNota);

		// Inicializamos el JComboBox de cmbxAno
		cmbxAno = new JComboBox<String>();
		cmbxAno.addItem("2023");
		cmbxAno.addItem("2024");
		cmbxAno.addItem("2025");
		cmbxAno.addItem("2026");
		cmbxAno.addItem("2027");
		cmbxAno.addItem("2028");
		cmbxAno.addItem("2029");
		cmbxAno.addItem("2030");
		cmbxAno.addItem("2031");
		cmbxAno.addItem("2032");
		cmbxAno.addItem("2033");
		cmbxAno.addItem("2034");
		cmbxAno.addItem("2035");
		cmbxAno.addItem("2036");
		cmbxAno.addItem("2037");
		cmbxAno.addItem("2038");
		cmbxAno.addItem("2039");
		cmbxAno.addItem("2040");
		cmbxAno.addItem("2041");
		cmbxAno.addItem("2042");
		cmbxAno.setBounds(309, 184, 40, 30);
		getContentPane().add(cmbxAno);

		// Inicializamos cmbxArea
		cmbxArea = new JComboBox<String>();
		cmbxArea.addItem("DAW");
		cmbxArea.addItem("DAM");
		cmbxArea.addItem("ASIR");
		cmbxArea.addItem("A3DV");
		// TODO Cuando se añada un área nueva, ésta se tiene que añadir automáticamente
		// a este cmbx
		cmbxArea.setBounds(309, 225, 60, 30);
		getContentPane().add(cmbxArea);

		// Inicializamos btnAtras
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(42, 300, 120, 30);
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(btnAtras);

		// Inicializamos btnAlta
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(419, 300, 120, 30);
		btnAlta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(btnAlta);

		// Inicializamos lblUrl
		lblURL = new JLabel("Código git:");
		lblURL.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblURL.setBounds(188, 63, 75, 30);
		getContentPane().add(lblURL);

		// Inicializamos txtURL
		txtURL = new JTextField();
		txtURL.setBounds(320, 71, 200, 20);
		getContentPane().add(txtURL);
		txtURL.setColumns(10);

		// Inicializamos lblAviso
		lblAviso = new JLabel("New label");
		lblAviso.setBounds(274, 310, 46, 14);
		getContentPane().add(lblAviso);

	}

	/**
	 * Método encargado de devolver un objeto de DatosAltaPI
	 * 
	 * @return
	 */
	public DatosAltaPI getDatos() {
		JTextField[] textFields = { txtNombre, txtURL };
		for (JTextField textField : textFields) { // Comprueba que los txtFields estén rellenos y si no lo están envia
													// un mensaje
			if (textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Faltan campos por comletar");
				return null; // Si hay un campo vacío, retornamos null o puedes manejarlo de otra manera
								// según tu lógica
			}
		}
		String año = (String) cmbxAno.getSelectedItem();
		String curso = String.valueOf((int) spnrCurso.getValue());
		String nota = String.valueOf((int) spnrNota.getValue());
		String cod_proyecto = generarCodigo();
		String nombre = txtNombre.getText();
		String url = txtURL.getText();
		String nc_area = (String) cmbxArea.getSelectedItem();
		DatosAltaPI datos = new DatosAltaPI(año, curso, nota, cod_proyecto, nombre, url, nc_area);
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
		lblCod.setText("Código de área generado: " + codigo.toString());
		return codigo.toString();
	}

	public void mostrarAviso(boolean caso) {
		if (caso) {
			lblAviso.setText("PI añadido correctamente");
		} else {
			lblAviso.setText("Error al añadir PI");
			lblCod.setText("");
		}

	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerBotonAlta bal) {
		btnAtras.addActionListener(ba);
		btnAlta.addActionListener(bal);
	}

	/**
	 * Método que hace visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}
}
