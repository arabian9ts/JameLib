package Utilities;

import java.awt.Image;

import javax.imageio.ImageIO;

/**
 * 画像を取得するクラス
 * @author arabian9ts
 *
 */
public class ImageLoader {

	/**
	 * 与えられたパスから画像をロードし、返却する
	 * @param img_path 取得したい画像の相対パス
	 * @return Image型のロードした画像
	 */
	public Image loadImage(String img_path) {
		try {
			 return ImageIO.read(getClass().getClassLoader().getResource(img_path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			//
		}
		return null;
	}
}
