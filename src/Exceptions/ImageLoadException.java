package Exceptions;

/**
 * 画像読み込み時に生じる例外です
 * @author arabian9ts
 *
 */
public class ImageLoadException extends Exception {
	
	/**
	 * デフォルトコンストラクタ
	 */
	public ImageLoadException(){
		super("画像が読み込めません"); //$NON-NLS-1$
	}
	
	/**
	 * 画像読み込みのエラー
	 * @param path 取得しようとしたファイルのパス
	 */
	public ImageLoadException(String path){
		super("画像が読み込めません : "+path); //$NON-NLS-1$
	}
}
