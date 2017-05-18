package Base;

import java.awt.Image;
import java.awt.Point;

import Exceptions.ImageLoadException;
import Exceptions.NotFoundException;
import Utilities.ImageLoader;

/**
 * 円形のノード
 * @author arabian9ts
 *
 */
public class BaseCircle extends BaseNode {
	private int radius;
	private Image icon;
	
	/**
	 * デフォルトコンストラiクタ
	 */
	protected BaseCircle(){
		this.radius=0;
		
		try{
			this.icon=ImageLoader.loadImage("images/a.png");  //$NON-NLS-1$
		}
		catch(NotFoundException en){
			en.printStackTrace();
		}
		catch(ImageLoadException ei){
			ei.printStackTrace();
		}
	}
	
	/**
	 * 円の永承を変形します
	 * @param _radius 新しい半径
	 */
	protected void transform(int _radius){
		this.radius=_radius;
	}

	/**
	 * 第4象限の座標を返します
	 * @return　第4象限の座標
	 * @see Base.BaseNode#location4()
	 */
	public Point location4() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
