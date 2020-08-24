import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;


public class BasicMediaPlayer {

    public static void main(String[] args) {
        EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();

        JFrame f = new JFrame();
        f.setContentPane(component);
        f.setBounds(new Rectangle(200,200,800,600));
        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                //component.release();
                System.exit(0);
            }

        });

        f.setVisible(true);

        component.mediaPlayer().media().play("C:\\Users\\Yukawa\\Videos\\MazeSolver_1.mp4");
    }

}
