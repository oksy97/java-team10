import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel {

	private JLabel replay, exit;	//버튼용도로 쓸 라벨
	private ImageIcon BGImage, replayImage, exitImage; //배경이미지와 위의 각 버튼용도의 라벨들을 위한 이미지들
	private ButtonListener buttonL; //버튼클릭효과를 위한 마우스 리스너
	//RoomPanel room;
	private JPanel primarypanel;//업콜을 위해 Primary패널의 레퍼런스값을 갖는 객체
	
	public GameOver(JPanel primary)
	{
		
		primarypanel= primary;
		
		try {								//게임 오버를 알리는 폭발음 재생
			SoundPlayer.GameOverSound();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setBounds(0,0,1200,900);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		buttonL= new ButtonListener();
		
		BGImage= new ImageIcon("GameOver/GameOver.jpg");		//배경이미지들 생성~line33
		replayImage= new ImageIcon("GameOver/Replay.png");
		exitImage= new ImageIcon("GameOver/Exit.png");
		
		replay= new JLabel();			//버튼 용도의 라벨들 생성 ~line46
		replay.setIcon(replayImage);
		replay.setBounds(317,776,300,110);
		replay.addMouseListener(buttonL);
		this.add(replay);
		
		
		exit= new JLabel();
		exit.setIcon(exitImage);
		exit.setBounds(628,776,300,110);
		exit.addMouseListener(buttonL);
		this.add(exit);
		
		this.setVisible(true);
		
	}
	
	public void paintComponent(Graphics page) //배경이미지
	{
		super.paintComponent(page);
		page.drawImage(BGImage.getImage(),0,0,this);
		
	}
	
	public void GoGamePanel()		//게임 재시작을 위해 RoomPanel의 무명객체 생성
	{
		this.setVisible(false);
		primarypanel.add(new RoomPanel(primarypanel));
	}
	
	public class ButtonListener implements MouseListener	//버튼용도의 라벨들의 이벤트 핸들링을 위한
	{														//마우스 리스너
		
		
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {
			Object obj=event.getSource() ;
			
			if (obj==replay)
			{
				
				GoGamePanel();	//게임 재시작
				
			}
			
			else if(obj==exit)
			{
				System.exit(1);	//Application 종료
				
			}
			
			
		}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}
	
	
	
}
