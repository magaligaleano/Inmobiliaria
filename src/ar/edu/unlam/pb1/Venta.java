package ar.edu.unlam.pb1;

public class Venta {
	Propiedad propiedad;
	Cliente cliente;
	
	public Venta(Propiedad propiedad, Cliente cliente) {
		
		this.propiedad = propiedad;
		this.cliente = cliente;
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

	@Override
	public String toString() {
		return "Venta [propiedad=" + propiedad + ", cliente=" + cliente + "]";
	}

	
	
	

}
