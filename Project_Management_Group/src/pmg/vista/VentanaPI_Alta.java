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
	private ImageIcon fondo;
	private JLabel lblFondo;

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
		lblGrupo.setBounds(133, 25, 130, 30);
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
		lblAno.setBounds(226, 182, 37, 30);
		getContentPane().add(lblAno);

		// Inicializamos lblArea
		lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArea.setBounds(221, 223, 37, 30);
		getContentPane().add(lblArea);

		lblCod = new JLabel("");
		lblCod.setForeground(new Color(0, 0, 0));
		lblCod.setFont(new Font("Segoe UI", Font.BOLD, 14));

		lblCod.setBounds(133, 264, 321, 30);
		getContentPane().add(lblCod);

		// Inicializamos txtNombre
		txtNombre = new JTextField();
		txtNombre.setBounds(296, 32, 211, 25);
		getContentPane().add(txtNombre);

		// Inicializamos spnrCurso
		spnrCurso = new JSpinner();
		spnrCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spnrCurso.setBounds(296, 109, 60, 25);
		getContentPane().add(spnrCurso);

		// Inicializamos spnrNota
		spnrNota = new JSpinner();
		spnrNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spnrNota.setBounds(296, 148, 60, 25);
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
		cmbxAno.setBounds(296, 189, 60, 25);
		getContentPane().add(cmbxAno);

		// Inicializamos cmbxArea
		cmbxArea = new JComboBox<String>();
		String[] areas = { "DAW", "ASIR", "DAM", "A3DV" };
		DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>(areas);
		cmbxArea.setModel(modeloComboBox);
		cmbxArea.setSelectedIndex(-1);
		// TODO Cuando se añada un área nueva, ésta se tiene que añadir automáticamente
		// a este cmbx
		cmbxArea.setBounds(296, 230, 60, 25);
		getContentPane().add(cmbxArea);

		// Inicializamos btnAtras
		btnAtras = new JButton("ATRÁS");
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setBounds(42, 300, 120, 30);
		btnAtras.setFocusable(false);
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(btnAtras);

		// Inicializamos btnAlta

		btnAlta = new JButton("ALTA");
		btnAlta.setBackground(Color.decode("#BCD0C7"));
		btnAlta.setBounds(419, 300, 120, 30);
		btnAlta.setFocusable(false);
		btnAlta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(btnAlta);

		// Inicializamos lblUrl
		lblURL = new JLabel("Código git:");
		lblURL.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblURL.setBounds(188, 63, 75, 30);
		getContentPane().add(lblURL);

		// Inicializamos txtURL
		txtURL = new JTextField();
		txtURL.setBounds(296, 70, 211, 25);
		getContentPane().add(txtURL);
		txtURL.setColumns(10);

		// Inicializamos lblAviso
		lblAviso = new JLabel("");
		lblAviso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAviso.setBounds(221, 295, 169, 40);
		getContentPane().add(lblAviso);

		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));

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
				JOptionPane.showMessageDialog(null, "Faltan campos por completar");
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
