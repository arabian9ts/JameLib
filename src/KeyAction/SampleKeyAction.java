package KeyAction;

import java.awt.event.KeyEvent;

import Screens.IRenderingDelegation;
import SelfEvents.ISwichScreenReceiver;
import SelfEvents.SwichScreenAction;

/**
 * サンプル画面用のキーアクション
 * @author arabian9ts
 *
 */
public class SampleKeyAction implements IKeyDelegation {
	private IRenderingDelegation _renderer;
	private ISwichScreenReceiver _receiver;

	/**
	 * キーが押された時のSampleScreenの挙動
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("at screen 1"); //$NON-NLS-1$
		fireSwichScreenAction();
	}

	/**
	 * キーが押されている時のSampleScreenの挙動
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		//
	}

	/**
	 * キーが離された時のSampleScreenの挙動
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		//
	}

	/**
	 * 紐付けするスクリーンの実体
	 * @see KeyAction.IKeyDelegation#bindDependedDelegator(Screens.IRenderingDelegation)
	 */
	@Override
	public void bindDependedDelegator(IRenderingDelegation renderer) {
		this._renderer=renderer;
	}

	/**
	 * スクリーン入れ替えイベントを発火します
	 * @see KeyAction.IKeyDelegation#fireSwichScreenAction()
	 */
	@Override
	public void fireSwichScreenAction() {
		this._receiver.swichScreenReceiver(new SwichScreenAction("sample2", this._receiver)); //$NON-NLS-1$
	}

	/**
	 * スクリーン入れ替えイベントのレシーバーを登録します
	 * @see KeyAction.IKeyDelegation#registReceiver(SelfEvents.ISwichScreenReceiver)
	 */
	@Override
	public void registReceiver(ISwichScreenReceiver receiver) {
		this._receiver=receiver;
	}


}
