import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RoomPanel extends JPanel {

	private JPanel ThisPanel; // �κ��丮 Ȥ�� ����� ����� ��Ȱ��ȭ�� ���� �г�
	private ImageIcon background; // ��� �̹���
	private ImageIcon Doorlock, Inventory, Sculpture, Hammer, Cabinet, Bear, Clock, Leftbookshelf, Drawer,
			RightbookShelf, UndertheTable;
	// ��Ʈ�鿡 ���� �̹��� ������
	private JButton BDoorlock, BInventory, BSculpture, BHammer, BCabinet, BBear, BClock, BLeftbookshelf, BDrawer,
			BRightbookShelf, BUndertheTable;
	// �̹��� �������� ����� ��ư
	// data
	private ThreadTimer timer; // �ð� ������ ���� ������
	private IconListener IListen; // ���� �����ܹ�ư�� �׼Ǹ�����
	private ExitPanel exitpanel; // Ż�� �г�
	private Inventory invenpanel; // ���� �г�
	private String strConfirmMessage; // ���� �޼���

	public RoomPanel(JPanel primary) {

		ThisPanel = this;
		setBounds(0, 0, 1200, 900);
		setBackground(Color.white);
		setLayout(null);

		IListen = new IconListener();

		background = new ImageIcon("Room/RoomImage.jpg");

		Doorlock = new ImageIcon("Room/Doorlock.png");
		BDoorlock = new JButton();

		Inventory = new ImageIcon("Room/Inventory.png");
		BInventory = new JButton();

		Sculpture = new ImageIcon("Room/Sculpture.png");
		BSculpture = new JButton();

		Hammer = new ImageIcon("Room/Hammer.png");
		BHammer = new JButton();

		Cabinet = new ImageIcon("Room/Cabinet.png");
		BCabinet = new JButton();

		Bear = new ImageIcon("Room/Bear.png");
		BBear = new JButton();

		Clock = new ImageIcon("Room/Clock.png");
		BClock = new JButton();

		Leftbookshelf = new ImageIcon("Room/Leftbookshelf.png");
		BLeftbookshelf = new JButton();

		Drawer = new ImageIcon("Room/Drawer.png");
		BDrawer = new JButton();

		RightbookShelf = new ImageIcon("Room/RightbookShelf.png");
		BRightbookShelf = new JButton();

		UndertheTable = new ImageIcon("Room/UndertheTable.png");
		BUndertheTable = new JButton();

		// ��Ʈ�鿡 ����� �̹��� �����ܰ� �� ��ư���� ����
		

		BDoorlock.setIcon(Doorlock);
		BDoorlock.setBounds(1122, 3, 74, 217);
		BDoorlock.setOpaque(false);
		BDoorlock.setContentAreaFilled(false);
		BDoorlock.setBorderPainted(false);
		BDoorlock.setDisabledIcon(Doorlock);
		BDoorlock.setEnabled(true);
		add(BDoorlock);
		BDoorlock.addActionListener(IListen);

		BInventory.setIcon(Inventory);
		BInventory.setBounds(940, 44, 147, 176);
		BInventory.setOpaque(false);
		BInventory.setContentAreaFilled(false);
		BInventory.setBorderPainted(false);
		BInventory.setEnabled(true);
		add(BInventory);
		BInventory.addActionListener(IListen);

		BSculpture.setIcon(Sculpture);
		BSculpture.setBounds(417, 479, 54, 152);
		BSculpture.setOpaque(false);
		BSculpture.setContentAreaFilled(false);
		BSculpture.setBorderPainted(false);
		BSculpture.setDisabledIcon(Sculpture);
		BSculpture.setEnabled(false);
		add(BSculpture);
		BSculpture.addActionListener(IListen);

		BHammer.setIcon(Hammer);
		BHammer.setBounds(792, 604, 60, 25);
		BHammer.setOpaque(false);
		BHammer.setContentAreaFilled(false);
		BHammer.setBorderPainted(false);
		BHammer.setEnabled(true);
		add(BHammer);
		BHammer.addActionListener(IListen);

		BCabinet.setIcon(Cabinet);
		BCabinet.setBounds(234, 283, 82, 178);
		BCabinet.setOpaque(false);
		BCabinet.setContentAreaFilled(false);
		BCabinet.setBorderPainted(false);
		BCabinet.setDisabledIcon(Cabinet);
		BCabinet.setEnabled(false);
		add(BCabinet);
		BCabinet.addActionListener(IListen);

		BBear.setIcon(Bear);
		BBear.setBounds(401, 359, 88, 122);
		BBear.setOpaque(false);
		BBear.setContentAreaFilled(false);
		BBear.setBorderPainted(false);
		BBear.setDisabledIcon(Bear);
		BBear.setEnabled(false);
		add(BBear);

		BBear.addActionListener(IListen);

		BClock.setIcon(Clock);
		BClock.setBounds(783, 255, 86, 287);
		BClock.setOpaque(false);
		BClock.setContentAreaFilled(false);
		BClock.setBorderPainted(false);
		BClock.setDisabledIcon(Clock);
		BClock.setEnabled(true);
		add(BClock);
		BClock.addActionListener(IListen);

		BLeftbookshelf.setIcon(Leftbookshelf);
		BLeftbookshelf.setBounds(316, 253, 94, 190);
		BLeftbookshelf.setOpaque(false);
		BLeftbookshelf.setContentAreaFilled(false);
		BLeftbookshelf.setBorderPainted(false);
		BLeftbookshelf.setDisabledIcon(Leftbookshelf);
		BLeftbookshelf.setEnabled(false);
		add(BLeftbookshelf);
		BLeftbookshelf.addActionListener(IListen);

		BDrawer.setIcon(Drawer);
		BDrawer.setBounds(131, 503, 121, 82);
		BDrawer.setOpaque(false);
		BDrawer.setContentAreaFilled(false);
		BDrawer.setBorderPainted(false);
		BDrawer.setDisabledIcon(Drawer);
		BDrawer.setEnabled(true);
		add(BDrawer);
		BDrawer.addActionListener(IListen);

		BRightbookShelf.setIcon(RightbookShelf);
		BRightbookShelf.setBounds(564, 268, 103, 159);
		BRightbookShelf.setOpaque(false);
		BRightbookShelf.setContentAreaFilled(false);
		BRightbookShelf.setBorderPainted(false);
		BRightbookShelf.setDisabledIcon(RightbookShelf);
		BRightbookShelf.setEnabled(true);
		add(BRightbookShelf);
		BRightbookShelf.addActionListener(IListen);

		BUndertheTable.setIcon(UndertheTable);
		BUndertheTable.setBounds(264, 782, 433, 87);
		BUndertheTable.setOpaque(false);
		BUndertheTable.setContentAreaFilled(false);
		BUndertheTable.setBorderPainted(false);
		BUndertheTable.setDisabledIcon(UndertheTable);
		BUndertheTable.setEnabled(false);
		add(BUndertheTable);
		BUndertheTable.addActionListener(IListen);

		// ��ư���� �̹��������ܰ� ��ġ���� ����

		timer = new ThreadTimer(this, primary); // ���� ���ѽð��� ���� Ÿ�̸� ����
		timer.start();

		exitpanel = new ExitPanel(primary, this, timer); // ���� �� �ִ� ��й�ȣ �Է��� ���� �г�
		invenpanel = new Inventory(this);// �κ��丮 â �г�

		primary.add(exitpanel);
		primary.add(invenpanel);
		exitpanel.setVisible(false);
		invenpanel.setVisible(false);

	} // RoomPanel()

	public void AlarmBox(String message) {
		
		JOptionPane.showMessageDialog(this, message);

	} // AlarmBox()
	
	public void getSound()  //��ư ȿ������ ���� �޼ҵ�
	{
		try {
			SoundPlayer.ButtonSound();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void QuizBox() {
		String result;

		result = JOptionPane.showInputDialog(this, "���� �����");
		if (result.equals("1231")) {
			BClock.setEnabled(false); 	//�ð� ��ư�� ��Ȱ��ȭ ��. 
			strConfirmMessage = "��������2 �� �����.";
			AlarmBox(strConfirmMessage);
			invenpanel.add_item(7);

		} // ������ 1231�� �ԷµǾ��� ���

	} // QuizBox()

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		// drawing...

		page.drawImage(background.getImage(), 0, 0, this);

	} // paintComponent() �̹����� ��� �׷���

	public class IconListener implements ActionListener {
		private Object obj = new Object();
		private int memo = 0;

		public void actionPerformed(ActionEvent event) {
			obj = event.getSource(); // �̺�Ʈ�� �߻��� ��ü�� ��´�.

			getSound(); //��ư����� ȿ���� ���
			if (obj == BDrawer) {

				BDrawer.setEnabled(false);
				BCabinet.setEnabled(true);
				strConfirmMessage = "ĳ��� ���踦 �����.";
				AlarmBox(strConfirmMessage);
				invenpanel.add_item(10);
			}

			else if (obj == BCabinet) {
				BCabinet.setEnabled(false);
				BUndertheTable.setEnabled(true);
				strConfirmMessage = "������,��������1�� �����.";
				AlarmBox(strConfirmMessage);

				invenpanel.add_item(8);
				invenpanel.add_item(5);

			}

			else if (obj == BUndertheTable) {
				BUndertheTable.setEnabled(false);
				memo++;
				if (memo == 3)
					BLeftbookshelf.setEnabled(true);
				strConfirmMessage = "�޸�3�� �����.";
				AlarmBox(strConfirmMessage);
				invenpanel.add_item(4);

			}

			else if (obj == BHammer) {
				BHammer.setVisible(false);
				BHammer.setEnabled(false);
				BSculpture.setEnabled(true);
				strConfirmMessage = "��ġ�� �����.";
				AlarmBox(strConfirmMessage);
				invenpanel.add_item(1);
			}

			else if (obj == BSculpture) {
				BSculpture.setVisible(false);
				BSculpture.setEnabled(false);
				BBear.setEnabled(true);
				memo++;
				if (memo == 3)
					BLeftbookshelf.setEnabled(true);

				strConfirmMessage = "�޸�1�� ������ ������ �����.";
				AlarmBox(strConfirmMessage);

				invenpanel.add_item(2);
				invenpanel.add_item(11);
			}

			else if (obj == BBear) {
				BBear.setVisible(false);
				BBear.setEnabled(false);

				strConfirmMessage = "��ø�� �����.";
				AlarmBox(strConfirmMessage);
				invenpanel.add_item(9);

			}

			else if (obj == BLeftbookshelf) {
				BLeftbookshelf.setEnabled(false);
				strConfirmMessage = "å�� �����.";
				AlarmBox(strConfirmMessage);
				invenpanel.add_item(12);
			}

			else if (obj == BRightbookShelf) {
				BRightbookShelf.setEnabled(false);
				invenpanel.add_item(3);
				strConfirmMessage = "�޸�2�� �����.";
				AlarmBox(strConfirmMessage);
				memo++;
				if (memo == 3)
					BLeftbookshelf.setEnabled(true);

			}

			else if (obj == BClock) {
				QuizBox();

			}

			else if (obj == BDoorlock) {
				ThisPanel.setVisible(false);
				exitpanel.setVisible(true);

			}

			else if (obj == BInventory) {
				ThisPanel.setVisible(false);
				invenpanel.setVisible(true);

			}
			
			
		  // �̺�Ʈ�� ����� ��ü�� ���� ������ ����.
		} // if... else

	} // IconListener class

} // RommPanel class