
package tragaperras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Hilo extends Thread implements ActionListener{
    JButton rueda,parar;
    
   
    Hilo(JButton rueda,JButton parar){
        this.rueda = rueda;
        this.parar = parar;
    }
   
    public void run(){
       int i = 5;
        while( true) {
            String numero = "numero"+i+".png";
            ImageIcon icono = new ImageIcon(".\\imagenes\\"+numero);
            ImageIcon iconoEscalado = new ImageIcon (icono.getImage().getScaledInstance(this.rueda.getWidth(), this.rueda.getHeight(), 0));
            this.rueda.setIcon(iconoEscalado);
            if(i==9)
            {
                i=4;
            }
            i++;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==parar){
            this.stop();
        }    
    }
}