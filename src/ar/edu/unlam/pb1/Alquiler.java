package ar.edu.unlam.pb1;

public class Alquiler {
   Propiedad propiedad;
   Cliente cliente;
   String nombreInquilino;
   
public Alquiler(Propiedad propiedad, Cliente cliente, String nombreInquilino) {
	
	this.propiedad = propiedad;
	this.cliente = cliente;
	this.nombreInquilino = nombreInquilino;
}

public Propiedad getPropiedad() {
	return propiedad;
}

public void setPropiedad(Propiedad propiedad) {
	this.propiedad = propiedad;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public String getNombreInquilino() {
	return nombreInquilino;
}

public void setNombreInquilino(String nombreInquilino) {
	this.nombreInquilino = nombreInquilino;
}

@Override
public String toString() {
	return "Alquiler [propiedad=" + propiedad + ", cliente=" + cliente + ", nombreInquilino=" + nombreInquilino
			+  "]";
}
   
   
}
