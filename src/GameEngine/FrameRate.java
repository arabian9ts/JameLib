package GameEngine;

/**
 * フレームレートの固定を行います
 * @author arabian9ts
 *
 */
public class FrameRate {
	private int _fps = 60;
	private long _error;
	private long _idealSleep;
	private long _prevTime;
	private long _currTime;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public FrameRate(){
		this._error = 0;
		this._idealSleep = (1000 << 16) / this._fps;
		this._currTime = System.currentTimeMillis() << 16;
	}
	
	/**
	 * 計測を開始します
	 */
	public void checkin(){
		this._prevTime = this._currTime;
	}
	
	/**
	 * 計測を終了し、スリープタイムを返却します
	 * @return スリープすべき時間
	 */
	public long checkout(){
		this._currTime = System.currentTimeMillis() << 16;
		long sleepTime = this._idealSleep - (this._currTime - this._prevTime) - this._error;
		if (sleepTime < 0x20000)
			sleepTime = 0x20000;
		this._prevTime = this._currTime;
		this._currTime = System.currentTimeMillis() << 16;
		this._error = this._currTime - this._prevTime - sleepTime;
		return sleepTime >> 16;
	}
}
