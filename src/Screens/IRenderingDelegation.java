package Screens;

import java.awt.Graphics;

/**
 * 画面描画を以上するためのインターフェース
 * @author arabian9ts
 */
public interface IRenderingDelegation {
	
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
