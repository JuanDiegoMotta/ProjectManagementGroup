/**
 * 
 */
package pmg.vista;

import javax.swing.*;

/**
 * Clase de la ventana gráfica del log-in
 * @author juanm
 *
 */
public class VentanaLogIn extends JFrame {
	//private logo (no se cómo se coloca)
	private JLabel lblUser;
	private JLabel lblPwd;
	private JTextField txtUser;
	private JPasswordField txtPwd;
	private JButton btnLogin;
	
	/**
	 * Constructor con parametros de VentanaLogIn
	 * @param titulo titulo de la ventana
	 */
	public VentanaLogIn(String titulo) {
		super(titulo);
		inicializarComponentes();
	}
	
	/**
	 * Método que se encarga de inicializar los componentes y colocarlos en la ventana
	 */
	public void inicializarComponentes() {
		//Se configura el layout a absolute
		getContentPane().setLayout(null);
		
		//Se inicializan y colocan los componentes
		lblUser = new JLabel("Usuario:");
		lblUser.setBounds(198, 135, 50, 30);
		getContentPane().add(lblUser);
		
		lblPwd = new JLabel("Contraseña:");
		lblPwd.setBounds(178, 176, 70, 30);
		getContentPane().add(lblPwd);
		
		txtUser = new JTextField("");
		txtUser.setBounds(277, 135, 133, 30);
		getContentPane().add(txtUser);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(277, 176, 133, 30);
		getContentPane().add(txtPwd);
		
		btnLogin = new JButton("Log-in");
		btnLogin.setBounds(245, 250, 78, 30);
		getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("ICONO");
		lblNewLabel.setBounds(260, 93, 46, 14);
		getContentPane().add(lblNewLabel);
		
		//Se le da tamaño y posicion a la ventana
		setSize(600, 400);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Método que hace visible la ventana 
	 */
	public void hacerVisible() {
		setVisible(true);
	}
}
