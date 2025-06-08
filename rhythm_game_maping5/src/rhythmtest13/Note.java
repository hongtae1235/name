package rhythmtest13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(main1.class.getResource("/images/noteBasic.jpg")).getImage();
	private int x, y = 580 - 1000 / main1.SLEEP_TIME * main1.NOTE_SPEED;
	private String noteType;

	public Note(int x, String noteType) {
		this.x = x;
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		if (noteType.equals("short")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else if (noteType.equals("long")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);

		}
	}

	public void drop() {
		y += main1.NOTE_SPEED;
	}

	@Override
	public void run() {
		try {
			while(true) {
				drop();
				Thread.sleep(main1.SLEEP_TIME);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
