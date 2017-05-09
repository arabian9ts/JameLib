package Utilities;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;

import Exceptions.SoundLoadException;

/**
 * サウンドを取得するクラス
 * @author arabian9ts
 *
 */
public class SoundLoader {
	
	/**
	 * サウンドを読み込みます
	 * @param path 読みおｋみたいサウンドのパス
	 * @return clip 読み込んだclipオブジェクト
	 * @throws SoundLoadException サウンド読み込みエラー
	 */
	public static Clip loadSound(String path) throws SoundLoadException{
		Clip clip;
		try {
			clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(AudioSystem.getAudioInputStream(SoundLoader.class
					.getClassLoader().getResource(path)));
		} catch (Exception e) {
			throw new SoundLoadException("サウンドが読み込めません"); //$NON-NLS-1$
		}
		return clip;
	}
	
}
