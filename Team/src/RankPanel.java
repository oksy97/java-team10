import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
// �ʿ��� ��Ű�� ����

public class RankPanel extends JPanel {

   private JLabel play, exit;   //Play, Exit ��ư�� �뵵�� ���� �󺧵�, �������� ��ưó�� ���
   private ImageIcon playImage, exitImage;// Play��ư�� �̹���������, Exit��ư�� �̹��� ������
   private ImageIcon background;//����̹����� ���� �̹��� ������
   
   private JLabel score[],rank[];   //������ �ش� ������ �ð��� ��Ÿ���� ���� �� ������Ʈ
   private Font fnt;   //����� ���� ��Ʈ�� ���� ����
   private FileReader fr1;   //�����Է��� ���� ����
   private File f1;   //���� ����
   private ArrayList<String> strTimeList;   //���� ����� ���ڿ��� �����ϱ� ���� ��� ����Ʈ
   private ArrayList<Integer> nTimeList;   //���ӱ���� ������ ������ �����ϱ� ���� ��� ����Ʈ
   private BufferedReader reader1,reader2; //���Ͽ��� ���ӱ���� �о�帮�� ���� ���۸���
   private RoomPanel roomagain; // 
   private JPanel primarypanel; // ���ݱ����� ���� �����̸Ӹ� �г�
   private regameListener rgL; // ������ �ٽ� �����ϰų� �����ϱ� ���� ������
   // ���� ������ ����

   public RankPanel(JPanel primary) {

      background = new ImageIcon("Record/Rank.jpg"); // ����̹���
      primarypanel=primary; // ������ ���� �����̸Ӹ��г�
      rgL = new regameListener(); // ������ ����
      
      fnt = new Font("Gothic", Font.PLAIN, 50); // ��Ʈ ����.

      setBounds(0,0,1200, 900); // ������ ����
      setBackground(Color.white); // ��� �� ����
      setLayout(null); // �г� ũ��, ���, ���̾ƿ��� ����.
      
      score=new JLabel[5]; // ���ھ� �󺧹迭����
      rank=new JLabel[5]; // ��ũ �󺧹迭����
      
      f1= new File("Record/RecordforTime.txt"); // ����� ������ ������ ����.
      
      strTimeList= new ArrayList<String>(); // ���� ����� ���ڿ��� �����ϴ� ��̸���Ʈ ����
      nTimeList= new ArrayList<Integer>(); // ���� ����� ������ ������ �����ϴ� ��� ����Ʈ ����
   
      playImage= new ImageIcon("GameOver/Replay.png"); // �÷��� ��ư �̹���
      exitImage= new ImageIcon("GameOver/Exit.png"); // ���� ��ư �̹���
      
      play= new JLabel(); // play �� ����
      play.setIcon(playImage); // play �� �̹��� ����
      play.setBounds(317,776,280,110); // play �� ��ġ ����
      play.addMouseListener(rgL); // play �� ������ ����
      this.add(play); // �гο� play �� �߰�
      // play �� ���� �� ũ�⸦ �����ϰ� �̺�Ʈ �߻��� ���� ������ ����.
      
      
      exit= new JLabel(); // exit �� ����
      exit.setIcon(exitImage); // exit �� �̹��� ����
      exit.setBounds(628,776,280,110); // exit �� ��ġ ����
      exit.addMouseListener(rgL); // exit �� ������ ����
      this.add(exit);// �гο� exit �� �߰�
      // exit �� ���� �� ũ�⸦ �����ϰ� �̺�Ʈ �߻��� ���� ������ ����.
      
      try {
         
      reader1= new BufferedReader(fr1 = new FileReader(f1)); // ������ �о��.
      NarrowDown(); // NarrowDown �޼ҵ� ȣ��
      reader1.close(); // ���ϸ����� ����

      
            }
      catch(Exception e)
      {
         
         
      }
      
      
      
      

   } // RankPanel()
     // ���ݱ����� ���. 
   
   public void readRecord()
   {
      int i =0;
      String s;
      try {
         while((s=reader1.readLine())!=null)
         {
             strTimeList.add(new String(s)); //���Ͽ��� �Է¹��� �ð��� ��Ʈ��Ÿ���� ��̸���Ʈ�� add
         }      
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   } // readRecord() ���Ͽ� ��ϵ� �ð��� �о���� �޼ҵ�

   public void NarrowDown()
   {
      
      String[] str;
      int min;
      
      readRecord();    //������ �����͸� �Է¹޾� ��Ʈ��Ÿ���� ��̸���Ʈ�� Add�ϱ� ���� �Լ� 

      
      for(String saved: strTimeList)
      {
         str= saved.split("��");   //"��"�� �������� ��Ʈ���� ����
         nTimeList.add((Integer.parseInt(str[0])*60)+Integer.parseInt(str[1])); 
         //������ ������ ��ȯ�ϰ� �п� �ش��ϴ� ���� 60�� ���Ͽ� �ʿ� ����, �� �ʴ����� ��ȯ. 
      }
      
      Collections.sort(nTimeList); //������������ ����
      
      for(int i=0;i<5;i++)
      {
         if(nTimeList.get(i)==null) {break;} // ��ϵ� ������ ������ ����
            
         
         try {
         min=nTimeList.get(i)/60; // �ʴ����� ���� 60���� ���� �а� �ʷ� ����
         score[i]=new JLabel(min+"��"+(nTimeList.get(i)-(60*min))+"��"); //�󺧿� ���ڿ� �������� �Է�
         score[i].setBounds(931, 128+(100*i), 200, 66); //100: �ణ
         score[i].setFont(fnt);// ��Ʈ�� ����
         score[i].setForeground(Color.WHITE); // �� ����
         score[i].setVisible(true); // ȭ�鿡 ���̵��� ����
         

         rank[i]=new JLabel((i+1)+"��"); // ������ ǥ��

         rank[i].setBounds(149, 128+(100*i), 150, 80); //100: �ణ
         rank[i].setFont(fnt); // ��Ʈ�� ����
         rank[i].setForeground(Color.WHITE); // �� ����
         rank[i].setVisible(true); // ȭ�鿡 ���̵��� ����
         
         this.add(score[i]); // �ð���� �迭�� �гο� �߰�
         this.add(rank[i]); // ������� �迭�� �гο� �߰�
         }
         
         catch(Exception e)
         {
            System.out.println(e);
            
         }
      }
      
      
   } // NarrowDown() ȭ�鿡 ������ �ɸ� �ð��� �����ִ� �޼ҵ�

   public void paintComponent(Graphics page) { 
      super.paintComponent(page);
      

      page.drawImage(background.getImage(), 0, 0, this);

   } // paintComponent()
     // �̹����� �޾Ƽ� �״�� �׷���.

   public void GoGamePanel()
   {
      this.setVisible(false);
      primarypanel.add(new RoomPanel(primarypanel));
      
   } // GoGamePanel()
     // �� �г�(RankPanel)�� ������ �ʰ� ������ �� ���ο� RoomPanel�� ����ü�� �����Ͽ� primarypanel�� �߰���. 
   
   
   public class regameListener implements MouseListener
   {
      public void mouseClicked(MouseEvent e) {}
      public void mousePressed(MouseEvent e) {
         Object obj=e.getSource() ;
         
         if (obj==play)
         {
        	 try {
					SoundPlayer.ButtonSound();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //ȿ���� ����
            GoGamePanel();   //RoomPanel�� ����ü�� �����ϱ� ���� �޼ҵ� ȣ��. ������� �ǹ���.
            
         }
         
         else if(obj==exit)
         {try {
				SoundPlayer.ButtonSound();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} //ȿ���� ����
            System.exit(1);
            
         }
         // ������Ʈ�� �޾Ƽ� play��ư�� ��� GoGamePanel �޼ҵ带 ����
         // ������Ʈ�� �޾Ƽ� exit��ư�� ��� ����.
         
      } // mousePressed()

      public void mouseReleased(MouseEvent e) {}
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
   } // regameListener

} // RankPanel class