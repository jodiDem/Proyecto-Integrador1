import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;
public class Ventana1 extends JFrame
{  
    public Ventana1()
    {
       Toolkit window = Toolkit.getDefaultToolkit();
        
       Dimension windowSize = window.getScreenSize();
       int heightWindow = windowSize.height;
       int widthWindow = windowSize.width;
       
       setSize(heightWindow, widthWindow);
       Lamina lamina1 = new Lamina();
       lamina1.setVisible(true);
       add(lamina1);
       
       
       
       
       
    }
}
