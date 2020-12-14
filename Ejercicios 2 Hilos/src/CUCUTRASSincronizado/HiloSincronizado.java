package CUCUTRASSincronizado;

public class HiloSincronizado extends Thread 
{
    Thread thrd;
    CucuTras cucuObj;

   // construye un nuevo hilo
    HiloSincronizado ( String name, CucuTras tt ) 
    {
           thrd= new Thread (name);
           cucuObj= tt;
           thrd.start(); 
  }

	@Override
	public void run() 
	{
        for ( int i=0; i<13; i++ )
        {
        	if (thrd.getName ( ).compareTo ( "Cucu") == 0)
        	{
        		cucuObj.cucu( true );
			}
        	else
        	{
        		cucuObj.tras(true);
			}
        	
        }
        cucuObj.tras( false );
	}
}


