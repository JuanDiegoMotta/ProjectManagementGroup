/**
 * 
 */
package pmg.modelo;

/**
 * Clase que representa un Alumno
 * @author juanm
 *
 */
public class Alumno {
	private String num_expediente;
	private String nombre_ape;
	private String cod_alumno;
	private String area;
	
	//Getters necesarios
	public String getNum_expediente() {
		return num_expediente;
	}

	public String getNombre_ape() {
		return nombre_ape;
	}

	public String getCod_alumno() {
		return cod_alumno;
	}

	public String getArea() {
		return area;
	}

	/**
	 * Constructor de la clase Alumno
	 * @param num_expediente
	 * @param nombre_ape
	 * @param cod_alumno
	 * @param area
	 */
	public Alumno(String num_expediente, String nombre_ape, String cod_alumno, String area) {
		super();
		this.num_expediente = num_expediente;
		this.nombre_ape = nombre_ape;
		this.cod_alumno = cod_alumno;
		this.area = area;
	}
	
}
