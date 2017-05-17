package GameEngine;

import javax.swing.JFrame;

import Constants.WindowParams;

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
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.setSize(WindowParams.width, WindowParams.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainContainer container=new MainContainer(frame, new FrameRate(60));
		frame.getContentPane().add(container);

		container.game_start();
	}
}
