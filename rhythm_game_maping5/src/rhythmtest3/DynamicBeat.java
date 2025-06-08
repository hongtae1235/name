package rhythmtest3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image Background;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(main1.SCREEN_WIDTH, main1.SCREEN_HEIGHT); //크기
		setResizable(false); //내가 크기를 못 줄이게
		setLocationRelativeTo(null); //실행했을 때 중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료 후 프로그램도 종료 (필수)
		setVisible(true); //창 화면출력(필수)
		
		Background = new ImageIcon(main1.class.getResource("/images/Background.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(main1.SCREEN_WIDTH, main1.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		this.repaint();
	}

}
