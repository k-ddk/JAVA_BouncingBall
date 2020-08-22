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
import javax.swing.JLabel; //ctrl + shift+ o 하면 필요한 패키지? 가 자동으로 import 됨

public class BouncingBall extends JFrame {

	// 자바에서 제공하는 방식으로 이미지를 띄우면 버퍼링 현상이 심함-> 더블 버퍼링 기법 이용
	// 더블버퍼링 기법: 현재 프로그램이 전체 화면 크기에 맞는 이미지를 매 순간 생성해서 원하는 컴포런트?만 화면에 출력하는 방식
	// 버퍼에 이미지를 담아서 매 순간마다 이미지를 갱신해 줌
	private Image screenImage;
	private Graphics screenGraphic;

	// menuBar 객체 만들기
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar_약간푸른회색.png")));

	private ImageIcon exitButtonHoverImage = new ImageIcon(Main.class.getResource("../images/off_button.png"));
	private ImageIcon exitButtonDefaultImage = new ImageIcon(Main.class.getResource("../images/on_button.png"));
	private ImageIcon startButtonHoverImage = new ImageIcon(Main.class.getResource("../images/start_button(hover)_밝은하늘색.png"));
	private ImageIcon startButtonDefaultImage = new ImageIcon(Main.class.getResource("../images/start_button(default).png"));
	private ImageIcon quitButtonHoverImage = new ImageIcon(Main.class.getResource("../images/quit_button(hover)_밝은하늘색.png"));
	private ImageIcon quitButtonDefaultImage = new ImageIcon(Main.class.getResource("../images/quit_button(default).png"));
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground_밤하늘내버전.png"))
			.getImage();
	
	private JButton exitButton = new JButton(exitButtonDefaultImage);
	private JButton startButton = new JButton(startButtonDefaultImage);
	private JButton quitButton = new JButton(quitButtonDefaultImage);
	
	//각각 프로그램안에서 마우스의 X, Y 값 자체를 의미
	private int mouseX, mouseY;

	public BouncingBall() {
		// 원래 존재하던 메뉴바가 보이지 않게 해 줌
		setUndecorated(true);
		setTitle("Bouncing Ball**"); // 게임 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기 설정
		setResizable(false); // 게임 창이 한 번 만들어지면, 사용자가 변경할 수 없음
		setLocationRelativeTo(null); // 게임 창이 컴퓨터 정중앙에 뜨게 됨
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 창 종료시, 전체 프로그램 종료
		setVisible(true); // 게임 창이 정상적으로 출력됨
							// 의 기본값은 false 기 때문에 true로 넣어줘야 함
		// 추가하는 메뉴바의 뒷부분이 하얀색으로, 내가 설정한 색이 그대로 나올 수 있게
		setBackground(new Color(0, 0, 0, 0));
		// 버튼이나 JLabel을 넣었을 때 지정한 위치 그대로 나타나게 됨
		setLayout(null);

		
		exitButton.setBounds(1207, -11, 64, 60);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			//마우스가 버튼 위에 올라왔을 때
			public void mouseEntered(MouseEvent e) {
				//아이콘 이미지를 바꿔줌
				exitButton.setIcon(exitButtonHoverImage);
				//마우스가 올라갔을 때 손가락 모양으로 바뀜
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//한 번만 실행되도록
				Music buttonEnteredMusic = new Music("마우스호버.mp3", false);
				buttonEnteredMusic.start();
				
			}
			@Override
			//마우스가 버튼 위에서 떨어졌을 때
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonDefaultImage);
				//다시 원래 모양의 마우스로 돌아감
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			//버튼을 실제로 클릭했을 때
			public void mousePressed(MouseEvent e) {
				//한 번만 실행되도록 
				//근데 이때 음악이 나옴과 동시에 프로그램이 종료되기 때문에 소리가 들릴 수 있도록
				Music buttonEnteredMusic = new Music("마우스클릭_슈팅.mp3", false);
				buttonEnteredMusic.start();
				try {
					//소리를 듣고 종료될 수 있도록
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
			//마우스가 버튼 위에 올라왔을 때
			public void mouseEntered(MouseEvent e) {
				//아이콘 이미지를 바꿔줌
				startButton.setIcon(startButtonHoverImage);
				//마우스가 올라갔을 때 손가락 모양으로 바뀜
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//한 번만 실행되도록
				Music buttonEnteredMusic = new Music("마우스호버.mp3", false);
				buttonEnteredMusic.start();
				
			}
			@Override
			//마우스가 버튼 위에서 떨어졌을 때
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonDefaultImage);
				//다시 원래 모양의 마우스로 돌아감
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			//버튼을 실제로 클릭했을 때
			public void mousePressed(MouseEvent e) {
				//한 번만 실행되도록 
				//근데 이때 음악이 나옴과 동시에 프로그램이 종료되기 때문에 소리가 들릴 수 있도록
				Music buttonEnteredMusic = new Music("마우스클릭_슈팅.mp3", false);
				buttonEnteredMusic.start();
				
				//시작 버튼과 나가기 버튼이 사라짐
				startButton.setVisible(false);
				quitButton.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/밤하늘.jpg")).getImage();
				
			}
		});
		add(startButton);
		
		quitButton.setBounds(515, 530, 230, 96);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			//마우스가 버튼 위에 올라왔을 때
			public void mouseEntered(MouseEvent e) {
				//아이콘 이미지를 바꿔줌
				quitButton.setIcon(quitButtonHoverImage);
				//마우스가 올라갔을 때 손가락 모양으로 바뀜
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//한 번만 실행되도록
				Music buttonEnteredMusic = new Music("마우스호버.mp3", false);
				buttonEnteredMusic.start();
				
			}
			@Override
			//마우스가 버튼 위에서 떨어졌을 때
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonDefaultImage);
				//다시 원래 모양의 마우스로 돌아감
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			//버튼을 실제로 클릭했을 때
			public void mousePressed(MouseEvent e) {
				//한 번만 실행되도록 
				//근데 이때 음악이 나옴과 동시에 프로그램이 종료되기 때문에 소리가 들릴 수 있도록
				Music buttonEnteredMusic = new Music("마우스클릭_슈팅.mp3", false);
				buttonEnteredMusic.start();
				try {
					//소리를 듣고 종료될 수 있도록
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		// 메뉴바의 위치와 크기를 정해줌
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			//마우스를 실제로 눌렀을 때의 이벤트 처리
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			//드래그 이벤트가 발생했을 때
			public void mouseDragged(MouseEvent e) {
				//스크린에서의 각 x, y의 좌표를 가져음
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				//JFrame의 위치 바꿔주기
				setLocation(x-mouseX, y-mouseY);
			}
		});
		// JFrame의 메뉴바가 추가됨, 나중에 그려질 때는 아래의 paintComponents를 통해 그려짐
		add(menuBar);

		// 프로그램 시작할 때 음악 무한 재생 반복
		// true 값을 줬기 때문에 직접 종료하기 전까지는 음악 계속 반복
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	// 메소드 추가해주기
	// paint는 JFrame을 상속받은 GUI 게임에서 가장 첫번째로 화면을 그려주는 함수
	public void paint(Graphics g) {

		// 1280x720 크기의 이미지를 만들어서 넣어줌
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

		// screenImage를 이용해서 그래픽 개체를 얻어옴
		screenGraphic = screenImage.getGraphics();

		// 직접 만들 새로운 함수
		screenDraw(screenGraphic);

		// 게임 창에 이미지가 나타나게 됨
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {

		// background가 screenImage에 그려질 수 있도록
		// 단순한 배경이미지, 고정된 이미지를 띄워주는 것~
		g.drawImage(background, 0, 0, null);
		// JLabel같은 것들을 JFrame 안에 추가하면 띄워주는 역할
		paintComponents(g);
		// 프로그램이 종료되는 순간까지 계속 paint 함수를 부르면서 이미지를 띄워줌
		this.repaint();

	}
}
