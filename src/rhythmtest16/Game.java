package rhythmtest16;

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
	private Image blueFlareImage; 
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	private Image keyPadDImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	private Image keyPadFImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	private Image keyPadJImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	private Image keyPadKImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	private Image keyPadLImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();

	
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
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(main1.class.getResource("/images/judgeMiss.png")).getImage();
			}
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
		g.drawImage(blueFlareImage, 250, 150, null);
		g.drawImage(judgeImage, 570, 290, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		

	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
		new Music("hi1.mp3", false).start();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("11.mp3", false).start();
		keyPadDImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("22.mp3", false).start();
		keyPadFImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
		new Music("big.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadSpace2Image = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
		
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("33.mp3", false).start();
		keyPadJImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("44.mp3", false).start();
		keyPadKImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(main1.class.getResource("/images/noteRoutePressed.png")).getImage();
		new Music("hi2.mp3", false).start();
		keyPadLImage = new ImageIcon(main1.class.getResource("/images/일러스트2.png")).getImage();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(main1.class.getResource("/images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(main1.class.getResource("/images/일러스트4.png")).getImage();
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
							new Beat(startTime + gap * 0, "S"),
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
							new Beat(startTime + gap * 97, "L"),
							new Beat(startTime + gap * 98, "S"),
							new Beat(startTime + gap * 99, "D"),
							new Beat(startTime + gap * 100, "F"),
							new Beat(startTime + gap * 101, "Space"),
							new Beat(startTime + gap * 102, "J"),
							new Beat(startTime + gap * 103, "K"),
							new Beat(startTime + gap * 104, "L"),
							new Beat(startTime + gap * 105, "S"),
							new Beat(startTime + gap * 106, "D"),
							new Beat(startTime + gap * 107, "F"),
							new Beat(startTime + gap * 108, "Space"),
							new Beat(startTime + gap * 109, "J"),
							new Beat(startTime + gap * 110, "K"),
							new Beat(startTime + gap * 111, "L"),
							new Beat(startTime + gap * 112, "S"),
							new Beat(startTime + gap * 113, "D"),
							new Beat(startTime + gap * 114, "F"),
							new Beat(startTime + gap * 115, "Space"),
							new Beat(startTime + gap * 116, "J"),
							new Beat(startTime + gap * 117, "K"),
							new Beat(startTime + gap * 118, "L"),
							new Beat(startTime + gap * 119, "S"),
							new Beat(startTime + gap * 120, "D"),
							new Beat(startTime + gap * 121, "F"),
							new Beat(startTime + gap * 122, "Space"),
							new Beat(startTime + gap * 123, "J"),
							new Beat(startTime + gap * 124, "K"),
							new Beat(startTime + gap * 125, "L"),
							new Beat(startTime + gap * 126, "S"),
							new Beat(startTime + gap * 127, "D"),
							new Beat(startTime + gap * 128, "F"),
							new Beat(startTime + gap * 129, "Space"),
							new Beat(startTime + gap * 130, "J"),
							new Beat(startTime + gap * 131, "K"),
							new Beat(startTime + gap * 132, "L"),
							new Beat(startTime + gap * 133, "S"),
							new Beat(startTime + gap * 134, "D"),
							new Beat(startTime + gap * 135, "F"),
							new Beat(startTime + gap * 136, "Space"),
							new Beat(startTime + gap * 137, "J"),
							new Beat(startTime + gap * 138, "K"),
							new Beat(startTime + gap * 139, "L"),
							new Beat(startTime + gap * 140, "S"),
							new Beat(startTime + gap * 141, "D"),
							new Beat(startTime + gap * 142, "F"),
							new Beat(startTime + gap * 143, "Space"),
							new Beat(startTime + gap * 144, "J"),
							new Beat(startTime + gap * 145, "K"),
							new Beat(startTime + gap * 146, "L"),
							new Beat(startTime + gap * 147, "S"),
							new Beat(startTime + gap * 148, "D"),
							new Beat(startTime + gap * 149, "F"),
							new Beat(startTime + gap * 150, "Space"),
							new Beat(startTime + gap * 151, "J"),
							new Beat(startTime + gap * 152, "K"),
							new Beat(startTime + gap * 153, "L"),
							new Beat(startTime + gap * 154, "S"),
							new Beat(startTime + gap * 155, "D"),
							new Beat(startTime + gap * 156, "F"),
							new Beat(startTime + gap * 157, "Space"),
							new Beat(startTime + gap * 158, "J"),
							new Beat(startTime + gap * 159, "K"),
							new Beat(startTime + gap * 160, "L"),
							new Beat(startTime + gap * 161, "S"),
							new Beat(startTime + gap * 162, "D"),
							new Beat(startTime + gap * 163, "F"),
							new Beat(startTime + gap * 164, "Space"),
							new Beat(startTime + gap * 165, "J"),
							new Beat(startTime + gap * 166, "K"),
							new Beat(startTime + gap * 167, "L"),
							new Beat(startTime + gap * 168, "S"),
							new Beat(startTime + gap * 169, "D"),
							new Beat(startTime + gap * 170, "F"),
							new Beat(startTime + gap * 171, "Space"),
							new Beat(startTime + gap * 172, "J"),
							new Beat(startTime + gap * 173, "K"),
							new Beat(startTime + gap * 174, "L"),
							new Beat(startTime + gap * 175, "S"),
							new Beat(startTime + gap * 176, "D"),
							new Beat(startTime + gap * 177, "F"),
							new Beat(startTime + gap * 178, "Space"),
							new Beat(startTime + gap * 179, "J"),
							new Beat(startTime + gap * 180, "K"),
							new Beat(startTime + gap * 181, "L"),
							new Beat(startTime + gap * 182, "S"),
							new Beat(startTime + gap * 183, "D"),
							new Beat(startTime + gap * 184, "F"),
							new Beat(startTime + gap * 185, "Space"),
							new Beat(startTime + gap * 186, "J"),
							new Beat(startTime + gap * 187, "K"),
							new Beat(startTime + gap * 188, "L"),
							new Beat(startTime + gap * 189, "S"),
							new Beat(startTime + gap * 190, "D"),
							new Beat(startTime + gap * 191, "F"),
							new Beat(startTime + gap * 192, "Space"),
							new Beat(startTime + gap * 193, "J"),
							new Beat(startTime + gap * 194, "K"),
							new Beat(startTime + gap * 195, "L"),
							new Beat(startTime + gap * 196, "S"),
							new Beat(startTime + gap * 197, "D"),
							new Beat(startTime + gap * 198, "F"),
							new Beat(startTime + gap * 199, "Space"),
							new Beat(startTime + gap * 200, "J"),
							new Beat(startTime + gap * 201, "K"),
							new Beat(startTime + gap * 202, "L"),
							new Beat(startTime + gap * 203, "S"),
							new Beat(startTime + gap * 204, "D"),
							new Beat(startTime + gap * 205, "F"),
							new Beat(startTime + gap * 206, "Space"),
							new Beat(startTime + gap * 207, "J"),
							new Beat(startTime + gap * 208, "K"),
							new Beat(startTime + gap * 209, "L"),
							new Beat(startTime + gap * 210, "S"),
							new Beat(startTime + gap * 211, "D"),
							new Beat(startTime + gap * 212, "F"),
							new Beat(startTime + gap * 213, "Space"),
							new Beat(startTime + gap * 214, "J"),
							new Beat(startTime + gap * 215, "K"),
							new Beat(startTime + gap * 216, "L"),
							new Beat(startTime + gap * 217, "S"),
							new Beat(startTime + gap * 218, "D"),
							new Beat(startTime + gap * 219, "F"),
							new Beat(startTime + gap * 220, "Space"),
							new Beat(startTime + gap * 221, "J"),
							new Beat(startTime + gap * 222, "K"),
							new Beat(startTime + gap * 223, "L"),
							new Beat(startTime + gap * 224, "S"),
							new Beat(startTime + gap * 225, "D"),
							new Beat(startTime + gap * 226, "F"),
							new Beat(startTime + gap * 227, "Space"),
							new Beat(startTime + gap * 228, "J"),
							new Beat(startTime + gap * 229, "K"),
							new Beat(startTime + gap * 230, "L"),
							new Beat(startTime + gap * 231, "S"),
							new Beat(startTime + gap * 232, "D"),
							new Beat(startTime + gap * 233, "F"),
							new Beat(startTime + gap * 234, "Space"),
							new Beat(startTime + gap * 235, "J"),
							new Beat(startTime + gap * 236, "K"),
							new Beat(startTime + gap * 237, "L"),
							new Beat(startTime + gap * 238, "S"),
							new Beat(startTime + gap * 239, "D"),
							new Beat(startTime + gap * 240, "F"),
							new Beat(startTime + gap * 241, "Space"),
							new Beat(startTime + gap * 242, "J"),
							new Beat(startTime + gap * 243, "K"),
							new Beat(startTime + gap * 244, "L"),
							new Beat(startTime + gap * 245, "S"),
							new Beat(startTime + gap * 246, "D"),
							new Beat(startTime + gap * 247, "F"),
							new Beat(startTime + gap * 248, "Space"),
							new Beat(startTime + gap * 249, "J"),
							new Beat(startTime + gap * 250, "K"),
							new Beat(startTime + gap * 251, "L"),
							new Beat(startTime + gap * 252, "S"),
							new Beat(startTime + gap * 253, "D"),
							new Beat(startTime + gap * 254, "F"),
							new Beat(startTime + gap * 255, "Space"),
							new Beat(startTime + gap * 256, "J"),
							new Beat(startTime + gap * 257, "K"),
							new Beat(startTime + gap * 258, "L"),
							new Beat(startTime + gap * 259, "S"),
							new Beat(startTime + gap * 260, "D"),
							new Beat(startTime + gap * 261, "F"),
							new Beat(startTime + gap * 262, "Space"),
							new Beat(startTime + gap * 263, "J"),
							new Beat(startTime + gap * 264, "K"),
							new Beat(startTime + gap * 265, "L"),
							new Beat(startTime + gap * 266, "S"),
							new Beat(startTime + gap * 267, "D"),
							new Beat(startTime + gap * 268, "F"),
							new Beat(startTime + gap * 269, "Space"),
							new Beat(startTime + gap * 270, "J"),
							new Beat(startTime + gap * 271, "K"),
							new Beat(startTime + gap * 272, "L"),
							new Beat(startTime + gap * 273, "S"),
							new Beat(startTime + gap * 274, "D"),
							new Beat(startTime + gap * 275, "F"),
							new Beat(startTime + gap * 276, "Space"),
							new Beat(startTime + gap * 277, "J"),
							new Beat(startTime + gap * 278, "K"),
							new Beat(startTime + gap * 279, "L"),
							new Beat(startTime + gap * 280, "S"),
							new Beat(startTime + gap * 281, "D"),
							new Beat(startTime + gap * 282, "F"),
							new Beat(startTime + gap * 283, "Space"),
							new Beat(startTime + gap * 284, "J"),
							new Beat(startTime + gap * 285, "K"),
							new Beat(startTime + gap * 286, "L"),
							new Beat(startTime + gap * 287, "S"),
							new Beat(startTime + gap * 288, "D"),
							new Beat(startTime + gap * 289, "F"),
							new Beat(startTime + gap * 290, "Space"),
							new Beat(startTime + gap * 291, "J"),
							new Beat(startTime + gap * 292, "K"),
							new Beat(startTime + gap * 293, "L"),
							new Beat(startTime + gap * 294, "S"),
							new Beat(startTime + gap * 295, "D"),
							new Beat(startTime + gap * 296, "F"),
							new Beat(startTime + gap * 297, "Space"),
							new Beat(startTime + gap * 298, "J"),
							new Beat(startTime + gap * 299, "K"),
							new Beat(startTime + gap * 300, "L"),
							new Beat(startTime + gap * 301, "S"),
							new Beat(startTime + gap * 302, "D"),
							new Beat(startTime + gap * 303, "F"),
							new Beat(startTime + gap * 304, "Space"),
							new Beat(startTime + gap * 305, "J"),
							new Beat(startTime + gap * 306, "K"),
							new Beat(startTime + gap * 307, "L"),
							new Beat(startTime + gap * 308, "S"),
							new Beat(startTime + gap * 309, "D"),
							new Beat(startTime + gap * 310, "F"),
							new Beat(startTime + gap * 311, "Space"),
							new Beat(startTime + gap * 312, "J"),
							new Beat(startTime + gap * 313, "K"),
							new Beat(startTime + gap * 314, "L"),
							new Beat(startTime + gap * 315, "S"),
							new Beat(startTime + gap * 316, "D"),
							new Beat(startTime + gap * 317, "F"),
							new Beat(startTime + gap * 318, "Space"),
							new Beat(startTime + gap * 319, "J"),
							new Beat(startTime + gap * 320, "K"),
							new Beat(startTime + gap * 321, "L"),
							new Beat(startTime + gap * 322, "S"),
							new Beat(startTime + gap * 323, "D"),
							new Beat(startTime + gap * 324, "F"),
							new Beat(startTime + gap * 325, "Space"),
							new Beat(startTime + gap * 326, "J"),
							new Beat(startTime + gap * 327, "K"),
							new Beat(startTime + gap * 328, "L"),
							new Beat(startTime + gap * 329, "S"),
							new Beat(startTime + gap * 330, "D"),
							new Beat(startTime + gap * 331, "F"),
							new Beat(startTime + gap * 332, "Space"),
							new Beat(startTime + gap * 333, "J"),
							new Beat(startTime + gap * 334, "K"),
							new Beat(startTime + gap * 335, "L"),
							new Beat(startTime + gap * 336, "S"),
							new Beat(startTime + gap * 337, "D"),
							new Beat(startTime + gap * 338, "F"),
							new Beat(startTime + gap * 339, "Space"),
							new Beat(startTime + gap * 340, "J"),
							new Beat(startTime + gap * 341, "K"),
							new Beat(startTime + gap * 342, "L"),
							new Beat(startTime + gap * 343, "S"),
							new Beat(startTime + gap * 344, "D"),
							new Beat(startTime + gap * 345, "F"),
							new Beat(startTime + gap * 346, "Space"),
							new Beat(startTime + gap * 347, "J"),
							new Beat(startTime + gap * 348, "K"),
							new Beat(startTime + gap * 349, "L"),
							new Beat(startTime + gap * 350, "S"),
							new Beat(startTime + gap * 351, "D"),
							new Beat(startTime + gap * 352, "F"),
							new Beat(startTime + gap * 353, "Space"),
							new Beat(startTime + gap * 354, "J"),
							new Beat(startTime + gap * 355, "K"),
							new Beat(startTime + gap * 356, "L"),
							new Beat(startTime + gap * 357, "S"),
							new Beat(startTime + gap * 358, "D"),
							new Beat(startTime + gap * 359, "F"),
							new Beat(startTime + gap * 360, "Space"),
							new Beat(startTime + gap * 361, "J"),
							new Beat(startTime + gap * 362, "K"),
							new Beat(startTime + gap * 363, "L"),
							new Beat(startTime + gap * 364, "S"),
							new Beat(startTime + gap * 365, "D"),
							new Beat(startTime + gap * 366, "F"),
							new Beat(startTime + gap * 367, "Space"),
							new Beat(startTime + gap * 368, "J"),
							new Beat(startTime + gap * 369, "K"),
							new Beat(startTime + gap * 370, "L"),
							new Beat(startTime + gap * 371, "S"),
							new Beat(startTime + gap * 372, "D"),
							new Beat(startTime + gap * 373, "F"),
							new Beat(startTime + gap * 374, "Space"),
							new Beat(startTime + gap * 375, "J"),
							new Beat(startTime + gap * 376, "K"),
							new Beat(startTime + gap * 377, "L"),
							new Beat(startTime + gap * 378, "S"),
							new Beat(startTime + gap * 379, "D"),
							new Beat(startTime + gap * 380, "F"),
							new Beat(startTime + gap * 381, "Space"),
							new Beat(startTime + gap * 382, "J"),
							new Beat(startTime + gap * 383, "K"),
							new Beat(startTime + gap * 384, "L"),
							new Beat(startTime + gap * 385, "S"),
							new Beat(startTime + gap * 386, "D"),
							new Beat(startTime + gap * 387, "F"),
							new Beat(startTime + gap * 388, "Space"),
							new Beat(startTime + gap * 389, "J"),
							new Beat(startTime + gap * 390, "K"),
							new Beat(startTime + gap * 391, "L"),
							new Beat(startTime + gap * 392, "S"),
							new Beat(startTime + gap * 393, "D"),
							new Beat(startTime + gap * 394, "F"),
							new Beat(startTime + gap * 395, "Space"),
							new Beat(startTime + gap * 396, "J"),
							new Beat(startTime + gap * 397, "K"),
							new Beat(startTime + gap * 398, "L"),
							new Beat(startTime + gap * 399, "S"),
							new Beat(startTime + gap * 400, "D"),
							new Beat(startTime + gap * 401, "F"),
							new Beat(startTime + gap * 402, "Space"),
							new Beat(startTime + gap * 403, "J"),
							new Beat(startTime + gap * 404, "K"),
							new Beat(startTime + gap * 405, "L"),
							new Beat(startTime + gap * 406, "S"),
							new Beat(startTime + gap * 407, "D"),
							new Beat(startTime + gap * 408, "F"),
							new Beat(startTime + gap * 409, "Space"),
							new Beat(startTime + gap * 410, "J"),
							new Beat(startTime + gap * 411, "K"),
							new Beat(startTime + gap * 412, "L"),
							new Beat(startTime + gap * 413, "S"),
							new Beat(startTime + gap * 414, "D"),
							new Beat(startTime + gap * 415, "F"),
							new Beat(startTime + gap * 416, "Space"),
							new Beat(startTime + gap * 417, "J"),
							new Beat(startTime + gap * 418, "K"),
							new Beat(startTime + gap * 419, "L"),
							new Beat(startTime + gap * 420, "S"),
							new Beat(startTime + gap * 421, "D"),
							new Beat(startTime + gap * 422, "F"),
							new Beat(startTime + gap * 423, "Space"),
							new Beat(startTime + gap * 424, "J"),
							new Beat(startTime + gap * 425, "K"),
							new Beat(startTime + gap * 426, "L"),
							new Beat(startTime + gap * 427, "S"),
							new Beat(startTime + gap * 428, "D"),
							new Beat(startTime + gap * 429, "F"),
							new Beat(startTime + gap * 430, "Space"),
							new Beat(startTime + gap * 431, "J"),
							new Beat(startTime + gap * 432, "K"),
							new Beat(startTime + gap * 433, "L"),
							new Beat(startTime + gap * 434, "S"),
							new Beat(startTime + gap * 435, "D"),
							new Beat(startTime + gap * 436, "F"),
							new Beat(startTime + gap * 437, "Space"),
							new Beat(startTime + gap * 438, "J"),
							new Beat(startTime + gap * 439, "K"),
							new Beat(startTime + gap * 440, "L"),
							new Beat(startTime + gap * 441, "S"),
							new Beat(startTime + gap * 442, "D"),
							new Beat(startTime + gap * 443, "F"),
							new Beat(startTime + gap * 444, "Space"),
							new Beat(startTime + gap * 445, "J"),
							new Beat(startTime + gap * 446, "K"),
							new Beat(startTime + gap * 447, "L"),
							new Beat(startTime + gap * 448, "S"),
							new Beat(startTime + gap * 449, "D"),
							new Beat(startTime + gap * 450, "F"),
							new Beat(startTime + gap * 451, "Space"),
							new Beat(startTime + gap * 452, "J"),
							new Beat(startTime + gap * 453, "K"),
							new Beat(startTime + gap * 454, "L"),
							new Beat(startTime + gap * 455, "S"),
							new Beat(startTime + gap * 456, "D"),
							new Beat(startTime + gap * 457, "F"),
							new Beat(startTime + gap * 458, "Space"),
							new Beat(startTime + gap * 459, "J"),
							new Beat(startTime + gap * 460, "K"),
							new Beat(startTime + gap * 461, "L"),
							new Beat(startTime + gap * 462, "S"),
							new Beat(startTime + gap * 463, "D"),
							new Beat(startTime + gap * 464, "F"),
							new Beat(startTime + gap * 465, "Space"),
							new Beat(startTime + gap * 466, "J"),
							new Beat(startTime + gap * 467, "K"),
							new Beat(startTime + gap * 468, "L"),
							new Beat(startTime + gap * 469, "S"),
							new Beat(startTime + gap * 470, "D"),
							new Beat(startTime + gap * 471, "F"),
							new Beat(startTime + gap * 472, "Space"),
							new Beat(startTime + gap * 473, "J"),
							new Beat(startTime + gap * 474, "K"),
							new Beat(startTime + gap * 475, "L"),
							new Beat(startTime + gap * 476, "S"),
							new Beat(startTime + gap * 477, "D"),
							new Beat(startTime + gap * 478, "F"),
							new Beat(startTime + gap * 479, "Space"),
							new Beat(startTime + gap * 480, "J"),
							new Beat(startTime + gap * 481, "K"),
							new Beat(startTime + gap * 482, "L"),
							new Beat(startTime + gap * 483, "S"),
							new Beat(startTime + gap * 484, "D"),
							new Beat(startTime + gap * 485, "F"),
							new Beat(startTime + gap * 486, "Space"),
							new Beat(startTime + gap * 487, "J"),
							new Beat(startTime + gap * 488, "K"),
							new Beat(startTime + gap * 489, "L"),
							new Beat(startTime + gap * 490, "S"),
							new Beat(startTime + gap * 491, "D"),
							new Beat(startTime + gap * 492, "F"),
							new Beat(startTime + gap * 493, "Space"),
							new Beat(startTime + gap * 494, "J"),
							new Beat(startTime + gap * 495, "K"),
							new Beat(startTime + gap * 496, "L"),
							new Beat(startTime + gap * 497, "S"),
							new Beat(startTime + gap * 498, "D"),
							new Beat(startTime + gap * 499, "F")
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
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	 public void judgeEvent(String judge) {
       if(!judge.equals("None")) {
       blueFlareImage = new ImageIcon(getClass().getResource("/images/blue_flare.png")).getImage();
       }
       if (judge.equals("Miss")) {
           judgeImage = new ImageIcon(getClass().getResource("/images/judgeMiss.png")).getImage();
      
       } else if (judge.equals("Late")) {
           judgeImage = new ImageIcon(getClass().getResource("/images/judgeLate.png")).getImage();
          
       } else if (judge.equals("Early")) {
           judgeImage = new ImageIcon(getClass().getResource("/images/judgeEarly.png")).getImage();

       } else if (judge.equals("Good")) {
           judgeImage = new ImageIcon(getClass().getResource("/images/judgeGood.png")).getImage();
         

       } else if (judge.equals("Great")) {
           judgeImage = new ImageIcon(getClass().getResource("/images/judgeGreat.png")).getImage();
           

       } else if (judge.equals("Perfect")) {
           judgeImage = new ImageIcon(getClass().getResource("/images/judgePerfect.png")).getImage();
           
       }
   }
}
