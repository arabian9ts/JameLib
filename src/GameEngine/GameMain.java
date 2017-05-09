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
		JFrame frame=new JFrame();
		
		MainContainer container=new MainContainer(frame);
		frame.getContentPane().add(container);
		
		container.game_start();
	}
}
