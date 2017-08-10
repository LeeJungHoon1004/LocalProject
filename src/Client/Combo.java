package Client;




//�׳� ������ ���������� ��ǥ��( �޺��ڽ�����)
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class Combo extends JFrame implements ActionListener{

	Container con;


	private Combo self = this;

	private JLabel labelPhoto1 = new JLabel("����1");
	private JLabel labelPhoto2 = new JLabel("����2");
	private JLabel labelPhoto3 = new JLabel("����3");

	private JLabel labelPhotoTitle = new JLabel("Ÿ��Ʋ");

	private JLabel labelPhotoFace = new JLabel("����7");

	private JButton buttonInfo = new JButton("info");
	private JButton buttonDailyGoal = new JButton("�Ϸ��ǥ");
	private JButton buttonGoal = new JButton("��ǥ");
	private JButton buttonphoto = new JButton("����"); 
	private JButton buttonvideo = new JButton("����");
	private JButton buttonCommunity = new JButton("Ŀ�´�Ƽ");

	private JButton buttonUpload = new JButton("���ε�");
	 
	private JButton buttonClose = new JButton("Ȩ����");
	private JButton buttonclear = new JButton("���ÿϷ�");


	private JPanel panelWest = new JPanel(new GridLayout(7,1)); //���̵�� 
	private JPanel panelNorth = new JPanel(); //Ÿ��Ʋ
	private JPanel panelCenter = new JPanel(new GridLayout(2,1)); // ����-����6��
	private JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	private JPanel panelCombo = new JPanel((new FlowLayout()));
	private JPanel panelwater = new JPanel((new FlowLayout()));



	private JLabel today3 = new JLabel("������ ��ǥ�� 3�� �����ϼ���");
	private JLabel waterchecklabel = new JLabel("������ Ƚ���� üũ�غ�����");

	private JButton fullcup = new JButton(new ImageIcon("full2.PNG"));

	private JButton cupb1 = new JButton(new ImageIcon("empty2.PNG"));

	private JButton cupb2= new JButton(new ImageIcon("empty2.PNG"));
	private JButton cupb3 = new JButton(new ImageIcon("empty2.PNG"));

	private JButton cupb4 = new JButton(new ImageIcon("empty2.PNG"));
	private JButton cupb5 = new JButton(new ImageIcon("empty2.PNG"));





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

		panelCenter.add(panelCombo,BorderLayout.NORTH);
		panelCenter.add(panelwater,BorderLayout.SOUTH);

		panelCombo.add(today3);
		panelCombo.add(combolist1);
		panelCombo.add(combolist2);
		panelCombo.add(combolist3);

		panelwater.add(waterchecklabel);
		panelwater.add(cupb1);
		
		panelwater.add(cupb2);
		panelwater.add(cupb3);
		panelwater.add(cupb4);
		panelwater.add(cupb5);

//��ưũ�⿡ ���� �̹�������
		cupb1.setBorderPainted(false);
		cupb1.setFocusPainted(false); 
		cupb1.setContentAreaFilled(false);
		cupb1.addActionListener(this); 

		setVisible(true);

		cupb2.setBorderPainted(false);
		cupb2.setFocusPainted(false); 
		cupb2.setContentAreaFilled(false);
		cupb2.addActionListener(this); 

		setVisible(true);

		cupb3.setBorderPainted(false);
		cupb3.setFocusPainted(false); 
		cupb3.setContentAreaFilled(false);
		cupb3.addActionListener(this); 

		setVisible(true);

		cupb4.setBorderPainted(false);
		cupb4.setFocusPainted(false); 
		cupb4.setContentAreaFilled(false);
		cupb4.addActionListener(this); 

		setVisible(true);

		cupb5.setBorderPainted(false);
		cupb5.setFocusPainted(false); 
		cupb5.setContentAreaFilled(false);
		cupb5.addActionListener(this); 

		setVisible(true);


		this.panelNorth.add(labelPhotoTitle);

		this.panelWest.add(labelPhotoFace);
		this.panelWest.add(buttonInfo);
		this.panelWest.add(buttonDailyGoal);
		this.panelWest.add(buttonGoal);
		this.panelWest.add(buttonphoto);
		this.panelWest.add(buttonvideo);
		this.panelWest.add(buttonCommunity);

		this.panelSouth.add(buttonUpload);
		
		this.panelSouth.add(buttonClose);
		this.panelCombo.add(buttonclear);
		

		this.add(panelWest, BorderLayout.WEST);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelNorth , BorderLayout.NORTH);
		this.add(panelSouth , BorderLayout.SOUTH);



		setVisible(true);



	}

	void init(){
		cupb1.setIconTextGap(1);
		fullcup.setIconTextGap(1);
		con=this.getContentPane();
		con.add("Center",cupb1);
	}

	 void start(){
		  cupb1.addActionListener(this);
		  fullcup.addActionListener(this);
		     
		 }
	public void eventInit(){


		
		
		cupb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((e.getSource()).equals(cupb1)){
					con.removeAll();
					con.add(fullcup);
					fullcup.updateUI();
				}
				else{
					con.removeAll();
					con.add(cupb1);
					cupb1.updateUI();
				}
			}

		});
		
		buttonclear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 String msg = buttonclear.getText();
	               if(JOptionPane.showConfirmDialog(null, msg, "���ÿϷ�!",  JOptionPane.OK_CANCEL_OPTION)==0) {
	                  //System.out.println("Ȯ��");
				
			}
			
		}
			
		});
		
		this.buttonClose.addActionListener(new ActionListener(){

			//��ưNo�� ���������� �̺�Ʈó��
			@Override
			public void actionPerformed(ActionEvent e) {
				//���̾�α�â �ݱ� . - Ŭ����.this �� �ν��Ͻ� �����θ� ��Ű��
				// JDialog�� ��ӹ޾� ���� Ŭ������ �ν���ȭ�Ǿ��ֱ⋚����
				//�� �ν��Ͻ��� �������� �޼ҵ带 �����ִ�.
				//Ŭ������ . ������ JDialog�� ��ӹ��� Ŭ������ ����Ű�� ������ Ŭ������ . �� �����ִ� Static Field�� ���δ�.
				Combo.this.dispose();
				
			}
		});
	

		//���ε��ư ������
		//		buttonUpload.addActionListener(new ActionListener(){
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				//			self.compInit().combolist1.getSelectedItem().toString();
		//
		//			}
		//
		//		});
	}




	public Combo(){




		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Combo.EXIT_ON_CLOSE);
		this.init();
		this.start();
		this.compInit();
		this.eventInit();
		
		this.setVisible(true);
		



	}

	public static void main(String[] args) {
		new Combo();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}