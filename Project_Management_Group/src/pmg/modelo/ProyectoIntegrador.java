/**
 * 
 */
package pmg.modelo;

/**
 * Clase que representa un ProyectoIntegrador
 * @author juanm
 *
 */
public class ProyectoIntegrador {
	private String año;
	private String curso;
	private String nota;
	private String cod_proyecto;
	private String nombre;
	private String url;
	private String nc_area;
	
	//Getters
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

	/**
	 * Constructor con parámetros de un ProyectoIntegrador
	 * @param año año (String)
	 * @param curso curso (String)
	 * @param nota nota (String)
	 * @param cod_proyecto código del proyecto (String)
	 * @param nombre nombre del proyecto (String)
	 * @param url url de GitHub (String)
	 * @param nc_area nombre corto (String)
	 */
	public ProyectoIntegrador(String año, String curso, String nota, String cod_proyecto, String nombre, String url,
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

}
