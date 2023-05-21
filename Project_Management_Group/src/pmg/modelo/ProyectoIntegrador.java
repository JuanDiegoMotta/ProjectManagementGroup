/**
 * 
 */
package pmg.modelo;

/**
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
