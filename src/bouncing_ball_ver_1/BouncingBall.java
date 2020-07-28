package bouncing_ball_ver_1;

import javax.swing.JFrame; //ctrl + shift+ o 하면 필요한 패키지? 가 자동으로 생김

public class BouncingBall extends JFrame {

	public BouncingBall() {
		setTitle("Bouncing Ball**"); //게임 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //게임 창 크기 설정
		setResizable(false); //게임 창이 한 번 만들어지면, 사용자가 변경할 수 없음
		setLocationRelativeTo(null); //게임 창이 컴퓨터 정중앙에 뜨게 됨
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임 창 종료시, 전체 프로그램 종료
		setVisible(true); //게임 창이 정상적으로 출력됨
		                 //의 기본값은 false 기 때문에 true로 넣어줘야 함
		
	
	}
}
