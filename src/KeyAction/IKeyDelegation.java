package KeyAction;

import java.awt.event.KeyListener;

import Screens.IRenderingDelegation;
import SelfEvents.ISwichScreenReceiver;

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
	public void bindDependedDelegator(IRenderingDelegation renderer);
	
	/**
	 * スクリーン入れ替えイベントを発火します
	 */
	public void fireSwichScreenAction();
	
	/**
	 * スクリーン入れ替えイベントのレシーバーを登録します
	 * @param receiver 登録するレシーバー
	 */
	public void registReceiver(ISwichScreenReceiver receiver);

	

}
