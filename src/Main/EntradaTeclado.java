package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class EntradaTeclado implements KeyListener{
    public boolean cimaPress, esqPress, baixoPress, dirPress;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();

        if(codigo == KeyEvent.VK_W){
            cimaPress = true;
        }
        if(codigo == KeyEvent.VK_A){
            esqPress = true;
        }
        if(codigo == KeyEvent.VK_S){
            baixoPress = true;
        }
        if(codigo == KeyEvent.VK_D){
            dirPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int codigo = e.getKeyCode();

        if(codigo == KeyEvent.VK_W){
            cimaPress = false;
        }
        if(codigo == KeyEvent.VK_A){
            esqPress = false;
        }
        if(codigo == KeyEvent.VK_S){
            baixoPress = false;
        }
        if(codigo == KeyEvent.VK_D){
            dirPress = false;
        }
    }
    
}
