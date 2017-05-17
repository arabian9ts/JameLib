package GameEngine;

/**
 * フレームレートを固定する役割を持つインターフェースです
 * @author arabian9ts
 *
 */
public interface IFrameRate {
	
	/**
	 * 処理の開始を宣言します
	 */
	public void checkin();
	
	/**
	 * 処理の終了を宣言します
	 * @return スリープする時間
	 */
	public long checkout();
}
