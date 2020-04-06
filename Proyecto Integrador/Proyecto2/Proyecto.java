import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import java.io.IOException;
import java.io.File;  
 public class Proyecto extends JFrame implements ActionListener
{
    private JButton btnSong, btnT, btnPlay, btnPause, btnStop, btnResume;//todos los botones
    private JPanel panel;//panel para poner la imagen y los bontones
    long songFrame; //el tiempo en microsegundos del audio
    Clip clip;// para el audio
    AudioInputStream audioInputStream;//para el audio
    static String filePath;//nombre del en la computadora
     public static void main()
    {
        
        Proyecto frame = new Proyecto(); //frame para poner todo el interfaz      
        frame.setBounds(200,200,450,450);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Leer Musica");        
        frame.Interfaz();
        frame.setVisible(true); 
         
        
        
       
    }
      
    public void Interfaz()
     {      
        Color Word = new Color(255,127,80);//el color de las palabras
        
        Container holder = getContentPane();//container del imagen del background
        holder.setLayout(null);
     
        
        ImageIcon image = new ImageIcon("Notes.jpg");  //imagen del background  
        JLabel imageLabel = new JLabel(image); 
        imageLabel.setBounds(0, 0, 450, 450);
        imageLabel.setVisible(true);
        holder.add(imageLabel); //poner imagen en el contenador
           
        btnSong = new JButton("Ode to Joy"); //boton que abre la pieza de musica
        btnSong.setFont(new Font("Trajan", Font.BOLD, 14));
        btnSong.setForeground(Word);  //'Word' es el objeto del clase color     
        btnSong.setLayout(null);
        btnSong.setBounds(160,100,100,50);
        btnSong.addActionListener(this);
        imageLabel.add(btnSong);
           
        btnT = new JButton("Terminos Musicales"); //boton que abre la ventana de informacion
        btnT.setFont(new Font("Trajan", Font.BOLD, 14));
        btnT.setForeground(Word);
        btnT.setLayout(null);
        btnT.setBounds(120,170,180,50);
        btnT.addActionListener(this);
        imageLabel.add(btnT);
        
                     
    }
    
      public void actionPerformed(ActionEvent e)
      {
        if (e.getSource() == btnT)
        {
            InfoFrame();
        }
          else if (e.getSource() == btnSong)
        {
           SongFrame();//funcionalidad al boton que dice 'Ode to Joy'
         }
         else 
         
             if (e.getSource() == btnPlay)
          {
             AudioPlayer();//funcionalidad al boton que empieza la cancion          
          }
        else 
            if (e.getSource() == btnStop)
        {
            AudioStop();//funcionalidad al boton que se para la cancion
        }
        else
             if  (e.getSource() == btnPause)
        {
            AudioPause();//funcionalidad al boton que pausa la cancion
        }
        
        else 
        {
            AudioResume();//funcionalidad al boton que continua la musica
        }
      }     
      private void SongFrame () 
         {
         Color Word = new Color(255,127,80);//Color de las palabras de los botones de nuevo
         JFrame songFrame = new JFrame("Ode to Joy");//frame para poner la imagen
         songFrame.setSize(600,800);
         songFrame.setLocationRelativeTo(null);
         
         ImageIcon image = new ImageIcon("Ode to JoySC2.jpg");    
         JLabel imageLabel = new JLabel(image); 
         imageLabel.setBounds(10, 10, 400, 400);
         imageLabel.setVisible(true);
         songFrame.add(imageLabel);
         songFrame.setResizable(false);//para que el usuario no puede cambiar el tamano de la ventana
         songFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
         songFrame.setVisible(true);
         
        btnPlay = new JButton("Reproduce");//boton para poner la musica
        btnPlay.setFont(new Font("Trajan", Font.BOLD, 14));
        btnPlay.setForeground(Word);
        btnPlay.setLayout(null);
        btnPlay.setBounds(100,550,90,50);
        btnPlay.addActionListener(this);
        imageLabel.add(btnPlay);  //agrega los botones sobre la imagen           
        
        btnPause = new JButton("Pausa");//boton que pausa la musica
        btnPause.setFont(new Font("Trajan", Font.BOLD, 14));
        btnPause.setForeground(Word);
        btnPause.setLayout(null);
        btnPause.setBounds(200,550,90,50);
        btnPause.addActionListener(this);
        imageLabel.add(btnPause); 
        
        btnStop = new JButton("Detener");//boton que para la musica
        btnStop.setFont(new Font("Trajan", Font.BOLD, 14));
        btnStop.setForeground(Word);
        btnStop.setLayout(null);
        btnStop.addActionListener(this);
        btnStop.setBounds(300,550,90,50);
        imageLabel.add(btnStop); 
        
        btnResume = new JButton("Reanudar");//boton que continua la musica
        btnResume.setFont(new Font("Trajan", Font.BOLD, 14));
        btnResume.setForeground(Word);
        btnResume.setLayout(null);
        btnResume.addActionListener(this);
        btnResume.setBounds(400,550,90,50);
        imageLabel.add(btnResume);
       }
      
      public void AudioPlayer() 
         {
             try 
              {
              filePath = "OTJ.wav";//nombre del audio en la conputadora
              audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
              clip = AudioSystem.getClip();
              clip.open(audioInputStream);//abrir el audio
              clip.start(); //poner el audio
              clip.loop(Clip.LOOP_CONTINUOUSLY);//para que el audio sigue continuamente
              
                      
               }
              catch (UnsupportedAudioFileException e) 
               {
                e.printStackTrace();
                System.out.println("Unsupported Audio File.");//para que aparece un error si el audio no es soportado
               } 
               catch (IOException e) 
               {
                  e.printStackTrace();
                  System.out.println("ERROR");
                } 
                catch (LineUnavailableException e) 
               {
                 e.printStackTrace();
                 System.out.println("ERROR");
               }              
      } 
      
      public void AudioStop()
        {
            clip.stop();
        }
        
      public void AudioPause()
       {
          songFrame = clip.getMicrosecondPosition(); 
          clip.stop(); 
      }
      
      public void AudioResume()
      { 
        clip.setMicrosecondPosition(songFrame);  
        clip.start();
      }
      private void InfoFrame()
      {
         JFrame infoFrame = new JFrame("Informacion");//frame para poner la imagen
         infoFrame.setSize(600,700);        
         infoFrame.setLocationRelativeTo(null);
         infoFrame.getContentPane().setBackground(Color.white);
          
         ImageIcon image = new ImageIcon("Info3.psd");    
         JLabel imageLabel = new JLabel(image);
         imageLabel.setBounds(0,0,500,600);
         imageLabel.setVisible(true);        
         infoFrame.add(imageLabel);
         infoFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
         infoFrame.setVisible(true);
      }
} 

        
      
        




  
