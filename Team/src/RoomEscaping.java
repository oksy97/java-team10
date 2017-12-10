import java.awt.*;
import javax.swing.*;



public class RoomEscaping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Room Escaping 10조");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel primary = new JPanel(); 	//프레임 위에 존재하며 앞으로 있을 대부분의 메뉴들의 setVisible(true or false)
										//작업 수행과 다음 메뉴에 해당하는 사용자 정의 패널들을 무명객체로 생성하기 위해  만든 패널
										//Frame의 보조적이 역할을 수행한다고 볼 수 있음
		
		primary.setPreferredSize(new Dimension(1200,900));
		primary.setLayout(null);
		
		try {	//Application 실행과 동시에 배경음악 재생 
			SoundPlayer.MainBGM();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		frame.getContentPane().add(primary);
		
		primary.add(new MainMenu(primary));	//메인메뉴 패널 생성
		
	
		
		frame.pack();
		frame.setVisible(true);		
		
		
		
	}

}


