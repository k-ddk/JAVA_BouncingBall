import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

package BlockGame;

public class BlockGame {

	static class MyFrame extends JFrame {
		
		//constant �����... �� �� �빮�ڷ�!
		//�׶� �׶� ���ڷ� ���� �� ���ٴ� �̸����� �ϴ°� ���Ƽ� !
		static int BALL_WIDTH = 20;  //���� ũ�� ����
		static int BALL_HEIGHT = 20;
		
		static int BLOCK_ROWS = 5;  //����� �� ��
		static int BLOCK_COLUMNS = 10;  //����� ���� ���� 10���� ���̵���..
		static int BLOCK_WIDTH = 40;  //��� �Ѱ��� �ʺ�
		static int BLOCK_HEIGHT = 20;  //��� �Ѱ��� ����  
		static int BLOCK_GAP = 3;  //��ϵ� ���� ����
		
		static int BAR_WIDTH = 80; //����ڰ� �����̴� ���� ũ��
		static int BAR_HEIGHT = 20;
		
		//400 = (��� �Ѱ� �ʺ�40)*(��� Į��10) �ε� ���� + ��ϵ� ���� ��! �̶� ������ ���� �ʿ�����Ƿ� ���ֱ�
		static int CANVAS_WIDTH = 400 + (BLOCK_GAP * BLOCK_COLUMNS)-BLOCK_GAP; //ĵ���� ũ��
		static int CANVAS_HEIGHT = 600;
		
		//variable
		static MyPanel myPanel = null;  //ĵ������ �׸� ��
		static int score = 0;  //������ ǥ���� ����
		static Timer time = null;
		static Block[][] blocks = new Block[BLOCK_ROWS][BLOCK_COLUMNS];  //��� �̶�� Ŭ������ 2���迭..
		static Bar bar = new Bar();  //Bar��� Ŭ������ ��ü
		static Ball ball = new Ball();
		static int barXTarget = bar.x;  //Target Value 
		static int dir = 0;  //���� �����̴� ����.. 0: Up-Right, 1: Down-Right,  2: Up-Left, 3: Down-Left
		static int ballSpeed = 5;  //���� �ӵ�-> ���߿� ���̵� ���� �� �̰Ű� ���� ������??
		
		
		static class Ball {
			int x = CANVAS_WIDTH/2-BALL_WIDTH/2;  //���� ��ġ! ù ȭ�鿡���� ����� ��ġ�ϵ���!
			int y = CANVAS_HEIGHT/2 - BALL_HEIGHT/2;
			int width = BALL_WIDTH;
			int height = BALL_HEIGHT;
		}
		
		static class Bar {
			int x = CANVAS_WIDTH/2-BAR_WIDTH/2;
			int y = CANVAS_HEIGHT-100;
			int width = BAR_WIDTH;
			int height = BAR_HEIGHT;
		}
		
		static class Block {
			int x;  //���� �������ϱ� ��ġ�� �� �ٸ��� ������ �ʱ�ȭ ���� �ʴ´�~
			int y;
			int width = BLOCK_WIDTH;
			int height = BLOCK_HEIGHT;
			int color = 0;  //0:���, 1:�����, 2:�Ķ���, 3:mazenta, 4:������<- �� ���� ���� ������ �ٸ�
		    boolean isHidden = false;  //�浹 ���� ����� ���������
		}
		
		static class MyPanel extends JPanel {  //JPanel�� ��ӹ޴� Ŭ���� MyPanel
			
		}
		
		//������
		public MyFrame(String title) {
			super(title);
			this.setVisible(true);  //ȭ���� ��Ÿ������ true��!
			this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
			this.setLocation(400, 300);  //â�� �ߴ� ��ġ!
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //�� �ɼ��� �־�� â�� ����
			
			initData();
			
			myPanel = new MyPanel();  //�г��� ����� �̰Ÿ� ��ü �����ӿ� �־������..
			this.add("Center", myPanel);
			
			setKeyListener();  //Ű����� �ٸ� �������� �ϹǷ� 
			startTimer();
		}
		public void initData() {  //������� ������ �ʱ�ȭ ���ִ� �Լ�
			
		}
		public void setKeyListener() {
			
		}
		public void startTimer() {
			
		}
	}
	public static void main(String[] args) {
		
		new MyFrame("Block Game");

	}

}
