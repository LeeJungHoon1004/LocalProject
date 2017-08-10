package Client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.border.TitledBorder;


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

	private JPanel panbox1 = new JPanel(new GridLayout(1, 2));
	private JPanel panbox2 = new JPanel(new GridLayout(1, 2));
	private JPanel panbox3 = new JPanel(new GridLayout(1, 2));
	private JPanel panbox = new JPanel(new GridLayout(3, 1));

	private TitledBorder tborder;

	private JPanel pan = new JPanel();
	private JScrollPane sc = new JScrollPane(pan);
	
	private CardLayout card = new CardLayout();
	private BasicShape self = this;

	public void comp() {
		setLayout(new BorderLayout());
		// tborder = new TitledBorder("");
		// tborder.setTitlePosition(TitledBorder.ABOVE_TOP);// ������ ��ġ�� Ÿ��Ʋ��
		// ��Ÿ���ִ� ����
		// tborder.setTitleJustification(TitledBorder.CENTER);// �ڸ������� ����� ����
		//
		// title.setBorder(tborder);
		// title.setFont(font);

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

		pan.add(panbox);
		pan.add(category);

		add(pan);
		// //this.sc.setBounds(0, 0, 1185, 715);
		// this.sc.setBounds(0, 0, 1185, 700);
		//this.sc.setBounds(0, 0, 700, 500);
		//add(sc, BorderLayout.CENTER);

	}

	public void changePanel() {
		card.next(this.getContentPane());
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
				// card.show(card,"goalPage");
				// card.changePanel();
				// ���� �̷������� ����.
			}
		});

		dailyBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		videoBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		imgBoardBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public BasicShape() {
		setTitle("�⺻shape�׽�Ʈ");
		setSize(700, 500);
		// setSize(1200, 750);
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