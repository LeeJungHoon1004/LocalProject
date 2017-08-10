package Client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

	
	//COMPNENT - defaultPan
	private JPanel defaultPan = new JPanel(new GridLayout(2,1));
	private JPanel panelUpper = new JPanel();
	private JPanel panellower = new JPanel();
	private JLabel labelUpper = new JLabel("�̹��������̵�1");
	private JLabel labellower = new JLabel("�̹���BMI");

	
	
	private JPanel goalPan = new JPanel();
	
	
	
	
	private JPanel dailyPan = new JPanel();
	
	
	
	
	
	private JPanel videoPan = new JPanel();
	
	
	
	
	
	//COMPNENT - imgBoardPan
	private JLabel labelPhoto1 = new JLabel("����1");
	private JLabel labelPhoto2 = new JLabel("����2");
	private JLabel labelPhoto3 = new JLabel("����3");
	private JButton buttonUpload = new JButton("���ε�");
	private JButton buttonRemove = new JButton("��������"); //���������� id�� �н����� ���Ȯ�� �ʿ���.
	private JButton buttonClose = new JButton("�ݱ�");
	private JPanel imgBoardPan = new JPanel(new GridLayout(3,1));
	private JPanel panelnull = new JPanel();
	private JPanel panelCenter = new JPanel(new GridLayout(1,3)); // ����-����3��
	private JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	

 	// =======COMPONENT========================

	public void comp() {

		setLayout(null);
		
		this.panelUpper.add(labelUpper);
		this.panellower.add(labellower);
		this.defaultPan.add(panelUpper);
		this.defaultPan.add(panellower);
		
		//compInit() -defaultPan
		
		this.panelCenter.add(labelPhoto1);
		this.panelCenter.add(labelPhoto2);
		this.panelCenter.add(labelPhoto3);
		this.panelSouth.add(buttonUpload);
		this.panelSouth.add(buttonRemove);
		this.panelSouth.add(buttonClose);
		this.imgBoardPan.add(panelCenter);
		this.imgBoardPan.add(panelnull);
		this.imgBoardPan.add(panelSouth);
		
		//compInit()  - panelCard_StimulsPhoto
		
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
		sidepan.setBounds(0,81,200,645);
		add(sidepan);
		
		
		
		mainPan.add(defaultPan, "NamedefaultPane");
		mainPan.add(goalPan);
		mainPan.add(dailyPan);
		mainPan.add(videoPan);
		mainPan.add(imgBoardPan , "NameimgBoard"); //ī��� �����ִ��ҿ�
											//�̸��� �ο��� .
											//�ο��� �̸��� ������ �̺�Ʈ ó���κп���
											//ī���� �̸����� �ĺ��Ͽ� visible��.
		
		this.setResizable(false);
		this.sc.setBounds(200, 79, 1000, 650);
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
			//	card.next(self.mainPan);
				card.show(self.mainPan, "NameimgBoard");
				
			}
		});
		
		title.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			//���콺��ư�� ������ ������ �̺�Ʈó��
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				card.show(self.mainPan, "NamedefaultPane");
			}
			
		});
		
		//===============EVENTINIT()=========imgBoardPan
		this.buttonUpload.addActionListener(new ActionListener(){
			//���� ���ε�� xxȸ������ ����. �� ���ܵ� . 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.buttonClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.buttonRemove.addActionListener(new ActionListener(){
			//���� ������ ȸ���� ���̵�� ��й�ȣ�� �ѹ��Է¹޾Ƽ� Ȯ���� �ش�ȸ���� �����ϰ�쿡 ���� . 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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