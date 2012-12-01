package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteAncianos extends Agente{

	
		public AgenteAncianos(){
		
		barrioExclusivo = 4;
		costo = 3;
		cultura = 5;
		diversion = 1;
		educacion = 1;
		familiar = 5;
		naturaleza = 4;
		populoso = 1;
		seguridad = 5;
		tranquilo = 4;
		transporte = 2;
		
		importanciaBarrioExclusivo = 0.1;
		importanciaCosto = 1;
		importanciaCultura = 1;
		importanciaDiversion = 0.2;
		importanciaEducacion = 0;
		importanciaFamiliar = 0.9;
		importanciaNaturaleza = 0.75;
		importanciaPopuloso = 1;
		importanciaSeguridad = 1;
		importanciaTranquilo = 1;
		importanciaTransporte = 0.1;
	}

}
