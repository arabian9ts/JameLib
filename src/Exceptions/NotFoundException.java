package Exceptions;

/**
 * ファイルが存在しないときに生じる例外です
 * @author arabian9ts
 *
 */
public class NotFoundException extends Exception{
	
	/**
	 * デフォルトコンストラクタ
	 */
	public NotFoundException(){
		super("ファイルが存在しません"); //$NON-NLS-1$
	}
	
	/**
	 * ファイルが存在しない例外
	 * @param path 取得しようとしたファイルのパス
	 */
	public NotFoundException(String path){
		super("ファイルが存在しません : "+path); //$NON-NLS-1$
	}
}
