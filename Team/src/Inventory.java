
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//인벤토리 패널
public class Inventory extends JPanel implements ActionListener{
   
   private Item itemIcon = new Item();  //아이콘 아이템 개체를 선언
   
   private JButton[] itemButton = new JButton[16];  //16개의 배열로 아이템 버튼을 선언
   private JLabel[] Infolabel = new JLabel[16];   //라벨
 
   
   //private int item
   private int[] itemArray = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
   //아이템의 정보. 초기 값은 -1(없음)

   //버튼과 이미지의 위치를 잡아주기 위한 변수 설정
   private int marginX=32,marginY=174;
   private int width=127,height=127;
   private int padding=12;

   private ImageIcon BGImage, Xbutton;
   private JButton BXbutton, BOpen;
   private RoomPanel roompanel;
   private Inventory ThisPanel;

   //인벤토리의 아이템 버튼(16개)를 위한 버튼 리스너
   buttonListener InvenL;

   private JTextField itemText = new JTextField("");
   
   public Inventory(RoomPanel room) { // 룸 패널을 넘겨받
     
      //리스너를 할당
      buttonListener InvenL = new buttonListener();
      
      //인벤토리 패널을 위한 값 설정
      setBounds(0,0,1200,900);
      setBackground(Color.white);
      setLayout(null);
      BGImage= new ImageIcon("ETC/InventoryBGImage.jpg");// 배경 이미지
      
      //다른 메소드에서 패널을 핸들링 하기 위해 대입하는 과정
      ThisPanel=this;
     roompanel=room;
     
     //종료 버튼 설정
     Xbutton = new ImageIcon("DoorLock/XButton.png");
     BXbutton = new JButton();
     BXbutton.setIcon(Xbutton);
      BXbutton.setBounds(1110, 16, 65, 65);
     BXbutton.setOpaque(false);
     BXbutton.setContentAreaFilled(false);
     BXbutton.setBorderPainted(false);
      BXbutton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             roompanel.setVisible(true);   
             ThisPanel.setVisible(false);
             }
      }); 
      add(BXbutton);
      
      //열기 버튼 설정 
      BOpen= new JButton("열기");
         BOpen.setBounds(500,400,100,72);
         BOpen.setBackground(new Color(36,186,223));
         BOpen.setForeground(Color.WHITE);
         BOpen.setFont(new Font("Gothic",Font.BOLD,15));
         BOpen.setLayout(null);
         BOpen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   int result;
                   String message;
                   message="사진조각2를 얻었다.";
                  add_item(6);
                  AlarmBox(message);
                  
                  BOpen.setEnabled(false);
                  BOpen.setVisible(false);
                   }
            }); 
         
      
      
      
      
      
      //각 아이템 버튼의 위치를 잡아줌
      int i=0;
      int j=0;
      int x=0,y=0;
      for(j=0;j<4;j++)
      {
         for(i=0;i<4;i++)
         {
         //계산식
            x=marginX+(i*width)+(i*padding);//마진+간격+너비
            y=marginY+(j*height)+(j*padding);//마진+간격+높이
            itemButton[j*4+i] = new JButton();
            itemButton[j*4+i].setBorder(new LineBorder(Color.black, 4));
            //itemButton[j*4+1].setOpaque(false);
            itemButton[j*4+i].setBounds(x,y,width,height);
            itemButton[j*4+i].setBackground(Color.BLACK);
             itemButton[j*4+i].setLayout(null);
             itemButton[j*4+i].addActionListener(InvenL);
             add(itemButton[j*4+i]);
             
             Infolabel[j*4+i] = new JLabel();
            Infolabel[j*4+i].setBounds(550,141,700,484);
            Infolabel[j*4+i].setBackground(Color.white);
             Infolabel[j*4+i].setLayout(null);
             add(Infolabel[j*4+i]);
             
         }
      }
   }
   
   
   public void add_item(int itemNo)//아이템을 추가하기 위한 메소드입
   {
      int x=0;
      for(x=0;x<16;x++) //16개의 아이템 배열
      {
         if(itemArray[x]==-1) //비어있는 곳을 찾았다!
         {
            itemArray[x]=itemNo;  //호출에서 제공받은 아이템의 넘버를 대입
            break;                //같은 아이템을 반복해 집어넣는 것을 막기 위해 break
         }
      }
     
      set_icon();   //아이템에 대한 정보가 바뀌었기 때문에 아이콘을 다시 보여줌
   }
   
   
  
   
   public void set_icon() //아이템의 리스트를 이용자가 볼 수 있도록 미리 깔아놓은 위치에 아이템의 이미지를 표현하는 메소드
   {
      int x=0;
      for(x=0;x<16;x++)
      {
         if(itemArray[x]!=-1) //아이템이 있을 경우에만,
            {

              //아이콘을 세팅
              itemButton[x].setIcon(itemIcon.get_icon(itemArray[x]));
              Infolabel[x].setIcon(itemIcon.get_info(itemArray[x]));

               
               if(itemArray[x]==12) 
               {
                Infolabel[x].add(BOpen);
               }
               
               Infolabel[x].setVisible(false);
            }
         else //아이템이 없을 경우(-1)는 아이콘이 필요없기 때문에 없애줌(null)
            itemButton[x].setIcon(null);
      }
      
     
   }
   
   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);
      page.drawImage(BGImage.getImage(), 0, 0, null);
      
   }
   
   public void AlarmBox(String message) // 알람
   {
     
      roompanel.AlarmBox(message);
       
   }
   
   public void actionPerformed(ActionEvent evt) {
    
      
      
     
     }
   
   public void getSound() //효과음 실행
   {
	   try {
			SoundPlayer.ButtonSound();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
   }
   
   public void gohide()
   {
      for(int i=0;i<16;i++)
      {
         Infolabel[i].setVisible(false);  // visible false
      }
   }
   
   public class buttonListener implements ActionListener
   {
      
     
   public void actionPerformed(ActionEvent e) {
      
	   //각 아이콘 버튼을 클릭시 해당 아이템의 정보를 나타내는 라벨 setVisible(true)
      
      Object obj=e.getSource();
		getSound();

         if(obj==BOpen)
         {   
            System.out.println(obj);
            add_item(6);
            BOpen.setEnabled(true);
            BOpen.setVisible(true);
         }
    
         else if(obj==itemButton[0])
         {
            gohide();
            Infolabel[0].setVisible(true);  
         }
         else if(obj==itemButton[1])
         {
            gohide();
            Infolabel[1].setVisible(true);
         }
         else if(obj==itemButton[2])
         {
            gohide();
            Infolabel[2].setVisible(true);
         }
         else if(obj==itemButton[3])
         {
            gohide();
            Infolabel[3].setVisible(true);
         }
         
         else if(obj==itemButton[4])
         {
            gohide();
            Infolabel[4].setVisible(true);
         }
         
         else if(obj==itemButton[5])
         {
            gohide();
            Infolabel[5].setVisible(true);
         }
         
         else if(obj==itemButton[6])
         {
            gohide();
            Infolabel[6].setVisible(true);
         }
         
         else if(obj==itemButton[7])
         {
            gohide();
            Infolabel[7].setVisible(true);
         }
         
         else if(obj==itemButton[8])
         {
            gohide();
            Infolabel[8].setVisible(true);
         }
         
          
         else if(obj==itemButton[9])
         {
            gohide();
            Infolabel[9].setVisible(true);
         }
         
         else if(obj==itemButton[10])
         {
            gohide();
            Infolabel[10].setVisible(true);
         }
         
         else if(obj==itemButton[11])
         {
            gohide();
            Infolabel[11].setVisible(true);
         }
         
         else if(obj==itemButton[12])
         {
            gohide();
            Infolabel[12].setVisible(true);
            
            
         }
         
         else if(obj==itemButton[13])
         {
            gohide();
            Infolabel[13].setVisible(true);
         }
         
         else if(obj==itemButton[14])
         {
            gohide();
            Infolabel[14].setVisible(true);
         }
        
         else if(obj==itemButton[15])
         {
            gohide();
            Infolabel[15].setVisible(true);
         }
        
      
   }
      
   }
   
}