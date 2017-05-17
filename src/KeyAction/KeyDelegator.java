package KeyAction;

import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JPanel;

import Screens.IRenderingDelegation;

/**
 * キーアクションを委譲します
 * @author arabian9ts
 *
 */
public class KeyDelegator {
	private IKeyDelegation _deleg_tar;
	private HashMap<String, IKeyDelegation> _deleg_map=new HashMap<String, IKeyDelegation>();
	
	/**
	 * デフォルトコンストラクタ
	 */
	public KeyDelegator(){
		//
	}
	
	/**
	 * キーアクションを切り替えます
	 * @param receiver キーアクションのレシーバ
	 * @param identifier キーアクションの委譲先の識別子
	 */
	public void linkKeyDeielgation(JPanel receiver, String identifier){
		receiver.removeKeyListener(this._deleg_tar);
		this._deleg_tar=this._deleg_map.get(identifier);
		if(this._deleg_tar==null){
			System.out.println("登録されていないキーリスナを指定しました"); //$NON-NLS-1$
			System.exit(1);
		}
		receiver.addKeyListener((KeyListener)this._deleg_tar);
	}
	
	/**
	 * キーアクションの委譲先を紐付けします
	 * @param identifier キーリスナの識別子
	 * @param delegation キーリスナ
	 * @param renderer キーアクションに対応するスクリーン描画クラス
	 */
	public void bindKeyDelegation(String identifier, IKeyDelegation delegation, IRenderingDelegation renderer){
		this._deleg_map.put(identifier, delegation);
		this._deleg_tar=delegation;
		this._deleg_tar.bindDependedScreen(renderer);
	}

}
