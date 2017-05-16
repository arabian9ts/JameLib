package KeyAction;

import java.awt.event.KeyListener;

import Screens.IRenderingDelegation;

/**
 * キーアクションとスクリーンを関連させるためのインターフェースです
 * @author arabian9ts
 *
 */
public interface IKeyDelegation extends KeyListener {
	
	/**
	 * 関連するスクリーンのインスタンスを送信します
	 * @param renderer キーに対応するスクリーン
	 */
	public void dependency(IRenderingDelegation renderer);

}
