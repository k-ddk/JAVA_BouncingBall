package bouncing_ball_ver_1;

import javax.swing.JFrame; //ctrl + shift+ o �ϸ� �ʿ��� ��Ű��? �� �ڵ����� ����

public class BouncingBall extends JFrame {  //Ŭ���� �̸��� �빮�ڷ� �����ϴ� ���� �Ϲ����̴�.! gui�� �����ϱ� ���� �⺻������ ��ӹ޾ƾ� �ϴ� JFrame

	public BouncingBall() {  //������, Ŭ������ ���� �̸�����...
		setTitle("Bouncing Ball**"); //���� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //���� â ũ�� ����
		setResizable(false); //���� â�� �� �� ���������, ����ڰ� ������ �� ����
		setLocationRelativeTo(null); //���� â�� ��ǻ�� ���߾ӿ� �߰� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���� â �����, ��ü ���α׷� ����
		setVisible(true); //���� â�� ���������� ��µ�
		                 //�� �⺻���� false �� ������ true�� �־���� ��
		
	
	}
}
