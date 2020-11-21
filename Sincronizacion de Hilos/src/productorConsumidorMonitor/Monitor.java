package productorConsumidorMonitor;

import java.util.Stack;

public class Monitor 
{
	private int numero;
	private boolean turnoConsumidor = false;//Partimos de la base que la colsa está vacía
	private Stack<String> contenido = new Stack<String>(); // Una pila, usa el metodo LIFO ( Primero en entrar ultimo en salir )
	private String resultado;
	private int contador = 0;
	
	
	public Monitor(int numero)
	{
		this.numero = numero;
	}
	
	public synchronized String get() 
	{
		while(!turnoConsumidor)//No hay consumidor ejecutándose
		{
			try
			{
				wait();
			}catch (InterruptedException e) {}
		}
		resultado = contenido.pop();
		turnoConsumidor=false;
		notifyAll();
		return resultado;
	}
	
	public synchronized void put(String cadena, int turno) 
	{
		while (turnoConsumidor )
		{
			try 
			{
				wait();
			}
			catch (InterruptedException e){}
		}
		
		contenido.push(cadena);
		turnoConsumidor=true; 
		notifyAll();
		}
}
