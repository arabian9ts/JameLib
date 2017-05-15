package Base;

import java.awt.Point;

/**
 * ベースとなるノードを提供します
 * @author arabian9ts
 *
 */
public abstract class BaseNode {
	protected int x;
	protected int y;
	
	/**
	 * デフォルトコンストラクタ
	 */
	protected BaseNode(){
		this.x=0;
		this.y=0;
	}
	
	/**
	 * 現在の左上隅の座標を返します
	 * @return 左上隅の座標
	 */
	protected Point alloc(){
		return new Point(-1, -1);
	}
	
	/**
	 * ノードの座標を割り当てます
	 * @param _x 割り当てるx座標
	 * @param _y 割り当てるy座標
	 * @return 割り当てた座標
	 */
	protected Point alloc(int _x, int _y){
		this.x=_x;
		this.y=_y;
		return new Point(_x, _y);
	}
	
	/**
	 * ベースノード同士の衝突を判定します
	 * @param targ 衝突判定をする対象のノード
	 * @return true: 衝突している false: 衝突していない
	 */
	protected boolean Collision(BaseNode targ){
		
		return true;
	}
	
}
