package GameEngine;

/**
 * フレームレートの固定を行います
 * @author arabian9ts
 *
 */
public class FrameRate {
	private int fps = 60;
	private long error;
	private long idealSleep;
	private long prevTime;
	private long currTime;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public FrameRate(){
		this.error = 0;
		this.idealSleep = (1000 << 16) / this.fps;
		this.currTime = System.currentTimeMillis() << 16;
	}
	
	/**
	 * 計測を開始します
	 */
	public void checkin(){
		this.prevTime = this.currTime;
	}
	
	/**
	 * 計測を終了し、スリープタイムを返却します
	 * @return スリープすべき時間
	 */
	public long checkout(){
		this.currTime = System.currentTimeMillis() << 16;
		long sleepTime = this.idealSleep - (this.currTime - this.prevTime) - this.error;
		if (sleepTime < 0x20000)
			sleepTime = 0x20000;
		this.prevTime = this.currTime;
		this.currTime = System.currentTimeMillis() << 16;
		this.error = this.currTime - this.prevTime - sleepTime;
		return sleepTime >> 16;
	}
}
