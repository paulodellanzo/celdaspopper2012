package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteAncianos extends Agente{

	
		public AgenteAncianos(){
		
		barrioExclusivoDeseado = 4;
		costoDeseado = 3;
		culturaDeseado = 5;
		diversionDeseado = 1;
		educacionDeseado = 1;
		familiarDeseado = 5;
		naturalezaDeseado = 4;
		populosoDeseado = 1;
		seguridadDeseado = 5;
		tranquiloDeseado = 4;
		transporteDeseado = 2;
		
		importanciaBarrioExclusivo = 0.1;
		importanciaCosto = 0.8;
		importanciaCultura = 0.7;
		importanciaDiversion = 0.2;
		importanciaEducacion = 0;
		importanciaFamiliar = 0.8;
		importanciaNaturaleza = 0.75;
		importanciaPopuloso = 0.8;
		importanciaSeguridad = 0.8;
		importanciaTranquilo = 0.9;
		importanciaTransporte = 0.1;
		
		coeficienteDeAprendizaje = 0.02;
	}

}
