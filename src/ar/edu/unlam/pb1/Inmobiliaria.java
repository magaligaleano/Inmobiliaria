package ar.edu.unlam.pb1;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private Departamento departamentos[];
	private Cliente clientes[];
	private Casa casas[];
	private Terreno terrenos[];
	private Campo campos[];
	private PH phs[];
	private final Integer CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO = 100;
	private final Integer CANTIDAD_MAXIMA_DE_CLIENTES = 400;
	
	
	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.casas = new Casa[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.departamentos = new Departamento[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.phs = new PH[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.terrenos = new Terreno[CANTIDAD_MAXIMA_DE_PROPIEDADES_POR_TIPO];
		this.clientes = new Cliente[CANTIDAD_MAXIMA_DE_CLIENTES];
	}
	
	public Boolean agregarCasa(Casa nueva) {
		for(int i=0;i< casas.length; i++) {
			if(casas[i]==null && verificacionDeDireccionCasa(nueva.getCalle(), nueva.getNumero(), nueva.getCiudad())) {
				casas[i]= nueva;
				return true;
			}
		}
		return false;
	}

	public Boolean agregarPH(PH nuevo) {
		for(int i=0;i< phs.length; i++) {
			if(phs[i]==null) {
				phs[i]= nuevo;
				return true;
			}
		}
		return false;
	}
	
		public Boolean agregarTerreno(Terreno nuevo) {
			for(int i=0;i< terrenos.length; i++) {
				if(terrenos[i]==null) {
					terrenos[i]= nuevo;
					return true;
				}
			}
			return false;
		
		}
			public Boolean agregarCampo(Campo nuevo) {
				for(int i=0;i< campos.length; i++) {
					if(campos[i]==null) {
						campos[i]= nuevo;
						return true;
					}
				}
				return false;
			}
			
	public boolean agregarDepartamento(Departamento nuevo) {
		for(int i=0;i<departamentos.length;i++) {
			if(departamentos[i]==null && verificacionDeDireccionDepto(nuevo.getCalle(), nuevo.getNroDepto(), nuevo.getPiso(), nuevo.getCiudad())) {
				departamentos[i] = nuevo;
				return true;
			}
		}
		return false;
	}
	public boolean agregarCliente(Cliente nuevo) {
		for(Cliente cliente : clientes) {
			if(cliente!=null && cliente.getDni().equals(nuevo.getDni())) {
				return false;
			}
		}
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i]==null) {
				clientes[i]= nuevo;
				return true;
			}
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
		for(int i=0;i < casas.length; i++) {
			if(casas[i] != null) {
				resultado += casas[i] + "\n";
			}
		}
		return resultado;
	}
	
	public String mostrarPropiedadesDeptos() {
		String resultado = "";
		for(int i=0;i < departamentos.length; i++) {
			if(departamentos[i] != null) {
				resultado += departamentos[i] + "\n";
			}
		}
		return resultado;
	}
	
	public String mostrarPropiedadesPH() {
		String resultado = "";
		for(int i=0;i < phs.length; i++) {
			if(phs[i] != null) {
				resultado += phs[i] + "\n";
			}
		}
		return resultado;
	}
	public String mostrarPropiedadesTerrenos() {
		String resultado = "";
		for(int i=0;i < terrenos.length; i++) {
			if(terrenos[i] != null) {
				resultado += terrenos[i] + "\n";
			}
		}
		return resultado;
	}
	public String mostrarPropiedadesCampos() {
		String resultado = "";
		for(int i=0;i < campos.length; i++) {
			if(campos[i] != null) {
				resultado += campos[i] + "\n";
			}
		}
		return resultado;
	}
	
	//Buscar y modificar propiedades
	
	public Boolean buscarCodigoCasa(String codigo) {
		for(Casa casa : casas) {
			if(casa.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
	public Boolean modificarCasa(String codigo, Casa actualizada) {
		for(int i=0;i<casas.length;i++) {
			if(casas[i].getCodigo().equals(codigo)) {
				casas[i] = actualizada;
				return true;
			}
		}
		return false;
	}
	public Boolean buscarCodigoDepto(String codigo) {
		for(Departamento depto: departamentos) {
			if(depto.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
	public Boolean modificarDepto(String codigo, Departamento actualizado) {
		for(int i=0;i<departamentos.length;i++) {
			if(departamentos[i].getCodigo().equals(codigo)) {
				departamentos[i] = actualizado;
				return true;
			}
		}
		return false;
	}
	public Boolean buscarCodigoPH(String codigo) {
		for(PH ph: phs) {
			if(ph.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
	public Boolean modificarPH(String codigo, PH actualizado) {
		for(int i=0;i<phs.length;i++) {
			if(phs[i].getCodigo().equals(codigo)) {
				phs[i] = actualizado;
				return true;
			}
		}
		return false;
	}
	//ordenar propiedades por precio
	
	public void ordenarCasasPorPrecio() {
		for(int i= 0; i<casas.length -1;i++) {
			for(int j= 0; j<casas.length -i -1;j++) {
				if(casas[j]!=null && casas[j+1]!=null && casas[j].getPrecio()>casas[j+1].getPrecio()) {
					Casa temp = casas[j];
					casas[j] = casas[j+1];
					casas[j+1] = temp;
				}
			}
		}
	}
	public void ordenarDeptosPorPrecio() {
		for(int i= 0; i<departamentos.length -1;i++) {
			for(int j= 0; j<departamentos.length -i -1;j++) {
				if(departamentos[j]!=null && departamentos[j+1]!=null && departamentos[j].getPrecio()>casas[j+1].getPrecio()) {
					Departamento temp = departamentos[j];
					departamentos[j] = departamentos[j+1];
					departamentos[j+1] = temp;
				}
			}
		}
	}
	public void ordenarPHPorPrecio() {
		for(int i= 0; i<phs.length -1;i++) {
			for(int j= 0; j<phs.length -i -1;j++) {
				if(phs[j]!=null && phs[j+1]!=null && phs[j].getPrecio()>phs[j+1].getPrecio()) {
					PH temp = phs[j];
					phs[j] = phs[j+1];
					phs[j+1] = temp;
				}
			}
		}
	}
	public void ordenarTerrenosPorPrecio() {
		for(int i= 0; i<terrenos.length -1;i++) {
			for(int j= 0; j<terrenos.length -i -1;j++) {
				if(terrenos[j]!=null && terrenos[j+1]!=null && terrenos[j].getPrecio()>terrenos[j+1].getPrecio()) {
					Terreno temp = terrenos[j];
					terrenos[j] = terrenos[j+1];
					terrenos[j+1] = temp;
				}
			}
		}
	}
	public void ordenarCamposPorPrecio() {
		for(int i= 0; i<campos.length -1;i++) {
			for(int j= 0; j<campos.length -i -1;j++) {
				if(campos[j]!=null && campos[j+1]!=null && campos[j].getPrecio()>campos[j+1].getPrecio()) {
					Campo temp = campos[j];
					campos[j] = campos[j+1];
					campos[j+1] = temp;
				}
			}
		}
	}
	//ordenar propiedades por ubicacion
	public void ordenarCasasPorUbicacion() {
		for(int i= 0; i<casas.length -1;i++) {
			for(int j= 0; j<casas.length -i -1;j++) {
				if(casas[j]!=null && casas[j+1]!=null && casas[j].getCiudad().compareTo(casas[j+1].getCiudad())> 0) {
					Casa temp = casas[j];
					casas[j] = casas[j+1];
					casas[j+1] = temp;
				}
			}
		}
	}
	
	//buscar por rango de precios
	public String rangoPreciosCasas(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < casas.length; i++) {
			if(casas[i] != null && casas[i].getPrecio()>=precioMinimo && casas[i].getPrecio()<=precioMaximo) {
				resultado += casas[i] + "\n";
			}
		}
		return resultado;
	}
	public Casa[] rangoPrecioCasasArray(Double precioMinimo, Double precioMaximo) {
		Casa casasEncontradas [] = null;
		Integer cantidadDeCasas = 0;
		for(int i=0;i < casas.length; i++) {
			if(casas[i] != null && casas[i].getPrecio()>=precioMinimo && casas[i].getPrecio()<=precioMaximo) { 
				casasEncontradas = new Casa[casas.length];
				casasEncontradas[cantidadDeCasas++] = casas[i];
			}
		}
	   return casasEncontradas;
		
	}
	
	public String rangoPreciosDeptos(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < departamentos.length; i++) {
			if(departamentos[i] != null && departamentos[i].getPrecio()>=precioMinimo && departamentos[i].getPrecio()<=precioMaximo) {
				resultado += departamentos[i] + "\n";
			}
		}
		return resultado;
	}
	
	public String rangoPreciosPH(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < phs.length; i++) {
			if(phs[i] != null && phs[i].getPrecio()>=precioMinimo && phs[i].getPrecio()<=precioMaximo) {
				resultado += phs[i] + "\n";
			}
		}
		return resultado;
	}
	public String rangoPreciosTerrenos(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < terrenos.length; i++) {
			if(terrenos[i] != null && terrenos[i].getPrecio()>=precioMinimo && terrenos[i].getPrecio()<=precioMaximo) {
				resultado += terrenos[i] + "\n";
			}
		}
		return resultado;
	}
	public String rangoPrecioCampos(Double precioMinimo, Double precioMaximo) {
		String resultado = "";
		for(int i=0;i < campos.length; i++) {
			if(campos[i] != null && campos[i].getPrecio()>=precioMinimo && campos[i].getPrecio()<=precioMaximo) {
				resultado += campos[i] + "\n";
			}
		}
		return resultado;
	}
	//buscar por ubicacion
	
	public String ubicacionCasas(String ubicacion) {
		String resultado = "";
		for(int i=0;i < casas.length; i++) {
			if(casas[i] != null && casas[i].getCiudad().equals(ubicacion)) {
				resultado += casas[i] + "\n";
			}
		}
		return resultado;
	}
	
	public String ubicacionDeptos(String ubicacion) {
		String resultado = "";
		for(int i=0;i < departamentos.length; i++) {
			if(departamentos[i] != null && departamentos[i].getCiudad().equals(ubicacion)) {
				resultado += departamentos[i] + "\n";
			}
		}
		return resultado;
	}
	
	public String ubicacionPH(String ubicacion) {
		String resultado = "";
		for(int i=0;i < phs.length; i++) {
			if(phs[i] != null && phs[i].getUbicacion().equals(ubicacion)) {
				resultado += phs[i] + "\n";
			}
		}
		return resultado;
	}
	public String ubicacionTerrenos(String ubicacion) {
		String resultado = "";
		for(int i=0;i < terrenos.length; i++) {
			if(terrenos[i] != null && terrenos[i].getUbicacion().equals(ubicacion)) {
				resultado += terrenos[i] + "\n";
			}
		}
		return resultado;
	}
	public String ubicacionCampos(String ubicacion) {
		String resultado = "";
		for(int i=0;i < campos.length; i++) {
			if(campos[i] != null && campos[i].getUbicacion().equals(ubicacion)) {
				resultado += campos[i] + "\n";
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
			if(actual!=null) {
				sumatoria+=actual.getPrecio();
				cantidadDeDeptos++;
			}
			
		}
		if(cantidadDeDeptos==0) {
			return 0.0;
		}
		promedio = sumatoria/ cantidadDeDeptos;
		return promedio;
		
	}
	public Casa [] crearCasas() {
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron",100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);
		 agregarCasa(casa1);
		 agregarCasa(casa2);
		 agregarCasa(casa3);
		return casas;
		
	}
	public Boolean verificacionDeDireccionCasa(String calle, Integer numero, String ciudad) {
		for(Casa actual : casas) {
			if(actual!=null && actual.getCalle().equals(calle)&& actual.getNumero().equals(numero) && actual.getCiudad().equals(ciudad)) {
				return false;
			}
			
		}
		return true;
	}
	public Boolean verificacionDeDireccionDepto(String calle, Integer nroDepto, Integer piso, String ciudad) {
		for(Departamento actual : departamentos) {
			if(actual!=null && actual.getCalle().equals(calle)&& actual.getNroDepto().equals(nroDepto) 
					&& actual.getPiso().equals(piso) && actual.getCiudad().equals(ciudad)) {
				return false;
			}
			
		}
		return true;
	}
}
