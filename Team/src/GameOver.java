import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel {

	private JLabel replay, exit;	//��ư�뵵�� �� ��
	private ImageIcon BGImage, replayImage, exitImage; //����̹����� ���� �� ��ư�뵵�� �󺧵��� ���� �̹�����
	private ButtonListener buttonL; //��ưŬ��ȿ���� ���� ���콺 ������
	//RoomPanel room;
	private JPanel primarypanel;//������ ���� Primary�г��� ���۷������� ���� ��ü
	
	public GameOver(JPanel primary)
	{
		
		primarypanel= primary;
		
		try {								//���� ������ �˸��� ������ ���
			SoundPlayer.GameOverSound();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setBounds(0,0,1200,900);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		buttonL= new ButtonListener();
		
		BGImage= new ImageIcon("GameOver/GameOver.jpg");		//����̹����� ����~line33
		replayImage= new ImageIcon("GameOver/Replay.png");
		exitImage= new ImageIcon("GameOver/Exit.png");
		
		replay= new JLabel();			//��ư �뵵�� �󺧵� ���� ~line46
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
	
	public void paintComponent(Graphics page) //����̹���
	{
		super.paintComponent(page);
		page.drawImage(BGImage.getImage(),0,0,this);
		
	}
	
	public void GoGamePanel()		//���� ������� ���� RoomPanel�� ����ü ����
	{
		this.setVisible(false);
		primarypanel.add(new RoomPanel(primarypanel));
	}
	
	public class ButtonListener implements MouseListener	//��ư�뵵�� �󺧵��� �̺�Ʈ �ڵ鸵�� ����
	{														//���콺 ������
		
		
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {
			Object obj=event.getSource() ;
			
			if (obj==replay)
			{
				
				GoGamePanel();	//���� �����
				
			}
			
			else if(obj==exit)
			{
				System.exit(1);	//Application ����
				
			}
			
			
		}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}
	
	
	
}
