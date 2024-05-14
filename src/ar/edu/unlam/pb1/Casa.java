package ar.edu.unlam.pb1;

public class Casa extends Propiedad {
	
	private static Integer contador = 1;
    private String codigo;
    private TipoDeOperacion tipo;
    
	public Casa(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo) {
		super(ciudad, numero, ciudad, precio, estaDisponible, tipo);
		
		this.codigo = "CASA"+contador++;
		
	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoDeOperacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeOperacion tipo) {
		this.tipo = tipo;
	}
    
    

//	@Override
	//public String toString() {
//		return "Casa [calle=" + calle + ", numero=" + numero + ", codigo=" + codigo + ", ciudad=" + ciudad + ",precio=" + precio + "]";
//	}
   
}
