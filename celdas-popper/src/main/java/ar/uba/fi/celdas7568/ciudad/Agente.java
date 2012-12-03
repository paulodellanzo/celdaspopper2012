package ar.uba.fi.celdas7568.ciudad;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class Agente {
	
	public double coeficienteDeAprendizaje;
	
	public double culturaDeseeado;
	public double diversionDeseeado;
	public double seguridadDeseeado;
	public double educacionDeseeado;
	public double naturalezaDeseeado;
	public double populosoDeseeado;
	public double familiarDeseeado;
	public double tranquiloDeseeado;
	public double transporteDeseeado;
	public double barrioExclusivoDeseeado;
	public double costoDeseado;
	
	public double importanciaCultura;
	public double importanciaDiversion;
	public double importanciaSeguridad;
	public double importanciaEducacion;
	public double importanciaNaturaleza;
	public double importanciaPopuloso;
	public double importanciaFamiliar;
	public double importanciaTranquilo;
	public double importanciaTransporte;
	public double importanciaBarrioExclusivo;
	public double importanciaCosto;
	
	public double max;
	public double min;
	
	String historial = "";
	
	private void grabarHistorial() {
		if(historial == ""){
			historial = historial + "cultura" +";";
			historial = historial + "diversion" +";";
			historial = historial + "seguridad" +";";
			historial = historial + "educacion" +";";
			historial = historial + "naturaleza" +";";
			historial = historial + "populoso" +";";
			historial = historial + "familiar" +";";
			historial = historial + "tranquilo" +";";
			historial = historial + "transporte" +";";
			historial = historial + "barrioExclusivo" +";";
			historial = historial + "costo" +"\r\n";
		}
		DecimalFormat df = new DecimalFormat("0.000"); 
		historial = historial + df.format(culturaDeseeado) +";";
		historial = historial + df.format(diversionDeseeado) +";";
		historial = historial + df.format(seguridadDeseeado) +";";
		historial = historial + df.format(educacionDeseeado) +";";
		historial = historial + df.format(naturalezaDeseeado) +";";
		historial = historial + df.format(populosoDeseeado) +";";
		historial = historial + df.format(familiarDeseeado) +";";
		historial = historial + df.format(tranquiloDeseeado) +";";
		historial = historial + df.format(transporteDeseeado) +";";
		historial = historial + df.format(barrioExclusivoDeseeado) +";";
		historial = historial + df.format(costoDeseado) +"\r\n";
		
	}
	
	public List<Opinion> elegirZona(Ciudad ciudad){

		
		grabarHistorial();
		List<Opinion> opiniones = Lists.newArrayList();
			
		for(Zona zona : ciudad){
			Opinion opinionSobreZona = evaluarZona(zona);
			opiniones.add(opinionSobreZona);
		}
			
		return opiniones;		
	}
	

	public Opinion evaluarZona(Zona zona){
		Opinion opinion = new Opinion();
		opinion.respuesta = 0;
		opinion.setZona(zona);
		
		double dif = Math.pow((barrioExclusivoDeseeado - zona.barrioExclusivo) * importanciaBarrioExclusivo,2);
		dif += Math.pow((costoDeseado - zona.costo) * importanciaCosto,2);
		dif += Math.pow((culturaDeseeado - zona.cultura) * importanciaCultura,2);
		dif += Math.pow((diversionDeseeado - zona.diversion) * importanciaDiversion,2);
		dif += Math.pow((educacionDeseeado - zona.educacion) * importanciaEducacion,2);
		dif += Math.pow((familiarDeseeado - zona.familiar) * importanciaFamiliar,2);
		dif += Math.pow((naturalezaDeseeado - zona.naturaleza) * importanciaNaturaleza,2);
		dif += Math.pow((populosoDeseeado - zona.populoso) * importanciaPopuloso,2);
		dif += Math.pow((seguridadDeseeado - zona.seguridad) * importanciaSeguridad,2);
		dif += Math.pow((tranquiloDeseeado - zona.tranquilo) * importanciaTranquilo,2);
		dif += Math.pow((transporteDeseeado - zona.transporte) * importanciaTransporte,2);
		
		opinion.respuesta = 100-dif; 
		return opinion;
	}

	
	public List<ElementoCiudad> evaluarOpiniones(List<Opinion> opiniones){
		
		Iterator<Opinion> iter = opiniones.iterator();
		max = -99999999;
		min = 99999999;
		Zona mejor = null;
		List<ElementoCiudad> elementos = Lists.newArrayList();
		
		while(iter.hasNext()){
			
			Opinion op = iter.next();
			if(op.respuesta > max){
				max = op.respuesta;
				mejor = op.getZona();
			}
			if(op.respuesta < min){
				min = op.respuesta;
				
			}
			elementos.add(new ElementoCiudad(op.getZona().posicionx,op.getZona().posiciony,op.respuesta));
			System.out.println("Zona en X: " + op.getZona().posicionx + " Y: " + op.getZona().posiciony);
			System.out.println("Tiene un puntaje de: " + op.respuesta);
			
		}
		System.out.println("\n"+"La mejor zona tiene un puntaje de: " + max);
		System.out.println("Esta ubicada en el punto X: " + mejor.posicionx + " Y: " + mejor.posiciony);
		
		return elementos;
	}

	public void aprender(Ciudad ciudad) {
		
		for(Zona zona : ciudad){
			barrioExclusivoDeseeado = barrioExclusivoDeseeado*(1.0-coeficienteDeAprendizaje)+zona.barrioExclusivo*coeficienteDeAprendizaje;
			costoDeseado = costoDeseado*(1.0-coeficienteDeAprendizaje)+zona.costo*coeficienteDeAprendizaje;
			culturaDeseeado = culturaDeseeado*(1.0-coeficienteDeAprendizaje)+zona.cultura*coeficienteDeAprendizaje;
			diversionDeseeado = diversionDeseeado*(1.0-coeficienteDeAprendizaje)+zona.diversion*coeficienteDeAprendizaje;
			educacionDeseeado = educacionDeseeado*(1.0-coeficienteDeAprendizaje)+zona.educacion*coeficienteDeAprendizaje;
			familiarDeseeado = familiarDeseeado*(1.0-coeficienteDeAprendizaje)+zona.familiar*coeficienteDeAprendizaje;
			naturalezaDeseeado = naturalezaDeseeado*(1.0-coeficienteDeAprendizaje)+zona.naturaleza*coeficienteDeAprendizaje;
			populosoDeseeado = populosoDeseeado*(1.0-coeficienteDeAprendizaje)+zona.populoso*coeficienteDeAprendizaje;
			seguridadDeseeado = seguridadDeseeado*(1.0-coeficienteDeAprendizaje)+zona.seguridad*coeficienteDeAprendizaje;
			tranquiloDeseeado = tranquiloDeseeado*(1.0-coeficienteDeAprendizaje)+zona.tranquilo*coeficienteDeAprendizaje;
			transporteDeseeado = transporteDeseeado*(1.0-coeficienteDeAprendizaje)+zona.transporte*coeficienteDeAprendizaje;	
			
		}

	}
	
	public String getHistorial(){
		return historial;
	}
}
