package SelfEvents;

import java.util.EventListener;

/**
 * スクリーンを入れ替えるためのイベントを受け取ります
 * @author arabian9ts
 *
 */
public interface ISwichScreenReceiver extends EventListener {
	
	/**
	 * スクリーン入れ替えイベントを受け取ります
	 * @param se イベントソース
	 */
	public void swichScreenReceiver(SwichScreenAction se);
	

	
}
