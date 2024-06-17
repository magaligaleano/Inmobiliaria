package ar.edu.unlam.pb1;

public class Casa extends Propiedad {
	
	private static Integer contador = 1;
   
    
	public Casa(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, String nombrePropietario) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, nombrePropietario, "CASA" + contador++);
		
	}
	


	@Override
	public String toString() {
		return "Casa [codigo=" + getCodigo() + ",Calle=" + getCalle() + ",Numero=" + getNumero()
				+ ",Ciudad=" + getCiudad() + ",Precio=" + getPrecio() + ",Tipo=" + getTipo()
				+ ",Propietario=" + getNombrePropietario() + "]";
	}






//	@Override
//	public String getCodigo() {
//		return codigo;
//	}

	
    
    

   
}
