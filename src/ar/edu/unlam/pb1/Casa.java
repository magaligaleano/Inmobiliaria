package ar.edu.unlam.pb1;

public class Casa {
	
	private static Integer contador = 1;
	private String calle;
    private Integer numero;
    private String ciudad;
    private Double precio;
    private Boolean estaDisponible;
    private String codigo;
    private TipoDeOperacion tipo;
    
	public Casa(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo) {
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.codigo = "CASA"+contador++;
		this.tipo = tipo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
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
		return "Casa [calle=" + calle + ", numero=" + numero + ", codigo=" + codigo + ", ciudad=" + ciudad + ",precio=" + precio + "]";
	}
    
}
