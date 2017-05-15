package Effects;

import java.awt.Graphics;

/**
 * エフェクトの描画を委譲します
 * @author arabian9ts
 *
 */
public class EffectDelegator {
	private IEffectDelegation _effect;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public EffectDelegator(){
		//
	}
	
	/**
	 * エフェクトリスナをセットします
	 * @param eff エフェクトリスナ
	 */
	public void bindEffect(IEffectDelegation eff){
		this._effect=eff;
		this._effect.initialize();
	}
	
	/**
	 * エフェクトの更新、描画を行います
	 * @param g グラフィックス
	 */
	public void delegate(Graphics g){
		if(this._effect!=null){
			this._effect.update();
			this._effect.render(g);
		}
	}
}
