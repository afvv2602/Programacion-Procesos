package plantillaAlgoritmos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MarcosPlantilla extends JFrame {

	private JPanel panelAlgoritmo1;
	int arrayAlgoritmo1[];

	/**
	 * Create the frame.
	 */
	public MarcosPlantilla() {
		inicializarComponentes();
		iniciarArrays();
	}

	private void inicializarComponentes() {
		// Hay que crear el array con los n�meros.
		int[] array = new int[20];
		//Creamos un narray aleatorio de numeros enteros, hay que tener en cuenta que:
		//random parte de cero y termina en uno, es decir, numeros decimales(double)
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		//Inicializamos el panel donde vamos a visualizar el array de enteros
		//que hemos generado
		panelAlgoritmo1 = new JPanel();
		//Fijamos que nuestro panel sea del mismo tama�o que el array que hemos definido
		panelAlgoritmo1.setLayout(new GridLayout(1,20));
		
		//A�adimos el contenido del array al panel, es decir, le ponemos de etiquetas
		//Los numeros generados
		for (int i = 0; i < array.length; i++) {
			// String aux = ""+
			// JButton boton = new JButton(String.valueOf(array[i]));
			JButton boton = new JButton("" + array[i]);
			this.panelAlgoritmo1.add(boton);
			// Despues habria que poner el panel dentro del layout
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// Hay que poner tanto en horizontal como en vertical el Panel

		// Hay que crear el manejador del bot�n

		// Por �ltimo lo colocamos dentro del layout

	}

	private void iniciarArrays() {
		// Generamos las matrices

		// Las ponemos dentro del panel, es decir, le a�adimos al panel un bot�n con
		// cada valor.
	}

	// M�todo manejador del bot�n, en el que se llamar�n los m�todos que vayamos a
	// ejecutar
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcosPlantilla frame = new MarcosPlantilla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
