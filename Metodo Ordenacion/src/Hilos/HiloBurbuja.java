package Hilos;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HiloBurbuja extends Thread {

	JPanel panel;
	int array[];
	JButton botones[];

	public HiloBurbuja(JPanel panel, int[] array) {
		this.panel = panel;
		this.array = array;
	}

	public void run() {
		int i, j, aux;
			for (i = 0; i < array.length - 1; i++) {
				for (j = 0; j < array.length - i - 1; j++) {
					if (array[j + 1] < array[j]) {
						aux = array[j + 1];
						array[j + 1] = array[j];
						((JButton) this.panel.getComponent(j + 1)).setText("" + array[j]);
						array[j] = aux;
						((JButton) this.panel.getComponent(j)).setText("" + aux);

					}
					this.panel.getComponent(j).setBackground(Color.pink);
				}
				this.panel.getComponent(19).setBackground(Color.pink);
			}
		}
}