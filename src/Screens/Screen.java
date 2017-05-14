package Screens;

import java.awt.Graphics;
import java.util.EventListener;

/**
 * 画面病がのインターフェース
 * @author arabian9ts
 */
public interface Screen extends EventListener {
	
	/**
	 * 画面初期化関数
	 */
	public void initialize();
	
	/**
	 * 画面更新関数
	 */
	public void update();
	
	/**
	 * 画面病が関数
	 * @param g : グラフィックス
	 */
	public void render(Graphics g);
	
	/**
	 * 画面最終処理関数<br>
	 * 画面切り替えの際、最後に行う処理を記述
	 */
	public void terminate();
	
}
