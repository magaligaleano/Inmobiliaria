package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private HashSet <Cliente> clientes;
	private ArrayList <Propiedad> propiedades;
	private TreeSet<Venta>ventas;
	private TreeSet <Alquiler> alquileres;
	private TreeSet <Permuta> permutas;

	
	
	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.clientes = new HashSet<>();
		this.propiedades = new ArrayList<>();
		this.ventas = new TreeSet<>();
		this.alquileres = new TreeSet<>();
		this.permutas = new TreeSet<>();
	}
	//metodos agregar
	public Boolean agregarPropiedad(Propiedad nueva) {
		return propiedades.add(nueva);
	}	
		
	public Boolean agregarCliente(Cliente nuevo) {
//		for(Cliente cliente: clientes) {
//			  if (cliente.getDni().equals(nuevo.getDni())) {
//	                return false;
//	            }
//	        }
		return clientes.add(nuevo);		
			
	}
	
	public Boolean agregarVenta(Venta nueva) throws UmbralMinimoNoAlcanzadoException {
		if(nueva.getPropiedad().getPrecio()<10000) {
			throw new UmbralMinimoNoAlcanzadoException("El importe de la propiedad está por debajo del umbral mínimo de 10000.");
		}
		else if(nueva.getPropiedad().getTipo().equals(TipoDeOperacion.VENTA)) {
		return ventas.add(nueva);
		}
		return false;
	}
	
	public Boolean agregarAlquiler(Alquiler nuevo) {
		if(nuevo.propiedad.getTipo().equals(TipoDeOperacion.ALQUILER)) {
			return alquileres.add(nuevo);
		}
		return false;
	}
	public Boolean agregarPermuta(Permuta nueva) {
		if(nueva.getPropiedadA().getTipo().equals(TipoDeOperacion.PERMUTA)) {
			return permutas.add(nueva);
		}
		return false;
	}

// getters y setters			
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	//mostrar propiedades
	
	public ArrayList<Propiedad> mostrarPropiedades(){
		if(propiedades.size()>0) {
			return propiedades;
		}
		return null;
	}
	
	public ArrayList<Propiedad> mostrarPropiedadesCasas() {
		ArrayList<Propiedad> propiedadesCasas = new ArrayList<>();
		for(Propiedad actual : propiedades) {
			if(actual instanceof Casa ) {
				propiedadesCasas.add(actual);
			}
		}
		return propiedadesCasas;
	}
	
	public ArrayList<Propiedad> mostrarPropiedadesDeptos() {
		ArrayList<Propiedad> propiedadesDeptos = new ArrayList<>();
		for(Propiedad actual : propiedades) {
			if(actual instanceof Departamento ) {
				propiedadesDeptos.add(actual);
			}
		}
		return propiedadesDeptos;
	}
	
	public ArrayList<Propiedad> mostrarPropiedadesPhs() {
		ArrayList<Propiedad> propiedadesPhs = new ArrayList<>();
		for(Propiedad actual : propiedades) {
			if(actual instanceof PH ) {
				propiedadesPhs.add(actual);
			}
		}
		return propiedadesPhs;
	}
	
	public ArrayList<Propiedad> mostrarPropiedadesTerrenos() {
		ArrayList<Propiedad> propiedadesTerrenos = new ArrayList<>();
		for(Propiedad actual : propiedades) {
			if(actual instanceof Terreno ) {
				propiedadesTerrenos.add(actual);
			}
		}
		return propiedadesTerrenos;
	}
	
	public ArrayList<Propiedad> mostrarPropiedadesCampos() {
		ArrayList<Propiedad> propiedadesCampos = new ArrayList<>();
		for(Propiedad actual : propiedades) {
			if(actual instanceof Campo ) {
				propiedadesCampos.add(actual);
			}
		}
		return propiedadesCampos;
	}

	public HashSet<Cliente> mostrarClientes(){
		return clientes;
	}
	//Buscar y modificar propiedades
	
	public Propiedad buscarCodigoPropiedad(String codigo) {
		Propiedad propiedadABuscar = null;
		for(Propiedad actual : propiedades) {
			if(actual.getCodigo().equals(codigo)) {
				return propiedadABuscar = actual;
			}
		}
		return propiedadABuscar;
	}
	
	public Boolean modificarPropiedad(String codigo, Propiedad actualizada) {
		for(Propiedad actual : propiedades) {
			if(actual.getCodigo().equals(codigo)) {
				actual = actualizada;
				return true;
			}
		}
		return false;
	}

	//ordenar propiedades por precio
	
	public ArrayList<Propiedad> ordenarPropiedadesPorPrecio(ArrayList<Propiedad> propiedades) {
		Collections.sort(propiedades, new OrdenadosPorPrecio());
		return propiedades;
		
	}

//	//ordenar propiedades por ubicacion
	public ArrayList<Propiedad> ordenarPropiedadesPorUbicacion() {
		Collections.sort(propiedades, new OrdenadasPorUbicacion());
		return propiedades;
		
		}
	
	
	//buscar por rango de precios
	
	public ArrayList<Propiedad> buscarPorRangoDePrecio(Double precioMinimo, Double precioMaximo) throws SinResultadosException {
		ArrayList <Propiedad> propiedadesEncontradas = new ArrayList<>();
			for(Propiedad actual : propiedades) {
				if(actual.getPrecio()>=precioMinimo && actual.getPrecio()<=precioMaximo) { 
					propiedadesEncontradas.add(actual);
				}
			}
			if (propiedadesEncontradas.isEmpty()) {
	            throw new SinResultadosException("No se encontraron propiedades en el rango de precio especificado.");
	        }
	   return propiedadesEncontradas;
		
	}

	//buscar por ubicacion
	
	public ArrayList<Propiedad> buscarPorUbicacion(String ubicacion){
		ArrayList<Propiedad> propiedadesEncontradas = null;
		Integer contador = 0;
		for(Propiedad actual : propiedades) {
			if(actual.getCiudad().equals(ubicacion)) {
				contador++;
			}
		}
		if(contador>0) {
			propiedadesEncontradas = new ArrayList<>();
			for(Propiedad actual : propiedades) {
				if(actual.getCiudad().equals(ubicacion)) {
					propiedadesEncontradas.add(actual);
				}
		}
	}
		return propiedadesEncontradas;
	}
	

	//promedio de precio de propiedades
	
	public Double calcularPromedioDePropiedades() {
		Double sumatoria = 0.0;
		Double promedio = 0.0;
		Integer contadorPropiedades = 0;
		
		for(Propiedad actual : propiedades) {
			if(actual!=null) {
				sumatoria+=actual.getPrecio();
				contadorPropiedades++;
			}
			
		}
		if(contadorPropiedades==0) {
			return 0.0;
		}
		promedio = sumatoria/ contadorPropiedades;
		return promedio;
	}
	
	public Double calcularPromedioPrecioDeLasCasas() {
		Double sumatoria = 0.0;
		Double promedio = 0.0;
		Integer cantidadDeCasas = 0;
		
		for(Propiedad actual : propiedades) {
			if(actual instanceof Casa) {
				sumatoria+=actual.getPrecio();
				cantidadDeCasas++;
			}
			
		}
		if(cantidadDeCasas==0) {
			return 0.0;
		}
		promedio = sumatoria/ cantidadDeCasas;
		return promedio;
		
	}
	public Double calcularPromedioPrecioDeLosDeptos() {
		Double sumatoria = 0.0;
		Double promedio = 0.0;
		Integer cantidadDeDeptos = 0;
		
		for(Propiedad actual : propiedades) {
				sumatoria+=actual.getPrecio();
				cantidadDeDeptos++;
			}
			
		if(cantidadDeDeptos==0) {
			return 0.0;
		}
		promedio = sumatoria/ cantidadDeDeptos;
		return promedio;
		
	}

	public Cliente buscarCliente(Integer dni) {
		Cliente clienteABuscar = null;
		for(Cliente cliente : clientes) {
			if(cliente.getDni().equals(dni)){
				clienteABuscar = cliente;
				return clienteABuscar;
			}
		}
		return null;
	}
	
	public ArrayList<Venta> mostrarVentas(){
		ArrayList<Venta> propiedadesVendidas = null;
		
		if(ventas.size()>0) {
			propiedadesVendidas = new ArrayList<>();
			for(Venta venta : ventas) {
				propiedadesVendidas.add(venta);
			}
		}
		return propiedadesVendidas;
	}
	
	public ArrayList<Alquiler> mostrarAlquileres(){
		ArrayList<Alquiler> propiedadesAlquiladas = null;
	
		if(alquileres.size()>0) {
			propiedadesAlquiladas = new ArrayList<>();
			for(Alquiler alquiler : alquileres) {
				propiedadesAlquiladas.add(alquiler);
			}
		}
		return propiedadesAlquiladas;
	}


    public TreeSet<Permuta> mostrarPermutas(){
    	TreeSet<Permuta> propiedadesPermutadas = null;
    	if(permutas.size()>0){
    		propiedadesPermutadas = new TreeSet<>();
    		for(Permuta permuta: permutas) {
    			propiedadesPermutadas.add(permuta);
    		}
    		}
    	return propiedadesPermutadas;
    	}
    
    public ArrayList<Propiedad> getPropiedades(String nombrePropietario) {
    	ArrayList<Propiedad> buscadas = null;
    	Integer contador = 0;
    	for(Propiedad propiedad : propiedades) {
    		if(propiedad.getNombrePropietario().equals(nombrePropietario)) {
    			contador++;
    		}
    	}
    	if(contador>0) {
    		buscadas = new ArrayList<>();
    		for(Propiedad propiedad : propiedades) {
        		if(propiedad.getNombrePropietario().equals(nombrePropietario)) {
        			buscadas.add(propiedad);
        		}
        	}
    	}
    	return buscadas;
    }
    }


