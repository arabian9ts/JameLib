package Screens;

import java.awt.Color;
import java.awt.Graphics;

import Effects.Effect;
import Effects.SampleEffect;

/**
 * @author arabian9ts
 *
 */
public class SampleScreen implements Screen {
	Effect _effect;

	/**
	 * 画面病がのための初期化処理をします
	 * @see Screens.Screen#initialize()
	 */
	@Override
	public void initialize() {
		/* ここに初期化したい処理を書きます */
		this._effect=new SampleEffect();
	}

	/**
	 * アニメーションのための更新処理をします
	 * @see Screens.Screen#update()
	 */
	@Override
	public void update() {
		/* ここに更新したい処理を書きます */
	}

	/**
	 * 画面の描画をします
	 * @see Screens.Screen#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		/* ここに描画したいものを書きます */
		g.setColor(Color.black);
		g.fillOval(50, 80, 100, 100);
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
