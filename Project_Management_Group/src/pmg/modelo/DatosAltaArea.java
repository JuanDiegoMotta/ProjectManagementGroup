/**
 * 
 */
package pmg.modelo;

/**
 * Clase encargada de almacenar los datos a la hora de hacer el alta de un área
 * @author juanm
 *
 */
public class DatosAltaArea {
	private String nombre_corto;
	private String cod_area;
	private String descripcion;
	
	/**
	 * Constructor de DatosAltaArea con parámetros
	 * @param nombre_corto nombre corto del área
	 * @param cod_area código del área
	 * @param descripcion despcripción del área
	 */
	public DatosAltaArea(String nombre_corto, String cod_area, String descripcion) {
		super();
		this.nombre_corto = nombre_corto;
		this.cod_area = cod_area;
		this.descripcion = descripcion;
	}
	
	//Getters
	public String getNombre_corto() {
		return nombre_corto;
	}

	public String getCod_area() {
		return cod_area;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}
