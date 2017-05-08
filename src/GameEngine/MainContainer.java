package GameEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Screens.RenderingScreen;
import Screens.StartScreen;

/**
 * 画面の構成要素を配置するコンテナ
 * @author arabian9ts
 *
 */
public class MainContainer extends JPanel implements Runnable {
	int bufferSize = 2;
	JFrame frame;
	RenderingScreen renderer;
	StartScreen _start;

	/**
	 * コンポーネントの初期化を行います
	 * @param frame メインフレーム
	 */
	public MainContainer(JFrame frame) {
		setBackground(Color.black);
		frame.setVisible(true);
		frame.setSize(500, 500);
		this._start=new StartScreen();
		this.frame = frame;
		this.renderer = new RenderingScreen();
		this.renderer.addScreen("start", this._start); //$NON-NLS-1$
	}

	/**
	 * ゲームのメインスレッドを開始します
	 */
	public void game_start() {
		(new Thread(this)).start();
	}

	/**
	 * オーバーライドしたRunnableインターフェースのrunメソッド
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.frame.createBufferStrategy(this.bufferSize);
		BufferStrategy bufferStrategy = this.frame.getBufferStrategy();
		while (true) {
			for (int i = 0; i < this.bufferSize; i++) {
				Graphics g = bufferStrategy.getDrawGraphics();
				if (!bufferStrategy.contentsLost()) {
					this.renderer.update();
					this.renderer.render(g);
					bufferStrategy.show();
					g.dispose();
				}
			}

		}
	}
}
