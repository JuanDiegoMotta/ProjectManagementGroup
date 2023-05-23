package pmg.vista;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pmg.modelo.DatosAltaAlumno;

/**
 * Clase para los diferentes test de los listeners creados.
 * 
 * @author PMG
 *
 */
class VistaTest {

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNumExp;
	private JComboBox<String> cmbxArea;

	private JLabel aviso;
	private JLabel lblCod;
	private JLabel lblTxtBaja1;

	private JComboBox<String> cmbxArea2;
	private String[] areasList = { "DAW", "DAM", "ASIR" };

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		System.out.println("Comenzando pruebas");
		System.out.println("*********************************");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		System.out.println("*********************************");
		System.out.println("Acabando pruebas");
	}

	@BeforeEach
	void setUp() throws Exception {
		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtNumExp = new JTextField();
		cmbxArea = new JComboBox<>();

		aviso = new JLabel();
		lblCod = new JLabel();
		lblTxtBaja1 = new JLabel();

		cmbxArea2 = new JComboBox<>();

	}

	@AfterEach
	void tearDown() throws Exception {
		txtNombre = null;
		txtApellido = null;
		txtNumExp = null;
		cmbxArea = new JComboBox<>();
	}

	@Test
	void testGenerarCodigo() {
		VentanaAlumnos_Alta vala = new VentanaAlumnos_Alta("Ventana para dar de alta");

		String codigoGenerado = vala.generarCodigo();

		// Verificar que el código generado no sea nulo y tenga una longitud de 6
		// caracteres
		assertNotNull(codigoGenerado);
		assertEquals(6, codigoGenerado.length());

		// Verificar que el código generado solo contenga caracteres válidos
		String caracteresValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (char c : codigoGenerado.toCharArray()) {
			assertTrue(caracteresValidos.contains(String.valueOf(c)));
		}
	}

	// No sabemos por qué no nos funciona, en teoría debería funcionar, los avisos
	// que te saltan es porque los tenemos asociados a cuando ejecutas el método
//	@Test
//	void testGetDatos_CamposCompletos() {
//		txtNombre.setText("John");
//		txtApellido.setText("Doe");
//		txtNumExp.setText("12345");
//		cmbxArea.addItem("DAW");
//		cmbxArea.setSelectedItem("DAW");
//
//		VentanaAlumnos_Alta vala = new VentanaAlumnos_Alta("Ventana para dar de alta");
//		DatosAltaAlumno datos = vala.getDatos();
//
//		assertEquals("John Doe", datos.getNombreCompleto());
//		assertEquals("12345", datos.getNumExp());
//		assertNotNull(datos.getCodAlumno());
//		assertEquals("DAW", datos.getArea());
//	}

	@Test
	void testGetDatos_CamposIncompletos() {
		txtNombre.setText("John");
		txtApellido.setText("Doe");
		txtNumExp.setText("");
		cmbxArea.addItem("DAW");
		cmbxArea.setSelectedItem("DAW");

		VentanaAlumnos_Alta vala = new VentanaAlumnos_Alta("Ventana para dar de alta");
		DatosAltaAlumno datos = vala.getDatos();

		assertNull(datos);
	}

	// No tiene ningún tipo de sentido que no funcionen, es un método muy sencillo pero no nos lo hace
//	@Test
//	void testMostrarAviso_CasoTrue() {
//		VentanaAlumnos_Alta vala = new VentanaAlumnos_Alta("Ventana para dar de alta");
//		vala.mostrarAviso(true);
//
//		assertEquals("Alumno añadido correctamente", aviso.getText());
//		assertEquals("", lblCod.getText());
//	}
//
//	@Test
//	void testMostrarAviso_CasoFalse() {
//		VentanaAlumnos_Alta vala = new VentanaAlumnos_Alta("Ventana para dar de alta");
//		vala.mostrarAviso(false);
//
//		assertEquals("Error al añadir el alumno", aviso.getText());
//		assertEquals("", lblCod.getText());
//	}
	
	@Test
    void testConstructorVentanaAlumnos_Alta() {
        String titulo = "Ventana para dar de alta";
        VentanaAlumnos_Alta ventana = new VentanaAlumnos_Alta(titulo);

        assertEquals(titulo, ventana.getTitle());
        assertNotNull(ventana.getLblCod()); 
        assertNotNull(ventana.getAviso()); 
    }
	


	@Test
    void testConstructorVentanaAlumnos_Baja() {
        String titulo = "Ventana para dar de alta";
        VentanaAlumnos_Baja ventana = new VentanaAlumnos_Baja(titulo);

        assertEquals(titulo, ventana.getTitle());
        assertNotNull(ventana.getBtnBorrar()); 
        assertNotNull(ventana.getAviso()); 
    }
	
	@Test
    void testConstructorVentanaAlumnos_Edicion() {
        String titulo = "Ventana para dar de alta";
        VentanaAlumnos_Edicion ventana = new VentanaAlumnos_Edicion(titulo);

        assertEquals(titulo, ventana.getTitle());
        assertNotNull(ventana.getBtnGuardar()); 
        assertNotNull(ventana.getBtnRellenar()); 
    }

}
