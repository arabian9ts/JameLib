package Base;

/**
 * 円形のノード
 * @author arabian9ts
 *
 */
public class BaseCircle extends BaseNode {
	protected int radius;
	
	/**
	 * デフォルトコンストラiクタ
	 */
	protected BaseCircle(){
		this.radius=0;
	}
	
	/**
	 * 円の永承を変形します
	 * @param _radius 新しい半径
	 */
	protected void transform(int _radius){
		this.radius=_radius;
	}
	
}
