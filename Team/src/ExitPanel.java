import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JPanel;

public class ExitPanel extends JPanel { // JPanel을 상속받음
	//private JPanel ThisPanel; //X버튼 누를시 도어락 패널이 setVisible(false)가 되기 위해 현재 패널 주소 복사를 위한 temper 패널
	// instance data
	private ImageIcon background; // 배경이미지입니다.
	private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8,
						icon9, icon0, iconCancle, iconOK; // 도어락에 표시될 도어락 버튼 이미지들
	private ImageIcon Xbutton;//도어락에 표시될 x버튼이미지	
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
					btnCancle, btnOK; // 도어락버튼입니다
	private JButton BXbutton;// 이벤트핸들링에서 사용할 버튼	
	
	private JLabel lbl[][]=new JLabel[4][10]; //도어락에 표시될 이미지들을 라벨로
	private ImageIcon box[]= new ImageIcon[10];//비밀번호 이미지들
	private BoxListener boxl; 
	
	private int nInput[]=new int [4]; //입력받는 비밀번호 4자리 
	private int nAnser[]= {3,5,0,7}; //비밀번호 정답
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
	} // UserPanel() - 패널에 대해 미리 설정함
	
	private void init() {

		//ThisPanel=this; //X버튼 누를시 도어락 패널이 setVisible(false)가 되기 위해 현재 패널 주소 복사
		
		this.setBounds(0, 0, 1200, 900);
		//setPreferredSize(new Dimension(1200, 900));
		setBackground(Color.white);
		setLayout(null);
		
		background = new ImageIcon("ETC/EXITBGImage.jpg");//배경 이미지

		icon1 = new ImageIcon("DoorLock/1.png");//도어락 숫자1
		btn1 = new JButton();

		icon2 = new ImageIcon("DoorLock/2.png");//도어락 숫자2
		btn2 = new JButton();

		icon3 = new ImageIcon("DoorLock/3.png");//도어락 숫자3
		btn3 = new JButton();

		icon4 = new ImageIcon("DoorLock/4.png");//도어락 숫자4
		btn4 = new JButton();

		icon5 = new ImageIcon("DoorLock/5.png");//도어락 숫자5
		btn5 = new JButton();

		icon6 = new ImageIcon("DoorLock/6.png");//도어락 숫자6
		btn6 = new JButton();

		icon7 = new ImageIcon("DoorLock/7.png");//도어락 숫자7
		btn7 = new JButton();

		icon8 = new ImageIcon("DoorLock/8.png");//도어락 숫자8
		btn8 = new JButton();

		icon9 = new ImageIcon("DoorLock/9.png");//도어락 숫자9
		btn9 = new JButton();

		icon0 = new ImageIcon("DoorLock/0.png");//도어락 숫자0
		btn0 = new JButton();

		iconCancle = new ImageIcon("DoorLock/취소.png");//도어락 취소 버튼
		btnCancle = new JButton();

		iconOK = new ImageIcon("DoorLock/확인.png");//도어락 확인 버튼
		btnOK = new JButton();
		
		Xbutton = new ImageIcon("DoorLock/XButton.png"); //도어락 화면 끄는 버튼
		BXbutton = new JButton();
		
		boxl= new BoxListener(); //도어락 버튼에 대한 설정을 하기 위한 리스너
		
		btn1.setIcon(icon1);
		btn1.setBounds(907, 254, 30, 44);
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn1.addActionListener(boxl);
		add(btn1);
		//숫자 이미지의 위치 설정하고 버튼을 넣음
		
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
		// 이 부분까지가 도어락에 표시되는 버튼입니다.

		box[1] = new ImageIcon("Box/Box1.png"); // 비밀번호 숫자1
		box[2] = new ImageIcon("Box/Box2.png"); //비밀번호 숫자2
		box[3] = new ImageIcon("Box/Box3.png");//비밀번호 숫자3
		box[4] = new ImageIcon("Box/Box4.png");//비밀번호 숫자4
		box[5] = new ImageIcon("Box/Box5.png");//비밀번호 숫자5
		box[6] = new ImageIcon("Box/Box6.png");//비밀번호 숫자6
		box[7] = new ImageIcon("Box/Box7.png");//비밀번호 숫자7
		box[8] = new ImageIcon("Box/Box8.png");//비밀번호 숫자8
		box[9] = new ImageIcon("Box/Box9.png");//비밀번호 숫자9
		box[0]= new ImageIcon("Box/Box0.png");//비밀번호 숫자0
	

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
				}//비밀번호 4자리 위치 설정
				
				lbl[i][j].setOpaque(false);
				lbl[i][j].setVisible(false);
				add (lbl[i][j]);
			}
			
		}
		// 여기까지 4번박스 이미지라벨입니다.		
	}
	private void Reactivate()
	{
		roompanel.setVisible(true);
		this.setVisible(false);
	}//게임 화면으로 다시 돌아갈수 있게 하기 위한 메소드
	
	private int wheretosetVisible()
	{
		int nCounter =0;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<10;j++)
				{
					if(lbl[i][j].isVisible()==true)	//각 행(화면상 열)별로 isVisible()==true이면 
					{								//다음 행으로 넘어감
						nCounter=i+1;
						break;
					}
					
				}
			}//for..			
			return nCounter;	//다음 빈 행의 번호를 반환
	}//이미지들을 보이게 하는 메소드
	
	public void paintComponent(Graphics page) { 
		super.paintComponent(page);
		// drawing...
		page.drawImage(background.getImage(), 0, 0, this);
		//이미지 그림
	} // paintComponent()
	
	public void GoRankPanel()
	{
		roompanel.setVisible(false);
		this.setVisible(false);
		rankpanel=new RankPanel(primarypanel);
		primarypanel.add(rankpanel);
	}
	//탈출하면 rankpanel이 보이도록
	
	private void getsound(int i) //효과음 재생
	{
		if(i==1) //1은 버튼음
		{
			try {
				SoundPlayer.ButtonSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(i==2)
		{		//2는 오답 효과음 재생
			try {
				SoundPlayer.WrongAnswerSound();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else
		{	// 정답 효과음 재생
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
			System.out.println(timerlabel.getTime()); //탈출하는데 걸린 시간 출력
			fw.write(timerlabel.getTime()+"\n");//걸린 시간 파일 저장
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}//탈출 성공시 RankPanel로 이동(생성)
	public class BoxListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object obj = event.getSource();
			getsound(1); // 버튼 효과음 재생
			int nCounter=0;
			//버튼을 클릭하면 해당 버튼의 이미지를 보이도록 한다. (숫자 0~9까지)
			if(obj==btn0)
			{
				nCounter=wheretosetVisible();
				
				lbl[nCounter][0].setVisible(true);
				nInput[nCounter]=0;
			}//숫자 0 이미지 보이게
			
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
			
			else if(obj==btnCancle) // 취소버튼 누르면 다 지워지도록
			{
				for(int i=0;i<4;i++)
				{
					for(int j=0;j<10;j++)
					{
						lbl[i][j].setVisible(false);
						
					}
					
				}
				
			}
			
			else if(obj==btnOK)//확인버튼
			{
				if((nInput[0]==nAnser[0])&&(nInput[1]==nAnser[1])&&(nInput[2]==nAnser[2])&&(nInput[3]==nAnser[3]))
				{
					GoRecord();
					GoRankPanel();
					getsound(3); //정답 효과음 재생
				}//비밀번호 정답시 기록을 보여줌
				
				else
				{
					getsound(2);	//오답효과음 재생
					
					for(int i=0;i<4;i++)
					{
						for(int j=0;j<10;j++)
						{
							lbl[i][j].setVisible(false); //비밀번호 초기화
							
						}
						
					}
					
					
				}//틀리면 비밀번호창 리셋
				
			}
			
			else if (obj==BXbutton)
			{
				Reactivate();
								
			}//오른쪽 위의 x버튼을 누르면 다시 게임 화면으로 
			
		}
		
	}
	
}// UserPanel class