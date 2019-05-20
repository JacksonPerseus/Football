import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Music{
    public Music(){
    }
    public static void playStartSound(File sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch(Exception e){
            System.out.println("Fuck it!");
        }
    }
    public static void playGoalSound(File sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch(Exception e){
            System.out.println("Fuck it!");
        }
    }
    public static void playOutSound(File sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch(Exception e){
            System.out.println("Fuck it!");
        }
    }
}