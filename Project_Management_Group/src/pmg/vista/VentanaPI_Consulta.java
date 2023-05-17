/**
 * 
 */
package pmg.vista;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import pmg.controlador.ListenerBotonAtras;

/**
 * @author jburg
 * 
 * Clase de la ventana gráfica Proyecto Integrador que consulta los proyectos según las áreas.
 *
 */
public class VentanaPI_Consulta extends JFrame {

	static final int ANCHO = 600;
	static final int ALTO = 400;
	private JLabel lblArea;
	private JComboBox<String> areasPi;
	private JTable tblPi;
	private DefaultTableModel tableModel;
	private JButton btnAtras;

	/**
	 * Constructor con parámetros de VentanaPI_Consulta
	 * @param titulo Título de la ventana de la aplicación.
	 */
	public VentanaPI_Consulta (String titulo) {
		super (titulo);
		inicializarComponentes();
	}
	
	/**
	 * Método que inicializa los componentes
	 */
	public void inicializarComponentes() {
		
		// Configuramos el layout a null.
		getContentPane().setLayout(null);
		
		// Se sale determina que hace la app al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Se declara el tamaño de la ventana con los valores estáticos
		setSize(ANCHO, ALTO);
		
		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		// Se obtienen las dimensiones en pixels de la ventana.       
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
		
		// Se agrega la etiqueta Área
		lblArea = new JLabel("Área: ");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArea.setBounds(179, 35, 70, 20);
		getContentPane().add(lblArea);
		
		// Creamos el comboBox
		areasPi = new JComboBox<String>();
		areasPi.setBounds(282, 34, 115, 29);
		String [] areas = {"DAW", "ASIR", "DAM", "A3DV"};
		DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>(areas);
		areasPi.setModel(modeloComboBox);
		getContentPane().add(areasPi);
		
		// Creamos el espacio donde vamos a colocar nuestra tabla
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setBounds(52, 75, 474, 199);
		getContentPane().add(scrpTabla);
		
		// Creamos la tabla y el modelo predeterminado
		tblPi = new JTable();
		scrpTabla.setViewportView(tblPi);
		
		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		tblPi.setModel(tableModel);
		
		cargarTabla();
		
		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setBounds(42, 300, 120, 30);
		getContentPane().add(btnAtras);
	}
	
	/**
	 * Método que hace visible la pantalla
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * Método que rellena la tabla
	 */
	private void cargarTabla() {
		
		// Especificamos el nombre de las columnas	
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Curso");
		tableModel.addColumn("Grupo");
		tableModel.addColumn("Año");
		tableModel.addColumn("Nota");
		tableModel.addColumn("Cod_proyecto");
		tableModel.addColumn("Cod_area");
		tableModel.addColumn("Url");
		
		tblPi.getColumn("Nombre").setPreferredWidth(75);
		tblPi.getColumn("Curso").setPreferredWidth(75);
		tblPi.getColumn("Grupo").setPreferredWidth(75);
		tblPi.getColumn("Año").setPreferredWidth(75);
		tblPi.getColumn("Nota").setPreferredWidth(75);
		tblPi.getColumn("Cod_proyecto").setPreferredWidth(75);
		tblPi.getColumn("Cod_area").setPreferredWidth(75);
		tblPi.getColumn("Url").setPreferredWidth(125);
	}
	
	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba) {
		btnAtras.addActionListener(ba);
	}

}
