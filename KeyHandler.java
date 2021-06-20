import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
public class KeyHandler implements KeyListener{

    GUI gui;
    
    public KeyHandler(GUI gui){
        this.gui = gui;
    }
    
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.saveAs();
        }
        else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.save();
        
        
        }
//EASTER EGG, OVAJ SNIMAK SAM NASAO DOK SAM TRAZIO LOGO FTN-A NA GOOGLE-U 
        if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_E){
            Runtime rt = Runtime.getRuntime();
            String url = "https://www.youtube.com/watch?v=DyP_NbPy4JM";
            try {
                rt.exec("rundll32 url.dll, FileProtocolHandler " + url);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

        if(e.getKeyCode()==KeyEvent.VK_O){
            gui.file.open();
        }
        

        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){
            gui.edit.undo();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    
}
