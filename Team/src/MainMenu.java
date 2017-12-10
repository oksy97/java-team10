import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MainMenu extends JPanel {
	
	private JPanel primarypanel;		//업콜을 위해 primary의 레퍼런스를 담을 JPanel 객체
	private ImageIcon BGImage;			//메인메뉴의 배경이미지
	private ImageIcon StartImage, ExitImage; 	//메인메뉴 버튼들의 이미지
	private MainMenuListener mml = new MainMenuListener (); 		//버튼 액션 리스너
	private JButton StartButton, ExitButton;		//시작버튼과 종료버튼 이미지
	//private BeforeGame beforegame;
	
	public MainMenu(JPanel primary)
	{
		
		primarypanel=primary;		//primary 의 레퍼런스 복사
		this.setPreferredSize(new Dimension(1200,900));	//1200X900로 셋팅
		this.setBounds(0, 0, 1200, 900);
		this.setLayout(null);
		setBackground(Color.WHITE);
		BGImage = new ImageIcon("images/Mainmenu.jpg"); //이미지들 생성
		StartImage = new ImageIcon("images/Start.png");
		ExitImage = new ImageIcon("images/Exit.png");
		
		
		StartButton= new JButton();	//시작버튼과 종료버튼 생성
		ExitButton= new JButton();
		
		StartButton.setIcon(StartImage);
		StartButton.setBounds(466,606,269,104);
		StartButton.setOpaque(false);	//버튼의 테두리, 배경색 등을 비활성화 ~line35
		StartButton.setContentAreaFilled(false);
		StartButton.setBorderPainted(false);
		StartButton.addActionListener(mml);	//버튼 액션리스너 add
		this.add(StartButton);
		
		ExitButton.setIcon(ExitImage);
		ExitButton.setBounds(466,750,269,104);
		ExitButton.setOpaque(false);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setBorderPainted(false);
		ExitButton.addActionListener(mml);//버튼 액션리스너 add

		this.add(ExitButton);
		
		
	}
	
public void GoBeforRoomPanel()	//다음 메뉴인 게임테마 설명으로 이동하기 위해 현재 패널을 setVisible(false), 
{								// primary패널에 BeforeGame의 무명객체 생성
	this.setVisible(false);
	primarypanel.add(new BeforeGame(primarypanel));
}
	
public void paintComponent(Graphics page) {    
									//배경이미지 
	super.paintComponent(page);	
	page.drawImage(BGImage.getImage(), 0, 0, null);
	
	
	}

public class MainMenuListener implements ActionListener
{
	public void actionPerformed (ActionEvent event)
	{
		Object obj = event.getSource();
		
		if(obj==StartButton)
		{
			try {	//버튼 클릭시 효과음 재생
				SoundPlayer.ButtonSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GoBeforRoomPanel();	//게임 테마 설명 메뉴 이동 메소드 호출 
			
			//StartButton.stop();
		
			
		}
		
		else if(obj==ExitButton)
		{
			try {		//버튼 클릭시 효과음 재생
				SoundPlayer.ButtonSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.exit(0);		//Application 종료
			
		}
		
	}
	
}
}
