import java.awt.*;
import javax.swing.*;



public class RoomEscaping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Room Escaping 10��");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel primary = new JPanel(); 	//������ ���� �����ϸ� ������ ���� ��κ��� �޴����� setVisible(true or false)
										//�۾� ����� ���� �޴��� �ش��ϴ� ����� ���� �гε��� ����ü�� �����ϱ� ����  ���� �г�
										//Frame�� �������� ������ �����Ѵٰ� �� �� ����
		
		primary.setPreferredSize(new Dimension(1200,900));
		primary.setLayout(null);
		
		try {	//Application ����� ���ÿ� ������� ��� 
			SoundPlayer.MainBGM();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		frame.getContentPane().add(primary);
		
		primary.add(new MainMenu(primary));	//���θ޴� �г� ����
		
	
		
		frame.pack();
		frame.setVisible(true);		
		
		
		
	}

}


