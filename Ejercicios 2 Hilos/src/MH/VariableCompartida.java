package MH;


public class VariableCompartida 
{
	 public static volatile int turno = 0;
	 private int var;
	 public VariableCompartida(int i) {
	  var = i;
	 }
	 
	 public void set(int i) {
	  var = i;
	 }
	 public int get() {
	  return var;
	 }
	 public void inc() {
	  var++;
	 }
	 public static void incTurno() {
	  turno = (turno+1)%2;
	 }
	 public static int getTurno() {
	  return turno;
	 }
}

