package ar.edu.unlam.pb1;

public class Terreno {
   private static Integer contador = 1;
   private Double ancho;
   private Double largo;
   private Double superficie;
   private String ubicacion;
   private String codigo;
   private Double precio;
   private Boolean estaDisponible;
   private TipoDeOperacion tipo;
   
public Terreno(Double ancho, Double largo, Double superficie, String ubicacion, Double precio,
		Boolean estaDisponible, TipoDeOperacion tipo) {
	this.ancho = ancho;
	this.largo = largo;
	this.superficie = superficie;
	this.ubicacion = ubicacion;
	this.codigo = "TERR"+contador++;
	this.precio = precio;
	this.estaDisponible = estaDisponible;
	this.tipo = tipo;
}

public Double getAncho() {
	return ancho;
}

public void setAncho(Double ancho) {
	this.ancho = ancho;
}

public Double getLargo() {
	return largo;
}

public void setLargo(Double largo) {
	this.largo = largo;
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
	return "Terreno [ubicacion=" + ubicacion + ", codigo=" + codigo + "]";
}
   
}
