  
package bouncing_ball_ver_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player; //컨트롤 + 쉬프트 + o 로 라이브러리 import 해주기

public class Music extends Thread { //이때 Thread란 프로그램 안의 또 다른 작은 프로그램이라 생각하면 된다

	private Player player;  //JAVAzoom 사이트에서 다운받고 buildpath 해서 넣어줘야지 쓸 수 있음!
	
	//현재 곡이 무한반복일지 아님, 한 번만 재생하고 끝날 지에 대한 설정
	private boolean isloop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	//생성자 만들기
	public Music(String name, boolean isloop) {  //곡의 제목과 해당 곡이 무한 반복인지~
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
	
	public void close() {  //음악이 언제 실행되고 있건 항상 종료할 수 있게 해주는 함수<- 사실 이건 리듬게임 만드는 데에 필요한 거 아마 나는 안 필요한 거 같..음./???
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
			System.out.println(e.getMessage());  //오류 발생 시 해당 오류메시지 출력
		}
	}
}