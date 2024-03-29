package ar.uba.fi.celdas7568.ciudad;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private int size = 40;
	private Squares squares;
	private JLabel labelAgente;
	
	Simulador simulador = new Simulador();
	
	public Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame.class.getResource("/ar/uba/fi/celdas7568/ciudad/Building-icon.png")));
		setTitle("Análisis de zonas urbanas");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Simular ciudad");
		button.setBounds(25, 20, 150, 30);
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				redibujarMapa();
			}
		};		
		button.addActionListener(actionListener);		
		add(button);		
		
		JButton button2 = new JButton("Cambiar ciudad");
		button2.setBounds(200, 20, 150, 30);
		ActionListener actionListener2 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				simulador.cambiarCiudad();
			}
		};		
		button2.addActionListener(actionListener2);		
		add(button2);		
		
		JButton button3 = new JButton("Cambiar agente");
		button3.setBounds(375, 20, 150, 30);
		ActionListener actionListener3 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				labelAgente.setText("Agente:"+simulador.proximoAgente());
			}
		};		
		button3.addActionListener(actionListener3);		
		add(button3);
		
		
		JButton button4 = new JButton("Mostrar historial");
		button4.setBounds(550, 20, 150, 30);
		ActionListener actionListener4 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println(simulador.getAgente().getHistorial());
				simulador.escribirHistorial(simulador.getAgente().getHistorial());
			}
		};		
		button4.addActionListener(actionListener4);		
		add(button4);
		
		
		
		labelAgente = new JLabel("Agente:"+simulador.nombreAgente());
		labelAgente.setBounds(520,100,200,50);
		add(labelAgente);
		
		
		for (int i = 0; i < 10; i++ ){
			JLabel l = new JLabel( String.valueOf(i) );
			JLabel l2 = new JLabel( String.valueOf(i) );
			l.setBounds(115 + size*i, 80, 10, 10);
			l2.setBounds(80, 115 + size*i, 10, 10);
			add(l);
			add(l2);
		}
			
		dibujarMapa();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void dibujarMapa(){
		
		List<ElementoCiudad> zonas = simulador.simular();
		double minPuntaje = zonas.get(zonas.size()-1).puntaje;
		zonas.remove(zonas.size()-1);
		double maxPuntaje = zonas.get(zonas.size()-1).puntaje;
		zonas.remove(zonas.size()-1);		  

						
		squares = new Squares();
		getContentPane().add(squares);	
				
		for (ElementoCiudad zona: zonas) {      	    	  
			double alfa =  ( zona.puntaje - minPuntaje) / (maxPuntaje - minPuntaje);
			Color c = new Color( (int) ( (1-alfa)*255.0 ), (int) (alfa*255.0), 0 );
			squares.addSquare(100 + zona.posX * size, 100 + zona.posY * size, size, size, c);
			
			if( zona.puntaje == maxPuntaje ){
				squares.addHuman(  105 + zona.posX * size, 105 + zona.posY * size );
			}
		}
	}
	
	public void redibujarMapa(){
		List<ElementoCiudad> zonas = simulador.simular();
		double minPuntaje = zonas.get(zonas.size()-1).puntaje;
		zonas.remove(zonas.size()-1);
		double maxPuntaje = zonas.get(zonas.size()-1).puntaje;
		zonas.remove(zonas.size()-1);	

		
		int i = 0;
		for (ElementoCiudad zona: zonas) {      	    	  
			double alfa =  ( zona.puntaje - minPuntaje) / (maxPuntaje - minPuntaje);
			Color c = new Color( (int) ( (1-alfa)*255.0 ), (int) (alfa*255.0), 0 );
			squares.modifySquare(i, c);

			if( zona.puntaje == maxPuntaje ){
				squares.modifyHuman(  105 + zona.posX * size, 105 + zona.posY * size );
			}
			
			i++;
		}
		
		repaint();
	}

	public static void main(String[] args) {
		Ciudad c = new Ciudad();
		c.importarZonas();
		new Frame();
	}
}
