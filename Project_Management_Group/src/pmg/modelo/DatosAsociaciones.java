/**
 * 
 */
package pmg.modelo;

/**
 * Clase que recoge los datos de los registros de la tabla PI_Alumno en la base
 * de datos
 * 
 * @author juanm
 *
 */
public class DatosAsociaciones {
	private String nombreAl;
	private String nombrePI;
	
	/**
	 * Constructor de DatosAsociaciones con parámetros
	 * @param nombreAl nombre del alumno (String)
	 * @param nombrePI nombre del proyecto (String)
	 */
	public DatosAsociaciones(String nombreAl, String nombrePI) {
		super();
		this.nombreAl = nombreAl;
		this.nombrePI = nombrePI;
	}
	
	//Getters necesarios
	public String getNombreAl() {
		return nombreAl;
	}

	public String getNombrePI() {
		return nombrePI;
	}
	
	
}
