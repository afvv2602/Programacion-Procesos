package pelotaRebotadoraMonoHilo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Marco extends JFrame
{
		private LaminaPelota lamina;
		public Marco()
		{
			
			setBounds(600,300,400,350);
			
			setTitle ("Rebotes");
			
			lamina=new LaminaPelota();
			
			add(lamina, BorderLayout.CENTER);
			
			JPanel laminaBotones=new JPanel();
			
			ponerBoton(laminaBotones, "Dale!", new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					comienza_el_juego();
				}
				
			});
			
			
			ponerBoton(laminaBotones, "Salir", new ActionListener()
			{
				public void actionPerformed(ActionEvent evento)
				{	
					System.exit(0);	
				}
			});
			
			add(laminaBotones, BorderLayout.SOUTH);
		}
		
		
		//Ponemos botones	
		public void ponerBoton(Container c, String titulo, ActionListener oyente)
		{	
			JButton boton=new JButton(titulo);	
			c.add(boton);
			boton.addActionListener(oyente);
			
		}
		
		public void comienza_el_juego ()
		{			
				Pelota pelota=new Pelota();
				
				lamina.add(pelota);
				//Creamos un hilo de ejecucion cada vez que le damos al play 
				Thread t = new Thread(new Hilo(pelota,lamina));
				t.start(); ///¿Que haria ? //¿Que tendria que hacer run()
//					
		}
}

