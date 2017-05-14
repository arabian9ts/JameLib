# JameLib
このプロジェクトはJava言語を用いたゲーム制作を用意にするためのフレームワークとして機能します。環境はeclipseを想定していますが、その他のエディタを用いる場合はパスを各自で設定し直してください。機能がある程度整備されればライブラリ化を図りますが、暫くは教育用のフレームワークという立ち位置で開発を進めます。

## Usage
![h image](images/md/h.png)  
<br>図のScreens階層に、SampleScreenに倣って自分の作成したいスクリーンクラスを作成します。その際、Screenインターフェースを実装(implements)するようにしてください。  

### スクリーンの作成の例
    public class SampleScreen implements Screen {
        int x;
        int y;

        @Override
        public void initialize() {
            /* ここに初期化したい処理を書きます */
        }

        @Override
        public void update() {
            /* ここに更新したい処理を書きます */
        }

        @Override
        public void render(Graphics g) {
            /* ここに描画したいものを書きます */
            g.setColor(Color.blue);
            g.fillOval(this.x, this.y, 100, 100);
        }

        @Override
        public void terminate() {
            /* ここに終了処理を書きます */
        }

    }

これは簡易的なスクリーンであり、拡張することができます。各自で実装した型、変数を用いてスクリーンを装飾してください。

### スクリーンの登録
    public class MainContainer extends JPanel implements Runnable {

        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        public void screenRegister(){
            this.renderer.addScreen("sample", new SampleScreen());
            this.renderer.addScreen("sample2", new SampleScreen2());
            ...
            this.renderer.swapScreen("sample");
  	   }

        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    }

上記の~で区切られたエリアは、省略したコードが存在することを表します。スクリーンの登録に必要な操作は、MainContainerクラスのscreenRegister()メソッドにaddScreen()を書き足すだけです。実行時には、最後に追加されたスクリーンが初期値として扱われるので、screenRegister()の最後で画面切り替えメソッドのswapScreenで最初のスクリーンに入れ替えることを忘れないでください。


### エフェクトの作成
![h2 image](images/md/h2.png)  
<br>図のEffects階層に、SampleEffectに倣って自分の作成したいエフェクトクラスを作成します。その際、Effectインターフェースを実装(implements)するようにしてください。  

### エフェクトの作成の例
    public class SampleEffect implements Effect {
    	int R = 10;
    	int radius = this.R;
    	Image image;

    	public SampleEffect() {
    		initialize();
    	}

    	@Override
    	public void initialize(){
    		try {
    			this.image = (ImageLoader.loadImage("images/effect/sample_effect.jpg"));
    		}catch(NotFoundException en){
    			en.printStackTrace();
    		}
    		catch (ImageLoadException ei) {
    			ei.printStackTrace();
    		}
    	}

    	@Override
    	public void update(){
    		this.radius+=1;
    	}

    	@Override
    	public void render(Graphics g) {
    		g.drawImage(this.image, 200 - this.radius, 300
    				- this.radius, 2 * this.radius, 2 * this.radius, null);
    	}

    }

これは簡易的なエフェクトであり、より高度なエフェクトに拡張することが可能です。作成したエフェクトを使用するには、エフェクトを使用したいスクリーン内で以下のように記述します。

### エフェクトの登録
    public class SampleScreen implements Screen {

        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    	EffectDelegation delegator;

        @Override
        public void initialize() {
      	   this.delegator.setEffect(new SampleEffect());
        }

        @Override
        public void update() {
            this.delegator.setEffect(new SampleEffect());
        }

        @Override
        public void render(Graphics g) {
            this.delegator.effect(g);
        }

        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    }

作成したエフェクトを使用するには、使用したいスクリーンクラスの任意の箇所、条件のもとでsetEffect()を呼び出し、エフェクトをセットします。エフェクトをsetEffect()でセットする際には、注意すべきことがあります。  

+ 一度エフェクトを作成してから、意図したエフェクトの更新にかかる時間を設けずに次のエフェクトをセットすると、十分に更新されていないエフェクトが描画され続けます。(場合によってはエフェクトの存在に気づきません。)
+ setEffect()を呼ぶと、必ずそのインスタンスのinitialize()メソッドが実行されます。(更新したくないパラメータもすべて初期値にリセットされます。)

1つ目の注意事項に関しては、特定の条件を満たした場合にのみエフェクトをセットするようにするか、カウンターを用意すれば解決できるでしょう。<br>
2つ目は、EffectDelegationにEffectのリスト構造を持たせ、その要素を切り替えることで対応ができるでしょう。

License
----------
Copyright &copy; 2017 arabian9ts
Distributed under the [MIT License][mit].

[MIT]: http://www.opensource.org/licenses/mit-license.php
