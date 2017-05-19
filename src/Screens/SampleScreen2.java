package Screens;

import java.awt.Graphics;

import Effects.EffectDelegator;
import Effects.SampleEffect;

/**
 * サンプルスクリーン2
 * @author arabian9ts
 *
 */
public class SampleScreen2 implements IRenderingDelegation {
	private int _counter;
	private EffectDelegator _delegator=new EffectDelegator();

	/**
	 * 画面病がのための初期化処理をします
	 * @see Screens.IRenderingDelegation#initialize()
	 */
	public void initialize() {
		this._counter=15;
		this._delegator.bindEffect(new SampleEffect());
	}

	/**
	 * アニメーションのための更新処理をします
	 * @see Screens.IRenderingDelegation#update()
	 */
	public void update() {
		this._counter=this._counter%150+1;
		if(this._counter%100==0){
			this._delegator.bindEffect(new SampleEffect());
		}
	}

	/**
	 * 画面の描画をします
	 * @see Screens.IRenderingDelegation#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		this._delegator.delegate(g);
	}

	/**
	 * 画面を切り替えるときの終了処理をします
	 * @see Screens.IRenderingDelegation#terminate()
	 */
	public void terminate() {
		/* ここに終了処理を書きます */
	}

}
