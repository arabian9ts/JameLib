package Utilities;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;

import Exceptions.NotFoundException;
import Exceptions.SoundLoadException;

/**
 * サウンドを取得するクラス
 * @author arabian9ts
 *
 */
public class SoundLoader {
	
	/**
	 * サウンドを読み込みます
	 * @param snd_path 読みおｋみたいサウンドのパス
	 * @return clip 読み込んだclipオブジェクト
	 * @throws SoundLoadException サウンド読み込みエラー
	 * @throws NotFoundException サウンドが存在しない例外
	 */
	public static Clip loadSound(String snd_path) throws SoundLoadException, NotFoundException{
		if(!new File(snd_path).exists()){
			throw new NotFoundException(snd_path);
		}
		Clip clip=null;
		try {
			clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(AudioSystem.getAudioInputStream(SoundLoader.class
					.getClassLoader().getResource(snd_path)));
		} catch (Exception e) {
			throw new SoundLoadException("サウンドが読み込めません"); //$NON-NLS-1$
		}
		return clip;
	}
	
}
