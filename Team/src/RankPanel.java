import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
// 필요한 패키지 삽입

public class RankPanel extends JPanel {

   private JLabel play, exit;   //Play, Exit 버튼의 용도로 사용될 라벨들, 라벨이지만 버튼처럼 사용
   private ImageIcon playImage, exitImage;// Play버튼의 이미지아이콘, Exit버튼의 이미지 아이콘
   private ImageIcon background;//배경이미지를 위한 이미지 아이콘
   
   private JLabel score[],rank[];   //순위와 해당 순위에 시간을 나타내기 위한 라벨 컴포넌트
   private Font fnt;   //사용저 정의 폰트를 위한 변수
   private FileReader fr1;   //파일입력을 위한 변수
   private File f1;   //파일 변수
   private ArrayList<String> strTimeList;   //게임 기록을 문자열로 정리하기 위한 어레이 리스트
   private ArrayList<Integer> nTimeList;   //게임기록을 정수형 변수로 정리하기 위한 어레이 리스트
   private BufferedReader reader1,reader2; //파일에서 게임기록을 읽어드리기 위한 버퍼리더
   private RoomPanel roomagain; // 
   private JPanel primarypanel; // 업콜구조를 위한 프라이머리 패널
   private regameListener rgL; // 게임을 다시 시작하거나 종료하기 위한 리스너
   // 각종 도구들 선언

   public RankPanel(JPanel primary) {

      background = new ImageIcon("Record/Rank.jpg"); // 배경이미지
      primarypanel=primary; // 업콜을 위한 프라이머리패널
      rgL = new regameListener(); // 리스너 삽입
      
      fnt = new Font("Gothic", Font.PLAIN, 50); // 폰트 설정.

      setBounds(0,0,1200, 900); // 사이즈 설정
      setBackground(Color.white); // 배경 색 설정
      setLayout(null); // 패널 크기, 배경, 레이아웃을 설정.
      
      score=new JLabel[5]; // 스코어 라벨배열생성
      rank=new JLabel[5]; // 랭크 라벨배열생성
      
      f1= new File("Record/RecordforTime.txt"); // 기록을 저장할 파일을 생성.
      
      strTimeList= new ArrayList<String>(); // 게임 기록을 문자열로 정리하는 어레이리스트 생성
      nTimeList= new ArrayList<Integer>(); // 게임 기록을 정수형 변수로 정리하는 어레이 리스트 생성
   
      playImage= new ImageIcon("GameOver/Replay.png"); // 플레이 버튼 이미지
      exitImage= new ImageIcon("GameOver/Exit.png"); // 종료 버튼 이미지
      
      play= new JLabel(); // play 라벨 생성
      play.setIcon(playImage); // play 라벨 이미지 설정
      play.setBounds(317,776,280,110); // play 라벨 위치 설정
      play.addMouseListener(rgL); // play 라벨 리스너 설정
      this.add(play); // 패널에 play 라벨 추가
      // play 라벨 생성 및 크기를 설정하고 이벤트 발생을 위해 리스너 설정.
      
      
      exit= new JLabel(); // exit 라벨 생성
      exit.setIcon(exitImage); // exit 라벨 이미지 설정
      exit.setBounds(628,776,280,110); // exit 라벨 위치 설정
      exit.addMouseListener(rgL); // exit 라벨 리스너 설정
      this.add(exit);// 패널에 exit 라벨 추가
      // exit 라벨 생성 및 크기를 설정하고 이벤트 발생을 위해 리스너 설정.
      
      try {
         
      reader1= new BufferedReader(fr1 = new FileReader(f1)); // 파일을 읽어옴.
      NarrowDown(); // NarrowDown 메소드 호출
      reader1.close(); // 파일리더를 닫음

      
            }
      catch(Exception e)
      {
         
         
      }
      
      
      
      

   } // RankPanel()
     // 업콜구조를 사용. 
   
   public void readRecord()
   {
      int i =0;
      String s;
      try {
         while((s=reader1.readLine())!=null)
         {
             strTimeList.add(new String(s)); //파일에서 입력받은 시간을 스트링타입의 어레이리스트에 add
         }      
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   } // readRecord() 파일에 기록된 시간을 읽어오는 메소드

   public void NarrowDown()
   {
      
      String[] str;
      int min;
      
      readRecord();    //파일의 데이터를 입력받아 스트링타입의 어레이리스트에 Add하기 위한 함수 

      
      for(String saved: strTimeList)
      {
         str= saved.split("분");   //"분"을 기준으로 스트링을 나눔
         nTimeList.add((Integer.parseInt(str[0])*60)+Integer.parseInt(str[1])); 
         //정수형 변수로 변환하고 분에 해당하는 수는 60을 곱하여 초와 더함, 즉 초단위로 변환. 
      }
      
      Collections.sort(nTimeList); //오름차순으로 정리
      
      for(int i=0;i<5;i++)
      {
         if(nTimeList.get(i)==null) {break;} // 기록된 순위가 없으면 종료
            
         
         try {
         min=nTimeList.get(i)/60; // 초단위의 수를 60으로 나눠 분과 초로 구별
         score[i]=new JLabel(min+"분"+(nTimeList.get(i)-(60*min))+"초"); //라벨에 문자열 형식으로 입력
         score[i].setBounds(931, 128+(100*i), 200, 66); //100: 행간
         score[i].setFont(fnt);// 폰트를 설정
         score[i].setForeground(Color.WHITE); // 색 설정
         score[i].setVisible(true); // 화면에 보이도록 설정
         

         rank[i]=new JLabel((i+1)+"위"); // 순위를 표시

         rank[i].setBounds(149, 128+(100*i), 150, 80); //100: 행간
         rank[i].setFont(fnt); // 폰트를 설정
         rank[i].setForeground(Color.WHITE); // 색 설정
         rank[i].setVisible(true); // 화면에 보이도록 설정
         
         this.add(score[i]); // 시간기록 배열을 패널에 추가
         this.add(rank[i]); // 순위기록 배열을 패널에 추가
         }
         
         catch(Exception e)
         {
            System.out.println(e);
            
         }
      }
      
      
   } // NarrowDown() 화면에 순위와 걸린 시간을 보여주는 메소드

   public void paintComponent(Graphics page) { 
      super.paintComponent(page);
      

      page.drawImage(background.getImage(), 0, 0, this);

   } // paintComponent()
     // 이미지를 받아서 그대로 그려줌.

   public void GoGamePanel()
   {
      this.setVisible(false);
      primarypanel.add(new RoomPanel(primarypanel));
      
   } // GoGamePanel()
     // 이 패널(RankPanel)을 보이지 않게 설정한 후 새로운 RoomPanel을 무명개체로 생성하여 primarypanel에 추가함. 
   
   
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
				} //효과음 실행
            GoGamePanel();   //RoomPanel의 무명객체를 생성하기 위한 메소드 호출. 재시작을 의미함.
            
         }
         
         else if(obj==exit)
         {try {
				SoundPlayer.ButtonSound();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} //효과음 실행
            System.exit(1);
            
         }
         // 오브젝트를 받아서 play버튼일 경우 GoGamePanel 메소드를 실행
         // 오브젝트를 받아서 exit버튼일 경우 종료.
         
      } // mousePressed()

      public void mouseReleased(MouseEvent e) {}
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
   } // regameListener

} // RankPanel class