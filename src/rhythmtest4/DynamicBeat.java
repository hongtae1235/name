 package rhythmtest4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/exit_entered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(main1.class.getResource("/images/exit.png"));
	
	private Image Background = new ImageIcon(main1.class.getResource("/images/Background.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(main1.class.getResource("/images/menuBar.png")));

	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
    private int mouseX, mouseY;
	
	
	//exit_entered
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(main1.SCREEN_WIDTH, main1.SCREEN_HEIGHT); //크기
		setResizable(false); //내가 크기를 못 줄이게
		setLocationRelativeTo(null); //실행했을 때 중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료 후 프로그램도 종료 (필수)
		setVisible(true); //창 화면출력(필수)
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		exitButton.setBounds(1245,0,30,30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		
		add(exitButton);
		
		menuBar.setBounds(0,0,1280,30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter()  {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
		    }
	    });
		add(menuBar);
		
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
		paintComponents(g);
		this.repaint();
<<<<<<< HEAD
=======
		//테스트
>>>>>>> cd3dde4988800afac04bf6237ba03231700ddef0
	}

}
