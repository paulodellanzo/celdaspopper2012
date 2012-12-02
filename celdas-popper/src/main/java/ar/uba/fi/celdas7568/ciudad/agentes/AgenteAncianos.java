package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgenteAncianos extends Agente{

	
		public AgenteAncianos(){
		
		barrioExclusivoDeseeado = 4;
		costoDeseado = 3;
		culturaDeseeado = 5;
		diversionDeseeado = 1;
		educacionDeseeado = 1;
		familiarDeseeado = 5;
		naturalezaDeseeado = 4;
		populosoDeseeado = 1;
		seguridadDeseeado = 5;
		tranquiloDeseeado = 4;
		transporteDeseeado = 2;
		
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
		
		coeficienteDeAprendizaje = 0.005;
	}

}
