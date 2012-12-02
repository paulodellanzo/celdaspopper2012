package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgentePareja extends Agente{

		public AgentePareja(){
		
		coeficienteDeAprendizaje = 0.005;
		
		barrioExclusivoDeseeado = 4;
		costoDeseeado = 3;
		culturaDeseeado = 3;
		diversionDeseeado = 4;
		educacionDeseeado = 2;
		familiarDeseeado = 2;
		naturalezaDeseeado = 3;
		populosoDeseeado = 5;
		seguridadDeseeado = 4;
		tranquiloDeseeado = 2;
		transporteDeseeado = 3;
		
		importanciaBarrioExclusivo = 0.2;
		importanciaCosto = 0.6;
		importanciaCultura = 0.7;
		importanciaDiversion = 0.7;
		importanciaEducacion = 0.2;
		importanciaFamiliar = 0.2;
		importanciaNaturaleza = 0.3;
		importanciaPopuloso = 1;
		importanciaSeguridad = 0.5;
		importanciaTranquilo = 0.8;
		importanciaTransporte = 0.8;

		}

}
