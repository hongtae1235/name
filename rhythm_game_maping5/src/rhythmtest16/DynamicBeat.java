package rhythmtest16;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/exit_entered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(main1.class.getResource("/images/exit.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			main1.class.getResource("/images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(main1.class.getResource("/images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(main1.class.getResource("/images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/leftEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(main1.class.getResource("/images/leftBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/rightEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(main1.class.getResource("/images/rightBasic.png"));

	private ImageIcon easyButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(main1.class.getResource("/images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(main1.class.getResource("/images/hardButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(main1.class.getResource("/images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(main1.class.getResource("/images/backButtonBasic.png"));

	private Image Background = new ImageIcon(main1.class.getResource("/images/Background.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(main1.class.getResource("/images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected = 0;

	public static Game game;

	// exit_entered

	public DynamicBeat() {
		
		trackList
		.add(new Track("funfun.png", "fun2.jpg", "fun1.jpg", "music1ex.mp3", "music1.mp3", "Who Put the Bomp"));
        trackList.add(new Track("newnew.png", "newyork2.jpg", "newyork1.jpg", "music3ex.mp3", "music3.mp3",
		"Sting(스팅) - Englishman In New York "));
        trackList.add(new Track("carcar.png", "car2.jpg", "car1.jpg", "music2ex.mp3", "music2.mp3",
		"Rascal Flatts - Life Is a Highway"));
		
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(main1.SCREEN_WIDTH, main1.SCREEN_HEIGHT); // 크기
		setResizable(false); // 내가 크기를 못 줄이게
		setLocationRelativeTo(null); // 실행했을 때 중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 후 프로그램도 종료 (필수)
		setVisible(true); // 창 화면출력(필수)
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		addKeyListener(new KeyListener());

		introMusic.start();

		exitButton.setBounds(1245, 0, 30, 30);
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
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

		});

		add(exitButton);

		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				enterMain();
			}
		});
		add(startButton);

		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);

		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				selectedLeft();
			}
		});
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				selectedright();
			}
		});
		add(rightButton);

		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				gamestart(nowSelected, "Easy");
			}
		});
		add(easyButton);

		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 70);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				gamestart(nowSelected, "Hard");
			}
		});
		add(hardButton);

		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("pick-92276.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("click.mp3", false);
				buttonEnteredMusic.start();
				backMain();
			}
		});
		add(backButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

	}

	public void paint(Graphics g) {
		screenImage = createImage(main1.SCREEN_WIDTH, main1.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(Background, 0, 0, null);
		if (isMainScreen) {
			g.drawImage(selectedImage, 360, 100, null);
			g.drawImage(titleImage, 200, 70, null);
		}
		if (isGameScreen) 
		{
			game.screenDraw(g);
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}

	public void selectedTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(main1.class.getResource("/images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(main1.class.getResource("/images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectedLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectedTrack(nowSelected);
	}

	public void selectedright() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectedTrack(nowSelected);
	}

	public void gamestart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		Background = new ImageIcon(main1.class.getResource("/images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).gettitleName(), difficulty,
	 			trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}

	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		Background = new ImageIcon(main1.class.getResource("/images/main_Background.jpg")).getImage();
		backButton.setVisible(false);
		selectedTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}

	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);

		Background = new ImageIcon(main1.class.getResource("/images/main_Background.jpg")).getImage();
		isMainScreen = true;

		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectedTrack(0);
	}
}
