import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.media.Media;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.component.MediaPlayerComponent;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

public class RTCServer {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Specify a single MRL to stream");
            System.exit(1);
        }

        String media = args[0];
        String publicIP = "224.0.0.0";
        short publicPort = 5555;
        String options = formatRtpStream(publicIP, publicPort);

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(args);
        Media mediaPlayer = mediaPlayerFactory.media().newMedia(media, options, ":no-sout-rtp-sap", ":no-sout-standard-sap", ":sout-all", ":sout-keep");
    }

    private static String formatRtpStream(String serverAddress, short serverPort) {

        StringBuilder sb = new StringBuilder(200);
        //sb.append(":sout=#transcode{acodec=mp4a,samplerate=12000,width=400,height=300}:rtp{dst=");
        //sb.append("::sout=#transcode{vcodec=mp4v,vb=4096,scale=1,fps=30,acodec=mpga,ab=128,channels=2,samplerate=44100,width=800,height=600}:rtp:duplicate{dst=file{dst=");
        sb.append("::sout=#transcode{vcodec=mp4v,vb=3000,fps=30,scale=1,acodec=mp4a,ab=128,channels=2,samplerate=48000,width=800,height=600}:rtp{dst=");

        sb.append(serverAddress);
        sb.append(",port=");
        sb.append(serverPort);
        sb.append(",mux=ts}");
        return sb.toString();
    }
}


