/**
 * 
 */
package pmg.modelo;

/**
 * @author jburg
 *
 * Clase encargada de almacenar los datos de los alumnos
 */
public class DatosAltaAlumno {

	private String nombreCompleto;
	private String numExp;
	private String area;
	private String codAlumno;

	
	/**
	 * Constructor de DatosAltaAlumno con parámetros
	 * @param nombreCompleto nombre completo del alumno (nombre y apellido)
	 * @param numExp número de expediente del alumno
	 * @param area área del alumno
	 * @param codAlumno código del alumno
	 */
	public DatosAltaAlumno(String nombreCompleto, String numExp, String codAlumno, String area) {
		this.nombreCompleto = nombreCompleto;
		this.numExp = numExp;
		this.area = area;
		this.codAlumno = codAlumno;
	}

	// Getters y Setters
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getNumExp() {
		return numExp;
	}

	public String getArea() {
		return area;
	}

	public String getCodAlumno() {
		return codAlumno;
	}
}
