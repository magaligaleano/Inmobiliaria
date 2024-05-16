package ar.edu.unlam.pb1;

public class PH extends Propiedad{
	private static Integer contador = 1;
	private Integer nroUnidad;
	private Integer piso;
	private Integer cantidadDeAmbientes;
	private String codigo;
    
	public PH(Integer nroUnidad, Integer piso, Integer cantidadDeAmbientes, Double precio, String ciudad,
			 Boolean estaDisponible, TipoDeOperacion tipo, String nombrePropietario, String nombreInquilino) {
		super(null, null, ciudad, precio, estaDisponible, tipo, nombrePropietario, nombreInquilino);
		this.nroUnidad = nroUnidad;
		this.piso = piso;
		this.cantidadDeAmbientes = cantidadDeAmbientes;
		this.codigo = "PH"+contador++;
		
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


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	

	@Override
	public String toString() {
		return "PH [nroUnidad=" + nroUnidad  + ", codigo=" + codigo + ", ciudad=" +super.getCiudad() + "]";
	}
    

}
