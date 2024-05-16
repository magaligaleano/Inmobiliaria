package ar.edu.unlam.pb1;

public class Campo extends Propiedad{
	
	private static Integer contador = 1;
	private String nombre;
	private Double superficie;
	private String codigo;
	
    
	public Campo(String nombre, Double superficie, String ubicacion, Double precio,
			Boolean estaDisponible, TipoDeOperacion tipo, String nombrePropietario, String nombreInquilino) {
		super("", 0, ubicacion, precio, estaDisponible, tipo, nombrePropietario, nombreInquilino);
		this.nombre = nombre;
		this.superficie = superficie;
		this.codigo = "CAM"+contador++;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	

	@Override
	public String toString() {
		return "Campo [nombre=" + nombre + ", ubicacion=" + getCiudad() + ",precio= " + getPrecio() +", codigo=" + codigo + "]";
	}

    
}
