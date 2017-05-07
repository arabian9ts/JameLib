package GameEngine;

import javax.swing.JFrame;

/**
 * ゲームのメインクラス<br>
 * スクリーンの追加や切り替えはこのクラスで行います
 * @author arabian9ts
 *
 */
public class GameMain {

	/**
	 * メインメソッド
	 * @param args コマンドライン引数です
	 */
	public static void main(String[] args) {
		MainContainer container=new MainContainer();
		JFrame frame=new JFrame();
		frame.getContentPane().add(container);
	}

}
