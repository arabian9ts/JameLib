package KeyAction;

import java.awt.event.KeyEvent;

import Screens.IRenderingDelegation;

/**
 * サンプル画面用のキーアクション
 * @author arabian9ts
 *
 */
public class SampleKeyAction implements IKeyDelegation {
	private IRenderingDelegation _renderer;

	/**
	 * キーが押された時のSampleScreenの挙動
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		//
	}

	/**
	 * キーが押されている時のSampleScreenの挙動
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("typed!"); //$NON-NLS-1$
		this._renderer.initialize();
	}

	/**
	 * キーが話された時のSampleScreenの挙動
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		//
	}

	/**
	 * 関連するスクリーンの実体を受け取ります
	 * @see KeyAction.IKeyDelegation#bindDependedScreen(Screens.IRenderingDelegation)
	 */
	@Override
	public void bindDependedScreen(IRenderingDelegation renderer) {
		this._renderer=renderer;
	}

}
