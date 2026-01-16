package maze;

import java.net.URL;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

public class Audio {
    Clip clip;
    URL audioURL[] = new URL[30];
    
    // To input the Audio location
    public Audio() {
        audioURL[0] = getClass().getResource("/Audio/SuspenseBGMusic.wav");
        audioURL[1] = getClass().getResource("/Audio/LevelUnlockedSoundEffect.wav");
        audioURL[2] = getClass().getResource("/Audio/KeySoundEffect.wav");
        audioURL[3] = getClass().getResource("/Audio/FinalLvlUnlocked.wav");
        audioURL[4] = getClass().getResource("/Audio/FinalRevelation.wav");
    }
    
    // To allow the audio files to run in the game and loads the audio file from the specified URL
    public void setFile(int i) {
        try {
            
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            
        }catch(Exception e) {
            
        }
         
    }
    
    //To start, loop continuously and stop the audio clip
    public void play() {
        clip.start();
    }
    
    public void loop() {      
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop() {        
        clip.stop();
    }
}
