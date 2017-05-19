package Screens;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author arabian9ts
 *
 */
public class SampleScreen implements IRenderingDelegation {
	private int _x;
	private int _y;

	/**
	 * 画面病がのための初期化処理をします
	 * @see Screens.IRenderingDelegation#initialize()
	 */
	@Override
	public void initialize() {
		/* ここに初期化したい処理を書きます */
		this._x=0;
		this._y=200;
	}

	/**
	 * アニメーションのための更新処理をします
	 * @see Screens.IRenderingDelegation#update()
	 */
	@Override
	public void update() {
		/* ここに更新したい処理を書きます */
		this._x=this._x%500+1;
	}

	/**
	 * 画面の描画をします
	 * @see Screens.IRenderingDelegation#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		/* ここに描画したいものを書きます */
		g.setColor(Color.blue);
		g.fillOval(this._x, this._y, 100, 100);
	}

	/**
	 * 画面を切り替えるときの終了処理をします
	 * @see Screens.IRenderingDelegation#terminate()
	 */
	@Override
	public void terminate() {
		/* ここに終了処理を書きます */
	}

}
