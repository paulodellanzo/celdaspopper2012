package ar.uba.fi.celdas7568.ciudad.agentes;
import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteSoltero extends Agente {
	
	public AgenteSoltero(){
		
		coeficienteDeAprendizaje = 0.01;
		
		barrioExclusivoDeseado = 2;
		costoDeseado = 3;
		culturaDeseado = 1;
		diversionDeseado = 5;
		educacionDeseado = 2;
		familiarDeseado = 2;
		naturalezaDeseado = 2;
		populosoDeseado = 4;
		seguridadDeseado = 3;
		tranquiloDeseado = 2;
		transporteDeseado = 4;
		
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
