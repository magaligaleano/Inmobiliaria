package ar.edu.unlam.pb1;

public class Permuta implements Operacion{
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

		
	}

