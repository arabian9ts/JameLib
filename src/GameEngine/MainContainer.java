package GameEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Constants.WindowParams;
import KeyAction.KeyDelegator;
import KeyAction.SampleKeyAction;
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
	 * @param frame_rater フレームレートインターフェース
	 */
	public MainContainer(JFrame frame, IFrameRate frame_rater) {
		setBackground(Color.black);
		frame.createBufferStrategy(this._bufferSize);
		
		this._frame = frame;
		this._rater=new FrameRate();
		this._rdelegator = new RenderingDelegator();
		this._kdelegator=new KeyDelegator();
		this._bufferStrategy = this._frame.getBufferStrategy();
		
		screenRegister();
	}
	
	/**
	 * スクリーンを登録します
	 */
	public void screenRegister(){
		SampleScreen sample=new SampleScreen();
		this._rdelegator.bindRenderer("sample", sample); //$NON-NLS-1$
		this._kdelegator.bindKeyDelegation("sample", new SampleKeyAction(), sample); //$NON-NLS-1$
		
		this._rdelegator.swapChain("sample"); //$NON-NLS-1$
		this._kdelegator.linkKeyDeielgation(this, "sample"); //$NON-NLS-1$
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
			this._rater.checkin();
			for (int i = 0; i < this._bufferSize; i++) {
				this._g = this._bufferStrategy.getDrawGraphics();
				if (!this._bufferStrategy.contentsLost()) {
					this._g.setColor(Color.black);
					this._g.fillRect(0,0,WindowParams.width,WindowParams.height);
					this._rdelegator.delegate(this._g);
					this._bufferStrategy.show();
					this._g.dispose();
					requestFocusInWindow();
				}
			}
			try{
				Thread.sleep(this._rater.checkout());
			}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
		}
	}
	
	
	private int _bufferSize = 2;
	private Graphics _g;
	private JFrame _frame;
	private IFrameRate _rater;
	private RenderingDelegator _rdelegator;
	private BufferStrategy _bufferStrategy;
	private KeyDelegator _kdelegator;
	
}
