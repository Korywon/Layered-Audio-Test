import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class Music {
	File file;
	Clip clip;
	FloatControl volume;
	
	public Music(String fileName) {
		try {
			this.file = new File(fileName);
			this.clip = AudioSystem.getClip();
			this.clip.open(AudioSystem.getAudioInputStream(file));
			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());;
		}
		
	}
	
	/*
	 * plays audio from start
	 */
	public void playSong() {
		this.clip.loop(this.clip.LOOP_CONTINUOUSLY);
		this.clip.start();
	}
	
	/**
	 * Plays song at a certain position.
	 * @param start sets position in microseconds
	 */
	public void playSong(long start) {
		this.clip.loop(this.clip.LOOP_CONTINUOUSLY);
		this.clip.setMicrosecondPosition((long) start);
		this.clip.start();
	}
	
	/**
	 * stops the clip
	 */
	public void stop() {
		this.clip.stop();
	}
	
	/**
	 * closes audio file
	 */
	public void closeAudio() {
		this.clip.close();
	}
	
	/**
	 * Gets gain and returns as volume
	 */
	public float getVolume() {
		volume = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
		return (float) Math.pow(10f, volume.getValue() / 20f);
		
	}
	
	/**
	 * Sets volume from 0 to 1.
	 * @param vol accepts from 0 to 1
	 */
	public void setVolume(float vol) {
		volume = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(20f * (float) Math.log10(vol));
	}
	
	
	public static void main(String[] args) {
		
		Music track1 = new Music("TetrisB1.wav");
		Music track2 = new Music("TetrisB2.wav");
		Music track3 = new Music("TetrisB3.wav");
		Music track4 = new Music("TetrisB4.wav");
		Music track5 = new Music("TetrisB5.wav");
		Music track6 = new Music("TetrisB6.wav");
		Music track7 = new Music("TetrisB7.wav");
		
		Music track8 = new Music("TetrisA1.wav");
		Music track9 = new Music("TetrisA2.wav");
		Music track10 = new Music("TetrisA3.wav");
		Music track11 = new Music("TetrisA4.wav");
		Music track12 = new Music("TetrisA5.wav");
		Music track13 = new Music("TetrisA6.wav");
		Music track14 = new Music("TetrisA7.wav");
		Music track15 = new Music("TetrisFinal.wav");
		
		track1.setVolume(0);
		track2.setVolume(0);
		track3.setVolume(0);
		track4.setVolume(0);
		track5.setVolume(0);
		track6.setVolume(0);
		track7.setVolume(0);
		
		track8.setVolume(0);
		track9.setVolume(0);
		track10.setVolume(0);
		track11.setVolume(0);
		track12.setVolume(0);
		track13.setVolume(0);
		track14.setVolume(0);
		
		track15.setVolume(0);
		
		track1.playSong();
		track2.playSong();
		track3.playSong();
		track4.playSong();
		track5.playSong();
		track6.playSong();
		track7.playSong();
		
		Scanner keyboard = new Scanner(System.in);
		int level = 1;

		System.out.println("TIER 1");
		while (true) {
			System.out.println("LEVEL " + level);
			System.out.print("Increase level: ");
			level += keyboard.nextInt();
			
			switch(level) {
				case 2:
					track1.setVolume(1);
					break;
				case 3:
					track2.setVolume(1);
					break;
				case 4:
					track3.setVolume(1);
					break;
				case 5:
					track4.setVolume(1);
					break;
				case 6:
					track5.setVolume(1);
					break;
				case 7:
					track6.setVolume(1);
					break;
				case 8:
					track7.setVolume(1);
					break;
				case 10:
					System.out.println("TIER 2");
					track1.stop();
					track2.stop();
					track3.stop();
					track4.stop();
					track5.stop();
					track6.stop();
					track7.stop();
					track1.closeAudio();
					track2.closeAudio();
					track3.closeAudio();
					track4.closeAudio();
					track5.closeAudio();
					track6.closeAudio();
					track7.closeAudio();
					
					track8.playSong();
					track9.playSong();
					track10.playSong();
					track11.playSong();
					track12.playSong();
					track13.playSong();
					track14.playSong();
					
					track8.setVolume(1);
					break;
				case 11:
					track9.setVolume(1);
					break;
				case 12:
					track10.setVolume(1);
					break;
				case 13:
					track11.setVolume(1);
					break;
				case 14:
					track12.setVolume(1);
					break;
				case 15:
					track12.stop();
					track13.setVolume(1);
					break;
				case 16:
					track14.setVolume(1);
					break;
				case 18:
					System.out.println("TIER 3");
					track8.stop();
					track9.stop();
					track10.stop();
					track11.stop();
					track12.stop();
					track13.stop();
					track14.stop();
					track8.closeAudio();
					track9.closeAudio();
					track10.closeAudio();
					track11.closeAudio();
					track12.closeAudio();
					track13.closeAudio();
					track14.closeAudio();
					
					track15.setVolume(1);
					track15.playSong((long) 9.5e+7);
			}
			
			
		}
		
	}
	
}
