package Screens;

import java.awt.Color;
import java.awt.Graphics;

import Effects.EffectDelegation;
import Effects.SampleEffect;

/**
 * @author arabian9ts
 *
 */
public class SampleScreen implements Screen {
	private int x;
	private int y;
	private int counter;
	private EffectDelegation delegator=new EffectDelegation();

	/**
	 * 画面病がのための初期化処理をします
	 * @see Screens.Screen#initialize()
	 */
	@Override
	public void initialize() {
		/* ここに初期化したい処理を書きます */
		this.x=0;
		this.y=30;
		this.counter=15;
		this.delegator.setEffect(new SampleEffect());
	}

	/**
	 * アニメーションのための更新処理をします
	 * @see Screens.Screen#update()
	 */
	@Override
	public void update() {
		/* ここに更新したい処理を書きます */
		this.x=this.x%500+1;
		this.counter=this.counter%150+1;
		
		if(this.counter%100==0){
			this.delegator.setEffect(new SampleEffect());
		}
	}

	/**
	 * 画面の描画をします
	 * @see Screens.Screen#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		/* ここに描画したいものを書きます */
		g.setColor(Color.blue);
		g.fillOval(this.x, this.y, 100, 100);

		this.delegator.effect(g);
	}

	/**
	 * 画面を切り替えるときの終了処理をします
	 * @see Screens.Screen#terminate()
	 */
	@Override
	public void terminate() {
		/* ここに終了処理を書きます */
	}

}
