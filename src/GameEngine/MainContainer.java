package GameEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Constants.WindowParams;
import Screens.RenderingDelegator;
import Screens.SampleScreen;

/**
 * 画面の構成要素を配置するコンテナ
 * @author arabian9ts
 *
 */
public class MainContainer extends JPanel implements Runnable {
	/**
	 * コンポーネントの初期化を行います
	 * @param frame メインフレーム
	 */
	public MainContainer(JFrame frame) {
		setBackground(Color.black);
		frame.setVisible(true);
		frame.setSize(WindowParams.width, WindowParams.height);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.createBufferStrategy(this._bufferSize);
		
		this._frame = frame;
		this._rate=new FrameRate();
		this._renderer = new RenderingDelegator();
		this._bufferStrategy = this._frame.getBufferStrategy();
		
		screenRegister();
	}
	
	/**
	 * スクリーンを登録します
	 */
	public void screenRegister(){
		this._renderer.bindRenderer("sample", new SampleScreen()); //$NON-NLS-1$
		this._renderer.swapChain("sample"); //$NON-NLS-1$
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
			this._rate.checkin();
			for (int i = 0; i < this._bufferSize; i++) {
				this._g = this._bufferStrategy.getDrawGraphics();
				if (!this._bufferStrategy.contentsLost()) {
					this._g.setColor(Color.black);
					this._g.fillRect(0,0,getWidth()+50,getHeight()+50);
					this._renderer.delegate(this._g);
					this._bufferStrategy.show();
					this._g.dispose();
				}
			}
			try{
				Thread.sleep(this._rate.checkout());
			}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
		}
	}
	
	
	private int _bufferSize = 2;
	private Graphics _g;
	private JFrame _frame;
	private FrameRate _rate;
	private RenderingDelegator _renderer;
	private BufferStrategy _bufferStrategy;
	
}
