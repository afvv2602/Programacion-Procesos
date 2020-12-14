package CUCUTRASSincronizado;

public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		CucuTras tt = new CucuTras();
		HiloSincronizado cucu = new HiloSincronizado("Cucu",tt);
		HiloSincronizado tras = new HiloSincronizado("Tras",tt);

		cucu.start();
		tras.start();


	}

}
