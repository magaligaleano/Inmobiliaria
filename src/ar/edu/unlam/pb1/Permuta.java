package ar.edu.unlam.pb1;

public class Permuta implements Operacion, Comparable<Permuta>{
	 private Propiedad propiedadA;
	    private Propiedad propiedadB;

	    public Permuta(Propiedad propiedadA, Propiedad propiedadB) {
	        this.propiedadA = propiedadA;
	        this.propiedadB = propiedadB;
	    }

	    @Override
	    public void ejecutar() {
	        String tempPropietario = propiedadA.getNombrePropietario();
	        propiedadA.setNombrePropietario(propiedadB.getNombrePropietario());
	        propiedadB.setNombrePropietario(tempPropietario);
	    }

		@Override
		public String toString() {
			return "Permuta [propiedadA=" + propiedadA + ", propiedadB=" + propiedadB + "]";
		}

		@Override
		public int compareTo(Permuta o) {
			return this.propiedadA.getCodigo().compareTo(o.propiedadA.getCodigo());
			
			
		}

		public Propiedad getPropiedadA() {
			return propiedadA;
		}

		public void setPropiedadA(Propiedad propiedadA) {
			this.propiedadA = propiedadA;
		}

		public Propiedad getPropiedadB() {
			return propiedadB;
		}

		public void setPropiedadB(Propiedad propiedadB) {
			this.propiedadB = propiedadB;
		}

		
	}

