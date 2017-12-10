
import javax.swing.*;
import java.awt.*;

public class Item  {
	//Iventory�� ����� ������ �̹��������ܵ�� �������� ������ ��Ÿ���� �̹��������� ����
	private ImageIcon[] icon = new ImageIcon[13];
	private ImageIcon[] info = new ImageIcon[13];
	
	public Item ()
	{
		icon[0] = new ImageIcon("ItemIconImages/������.png");
		icon[1] = new ImageIcon("ItemIconImages/��ġ.png");
		icon[2] = new ImageIcon("ItemIconImages/�޸�1.png");
		icon[3] = new ImageIcon("ItemIconImages/�޸�2.png");
		icon[4] = new ImageIcon("ItemIconImages/�޸�3.png");
		icon[5] = new ImageIcon("ItemIconImages/��������1.png");
		icon[6] = new ImageIcon("ItemIconImages/��������2.png");
		icon[7] = new ImageIcon("ItemIconImages/��������3.png");
		icon[8] = new ImageIcon("ItemIconImages/������.png");
		icon[9] = new ImageIcon("ItemIconImages/��ø.png");
		icon[10] = new ImageIcon("ItemIconImages/����.png");
		icon[11] = new ImageIcon("ItemIconImages/����������.png");
		icon[12] = new ImageIcon("ItemIconImages/å.png");
		
		info[0] = new ImageIcon("ItemInfoImages/����������.png");
		info[1] = new ImageIcon("ItemInfoImages/��ġ����.png");
		info[2] = new ImageIcon("ItemInfoImages/�޸�1����.png");
		info[3] = new ImageIcon("ItemInfoImages/�޸�2����.png");
		info[4] = new ImageIcon("ItemInfoImages/�޸�3����.png");
		info[5] = new ImageIcon("ItemInfoImages/��������1����.png");
		info[6] = new ImageIcon("ItemInfoImages/��������2����.png");
		info[7] = new ImageIcon("ItemInfoImages/��������3����.png");
		info[8] = new ImageIcon("ItemInfoImages/�������г�����.png");
		info[9] = new ImageIcon("ItemInfoImages/��ø����.png");
		info[10] = new ImageIcon("ItemInfoImages/��������.png");
		info[11] = new ImageIcon("ItemInfoImages/��������������.png");
		info[12] = new ImageIcon("ItemInfoImages/å����.png");
	}
	public ImageIcon get_icon(int itemNo)	//ȣ��� �ش� ��ư �������� �̹����� ��ȯ
	{
		return icon[itemNo];
	}
	public ImageIcon get_info(int itemNo)	//ȣ��� �ش� ��ư �������� ������ ��Ÿ�����̹����� ��ȯ
	{
		return info[itemNo];
	}

}
