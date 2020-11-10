package Hilos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class Main extends JFrame   
{
	//Atributos
	private static JPanel etiqueta;
	private static JPanel panel2;
	private static JPanel panel3;
	private JButton iniciar;
	private static int[] array,array2,array3;
	
	
	public Main() 
	{
		iniciarComponentes();
	}
	
	private void iniciarComponentes()
	{
		//Inicializamos los atributos
		etiqueta = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		iniciar = new JButton();
		array = new int[20];
		array2 = new int[21];
		array3 = new int[21];
		for(int i = 1; i<array.length; i++) {
			array[i] = (int)(Math.random()*100);
		}
		array2 = array;
		array3 = array;
		
		
		iniciar.setText("Iniciar");
		iniciar.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt)
			{
				try {
					iniciarMouseClicked(evt);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,600,500);
		setTitle("Sorting Algorithym");
		
		 etiqueta.setBorder(javax.swing.BorderFactory.createLineBorder(null));

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(etiqueta);
	        etiqueta.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 112, Short.MAX_VALUE)
	        );
	        
	        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(null));

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
	        panel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	        		jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        jPanel2Layout.setVerticalGroup(
	        		jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 112, Short.MAX_VALUE)
	        );
	        panel3.setBorder(javax.swing.BorderFactory.createLineBorder(null));

	        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panel3);
	        panel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	        		jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        jPanel3Layout.setVerticalGroup(
	        		jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 112, Short.MAX_VALUE)
	        );
	        
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
					layout.createParallelGroup(GroupLayout.Alignment.LEADING)					
					.addGroup(layout.createSequentialGroup())
						.addComponent(etiqueta, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
						.addComponent(iniciar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				);
		
		layout.setVerticalGroup( 
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup( layout.createSequentialGroup()
				.addGap(79, 79, 79)
				.addComponent(etiqueta,GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				.addGap(72, 72, 72)
				.addComponent(panel2,GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				.addGap(72, 72, 72)
				.addComponent(panel3,GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				.addGap(72, 72, 72)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(iniciar)			
		)));
		pack();
		
		etiqueta.setLayout(new GridLayout(1,21));
		for(int i=0; i<array.length;i++) {
			JButton boton = new JButton(""+array[i]);
			this.etiqueta.add(boton);
		}
		
		panel2.setLayout(new GridLayout(1,21));
		for(int i=0; i<array2.length;i++) {
			JButton boton = new JButton(""+array2[i]);
			this.panel2.add(boton);
		}
		panel3.setLayout(new GridLayout(1,21));
		for(int i=0; i<array3.length;i++) {
			JButton boton = new JButton(""+array3[i]);
			this.panel3.add(boton);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private void iniciarMouseClicked(MouseEvent evt) throws InterruptedException 
	{
		HiloBurbuja h1 = new HiloBurbuja(etiqueta, array);
		h1.start();
		HiloInsercion h2 = new HiloInsercion(panel2, array2);
		h2.start();
		HiloSeleccion h3 = new HiloSeleccion(panel3,array3);
		h3.start();
	}

}
