package Client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class BasicShape extends JFrame {
	private Socket client;
	private DataOutputStream dos;
	private DataInputStream dis;

	// =======SOCKET========================

	private Container cp = this.getContentPane();

	private JLabel lbID = new JLabel("���̵� :");
	private JTextField inputID = new JTextField();

	private JLabel lbPW = new JLabel("��й�ȣ :");
	private JPasswordField inputPW = new JPasswordField();

	private JButton membership = new JButton("ȸ������");
	private JButton login = new JButton("�α���");
	private JLabel title = new JLabel("title", JLabel.CENTER);
	private Font font = new Font("����", Font.ITALIC, 30);

	private JButton goalBt = new JButton("���� ��ǥ");
	private JButton dailyBt = new JButton("�Ϸ� ��ǥ");
	private JButton videoBt = new JButton("�����");
	private JButton imgBoardBt = new JButton("�����Խ���");

	private JPanel category = new JPanel(new GridLayout(4, 1));
	private JPanel picture = new JPanel();
	private JPanel bmi = new JPanel();

	private JPanel titlePan = new JPanel();
	private JPanel panbox1 = new JPanel(new GridLayout(1, 2));
	private JPanel panbox2 = new JPanel(new GridLayout(1, 2));
	private JPanel panbox3 = new JPanel(new GridLayout(1, 2));
	private JPanel panbox = new JPanel(new GridLayout(3, 1));
	private JPanel sidepan = new JPanel(new GridLayout(5,1));
	
	private CardLayout card = new CardLayout();
	private BasicShape self = this;
	private JPanel mainPan = new JPanel(card);
	private JScrollPane sc = new JScrollPane(mainPan);

	private JPanel goalPan = new JPanel();
	private JPanel dailyPan = new JPanel();
	private JPanel videoPan = new JPanel();
	private JPanel imgBoardPan = new JPanel();

	public void comp() {

		setLayout(null);
		
		category.add(goalBt);
		category.add(dailyBt);
		category.add(videoBt);
		category.add(imgBoardBt);

		panbox1.add(lbID);
		panbox1.add(inputID);
		panbox2.add(lbPW);
		panbox2.add(inputPW);
		panbox3.add(login);
		panbox3.add(membership);
		panbox.add(panbox1);
		panbox.add(panbox2);
		panbox.add(panbox3);

		title.setFont(font);
		titlePan.add(title);
		

		sidepan.add(panbox);
		sidepan.add(category);

		titlePan.setBounds(0,0,1400,80);
		add(titlePan);
		sidepan.setBounds(0,81,200,630);
		add(sidepan);

		mainPan.add(goalPan);
		mainPan.add(dailyPan);
		mainPan.add(videoPan);
		mainPan.add(imgBoardPan);
		this.sc.setBounds(200, 79, 985, 635);
		add(sc);

	}

	public void eventInit() {
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �α���
				try {
					client = new Socket("", 4000);
					dos = new DataOutputStream(client.getOutputStream());
					dis = new DataInputStream(client.getInputStream());
					System.out.println("�ʱ⿬�Ἲ��");
				} catch (Exception e1) {
					System.out.println("�ʱ⿬�����");
				}

				String userID = inputID.getText();
				String userPW = inputPW.getText();

				try {
					dos.writeUTF("�α���");
					dos.writeUTF(userID);
					dos.writeUTF(userPW);
					System.out.println("�����ͺ����� ����");
				} catch (Exception e1) {
					System.out.println("������ ������ ����");
				}

				try {
					String result = dis.readUTF();

					if (result.equals("�α��μ���")) {
						JOptionPane.showMessageDialog(null, "�α��� ����");
						
					} else if(result.equals("�α��ν���")) {
						JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�.");
					}
					System.out.println("�α��� ����");
				} catch (Exception e2) {
					System.out.println("�α��� ����");
				}
			}
		});

		membership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ȸ������â ����
				new SingUp(self).setVisible(true);
			}
		});

		goalBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(goalPan);
			}
		});

		dailyBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(dailyPan);

			}
		});

		videoBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(videoPan);

			}
		});

		imgBoardBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(imgBoardPan);

			}
		});
	}

	public BasicShape() {
		setTitle("�⺻shape�׽�Ʈ");
		//setSize(700, 500);
		setSize(1200, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp.setBackground(Color.WHITE);
		comp();
		eventInit();
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		new BasicShape();
	}// main end
}

// http://msource.tistory.com/5
// ī�巹�̾ƿ� ���� ����
//http://www.w3ii.com/ko/swing/swing_cardlayout.html
//ī�巹�̾ƿ� Ŭ����