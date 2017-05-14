package Screens;

import java.awt.Graphics;
import java.util.HashMap;

/**
 * スクリーンを委譲するクラス<br>
 * 作成したスクリーンモードの登録、切り替えを行います<br>
 * また、スクリーンの実態に更新、描画を委譲します
 * @author arabian9ts
 *
 */
public class RenderingDelegator {
	private Screen current;
	private HashMap<String, Screen> screen_map=new HashMap<String, Screen>();
	
	/**
	 * スクリーンを切り替えます
	 * @param identifier スクリーンの識別子
	 */
	public void swapScreen(String identifier){
		this.current.terminate();
		this.current=this.screen_map.get(identifier);
		if(this.current==null){
			System.out.println("登録されていないスクリーンを指定しました"); //$NON-NLS-1$
			System.exit(1);
		}
		this.current.initialize();
	}
	
	/**
	 * スクリーンを登録するメソッドです<br>
	 * スクリーンを識別する名前、作成したスクリーンの実態を渡してください
	 * @param identifier スクリーンに持たせる名前(ex. start, result, ..., etc)
	 * @param screen スクリーンの実態
	 */
	public void addScreen(String identifier, Screen screen){
		this.screen_map.put(identifier, screen);
		this.current=screen;
	}

	/**
	 * スクリーンの更新、描画を行います
	 * @param g グラフィックス
	 */
	public void screen(Graphics g){
		if(this.current!=null){
			this.current.update();
			this.current.render(g);
		}
	}
	
}
