package KeyEvents;

import Screens.RenderingDelegator;

/**
 * キーアクションを委譲します
 * @author arabian9ts
 *
 */
public class KeyDelegator {
	RenderingDelegator rdelegator;
	
	/**
	 * デフォルトコンストラクタ
	 * @param rdel レンダリングを以上するインスタンス
	 */
	public KeyDelegator(RenderingDelegator rdel){
		this.rdelegator=rdel;
	}
	
	
}
