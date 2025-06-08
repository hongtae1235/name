package rhythmtest;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(main1.SCREEN_WIDTH, main1.SCREEN_HEIGHT); //크기
		setResizable(false); //내가 크기를 못 줄이게
		setLocationRelativeTo(null); //실행했을 때 중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료 후 프로그램도 종료 (필수)
		setVisible(true); //창 화면출력(필수)
	}

}
