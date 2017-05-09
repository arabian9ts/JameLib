package Utilities;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Exceptions.ImageLoadException;
import Exceptions.NotFoundException;

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
	 * @throws NotFoundException 画像が存在しない例外
	 */
	public static Image loadImage(String img_path) throws ImageLoadException, NotFoundException {
		if(!new File(img_path).exists()){
			throw new NotFoundException(img_path);
		}
		ImageIcon image=null;
		try {
			image=new ImageIcon(img_path);
		} catch (Exception e) {
			throw new ImageLoadException(img_path);
		}
		return image.getImage();
	}
}
