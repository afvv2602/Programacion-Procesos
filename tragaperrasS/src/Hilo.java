import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Hilo extends Thread implements ActionListener{
    JButton rueda,parar;
    boolean activo = true;
    int numero;

   
    Hilo(JButton rueda,JButton parar){
        this.rueda = rueda;
        this.parar = parar;
        
    }
    public int getNumero() {
    	return numero;
	}
    
    public void run(){
       int i = 5;
       int imagen = 0;
        while(activo) {
            String numero = "numero"+i+".png";
            ImageIcon icono = new ImageIcon(".\\imagenes\\"+numero);
            ImageIcon iconoEscalado = new ImageIcon (icono.getImage().getScaledInstance(this.rueda.getWidth(), this.rueda.getHeight(), 0));
            this.rueda.setIcon(iconoEscalado);
            
            if(i==9)
            {
                i=4;
            }
            i++;
            this.numero = i-1;
        } 
       
    }
    
    
    public boolean getActivo() {
    	return activo;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== parar){
            activo = false;
            
        }    
    }
}