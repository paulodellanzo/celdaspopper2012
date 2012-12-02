package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteFamilia extends Agente{

		public AgenteFamilia(){
		
		barrioExclusivoDeseeado = 1;
		costoDeseado = 3;
		culturaDeseeado = 3;
		diversionDeseeado = 3;
		educacionDeseeado = 5;
		familiarDeseeado = 5;
		naturalezaDeseeado = 3;
		populosoDeseeado = 1;
		seguridadDeseeado = 4;
		tranquiloDeseeado = 3;
		transporteDeseeado = 1;
		
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
		
		coeficienteDeAprendizaje = 0.005;
		}
}