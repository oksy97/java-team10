import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ThreadTimer extends JLabel implements Runnable{
	
	private JLabel JTime[][]; // 시간(분,초)표시
	private JLabel JBetween; // : 을 표시
	private Thread myThread;
	private Font ft;
	private RoomPanel room; 
	private String time; // 기록남길 때 쓸 시간
	private String strdate; //기록 남길 때 쓸 날짜
	private JPanel primarypanel;

	
	public ThreadTimer(RoomPanel Rp,JPanel primary)
	{
	
		primarypanel=primary;
		room=Rp;
		ft= new Font("Gothic",Font.BOLD,64);
		
		JTime= new JLabel[3][];//시간
		JTime[0]=new JLabel[6]; //분(0~5)
		JTime[1]=new JLabel[10];//10의 자리 초(0~9)
		JTime[2]=new JLabel[10];//1의 자리 초(0~9)
		JBetween= new JLabel(":");
		JBetween.setForeground(Color.white);
		JBetween.setFont(ft);
		JBetween.setBounds(126,29,30,65);
		Rp.add(JBetween);
		

		for(int i=0;i<6;i++)
		{
			JTime[0][i]=new JLabel(Integer.toString(i)); // 문자로 바꿔줘야 하기 때문에

			JTime[0][i].setFont(ft);
			JTime[0][i].setBounds(86, 29, 40, 65);
			JTime[0][i].setHorizontalAlignment(SwingConstants.CENTER);
			JTime[0][i].setVisible(false);
			JTime[0][i].setForeground(Color.white);
			Rp.add(JTime[0][i]);
		}
		//분
		for (int i=0;i<6;i++)
		{
			JTime[1][i]= new JLabel(Integer.toString(i));
			JTime[1][i].setFont(ft);
			JTime[1][i].setBounds(146, 29, 40, 65);
			JTime[1][i].setHorizontalAlignment(SwingConstants.CENTER);
			JTime[1][i].setVisible(false);
			JTime[1][i].setForeground(Color.white);
			Rp.add(JTime[1][i]);
		}
		//10의 자리 초			
		for (int i=0;i<10;i++)
		{
			JTime[2][i]= new JLabel(Integer.toString(i));
			JTime[2][i].setFont(ft);
			JTime[2][i].setBounds(196, 29, 40, 65);
			JTime[2][i].setHorizontalAlignment(SwingConstants.CENTER);	
			JTime[2][i].setVisible(false);
			JTime[2][i].setForeground(Color.white);
			Rp.add(JTime[2][i]);
		}
		//1의자리 초
		JTime[0][5].setVisible(true);
		JTime[1][0].setVisible(true);
		JTime[2][0].setVisible(true);
	
	}		
		
	public String getTime()
	{

		return time;
	}//시간 가져옴
	
	public void setTime(int m, int s1, int s2)
	{
		int sec1,sec2;
			
		sec1=5-s1;
		sec2=10-s2;
		
		time=+(5-m)+"분"+sec1+sec2; 
		
	}//분,초 설정
	
	
	public void GoGameOver()
	{
		room.setVisible(false);
		
		primarypanel.add(new GameOver(primarypanel));//프라이머리 패널에 게임오버 패널 add
	}
		//타임아웃이 되면 게임 오버를 하기 위해
	
	public void start()
	{
		if (myThread==null)
		{
			myThread= new Thread(this);
			
		}
		
		myThread.start();
		
	}
	
	public void stop()
	{
		if (myThread!=null)
		{
			myThread.stop();			
		}
		
	}
	
	public void run() 
	{
		try
		{	JTime[0][5].setVisible(false);
			JTime[1][0].setVisible(false);
			JTime[2][0].setVisible(false);
			for(int m=5;m>=0;m--)
			{//분
				
				JTime[0][m].setVisible(true);
				
				for(int s1=5;s1>=0;s1--)
				{//10의자리초
					
					JTime[1][s1].setVisible(true);
					
					for(int s2=9;s2>=0;s2--)
					{//1의자리초
						if(m==0) 
						{
							JTime[0][m].setForeground(Color.red);
							JTime[1][s1].setForeground(Color.red);
							JTime[2][s2].setForeground(Color.red);
							JBetween.setForeground(Color.red);
							//시간이 얼마 남지 않음을 표현하기 위해 시간의 색을 빨간색으로 변경
							if(s2<3)
							{
								SoundPlayer.WrongAnswerSound(); //30초 이후부터 시간이 지남에 따라 효과음 재생
							}
							
							else if(s2==0&&s1==0)
							{
								
								GoGameOver(); // 타임아웃으로 게임오버
							}
							
						}
						
						JTime[2][s2].setVisible(true);
						setTime(m,s1,s2);
						myThread.sleep(1000);//1초마다 시간바뀜
						JTime[2][s2].setVisible(false);
											
					}
					
					JTime[1][s1].setVisible(false);
					
				}
				
				JTime[0][m].setVisible(false);
				
			}
			
		}
		catch(Exception e)
		{
			
			
		}
		
	}
	
}
