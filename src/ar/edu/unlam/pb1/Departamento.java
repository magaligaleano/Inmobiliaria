package ar.edu.unlam.pb1;

public class Departamento extends Propiedad {

	
	private Integer piso;
	private String codigo;
	
	private static Integer contador = 1;
	
	public Departamento(String calle, Integer piso, Integer nroDepto, String ciudad, Boolean estaDisponible,
			Double precio, TipoDeOperacion tipo, String nombrePropietario, String nombreInquilino) {
		super(ciudad, nroDepto, ciudad, precio, estaDisponible, tipo, nombrePropietario, nombreInquilino);
		this.piso = piso;
		this.codigo = "DEPTO"+contador++;
	}
	
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	@Override
	public String toString() {
		return "Departamento [calle=" + getCalle() + ", piso=" + piso + ", nroDepto=" + getNumero() + ", codigo=" + codigo
				+ ", ciudad=" + getCiudad() + "]";
	}
	
	
}
