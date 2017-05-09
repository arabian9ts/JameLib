package Exceptions;

/**
 * 画像読み込み時に生じる例外です
 * @author arabian9ts
 *
 */
public class ImageLoadException extends Exception {
	/**
	 * 画像読み込みのエラー
	 * @param error エラーメッセージ
	 */
	public ImageLoadException(String error){
		super(error);
	}
}
