package Screens;

import java.awt.Graphics;
import java.util.HashMap;

/**
 * スクリーンの描画を委譲するクラス<br>
 * 作成したスクリーンモードの登録、切り替えを行います<br>
 * また、スクリーンの実態に更新、描画を委譲します
 * @author arabian9ts
 *
 */
public class RenderingDelegator {
	private IRenderingDelegation _deleg_tar;
	private HashMap<String, IRenderingDelegation> _deleg_map=new HashMap<String, IRenderingDelegation>();
	
	/**
	 * スクリーンを切り替えます
	 * @param identifier スクリーンの識別子
	 */
	public void swapChain(String identifier){
		this._deleg_tar.terminate();
		this._deleg_tar=this._deleg_map.get(identifier);
		if(this._deleg_tar==null){
			System.out.println("登録されていないスクリーンを指定しました"); //$NON-NLS-1$
			System.exit(1);
		}
		this._deleg_tar.initialize();
	}

	/**
	 * スクリーンを追加します
	 * @param identifier 登録するスクリーンの識別子
	 * @param screen 登録するスクリーンの識別子
	 */
	public void bindRenderer(String identifier, IRenderingDelegation screen){
		this._deleg_map.put(identifier, screen);
		this._deleg_tar=screen;
	}

	/**
	 * スクリーンの更新、描画を行います
	 * @param g グラフィックス
	 */
	public void delegate(Graphics g){
		if(this._deleg_tar!=null){
			this._deleg_tar.update();
			this._deleg_tar.render(g);
		}
	}

	
}
