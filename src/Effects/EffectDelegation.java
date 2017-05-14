package Effects;

import java.awt.Graphics;

/**
 * エフェクトの描画を委譲します
 * @author arabian9ts
 *
 */
public class EffectDelegation {
	Effect effect;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public EffectDelegation(){
		//
	}
	
	/**
	 * エフェクトリスナをセットします
	 * @param eff エフェクトリスナ
	 */
	public void setEffect(Effect eff){
		this.effect=eff;
		this.effect.initialize();
	}
	
	/**
	 * エフェクトの更新、描画を行います
	 * @param g グラフィックス
	 */
	public void effect(Graphics g){
		if(this.effect!=null){
			this.effect.update();
			this.effect.render(g);
		}
	}
}
