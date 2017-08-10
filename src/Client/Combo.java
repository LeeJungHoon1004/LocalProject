package Client;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Combo extends JFrame{

	private Combo self = this;

	private JLabel labelPhoto1 = new JLabel("����1");
	private JLabel labelPhoto2 = new JLabel("����2");
	private JLabel labelPhoto3 = new JLabel("����3");

	private JLabel labelPhotoTitle = new JLabel("Ÿ��Ʋ");

	private JLabel labelPhotoFace = new JLabel("����7");

	private JButton buttonInfo = new JButton("info");
	private JButton buttonDailyGoal = new JButton("�Ϸ��ǥ");
	private JButton buttonGoal = new JButton("��ǥ");
	private JButton buttonphoto = new JButton("����"); // ���ڽż���
	private JButton buttonvideo = new JButton("����");
	private JButton buttonCommunity = new JButton("Ŀ�´�Ƽ");

	private JButton buttonUpload = new JButton("���ε�");
	private JButton buttonRemove = new JButton("��������"); //���������� id�� �н����� ���Ȯ�� �ʿ���.
	private JButton buttonClose = new JButton("�ݱ�");


	private JPanel panelWest = new JPanel(new GridLayout(7,1)); //���̵�� 
	private JPanel panelNorth = new JPanel(); //Ÿ��Ʋ
	private JPanel panelCenter = new JPanel(new GridLayout(1,2)); // ����-����6��
	private JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	private JPanel panelCombo = new JPanel((new FlowLayout()));



	private JLabel today3 = new JLabel("������ ��ǥ�� 3�� �����ϼ���");
	public void compInit(){



		panelCenter.add(panelCombo);

		String[] action = { "1.������� �������� �̿��ϱ� ", "2.�30�� �ϱ�", "3.�Ͼ�� ��Ʈ��Ī �ϱ�", 
				"4.�������� ����̿��ϱ� ", "5.����Ʈ  30���� 3��Ʈ" , "6.�÷�ũ 1�� 3��Ʈ" ,"7.����ȸԱ�","8.�����ϸ� �������ϱ�"
				,"9.�ڱ��� �ϴ������� 5��","10.�Ͼ�� ������ ����"};

		JComboBox combolist1 = new JComboBox(action);

		combolist1.addItem(action);
		combolist1.setEditable(false);

	

		JComboBox combolist2 = new JComboBox(action);
		combolist2.addItem(action);
		combolist2.setEditable(false);

		JComboBox combolist3 = new JComboBox(action);
		combolist3.addItem(action);
		combolist3.setEditable(false);



		panelCombo.add(today3);
		panelCombo.add(combolist1);
		panelCombo.add(combolist2);
		panelCombo.add(combolist3);
		
	
		

		//		String selected1 = combolist1.getSelectedItem().toString();
		//		System.out.println(selected1);
		//		String selected2 = combolist2.getSelectedItem().toString();
		//		System.out.println(selected2);
		//		String selected3 = combolist3.getSelectedItem().toString();
		//		System.out.println(selected3);

		this.panelNorth.add(labelPhotoTitle);

		this.panelWest.add(labelPhotoFace);
		this.panelWest.add(buttonInfo);
		this.panelWest.add(buttonDailyGoal);
		this.panelWest.add(buttonGoal);
		this.panelWest.add(buttonphoto);
		this.panelWest.add(buttonvideo);
		this.panelWest.add(buttonCommunity);

		this.panelSouth.add(buttonUpload);
		this.panelSouth.add(buttonRemove);
		this.panelSouth.add(buttonClose);

		this.add(panelWest, BorderLayout.WEST);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelNorth , BorderLayout.NORTH);
		this.add(panelSouth , BorderLayout.SOUTH);
	}
	
	public void eventInit(){

		buttonUpload.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
//			self.compInit().combolist1.getSelectedItem().toString();


			}

		});
	}
	public Combo(){



		this.setLocationRelativeTo(null);
		this.setSize(800,800);
		this.setDefaultCloseOperation(Combo.EXIT_ON_CLOSE);
		this.compInit();
		this.eventInit();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Combo();
	}

}