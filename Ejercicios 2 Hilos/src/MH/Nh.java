package MH;

public class Nh extends Thread
{
	 private int vueltas;
	 private VariableCompartida var;
	 
	 public Nh(int i, VariableCompartida v) {
	  vueltas = i;
	  var = v;
	 }
	 
	 public void run() {
	  for(int i = 0; i < vueltas; i++) {
	   var.inc();
	  }
	 }
	 
	 
	 public static void main(String[] args) 
	 {
		  // TODO Auto-generated method stub
		  VariableCompartida variable = new VariableCompartida(0);
		  Nh i1 = new Nh(1000, variable);
		  Nh i2 = new Nh(1000, variable);
		  
		  i1.start();
		  i2.start();
		  
		  try {
		   i1.join();
		   i2.join();
		  } catch(InterruptedException e) {
		   e.printStackTrace();
		   
		  }
		  
		  System.out.println(variable.get());
	 }
}
