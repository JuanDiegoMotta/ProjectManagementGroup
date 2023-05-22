/**
 * 
 */
package pmg.vista;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import pmg.controlador.ListenerBoton;
import java.awt.Color;

/**
 * Clase de la ventana gráfica del log-in
 * 
 * @author juanm
 *
 */
public class VentanaLogIn extends JFrame {
	static private String USUARIO = "root";
	static private String CONTRASEÑA = "root";

	private JLabel lblUser;
	private JLabel lblPwd;
	private JTextField txtUser;
	private JPasswordField txtPwd;
	private JButton btnLogin;
	private JLabel lblNewLabel;
	private JLabel error;
	private JLabel errorCont;
	private int cont;
	private ImageIcon logo;
	private ImageIcon fondo;
	private JLabel lblFondo;

	/**
	 * Constructor con parametros de VentanaLogIn
	 * 
	 * @param titulo titulo de la ventana
	 */
	public VentanaLogIn() {
//		super(titulo);
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
		lblPwd.setBounds(155, 176, 97, 30);
		lblPwd.setFont(new Font("Segoe UI", Font.BOLD, 14));

		getContentPane().add(lblPwd);

		txtUser = new JTextField("");
		txtUser.setBackground(new Color(255, 255, 255));
		txtUser.setBounds(277, 135, 133, 30);
		getContentPane().add(txtUser);

		txtPwd = new JPasswordField();
		txtPwd.setBackground(new Color(255, 255, 255));
		txtPwd.setBounds(277, 176, 133, 30);
		getContentPane().add(txtPwd);

		btnLogin = new JButton("LOG-IN");
		btnLogin.setBackground(Color.decode("#BCD0C7"));
		btnLogin.setBounds(219, 250, 120, 30);
		btnLogin.setFocusable(false);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(btnLogin);

		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(180, 44, 205, 68);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(lblNewLabel);
		logo = new ImageIcon("../img/logoPMG.png");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoPMG.png")));

		error = new JLabel();
		error.setBounds(219, 295, 181, 20);
		error.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(error);

		errorCont = new JLabel();
		errorCont.setBounds(219, 322, 181, 20);
		errorCont.setFont(new Font("Segoe UI", Font.BOLD, 14));
		getContentPane().add(errorCont);

		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));

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

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBoton b) {
		btnLogin.addActionListener(b);
	}

	/**
	 * Método encargado de comprobar que el usuario y contraseña que pone el usuario
	 * sean correctos
	 * 
	 * @param vp Clase VentanaPrincipal
	 */
	public void concederAcceso(VentanaPrincipal vp) {
		String usua = txtUser.getText();
		String passwo = String.valueOf(txtPwd.getPassword());
		if (usua.equals(USUARIO)) {
			if (passwo.equals(CONTRASEÑA)) {
				dispose();
				vp.hacerVisible();
			} else {
				cont++;
				mostrarErrorLeft(cont);
				mostrarError("Contraseñá incorrecta");

			}
		} else {
			mostrarError("Usuario no valido");
		}

	}

	/**
	 * Método encargado de mostrar un error en la pantalla
	 * 
	 * @param errors String que se le pasa como parámetro
	 */
	public void mostrarError(String errors) {
		error.setText(errors);
	}

	/**
	 * Método encargado de mostros los intentos restantes que te quedan
	 * 
	 * @param contt Contador que se le pasa como parámetro
	 */
	public void mostrarErrorLeft(int contt) {
		if (contt >= 4) {
			dispose();
		} else {
			errorCont.setText("Intentos restantes: " + (4 - contt));
		}
	}
}
