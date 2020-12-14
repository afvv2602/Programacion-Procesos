package CUCUTRASSincronizado;

public class CucuTras 
{
	synchronized void cucu ( boolean running ) 
	{
		if ( !running ) 
		{ 
			notify();
			return;
		}  
		System.out.println ( "Cucu ");
		notify ( );
		try {
			wait ( ); 
		}
		catch ( InterruptedException exc ) {
			System.out.println ( "del Hilo interrumpido  ");
		}
	}
	synchronized void tras ( boolean running ) 
	{
		if (!running)
		{ 
			notify(); 
			return;
		} 
		System.out.println ( "Tras");
		notify ( );
		try 
		{
			wait ( ); 
		}
		catch ( InterruptedException exc ) 
		{
			System.out.println ( "Hilo interrumpido");
		}
	}
}
