package rhythmtest14;

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
			note.screenDraw(g);
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

	}

	public void pressS() {
		noteRouteSImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("hi1.mp3", false).start();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressD() {
		noteRouteDImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("11.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressF() {
		noteRouteFImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("22.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("big.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		noteRouteJImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("33.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressK() {
		noteRouteKImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("44.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressL() {
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
				if(titleName.equals("Who Put the Bomp")) {
					int startTime = 4460 - main1.REACH_TIME * 1000;
					int gap = 125;
					beats = new Beat[] {
							new Beat(startTime, "S"),
							new Beat(startTime + gap * 2, "D"),
							new Beat(startTime + gap * 4, "S"),
							new Beat(startTime + gap * 6, "D"),
							new Beat(startTime + gap * 8, "S"),
							new Beat(startTime + gap * 10, "D"),
							new Beat(startTime + gap * 12, "S"),
							new Beat(startTime + gap * 14, "D"),
							new Beat(startTime + gap * 18, "J"),
							new Beat(startTime + gap * 20, "K"),
							new Beat(startTime + gap * 22, "J"),
							new Beat(startTime + gap * 24, "K"),
							new Beat(startTime + gap * 26, "J"),
							new Beat(startTime + gap * 28, "K"),
							new Beat(startTime + gap * 30, "J"),
							new Beat(startTime + gap * 32, "K"),
							new Beat(startTime + gap * 36, "S"),
							new Beat(startTime + gap * 38, "D"),
							new Beat(startTime + gap * 40, "S"),
							new Beat(startTime + gap * 42, "D"),
							new Beat(startTime + gap * 44, "S"),
							new Beat(startTime + gap * 46, "D"),
							new Beat(startTime + gap * 48, "J"),
							new Beat(startTime + gap * 49, "K"),
							new Beat(startTime + gap * 50, "L"),
							new Beat(startTime + gap * 52, "F"),
							new Beat(startTime + gap * 52, "Space"),
							new Beat(startTime + gap * 52, "J")
					};
		}
				else if(titleName.equals("Sting(스팅) - Englishman In New York")){
					int startTime = 1000;
					beats = new Beat[] {
							new Beat(startTime, "Space")
					};
				}
				else if(titleName.equals("Rascal Flatts - Life Is a Highway")){
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
		    	} catch (Exception e) {
		    		e.printStackTrace();
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

}
