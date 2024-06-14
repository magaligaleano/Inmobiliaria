package ar.edu.unlam.pb1;

public class Terreno extends Propiedad {
   private static Integer contador = 1;
   private Double ancho;
   private Double largo;
   private Double superficie;

   
public Terreno(Double ancho, Double largo, Double superficie, String ubicacion, Double precio,
		Boolean estaDisponible, TipoDeOperacion tipo, String nombrePropietario) {
	super(null, 0, ubicacion, precio, estaDisponible, tipo, nombrePropietario, "TERR"+contador++);
	this.ancho = ancho;
	this.largo = largo;
	this.superficie = superficie;
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


@Override
public String toString() {
	return "Terreno [ancho=" + ancho + ", largo=" + largo + ", codigo=" + getCodigo() + ", Ciudad=" + getCiudad()
			+ ", Tipo=" + getTipo() + "]";
}



   
}
