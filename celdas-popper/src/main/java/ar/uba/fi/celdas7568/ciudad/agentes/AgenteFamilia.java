package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteFamilia extends Agente{

		public AgenteFamilia(){
		
		barrioExclusivoDeseado = 2;
		costoDeseado = 3;
		culturaDeseado = 3;
		diversionDeseado = 3;
		educacionDeseado = 5;
		familiarDeseado = 5;
		naturalezaDeseado = 3;
		populosoDeseado = 1;
		seguridadDeseado = 4;
		tranquiloDeseado = 3;
		transporteDeseado = 1;
		
		importanciaBarrioExclusivo = 0.7;
		importanciaCosto = 0.2;
		importanciaCultura = 0.2;
		importanciaDiversion = 0.8;
		importanciaEducacion = 0.9;
		importanciaFamiliar = 0.9;
		importanciaNaturaleza = 0.6;
		importanciaPopuloso = 0.8;
		importanciaSeguridad = 0.75;
		importanciaTranquilo = 0.5;
		importanciaTransporte = 0.2;
		
		coeficienteDeAprendizaje = 0.02;
		}
}