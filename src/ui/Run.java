package ui;

import java.io.File;

import shapes.DrawFrame;

public class Run {
	
	
		public static void main(String[] args){
			createImageFolders();
			new MainFrame();
			}

private static void createImageFolders() {
	File imageDir = new File("imgs/full");
	File thumbDir = new File("imgs/thumbs");

	if (!imageDir.exists())
		imageDir.mkdirs();

	if (!thumbDir.exists())
		thumbDir.mkdirs();
}
}