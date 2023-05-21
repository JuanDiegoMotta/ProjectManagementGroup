/**
 * 
 */
package pmg.vista;

import java.awt.*;

import javax.swing.*;

import pmg.controlador.ListenerBotonAtras;
import pmg.modelo.Alumno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase VentanaPI_Edicion
 * 
 * @author juanm
 *
 */
public class VentanaPI_Edicion extends JFrame {
	// Labels
	private JLabel lblGrupo;
	private JLabel lblCurso;
	private JLabel lblComponentes;
	private JLabel lblNota;
	private JLabel lblAno;
	private JLabel lblArea;
	private JLabel lblCod;
	// Otros JComponents
	private JTextField txtNombre;
	private JSpinner spnrCurso;
	private JList<Alumno> listAlumnos;
	private JSpinner spnrNota;
	private JComboBox<String> cmbxAno;
	private JComboBox<String> cmbxArea;
	private JButton btnAtras;
	private JButton btnAlta;
	private JTextField textField;
	private JButton btnRellenar;
	private ImageIcon rellenar;

	/**
	 * Constructor de la clase VentanaPI_Edicion
	 * 
	 * @param titulo Titulo de la ventana
	 */
	public VentanaPI_Edicion(String titulo) {
		super(titulo);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		// Configuramos layout a absoluto
		getContentPane().setLayout(null);

		// Le damos tamaño y posición a la ventana
		setSize(600, 400);
		setLocationRelativeTo(null);

		// Inicializamos y situamos los JComponent
		lblGrupo = new JLabel("Nombre del grupo:");
		lblGrupo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGrupo.setBounds(133, 75, 130, 30);
		getContentPane().add(lblGrupo);

		// Inicializamos lblCurso
		lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCurso.setBounds(221, 116, 42, 30);
		getContentPane().add(lblCurso);

		// Inicializamos lblComponentes
		lblComponentes = new JLabel("Componentes:");
		lblComponentes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblComponentes.setBounds(163, 156, 100, 30);
		getContentPane().add(lblComponentes);

		// Inicializamos lblNota
		lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNota.setBounds(222, 200, 60, 30);
		getContentPane().add(lblNota);

		// Inicializamos lblAno
		lblAno = new JLabel("Año:");
		lblAno.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAno.setBounds(226, 240, 42, 30);
		getContentPane().add(lblAno);

		// Inicializamos lblArea
		lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArea.setBounds(226, 280, 37, 30);
		getContentPane().add(lblArea);

		// Inicializamos lblCod
		lblCod = new JLabel("Introduce el código:");
		lblCod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCod.setBounds(126, 29, 137, 30);
		getContentPane().add(lblCod);

		// Inicializamos txtNombre
		txtNombre = new JTextField();
		txtNombre.setBounds(320, 75, 100, 30);
		getContentPane().add(txtNombre);

		// Inicializamos spnrCurso
		spnrCurso = new JSpinner();
		spnrCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spnrCurso.setBounds(320, 116, 30, 30);
		getContentPane().add(spnrCurso);

		// Inicializamos listaAlumnos
		listAlumnos = new JList<Alumno>();
		DefaultListModel<Alumno> dlm = new DefaultListModel<Alumno>();
		listAlumnos.setModel(dlm);
		listAlumnos.setBounds(320, 157, 100, 30);
		getContentPane().add(listAlumnos);

		// Inicializamos spnrNota
		spnrNota = new JSpinner();
		spnrNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spnrNota.setBounds(320, 198, 30, 30);
		getContentPane().add(spnrNota);

		// Inicializamos cmbxAno
		cmbxAno = new JComboBox<String>();
		cmbxAno.addItem("1");
		cmbxAno.addItem("2");
		cmbxAno.setBounds(320, 239, 40, 30);
		getContentPane().add(cmbxAno);

		// Inicializamos cmbxArea
		cmbxArea = new JComboBox<String>();
		cmbxArea.addItem("DAW");
		cmbxArea.addItem("DAM");
		cmbxArea.addItem("ASIR");
		cmbxArea.addItem("A3DV");
		cmbxArea.setBounds(320, 280, 60, 30);
		getContentPane().add(cmbxArea);

		// Inicializamos btnAtras
		btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setBounds(42, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Inicializamos btnAlta
		btnAlta = new JButton("Guardar");
		btnAlta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAlta.setBounds(419, 300, 120, 30);
		getContentPane().add(btnAlta);

		// Inicializamos textField
		textField = new JTextField();
		textField.setBounds(320, 32, 100, 30);
		getContentPane().add(textField);
		textField.setColumns(10);

		// Inicializamos btnRellenar
		btnRellenar = new JButton();
		btnRellenar.setBounds(452, 29, 42, 37);
		getContentPane().add(btnRellenar);
		rellenar = new ImageIcon();
		btnRellenar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/rellenar.png")));

	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 * 
	 * @param ba Clase ListenerBotonAtras
	 */
	public void setControlador(ListenerBotonAtras ba) {
		btnAtras.addActionListener(ba);
	}

	/**
	 * Método que hace visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}

}
