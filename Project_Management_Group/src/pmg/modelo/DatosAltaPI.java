/**
 * 
 */
package pmg.modelo;

/**
 * Clase que guarda los datos del alta de un proyecto integrador
 * 
 * @author juanm
 *
 */
public class DatosAltaPI {
	private String año;
	private String curso;
	private String nota;
	private String cod_proyecto;
	private String nombre;
	private String url;
	private String nc_area;

	/**
	 * Constructor con parámetros de DatosAltaPI
	 * 
	 * @param año          año
	 * @param curso        curso (1 ó 2)
	 * @param nota         nota (del 1 al 10)
	 * @param cod_proyecto codigo proyecto integrador
	 * @param nombre       nombre del proyecto
	 * @param url          url de github del proyecto
	 * @param nc_area      nombre corto del área
	 */
	public DatosAltaPI(String año, String curso, String nota, String cod_proyecto, String nombre, String url,
			String nc_area) {
		super();
		this.año = año;
		this.curso = curso;
		this.nota = nota;
		this.cod_proyecto = cod_proyecto;
		this.nombre = nombre;
		this.url = url;
		this.nc_area = nc_area;
	}

	// Getters
	public String getAño() {
		return año;
	}

	public String getCurso() {
		return curso;
	}

	public String getNota() {
		return nota;
	}

	public String getCod_proyecto() {
		return cod_proyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUrl() {
		return url;
	}

	public String getNc_area() {
		return nc_area;
	}
	
	public String toString() {
		return año+"\n"+curso+"\n"+nota+"\n"+cod_proyecto+"\n"+nombre+"\n"+url+"\n"+nc_area;
	}
}
