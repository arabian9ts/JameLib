package SelfEvents;

import java.util.EventObject;

/**
 * @author arabian9ts
 *
 */
public class SwichScreenAction extends EventObject {
	/**
	 * スクリーン識別子です
	 */
	public String identifier="unknown"; //$NON-NLS-1$
	
	/**
	 * コンストラクタ
	 * @param identifier スクリーン識別子
	 * @param source イベントの発生元
	 */
	public SwichScreenAction(String identifier, Object source) {
		super(source);
		this.identifier=identifier;
		System.out.println("event occur"); //$NON-NLS-1$
	}

}
