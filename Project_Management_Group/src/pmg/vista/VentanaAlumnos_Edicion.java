/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;


import pmg.controlador.ListenerBotonAtras;

/**
 * @author juanm
 * 
 * Clase de la ventana gráfica Alumnos que edita al alumno según su código.
 *
 */

public class VentanaAlumnos_Edicion extends JFrame {
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
		private JButton btnEdition;
		private ImageIcon rellenar;
		
		/**
		 * Constructor de la clase VentanaAlumnos_Edición
		 * @param titulo
		 */
		public VentanaAlumnos_Edicion(String titulo) {
			super(titulo);
			inicializarComponentes();
		}
		
		/**
		 * Método encargado de inicializar todos los componentes de la ventana
		 */
		public void inicializarComponentes() {
			//Configuramos layout a absoluto
			getContentPane().setLayout(null);
			
			//Le damos tamaño y posición a la ventana
			setSize(600,400);
			setLocationRelativeTo(null);
			
			// Creamos lblNombre
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(183, 78, 100, 30);
			lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
			getContentPane().add(lblNombre);
			
			// Creamos txtNombre
			txtNombre = new JTextField();
			txtNombre.setBounds(270, 86, 137, 20);
			getContentPane().add(txtNombre);
			
			// Creamos lblApellido
			lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(183, 118, 70, 30);
			lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 14));
			getContentPane().add(lblApellido);
			
			// Creamos txtApellido
			txtApellido = new JTextField();
			txtApellido.setBounds(270, 126, 137, 20);
			getContentPane().add(txtApellido);
			
			// Creamos lblNumExp
			lblNumExp = new JLabel("Numero Expediente:");
			lblNumExp.setBounds(108, 158, 156, 30);
			lblNumExp.setFont(new Font("Segoe UI", Font.BOLD, 14));
			getContentPane().add(lblNumExp);
			
			// Creamos txtNumExt
			txtNumExp = new JTextField();
			txtNumExp.setBounds(269, 166, 138, 20);
			getContentPane().add(txtNumExp);
			
			// Creamos lblArea
			lblArea = new JLabel("Área:");
			lblArea.setBounds(211,193, 42, 30);
			lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
			getContentPane().add(lblArea);
			
			// Creamos lblCp
			lblCp = new JLabel("Introduce el código:");
			lblCp.setBounds(107, 38, 137, 30);
			lblCp.setFont(new Font("Segoe UI", Font.BOLD, 14));
			getContentPane().add(lblCp);
			
			// Creamos txtCp
			txtCp = new JTextField();
			txtCp.setBounds(270, 46, 137, 20);
			getContentPane().add(txtCp);
			
			// Creamos lblCod
			lblCod = new JLabel("Aquí iría el código generado automáticamente (al pulsar el botón)");
			lblCod.setBounds(122, 233, 321, 30);
			getContentPane().add(lblCod);
			
			// Creamos el JComboBox cmbxArea y le añadimos los datos
			cmbxArea = new JComboBox<String>();
			cmbxArea.addItem("DAW");
			cmbxArea.addItem("DAM");
			cmbxArea.addItem("ASIR");
			cmbxArea.addItem("A3DV");
			cmbxArea.setBounds(270, 200, 138, 20);
			getContentPane().add(cmbxArea);
			
			// Creamos botón atrás y lo agregamos a la ventana
			btnAtras = new JButton("ATRÁS");
			btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnAtras.setBounds(52, 300, 120, 30);
			getContentPane().add(btnAtras);
			
			// Creamos el botón btnEdition
			btnEdition = new JButton();
			btnEdition.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnEdition.setBounds(417, 36, 52, 39);
			getContentPane().add(btnEdition);
			rellenar = new ImageIcon();
			btnEdition.setIcon(new ImageIcon(VentanaAlumnos_Baja.class.getResource("/img/rellenar.png")));
			
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
		public void setControlador(ListenerBotonAtras ba) {
			btnAtras.addActionListener(ba);
		}

}
