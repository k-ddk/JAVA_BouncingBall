package bouncing_ball_ver_6_리듬게임따라하기;

public class Main {

	//public static 이란 모든 프로젝트 내에서 공유하는 변수임을 의미
	//final은 한 번 선언된 후, 바뀌지 않음을 의미
	public static final int SCREEN_WIDTH = 1280; //전체 너비
	public static final int SCREEN_HEIGHT = 720; //전체 높이
	
	public static void main(String[] args) {
		
		new BouncingBall(); //BouncingBall이라는 클래스의 객체를 만듦
	
	}

}
