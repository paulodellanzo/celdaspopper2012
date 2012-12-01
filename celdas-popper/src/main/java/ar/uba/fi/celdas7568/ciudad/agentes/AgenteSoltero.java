package ar.uba.fi.celdas7568.ciudad.agentes;
import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteSoltero extends Agente {
	
	public AgenteSoltero(){
		
		barrioExclusivo = 2;
		costo = 3;
		cultura = 1;
		diversion = 5;
		educacion = 2;
		familiar = 2;
		naturaleza = 2;
		populoso = 4;
		seguridad = 3;
		tranquilo = 2;
		transporte = 4;
		
		importanciaBarrioExclusivo = 0.1;
		importanciaCosto = 0.5;
		importanciaCultura = 0.1;
		importanciaDiversion = 0.9;
		importanciaEducacion = 0.2;
		importanciaFamiliar = 0.2;
		importanciaNaturaleza = 0.3;
		importanciaPopuloso = 0.9;
		importanciaSeguridad = 0.3;
		importanciaTranquilo = 0;
		importanciaTransporte = 0.7;
	}
	
}
