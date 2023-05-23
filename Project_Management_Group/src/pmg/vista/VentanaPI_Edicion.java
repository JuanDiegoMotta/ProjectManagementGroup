/**
 * 
 */
package pmg.vista;

import java.awt.*;

import javax.swing.*;

import pmg.controlador.*;
import pmg.modelo.Alumno;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Clase de la VentanaPI_Edicion, que permite editar un proyecto integrador según su código.
 * 
 * @author PMG
 *
 */
public class VentanaPI_Edicion extends JFrame {
	// Labels
	private JLabel lblGrupo;
	private JLabel lblCurso;
	private JLabel lblNota;
	private JLabel lblAno;
	private JLabel lblArea;
	private JLabel lblCod;
	// Otros JComponents
	private JTextField txtNombre;
	private JSpinner spnrCurso;
	private JSpinner spnrNota;
	private JComboBox<String> cmbxAno;
	private JComboBox<String> cmbxArea;
	private JButton btnAtras;
	private JButton btnGuardar;
	private JTextField txtCod;
	private JButton btnRellenar;
	private ImageIcon rellenar;
	private JLabel lblAviso;
	private ImageIcon fondo;
	private JLabel lblFondo;
	private ArrayList<String> areasList;
	private JLabel lblGit;
	private JTextField txtGit;
	
	//Getters necesarios
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnRellenar() {
		return btnRellenar;
	}

	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JSpinner getSpnrCurso() {
		return spnrCurso;
	}

	public JSpinner getSpnrNota() {
		return spnrNota;
	}

	public JComboBox<String> getCmbxAno() {
		return cmbxAno;
	}

	public JComboBox<String> getCmbxArea() {
		return cmbxArea;
	}

	public JTextField getTxtCod() {
		return txtCod;
	}
	
	public JLabel getLblAviso() {
		return lblAviso;
	}
	public void setAreasList(ArrayList<String> areas) {
		areasList = areas;
	}
	public JTextField getTxtGit() {
		return txtGit;
	}


	/**
	 * Constructor de la clase VentanaPI_Edicion
	 * 
	 * @param titulo Titulo de la ventana
	 */
	public VentanaPI_Edicion(String titulo) {
		super(titulo);
		inicializarComponentes();
	}
  
	/**
	 * Método que se encarga de inicializar los componentes gráficos a nuestra aplicación.
	 */
	public void inicializarComponentes() {
		// Configuramos layout a absoluto
		getContentPane().setLayout(null);
		
		// Se sale determina que hace la app al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
		lblCurso.setBounds(221, 146, 42, 30);
		getContentPane().add(lblCurso);

		// Inicializamos lblNota
		lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNota.setBounds(221, 189, 60, 30);
		getContentPane().add(lblNota);

		// Inicializamos lblAno
		lblAno = new JLabel("Año:");
		lblAno.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAno.setBounds(225, 229, 42, 30);
		getContentPane().add(lblAno);

		// Inicializamos lblArea
		lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArea.setBounds(225,269, 37, 30);
		getContentPane().add(lblArea);

		// Inicializamos lblCod
		lblCod = new JLabel("Introduce el código:");
		lblCod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCod.setBounds(126, 29, 137, 30);
		getContentPane().add(lblCod);

		// Inicializamos txtNombre
		txtNombre = new JTextField();
		txtNombre.setBounds(297, 80, 211, 25);
		getContentPane().add(txtNombre);

		// Inicializamos spnrCurso
		spnrCurso = new JSpinner();
		spnrCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spnrCurso.setBounds(297, 151, 60, 25);
		getContentPane().add(spnrCurso);
    
  // Inicializamos spnrNota
		spnrNota = new JSpinner();
		spnrNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spnrNota.setBounds(297, 192, 60, 25);
		getContentPane().add(spnrNota);

		// Inicializamos cmbxAno
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
		cmbxAno.setBounds(297, 234, 60, 25);
		getContentPane().add(cmbxAno);

		// Inicializamos cmbxArea
		cmbxArea = new JComboBox<String>();
		cmbxArea.setBounds(297, 274, 60, 25);
		getContentPane().add(cmbxArea);

		// Inicializamos btnAtras
		btnAtras = new JButton("ATRÁS");
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(42, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Inicializamos btnGuardar
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(Color.decode("#BCD0C7"));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardar.setFocusable(false);
		btnGuardar.setBounds(419, 300, 120, 30);
		getContentPane().add(btnGuardar);
    
		// Inicializamos txtCod
		txtCod = new JTextField();
		txtCod.setBounds(297, 34, 145, 25);
		getContentPane().add(txtCod);
		txtCod.setColumns(10);
		
    // Inicializamos btnRellenar
		btnRellenar = new JButton();
		btnRellenar.setBackground(Color.decode("#BCD0C7"));
		btnRellenar.setBounds(471, 29, 37, 30);
		btnRellenar.setFocusable(false);
		getContentPane().add(btnRellenar);
		rellenar = new ImageIcon();
		btnRellenar.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/rellenar.png")));

		//Inicializamos lblGit
		lblGit = new JLabel("Git URL:");
		lblGit.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGit.setBounds(210, 121, 53, 14);
		getContentPane().add(lblGit);
		
		//Inicializamos txtGit
		txtGit = new JTextField();
		txtGit.setBounds(297, 116, 211, 24);
		getContentPane().add(txtGit);
		txtGit.setColumns(10);
    // Inicializamos lblAviso
		lblAviso = new JLabel((String) null);
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(172, 310, 237, 14);
		getContentPane().add(lblAviso);
		// Fondo de pantalla
		lblFondo = new JLabel();
		lblFondo.setBackground(Color.BLACK);
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));
		
		
		

	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 * 
	 * @param ba Clase ListenerBotonAtras
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerMostrar lm, ListenerGuardar lg) {
		btnAtras.addActionListener(ba);
		btnRellenar.addActionListener(lm);
		btnGuardar.addActionListener(lg);
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
	
	/**
	 * Actualiza el texto del componente de aviso y el componente lblCod en función del resultado.
	 *
	 * @param caso indica si la operación fue exitosa (true) o no (false)
	 */
	public void mostrarAviso(boolean caso) {
		if (caso) {
			lblAviso.setText("PI editado correctamente");
		} else {
			lblAviso.setText("Error al editar PI");
		}
	}
}
