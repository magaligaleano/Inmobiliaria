package ar.edu.unlam.pb1;

public class Propiedad {
	private String calle;
    private Integer numero;
    private String ciudad;
	private Double precio;
    private Boolean estaDisponible;
    private TipoDeOperacion tipo;
    private String nombrePropietario;
    private String nombreInquilino;
    private String codigo;
    
    
    public Propiedad(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, String nombrePropietario, String codigo) {
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
		this.nombrePropietario = nombrePropietario;
		this.codigo = codigo;
		
	}
//    public abstract String getCodigo();
    
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

	public TipoDeOperacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeOperacion tipo) {
		this.tipo = tipo;
	}
    
	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public String getNombreInquilino() {
		return nombreInquilino;
	}
	


	public void setNombreInquilino(String nombreInquilino) {
		this.nombreInquilino = nombreInquilino;
	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean estaDisponibleParaVenta() {
    	if(estaDisponible && tipo == TipoDeOperacion.VENTA) {
    		return true;
    	}
    	return false;
    }
    public Boolean estaDisponibleParaAlquiler() {
    	if(estaDisponible && tipo == TipoDeOperacion.ALQUILER) {
    		return true;
    	}
    	return false;
    }
    public Boolean estaDisponibleParaPermuta() {
    	if(estaDisponible && tipo == TipoDeOperacion.PERMUTA) {
    		return true;
    	}
    	return false;
    }
    
	@Override
	public String toString() {
		return "Propiedad [calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", precio=" + precio + "]";
	}
	
	

	
    
}
