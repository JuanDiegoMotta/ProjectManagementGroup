/**
 * 
 */
package pmg.vista;

import javax.swing.*;

import pmg.modelo.Alumno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


/**
 * Clase de la ventana gráfica que da de alta los proyectos integradores
 * @author juanm
 *
 */
public class VentanaPI_Alta extends JFrame implements iVentana{
	//Labels
	private JLabel lblGrupo;
	private JLabel lblCurso;
	private JLabel lblComponentes;
	private JLabel lblNota;
	private JLabel lblAno;
	private JLabel lblArea;
	private JLabel lblCod;
	//Otros JComponents
	private JTextField txtNombre;
	private JSpinner spnrCurso;
	private JList<Alumno> listAlumnos;
	private JSpinner spnrNota;
	private JComboBox<String> cmbxAno;
	private JComboBox<String> cmbxArea;
	private JButton btnAtras;
	private JButton btnAlta;
	
	public VentanaPI_Alta(String titulo) {
		super(titulo);
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		//Configuramos layout a absoluto
		getContentPane().setLayout(null);
		
		//Le damos tamaño y posición a la ventana
		setSize(600,400);
		setLocationRelativeTo(null);
		
		//Inicializamos y situamos los JComponent
		lblGrupo = new JLabel("Nombre del grupo:");
		lblGrupo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGrupo.setBounds(133, 38, 130, 30);
		getContentPane().add(lblGrupo);
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCurso.setBounds(221, 79, 42, 30);
		getContentPane().add(lblCurso);
		
		lblComponentes = new JLabel("Componentes:");
		lblComponentes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblComponentes.setBounds(162, 121, 116, 30);
		getContentPane().add(lblComponentes);
		
		lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNota.setBounds(203, 161, 60, 30);
		getContentPane().add(lblNota);
		
		lblAno = new JLabel("Año:");
		lblAno.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAno.setBounds(221, 202, 42, 30);
		getContentPane().add(lblAno);
		
		lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArea.setBounds(226,243, 37, 30);
		getContentPane().add(lblArea);
		
		lblCod = new JLabel("Aquí iría el código generado automáticamente (al pulsar el botón)");
		lblCod.setForeground(new Color(192, 192, 192));
		lblCod.setBounds(147, 275, 321, 30);
		getContentPane().add(lblCod);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(320, 38, 100, 30);
		getContentPane().add(txtNombre);
		
		spnrCurso = new JSpinner();
		spnrCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spnrCurso.setBounds(320, 79, 30, 30);
		getContentPane().add(spnrCurso);
		
		listAlumnos = new JList<Alumno>();
		DefaultListModel<Alumno> dlm = new DefaultListModel<Alumno>();
//		dlm.addElement(new Alumno("Alumno1", "Apellidos", "12345678A"));
//		dlm.addElement(new Alumno("Alumno2", "Apellidos", "12345678E"));
//		dlm.addElement(new Alumno("Alumno3", "Apellidos", "12345678C"));
//		dlm.addElement(new Alumno("Alumno4", "Apellidos", "12345678B"));
//		dlm.addElement(new Alumno("Alumno5", "Apellidos", "12345678D"));
//		dlm.addElement(new Alumno("Alumno6", "Apellidos", "12345678F"));
		listAlumnos.setModel(dlm);
		listAlumnos.setBounds(320, 120, 100, 30);
		getContentPane().add(listAlumnos);
		
		spnrNota = new JSpinner();
		spnrNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spnrNota.setBounds(320, 161, 30, 30);
		getContentPane().add(spnrNota);
		
		cmbxAno = new JComboBox<String>();
		cmbxAno.addItem("1");
		cmbxAno.addItem("2");
		cmbxAno.setBounds(320, 202, 40, 30);
		getContentPane().add(cmbxAno);
		
		cmbxArea = new JComboBox<String>();
		cmbxArea.addItem("DAW");
		cmbxArea.addItem("DAM");
		cmbxArea.addItem("ASIR");
		cmbxArea.addItem("A3DV");
		cmbxArea.setBounds(320, 243, 60, 30);
		getContentPane().add(cmbxArea);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(42, 300, 120, 30);
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));

		getContentPane().add(btnAtras);
		
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(419, 300, 120, 30);
		btnAlta.setFont(new Font("Segoe UI", Font.BOLD, 14));

		getContentPane().add(btnAlta);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
