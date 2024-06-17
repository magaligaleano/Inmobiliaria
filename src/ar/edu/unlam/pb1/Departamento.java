package ar.edu.unlam.pb1;

public class Departamento extends Propiedad {

	private Integer piso;
	private static Integer contador = 1;
	
	public Departamento(String calle, Integer piso, Integer nroDepto, String ciudad, Boolean estaDisponible,
			Double precio, TipoDeOperacion tipo, String nombrePropietario) {
		super(calle, nroDepto, ciudad, precio, estaDisponible, tipo, nombrePropietario, "DEPTO"+contador++);
		this.piso = piso;
	}
	
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	@Override
	public String toString() {
		return "Departamento [Codigo =" +getCodigo() + ", Piso=" + piso + ", Calle=" + getCalle() + ", Ciudad=" + getCiudad()
				+ ", Precio=" + getPrecio() + ", Tipo=" + getTipo() + ", NombrePropietario="
				+ getNombrePropietario() + "]";
	}
	
	
	
	

	
	
}
