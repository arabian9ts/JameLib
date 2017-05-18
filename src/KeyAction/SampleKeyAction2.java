package KeyAction;

import java.awt.event.KeyEvent;

import Screens.IRenderingDelegation;
import SelfEvents.ISwichScreenReceiver;
import SelfEvents.SwichScreenAction;

/**
 * サンプルスクリーン2のキーアクションです
 * @author arabian9ts
 *
 */
public class SampleKeyAction2 implements IKeyDelegation {
	private IRenderingDelegation _renderer;
	private ISwichScreenReceiver _receiver;

	/**
	 * キーが押された時のSampleScreen2の挙動
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent e) {
		System.out.println("at screen 2"); //$NON-NLS-1$
		fireSwichScreenAction();
	}

	/**
	 * キーが押されている時のSampleScreen2の挙動
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		//
	}

	/**
	 * キーが離された時のSampleScreen2の挙動
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		//
	}

	/**
	 * 紐付けするスクリーンの実体
	 * @see KeyAction.IKeyDelegation#bindDependedDelegator(Screens.IRenderingDelegation)
	 */
	public void bindDependedDelegator(IRenderingDelegation renderer) {
		this._renderer=renderer;
	}

	/**
	 * スクリーン入れ替えイベントを発火します
	 * @see KeyAction.IKeyDelegation#fireSwichScreenAction()
	 */
	public void fireSwichScreenAction() {
		this._receiver.swichScreenReceiver(new SwichScreenAction("sample", this._receiver)); //$NON-NLS-1$
	}

	/**
	 * スクリーン入れ替えイベントのレシーバーを登録します
	 * @see KeyAction.IKeyDelegation#registReceiver(SelfEvents.ISwichScreenReceiver)
	 */
	public void registReceiver(ISwichScreenReceiver receiver) {
		this._receiver=receiver;
	}

}
