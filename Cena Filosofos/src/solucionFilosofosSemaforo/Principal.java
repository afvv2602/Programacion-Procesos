package solucionFilosofosSemaforo;

import java.util.concurrent.Semaphore;

public class Principal
{
	private static final int N_FILOSOFOS = 5; 
	private static final int N_VECES = 200;
	
	private static Semaphore tenedores [] = new Semaphore [N_FILOSOFOS];
	private static Semaphore acceso = new Semaphore(N_FILOSOFOS-1);
	
	private static Filosofo filosofos [] = new Filosofo [N_FILOSOFOS];

		
	
	public static void main(String[] args) 
	{
		long ini = System.currentTimeMillis();
		
		
		for (int i = 0; i < tenedores.length; i++) 
		{
			tenedores[i] = new Semaphore(1);
		}
		
		for (int i = 0; i < filosofos.length; i++) 
		{
			filosofos[i] = new Filosofo(i,N_VECES,N_FILOSOFOS,acceso,tenedores);
		}
		
		for (int i = 0; i < filosofos.length; i++) 
		{
			filosofos[i].start();
		}
		
		for (int i = 0; i < filosofos.length; i++) 
		{
			try 
			{
				filosofos[i].join();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}

		System.out.println("MAIN: Han terminado todos los filosofos correctamente");
		System.out.println("MAIN: Tiempo total: " + (System.currentTimeMillis()-ini));
	}
}
