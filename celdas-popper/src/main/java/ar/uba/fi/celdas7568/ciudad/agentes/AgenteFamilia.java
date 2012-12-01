package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteFamilia extends Agente{

		public AgenteFamilia(){
		
		barrioExclusivo = 1;
		costo = 3;
		cultura = 3;
		diversion = 3;
		educacion = 5;
		familiar = 5;
		naturaleza = 3;
		populoso = 1;
		seguridad = 4;
		tranquilo = 3;
		transporte = 1;
		
		importanciaBarrioExclusivo = 0.3;
		importanciaCosto = 0.2;
		importanciaCultura = 0.2;
		importanciaDiversion = 0.8;
		importanciaEducacion = 1;
		importanciaFamiliar = 1;
		importanciaNaturaleza = 0.6;
		importanciaPopuloso = 0.8;
		importanciaSeguridad = 0.75;
		importanciaTranquilo = 0.5;
		importanciaTransporte = 0.2;
		}
}