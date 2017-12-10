
import javax.swing.*;
import java.awt.*;

public class Item  {
	//Iventory에 사용할 아이템 이미지아이콘들과 아이템의 정보를 나타내는 이미지아이콘 생성
	private ImageIcon[] icon = new ImageIcon[13];
	private ImageIcon[] info = new ImageIcon[13];
	
	public Item ()
	{
		icon[0] = new ImageIcon("ItemIconImages/곰인형.png");
		icon[1] = new ImageIcon("ItemIconImages/망치.png");
		icon[2] = new ImageIcon("ItemIconImages/메모1.png");
		icon[3] = new ImageIcon("ItemIconImages/메모2.png");
		icon[4] = new ImageIcon("ItemIconImages/메모3.png");
		icon[5] = new ImageIcon("ItemIconImages/사진조각1.png");
		icon[6] = new ImageIcon("ItemIconImages/사진조각2.png");
		icon[7] = new ImageIcon("ItemIconImages/사진조각3.png");
		icon[8] = new ImageIcon("ItemIconImages/손전등.png");
		icon[9] = new ImageIcon("ItemIconImages/수첩.png");
		icon[10] = new ImageIcon("ItemIconImages/열쇠.png");
		icon[11] = new ImageIcon("ItemIconImages/조각상조각.png");
		icon[12] = new ImageIcon("ItemIconImages/책.png");
		
		info[0] = new ImageIcon("ItemInfoImages/곰인형정보.png");
		info[1] = new ImageIcon("ItemInfoImages/망치정보.png");
		info[2] = new ImageIcon("ItemInfoImages/메모1정보.png");
		info[3] = new ImageIcon("ItemInfoImages/메모2정보.png");
		info[4] = new ImageIcon("ItemInfoImages/메모3정보.png");
		info[5] = new ImageIcon("ItemInfoImages/액자조각1정보.png");
		info[6] = new ImageIcon("ItemInfoImages/액자조각2정보.png");
		info[7] = new ImageIcon("ItemInfoImages/액자조각3정보.png");
		info[8] = new ImageIcon("ItemInfoImages/손전등패널정보.png");
		info[9] = new ImageIcon("ItemInfoImages/수첩정보.png");
		info[10] = new ImageIcon("ItemInfoImages/열쇠정보.png");
		info[11] = new ImageIcon("ItemInfoImages/조각상조각정보.png");
		info[12] = new ImageIcon("ItemInfoImages/책정보.png");
	}
	public ImageIcon get_icon(int itemNo)	//호출시 해당 버튼 아이콘의 이미지를 반환
	{
		return icon[itemNo];
	}
	public ImageIcon get_info(int itemNo)	//호출시 해당 버튼 아이콘의 정보를 나타내는이미지를 반환
	{
		return info[itemNo];
	}

}
