package Effects;

import java.awt.Graphics;

/**
 * エフェクト描画委譲のためのインターフェース<br>
 * エフェクトを使用する場合はこのインターフェースを実装してください
 * @author arabian9ts
 *
 */
public interface IEffectDelegation {

	/**
	 * エフェクトの初期化関数<br>
	 * 画像の読み込みなどを行ってください
	 */
	public void initialize();
	
	/**
	 * えっフェぅとの変化処理を行ってください<br>
	 * オーバーライドしたRunnableインターフェースのrunメソッド内で利用してください
	 */
	public void update();
	
	/**
	 * エフェクトの描画処理を記述してください
	 * @param g グラフィックス
	 */
	public void render(Graphics g);
	
}
