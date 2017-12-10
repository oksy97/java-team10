
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//�κ��丮 �г�
public class Inventory extends JPanel implements ActionListener{
   
   private Item itemIcon = new Item();  //������ ������ ��ü�� ����
   
   private JButton[] itemButton = new JButton[16];  //16���� �迭�� ������ ��ư�� ����
   private JLabel[] Infolabel = new JLabel[16];   //��
 
   
   //private int item
   private int[] itemArray = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
   //�������� ����. �ʱ� ���� -1(����)

   //��ư�� �̹����� ��ġ�� ����ֱ� ���� ���� ����
   private int marginX=32,marginY=174;
   private int width=127,height=127;
   private int padding=12;

   private ImageIcon BGImage, Xbutton;
   private JButton BXbutton, BOpen;
   private RoomPanel roompanel;
   private Inventory ThisPanel;

   //�κ��丮�� ������ ��ư(16��)�� ���� ��ư ������
   buttonListener InvenL;

   private JTextField itemText = new JTextField("");
   
   public Inventory(RoomPanel room) { // �� �г��� �Ѱܹ�
     
      //�����ʸ� �Ҵ�
      buttonListener InvenL = new buttonListener();
      
      //�κ��丮 �г��� ���� �� ����
      setBounds(0,0,1200,900);
      setBackground(Color.white);
      setLayout(null);
      BGImage= new ImageIcon("ETC/InventoryBGImage.jpg");// ��� �̹���
      
      //�ٸ� �޼ҵ忡�� �г��� �ڵ鸵 �ϱ� ���� �����ϴ� ����
      ThisPanel=this;
     roompanel=room;
     
     //���� ��ư ����
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
      
      //���� ��ư ���� 
      BOpen= new JButton("����");
         BOpen.setBounds(500,400,100,72);
         BOpen.setBackground(new Color(36,186,223));
         BOpen.setForeground(Color.WHITE);
         BOpen.setFont(new Font("Gothic",Font.BOLD,15));
         BOpen.setLayout(null);
         BOpen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   int result;
                   String message;
                   message="��������2�� �����.";
                  add_item(6);
                  AlarmBox(message);
                  
                  BOpen.setEnabled(false);
                  BOpen.setVisible(false);
                   }
            }); 
         
      
      
      
      
      
      //�� ������ ��ư�� ��ġ�� �����
      int i=0;
      int j=0;
      int x=0,y=0;
      for(j=0;j<4;j++)
      {
         for(i=0;i<4;i++)
         {
         //����
            x=marginX+(i*width)+(i*padding);//����+����+�ʺ�
            y=marginY+(j*height)+(j*padding);//����+����+����
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
   
   
   public void add_item(int itemNo)//�������� �߰��ϱ� ���� �޼ҵ���
   {
      int x=0;
      for(x=0;x<16;x++) //16���� ������ �迭
      {
         if(itemArray[x]==-1) //����ִ� ���� ã�Ҵ�!
         {
            itemArray[x]=itemNo;  //ȣ�⿡�� �������� �������� �ѹ��� ����
            break;                //���� �������� �ݺ��� ����ִ� ���� ���� ���� break
         }
      }
     
      set_icon();   //�����ۿ� ���� ������ �ٲ���� ������ �������� �ٽ� ������
   }
   
   
  
   
   public void set_icon() //�������� ����Ʈ�� �̿��ڰ� �� �� �ֵ��� �̸� ��Ƴ��� ��ġ�� �������� �̹����� ǥ���ϴ� �޼ҵ�
   {
      int x=0;
      for(x=0;x<16;x++)
      {
         if(itemArray[x]!=-1) //�������� ���� ��쿡��,
            {

              //�������� ����
              itemButton[x].setIcon(itemIcon.get_icon(itemArray[x]));
              Infolabel[x].setIcon(itemIcon.get_info(itemArray[x]));

               
               if(itemArray[x]==12) 
               {
                Infolabel[x].add(BOpen);
               }
               
               Infolabel[x].setVisible(false);
            }
         else //�������� ���� ���(-1)�� �������� �ʿ���� ������ ������(null)
            itemButton[x].setIcon(null);
      }
      
     
   }
   
   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);
      page.drawImage(BGImage.getImage(), 0, 0, null);
      
   }
   
   public void AlarmBox(String message) // �˶�
   {
     
      roompanel.AlarmBox(message);
       
   }
   
   public void actionPerformed(ActionEvent evt) {
    
      
      
     
     }
   
   public void getSound() //ȿ���� ����
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
      
	   //�� ������ ��ư�� Ŭ���� �ش� �������� ������ ��Ÿ���� �� setVisible(true)
      
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