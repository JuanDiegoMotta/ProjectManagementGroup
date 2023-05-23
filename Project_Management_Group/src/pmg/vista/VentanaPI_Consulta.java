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
 * Clase de la ventana gráfica Proyecto Integrador que consulta los proyectos
 * según las áreas.
 * 
 * @author jburg
 */
public class VentanaPI_Consulta extends JFrame {

	static final int ANCHO = 600;
	static final int ALTO = 400;
	private JLabel lblArea;
	private JComboBox<String> areasPi;
	private JTable tblPi;
	private DefaultTableModel tableModel;
	private JButton btnAtras;
	private ImageIcon fondo;
	private JLabel lblFondo;
	private ArrayList<String> areasList;
	
	// Getters necesarios
	public JComboBox<String> getAreasPi() {
		return areasPi;
	}
	public void setAreasList(ArrayList<String> areas) {
		areasList = areas;
	}

	/**
	 * Constructor con parámetros de VentanaPI_Consulta
	 * 
	 * @param titulo Título de la ventana de la aplicación.
	 */
	public VentanaPI_Consulta(String titulo) {
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
		lblArea.setBounds(188, 34, 70, 20);
		getContentPane().add(lblArea);

		// Creamos el comboBox
		areasPi = new JComboBox<String>();
		areasPi.setBounds(268, 34, 115, 25);
		areasPi.setSelectedIndex(-1);
		getContentPane().add(areasPi);

		// Creamos el espacio donde vamos a colocar nuestra tabla
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setBounds(30, 75, 528, 199);
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

		// Creamos botón atrás y lo agregamos a la ventana
		btnAtras = new JButton("ATRÁS");
		btnAtras.setBackground(Color.decode("#BCD0C7"));
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(42, 300, 120, 30);
		getContentPane().add(btnAtras);
		
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
	public void cargarTabla(ArrayList<ProyectoIntegrador> proyectos) {

		// Especificamos el nombre de las columnas
		if (tableModel.getColumnCount() == 0) {
			tableModel.addColumn("Nombre");
			tableModel.addColumn("Curso");
			tableModel.addColumn("Año");
			tableModel.addColumn("Nota");
			tableModel.addColumn("Cod_proyecto");
			tableModel.addColumn("nc_area");
			tableModel.addColumn("Url");
			// Especificamos el tamaño de las columnas
			tblPi.getColumn("Nombre").setPreferredWidth(85);
			tblPi.getColumn("Curso").setPreferredWidth(55);
			tblPi.getColumn("Año").setPreferredWidth(45);
			tblPi.getColumn("Nota").setPreferredWidth(45);
			tblPi.getColumn("Cod_proyecto").setPreferredWidth(90);
			tblPi.getColumn("nc_area").setPreferredWidth(70);
			tblPi.getColumn("Url").setPreferredWidth(190);
		}

		// Limpiar los datos existentes en la tabla
		tableModel.setRowCount(0);

		for (ProyectoIntegrador pi : proyectos) {
			Object[] fila = new Object[7]; // Creamos un objeto con el número de columnas
			fila[0] = pi.getNombre();
			fila[1] = pi.getCurso();
			fila[2] = pi.getAño();
			fila[3] = pi.getNota();
			fila[4] = pi.getCod_proyecto();
			fila[5] = pi.getNc_area();
			fila[6] = pi.getUrl();
			tableModel.addRow(fila);
		}
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 * 
	 * @param ba Clase ListenerBotonAtras
	 * @param lc Clase ListenerConsultas
	 */
	public void setControlador(ListenerBotonAtras ba, ListenerConsultas lc) {
		btnAtras.addActionListener(ba);
		areasPi.addItemListener(lc);
	}
	
	/**
	 * Método que rellena el ComboBox de areas con las areas en areasList
	 */
	public void rellenarComboBox() {
		if (areasPi.getItemCount()>0) {
			areasPi.removeAllItems();
		}
		for(String area: areasList) {			
			areasPi.addItem(area);
		}
	}

}
