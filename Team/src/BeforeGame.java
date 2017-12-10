import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BeforeGame extends JPanel {

	private JLabel play, exit; //버튼용도로 쓸 라벨
	private ImageIcon BGImage, playImage, exitImage; //배경이미지와 위의 각 버튼용도의 라벨들을 위한 이미지들
	private ButtonListener buttonL;//버튼클릭효과를 위한 마우스 리스너
	//RoomPanel room;
	private JPanel primarypanel;	//업콜을 위해 Primary패널의 레퍼런스값을 갖는 객체
	
	public BeforeGame(JPanel primary)
	{
		primarypanel= primary;
		
		this.setBounds(0,0,1200,900);
		this.setLayout(null);
		
		buttonL= new ButtonListener();
		
		BGImage= new ImageIcon("BeforGame/BGImage.jpg");
		playImage= new ImageIcon("BeforGame/Play.png");
		exitImage= new ImageIcon("BeforGame/Exit.png");
		
		play= new JLabel();	//버튼용도의 라벨 생성~line 39
		play.setIcon(playImage);
		play.setBounds(317,776,256,99);
		play.addMouseListener(buttonL);
		this.add(play);
		
		
		exit= new JLabel();
		exit.setIcon(exitImage);
		exit.setBounds(628,776,256,99);
		exit.addMouseListener(buttonL);
		this.add(exit);
		
		this.setVisible(true);
		
	}
	
	public void paintComponent(Graphics page)	//배경이미지
	{
		super.paintComponent(page);
		page.drawImage(BGImage.getImage(),0,0,null);
		
	}
	
	public void GoGamePanel()	//플레이 버튼 클릭시 RoomPanel의 무명객체 생성~line54
	{
		this.setVisible(false);
		primarypanel.add(new RoomPanel(primarypanel));
	}
	
	public class ButtonListener implements MouseListener
	{
		
		
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {
			Object obj=event.getSource() ;
			
			if (obj==play)
			{
				try {		//효과음 재생
					SoundPlayer.ButtonSound();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				GoGamePanel();	//RoomPanel의 무명객체를 생성하기 위한 메소드 호출
				
			}
			
			else if(obj==exit)
			{
				try {	//효과음 재생
					SoundPlayer.ButtonSound();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.exit(1);	//Application 종료
				
			}
			
			
		}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}
	
}
