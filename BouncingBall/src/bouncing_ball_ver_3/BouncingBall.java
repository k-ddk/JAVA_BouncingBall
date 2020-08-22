package bouncing_ball_ver_3;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame; //ctrl + shift+ o 하면 필요한 패키지? 가 자동으로 import 됨


public class BouncingBall extends JFrame {

	//자바에서 제공하는 방식으로 이미지를 띄우면 버퍼링 현상이 심함-> 더블 버퍼링 기법 이용
	//더블버퍼링 기법: 현재 프로그램이 전체 화면 크기에 맞는 이미지를 매 순간 생성해서 원하는 컴포런트?만 화면에 출력하는 방식
	//버퍼에 이미지를 담아서 매 순간마다 이미지를 갱신해 줌
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground; //IntroBackground 라는 내가 가져 온 이미지를 담을 수 있는 객체 
	
	public BouncingBall() {
		setTitle("Bouncing Ball**"); //게임 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //게임 창 크기 설정
		setResizable(false); //게임 창이 한 번 만들어지면, 사용자가 변경할 수 없음
		setLocationRelativeTo(null); //게임 창이 컴퓨터 정중앙에 뜨게 됨
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임 창 종료시, 전체 프로그램 종료
		setVisible(true); //게임 창이 정상적으로 출력됨
		                 //의 기본값은 false 기 때문에 true로 넣어줘야 함
		
		//Main클래스의 위치를 기반으로 IntroBackground라는 이미지를 얻어온 뒤
		//그것의 이미지 인스턴스를 introBackground라는 변수에 초기화 해준다는 의미
		//******* 이미지 파일 넣을 때 내가 만든 이미지 파일 넣으려면 카톡으로 말고 메일로 보내서!할 것 , 
		//******* 카톡으로 다운받으면 크기가 자동으로 작아짐!
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground_밤하늘내버전.png")).getImage();
		
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
		g.drawImage(introBackground, 0, 0, null);
	    
		//프로그램이 종료되는 순간까지 계속 paint 함수를 부르면서 이미지를 띄워줌
		this.repaint();
	    
	}
}
