package ar.edu.unlam.pb1;

public class PH extends Propiedad{
	private static Integer contador = 1;
	private Integer nroUnidad;
	private Integer piso;
	private Integer cantidadDeAmbientes;
	
    
	public PH(Integer nroUnidad, Integer piso, Integer cantidadDeAmbientes, Double precio, String ciudad,
			 Boolean estaDisponible, TipoDeOperacion tipo, String nombrePropietario) {
		super(null, null, ciudad, precio, estaDisponible, tipo, nombrePropietario, "PH"+contador++);
		this.nroUnidad = nroUnidad;
		this.piso = piso;
		this.cantidadDeAmbientes = cantidadDeAmbientes;
		
		
	}

	public Integer getNroUnidad() {
		return nroUnidad;
	}

	public void setNroUnidad(Integer nroUnidad) {
		this.nroUnidad = nroUnidad;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getCantidadDeAmbientes() {
		return cantidadDeAmbientes;
	}

	public void setCantidadDeAmbientes(Integer cantidadDeAmbientes) {
		this.cantidadDeAmbientes = cantidadDeAmbientes;
	}



	

	@Override
	public String toString() {
		return "PH [nroUnidad=" + nroUnidad  + ", codigo=" + getCodigo() + ", ciudad=" +getCiudad() + ", tipo=" +getTipo() + "]";
	}
    

}
