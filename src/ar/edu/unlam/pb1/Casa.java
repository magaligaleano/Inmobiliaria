package ar.edu.unlam.pb1;

public class Casa extends Propiedad {
	
	private static Integer contador = 1;
    private String codigo;
    
	public Casa(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, String nombrePropietario, String nombreInquilino) {
		super(ciudad, numero, ciudad, precio, estaDisponible, tipo, nombrePropietario, nombreInquilino);
		
		this.codigo = "CASA"+contador++;
		
	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Casa [codigo=" + codigo + ",Calle=" + getCalle() + ",Numero=" + getNumero()
				+ ",Ciudad=" + getCiudad() + ",Precio=" + getPrecio() + ",Tipo=" + getTipo()
				+ ",Propietario()=" + getNombrePropietario() + "]";
	}

	
    
    

   
}
