package bouncing_ball_ver_3;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame; //ctrl + shift+ o �ϸ� �ʿ��� ��Ű��? �� �ڵ����� import ��


public class BouncingBall extends JFrame {

	//�ڹٿ��� �����ϴ� ������� �̹����� ���� ���۸� ������ ����-> ���� ���۸� ��� �̿�
	//������۸� ���: ���� ���α׷��� ��ü ȭ�� ũ�⿡ �´� �̹����� �� ���� �����ؼ� ���ϴ� ������Ʈ?�� ȭ�鿡 ����ϴ� ���
	//���ۿ� �̹����� ��Ƽ� �� �������� �̹����� ������ ��
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground; //IntroBackground ��� ���� ���� �� �̹����� ���� �� �ִ� ��ü 
	
	public BouncingBall() {
		setTitle("Bouncing Ball**"); //���� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //���� â ũ�� ����
		setResizable(false); //���� â�� �� �� ���������, ����ڰ� ������ �� ����
		setLocationRelativeTo(null); //���� â�� ��ǻ�� ���߾ӿ� �߰� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���� â �����, ��ü ���α׷� ����
		setVisible(true); //���� â�� ���������� ��µ�
		                 //�� �⺻���� false �� ������ true�� �־���� ��
		
		//MainŬ������ ��ġ�� ������� IntroBackground��� �̹����� ���� ��
		//�װ��� �̹��� �ν��Ͻ��� introBackground��� ������ �ʱ�ȭ ���شٴ� �ǹ�
		//******* �̹��� ���� ���� �� ���� ���� �̹��� ���� �������� ī������ ���� ���Ϸ� ������!�� �� , 
		//******* ī������ �ٿ������ ũ�Ⱑ �ڵ����� �۾���!
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_���ϴó�����.png")).getImage();
		
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
		g.drawImage(introBackground, 0, 0, null);
	    
		//���α׷��� ����Ǵ� �������� ��� paint �Լ��� �θ��鼭 �̹����� �����
		this.repaint();
	    
	}
}
