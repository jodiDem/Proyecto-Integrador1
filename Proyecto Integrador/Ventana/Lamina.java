import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
public class Lamina extends JPanel implements ActionListener
{
    private JButton btnSong,term1,term2, term3, term4, term5, term6;
    private JPanel panel;
     public  void paintComponent(Graphics g) 
    {
      setLayout(null);
      super.paintComponents(g);
      g.setFont(new Font("Hatch Light", Font.BOLD, 18));
      g.drawString("Descripcion del programa", 20, 20);
       
      g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
      g.drawString("Este programa te ayudara aprender leer musica y los terminos musicales en una cancion.", 20, 45);
      
      g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
      g.drawString("Haga clic en el buton 'Ode to Joy' para ver la cancion.", 20, 70);
      
      btnSong = new JButton();
      btnSong.setBounds(10,95,100,30);
      add(btnSong);
      btnSong.setFont(new Font("Hatch Light", Font.PLAIN, 14));
      btnSong.setText("Ode to Joy");
      
      
      btnSong.addActionListener(this);
       
      g.setFont(new Font("Hatch Light", Font.BOLD, 18));
      g.setColor(Color.pink);
      g.drawString("Terminos Musicales en la Cancion:",200,350);
      
      term1 = new JButton();
      term1.setBounds(10,400,100,30);
      add(term1);
      term1.setFont(new Font("Serenity", Font.PLAIN, 14));
      term1.setText("Termino 1");
      term1.setForeground(Color.blue);
      
      term2 = new JButton();
      term2.setBounds(10,440,100,30);
      add(term2);
      term2.setFont(new Font("Serenity", Font.PLAIN, 14));
      term2.setText("Termino 2");
      term2.setForeground(Color.blue);
      
      term3 = new JButton();
      term3.setBounds(10,480,100,30);
      add(term3);
      term3.setFont(new Font("Serenity", Font.PLAIN, 14));
      term3.setText("Termino 3");
      term3.setForeground(Color.blue);
      
      term4 = new JButton();
      term4.setBounds(10,520,100,30);
      add(term4);
      term4.setFont(new Font("Serenity", Font.PLAIN, 14));
      term4.setText("Termino 4");
      term4.setForeground(Color.blue);
      
      term5 = new JButton();
      term5.setBounds(10,560,100,30);
      add(term5);
      term5.setFont(new Font("Serenity", Font.PLAIN, 14));
      term5.setText("Termino 5");
      term5.setForeground(Color.blue);
      
      term6 = new JButton();
      term6.setBounds(10,600,100,30);
      add(term6);
      term6.setFont(new Font("Serenity", Font.PLAIN, 14));
      term6.setText("Termino 6");
      term6.setForeground(Color.blue);
      
    }
  
    public void actionPerformed(ActionEvent e)
    { 
      
     }
}
