package Effects;

import java.awt.Graphics;
import java.awt.Image;

import Utilities.ImageLoader;

/**
 * サンプルのエフェクトクラス
 * @author arabian9ts
 *
 */
public class SampleEffect implements Effect {
	int cnt = 0;
	int sup = 4;
	int R = 50;
	int radius = this.R;
	Image effect;

	/**
	 * エフェクトの初期化コンストラクタ
	 */
	public SampleEffect() {
		initialize();
		(new Thread(this)).start();
	}
	
	/** (non-Javadoc)
	 * @see Effects.Effect#initialize()
	 */
	public void initialize(){
		try {
			this.effect = (new ImageLoader()).loadImage("images/sample.jpg"); //$NON-NLS-1$
		} catch (Exception e) {
			//
		}
	}
	
	/** (non-Javadoc)
	 * @see Effects.Effect#update()
	 */
	public void update(){
		this.cnt++;
		this.radius = this.R + (this.cnt + 1) * 15;
	}

	/**
	 * Runnableインターフェースrunメソッド
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			update();
			if (this.cnt >= this.sup) {
				return;
			}
		}
	}


	/**
	 * 画面描画関数<br>
	 * エフェクトを画面上に描画する
	 * @param g グラフィックス
	 * @see Effects.Effect#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		g.drawImage(this.effect, 500 - this.radius, 500
				- this.radius, 2 * this.radius, 2 * this.radius, null);
	}
}

