package Base;

/**
 * 四角形のノード
 * @author arabian9ts
 *
 */
public class BaseRect extends BaseNode {
	protected int width;
	protected int height;
	
	/**
	 * デフォルトコンストラクタ
	 */
	protected BaseRect(){
		this.width=0;
		this.height=0;
	}

	/**
	 * 四角形の形状を変更します
	 * @param _width 新しい幅
	 * @param _height 新しい高さ
	 */
	protected void transform(int _width, int _height){
		this.width=_width;
		this.height=_height;
	}
	
}
