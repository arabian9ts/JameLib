package Base;

import java.awt.Image;

import Exceptions.ImageLoadException;
import Exceptions.NotFoundException;
import Utilities.ImageLoader;

/**
 * 四角形のノード
 * @author arabian9ts
 *
 */
public class BaseRect extends BaseNode {
	private int width;
	private int height;
	private Image icon;
	
	/**
	 * デフォルトコンストラクタ
	 */
	protected BaseRect(){
		this.width=0;
		this.height=0;
		
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
	 * 四角形の形状を変更します
	 * @param _width 新しい幅
	 * @param _height 新しい高さ
	 */
	protected void transform(int _width, int _height){
		this.width=_width;
		this.height=_height;
	}
	
}
