package ar.edu.unlam.pb1;

public class Alquiler implements Operacion, Comparable<Alquiler>{
   Propiedad propiedad;
   String nombreInquilino;
   
public Alquiler(Propiedad propiedad, String nombreInquilino) {
	
	this.propiedad = propiedad;
	this.nombreInquilino = nombreInquilino;
}



public Propiedad getPropiedad() {
	return propiedad;
}



public String getNombreInquilino() {
	return nombreInquilino;
}



@Override
public void ejecutar() {
	if(propiedad.estaDisponibleParaAlquiler()) {
		propiedad.setNombreInquilino(nombreInquilino);
	}
	 
	
}



@Override
public String toString() {
	return "Alquiler [propiedad=" + propiedad + ", nombreInquilino=" + nombreInquilino + "]";
}



@Override
public int compareTo(Alquiler o) {
	return this.propiedad.getCodigo().compareTo(o.propiedad.getCodigo());
}
   
   
}
