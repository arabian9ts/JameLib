package Base;

import java.awt.Point;

/**
 * BaseNodeがインターフェースです。
 * @author arabian9ts
 *
 */
public interface IBaseNode {
	/**
	 * 現在の左上隅の座標を返します
	 * @return 左上隅の座標
	 */
	public Point alloc();
	
	/**
	 * ノードの座標を割り当てます
	 * @param _x 割り当てるx座標
	 * @param _y 割り当てるy座標
	 * @return 割り当てた座標
	 */
	public Point alloc(int _x, int _y);
	
	/**
	 * ベースノード同士の当たり判定を行います
	 * @param targ 当たり判定を行う対象ノード
	 * @return true: 衝突している false: 衝突していない
	 */
	public boolean collision(BaseNode targ);
	
	/**
	 * 第4象限の座標を返します
	 * @return　第4象限の座標
	 */
	public Point location4();
}
