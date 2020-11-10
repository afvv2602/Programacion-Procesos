package Hilos;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HiloInsercion extends Thread {

	JPanel panel;
	int array[];
	JButton botones[];

	public HiloInsercion(JPanel panel, int[] array) {
		this.panel = panel;
		this.array = array;
	}

	public void run() {
		int j = 0;
		boolean sw = false;
		int tamArray = array.length;
		while (true) {
			for (int i = 1; i <= tamArray - 1; i++) {
				int x = array[i];
				j = i - 1;
				while (j >= 0 && x < array[j]) {
					array[j + 1] = array[j];
					((JButton) this.panel.getComponent(j + 1)).setText("" + array[j]);
					try {
						sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					j = j - 1;
				}
				array[j + 1] = x;
				((JButton) this.panel.getComponent(j + 1)).setText("" + x);
				try {
					sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.panel.getComponent(j).setBackground(Color.cyan);
			}
			if (sw)
				break;
			sw = true;
		}
		this.panel.getComponent(19).setBackground(Color.cyan);
	}
}
