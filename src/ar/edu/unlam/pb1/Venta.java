package ar.edu.unlam.pb1;

public class Venta implements Operacion{
	Propiedad propiedad;
	String nuevoPropietario;
	
	public Venta(Propiedad propiedad, String nuevoPropietario) {
		
		this.propiedad = propiedad;
		this.nuevoPropietario = nuevoPropietario;
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

	
	
	

}
