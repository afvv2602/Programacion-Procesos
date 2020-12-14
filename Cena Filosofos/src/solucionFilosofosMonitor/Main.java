package solucionFilosofosMonitor;

public class Main 
{
        public static void main(String[] args) 
        {
                int NUM_PROCESOS=5;
                                
                Monitor gestorPalillos = new Monitor(NUM_PROCESOS);
                Filosofo filosofos[] = new Filosofo[NUM_PROCESOS];
                Thread hilos[]=new Thread[NUM_PROCESOS];
                
                for (int i=1; i<NUM_PROCESOS; i++)
                {
                	//Le da el monitor y la posicion de dos palillos 
                	//La posicion del palillo derecho i y del izquierdo i-1
                        filosofos[i] = new Filosofo(gestorPalillos, i, i-1);
                        //Se crea un nuevo hilo con la posicion de los filosofos
                        hilos[i] = new Thread(filosofos[i]);
                        hilos[i].start();
                }
                //Haces el set a mano del filosofo 0 estableciendole los valores 0 y 4
                filosofos[0] = new Filosofo(gestorPalillos, 0, 4);
                hilos[0] = new Thread(filosofos[0]);
                hilos[0].start();
        } 
}

