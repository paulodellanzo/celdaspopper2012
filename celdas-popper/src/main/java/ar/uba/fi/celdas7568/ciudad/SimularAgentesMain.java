package ar.uba.fi.celdas7568.ciudad;

import java.util.Iterator;
import java.util.List;

import ar.uba.fi.celdas7568.ciudad.Opinion;
import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaDeDecision;

import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaSoltero;

public class SimularAgentesMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int opcion = 1;
		
		
		if (opcion == 1) {
			System.out.println("Simulacion para Soltero");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = 0;
			personalidad.costo = 0.5;
			personalidad.cultura = -0.75;
			personalidad.diversion = 1;
			personalidad.educacion = 0;
			personalidad.familiar = -0.5;
			personalidad.naturaleza = 0.5;
			personalidad.populoso = 0.75;
			personalidad.seguridad = -0.5;
			personalidad.tranquilo = -1;
			personalidad.transporte = 0.75;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaSoltero();
			agente.setHeuristicaDeDesicion(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			List<ElementoCiudad> elementos = agente.getHeuristicaDeDesicion()
					.evaluarOpiniones(opinionZonas);
			CreadorCiudad crea = new CreadorCiudad(elementos,
					agente.getHeuristicaDeDesicion().max,
					agente.getHeuristicaDeDesicion().min);
			crea.crearCiudad();
		}

		if (opcion == 2) {
			System.out.println("Simulacion para Pareja");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = 0.5;
			personalidad.costo = 0.25;
			personalidad.cultura = 0.5;
			personalidad.diversion = 0.5;
			personalidad.educacion = -0.5;
			personalidad.familiar = 0;
			personalidad.naturaleza = 0.75;
			personalidad.populoso = 1;
			personalidad.seguridad = 0.5;
			personalidad.tranquilo = -0.75;
			personalidad.transporte = 0;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaSoltero();
			agente.setHeuristicaDeDesicion(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			List<ElementoCiudad> elementos = agente.getHeuristicaDeDesicion()
					.evaluarOpiniones(opinionZonas);
			CreadorCiudad crea = new CreadorCiudad(elementos,
					agente.getHeuristicaDeDesicion().max,
					agente.getHeuristicaDeDesicion().min);
			crea.crearCiudad();
		}
		if (opcion == 3) {
			System.out.println("Simulacion para Familia");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = 1;
			personalidad.costo = -0.5;
			personalidad.cultura = 0;
			personalidad.diversion = -0.25;
			personalidad.educacion = 1;
			personalidad.familiar = 1;
			personalidad.naturaleza = 0.25;
			personalidad.populoso = -0.5;
			personalidad.seguridad = 0.75;
			personalidad.tranquilo = 0.5;
			personalidad.transporte = -0.25;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaSoltero();
			agente.setHeuristicaDeDesicion(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			List<ElementoCiudad> elementos = agente.getHeuristicaDeDesicion()
					.evaluarOpiniones(opinionZonas);
			CreadorCiudad crea = new CreadorCiudad(elementos,
					agente.getHeuristicaDeDesicion().max,
					agente.getHeuristicaDeDesicion().min);
			crea.crearCiudad();
		}

		if (opcion == 4) {
			System.out.println("Simulacion para Ancianos");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = -0.5;
			personalidad.costo = -0.25;
			personalidad.cultura = 1;
			personalidad.diversion = -1;
			personalidad.educacion = -0.75;
			personalidad.familiar = -0.5;
			personalidad.naturaleza = 0.75;
			personalidad.populoso = -0.75;
			personalidad.seguridad = 0.5;
			personalidad.tranquilo = 1;
			personalidad.transporte = 0;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaSoltero();
			agente.setHeuristicaDeDesicion(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			List<ElementoCiudad> elementos = agente.getHeuristicaDeDesicion()
					.evaluarOpiniones(opinionZonas);
			CreadorCiudad crea = new CreadorCiudad(elementos,
					agente.getHeuristicaDeDesicion().max,
					agente.getHeuristicaDeDesicion().min);
			crea.crearCiudad();
		}
	}

}



