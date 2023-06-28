import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.LoginWin;

class SoundButton extends JButton {
    private File soundFile;

    public SoundButton(String text) {
        super(text);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playSound();
            }
        });
    }

    private void playSound() {
        try {
        	URL url = TestFrame.class.getResource("/소리모음/test.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }
}

public class TestFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sound Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // SoundButton 생성 및 추가
//        (new ImageIcon(LoginWin.class.getResource("/이미지/가입하기버튼.png")));
        SoundButton soundButton = new SoundButton("Play Sound");
        frame.getContentPane().add(soundButton);
        
        frame.pack();
        frame.setVisible(true);
    }
}