package rhythmtest15;

import javax.swing.*;

import com.sun.tools.javac.Main;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(main1.class.getResource("/images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(main1.class.getResource("/images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(main1.class.getResource("/images/gameInfo.png")).getImage();

	private Image noteRouteSImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	private Image blueFlareImage = new ImageIcon(main1.class.getResource("/images/blue_flare.png")).getImage();

	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);

		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);

		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
			note.screenDraw(g);
			}
		}

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);

		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		g.drawImage(blueFlareImage, 320, 370, null);


	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("hi1.mp3", false).start();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("11.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("22.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("big.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("33.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("44.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("hi2.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes();

	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes() {
		Beat[] beats = null;
				if(titleName.equals("Who Put the Bomp")  && difficulty.equals("Easy")) {
					int startTime = 4460 - main1.REACH_TIME * 1000;
					int gap = 125;
					beats = new Beat[] {
							new Beat(startTime, "S"),
				            new Beat(startTime + gap * 1, "D"),
				            new Beat(startTime + gap * 2, "F"),
				            new Beat(startTime + gap * 3, "Space"),
				            new Beat(startTime + gap * 4, "J"),
				            new Beat(startTime + gap * 5, "K"),
				            new Beat(startTime + gap * 6, "L"),
				            new Beat(startTime + gap * 7, "S"),
				            new Beat(startTime + gap * 8, "D"),
				            new Beat(startTime + gap * 9, "F"),
				            new Beat(startTime + gap * 10, "Space"),
				            new Beat(startTime + gap * 11, "J"),
				            new Beat(startTime + gap * 12, "K"),
				            new Beat(startTime + gap * 13, "L"),
				            new Beat(startTime + gap * 14, "S"),
				            new Beat(startTime + gap * 15, "D"),
				            new Beat(startTime + gap * 16, "F"),
				            new Beat(startTime + gap * 17, "Space"),
				            new Beat(startTime + gap * 18, "J"),
				            new Beat(startTime + gap * 19, "K"),
				            new Beat(startTime + gap * 20, "L"),
				            new Beat(startTime + gap * 21, "S"),
				            new Beat(startTime + gap * 22, "D"),
				            new Beat(startTime + gap * 23, "F"),
				            new Beat(startTime + gap * 24, "Space"),
				            new Beat(startTime + gap * 25, "J"),
				            new Beat(startTime + gap * 26, "K"),
				            new Beat(startTime + gap * 27, "L"),
				            new Beat(startTime + gap * 28, "S"),
				            new Beat(startTime + gap * 29, "D"),
				            new Beat(startTime + gap * 30, "F"),
				            new Beat(startTime + gap * 31, "Space"),
				            new Beat(startTime + gap * 32, "J"),
				            new Beat(startTime + gap * 33, "K"),
				            new Beat(startTime + gap * 34, "L"),
				            new Beat(startTime + gap * 35, "S"),
				            new Beat(startTime + gap * 36, "D"),
				            new Beat(startTime + gap * 37, "F"),
				            new Beat(startTime + gap * 38, "Space"),
				            new Beat(startTime + gap * 39, "J"),
				            new Beat(startTime + gap * 40, "K"),
				            new Beat(startTime + gap * 41, "L"),
				            new Beat(startTime + gap * 42, "S"),
				            new Beat(startTime + gap * 43, "D"),
				            new Beat(startTime + gap * 44, "F"),
				            new Beat(startTime + gap * 45, "Space"),
				            new Beat(startTime + gap * 46, "J"),
				            new Beat(startTime + gap * 47, "K"),
				            new Beat(startTime + gap * 48, "L"),
				            new Beat(startTime + gap * 49, "S"),
				            new Beat(startTime + gap * 50, "D"),
				            new Beat(startTime + gap * 51, "F"),
				            new Beat(startTime + gap * 52, "Space"),
				            new Beat(startTime + gap * 53, "J"),
				            new Beat(startTime + gap * 54, "K"),
				            new Beat(startTime + gap * 55, "L"),
				            new Beat(startTime + gap * 56, "S"),
				            new Beat(startTime + gap * 57, "D"),
				            new Beat(startTime + gap * 58, "F"),
				            new Beat(startTime + gap * 59, "Space"),
				            new Beat(startTime + gap * 60, "J"),
				            new Beat(startTime + gap * 61, "K"),
				            new Beat(startTime + gap * 62, "L"),
				            new Beat(startTime + gap * 63, "S"),
				            new Beat(startTime + gap * 64, "D"),
				            new Beat(startTime + gap * 65, "F"),
				            new Beat(startTime + gap * 66, "Space"),
				            new Beat(startTime + gap * 67, "J"),
				            new Beat(startTime + gap * 68, "K"),
				            new Beat(startTime + gap * 69, "L"),
				            new Beat(startTime + gap * 70, "S"),
				            new Beat(startTime + gap * 71, "D"),
				            new Beat(startTime + gap * 72, "F"),
				            new Beat(startTime + gap * 73, "Space"),
				            new Beat(startTime + gap * 74, "J"),
				            new Beat(startTime + gap * 75, "K"),
				            new Beat(startTime + gap * 76, "L"),
				            new Beat(startTime + gap * 77, "S"),
				            new Beat(startTime + gap * 78, "D"),
				            new Beat(startTime + gap * 79, "F"),
				            new Beat(startTime + gap * 80, "Space"),
				            new Beat(startTime + gap * 81, "J"),
				            new Beat(startTime + gap * 82, "K"),
				            new Beat(startTime + gap * 83, "L"),
				            new Beat(startTime + gap * 84, "S"),
				            new Beat(startTime + gap * 85, "D"),
				            new Beat(startTime + gap * 86, "F"),
				            new Beat(startTime + gap * 87, "Space"),
				            new Beat(startTime + gap * 88, "J"),
				            new Beat(startTime + gap * 89, "K"),
				            new Beat(startTime + gap * 90, "L"),
				            new Beat(startTime + gap * 91, "S"),
				            new Beat(startTime + gap * 92, "D"),
				            new Beat(startTime + gap * 93, "F"),
				            new Beat(startTime + gap * 94, "Space"),
				            new Beat(startTime + gap * 95, "J"),
				            new Beat(startTime + gap * 96, "K"),
				            new Beat(startTime + gap * 97, "L")
					};
		}
				else if(titleName.equals("Who Put the Bomp") && difficulty.equals("Hard")){
					int startTime = 1000;
					beats = new Beat[] {
							new Beat(startTime, "Space")
					};
				}
				else if(titleName.equals("Sting(스팅) - Englishman In New York") && difficulty.equals("Easy")){
					int startTime = 1000;
					beats = new Beat[] {
							new Beat(startTime, "Space")
					};
				}
				else if(titleName.equals("Sting(스팅) - Englishman In New York") && difficulty.equals("Hard")){
					int startTime = 1000;
					beats = new Beat[] {
							new Beat(startTime, "Space")
					};
				}
				else if(titleName.equals("Rascal Flatts - Life Is a Highway") && difficulty.equals("Easy")){
			     	int startTime = 1000;
					beats = new Beat[] {
							new Beat(startTime, "Space")
					};
				}
				else if(titleName.equals("Rascal Flatts - Life Is a Highway") && difficulty.equals("Hard")){
			     	int startTime = 1000;
					beats = new Beat[] {
							new Beat(startTime, "Space")
					};
				}
				
				int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
		    if (beats[i].getTime() <= gameMusic.getTime()) {
		        Note note = new Note(beats[i].getNoteName());
		        note.start();
		        noteList.add(note);
		        i++;
		        dropped = true;
		    }
		    if(!dropped) {
		    	try {
		    		Thread.sleep(5);
		    	} catch (InterruptedException e) {
		    	}
		    }
		}

		//noteList.add(new Note(228, 120, "short"));
		//noteList.add(new Note(332, 580, "short"));
		//noteList.add(new Note(436, 500, "short"));
		//noteList.add(new Note(540, 340, "long"));
		//noteList.add(new Note(744, 325, "short"));
		//noteList.add(new Note(848, 305, "short"));
		//noteList.add(new Note(952, 305, "short"));
	}

	public  void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}
