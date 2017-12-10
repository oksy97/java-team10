import javax.sound.sampled.*;
import java.io.*;

public class SoundPlayer {

	public static void MainBGM() throws Exception{
		//메인 배경음악을 재생하기 위한 메소드
		Clip mainBGM = AudioSystem.getClip();
		AudioInputStream bgm = AudioSystem.getAudioInputStream(new File("Music/MainBGM.WAV"));
		mainBGM.open(bgm);
		mainBGM.loop(Clip.LOOP_CONTINUOUSLY);	//무한히 재생
	}
	
public static void ButtonSound() throws Exception{
		
	//버튼 클릭시 효과음을 재생하기 위한 메소드
	
		Clip BSound = AudioSystem.getClip();
		AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/클릭.wav"));
		BSound.open(sound);
		BSound.loop(0);
	}

public static void GameOverSound() throws Exception{
	
	//게임 오버 패널등장과 동시에 재생되는 효과음 메소드 
	
	Clip GOSound = AudioSystem.getClip();
	AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/Explosion_Large.WAV"));
	GOSound.open(sound);
	GOSound.loop(0);
}

public static void WrongAnswerSound() throws Exception{
	
	//ExitPanel에서 오답을 입력시 재생되는 효과음 메소드
	
	Clip GOSound = AudioSystem.getClip();
	AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/beep11.wav"));
	GOSound.open(sound);
	GOSound.loop(0);
}

public static void ExitSound() throws Exception{
	
	//ExitPanel에서 정답을 입력시 재생되는 효과음 메소드
	
	Clip GOSound = AudioSystem.getClip();
	AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/applause2.wav"));
	GOSound.open(sound);
	GOSound.loop(0);
}
	
}
