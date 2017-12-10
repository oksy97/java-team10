import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MainMenu extends JPanel {
	
	private JPanel primarypanel;		//������ ���� primary�� ���۷����� ���� JPanel ��ü
	private ImageIcon BGImage;			//���θ޴��� ����̹���
	private ImageIcon StartImage, ExitImage; 	//���θ޴� ��ư���� �̹���
	private MainMenuListener mml = new MainMenuListener (); 		//��ư �׼� ������
	private JButton StartButton, ExitButton;		//���۹�ư�� �����ư �̹���
	//private BeforeGame beforegame;
	
	public MainMenu(JPanel primary)
	{
		
		primarypanel=primary;		//primary �� ���۷��� ����
		this.setPreferredSize(new Dimension(1200,900));	//1200X900�� ����
		this.setBounds(0, 0, 1200, 900);
		this.setLayout(null);
		setBackground(Color.WHITE);
		BGImage = new ImageIcon("images/Mainmenu.jpg"); //�̹����� ����
		StartImage = new ImageIcon("images/Start.png");
		ExitImage = new ImageIcon("images/Exit.png");
		
		
		StartButton= new JButton();	//���۹�ư�� �����ư ����
		ExitButton= new JButton();
		
		StartButton.setIcon(StartImage);
		StartButton.setBounds(466,606,269,104);
		StartButton.setOpaque(false);	//��ư�� �׵θ�, ���� ���� ��Ȱ��ȭ ~line35
		StartButton.setContentAreaFilled(false);
		StartButton.setBorderPainted(false);
		StartButton.addActionListener(mml);	//��ư �׼Ǹ����� add
		this.add(StartButton);
		
		ExitButton.setIcon(ExitImage);
		ExitButton.setBounds(466,750,269,104);
		ExitButton.setOpaque(false);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setBorderPainted(false);
		ExitButton.addActionListener(mml);//��ư �׼Ǹ����� add

		this.add(ExitButton);
		
		
	}
	
public void GoBeforRoomPanel()	//���� �޴��� �����׸� �������� �̵��ϱ� ���� ���� �г��� setVisible(false), 
{								// primary�гο� BeforeGame�� ����ü ����
	this.setVisible(false);
	primarypanel.add(new BeforeGame(primarypanel));
}
	
public void paintComponent(Graphics page) {    
									//����̹��� 
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
			try {	//��ư Ŭ���� ȿ���� ���
				SoundPlayer.ButtonSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GoBeforRoomPanel();	//���� �׸� ���� �޴� �̵� �޼ҵ� ȣ�� 
			
			//StartButton.stop();
		
			
		}
		
		else if(obj==ExitButton)
		{
			try {		//��ư Ŭ���� ȿ���� ���
				SoundPlayer.ButtonSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.exit(0);		//Application ����
			
		}
		
	}
	
}
}
