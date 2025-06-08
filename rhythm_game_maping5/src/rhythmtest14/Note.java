package rhythmtest14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(main1.class.getResource("/images/noteBasic.jpg")).getImage();
	private int x, y = 580 - (1000 / main1.SLEEP_TIME * main1.NOTE_SPEED) * main1.REACH_TIME;
	private String noteType;

	public Note(String noteType){
        if(noteType.equals("S")){
            x = 228;
        }else if(noteType.equals("D")){
            x = 332;
        }else if(noteType.equals("F")){
            x = 436;
        }else if(noteType.equals("Space")){
            x = 540;
        }else if(noteType.equals("J")){
            x = 744;
        }else if(noteType.equals("K")){
            x = 848;
        }else if(noteType.equals("L")){
            x = 952;
        }
        this.noteType = noteType;
    }

	public void screenDraw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else {
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
