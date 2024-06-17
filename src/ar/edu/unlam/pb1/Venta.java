package ar.edu.unlam.pb1;

public class Venta implements Operacion, Comparable<Venta>{
	Propiedad propiedad;
	String nuevoPropietario;
	
	public Venta(Propiedad propiedad, String nuevoPropietario) {
		
		this.propiedad = propiedad;
		this.nuevoPropietario = nuevoPropietario;
	}


	public Propiedad getPropiedad() {
		return propiedad;
	}

	public String getNuevoPropietario() {
		return nuevoPropietario;
	}


	@Override
    public void ejecutar() {
        propiedad.setNombrePropietario(nuevoPropietario);
        propiedad.setEstaDisponible(false);
    }


	@Override
	public String toString() {
		return "Venta [propiedad=" + propiedad + ", nuevoPropietario=" + nuevoPropietario + "]";
	}


	@Override
	public int compareTo(Venta o) {
		return this.propiedad.getCodigo().compareTo(o.propiedad.getCodigo());
	}

	
	
	

}
