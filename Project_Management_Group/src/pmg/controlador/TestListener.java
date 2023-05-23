package pmg.controlador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pmg.modelo.DatosAltaAlumno;
import pmg.vista.VentanaAlumnos_Alta;


/**
 * Clase para los diferentes test de los listeners creados.
 * 
 * @author PMG
 *
 */
class TestListener {
    	
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
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAltaAlumnos_ExpedienteUnico() {

	}

}
