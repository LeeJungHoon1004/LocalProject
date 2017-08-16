package Client;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SingUp extends JDialog {
	
	private SingUp self = this;
	
	private JLabel name = new JLabel("�̸� : ");
	private JTextField inputName = new JTextField();
	private JLabel gender = new JLabel("���� : ");
	private JRadioButton male = new JRadioButton("����");
	private JRadioButton female = new JRadioButton("����");

	private JLabel id = new JLabel("ID : ");
	private JTextField inputId = new JTextField();
	private JLabel pw = new JLabel("PW : ");
	private JTextField inputPw = new JTextField();
	private JLabel pwcheck = new JLabel("PWȮ�� : ");
	private JTextField inputCheck = new JTextField();
	private JButton cancel = new JButton("�ݱ�");
	private JButton sing = new JButton("�����ϱ�");
	private JPanel radioPan = new JPanel();
	private ButtonGroup group = new ButtonGroup();
	private JPanel panName = new JPanel();
	private JPanel panGender = new JPanel();
	private JPanel panID = new JPanel();
	private JPanel panPW = new JPanel();
	private JPanel panCheck = new JPanel();
	private JPanel panButtons = new JPanel();
	// =========================UI���á�=================================
	private Socket client;
	private DataOutputStream dos;
	private DataInputStream dis;

	public void compInit() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		name.setPreferredSize(new Dimension(100, 40));
		inputName.setPreferredSize(new Dimension(200, 40));
		gender.setPreferredSize(new Dimension(100, 40));
		radioPan.setPreferredSize(new Dimension(200, 40));
		id.setPreferredSize(new Dimension(100, 40));
		inputId.setPreferredSize(new Dimension(200, 40));
		pw.setPreferredSize(new Dimension(100, 40));
		inputPw.setPreferredSize(new Dimension(200, 40));
		pwcheck.setPreferredSize(new Dimension(100, 40));
		inputCheck.setPreferredSize(new Dimension(200, 40));
		cancel.setPreferredSize(new Dimension(75, 35));
		sing.setPreferredSize(new Dimension(100, 35));
		c.insets = new Insets(5, 0, 0, 0);
		panName.add(name);
		panName.add(inputName);
		c.gridy = 1;
		c.gridx = 1;
		add(panName, c);
		panGender.add(gender);
		group.add(male);
		group.add(female);
		radioPan.add(male);
		radioPan.add(female);
		panGender.add(radioPan);
		c.gridy = 2;
		c.gridx = 1;
		add(panGender, c);
		panID.add(id);
		panID.add(inputId);
		c.gridy = 3;
		c.gridx = 1;
		add(panID, c);
		panPW.add(pw);
		panPW.add(inputPw);
		c.gridy = 4;
		c.gridx = 1;
		add(panPW, c);
		panCheck.add(pwcheck);
		panCheck.add(inputCheck);
		c.gridy = 5;
		c.gridx = 1;
		add(panCheck, c);
		panButtons.add(cancel);
		panButtons.add(sing);
		c.gridy = 6;
		c.gridx = 1;
		add(panButtons, c);
	}// end

	public void eventInit() {
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = inputName.getText();
				String userID = inputId.getText();
				String userPW = inputPw.getText();
				String userCheck = inputCheck.getText();
				
				//���õ� ����,������ ������ if������ �б��Ͽ� ��ȿ���˻� �ʿ���. **�̱���**
				String malegender = male.getLabel();
				String femalegender = female.getLabel();
				
				// ��ȿ�� �˻� 1. ��ĭüũ
				System.out.println(userName.isEmpty());
				System.out.println(malegender);
				if (userName.isEmpty() || userID.isEmpty() || userPW.isEmpty() || userCheck.isEmpty()) {
					{
						
						if (male.getSelectedIcon() == null && female.getSelectedIcon() == null)
							// �����϶�		
							JOptionPane.showMessageDialog(null, "��ĭ�� ���� ���ּ���");
							return;
					}
				}

				// ��ȿ�� �˻�2. ����� ���Ȯ�ι�ȣ�� ��ġ�ϴ��� Ȯ��
				if (userCheck.equals(userPW)) {
					try {
						dos.writeUTF("����");
						dos.writeUTF(userName);
						if (male.isSelected()) {
							String userGender = male.getText();
							dos.writeUTF(userGender);
						} else if (female.isSelected()) {
							String userGender = female.getText();
							dos.writeUTF(userGender);
						}
						dos.writeUTF(userID);
						dos.writeUTF(userPW);
						dos.writeUTF(userCheck);
						JOptionPane.showMessageDialog(null, "ȸ�������� ���� ó�� �Ǿ����ϴ�.");
						dispose();
						System.out.println("������ ������ ����");
					} catch (Exception e1) {
						System.out.println("������ ������ ����");
					}
				} else if (!userCheck.equals("����")) {
				//	JOptionPane.showMessageDialog(null, "ȸ�������� ������ ó�� �Ǿ����ϴ�.");
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ�����ʽ��ϴ�.");
					return;
				}
				
				try {
					// client = new Socket("", 40000);
					client = new Socket("127.0.0.1", 40000);
					dos = new DataOutputStream(client.getOutputStream());
					dis = new DataInputStream(client.getInputStream());
					
					dos.writeUTF("ȸ������");
					//if( ���� ���� ����) //���� ������ String �̸� , String id ,String pw , String gender 
					
					
					System.out.println("ȸ�����Խõ�");
				} catch (Exception e1) {
					System.out.println("�ʱ⿬�����");
				}

				try {
					String response = dis.readUTF();
					System.out.println(response);
					if (response.equals("����")) {
						JOptionPane.showMessageDialog(self, "ȸ������ �Ǽ̽��ϴ�.");
					} else {
						JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ID�Դϴ�.");
					}
				//	System.out.println("������ �ޱ� ����!");
				} catch (Exception e2) {
				//	System.out.println("������ �ޱ� ����");
				}
			}
		});
	}// end

	public SingUp(BasicShape parent) {
		setTitle("ȸ������");
		setSize(500, 500);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		compInit();
		this.eventInit();
		setModal(true);

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
	}// end

}// class end
	// <a target="_blank"
	// href="https://m.blog.naver.com/PostView.nhn?blogId=ndb796&amp;logNo=220547775994&amp;proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F"
	// class="tx-link">https://m.blog.naver.com/PostView.nhn?blogId=ndb796&amp;logNo=220547775994&amp;proxyReferer=https://www.google.co.kr/</a>;;
	// üũ�ڽ�&amp;������ư ��
	// ****���� ��ư�� ��ư�׷쿡 �־���� �ϳ��� �����ȴ�.****
	// <a target="_blank"
	// href="http://blog.naver.com/PostView.nhn?blogId=bestheroz&amp;logNo=103957162"
	// class="tx-link">http://blog.naver.com/PostView.nhn?blogId=bestheroz&amp;logNo=103957162</a>;;
	// �Է°��� ���� �����ÿ� ��� �������� �ٽ� �Է��Ҽ� �ֵ��� focus�� ����� �ִ�.��