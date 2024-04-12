package ar.edu.unlam.pb1;

public class PH {
	private static Integer contador = 1;
	private Integer nroUnidad;
	private Integer piso;
	private Integer cantidadDeAmbientes;
	private Double precio;
	private String ciudad;
	private String codigo;
	private Boolean estaDisponible;
    private TipoDeOperacion tipo;
    
	public PH(Integer nroUnidad, Integer piso, Integer cantidadDeAmbientes, Double precio, String ubicacion,
			 Boolean estaDisponible, TipoDeOperacion tipo) {
		this.nroUnidad = nroUnidad;
		this.piso = piso;
		this.cantidadDeAmbientes = cantidadDeAmbientes;
		this.precio = precio;
		this.ciudad = ubicacion;
		this.codigo = "PH"+contador++;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getUbicacion() {
		return ciudad;
	}

	public void setUbicacion(String ubicacion) {
		this.ciudad = ubicacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoDeOperacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeOperacion tipo) {
		this.tipo = tipo;
	}
	
    
	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public boolean estaDisponibleParaVenta() {
    	if(estaDisponible && tipo == TipoDeOperacion.VENTA) {
    		return true;
    	}
    	return false;
    }
    public boolean estaDisponibleParaAlquiler() {
    	if(estaDisponible && tipo == TipoDeOperacion.ALQUILER) {
    		return true;
    	}
    	return false;
    }

	@Override
	public String toString() {
		return "PH [nroUnidad=" + nroUnidad + ", ubicacion=" + ciudad + ", codigo=" + codigo + ", ciudad=" + ciudad + "]";
	}
    

}
