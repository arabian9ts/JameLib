package Base;

import java.awt.Point;

/**
 * ベースとなるノードを提供します
 * @author arabian9ts
 *
 */
public abstract class BaseNode implements IBaseNode {
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
	 * @see Base.IBaseNode#alloc()
	 */
	@Override
	public Point alloc(){
		return new Point(-1, -1);
	}
	
	/**
	 * ノードの座標を割り当てます
	 * @param _x 割り当てるx座標
	 * @param _y 割り当てるy座標
	 * @return 割り当てた座標
	 * @see Base.IBaseNode#alloc(int, int)
	 */
	@Override
	public Point alloc(int _x, int _y){
		this.x=_x;
		this.y=_y;
		return new Point(_x, _y);
	}
	
	/**
	 * ベースノード同士の当たり判定を行います
	 * @param targ 当たり判定を行う対象ノード
	 * @return true: 衝突している false: 衝突していない
	 * @see Base.IBaseNode#collision(Base.BaseNode)
	 */
	@Override
	public boolean collision(BaseNode targ){
		
		return true;
	}
	
	/**
	 * 第4象限の座標を返します
	 * @return　第4象限の座標
	 * @see Base.IBaseNode#location4()
	 */
	public Point location4(){
		return new Point(0,0);
	}
	
}
