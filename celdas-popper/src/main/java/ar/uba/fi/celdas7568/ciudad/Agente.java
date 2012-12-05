package ar.uba.fi.celdas7568.ciudad;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class Agente {
	
	public double coeficienteDeAprendizaje;
	
	public double culturaDeseado;
	public double diversionDeseado;
	public double seguridadDeseado;
	public double educacionDeseado;
	public double naturalezaDeseado;
	public double populosoDeseado;
	public double familiarDeseado;
	public double tranquiloDeseado;
	public double transporteDeseado;
	public double barrioExclusivoDeseado;
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
		historial = historial + df.format(culturaDeseado) +";";
		historial = historial + df.format(diversionDeseado) +";";
		historial = historial + df.format(seguridadDeseado) +";";
		historial = historial + df.format(educacionDeseado) +";";
		historial = historial + df.format(naturalezaDeseado) +";";
		historial = historial + df.format(populosoDeseado) +";";
		historial = historial + df.format(familiarDeseado) +";";
		historial = historial + df.format(tranquiloDeseado) +";";
		historial = historial + df.format(transporteDeseado) +";";
		historial = historial + df.format(barrioExclusivoDeseado) +";";
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
		
		double dif = Math.pow((barrioExclusivoDeseado - zona.barrioExclusivo) * importanciaBarrioExclusivo,2);
		dif += Math.pow((costoDeseado - zona.costo) * importanciaCosto,2);
		dif += Math.pow((culturaDeseado - zona.cultura) * importanciaCultura,2);
		dif += Math.pow((diversionDeseado - zona.diversion) * importanciaDiversion,2);
		dif += Math.pow((educacionDeseado - zona.educacion) * importanciaEducacion,2);
		dif += Math.pow((familiarDeseado - zona.familiar) * importanciaFamiliar,2);
		dif += Math.pow((naturalezaDeseado - zona.naturaleza) * importanciaNaturaleza,2);
		dif += Math.pow((populosoDeseado - zona.populoso) * importanciaPopuloso,2);
		dif += Math.pow((seguridadDeseado - zona.seguridad) * importanciaSeguridad,2);
		dif += Math.pow((tranquiloDeseado - zona.tranquilo) * importanciaTranquilo,2);
		dif += Math.pow((transporteDeseado - zona.transporte) * importanciaTransporte,2);
		
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

	public double aprender(double valorDeseado,double valorZona,double importancia){
		
		double coeficienteAtributo = coeficienteDeAprendizaje * (1.0-importancia);
		
		double nuevoValor = valorDeseado*(1.0-coeficienteAtributo)+valorZona*coeficienteAtributo;
		return nuevoValor;
	}
	
	public void aprender(Ciudad ciudad) {
		
		for(Zona zona : ciudad){
			barrioExclusivoDeseado= aprender(barrioExclusivoDeseado,zona.barrioExclusivo,importanciaBarrioExclusivo);
			costoDeseado= aprender(costoDeseado,zona.costo,importanciaCosto);
			culturaDeseado= aprender(culturaDeseado,zona.cultura,importanciaCultura);
			diversionDeseado= aprender(diversionDeseado,zona.diversion,importanciaDiversion);
			educacionDeseado= aprender(educacionDeseado,zona.educacion,importanciaEducacion);
			familiarDeseado= aprender(familiarDeseado,zona.familiar,importanciaFamiliar);
			naturalezaDeseado= aprender(naturalezaDeseado,zona.naturaleza,importanciaNaturaleza);
			populosoDeseado= aprender(populosoDeseado,zona.populoso,importanciaPopuloso);
			seguridadDeseado= aprender(seguridadDeseado,zona.seguridad,importanciaSeguridad);
			tranquiloDeseado= aprender(tranquiloDeseado,zona.tranquilo,importanciaTranquilo);
			transporteDeseado= aprender(transporteDeseado,zona.transporte,importanciaTransporte);	
		}
	}
	
	public String getHistorial(){
		return historial;
	}
}
