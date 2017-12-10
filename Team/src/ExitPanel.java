import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JPanel;

public class ExitPanel extends JPanel { // JPanel�� ��ӹ���
	//private JPanel ThisPanel; //X��ư ������ ����� �г��� setVisible(false)�� �Ǳ� ���� ���� �г� �ּ� ���縦 ���� temper �г�
	// instance data
	private ImageIcon background; // ����̹����Դϴ�.
	private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8,
						icon9, icon0, iconCancle, iconOK; // ������� ǥ�õ� ����� ��ư �̹�����
	private ImageIcon Xbutton;//������� ǥ�õ� x��ư�̹���	
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
					btnCancle, btnOK; // �������ư�Դϴ�
	private JButton BXbutton;// �̺�Ʈ�ڵ鸵���� ����� ��ư	
	
	private JLabel lbl[][]=new JLabel[4][10]; //������� ǥ�õ� �̹������� �󺧷�
	private ImageIcon box[]= new ImageIcon[10];//��й�ȣ �̹�����
	private BoxListener boxl; 
	
	private int nInput[]=new int [4]; //�Է¹޴� ��й�ȣ 4�ڸ� 
	private int nAnser[]= {3,5,0,7}; //��й�ȣ ����
	private RoomPanel roompanel;
	private RankPanel rankpanel;
	private JPanel primarypanel;

	
	private ThreadTimer timerlabel;
	private File f;
	private BufferedWriter bw;
	private FileWriter fw;
	// method
	public ExitPanel(JPanel primary,RoomPanel room,ThreadTimer timer) {
		
		primarypanel=primary;
		roompanel=room;
		timerlabel=timer;
			
		init();
	} // UserPanel() - �гο� ���� �̸� ������
	
	private void init() {

		//ThisPanel=this; //X��ư ������ ����� �г��� setVisible(false)�� �Ǳ� ���� ���� �г� �ּ� ����
		
		this.setBounds(0, 0, 1200, 900);
		//setPreferredSize(new Dimension(1200, 900));
		setBackground(Color.white);
		setLayout(null);
		
		background = new ImageIcon("ETC/EXITBGImage.jpg");//��� �̹���

		icon1 = new ImageIcon("DoorLock/1.png");//����� ����1
		btn1 = new JButton();

		icon2 = new ImageIcon("DoorLock/2.png");//����� ����2
		btn2 = new JButton();

		icon3 = new ImageIcon("DoorLock/3.png");//����� ����3
		btn3 = new JButton();

		icon4 = new ImageIcon("DoorLock/4.png");//����� ����4
		btn4 = new JButton();

		icon5 = new ImageIcon("DoorLock/5.png");//����� ����5
		btn5 = new JButton();

		icon6 = new ImageIcon("DoorLock/6.png");//����� ����6
		btn6 = new JButton();

		icon7 = new ImageIcon("DoorLock/7.png");//����� ����7
		btn7 = new JButton();

		icon8 = new ImageIcon("DoorLock/8.png");//����� ����8
		btn8 = new JButton();

		icon9 = new ImageIcon("DoorLock/9.png");//����� ����9
		btn9 = new JButton();

		icon0 = new ImageIcon("DoorLock/0.png");//����� ����0
		btn0 = new JButton();

		iconCancle = new ImageIcon("DoorLock/���.png");//����� ��� ��ư
		btnCancle = new JButton();

		iconOK = new ImageIcon("DoorLock/Ȯ��.png");//����� Ȯ�� ��ư
		btnOK = new JButton();
		
		Xbutton = new ImageIcon("DoorLock/XButton.png"); //����� ȭ�� ���� ��ư
		BXbutton = new JButton();
		
		boxl= new BoxListener(); //����� ��ư�� ���� ������ �ϱ� ���� ������
		
		btn1.setIcon(icon1);
		btn1.setBounds(907, 254, 30, 44);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn1.addActionListener(boxl);
		add(btn1);
		//���� �̹����� ��ġ �����ϰ� ��ư�� ����
		
		btn2.setIcon(icon2);
		btn2.setBounds(981, 254, 30, 44);
		btn2.setOpaque(false);
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		btn2.addActionListener(boxl);
		add(btn2);

		btn3.setIcon(icon3);
		btn3.setBounds(1056, 254, 30, 44);
		btn3.setOpaque(false);
		btn3.setContentAreaFilled(false);
		btn3.setBorderPainted(false);
		btn3.addActionListener(boxl);
		add(btn3);

		btn4.setIcon(icon4);
		btn4.setBounds(907, 353, 30, 44);
		btn4.setOpaque(false);
		btn4.setContentAreaFilled(false);
		btn4.setBorderPainted(false);
		btn4.addActionListener(boxl);
		add(btn4);

		btn5.setIcon(icon5);
		btn5.setBounds(981, 353, 30, 44);
		btn5.setOpaque(false);
		btn5.setContentAreaFilled(false);
		btn5.setBorderPainted(false);
		btn5.addActionListener(boxl);
		add(btn5);

		btn6.setIcon(icon6);
		btn6.setBounds(1056, 353, 32, 45);
		btn6.setOpaque(false);
		btn6.setContentAreaFilled(false);
		btn6.setBorderPainted(false);
		btn6.addActionListener(boxl);
		add(btn6);

		btn7.setIcon(icon7);
		btn7.setBounds(907, 453, 30, 44);
		btn7.setOpaque(false);
		btn7.setContentAreaFilled(false);
		btn7.setBorderPainted(false);
		btn7.addActionListener(boxl);
		add(btn7);

		btn8.setIcon(icon8);
		btn8.setBounds(981, 453, 32, 45);
		btn8.setOpaque(false);
		btn8.setContentAreaFilled(false);
		btn8.setBorderPainted(false);
		btn8.addActionListener(boxl);
		add(btn8);

		btn9.setIcon(icon9);
		btn9.setBounds(1056, 453, 32, 45);
		btn9.setOpaque(false);
		btn9.setContentAreaFilled(false);
		btn9.setBorderPainted(false);
		btn9.addActionListener(boxl);
		add(btn9);

		btn0.setIcon(icon0);
		btn0.setBounds(984, 552, 32, 45);
		btn0.setOpaque(false);
		btn0.setContentAreaFilled(false);
		btn0.setBorderPainted(false);
		btn0.addActionListener(boxl);
		add(btn0);

		btnCancle.setIcon(iconCancle);
		btnCancle.setBounds(897, 568, 57, 28);
		btnCancle.setOpaque(false);
		btnCancle.setContentAreaFilled(false);
		btnCancle.setBorderPainted(false);
		btnCancle.addActionListener(boxl);
		add(btnCancle);

		btnOK.setIcon(iconOK);
		btnOK.setBounds(1046, 568, 56, 28);
		btnOK.setOpaque(false);
		btnOK.setContentAreaFilled(false);
		btnOK.setBorderPainted(false);
		btnOK.addActionListener(boxl);
		add(btnOK);

		BXbutton.setIcon(Xbutton);
		BXbutton.setBounds(1110, 16, 65, 65);
		BXbutton.setOpaque(false);
		BXbutton.setContentAreaFilled(false);
		BXbutton.setBorderPainted(false);
		BXbutton.addActionListener(boxl);
		add(BXbutton);
		// �� �κб����� ������� ǥ�õǴ� ��ư�Դϴ�.

		box[1] = new ImageIcon("Box/Box1.png"); // ��й�ȣ ����1
		box[2] = new ImageIcon("Box/Box2.png"); //��й�ȣ ����2
		box[3] = new ImageIcon("Box/Box3.png");//��й�ȣ ����3
		box[4] = new ImageIcon("Box/Box4.png");//��й�ȣ ����4
		box[5] = new ImageIcon("Box/Box5.png");//��й�ȣ ����5
		box[6] = new ImageIcon("Box/Box6.png");//��й�ȣ ����6
		box[7] = new ImageIcon("Box/Box7.png");//��й�ȣ ����7
		box[8] = new ImageIcon("Box/Box8.png");//��й�ȣ ����8
		box[9] = new ImageIcon("Box/Box9.png");//��й�ȣ ����9
		box[0]= new ImageIcon("Box/Box0.png");//��й�ȣ ����0
	

		for(int i=0;i<4;i++)
		{
			for(int j=0;j<10;j++)
			{
				lbl[i][j]= new JLabel();
				lbl[i][j].setIcon(box[j]);
				switch(i)
				{
				case 0: lbl[i][j].setBounds(70, 345, 153, 153);
						break;
				case 1: lbl[i][j].setBounds(241, 345, 153, 153);
						break;
				case 2: lbl[i][j].setBounds(412, 345, 153, 153);
						break;
				case 3: lbl[i][j].setBounds(583, 345, 153, 153);
						break;
				}//��й�ȣ 4�ڸ� ��ġ ����
				
				lbl[i][j].setOpaque(false);
				lbl[i][j].setVisible(false);
				add (lbl[i][j]);
			}
			
		}
		// ������� 4���ڽ� �̹������Դϴ�.		
	}
	private void Reactivate()
	{
		roompanel.setVisible(true);
		this.setVisible(false);
	}//���� ȭ������ �ٽ� ���ư��� �ְ� �ϱ� ���� �޼ҵ�
	
	private int wheretosetVisible()
	{
		int nCounter =0;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<10;j++)
				{
					if(lbl[i][j].isVisible()==true)	//�� ��(ȭ��� ��)���� isVisible()==true�̸� 
					{								//���� ������ �Ѿ
						nCounter=i+1;
						break;
					}
					
				}
			}//for..			
			return nCounter;	//���� �� ���� ��ȣ�� ��ȯ
	}//�̹������� ���̰� �ϴ� �޼ҵ�
	
	public void paintComponent(Graphics page) { 
		super.paintComponent(page);
		// drawing...
		page.drawImage(background.getImage(), 0, 0, this);
		//�̹��� �׸�
	} // paintComponent()
	
	public void GoRankPanel()
	{
		roompanel.setVisible(false);
		this.setVisible(false);
		rankpanel=new RankPanel(primarypanel);
		primarypanel.add(rankpanel);
	}
	//Ż���ϸ� rankpanel�� ���̵���
	
	private void getsound(int i) //ȿ���� ���
	{
		if(i==1) //1�� ��ư��
		{
			try {
				SoundPlayer.ButtonSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(i==2)
		{		//2�� ���� ȿ���� ���
			try {
				SoundPlayer.WrongAnswerSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else
		{	// ���� ȿ���� ���
			try {
				SoundPlayer.ExitSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public void GoRecord()
	{
		f= new File("Record/RecordforTime.txt");
		try {
			fw= new FileWriter(f,true);
			bw=new BufferedWriter(fw);
			System.out.println(timerlabel.getTime()); //Ż���ϴµ� �ɸ� �ð� ���
			fw.write(timerlabel.getTime()+"\n");//�ɸ� �ð� ���� ����
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}//Ż�� ������ RankPanel�� �̵�(����)
	public class BoxListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object obj = event.getSource();
			getsound(1); // ��ư ȿ���� ���
			int nCounter=0;
			//��ư�� Ŭ���ϸ� �ش� ��ư�� �̹����� ���̵��� �Ѵ�. (���� 0~9����)
			if(obj==btn0)
			{
				nCounter=wheretosetVisible();
				
				lbl[nCounter][0].setVisible(true);
				nInput[nCounter]=0;
			}//���� 0 �̹��� ���̰�
			
			else if(obj==btn1)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][1].setVisible(true);
				nInput[nCounter]=1;
				
			}
			
			else if(obj==btn2)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][2].setVisible(true);
				nInput[nCounter]=2;
				
			}
			
			else if(obj==btn3)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][3].setVisible(true);
				nInput[nCounter]=3;
				
			}
			
			else if(obj==btn4)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][4].setVisible(true);
				nInput[nCounter]=4;
				
			}
			
			else if(obj==btn5)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][5].setVisible(true);
				nInput[nCounter]=5;
				
			}
			
			else if(obj==btn6)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][6].setVisible(true);
				nInput[nCounter]=6;
				
			}
			
			else if(obj==btn7)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][7].setVisible(true);
				nInput[nCounter]=7;
				
			}
			
			else if(obj==btn8)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][8].setVisible(true);
				nInput[nCounter]=8;
				
			}
			
			else if(obj==btn9)
			{
				nCounter=wheretosetVisible();
				lbl[nCounter][9].setVisible(true);
				nInput[nCounter]=9;
				
			}
			
			else if(obj==btnCancle) // ��ҹ�ư ������ �� ����������
			{
				for(int i=0;i<4;i++)
				{
					for(int j=0;j<10;j++)
					{
						lbl[i][j].setVisible(false);
						
					}
					
				}
				
			}
			
			else if(obj==btnOK)//Ȯ�ι�ư
			{
				if((nInput[0]==nAnser[0])&&(nInput[1]==nAnser[1])&&(nInput[2]==nAnser[2])&&(nInput[3]==nAnser[3]))
				{
					GoRecord();
					GoRankPanel();
					getsound(3); //���� ȿ���� ���
				}//��й�ȣ ����� ����� ������
				
				else
				{
					getsound(2);	//����ȿ���� ���
					
					for(int i=0;i<4;i++)
					{
						for(int j=0;j<10;j++)
						{
							lbl[i][j].setVisible(false); //��й�ȣ �ʱ�ȭ
							
						}
						
					}
					
					
				}//Ʋ���� ��й�ȣâ ����
				
			}
			
			else if (obj==BXbutton)
			{
				Reactivate();
								
			}//������ ���� x��ư�� ������ �ٽ� ���� ȭ������ 
			
		}
		
	}
	
}// UserPanel class