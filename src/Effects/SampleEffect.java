package Effects;

import java.awt.Graphics;
import java.awt.Image;

import Exceptions.ImageLoadException;
import Exceptions.NotFoundException;
import Utilities.ImageLoader;

/**
 * サンプルのエフェクトクラス
 * @author arabian9ts
 *
 */
public class SampleEffect implements Effect {
	int R = 10;
	int radius = this.R;
	Image image;

	/**
	 * エフェクトの初期化コンストラクタ
	 */
	public SampleEffect() {
		initialize();
		(new Thread(this)).start();
	}
	

	/**
	 * エフェクトのスレッドをスタートします
	 * @see Effects.Effect#start()
	 */
	@Override
	public void start() {
		(new Thread(this)).start();
	}
	
	/**
	 * エフェクトの初期化をします
	 * @see Effects.Effect#initialize()
	 */
	@Override
	public void initialize(){
		try {
			this.image = (ImageLoader.loadImage("images/sample_effect.jpg")); //$NON-NLS-1$
		}catch(NotFoundException en){
			en.printStackTrace();
		}
		catch (ImageLoadException ei) {
			ei.printStackTrace();
		}
	}
	
	/**
	 * エフェクトの更新を行います
	 * @see Effects.Effect#update()
	 */
	@Override
	public void update(){
		this.radius+=3;
	}

	/**
	 * Runnableインターフェースrunメソッド
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			update();
			//render(MainContainer.g);
			System.out.println("running"); //$NON-NLS-1$
			if (this.radius >= 200) {
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
	@Override
	public void render(Graphics g) {
		g.drawImage(this.image, 200 - this.radius, 300
				- this.radius, 2 * this.radius, 2 * this.radius, null);
		
	}

}

