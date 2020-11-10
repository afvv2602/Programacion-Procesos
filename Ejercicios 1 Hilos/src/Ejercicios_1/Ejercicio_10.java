package Ejercicios_1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import relojHilos.Marco;

public class Ejercicio_10 extends JFrame implements Runnable 
{
	//Atributos
	private  JButton iniciar;
	private  JButton reiniciar;
	private  JLabel etiqueta;
	Thread hilo;
	
	/**
	 * Create the frame.
	 */
	public Ejercicio_10() 
	{
		iniciarComponentes();
		reiniciar.setEnabled(false);
	}
	
	private void iniciarComponentes()
	{
		//Inicializamos los atributos
		iniciar = new JButton();
		reiniciar = new JButton();
		etiqueta = new JLabel();
		
		
		//Le decimos que la ventana se va a cerrar cuando el demos al exit y le ponemos un título
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cronometro");
		
		//Indicamos el tipo de fuente y el estilo de borde que vamos a ponerle a la etiqueta
		Font fuente = new Font("Comic Sans MS",1,36);
		SoftBevelBorder borde = new SoftBevelBorder(BevelBorder.RAISED);
		
		
		//Le damos valores a la etiqueta
		etiqueta.setFont(fuente);
		etiqueta.setText("00:00:00");
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setBorder(borde);
		
		//Le damos valores al botón de iniciar
		fuente = new Font("Comic Sans MS",1,18);
		
		iniciar.setFont(fuente);
		iniciar.setText("Iniciar");
		//Añadimos un manejador de eventos, es decir, cuando hagamos click en el botón, haremos algo.
		iniciar.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt)
			{
				iniciarMouseClicked(evt);
			}
		});
		
		reiniciar.setFont(fuente);
		reiniciar.setText("Reiniciar");
		//Añadimos un manejador de eventos, es decir, cuando hagamos click en el botón, haremos algo.
		reiniciar.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent evt)
			{
				reiniciarMouseClicked(evt);
			}
		});
		
		//Vamos a colocar los botones y la etiqueta dentro del Layout
		GroupLayout layout = new GroupLayout(getContentPane());
		//Lo instanciamos
		getContentPane().setLayout(layout);
		
		//Le indicamos los elementos que queremos tener dentro del layout
		layout.setHorizontalGroup( 
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup())
				.addGap(87, 87, 87)
				.addGroup(layout.createSequentialGroup()
					.addComponent(iniciar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
					.addComponent(reiniciar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
				.addComponent(etiqueta,GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(99,Short.MAX_VALUE))
		);
		
		//En el eje vertical, lo que le tenemos que decir es que los botones están en paralelo uno al lado del otro y con un GAP entre ellos
		layout.setVerticalGroup( 
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup( layout.createSequentialGroup()
				.addGap(79, 79, 79)
				.addComponent(etiqueta,GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				.addGap(72, 72, 72)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(iniciar)
					.addComponent(reiniciar))			
				.addContainerGap(71,Short.MAX_VALUE))
		);
		pack();
	}
	
	//Vamos a añadir la tarea del hilo que se va a ejecutar, es decir, el mismo Frame
	@Override
	public void run()
	{
		etiqueta.setText("00:00:00");
		
		int horas,minutos,segundos;
		horas = minutos = segundos = 0;
		
		long milisegundosIniciales = System.currentTimeMillis();
		long milisegundosActuales;
		//Vamos a hacer el mecanismo del contador, es decir, vamos a ver los milisegundos que han pasado desde que se ha iniciado la aplicación
		while (true) 
		{
			//Tiempo que ha pasado desde que le hemos dado a iniciar
			milisegundosActuales = System.currentTimeMillis();
			//60 milisegundos es un segundo, podemos ajustar a más milisegundos
			if (milisegundosActuales - milisegundosIniciales > 50) 
			{
				++segundos;
				if (segundos == 60)
				{
					segundos = 0;
					++minutos;
					if (minutos == 60) 
					{
						minutos = 0;
						++horas;
					}
				}
				milisegundosIniciales = milisegundosActuales;
				//Escribimos el tiempo que ha pasado:
				etiqueta.setText(String.format("%02d:%02d:%02d", horas,minutos,segundos));
			}
		}
	}
	//Inidicamos que hay que hacer cuando se pulsa el botón inciar
	private void iniciarMouseClicked(MouseEvent evt) 
	{
		// Cuando se ha iniciado la aplicación la primera vez, tiene la etiqueta Iniciar
		if (iniciar.getText().equals("Iniciar")) 
		{
			hilo = new Thread(this);
			hilo.start();//Iniciamos el hilo, es decir, reservamos recursos y ejecutamos el run
			iniciar.setText("Parar");
		}
		else
		{
			//Cuando se está ejecutando un botón, deshabilitamos el otro
			reiniciar.setEnabled(true);
			hilo.stop();
			iniciar.setEnabled(false);
		}
	}
	//Decimos lo que hay que hacer cuando se pulsa el botón reiniciar
	private void reiniciarMouseClicked(MouseEvent evt) 
	{
		etiqueta.setText("00:00:00");
		//Reiniciamos el cronómetro a "fuerza bruta"
		hilo = new Thread(this);
		hilo.start();
		iniciar.setEnabled(true);
		reiniciar.setEnabled(false);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					Marco frame = new Marco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
