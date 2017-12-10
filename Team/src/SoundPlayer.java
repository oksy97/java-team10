import javax.sound.sampled.*;
import java.io.*;

public class SoundPlayer {

	public static void MainBGM() throws Exception{
		//���� ��������� ����ϱ� ���� �޼ҵ�
		Clip mainBGM = AudioSystem.getClip();
		AudioInputStream bgm = AudioSystem.getAudioInputStream(new File("Music/MainBGM.WAV"));
		mainBGM.open(bgm);
		mainBGM.loop(Clip.LOOP_CONTINUOUSLY);	//������ ���
	}
	
public static void ButtonSound() throws Exception{
		
	//��ư Ŭ���� ȿ������ ����ϱ� ���� �޼ҵ�
	
		Clip BSound = AudioSystem.getClip();
		AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/Ŭ��.wav"));
		BSound.open(sound);
		BSound.loop(0);
	}

public static void GameOverSound() throws Exception{
	
	//���� ���� �гε���� ���ÿ� ����Ǵ� ȿ���� �޼ҵ� 
	
	Clip GOSound = AudioSystem.getClip();
	AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/Explosion_Large.WAV"));
	GOSound.open(sound);
	GOSound.loop(0);
}

public static void WrongAnswerSound() throws Exception{
	
	//ExitPanel���� ������ �Է½� ����Ǵ� ȿ���� �޼ҵ�
	
	Clip GOSound = AudioSystem.getClip();
	AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/beep11.wav"));
	GOSound.open(sound);
	GOSound.loop(0);
}

public static void ExitSound() throws Exception{
	
	//ExitPanel���� ������ �Է½� ����Ǵ� ȿ���� �޼ҵ�
	
	Clip GOSound = AudioSystem.getClip();
	AudioInputStream sound = AudioSystem.getAudioInputStream(new File("Music/applause2.wav"));
	GOSound.open(sound);
	GOSound.loop(0);
}
	
}
