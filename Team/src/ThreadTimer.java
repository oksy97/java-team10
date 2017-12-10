import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ThreadTimer extends JLabel implements Runnable{
	
	private JLabel JTime[][]; // �ð�(��,��)ǥ��
	private JLabel JBetween; // : �� ǥ��
	private Thread myThread;
	private Font ft;
	private RoomPanel room; 
	private String time; // ��ϳ��� �� �� �ð�
	private String strdate; //��� ���� �� �� ��¥
	private JPanel primarypanel;

	
	public ThreadTimer(RoomPanel Rp,JPanel primary)
	{
	
		primarypanel=primary;
		room=Rp;
		ft= new Font("Gothic",Font.BOLD,64);
		
		JTime= new JLabel[3][];//�ð�
		JTime[0]=new JLabel[6]; //��(0~5)
		JTime[1]=new JLabel[10];//10�� �ڸ� ��(0~9)
		JTime[2]=new JLabel[10];//1�� �ڸ� ��(0~9)
		JBetween= new JLabel(":");
		JBetween.setForeground(Color.white);
		JBetween.setFont(ft);
		JBetween.setBounds(126,29,30,65);
		Rp.add(JBetween);
		

		for(int i=0;i<6;i++)
		{
			JTime[0][i]=new JLabel(Integer.toString(i)); // ���ڷ� �ٲ���� �ϱ� ������

			JTime[0][i].setFont(ft);
			JTime[0][i].setBounds(86, 29, 40, 65);
			JTime[0][i].setHorizontalAlignment(SwingConstants.CENTER);
			JTime[0][i].setVisible(false);
			JTime[0][i].setForeground(Color.white);
			Rp.add(JTime[0][i]);
		}
		//��
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
		//10�� �ڸ� ��			
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
		//1���ڸ� ��
		JTime[0][5].setVisible(true);
		JTime[1][0].setVisible(true);
		JTime[2][0].setVisible(true);
	
	}		
		
	public String getTime()
	{

		return time;
	}//�ð� ������
	
	public void setTime(int m, int s1, int s2)
	{
		int sec1,sec2;
			
		sec1=5-s1;
		sec2=10-s2;
		
		time=+(5-m)+"��"+sec1+sec2; 
		
	}//��,�� ����
	
	
	public void GoGameOver()
	{
		room.setVisible(false);
		
		primarypanel.add(new GameOver(primarypanel));//�����̸Ӹ� �гο� ���ӿ��� �г� add
	}
		//Ÿ�Ӿƿ��� �Ǹ� ���� ������ �ϱ� ����
	
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
			{//��
				
				JTime[0][m].setVisible(true);
				
				for(int s1=5;s1>=0;s1--)
				{//10���ڸ���
					
					JTime[1][s1].setVisible(true);
					
					for(int s2=9;s2>=0;s2--)
					{//1���ڸ���
						if(m==0) 
						{
							JTime[0][m].setForeground(Color.red);
							JTime[1][s1].setForeground(Color.red);
							JTime[2][s2].setForeground(Color.red);
							JBetween.setForeground(Color.red);
							//�ð��� �� ���� ������ ǥ���ϱ� ���� �ð��� ���� ���������� ����
							if(s2<3)
							{
								SoundPlayer.WrongAnswerSound(); //30�� ���ĺ��� �ð��� ������ ���� ȿ���� ���
							}
							
							else if(s2==0&&s1==0)
							{
								
								GoGameOver(); // Ÿ�Ӿƿ����� ���ӿ���
							}
							
						}
						
						JTime[2][s2].setVisible(true);
						setTime(m,s1,s2);
						myThread.sleep(1000);//1�ʸ��� �ð��ٲ�
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
