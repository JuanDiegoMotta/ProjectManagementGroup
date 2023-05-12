/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

import pmg.modelo.Alumno;

/**
 * @author juanm
 * Clase de la ventana gráfica Alumnos que da de alta al alumno según su código.
 *
 */
public class VentanaAlumnos_Alta extends JFrame implements iVentana{
	//Labels
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblNumExp;
	private JLabel lblArea;
	private JLabel lblCod;
	private JLabel lblCp;
	//Otros JComponents
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNumExp;
	private JTextField txtCp;
	private JComboBox<String> cmbxArea;
	private JButton btnAtras;
	private JButton btnAlta;
	
	public VentanaAlumnos_Alta(String titulo) {
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
		lblArea.setBounds(206,142, 42, 30);
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblArea);
		
		lblCp = new JLabel("Código Proyecto:");
		lblCp.setBounds(122, 182, 122, 30);
		lblCp.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblCp);
		
		txtCp = new JTextField();
		txtCp.setBounds(270, 189, 137, 20);
		getContentPane().add(txtCp);
		
		lblCod = new JLabel("Aquí iría el código generado automáticamente (al pulsar el botón)");
		lblCod.setBounds(122, 233, 321, 30);
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
