import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;

public class Initializer {
    JWindow window;
    Game game;
    Desktop desktop;
    Path installPath = Paths.get("GameCollection.exe");



    public Initializer() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Initializer().buildGUI();;

    }

    void buildGUI(){
        try {
            playSound();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JWindow window = new JWindow();
        window.getContentPane().add(
                new JLabel("", new ImageIcon(getClass().getResource("img/misc/loading_main.png")), SwingConstants.CENTER));
        window.setBounds(50, 200, 1200, 300);
        window.setVisible(true);


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        window.setVisible(false);window.setVisible(false);
        System.out.println("This is reachable");
        game = new Game();
        System.exit(0);
    }

    public void playSound()throws LineUnavailableException, UnsupportedAudioFileException, IOException{


        try
        {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("soundtrack/Taliban.mp3"));
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
        }

        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1)
        {
            e1.printStackTrace();
        }
    }



}
