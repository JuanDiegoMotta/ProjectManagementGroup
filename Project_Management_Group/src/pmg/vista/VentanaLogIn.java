/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Clase de la ventana gráfica del log-in
 * 
 * @author juanm
 *
 */
public class VentanaLogIn extends JFrame implements iVentana {
	// private logo (no se cómo se coloca)
	private JLabel lblUser;
	private JLabel lblPwd;
	private JTextField txtUser;
	private JPasswordField txtPwd;
	private JButton btnLogin;

	/**
	 * Constructor con parametros de VentanaLogIn
	 * 
	 * @param titulo titulo de la ventana
	 */
	public VentanaLogIn(String titulo) {
		super(titulo);
		inicializarComponentes();
	}

	/**
	 * Método que se encarga de inicializar los componentes y colocarlos en la
	 * ventana
	 */
	public void inicializarComponentes() {
		// Se configura el layout a absolute
		getContentPane().setLayout(null);

		// Se inicializan y colocan los componentes
		lblUser = new JLabel("Usuario:");
		lblUser.setBounds(178, 135, 70, 30);
		lblUser.setFont(new Font("Segoe UI", Font.BOLD, 14));

		getContentPane().add(lblUser);

		lblPwd = new JLabel("Contraseña:");
		lblPwd.setBounds(151, 176, 97, 30);
		lblPwd.setFont(new Font("Segoe UI", Font.BOLD, 14));

		getContentPane().add(lblPwd);

		txtUser = new JTextField("");
		txtUser.setBounds(277, 135, 133, 30);
		getContentPane().add(txtUser);

		txtPwd = new JPasswordField();
		txtPwd.setBounds(277, 176, 133, 30);
		getContentPane().add(txtPwd);

		btnLogin = new JButton("Log-in");
		btnLogin.setBounds(219, 250, 120, 30);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));

		getContentPane().add(btnLogin);

		JLabel lblNewLabel = new JLabel("ICONO");
		lblNewLabel.setBounds(248, 95, 63, 14);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

		getContentPane().add(lblNewLabel);

		// Se le da tamaño y posicion a la ventana
		setSize(600, 400);
		setLocationRelativeTo(null);
	}

	/**
	 * Método que hace visible la ventana
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
