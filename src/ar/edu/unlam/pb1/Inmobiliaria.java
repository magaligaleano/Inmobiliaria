package ar.edu.unlam.pb1;

import java.util.ArrayList;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private ArrayList <Departamento> departamentos;
	private ArrayList <Cliente> clientes;
	private ArrayList <Casa> casas;
	private ArrayList <Terreno> terrenos;
	private ArrayList <Campo> campos;
	private ArrayList <PH> phs;
	private ArrayList <Venta>ventas;
	private ArrayList <Alquiler> alquileres;
	
	
	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.casas = new ArrayList<>();
		this.departamentos = new ArrayList<>();
		this.phs = new ArrayList<>();
		this.terrenos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.campos = new ArrayList<>();
		this.ventas = new ArrayList<>();
		this.alquileres = new ArrayList<>();
	}
	
	public Boolean agregarCasa(Casa nueva) { 
			if(verificacionDeDireccionCasa(nueva.getCalle(), nueva.getNumero(), nueva.getCiudad())) {
				return casas.add(nueva);
			}
			return false;
		}
		
	

	public Boolean agregarPH(PH nuevo) {
		   return phs.add(nuevo);
		
		}
		
	
	
		public Boolean agregarTerreno(Terreno nuevo) {	
			return terrenos.add(nuevo);
			
		
		}
			public Boolean agregarCampo(Campo nuevo) {
			return campos.add(nuevo);
					
			}
			
	public boolean agregarDepartamento(Departamento nuevo) {
		if(verificacionDeDireccionDepto(nuevo.getCalle(), nuevo.getNumero(), nuevo.getPiso(), nuevo.getCiudad())) {
			  return departamentos.add(nuevo);
			
			}
		return false;
		}
		
	public Boolean agregarCliente(Cliente nuevo) {
		for(Cliente cliente : clientes) {
			if(cliente.getDni().equals(nuevo.getDni())) {
				return false;
			}
		}
		return clientes.add(nuevo);
			
	}
	
	public Boolean agregarVenta(Venta nueva) {
		return ventas.add(nueva);
	}
	public Boolean agregarAlquiler(Alquiler nuevo) {
		return alquileres.add(nuevo);
	}
	public Boolean isVenta(Propiedad propiedad, Cliente cliente) {
		if(propiedad.estaDisponibleParaVenta()) {
			propiedad.setEstaDisponible(false);
			propiedad.setNombrePropietario(cliente.getNombre());
			return true;
		}
		
		 return false;
	}
	public Boolean isAlquiler(Propiedad propiedad, Cliente cliente) {
		if(propiedad.estaDisponibleParaAlquiler()) {
			propiedad.setEstaDisponible(false);
			propiedad.setNombreInquilino(cliente.getNombre());
			return true;
		}
		return false;
	}
			
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
	
	public String mostrarPropiedadesCasas() {
		String resultado = "";
		for(int i=0;i < casas.size(); i++) {
				resultado += casas.get(i).toString() + "\n";
			
		}
		return resultado;
	}
	
	public String mostrarPropiedadesDeptos() {
		String resultado = "";
		for(int i=0;i < departamentos.size(); i++) {
			if(departamentos.get(i) != null) {
				resultado += departamentos.get(i).toString() + "\n";
			}
		}
		return resultado;
	}
	
	public String mostrarPropiedadesPH() {
		String resultado = "";
		for(int i=0;i < phs.size(); i++) {
				resultado += phs.get(i).toString() + "\n";
			
		}
		return resultado;
	}
	public String mostrarPropiedadesTerrenos() {
		String resultado = "";
		for(int i=0;i < terrenos.size(); i++) {
				resultado += terrenos.get(i).toString() + "\n";
			
		}
		return resultado;
	}
	public String mostrarPropiedadesCampos() {
		String resultado = "";
		for(int i=0;i < campos.size(); i++) {
				resultado += campos.get(i).toString() + "\n";
			
		}
		return resultado;
	}
	
	//Buscar y modificar propiedades
	
	public Casa buscarCodigoCasa(String codigo) {
		Casa casaAbuscar = null
;		for(Casa casa : casas) {
			if(casa.getCodigo().equals(codigo)) {
				casaAbuscar = casa;
				return casaAbuscar;
			}
		}
		return null;
	}
	public Boolean modificarCasa(String codigo, Casa actualizada) {
		for(int i=0;i<casas.size();i++) {
			if(casas.get(i).getCodigo().equals(codigo)) {
			   casas.set(i, actualizada);
			   return true;
			}
		}
		return false;
	}
	public Departamento buscarCodigoDepto(String codigo) {
		Departamento buscado = null;
		for(Departamento depto: departamentos) {
			if(depto.getCodigo().equals(codigo)) {
				buscado = depto;
			}
		}
		return buscado;
	}
	public Boolean modificarDepto(String codigo, Departamento actualizado) {
		for(int i=0;i<departamentos.size();i++) {
			if(departamentos.get(i).getCodigo().equals(codigo)) {
				departamentos.set(i, actualizado);
				return true;
			}
		}
		return false;
	}
	public PH buscarCodigoPH(String codigo) {
		PH buscado = null;
		for(PH ph: phs) {
			if(ph.getCodigo().equals(codigo)) {
				buscado = ph;
			}
		}
		return buscado;
	}
	public Boolean modificarPH(String codigo, PH actualizado) {
		for(int i=0;i<phs.size();i++) {
			if(phs.get(i).equals(codigo)) {
			   phs.set(i, actualizado);
			   return true;
			}
		}
		return false;
	}
	
	
	public Campo buscarCodigoCampo(String codigo) {
		Campo buscado = null;
		for(Campo campo: campos) {
			if(campo.getCodigo().equals(codigo)) {
				buscado = campo;
			}
		}
		return buscado;
	}
	public Boolean modificarCampo(String codigo, Campo actualizado) {
		for(int i=0;i<campos.size();i++) {
			if(campos.get(i).getCodigo().equals(codigo)) {
				campos.set(i, actualizado);
				return true;
			}
		}
		return false;
	}
	
	public Terreno buscarCodigoTerreno(String codigo) {
		Terreno buscado = null;
		for(Terreno terreno : terrenos) {
			if(terreno.getCodigo().equals(codigo)) {
				buscado = terreno;
			}
		}
		return buscado;
	}
	public Boolean modificarTerreno(String codigo, Terreno actualizado) {
		for(int i=0;i<terrenos.size();i++) {
			if(terrenos.get(i).getCodigo().equals(codigo)) {
				 terrenos.set(i, actualizado);
				 return true;
			}
		}
		return false;
	}
	//ordenar propiedades por precio
	
	public void ordenarCasasPorPrecio() {
		for(int i= 0; i<casas.size();i++) {
			for(int j= 0; j<casas.size()-1;j++) {
				if(casas.get(j).getPrecio()>casas.get(j+1).getPrecio()) {
					Casa temp = casas.get(j);
					casas.set(j, casas.get(j+1));
					casas.set(j+1, temp);
				}
			}
		}
	}
	public void ordenarDeptosPorPrecio() {
		for(int i= 0; i<departamentos.size();i++) {
			for(int j= 0; j<departamentos.size()-1;j++) {
				if(departamentos.get(j).getPrecio()>departamentos.get(j+1).getPrecio()) {
					Departamento temp = departamentos.get(j);
					departamentos.set(j, departamentos.get(j+1));
					departamentos.set(j+1, temp);
				}
			}
		}
	}
	public void ordenarPHPorPrecio() {
		for(int i= 0; i<phs.size();i++) {
			for(int j= 0; j<phs.size()-1;j++) {
				if(phs.get(j).getPrecio()>phs.get(j+1).getPrecio()) {
					PH temp = phs.get(j);
					phs.set(j, phs.get(j+1));
					phs.set(j+1, temp);
				}
			}
		}
	}
	public void ordenarTerrenosPorPrecio() {
		for(int i= 0; i<terrenos.size();i++) {
			for(int j= 0; j<terrenos.size()-1;j++) {
				if(terrenos.get(j).getPrecio()>terrenos.get(j+1).getPrecio()) {
					Terreno temp = terrenos.get(j);
					terrenos.set(j, terrenos.get(j+1));
					terrenos.set(j+1, temp);
				}
			}
		}
	}
	public void ordenarCamposPorPrecio() {
		for(int i= 0; i<campos.size();i++) {
			for(int j= 0; j<campos.size()-1;j++) {
				if(campos.get(j).getPrecio()>campos.get(j+1).getPrecio()) {
					Campo temp = campos.get(j);
					campos.set(j, campos.get(j+1));
					campos.set(j+1, temp);
				}
			}
		}
	}
//	//ordenar propiedades por ubicacion
	public void ordenarCasasPorUbicacion() {
		for(int i= 0; i<casas.size();i++) {
			for(int j= 0; j<casas.size()-1;j++) {
				if(casas.get(j).getCiudad().compareTo(casas.get(j+1).getCiudad())> 0) {
					Casa temp = casas.get(j);
					casas.set(j, casas.get(j+1));
					casas.set(j+1, temp);
				}
			}
		}
	}
	
	//buscar por rango de precios
	public String rangoPreciosCasas(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < casas.size(); i++) {
			if(casas.get(i).getPrecio()>=precioMinimo && casas.get(i).getPrecio()<=precioMaximo) {
				resultado += casas.get(i) + "\n";
			}
		}
		return resultado;
	}
	public ArrayList<Casa> rangoPrecioCasasArray(Double precioMinimo, Double precioMaximo) {
		ArrayList <Casa> casasEncontradas = null;
		Integer contador = 0;
		for(int i=0;i < casas.size(); i++) {
			if(casas.get(i).getPrecio()>=precioMinimo && casas.get(i).getPrecio()<=precioMaximo) { 
				contador++;
			}
		}
		if(contador>0) {
			casasEncontradas = new ArrayList<>();
			for(int i=0;i < casas.size(); i++) {
				if(casas.get(i).getPrecio()>=precioMinimo && casas.get(i).getPrecio()<=precioMaximo) { 
					casasEncontradas.add(casas.get(i));
				}
			}
		}
	   return casasEncontradas;
		
	}
	
	public String rangoPreciosDeptos(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < departamentos.size(); i++) {
			if(departamentos.get(i).getPrecio()>=precioMinimo && departamentos.get(i).getPrecio()<=precioMaximo) {
				resultado += departamentos.get(i) + "\n";
			}
		}
		return resultado;
	}
	
	public String rangoPreciosPH(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < phs.size(); i++) {
			if(phs.get(i).getPrecio()>=precioMinimo && phs.get(i).getPrecio()<=precioMaximo) {
				resultado += phs.get(i) + "\n";
			}
		}
		return resultado;
	}
	public String rangoPreciosTerrenos(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < terrenos.size(); i++) {
			if(terrenos.get(i).getPrecio()>=precioMinimo && terrenos.get(i).getPrecio()<=precioMaximo) {
				resultado += terrenos.get(i) + "\n";
			}
		}
		return resultado;
	}
	public String rangoPrecioCampos(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < campos.size(); i++) {
			if(campos.get(i).getPrecio()>=precioMinimo && campos.get(i).getPrecio()<=precioMaximo) {
				resultado += campos.get(i) + "\n";
			}
		}
		return resultado;
	}
	//buscar por ubicacion
	
	public String ubicacionCasas(String ubicacion) {
		String resultado = "";
		for(int i=0;i < casas.size(); i++) {
			if(casas.get(i).getCiudad().equals(ubicacion)) {
				resultado += casas.get(i) + "\n";
			}
		}
		return resultado;
	}
	
	public String ubicacionDeptos(String ubicacion) {
		String resultado = "";
		for(int i=0;i < departamentos.size(); i++) {
			if(departamentos.get(i).getCiudad().equals(ubicacion)) {
				resultado += departamentos.get(i) + "\n";
			}
		}
		return resultado;
	}
	
	public String ubicacionPH(String ubicacion) {
		String resultado = "";
		for(int i=0;i < phs.size(); i++) {
			if(phs.get(i).getCiudad().equals(ubicacion)) {
				resultado += phs.get(i) + "\n";
			}
		}
		return resultado;
	}
	public String ubicacionTerrenos(String ubicacion) {
		String resultado = "";
		for(int i=0;i < terrenos.size(); i++) {
			if(terrenos.get(i).getCiudad().equals(ubicacion)) {
				resultado += terrenos.get(i) + "\n";
			}
		}
		return resultado;
	}
	public String ubicacionCampos(String ubicacion) {
		String resultado = "";
		for(int i=0;i < campos.size(); i++) {
			if(campos.get(i).getCiudad().equals(ubicacion)) {
				resultado += campos.get(i) + "\n";
			}
		}
		return resultado;
}
	//promedio de precio de propiedades
	public Double calcularPromedioPrecioDeLasCasas() {
		Double sumatoria = 0.0;
		Double promedio = 0.0;
		Integer cantidadDeCasas = 0;
		
		for(Casa actual : casas) {
			if(actual!=null) {
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
		
		for(Departamento actual : departamentos) {
				sumatoria+=actual.getPrecio();
				cantidadDeDeptos++;
			}
			
		if(cantidadDeDeptos==0) {
			return 0.0;
		}
		promedio = sumatoria/ cantidadDeDeptos;
		return promedio;
		
	}

	public Boolean verificacionDeDireccionCasa(String calle, Integer numero, String ciudad) {
		for(Casa actual : casas) {
			if(actual.getCalle().equals(calle)&& actual.getNumero().equals(numero) && actual.getCiudad().equals(ciudad)) {
				return false;
			}
			
		}
		return true;
	}
	public Boolean verificacionDeDireccionDepto(String calle, Integer nroDepto, Integer piso, String ciudad) {
		for(Departamento actual : departamentos) {
			if(actual.getCalle().equals(calle)&& actual.getNumero().equals(nroDepto) 
					&& actual.getPiso().equals(piso) && actual.getCiudad().equals(ciudad)) {
				return false;
			}
			
		}
		return true;
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
		Integer contador = 0;
		for(Venta venta : ventas) {
			if(venta.getPropiedad()!=null) {
				contador++;
			}	
		}
		if(contador>0) {
			propiedadesVendidas = new ArrayList<>();
			for(Venta venta : ventas) {
				propiedadesVendidas.add(venta);
			}
		}
		return propiedadesVendidas;
	}
	
	public ArrayList<Alquiler> mostrarAlquileres(){
		ArrayList<Alquiler> propiedadesAlquiladas = null;
		Integer contador = 0;
		for(Alquiler alquiler : alquileres) {
			if(alquiler.getPropiedad()!=null) {
				contador++;
			}	
		}
		if(contador>0) {
			propiedadesAlquiladas = new ArrayList<>();
			for(Alquiler alquiler : alquileres) {
				propiedadesAlquiladas.add(alquiler);
			}
		}
		return propiedadesAlquiladas;
	}
//	 public ArrayList<Casa> mostrarVentasCasas(){
//		 ArrayList<Casa> casasVendidas = null;
//		 Integer contadorCasa = 0;
//		 for(Casa casa: casas) {
//			 if(casa.fueVendida()) {
//				 contadorCasa++;
//			 }
//		 }
//		 if(contadorCasa>0) {
//			 casasVendidas = new ArrayList<>();
//			 for(Casa casa: casas) {
//				 if(casa.fueVendida()) {
//					 casasVendidas.add(casa);
//				 }
//			 }
//		 }
//		 return casasVendidas;
//	 }
//	 
//	
//	public String mostrarVentasCasas() {
//		String resultado = "";
//		for(Casa casa: casas) {
//			if(casa.fueVendida()) {
//				resultado+=casa.toString()+" ";
//				}
//			for(Cliente cliente: clientes) {
//				if(cliente.getNombre().equals(casa.getNombrePropietario())) {
//					resultado+=cliente.toString()+ "\n";
//				}
//			}
//			}
//			
//		
//		return resultado;
//	}
//	public String mostrarAlquilerCasas() {
//		String resultado = "";
//		for(Casa casa: casas) {
//			if(casa.fueAlquilada()) {
//				resultado+=casa.toString()+" ";
//				}
//			for(Cliente cliente: clientes) {
//				if(cliente.getNombre().equals(casa.getNombreInquilino())) {
//					resultado+=cliente.toString()+ "\n";
//				}
//			}
//			}
//			
//		
//		return resultado;
//	}
}
