package solucionFilosofosSemaforo;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread 
{
	
	private int id;
	private int nVeces;
	private int nFilosofos;
	private Semaphore acceso;
	private Semaphore tenedores [];
	
	public Filosofo(int id, int nVeces,int nFilosofos,Semaphore acceso,Semaphore tenedores []) 
	{
		this.id = id;
		this.nVeces = nVeces;
		this.nFilosofos = nFilosofos;
		this.acceso = acceso;
		this.tenedores = tenedores;
	}

	@Override
	public void run() 
	{
		try
		{
			for (int i = 0 ; i < nVeces; i++)
			{
				// Solo pueden pasar algunos filosofos, preguntamos antes de entrar
				acceso.acquire();
			
				// Vemos si podemor adquirir los tenederos a nuestra izquierda y derecha para comer
				tenedores[id].acquire();
				tenedores[(id+1)%nFilosofos].acquire();
				// Ya hemos terminado de comer, por lo tanto, liberamos los tenedores
				tenedores[id].release();
				tenedores[(id+1)%nFilosofos].release();
				
				// Liberamos el acceso para que otro filósofo pueda intentar comer
				acceso.release();
			}
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
}
