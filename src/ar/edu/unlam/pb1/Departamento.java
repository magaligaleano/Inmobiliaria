package ar.edu.unlam.pb1;

public class Departamento {

	private String calle;
	private Integer piso;
	private Integer nroDepto;
	private String ciudad;
	private String codigo;
	private Double precio;
    private Boolean estaDisponible;
	private static Integer contador = 1;
	private TipoDeOperacion tipo;
	public Departamento(String calle, Integer piso, Integer nroDepto, String ciudad, Boolean estaDisponible,
			Double precio, TipoDeOperacion tipo) {
		this.calle = calle;
		this.piso = piso;
		this.nroDepto = nroDepto;
		this.ciudad = ciudad;
		this.codigo = "DEPTO"+contador++;
		this.estaDisponible = estaDisponible;
		this.precio = precio;
		this.tipo = tipo;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public Integer getNroDepto() {
		return nroDepto;
	}
	public void setNroDepto(Integer nroDepto) {
		this.nroDepto = nroDepto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
		return "Departamento [calle=" + calle + ", piso=" + piso + ", nroDepto=" + nroDepto + ", codigo=" + codigo
				+ ", ciudad=" + ciudad + "]";
	}
	
	
}
