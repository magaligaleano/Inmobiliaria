package ar.edu.unlam.pb1;

public class Alquiler implements Operacion{
   Propiedad propiedad;
   String nombreInquilino;
   
public Alquiler(Propiedad propiedad, String nombreInquilino) {
	
	this.propiedad = propiedad;
	this.nombreInquilino = nombreInquilino;
}



@Override
public void ejecutar() {
	 propiedad.setNombreInquilino(nombreInquilino);
	
}



@Override
public String toString() {
	return "Alquiler [propiedad=" + propiedad + ", nombreInquilino=" + nombreInquilino + "]";
}
   
   
}
