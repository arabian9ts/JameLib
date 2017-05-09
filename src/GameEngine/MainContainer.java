package GameEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Screens.RenderingScreen;
import Screens.SampleScreen;

/**
 * 画面の構成要素を配置するコンテナ
 * @author arabian9ts
 *
 */
public class MainContainer extends JPanel implements Runnable {
	int bufferSize = 2;
	JFrame frame;
	FrameRate rate;
	RenderingScreen renderer;
	BufferStrategy bufferStrategy;
	SampleScreen _sample;

	/**
	 * コンポーネントの初期化を行います
	 * @param frame メインフレーム
	 */
	public MainContainer(JFrame frame) {
		setBackground(Color.black);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.createBufferStrategy(this.bufferSize);
		
		this._sample=new SampleScreen();
		this.frame = frame;
		this.rate=new FrameRate();
		this.renderer = new RenderingScreen();
		this.renderer.addScreen("sample", this._sample); //$NON-NLS-1$
		this.renderer.swapScreen("sample"); //$NON-NLS-1$
		this.bufferStrategy = this.frame.getBufferStrategy();
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
		while (true) {
			this.rate.checkin();
			for (int i = 0; i < this.bufferSize; i++) {
				Graphics g = this.bufferStrategy.getDrawGraphics();
				if (!this.bufferStrategy.contentsLost()) {
					this.renderer.update();
					this.renderer.render(g);
					this.bufferStrategy.show();
					g.dispose();
				}
			}
			try{
				long s=this.rate.checkout();
				System.out.println(s);
				Thread.sleep(s);
				//Thread.sleep(100);
			}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
		}
	}
}
