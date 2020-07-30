package bouncing_ball_ver_5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player; //��Ʈ�� + ����Ʈ + o �� ���̺귯�� import ���ֱ�

public class Music extends Thread { //�̶� Thread�� ���α׷� ���� �� �ٸ� ���� ���α׷��̶� �����ϸ� �ȴ�

	private Player player;
	
	//���� ���� ���ѹݺ����� �ƴ�, �� ���� ����ϰ� ���� ���� ���� ����
	private boolean isloop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	//������ �����
	public Music(String name, boolean isloop) {
		try {
			//isloop ���� �ʱ�ȭ
			this.isloop = isloop;
			
			//���ϰ�������
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			//������ ���ۿ� ��Ƽ� �о����
			bis = new BufferedInputStream(fis);
			//player�� �ش� ������ ���� �� �ְ�
			player = new Player(bis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//�޼ҵ� �߰����ֱ�
	//���� ����ǰ� �ִ� ������ � ��ġ���� ����ǰ� �ִ��� �˷���
	//getTime(), close()�� ���� ���ӿ� �ʿ��� �Լ���..
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
	
	//�����带 ��ӹ����� ������ �����ؾ��ϴ� �Լ�
	@Override
	public void run() {
		try {
			do {
				//�� �����Ű�� �̶� ����~, while �� �Ѿ��
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis); //isloop ���� true ��� �ش� ���� ���� �ݺ���
			} while(isloop) ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
