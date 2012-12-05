package ar.uba.fi.celdas7568.ciudad.agentes;

import ar.uba.fi.celdas7568.ciudad.Agente;

public class AgentePareja extends Agente{

		public AgentePareja(){
		
		coeficienteDeAprendizaje = 0.005;
		
		barrioExclusivoDeseado = 4;
		costoDeseado = 3;
		culturaDeseado = 3;
		diversionDeseado = 4;
		educacionDeseado = 2;
		familiarDeseado = 2;
		naturalezaDeseado = 3;
		populosoDeseado = 5;
		seguridadDeseado = 4;
		tranquiloDeseado = 2;
		transporteDeseado = 3;
		
		importanciaBarrioExclusivo = 0.2;
		importanciaCosto = 0.6;
		importanciaCultura = 0.7;
		importanciaDiversion = 0.7;
		importanciaEducacion = 0.2;
		importanciaFamiliar = 0.2;
		importanciaNaturaleza = 0.3;
		importanciaPopuloso = 0.9;
		importanciaSeguridad = 0.5;
		importanciaTranquilo = 0.8;
		importanciaTransporte = 0.8;
		inicializar();

		}

}
