package productorConsumidorSemaforo;

public class Productor extends Thread 
{ 
    Cola cola;
    int nVeces;
    Productor(Cola cola,String name,int nVeces) 
    { 
        this.cola = cola;
        this.setName(name);
        this.nVeces = nVeces;
    } 
  
    public void run() 
    { 
        for (int i = 0; i < nVeces; i++) 
        {
            cola.put(this.getName(),i);  
            try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    } 
} 

