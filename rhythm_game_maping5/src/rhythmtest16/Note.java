package rhythmtest16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(main1.class.getResource("/images/noteBasic.jpg")).getImage();
	private int x, y = 580 - (1000 / main1.SLEEP_TIME * main1.NOTE_SPEED) * main1.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}

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
		if(y > 620 ) {
			System.out.println("Miss");
			close();
		}
	}

	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(main1.SLEEP_TIME);
				}
				else  {
					interrupt();
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public String judge() {
		if(y >= 613) {
			System.out.println("Late");
			close();
			return "Late";
		}
		else if(y >= 610) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 590) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y >= 575) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y >= 555) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y >= 540) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 520) {
			System.out.println("Bad");
			close();
			return "Bad";
		}
        return "None";
}
	public int getY() {
		return y;
	}
}