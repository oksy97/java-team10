import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BeforeGame extends JPanel {

	private JLabel play, exit; //��ư�뵵�� �� ��
	private ImageIcon BGImage, playImage, exitImage; //����̹����� ���� �� ��ư�뵵�� �󺧵��� ���� �̹�����
	private ButtonListener buttonL;//��ưŬ��ȿ���� ���� ���콺 ������
	//RoomPanel room;
	private JPanel primarypanel;	//������ ���� Primary�г��� ���۷������� ���� ��ü
	
	public BeforeGame(JPanel primary)
	{
		primarypanel= primary;
		
		this.setBounds(0,0,1200,900);
		this.setLayout(null);
		
		buttonL= new ButtonListener();
		
		BGImage= new ImageIcon("BeforGame/BGImage.jpg");
		playImage= new ImageIcon("BeforGame/Play.png");
		exitImage= new ImageIcon("BeforGame/Exit.png");
		
		play= new JLabel();	//��ư�뵵�� �� ����~line 39
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
	
	public void paintComponent(Graphics page)	//����̹���
	{
		super.paintComponent(page);
		page.drawImage(BGImage.getImage(),0,0,null);
		
	}
	
	public void GoGamePanel()	//�÷��� ��ư Ŭ���� RoomPanel�� ����ü ����~line54
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
				try {		//ȿ���� ���
					SoundPlayer.ButtonSound();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				GoGamePanel();	//RoomPanel�� ����ü�� �����ϱ� ���� �޼ҵ� ȣ��
				
			}
			
			else if(obj==exit)
			{
				try {	//ȿ���� ���
					SoundPlayer.ButtonSound();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.exit(1);	//Application ����
				
			}
			
			
		}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}
	
}
