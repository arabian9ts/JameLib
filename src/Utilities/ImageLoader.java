package Utilities;

import java.awt.Image;

import javax.imageio.ImageIO;

import Exceptions.ImageLoadException;

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
	 * @throws ImageLoadException 画像読み込み例外
	 */
	public static Image loadImage(String img_path) throws ImageLoadException {
		Image image;
		try {
			 image=ImageIO.read(ImageLoader.class.getClassLoader().getResource(img_path));
		} catch (Exception e) {
			throw new ImageLoadException("画像が読み込めません"); //$NON-NLS-1$
		}
		return image;
	}
}
