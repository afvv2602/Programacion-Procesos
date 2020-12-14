package solucionFilosofosMonitor;

import java.util.concurrent.ThreadLocalRandom;

public class Filosofo implements Runnable
{
    Monitor gestorPalillos;
    int posPalilloIzqquierdo,posPalilloDerecho;
    
    public Filosofo(Monitor gestorPalillos, int palilloIzquierdo, int palilloDerecho)
    {
            this.gestorPalillos=gestorPalillos;
            this.posPalilloDerecho=palilloDerecho;
            this.posPalilloIzqquierdo=palilloIzquierdo;
    }
    
    public void run() 
    {
        boolean palillosCogidos;
        while (true)
        {
        	//Comprobamos si podemos coger los palillos
        	palillosCogidos = this.gestorPalillos.intentarCogerPalillos(posPalilloIzqquierdo, posPalilloDerecho);
        	//Si los coge entonces come y libera los palillos 
            if (palillosCogidos)
            {
                    comer();//Nos damos un atracón de comer
                    this.gestorPalillos.liberarPalillos(posPalilloIzqquierdo, posPalilloDerecho);
                    dormir();//Después de un buen banquete, nos echamos una siesta.
            } 
        }
    }

    private void comer() 
    {
            System.out.println("Filosofo "+ Thread.currentThread().getName()+" comiendo");
            esperarTiempoAzar();
    }
    
    private void esperarTiempoAzar() 
    {
    		//Aunque aparezca la palabra Thread, nos permite generar un número aleatorio en un rango determinado
    		int milisegundosAlAzar = ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
            try 
            {
                    Thread.sleep(milisegundosAlAzar);
            }
            catch (InterruptedException ex) 
            {
                    System.out.println("Fallo la espera");
            }
    }
    
    private void dormir()
    {
            System.out.println("Filosofo "+  Thread.currentThread().getName()+  " zzZZZZZ");
            esperarTiempoAzar();
    }
}