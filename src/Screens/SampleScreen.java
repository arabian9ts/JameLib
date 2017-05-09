package Screens;

import java.awt.Color;
import java.awt.Graphics;

import Effects.SampleEffect;

/**
 * @author arabian9ts
 *
 */
public class SampleScreen implements Screen {
	int x;
	int y;
	int counter;
	SampleEffect effect;

	/**
	 * 画面病がのための初期化処理をします
	 * @see Screens.Screen#initialize()
	 */
	@Override
	public void initialize() {
		/* ここに初期化したい処理を書きます */
		this.x=0;
		this.y=80;
		this.counter=15;
		(this.effect=new SampleEffect()).start();
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
		
		if(this.counter%150==0){
			System.out.println("create effect"); //$NON-NLS-1$
			(this.effect=new SampleEffect()).start();
		}
		if(this.effect!=null)
			this.effect.render(g);
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
