package bouncing_ball_ver_5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player; //컨트롤 + 쉬프트 + o 로 라이브러리 import 해주기

public class Music extends Thread { //이때 Thread란 프로그램 안의 또 다른 작은 프로그램이라 생각하면 된다

	private Player player;
	
	//현재 곡이 무한반복일지 아님, 한 번만 재생하고 끝날 지에 대한 설정
	private boolean isloop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	//생성자 만들기
	public Music(String name, boolean isloop) {
		try {
			//isloop 변수 초기화
			this.isloop = isloop;
			
			//파일가져오기
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			//파일을 버퍼에 담아서 읽어오기
			bis = new BufferedInputStream(fis);
			//player가 해당 파일을 담을 수 있게
			player = new Player(bis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//메소드 추가해주기
	//현재 실행되고 있는 음악이 어떤 위치에서 실행되고 있는지 알려줌
	//getTime(), close()는 리듬 게임에 필요한 함수들..
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		isloop = false;
		player.close();
		this.interrupt();
	}
	
	//스레드를 상속받으면 무조건 실행해야하는 함수
	@Override
	public void run() {
		try {
			do {
				//곡 실행시키기 이때 만약~, while 로 넘어가서
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis); //isloop 값이 true 라면 해당 곡은 무한 반복됨
			} while(isloop) ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
