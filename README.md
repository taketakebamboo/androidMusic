# androidMusic
android studioで音楽再生のノウハウを理解します。

# mediaPlayer型、クラスについて
- 音楽生成にはMediaPlayerクラスをインポート後、lateinit でMediaPlayer型の変数を作成する

# MediaPlayerクラスメソッド
#### MediaPlayer.create
- MediaPlayerクラスの引数が２つのメソッド

# kotlinにおけるゼロ埋め
- "string".padStart(桁数(Int),埋める文字(String))
  - 例）"12".padStart(4,"0") -> 0012
- "string".padEnd(桁数(Int),埋める文字(String))
  - 例）"12".padEnd(4,"0") -> 1200