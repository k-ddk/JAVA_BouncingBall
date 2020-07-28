package bouncing_ball_ver_4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; //ctrl + shift+ o �ϸ� �ʿ��� ��Ű��? �� �ڵ����� import ��


public class BouncingBall extends JFrame {

	//�ڹٿ��� �����ϴ� ������� �̹����� ���� ���۸� ������ ����-> ���� ���۸� ��� �̿�
	//������۸� ���: ���� ���α׷��� ��ü ȭ�� ũ�⿡ �´� �̹����� �� ���� �����ؼ� ���ϴ� ������Ʈ?�� ȭ�鿡 ����ϴ� ���
	//���ۿ� �̹����� ��Ƽ� �� �������� �̹����� ������ ��
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_���ϴó�����.png")).getImage();
	//menuBar ��ü �����
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/on_button.png")));
	
	private int mouseX, mouseY;
	
	public BouncingBall() {
		//���� �����ϴ� �޴��ٰ� ������ �ʰ� �� ��
		setUndecorated(true);
		
		setTitle("Bouncing Ball**"); //���� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //���� â ũ�� ����
		setResizable(false); //���� â�� �� �� ���������, ����ڰ� ������ �� ����
		setLocationRelativeTo(null); //���� â�� ��ǻ�� ���߾ӿ� �߰� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���� â �����, ��ü ���α׷� ����
		setVisible(true); //���� â�� ���������� ��µ�
		                 //�� �⺻���� false �� ������ true�� �־���� ��
		//�߰��ϴ� �޴����� �޺κ��� �Ͼ������??
		setBackground(new Color(0, 0, 0, 0));
		//��ư�̳� JLabel�� �־��� �� ������ ��ġ �״�� ��Ÿ���� ��
		setLayout(null);
		
		//�޴����� ��ġ�� ũ�⸦ ������
		menuBar.setBounds(0, 0, 1280, 30);
		//JFrame�� �޴��ٰ� �߰���, ���߿� �׷��� ���� �Ʒ��� paintComponents�� ���� �׷���
		add(menuBar);
		
		exitButton.setBounds(50, 50, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		add(exitButton);
		
		//���α׷� ������ �� ���� ���� ��� �ݺ�
		//true ���� ��� ������ ���� �����ϱ� �������� ���� ��� �ݺ�
		Music introMusic = new Music("introMusic.mp3", true);
	    introMusic.start();
	}
	
	//�޼ҵ� �߰����ֱ�
	//paint�� JFrame�� ��ӹ��� GUI ���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ�
	public void paint(Graphics g) {
		
		//1280x720 ũ���� �̹����� ���� �־���
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		
		//screenImage�� �̿��ؼ� �׷��� ��ü�� ����
		screenGraphic = screenImage.getGraphics();
		
		//���� ���� ���ο� �Լ�
		screenDraw(screenGraphic); 
		
		//���� â�� �̹����� ��Ÿ���� ��
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		
		//introBackground�� screenImage�� �׷��� �� �ֵ���
		//�ܼ��� ����̹���, ������ �̹����� ����ִ� ��~
		g.drawImage(introBackground, 0, 0, null);
	    //JFrame���� �߰��� �͵鵵 �׷���
		//JLabel���� �͵��� �����~
		paintComponents(g);
		//���α׷��� ����Ǵ� �������� ��� paint �Լ��� �θ��鼭 �̹����� �����
		this.repaint();
	    
	}
}
