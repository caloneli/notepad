import java.awt.Color;

public class Function_Color {

    GUI gui;
    public Function_Color(GUI gui){
        this.gui = gui;

    }
    public void changeColor(String color){
        switch(color){
            case "White": 
            gui.window.getContentPane().setBackground(Color.white);
            gui.textArea.setBackground(Color.white); //pozadina
            gui.textArea.setForeground(Color.black); //font color
            break;
            case "Black": 
            gui.window.getContentPane().setBackground(Color.black);
            gui.textArea.setBackground(Color.black); //pozadina
            gui.textArea.setForeground(Color.white); //font color
            break;
            case "Blue": 
            gui.window.getContentPane().setBackground(Color.blue);
            gui.textArea.setBackground(Color.blue); //pozadina
            gui.textArea.setForeground(Color.white); //font color
            break;

            case "CoolColor": 
            gui.window.getContentPane().setBackground(new Color(0,204,204));
            gui.textArea.setBackground(new Color(0,204,204)); //pozadina
            gui.textArea.setForeground(Color.black); //font color
            break;
            
        }

    }

    
}
