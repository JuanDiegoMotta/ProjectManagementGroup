package pmg.vista;

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

public class VentanaPI_Asociar extends JFrame {

	static final int ANCHO = 600;
	static final int ALTO = 400;
	private JLabel lblArea;
	private JComboBox<String> areasPi;
	private JTable tblAlumnos;
	private DefaultTableModel tableModel;
	private JButton btnAtras;
	private JLabel nombre;
	private JTextField txtnombre;
	private JButton asociar;
	private JLabel aviso;

	public JComboBox<String> getAreasPi() {
		return areasPi;
	}

	public JTable getTblAlumnos() {
		return tblAlumnos;
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
		areasPi.setBounds(424, 27, 115, 30);
		String[] areas = { "DAW", "ASIR", "DAM", "A3DV" };
		DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>(areas);
		areasPi.setModel(modeloComboBox);
		getContentPane().add(areasPi);

		// Creamos el espacio donde vamos a colocar nuestra tabla
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setBounds(52, 69, 487, 205);
		getContentPane().add(scrpTabla);

		// Creamos la tabla y el modelo predeterminado
		tblAlumnos = new JTable();
		scrpTabla.setViewportView(tblAlumnos);

		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		tblAlumnos.setModel(tableModel);

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setBounds(52, 300, 120, 30);
		getContentPane().add(btnAtras);

		// Creamos label de nombre de proyecto
		nombre = new JLabel("Nombre del proyecto:");
		nombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		nombre.setBounds(52, 25, 160, 30);
		getContentPane().add(nombre);

		// Creamos el textfield del nombre del proyecto
		txtnombre = new JTextField();
		txtnombre.setBounds(224, 27, 115, 30);
		getContentPane().add(txtnombre);

		asociar = new JButton("ASOCIAR");
		asociar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		asociar.setBounds(419, 300, 120, 30);
		getContentPane().add(asociar);
		
		aviso = new JLabel();
		aviso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		aviso.setBounds(10, 10, 120, 30);
		getContentPane().add(aviso);
		
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
	public void cargarTabla(ArrayList<Alumno> alumnos) {

		// Verificar si ya se han agregado las columnas
		if (tableModel.getColumnCount() == 0) {
			// Especificamos el nombre de las columnas solo si no existen previamente
			tableModel.addColumn("Alumnos");
			tblAlumnos.getColumn("Alumnos").setPreferredWidth(125);
			tblAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}

		// Limpiar los datos existentes en la tabla
		tableModel.setRowCount(0);

		for (Alumno al : alumnos) {
			Object[] fila = new Object[1];
			fila[0] = al.getNombre_ape();

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
