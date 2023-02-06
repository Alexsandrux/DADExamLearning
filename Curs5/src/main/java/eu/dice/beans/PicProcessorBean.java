package eu.dice.beans;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;

public class PicProcessorBean {
	public PicProcessorBean() {

	}

	public int processPicture(String inputPicFilePath, String outputPicFilePath, String x, String y, String w,
			String h) {
		int res = 0;
		try {
			BufferedImage img = ImageIO.read(new File(inputPicFilePath));
			BufferedImage imgRes = img.getSubimage(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(w), Integer.parseInt(h));
			ImageIO.write(imgRes, "jpg", new File(outputPicFilePath));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			res = -1;
		}
		return res;
	}
}
