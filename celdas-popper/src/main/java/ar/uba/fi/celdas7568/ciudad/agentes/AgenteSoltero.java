package ar.uba.fi.celdas7568.ciudad.agentes;
import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteSoltero extends Agente {
	
	public AgenteSoltero(){
		
		coeficienteDeAprendizaje = 0.005;
		
		barrioExclusivoDeseeado = 2;
		costoDeseeado = 3;
		culturaDeseeado = 1;
		diversionDeseeado = 5;
		educacionDeseeado = 2;
		familiarDeseeado = 2;
		naturalezaDeseeado = 2;
		populosoDeseeado = 4;
		seguridadDeseeado = 3;
		tranquiloDeseeado = 2;
		transporteDeseeado = 4;
		
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
		
		importanciaBarrioExclusivo = 1;
		importanciaCosto = 1;
		importanciaCultura = 1;
		importanciaDiversion = 1;
		importanciaEducacion = 1;
		importanciaFamiliar = 1;
		importanciaNaturaleza = 1;
		importanciaPopuloso = 1;
		importanciaSeguridad = 1;
		importanciaTranquilo = 1;
		importanciaTransporte = 1;
	}
	
}
