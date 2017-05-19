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
public class SampleEffect implements IEffectDelegation {
	private int _radius = 10;
	private Image _image;

	/**
	 * エフェクトの初期化コンストラクタ
	 */
	public SampleEffect() {
		initialize();
	}
	
	
	/**
	 * エフェクトの初期化をします
	 * @see Effects.IEffectDelegation#initialize()
	 */
	@Override
	public void initialize(){
		try {
			this._image = (ImageLoader.loadImage("images/effect/sample_effect.jpg")); //$NON-NLS-1$
		}catch(NotFoundException en){
			en.printStackTrace();
		}
		catch (ImageLoadException ei) {
			ei.printStackTrace();
		}
	}
	
	/**
	 * エフェクトの更新を行います
	 * @see Effects.IEffectDelegation#update()
	 */
	@Override
	public void update(){
		this._radius+=1;
	}


	/**
	 * 画面描画関数<br>
	 * エフェクトを画面上に描画する
	 * @param g グラフィックス
	 * @see Effects.IEffectDelegation#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(this._image, 230 - this._radius, 250
				- this._radius, 2 * this._radius, 2 * this._radius, null);
		
	}

}

