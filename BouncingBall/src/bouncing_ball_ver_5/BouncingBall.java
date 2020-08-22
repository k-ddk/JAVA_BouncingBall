package bouncing_ball_ver_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; //ctrl + shift+ o �ϸ� �ʿ��� ��Ű��? �� �ڵ����� import ��

public class BouncingBall extends JFrame {

	// �ڹٿ��� �����ϴ� ������� �̹����� ���� ���۸� ������ ����-> ���� ���۸� ��� �̿�
	// ������۸� ���: ���� ���α׷��� ��ü ȭ�� ũ�⿡ �´� �̹����� �� ���� �����ؼ� ���ϴ� ������Ʈ?�� ȭ�鿡 ����ϴ� ���
	// ���ۿ� �̹����� ��Ƽ� �� �������� �̹����� ������ ��
	private Image screenImage;
	private Graphics screenGraphic;

	// menuBar ��ü �����
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar_�ణǪ��ȸ��.png")));

	private ImageIcon exitButtonHoverImage = new ImageIcon(Main.class.getResource("../images/off_button.png"));
	private ImageIcon exitButtonDefaultImage = new ImageIcon(Main.class.getResource("../images/on_button.png"));
	private ImageIcon startButtonHoverImage = new ImageIcon(Main.class.getResource("../images/start_button(hover)_�����ϴû�.png"));
	private ImageIcon startButtonDefaultImage = new ImageIcon(Main.class.getResource("../images/start_button(default).png"));
	private ImageIcon quitButtonHoverImage = new ImageIcon(Main.class.getResource("../images/quit_button(hover)_�����ϴû�.png"));
	private ImageIcon quitButtonDefaultImage = new ImageIcon(Main.class.getResource("../images/quit_button(default).png"));
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground_���ϴó�����.png"))
			.getImage();
	
	private JButton exitButton = new JButton(exitButtonDefaultImage);
	private JButton startButton = new JButton(startButtonDefaultImage);
	private JButton quitButton = new JButton(quitButtonDefaultImage);
	
	//���� ���α׷��ȿ��� ���콺�� X, Y �� ��ü�� �ǹ�
	private int mouseX, mouseY;

	public BouncingBall() {
		// ���� �����ϴ� �޴��ٰ� ������ �ʰ� �� ��
		setUndecorated(true);
		setTitle("Bouncing Ball**"); // ���� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ���� â ũ�� ����
		setResizable(false); // ���� â�� �� �� ���������, ����ڰ� ������ �� ����
		setLocationRelativeTo(null); // ���� â�� ��ǻ�� ���߾ӿ� �߰� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� â �����, ��ü ���α׷� ����
		setVisible(true); // ���� â�� ���������� ��µ�
							// �� �⺻���� false �� ������ true�� �־���� ��
		// �߰��ϴ� �޴����� �޺κ��� �Ͼ������, ���� ������ ���� �״�� ���� �� �ְ�
		setBackground(new Color(0, 0, 0, 0));
		// ��ư�̳� JLabel�� �־��� �� ������ ��ġ �״�� ��Ÿ���� ��
		setLayout(null);

		
		exitButton.setBounds(1207, -11, 64, 60);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			//���콺�� ��ư ���� �ö���� ��
			public void mouseEntered(MouseEvent e) {
				//������ �̹����� �ٲ���
				exitButton.setIcon(exitButtonHoverImage);
				//���콺�� �ö��� �� �հ��� ������� �ٲ�
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//�� ���� ����ǵ���
				Music buttonEnteredMusic = new Music("���콺ȣ��.mp3", false);
				buttonEnteredMusic.start();
				
			}
			@Override
			//���콺�� ��ư ������ �������� ��
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonDefaultImage);
				//�ٽ� ���� ����� ���콺�� ���ư�
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			//��ư�� ������ Ŭ������ ��
			public void mousePressed(MouseEvent e) {
				//�� ���� ����ǵ��� 
				//�ٵ� �̶� ������ ���Ȱ� ���ÿ� ���α׷��� ����Ǳ� ������ �Ҹ��� �鸱 �� �ֵ���
				Music buttonEnteredMusic = new Music("���콺Ŭ��_����.mp3", false);
				buttonEnteredMusic.start();
				try {
					//�Ҹ��� ��� ����� �� �ֵ���
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(515, 400, 230, 96);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			//���콺�� ��ư ���� �ö���� ��
			public void mouseEntered(MouseEvent e) {
				//������ �̹����� �ٲ���
				startButton.setIcon(startButtonHoverImage);
				//���콺�� �ö��� �� �հ��� ������� �ٲ�
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//�� ���� ����ǵ���
				Music buttonEnteredMusic = new Music("���콺ȣ��.mp3", false);
				buttonEnteredMusic.start();
				
			}
			@Override
			//���콺�� ��ư ������ �������� ��
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonDefaultImage);
				//�ٽ� ���� ����� ���콺�� ���ư�
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			//��ư�� ������ Ŭ������ ��
			public void mousePressed(MouseEvent e) {
				//�� ���� ����ǵ��� 
				//�ٵ� �̶� ������ ���Ȱ� ���ÿ� ���α׷��� ����Ǳ� ������ �Ҹ��� �鸱 �� �ֵ���
				Music buttonEnteredMusic = new Music("���콺Ŭ��_����.mp3", false);
				buttonEnteredMusic.start();
				
				//���� ��ư�� ������ ��ư�� �����
				startButton.setVisible(false);
				quitButton.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/���ϴ�.jpg")).getImage();
				
			}
		});
		add(startButton);
		
		quitButton.setBounds(515, 530, 230, 96);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			//���콺�� ��ư ���� �ö���� ��
			public void mouseEntered(MouseEvent e) {
				//������ �̹����� �ٲ���
				quitButton.setIcon(quitButtonHoverImage);
				//���콺�� �ö��� �� �հ��� ������� �ٲ�
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//�� ���� ����ǵ���
				Music buttonEnteredMusic = new Music("���콺ȣ��.mp3", false);
				buttonEnteredMusic.start();
				
			}
			@Override
			//���콺�� ��ư ������ �������� ��
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonDefaultImage);
				//�ٽ� ���� ����� ���콺�� ���ư�
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			//��ư�� ������ Ŭ������ ��
			public void mousePressed(MouseEvent e) {
				//�� ���� ����ǵ��� 
				//�ٵ� �̶� ������ ���Ȱ� ���ÿ� ���α׷��� ����Ǳ� ������ �Ҹ��� �鸱 �� �ֵ���
				Music buttonEnteredMusic = new Music("���콺Ŭ��_����.mp3", false);
				buttonEnteredMusic.start();
				try {
					//�Ҹ��� ��� ����� �� �ֵ���
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		// �޴����� ��ġ�� ũ�⸦ ������
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			//���콺�� ������ ������ ���� �̺�Ʈ ó��
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			//�巡�� �̺�Ʈ�� �߻����� ��
			public void mouseDragged(MouseEvent e) {
				//��ũ�������� �� x, y�� ��ǥ�� ������
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				//JFrame�� ��ġ �ٲ��ֱ�
				setLocation(x-mouseX, y-mouseY);
			}
		});
		// JFrame�� �޴��ٰ� �߰���, ���߿� �׷��� ���� �Ʒ��� paintComponents�� ���� �׷���
		add(menuBar);

		// ���α׷� ������ �� ���� ���� ��� �ݺ�
		// true ���� ��� ������ ���� �����ϱ� �������� ���� ��� �ݺ�
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	// �޼ҵ� �߰����ֱ�
	// paint�� JFrame�� ��ӹ��� GUI ���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ�
	public void paint(Graphics g) {

		// 1280x720 ũ���� �̹����� ���� �־���
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

		// screenImage�� �̿��ؼ� �׷��� ��ü�� ����
		screenGraphic = screenImage.getGraphics();

		// ���� ���� ���ο� �Լ�
		screenDraw(screenGraphic);

		// ���� â�� �̹����� ��Ÿ���� ��
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {

		// background�� screenImage�� �׷��� �� �ֵ���
		// �ܼ��� ����̹���, ������ �̹����� ����ִ� ��~
		g.drawImage(background, 0, 0, null);
		// JLabel���� �͵��� JFrame �ȿ� �߰��ϸ� ����ִ� ����
		paintComponents(g);
		// ���α׷��� ����Ǵ� �������� ��� paint �Լ��� �θ��鼭 �̹����� �����
		this.repaint();

	}
}
