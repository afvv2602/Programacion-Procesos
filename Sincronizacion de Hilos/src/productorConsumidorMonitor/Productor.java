
package productorConsumidorMonitor;


public class Productor extends Thread
{
	private Monitor monitor;
	private int nVeces;
	private String name;
	public Productor(Monitor monitor, int n,String cadena) 
	{
		this.monitor = monitor;
		this.nVeces = n;
		this.name = cadena;
	}
	public void run() 
	{
		for (int i = 0; i < nVeces; i++)
		{
			System.out.println("El productor"+name+" ha producido: " + i);
			monitor.put(name,i);
			try 
			{
				sleep(100);
			}
			catch (InterruptedException e) { }
		}
	}
}
