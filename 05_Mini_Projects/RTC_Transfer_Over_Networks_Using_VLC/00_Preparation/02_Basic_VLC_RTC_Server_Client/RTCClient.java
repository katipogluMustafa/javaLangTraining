import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import java.awt.*;

public class RTCClient {

    public static void main(String[] args) {
        String mediatorIP = "192.168.1.104"; short mediatorPort = 6001;
        String publicIP, publicServer, localIP, localServer, clientIP;
        short publicPort, localPort;

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(args);
        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.black);
        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
        mediaPlayer.setVideoSurface(videoSurface);

        JFrame f = new JFrame();
        //f.setIconImage(new ImageIcon(Client.class.getResource("icons/vlcj-logo.png")).getImage());
        f.add(canvas);
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        publicIP = inFromServer.readLine(); // Recv public server's ip from mediator
        publicPort = Short.parseShort(inFromServer.readLine()); // Recv public server's port from mediator
        publicServer = formatRtpStream(publicIP, publicPort);
        System.out.println("Capturing from '" + publicServer + "'");
        f.setTitle("Capturing from Public Server 'rtp://" + publicIP + ":" + publicPort + "'");
        mediaPlayer.playMedia(publicServer);
    }

}
