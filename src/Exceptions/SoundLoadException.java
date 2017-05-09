package Exceptions;

/**
 * サウンド読み込み時の例外です
 * @author arabian9ts
 *
 */
public class SoundLoadException extends Exception {
	/**
	 * サウンド読み込みのエラー
	 * @param error エラーメッセージ
	 */
	public SoundLoadException(String error){
		super(error);
	}
}
