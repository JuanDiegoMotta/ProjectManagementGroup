package pmg.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import pmg.controlador.ListenerBotonAsociar;
import pmg.controlador.ListenerBotonAtras;
import pmg.controlador.ListenerConsultas;
import pmg.modelo.Alumno;
import pmg.modelo.DatosAsociaciones;

/**
 * Clase VentanaPI_Asociar
 * 
 * @author Pablo
 *
 */
public class VentanaPI_Asociar extends JFrame {

	static final int ANCHO = 600;
	static final int ALTO = 400;
	private JLabel lblArea;
	private JComboBox<String> areasPi;
	private JTable tblAsociaciones;
	private DefaultTableModel tableModel;
	private JButton btnAtras;
	private JLabel nombre;
	private JTextField txtnombre;
	private JButton asociar;
	private JLabel aviso;
	private ImageIcon fondo;
	private JLabel lblFondo;

	// Getters necesarios
	public JComboBox<String> getAreasPi() {
		return areasPi;
	}

	public JTable getTblAlumnos() {
		return tblAsociaciones;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JLabel getAviso() {
		return aviso;
	}

	/**
	 * Constructor con parámetros de VentanaAlumnos_Consulta
	 * 
	 * @param titulo Título de la ventana de la aplicación.
	 */
	public VentanaPI_Asociar(String titulo) {
		super(titulo);
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
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

		// Se agrega la etiqueta Área
		lblArea = new JLabel("Área: ");
		lblArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArea.setBounds(360, 26, 49, 30);
		getContentPane().add(lblArea);

		// Creamos el comboBox
		areasPi = new JComboBox<String>();
		areasPi.setBounds(424, 27, 115, 25);
		String[] areas = { "DAW", "ASIR", "DAM", "A3DV" };
		DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>(areas);
		areasPi.setModel(modeloComboBox);
		areasPi.setSelectedIndex(-1);
		getContentPane().add(areasPi);

		// Creamos el espacio donde vamos a colocar nuestra tabla
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setBounds(52, 69, 487, 205);
		getContentPane().add(scrpTabla);

		// Creamos la tabla y el modelo predeterminado
		tblAsociaciones = new JTable();
		scrpTabla.setViewportView(tblAsociaciones);

		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		tblAsociaciones.setModel(tableModel);

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setFocusable(false);
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setBounds(52, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Creamos label de nombre de proyecto
		nombre = new JLabel("Nombre del proyecto:");
		nombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		nombre.setBounds(52, 25, 160, 30);
		getContentPane().add(nombre);

		// Creamos el textfield del nombre del proyecto
		txtnombre = new JTextField();
		txtnombre.setBounds(224, 27, 115, 25);
		getContentPane().add(txtnombre);

		asociar = new JButton("ASOCIAR");
		asociar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		asociar.setFocusable(false);
		asociar.setBackground(Color.decode("#BCD0C7"));
		asociar.setBounds(419, 300, 120, 30);
		getContentPane().add(asociar);

		aviso = new JLabel();
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setFont(new Font("Segoe UI", Font.BOLD, 11));
		aviso.setBounds(182, 300, 227, 30);
		getContentPane().add(aviso);
		
		// Fondo de pantalla
		lblFondo = new JLabel();
		getContentPane().add(lblFondo);
		lblFondo.setBounds(0, 0, 600, 400);
		fondo = new ImageIcon("../img/fondo.png");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/fondo.png")));

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
	public void cargarTabla(ArrayList<DatosAsociaciones> datos) {

		// Verificar si ya se han agregado las columnas
		if (tableModel.getColumnCount() == 0) {
			// Especificamos el nombre de las columnas solo si no existen previamente
			tableModel.addColumn("Alumnos");
			tblAsociaciones.getColumn("Alumnos").setPreferredWidth(125);
			tblAsociaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			//Añadimos columna proyectos
			tableModel.addColumn("Proyectos");
			tblAsociaciones.getColumn("Proyectos").setPreferredWidth(125);

			
		}

		// Limpiar los datos existentes en la tabla
		tableModel.setRowCount(0);

		for (DatosAsociaciones registro : datos) {
			Object[] fila = new Object[2]; // Cremos uno objeto con el número de columnas que queremos
			fila[0] = registro.getNombreAl();
			fila[1] = registro.getNombrePI();
			tableModel.addRow(fila);
		}
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerConsultas lc, ListenerBotonAsociar ListenerBAsociar) {
		btnAtras.addActionListener(ba);
		areasPi.addItemListener(lc);
		asociar.addActionListener(ListenerBAsociar);
	}

	public JTextField getTxtnombre() {
		return txtnombre;
	}

	@Override
	public String toString() {
		return "" + txtnombre + "";
	}

	/**
	 * Actualiza el texto del componente de aviso y el componente lblCod en función
	 * del resultado.
	 *
	 * @param caso indica si la operación fue exitosa (true) o no (false)
	 */
	public void mostrarAviso(boolean caso) {
		if (caso) {
			aviso.setText("Alumno asociado correctamente");
		} else {
			aviso.setText("Error al asociar el alumno");
		}
	}

}
