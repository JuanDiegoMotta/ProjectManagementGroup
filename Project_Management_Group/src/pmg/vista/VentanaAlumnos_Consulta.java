/**
 * 
 */
package pmg.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import pmg.controlador.*;
import pmg.modelo.*;

/**
 * @author Pablo
 *
 */
public class VentanaAlumnos_Consulta extends JFrame {
	static final int ANCHO = 600;
	static final int ALTO = 400;
	private JLabel lblArea;
	private JComboBox<String> areasPi;
	private JTable tblAlumnos;
	private DefaultTableModel tableModel;
	private JButton btnAtras;

	// Getters necesarios
	public JComboBox<String> getAreasPi() {
		return areasPi;
	}

	/**
	 * Constructor con parámetros de VentanaAlumnos_Consulta
	 * 
	 * @param titulo Título de la ventana de la aplicación.
	 */
	public VentanaAlumnos_Consulta(String titulo) {
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
		lblArea.setBounds(179, 35, 70, 20);
		getContentPane().add(lblArea);

		// Creamos el comboBox
		areasPi = new JComboBox<String>();
		areasPi.setBounds(282, 34, 115, 29);
		String[] areas = { "DAW", "ASIR", "DAM", "A3DV" };
		DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>(areas);
		areasPi.setModel(modeloComboBox);
		getContentPane().add(areasPi);

		// Creamos el espacio donde vamos a colocar nuestra tabla
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setBounds(52, 75, 474, 199);
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
	}

	/**
	 * Método que hace visible la pantalla
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Método encargado de rellenar la tabla
	 * 
	 * @param alumnos
	 */
	public void cargarTabla(ArrayList<Alumno> alumnos) {

		// Verificar si ya se han agregado las columnas
		if (tableModel.getColumnCount() == 0) {
			// Especificamos el nombre de las columnas solo si no existen previamente
			tableModel.addColumn("Nombre y apellidos");
			tableModel.addColumn("Num_Expediente");
			tableModel.addColumn("Cod_Alumno");

			tblAlumnos.getColumn("Nombre y apellidos").setPreferredWidth(125);
			tblAlumnos.getColumn("Num_Expediente").setPreferredWidth(75);
			tblAlumnos.getColumn("Cod_Alumno").setPreferredWidth(75);
		}

		// Limpiar los datos existentes en la tabla
		tableModel.setRowCount(0);

		for (Alumno al : alumnos) { // Creamos un for que recorra el ArrayList y que en cada interación imprima el
									// nombre, el número de expediente y el código de alumno
			Object[] fila = new Object[3];
			fila[0] = al.getNombre_ape();
			fila[1] = al.getNum_expediente();
			fila[2] = al.getCod_alumno();
			tableModel.addRow(fila);
		}
	}

	/**
	 * Método que devuelve el área seleccionada por el usuario
	 * 
	 * @return área (String)
	 */
	public String getArea() {
		String area = (String) areasPi.getSelectedItem();
		return area;
	}

	/**
	 */
	/**
	 * Método encargado de agregar un controlador a la ventana
	 * 
	 * @param ba ListenerBotonAtras
	 * @param lc ListenerConsultas
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerConsultas lc) {
		btnAtras.addActionListener(ba);
		areasPi.addItemListener(lc);
	}

}
