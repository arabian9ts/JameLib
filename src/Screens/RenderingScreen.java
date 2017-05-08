package Screens;

import java.awt.Graphics;
import java.util.HashMap;

/**
 * スクリーンを制御するクラス<br>
 * 作成したスクリーンモードの登録、切り替えを行う
 * @author arabian9ts
 *
 */
public class RenderingScreen implements Screen {
	Screen current;
	HashMap<String, Screen> screen_map=new HashMap<String, Screen>();
	
	/**
	 * スクリーンを切り替えます
	 * @param identifier スクリーンの識別子
	 */
	public void swapScreen(String identifier){
		terminate();
		this.current=this.screen_map.get(identifier);
		if(this.current==null){
			System.out.println("登録されていないスクリーンを指定しました"); //$NON-NLS-1$
			System.exit(1);
		}
		initialize();
	}
	
	/**
	 * スクリーンを登録するメソッドです<br>
	 * スクリーンを識別する名前、作成したスクリーンの実態をワタシてください
	 * @param identifier スクリーンに持たせる名前(ex. start, result, ..., etc)
	 * @param screen スクリーン変数
	 */
	public void addScreen(String identifier, Screen screen){
		this.screen_map.put(identifier, screen);
		this.current=screen;
	}

	/**
	 * 現在のスクリーンの初期化関数を呼び出します
	 * @see Screens.Screen#terminate()
	 */
	@Override
	public void initialize() {
		this.current.initialize();
	}

	/**
	 * 現在のスクリーンの更新を行います
	 * @see Screens.Screen#terminate()
	 */
	@Override
	public void update() {
		this.current.update();
	}

	/**
	 * 現在のスクリーンの描画処理を行います
	 * @param g グラフィックス
	 * @see Screens.Screen#terminate()
	 */
	@Override
	public void render(Graphics g) {
		this.current.render(g);
	}
	
	/**
	 * 現在のスクリーンの終了処理を行います
	 * @see Screens.Screen#terminate()
	 */
	@Override
	public void terminate(){
		this.current.terminate();
	}
}
