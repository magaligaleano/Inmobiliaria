package ar.edu.unlam.pb1;

public class Campo {
	private static Integer contador = 1;
	private String nombre;
	private Double superficie;
	private String ubicacion;
	private String codigo;
	private Double precio;
	private Boolean estaDisponible;
    private TipoDeOperacion tipo;
    
	public Campo(String nombre, Double superficie, String ubicacion, Double precio,
			Boolean estaDisponible, TipoDeOperacion tipo) {
		this.nombre = nombre;
		this.superficie = superficie;
		this.ubicacion = ubicacion;
		this.codigo = "CAM"+contador++;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
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
		return "Campo [nombre=" + nombre + ", ubicacion=" + ubicacion + ", codigo=" + codigo + "]";
	}

    
}
