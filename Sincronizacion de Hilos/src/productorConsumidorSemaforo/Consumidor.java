package productorConsumidorSemaforo;

public class Consumidor extends Thread 
{ 
    Cola cola; 
    int nVeces;
    Consumidor(Cola cola, String name, int nVeces) 
    { 
        this.cola = cola;
        this.setName(name);
        this.nVeces = nVeces;
    } 
  
    public void run() 
    { 

    	for (int i = 0; i < nVeces; i++)
        {
            cola.get(getName());
            try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    } 
} 

