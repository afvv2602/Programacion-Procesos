package productorConsumidorSemaforo;

import java.util.concurrent.Semaphore;

public class Cola 
{ 
	    int elemento; 
	  
	    static Semaphore semaforoConsumidor = new Semaphore(0); 
	    static Semaphore semoforoProductor  = new Semaphore(1); 
	  
	    void get(String name) 
	    { 
	        try 
	        { 
	            semaforoConsumidor.acquire(); //Si hay algunu hilo usando el metodo nadie lo puede usar
	        } 
	        catch (InterruptedException e) 
	        { 
	            System.out.println("InterruptedException caught"); 
	        } 
	  
	        System.out.println("El consumidor"+name+" ha consumido el elemento: " + elemento); 

	        semoforoProductor.release(); // Se libera el hilo para el uso del mismo
	    } 
	  
	    void put(String name, int elemento) 
	    { 
	        try 
	        { 
	            semoforoProductor.acquire(); 
	        } 
	        catch (InterruptedException e) 
	        { 
	            System.out.println("InterruptedException caught"); 
	        } 
	  
	        this.elemento = elemento; 
	  
	        System.out.println("El productor"+name+" ha producido: " + elemento); 
	   
	        semaforoConsumidor.release(); 
	    }  
}
