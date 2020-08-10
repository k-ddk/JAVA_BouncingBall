import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

package BlockGame;

public class BlockGame {

	static class MyFrame extends JFrame {
		
		//constant 상수들... 은 다 대문자로!
		//그때 그때 숫자로 쓰는 것 보다는 이름으로 하는게 나아서 !
		static int BALL_WIDTH = 20;  //공의 크기 지정
		static int BALL_HEIGHT = 20;
		
		static int BLOCK_ROWS = 5;  //블록의 줄 수
		static int BLOCK_COLUMNS = 10;  //블록은 가로 세로 10개가 놓이도록..
		static int BLOCK_WIDTH = 40;  //블록 한개의 너비
		static int BLOCK_HEIGHT = 20;  //블록 한개의 높이  
		static int BLOCK_GAP = 3;  //블록들 간의 간격
		
		static int BAR_WIDTH = 80; //사용자가 움직이는 바의 크기
		static int BAR_HEIGHT = 20;
		
		//400 = (블록 한개 너비40)*(블록 칼럼10) 인데 여기 + 블록들 간의 갭! 이때 마지막 갭은 필요없으므로 빼주기
		static int CANVAS_WIDTH = 400 + (BLOCK_GAP * BLOCK_COLUMNS)-BLOCK_GAP; //캔버스 크기
		static int CANVAS_HEIGHT = 600;
		
		//variable
		static MyPanel myPanel = null;  //캔버스를 그릴 판
		static int score = 0;  //점수를 표현할 변수
		static Timer time = null;
		static Block[][] blocks = new Block[BLOCK_ROWS][BLOCK_COLUMNS];  //블록 이라는 클래스의 2차배열..
		static Bar bar = new Bar();  //Bar라는 클래스의 객체
		static Ball ball = new Ball();
		static int barXTarget = bar.x;  //Target Value 
		static int dir = 0;  //공이 움직이는 방향.. 0: Up-Right, 1: Down-Right,  2: Up-Left, 3: Down-Left
		static int ballSpeed = 5;  //공의 속도-> 나중에 난이도 높일 때 이거가 점점 빠르게??
		
		
		static class Ball {
			int x = CANVAS_WIDTH/2-BALL_WIDTH/2;  //공의 위치! 첫 화면에서는 가운데에 위치하도록!
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
			int x;  //블럭은 여러개니까 위치가 다 다르기 떄문에 초기화 하지 않는다~
			int y;
			int width = BLOCK_WIDTH;
			int height = BLOCK_HEIGHT;
			int color = 0;  //0:흰색, 1:노랑색, 2:파란색, 3:mazenta, 4:빨간색<- 공 색에 따라 점수가 다름
		    boolean isHidden = false;  //충돌 이후 블록이 사라지도록
		}
		
		static class MyPanel extends JPanel {  //JPanel을 상속받는 클래스 MyPanel
			
		}
		
		//생성자
		public MyFrame(String title) {
			super(title);
			this.setVisible(true);  //화면이 나타나도록 true값!
			this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
			this.setLocation(400, 300);  //창이 뜨는 위치!
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //이 옵션을 넣어야 창이 닫힘
			
			initData();
			
			myPanel = new MyPanel();  //패널을 만들고 이거를 전체 프레임에 넣어줘야함..
			this.add("Center", myPanel);
			
			setKeyListener();  //키보드로 바를 움직여야 하므로 
			startTimer();
		}
		public void initData() {  //상수들을 실제로 초기화 해주는 함수
			
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
