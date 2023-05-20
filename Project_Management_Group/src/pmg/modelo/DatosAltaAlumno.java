/**
 * 
 */
package pmg.modelo;

/**
 * @author jburg
 *
 */
public class DatosAltaAlumno {

	private String nombreCompleto;
	private String numExp;
	private String area;
	private String codAlumno;

	public DatosAltaAlumno(String nombreCompleto, String numExp, String area, String codAlumno) {
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
