package bouncing_ball_ver_4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; //ctrl + shift+ o 하면 필요한 패키지? 가 자동으로 import 됨


public class BouncingBall extends JFrame {

	//자바에서 제공하는 방식으로 이미지를 띄우면 버퍼링 현상이 심함-> 더블 버퍼링 기법 이용
	//더블버퍼링 기법: 현재 프로그램이 전체 화면 크기에 맞는 이미지를 매 순간 생성해서 원하는 컴포런트?만 화면에 출력하는 방식
	//버퍼에 이미지를 담아서 매 순간마다 이미지를 갱신해 줌
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_밤하늘내버전.png")).getImage();
	//menuBar 객체 만들기
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/on_button.png")));
	
	private int mouseX, mouseY;
	
	public BouncingBall() {
		//원래 존재하던 메뉴바가 보이지 않게 해 줌
		setUndecorated(true);
		
		setTitle("Bouncing Ball**"); //게임 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //게임 창 크기 설정
		setResizable(false); //게임 창이 한 번 만들어지면, 사용자가 변경할 수 없음
		setLocationRelativeTo(null); //게임 창이 컴퓨터 정중앙에 뜨게 됨
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임 창 종료시, 전체 프로그램 종료
		setVisible(true); //게임 창이 정상적으로 출력됨
		                 //의 기본값은 false 기 때문에 true로 넣어줘야 함
		//추가하는 메뉴바의 뒷부분이 하얀색으로??
		setBackground(new Color(0, 0, 0, 0));
		//버튼이나 JLabel을 넣었을 때 지정한 위치 그대로 나타나게 됨
		setLayout(null);
		
		//메뉴바의 위치와 크기를 정해줌
		menuBar.setBounds(0, 0, 1280, 30);
		//JFrame의 메뉴바가 추가됨, 나중에 그려질 때는 아래의 paintComponents를 통해 그려짐
		add(menuBar);
		
		exitButton.setBounds(50, 50, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		add(exitButton);
		
		//프로그램 시작할 때 음악 무한 재생 반복
		//true 값을 줬기 때문에 직접 종료하기 전까지는 음악 계속 반복
		Music introMusic = new Music("introMusic.mp3", true);
	    introMusic.start();
	}
	
	//메소드 추가해주기
	//paint는 JFrame을 상속받은 GUI 게임에서 가장 첫번째로 화면을 그려주는 함수
	public void paint(Graphics g) {
		
		//1280x720 크기의 이미지를 만들어서 넣어줌
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		
		//screenImage를 이용해서 그래픽 개체를 얻어옴
		screenGraphic = screenImage.getGraphics();
		
		//직접 만들 새로운 함수
		screenDraw(screenGraphic); 
		
		//게임 창에 이미지가 나타나게 됨
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		
		//introBackground가 screenImage에 그려질 수 있도록
		//단순한 배경이미지, 고정된 이미지를 띄워주는 것~
		g.drawImage(introBackground, 0, 0, null);
	    //JFrame으로 추가한 것들도 그려줌
		//JLabel같은 것들을 띄워줌~
		paintComponents(g);
		//프로그램이 종료되는 순간까지 계속 paint 함수를 부르면서 이미지를 띄워줌
		this.repaint();
	    
	}
}
