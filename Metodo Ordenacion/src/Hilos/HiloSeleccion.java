package Hilos;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HiloSeleccion extends Thread {

	JPanel panel;
	int array[];
	JButton botones[];

	public HiloSeleccion(JPanel panel, int[] array) {
		this.panel = panel;
		this.array = array;
	}

	public void run() {
		for (int i = array.length - 1; i > 0; i--) {
			int maxValue = 0;
			for (int j = 0; j < i; j++) {
				if (array[j + 1] > array[maxValue]) {
					maxValue = j + 1;
				}
			}
			swap(array, i, maxValue);
		}
		this.panel.getComponent(0).setBackground(Color.magenta);
	}

	public void swap(int[] array, int a, int b) {
		int value = array[b];
		array[b] = array[a];
		((JButton) this.panel.getComponent(b)).setText("" + a);
		try {
			sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		array[a] = value;
		((JButton) this.panel.getComponent(a)).setText("" + value);
		try {
			sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (a != b) {
			this.panel.getComponent(b).setBackground(Color.magenta);
			this.panel.getComponent(a).setBackground(Color.magenta);
		} else
			this.panel.getComponent(b).setBackground(Color.magenta);
	}
}
