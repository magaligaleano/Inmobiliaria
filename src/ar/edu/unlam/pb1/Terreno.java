package ar.edu.unlam.pb1;

public class Terreno extends Propiedad {
   private static Integer contador = 1;
   private Double ancho;
   private Double largo;
   private Double superficie;
   private String codigo;
   
public Terreno(Double ancho, Double largo, Double superficie, String ubicacion, Double precio,
		Boolean estaDisponible, TipoDeOperacion tipo, String nombrePropietario, String nombreInquilino) {
	super(null, 0, ubicacion, precio, estaDisponible, tipo, nombrePropietario, nombreInquilino);
	this.ancho = ancho;
	this.largo = largo;
	this.superficie = superficie;
	this.codigo = "TERR"+contador++;
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

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}



@Override
public String toString() {
	return "Terreno [ubicacion=" + super.getCiudad() + ", codigo=" + codigo + "]";
}
   
}
