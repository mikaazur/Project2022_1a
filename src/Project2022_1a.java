////////////////////////////////////////////////////////////////////////////
//
//　　学籍番号：　2272021　
//　　氏　　名：　大野真楓
//
////////////////////////////////////////////////////////////////////////////
//
//  プログラミング基礎演習Ｂ（Java)　2022年度　プロジェクト課題用ファイル
//
//　　概要：
//　　　１．複数の画像ファイルを配列に入れて使用している。
//　　　２．複数の音声ファイルを配列に入れて使用している。
//　　　３．マウスの「瞬間動作と移動動作」に対するリスナーを組み込んである。
//　　　４．マウスの動作に応じて、音を再生する。
//　　　５．ボタンをクリックしたときに、画面を消して、paintメソッドを呼んでいる。
//
////////////////////////////////////////////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class Project2022_1a extends Frame {

    /*
    　ここは、プログラムのどこからでも使いたい 変数などを宣言しておくフィールドです。
    　変数や、オブジェクトの入れものを用意しています。
     */
    // マウスのｘ座標の記録用変数 Mx,　ｙ座標の記録用変数 Myです。
    int Mx = 0, My = 0;
    //
    // gを、標準グラフィクス描画対象として使います。
    Graphics g;
    //
    // g2を、高度なグラフィクス機能（Graphics2D）を使う場合の描画対象として使います。
    Graphics2D g2;
    //
    // Frame部品の一種である自分を、リスナーオブジェクトから呼び出せるようにするために、
    //　入れ物　myFrame　を用意します
    Frame myFrame;
    //
    // 画像ファイルから読み込む複数の画像を入れるためのオブジェクトです
    //（今回は配列として用意）。
    Image img[];

    //
    // 音声ファイルを入れるためのオブジェクトです（今回は配列として用意）。
    Clip clip[];
    //
    // ボタン部品の入れ物 bt1 を用意します。
    Button bt1;
    //
    // 描画する画像番号を指定するための変数です（ドラッグ動作ごとに０～９を循環させます）。
    int m = 0;
    static int num;
    static int sou;

    //
    //////////////////////////////////////////    
    //①　このプログラムの起動
    //////////////////////////////////////////    
    public static void main(String[] args) throws IOException {
        //②　このプログラム本体の生成
        // ③へ
        int i = 0;
        i++;
        System.out.println(i + ".番号を入力してパークを選択してください");
        System.out.println("1.ディズニーランド");
        System.out.println("2.ディズニーシー");

        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        int res1 = Integer.parseInt(str1);

        if (res1 == 1) {
            i++;
            sou=1;
            System.out.println(i + ".番号を入力してテーマランドを選択してください");

            System.out.println("1.ワールドバザール");
            System.out.println("2.アドベンチャーランド");
            System.out.println("3.ウエスタンランド");
            System.out.println("4.クリッターカントリー");
            System.out.println("5.ファンタジーランド");
            System.out.println("6.トゥーンタウン");
            System.out.println("7.トゥモローランド");

            String str2 = br.readLine();
            int res2 = Integer.parseInt(str2);

            if (res2 == 1) {
                num = 1;
                Project2022_1a pj = new Project2022_1a();
            } else if (res2 == 2) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.ウエスタンリバー鉄道");
                System.out.println("2.カリブの海賊");
                System.out.println("3.ジャングルクルーズ：ワイルドライフ・エクスペディション");
                System.out.println("4.スイスファミリー・ツリーハウス");
                System.out.println("5.魅惑のチキルーム：スティッチ・プレゼンツ“アロハ・エ・コモ・マイ！”");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 121;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 122;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 123;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 124;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 5) {
                    num = 125;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～5の数字を入力してください");
                }
            } else if (res2 == 3) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.カントリーベア・シアター");
                System.out.println("2.蒸気船マークトウェイン号");
                System.out.println("3.トムソーヤ島いかだ");
                System.out.println("4.ビッグサンダー・マウンテン");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 131;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 132;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 133;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 134;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～4の数字を入力してください");
                }
            } else if (res2 == 4) {
                System.out.println("1.スプラッシュ・マウンテン");
                System.out.println("2.ビーバーブラザーズのカヌー探険");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 141;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 142;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～2の数字を入力してください");
                }
            } else if (res2 == 5) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.アリスのティーパーティー");
                System.out.println("2.イッツ・ア・スモールワールド");
                System.out.println("3.キャッスルカルーセル");
                System.out.println("4.白雪姫と七人のこびと");
                System.out.println("5.シンデレラのフェアリーテイル・ホール");
                System.out.println("6.空飛ぶダンボ");
                System.out.println("7.美女と野獣“魔法のものがたり”");
                System.out.println("8.ピーターパン空の旅");
                System.out.println("9.ピノキオの冒険旅行");
                System.out.println("10.プーさんのハニーハント");
                System.out.println("11.ホーンテッドマンション");
                System.out.println("12.ミッキーのフィルハーマジック");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 151;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 152;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 153;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 154;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 5) {
                    num = 155;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 6) {
                    num = 156;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 7) {
                    num = 157;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 8) {
                    num = 158;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 9) {
                    num = 159;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 10) {
                    num = 1510;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 11) {
                    num = 1511;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 12) {
                    num = 1512;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～12の数字を入力してください");
                }
            } else if (res2 == 6) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.ガジェットのゴーコースター");
                System.out.println("2.グーフィーのペイント＆プレイハウス");
                System.out.println("3.チップとデールのツリーハウス");
                System.out.println("4.ドナルドのボート");
                System.out.println("5.ミニーの家");
                System.out.println("6.ロジャーラビットのカートゥーンスピン");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 161;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 162;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 163;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 164;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 5) {
                    num = 165;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 6) {
                    num = 166;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～6の数字を入力してください");
                }
            } else if (res2 == 7) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.スター・ツアーズ：ザ・アドベンチャーズ・コンティニュー");
                System.out.println("2.スティッチ・エンカウンター");
                System.out.println("3.スペース・マウンテン");
                System.out.println("4.バズ・ライトイヤーのアストロブラスター");
                System.out.println("5.ベイマックスのハッピーライド");
                System.out.println("6.モンスターズ・インク“ライド＆ゴーシーク！”");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 171;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 172;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 173;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 174;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 5) {
                    num = 175;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 6) {
                    num = 176;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～6の数字を入力してください");
                }
            } else {
                System.out.println("1～7の数字を入力してください");
            }

        } else if (res1 == 2) {
            i++;
            sou =2;
            System.out.println(i + ".番号を入力してテーマポートを選択してください");
            System.out.println("1.メディテレーニアンハーバー");
            System.out.println("2.アメリカンウォーターフロント");
            System.out.println("3.ポートディスカバリー");
            System.out.println("4.ロストリバーデルタ");
            System.out.println("5.アラビアンコースト");
            System.out.println("6.マーメイドラグーン");
            System.out.println("7.ミステリアスアイランド");

            String str2 = br.readLine();
            int res2 = Integer.parseInt(str2);

            if (res2 == 1) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.ソアリン：ファンタスティック・フライト");
                System.out.println("2.フォートレス・エクスプロレーション");
                System.out.println("3.ヴェネツィアン・ゴンドラ");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 211;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 212;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 213;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～3の数字を入力してください");
                }
            } else if (res2 == 2) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.タートル・トーク");
                System.out.println("2.タワー・オブ・テラー");
                System.out.println("3.ディズニーシー・エレクトリックレールウェイ");
                System.out.println("4.トイ・ストーリー・マニア！");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 221;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 222;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 223;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 224;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～4の数字を入力してください");
                }
            } else if (res2 == 3) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.アクアトピア");
                System.out.println("2.ニモ＆フレンズ・シーライダー");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 231;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 232;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～2の数字を入力してください");
                }
            } else if (res2 == 4) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.インディ・ジョーンズ・アドベンチャー： クリスタルスカルの魔宮");
                System.out.println("2.レイジングスピリッツ");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 241;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 242;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～2の数字を入力してください");
                }
            } else if (res2 == 5) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.キャラバンカルーセル");
                System.out.println("2.ジャスミンのフライングカーペット");
                System.out.println("3.シンドバッド・ストーリーブック・ヴォヤッジ");
                System.out.println("4.マジックランプシアター");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 251;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 252;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 253;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 254;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～4の数字を入力してください");
                }
            } else if (res2 == 6) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.アリエルのプレイグラウンド");
                System.out.println("2.ジャンピン・ジェリーフィッシュ");
                System.out.println("3.スカットルのスクーター");
                System.out.println("4.フランダーのフライングフィッシュコースター");
                System.out.println("5.ブローフィッシュ・バルーンレース");
                System.out.println("6.マーメイドラグーンシアター");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 261;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 262;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 3) {
                    num = 263;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 4) {
                    num = 264;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 5) {
                    num = 265;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 6) {
                    num = 266;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～6の数字を入力してください");
                }
            } else if (res2 == 7) {
                i++;
                System.out.println(i + ".番号を入力してアトラクションを選択してください");
                System.out.println("1.海底2万マイル");
                System.out.println("2.センター・オブ・ジ・アース");
                String str3 = br.readLine();
                int res3 = Integer.parseInt(str3);
                if (res3 == 1) {
                    num = 271;
                    Project2022_1a pj = new Project2022_1a();
                } else if (res3 == 2) {
                    num = 272;
                    Project2022_1a pj = new Project2022_1a();
                } else {
                    System.out.println("1～2の数字を入力してください");
                }
            } else {
                System.out.println("1～7の数字を入力してください");
            }
        } else {
            System.out.println("1～2の数字を入力してください");
        }
    }

    //③　このプログラムの生成内容 (この部分はコンストラクタと呼ぶ)
    public Project2022_1a() {

        //④　ウインドウタイトルの設定
        super("explanation");
        //　自分自身（this） を、どこからでも呼び出せるように myFrame に代入しておきます。
        myFrame = this;
        //
        // このアプリケーションが持つ描画面を受け取り、gという名前で呼び出せるようにします。
        g = myFrame.getGraphics();
        //
        // Graphics2Dの機能を使う場合は、g2として呼び出せるようにします。
        g2 = (Graphics2D) g;
        
        int numSounds = 2;
        clip = new Clip[numSounds];
        for (int i = 0; i < numSounds; i++) {
            clip[i] = ClipProB.createClip(new File("src/sounds/ss" + i + ".wav"));
        }
        Toolkit tk = getToolkit();
        img = new Image[120];
        for (int i = 1; i < 120; i++) {
            img[i] = tk.getImage("src/images/a" + i + ".jpg");
        }
        this.addMouseListener(
                new MouseAdapter() {

            // マウスがクリックされたときの処理
            public void mouseClicked(MouseEvent e) {
                int x = 30;
                int y = 210;
                if (num == 1) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[2], x, y, myFrame);
                } else if (num == 121) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[4], x, y, myFrame);
                } else if (num == 122) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[6], x, y, myFrame);
                } else if (num == 123) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[8], x, y, myFrame);
                } else if (num == 124) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[10], x, y, myFrame);
                } else if (num == 125) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[12], x, y, myFrame);
                } else if (num == 131) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[14], x, y, myFrame);
                } else if (num == 132) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[16], x, y, myFrame);
                } else if (num == 133) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[18], x, y, myFrame);
                } else if (num == 134) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[20], x, y, myFrame);
                } else if (num == 141) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[22], x, y, myFrame);
                } else if (num == 142) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[24], x, y, myFrame);
                } else if (num == 151) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[26], x, y, myFrame);
                } else if (num == 152) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[28], x, y, myFrame);
                } else if (num == 153) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[30], x, y, myFrame);
                } else if (num == 154) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[32], x, y, myFrame);
                } else if (num == 155) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[34], x, y, myFrame);
                } else if (num == 156) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[36], x, y, myFrame);
                } else if (num == 157) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[38], x, y, myFrame);
                } else if (num == 158) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[40], x, y, myFrame);
                } else if (num == 159) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[42], x, y, myFrame);
                } else if (num == 1510) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[44], x, y, myFrame);
                } else if (num == 1511) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[46], x, y, myFrame);
                } else if (num == 1512) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[48], x, y, myFrame);
                } else if (num == 161) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[50], x, y, myFrame);
                } else if (num == 162) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[52], x, y, myFrame);
                } else if (num == 163) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[54], x, y, myFrame);
                } else if (num == 164) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[56], x, y, myFrame);
                } else if (num == 165) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[58], x, y, myFrame);
                } else if (num == 166) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[60], x, y, myFrame);
                } else if (num == 171) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[62], x, y, myFrame);
                } else if (num == 172) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[64], x, y, myFrame);
                } else if (num == 173) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[66], x, y, myFrame);
                } else if (num == 174) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[68], x, y, myFrame);
                } else if (num == 175) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[70], x, y, myFrame);
                } else if (num == 176) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[72], x, y, myFrame);
                } else if (num == 211) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[74], x, y, myFrame);
                } else if (num == 212) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[76], x, y, myFrame);
                } else if (num == 213) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[78], x, y, myFrame);
                } else if (num == 221) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[80], x, y, myFrame);
                } else if (num == 222) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[82], x, y, myFrame);
                } else if (num == 223) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[84], x, y, myFrame);
                } else if (num == 224) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[86], x, y, myFrame);
                } else if (num == 231) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[88], x, y, myFrame);
                } else if (num == 232) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[90], x, y, myFrame);
                } else if (num == 241) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[92], x, y, myFrame);
                } else if (num == 242) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[94], x, y, myFrame);
                } else if (num == 251) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[96], x, y, myFrame);
                } else if (num == 252) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[98], x, y, myFrame);
                } else if (num == 253) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[100], x, y, myFrame);
                } else if (num == 254) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[102], x, y, myFrame);
                } else if (num == 261) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[104], x, y, myFrame);
                } else if (num == 262) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[106], x, 130, myFrame);
                } else if (num == 263) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[108], x, 130, myFrame);
                } else if (num == 264) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[110], x, y, myFrame);
                } else if (num == 265) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[112], x, y, myFrame);
                } else if (num == 266) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[114], x, y, myFrame);
                } else if (num == 271) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[116], x, y, myFrame);
                } else if (num == 272) {
                    Graphics g = myFrame.getGraphics();
                    g.drawImage(img[118], x, y, myFrame);
                }
            }
        });

        //⑤　ウィンドウを閉じるための動作の設定
        addWindowListener(new SampleWindowListner());
        //⑥　ウィンドイの表示サイズの設定
        setSize(1000, 700);
        //⑦　ウィンドウ部品（Frame)を表示させる（指示しないと表示されない）
        setVisible(true);
        //⑧　表示のための処理　⑨へ

    }

    //⑨　描画処理
    public void paint(Graphics g) {
        if(sou == 1){
            clip[0].loop(1);
        }else if(sou ==2){
            clip[1].loop(1);
        }
        if (num == 1) {
            String str1 = "ワールドバザール";
            Font f1;
            int x1, y1;
            g.setColor(Color.pink);
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ヴィクトリア時代の優美な建物が軒を連ねるストリート。";
            String str22 = "ウォルトが生まれ育った20世紀初頭の古き良き時代のアメリカが、";
            String str23 = "あなたを優しく迎えます。アンティークなゲームに、どこか懐かしいショップや";
            String str24 = "レストラン。さてどこからのぞいてみますか？";
            String str25 = "大きな屋根が設置されているのは雨の多い日本にだけなのです！";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[1], 30, 210, this);

        } else if (num == 121) {
            String str1 = "ウエスタンリバー鉄道";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 84, 56));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "蒸気機関車に乗ってアメリカ西部を巡る旅へ出発";
            String str22 = "ウエスタンリバー鉄道の車体は全部で４種類あります．";
            String str23 = "コロラド号，ミズーリ号，リオ・グランデ号，ミシシッピ号と，";
            String str24 = "アメリカの川の名前にちなんだ名前が付けられています．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[3], 30, 210, myFrame);
        } else if (num == 122) {
            String str1 = "カリブの海賊";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 84, 56));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "冒険とスリルに満ちた船旅に出発！そこにはキャプテン・ジャック・スパロウも．";
            String str22 = "カリブ海沿岸で17世紀から19世紀にかけて暴れていた海賊たちがモデル．";
            String str23 = "しばらく進むと急流を下るシーンがありますが，これはタイムスリップを表しています．";
            String str24 = "ボートはさらに進んでいきますが，時間はどんどん過去にさかのぼっているのです．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[5], 30, 210, myFrame);
        } else if (num == 123) {
            String str1 = "ジャングルクルーズ：ワイルドライフ・エクスペディション";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 84, 56));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "愉快な船長と一緒に，野生の動物たちが住む神秘的なジャングルを探索！";
            String str22 = "終盤に差し掛かると，原住民の商人，サムが表れます．";
            String str23 = "サムは初め，干し首を持った「首狩り族のサム」でした．しかし果物を売る仕事，";
            String str24 = "お守りを売る仕事と２度の転職を経て，現在は船長にお守りを売っています．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[7], 30, 210, myFrame);
        } else if (num == 124) {
            String str1 = "スイスファミリー・ツリーハウス";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 84, 56));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "無人島にたどり着いたロビンソン一家が暮らした大きな木の家を散策．";
            String str22 = "入り口すぐ左側には落とし穴があります．";
            String str23 = "この落とし穴から時々トラの鳴き声が聞こえます．";
            String str24 = "新型コロナウイルス拡大防止のため現在は休止しています";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[9], 30, 210, myFrame);
        } else if (num == 125) {
            String str1 = "魅惑のチキルーム：スティッチ・プレゼンツ“アロハ・エ・コモ・マイ！";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 84, 56));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1); 
            String str21 = "鳥たちが繰り広げる魅惑のショーに，いたずら好きのスティッチが！";
            String str22 = "ショーの中では「アロハ・エ・コモ．マイ」をはじめとした数々の";
            String str23 = "ハワイアンミュージックやハワイ語も学べちゃいます！";
            Font f2;
            int x2, y21, y22, y23;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawImage(img[11], 30, 210, myFrame);
        } else if (num == 131) {
            String str1 = "カントリーベア・シアター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(205, 90, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "個性あふれるゆかいなクマたちのにぎやかなコンサート．";
            String str22 = "クリスマスの時期には期間限定で「ジングルベル・ジャンボリー」に変化します．";
            String str23 = "このアトラクションは季節ごとに変わる「３種類の公演」がある唯一の";
            String str24 = "アトラクションでもあるのです．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[13], 30, 210, myFrame);
        } else if (num == 132) {
            String str1 = "蒸気船マークトウェイン号";
            Font f1;
            int x1, y1;
            g.setColor(new Color(205, 90, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "優雅な蒸気船でアメリカ河を１周．";
            String str22 = "おすすめの乗車場所は最上階の３階です．";
            String str23 = "心地よい風を全身で感じながら，目の前に広がる風景を存分に楽しむことができます．";
            String str24 = "アメリカ河は濁っているためレールを目視するのは難しいですが，安全面を考慮し";
            String str25 = "しっかりとレールが敷かれています．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[15], 30, 210, myFrame);
        } else if (num == 133) {
            String str1 = "トムソーヤ島いかだ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(205, 90, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "アメリカ河を渡り，楽しい冒険に満ちたトムソーヤ島へ．";
            String str22 = "トムソーヤ島に到着すると，船着き場に探検マップがあります．";
            String str23 = "ルートは決まっていないので，マップを見ながらどんな風に冒険するかは自由！";
            String str24 = "マップの裏側や島内の看板を注意深く見れば，もっともっと探検を";
            String str25 = "楽しむことができます．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[17], 30, 210, myFrame);
        } else if (num == 134) {
            String str1 = "ビッグサンダーマウンテン";
            Font f1;
            int x1, y1;
            g.setColor(new Color(205, 90, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "鉱山列車が，荒野を急旋回，急降下しながら大暴走！";
            String str22 = "ビッグサンダー・マウンテンのコース内には動物が５種類います．";
            String str23 = "アメリカ西部に生息する動物で，オポッサム，コヨーテ，";
            String str24 = "ビッグホーンシープ，コウモリ，ガラガラヘビが確認";
            String str25 = "できます．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[19], 30, 210, myFrame);
        } else if (num == 141) {
            String str1 = "スプラッシュ・マウンテン";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 40, 90));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "丸太のボートでスリル満点の旅へ！";
            String str22 = "スプラッシュ・マウンテンは，東京ディズニーランドで最も速いアトラクションです．";
            String str23 = "45度の急斜面を急降下するのですが，高さは約３０m！";
            String str24 = "スプラッシュ・マウンテンの瞬間最高速度は，約６２kmにもなります．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[21], 30, 210, myFrame);
        } else if (num == 142) {
            String str1 = "ビーバーブラザーズのカヌー探検";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 40, 90));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "みんなでカヌーをこいで出発！";
            String str22 = "毎年７月３日は「七三の日」として，キャストの髪型が七三分けになります．";
            String str23 = "七三の日の発祥は，このカヌーキャスト．次第にジャングルクルーズや";
            String str24 = "ベネチアンゴンドラなど，他の船系アトラクションのキャストにも広まりました．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[23], 30, 210, myFrame);
        } else if (num == 151) {
            String str1 = "アリスのティーパーティ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "くるくる回るティーカップ．ふしぎの国のお茶会へようこそ！";
            String str22 = "ティーパーティの入り口付近には，お花で作られたカラフルな";
            String str23 = "キノコがたくさんあります．実はゲストたちは並んでいる間に";
            String str24 = "このキノコを食べて子らだが小さくなってしまっているんだそう！";
            String str25 = "ティーカップに乗れるのはゲストが小さくなっているからなのです．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[25], 30, 210, myFrame);
        } else if (num == 152) {
            String str1 = "イッツ・ア・スモールワールド";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "世界中の子供たちの歌声に包まれる，世界で一番幸せな船旅．";
            String str22 = "アトラクション中は，小さな世界のBGMを聞きながら進んでいくのですが，";
            String str23 = "実はディズニーキャラクターの近くを通る時に描く映画のBGMが聞こえる";
            String str24 = "ようになっているのです．しかし，各キャラクターの近くで流れている";
            String str25 = "BGMは音量が小さいので，小さな世界の音楽に隠れてしまっています．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[27], 30, 210, myFrame);
        } else if (num == 153) {
            String str1 = "キャッスルカルーセル";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "バンドオルガンの美しい音色に合わせて走る白馬たち．";
            String str22 = "キャッスルカルーセルは，シンデレラ城と同じく「シンデレラ」をテーマにしており，";
            String str23 = "カルーセルのあちらこちらには，映画のワンシーンが描かれた絵画がストーリー順に";
            String str24 = "１８枚飾られています．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[29], 30, 210, myFrame);
        } else if (num == 154) {
            String str1 = "白雪姫と七人のこびと";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "トロッコに乗って冒険に出発．暗い森の中には恐ろしい魔女が．";
            String str22 = "当初ディズニーランドではお化け屋敷として作られたアトラクション";
            String str23 = "だったのです．アトラクションのコンセプトは「ゲスト自身が白雪姫に";
            String str24 = "なった気分で楽しめるアトラクション」として作られたので，白雪姫が";
            String str25 = "登場するのは，1か所のみなのです．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[31], 30, 210, myFrame);
        } else if (num == 155) {
            String str1 = "シンデレラのフェアリーテイル・ホール";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "お城の中は，憧れのシンデレラの世界！";
            String str22 = "玉座やガラスの靴が見られます．";
            String str23 = "一番奥の，シンデレラと王子様がくるくると踊るジオラマでは，";
            String str24 = "数秒に一度だけ魔法の杖を持ったフェアリーゴッドマザーが";
            String str25 = "煌めきとともに現れます．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[33], 30, 210, myFrame);
        } else if (num == 156) {
            String str1 = "空飛ぶダンボ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ダンボの背中に乗って大空へ．";
            String str22 = "このアトラクションで流れているBGMは，全12曲を24分でリピートしています．";
            String str23 = "ダンボの親友ティモシーマウスは，中心でダンボを指揮しています．";
            Font f2;
            int x2, y21, y22, y23;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawImage(img[35], 30, 210, myFrame);
        } else if (num == 157) {
            String str1 = "美女と野獣“魔法のものがたり”'";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "踊るように動くカップに乗って，真実の愛を描いたものがたりの世界へ．";
            String str22 = "アトラクションを乗り終え外に出てお城を振り返ると，赤いバラと";
            String str23 = "お城を同時に見ることができます．";
            String str24 = "また，アトラクションの出口はお城の色がクリーム色になっており，";
            String str25 = "魔法が解けたことを表現しています．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[37], 30, 210, myFrame);
        } else if (num == 158) {
            String str1 = "ピーターパン空の旅";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "空飛ぶ海賊船に乗って，ネバーランドへ．";
            String str22 = "Qラインをよく見ると，乗り場に近づくに連れて足元のレンガがどんどん小さい";
            String str23 = "サイズにっています．そして，乗り場付近になるとQラインが坂になり，付近には";
            String str24 = "空と雲が描かれています．空を飛んで地上の風景がどんどん小さくなり,";
            String str25 = "雲に近づいていく様子がQラインでも表現されています．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[39], 30, 210, myFrame);
        } else if (num == 159) {
            String str1 = "ピノキオの冒険旅行";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "トロッコに乗って，冒険の旅へ出発！";
            String str22 = "ピノキオの冒険旅行はアトラクションに乗る前から始まっており，";
            String str23 = "ピノキオがファウルフェローとギデオンに誘拐されるまでの話は";
            String str24 = "外の置き物によって語られているため，アトラクションは";
            String str25 = "人形劇のシーンから始まります．";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[41], 30, 210, myFrame);
        } else if (num == 1510) {
            String str1 = "プーさんのハニーハント";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ハニーポットに乗って,プーさんの大好きなはちみつを探しにいこう！";
            String str22 = "プーさんのハニーハントでの楽しみの一つ『はちみつの大砲』.";
            String str23 = "この大砲が受けられるのは1番目と3番目のハニーポッドのみです．";
            String str24 = "このアトラクションでは待ち時間が14分(イーヨー)や82分(ハニー)など";
            String str25 = "プーさんにちなんだ数になることがあります！";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[43], 30, 210, myFrame);
        } else if (num == 1511) {
            String str1 = "ホーンテッドマンション";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "999の幽霊たちが住んでいる館。";
            String str22 = "ホーンテッドマンションには、サンルーム(温室)があります。";
            String str23 = "サンルームは昼間は特に何もないのですが、夜になると人魂が浮かんでいることが確認できます。";
            String str24 = "一瞬なので、注意していないと見逃してしまうかもしれませんが、しばらく観察してみてください。";
            String str25 = "アトラクションの出口付近のほうが、見やすいのでオススメです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[45], 30, 210, myFrame);
        } else if (num == 1512) {
            String str1 = "ミッキーのフィルハーマジック";
            Font f1;
            int x1, y1;
            g.setColor(new Color(200, 0, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ミッキーが指揮するコンサートが、ドナルドのせいで予想外の展開に！";
            String str22 = "2022年9月，このアトラクションは初のリニューアルを遂げました．";
            String str23 = "ディズニー＆ピクサー映画『リメンバー・ミー』のシーンの追加と、";
            String str24 = "投影機器の一新により，映像が鮮明になりました．";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[47], 30, 210, myFrame);
        } else if (num == 161) {
            String str1 = "ガジェットのゴーコースター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 255, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "トゥーンタウンの天才発明家、ガジェットがつくったドングリのコースター。";
            String str22 = "ゴーコースターはトゥーンタウンの仲間たちが持ち寄った不用品を";
            String str23 = "リサイクルして作られました。";
            String str24 = "アトラクション内では様々なリサイクル品を見ることができます。";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[49], 30, 210, myFrame);
        } else if (num == 162) {
            String str1 = "グーフィーのペイント＆プレイハウス";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 255, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ペンキ噴射装置を使って、グーフィーの部屋を楽しく模様替え！";
            String str22 = "グーフィーのペイント&プレイハウスは、ゲストがペンキを噴射して";
            String str23 = "グーフィーの部屋を模様替えしていくのですが、模様替えの完成パターンは、";
            String str24 = "何種類かあるんです！模様替えのパターンが「王様の部屋」だった場合、";
            String str25 = "人気ゲーム「キングダムハーツ」に登場するグーフィーの盾が飾られています！";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[51], 30, 210, myFrame);
        } else if (num == 163) {
            String str1 = "チップとデールのツリーハウス";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 255, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "チップとデールのお家が見られるよ！";
            String str22 = "入り口にある看板には、チップとデールが木のすべり台で";
            String str23 = "遊んでいるオブジェがあります。";
            String str24 = "実はこのオブジェのチップとデール、クリスマスの時期にはサンタの帽子をかぶっているんです！";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[53], 30, 210, myFrame);
        } else if (num == 164) {
            String str1 = "ドナルドのボート";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 255, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "汽笛やベルを鳴らして遊ぼう！";
            String str22 = "ドナルドの帽子とお尻をイメージしたようなドナルドのボート。";
            String str23 = "実は、季節によってデコレーションが変わるんです。6月9日の、";
            String str24 = "ドナルドのバースデー（スクリーンデビュー日）にはお誕生日のデコレーション、クリスマスシーズンには、";
            String str25 = "「Merry Christmas」の文字とともにクリスマス仕様のデコレーションを見ることができます。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[55], 30, 210, myFrame);
        } else if (num == 165) {
            String str1 = "ミニーの家";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 255, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "おしゃれで料理が大好きなミニーのお部屋が見られるよ！";
            String str22 = "小さなテーブルにはミッキーとの写真が飾られています。";
            String str23 = "実はこの写真，ミッキーの家にもあるのです！";
            String str24 = "ミニーの家の写真は「丸いフォトフレーム」で、ミッキーの家は";
            String str25 = "「四角いフォトフレーㇺ」なので、一見すると同じには見えないのです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[57], 30, 210, myFrame);
        } else if (num == 166) {
            String str1 = "ロジャーラビットのカートゥーンスピン";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 255, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "スピンするキャブに乗って、ロジャーラビットたちを助けに行こう！";
            String str22 = "ロジャーラビットのカートゥーンスピン入り口のドアには、";
            String str23 = "ロジャーの形をした大きな穴が空いています。 ";
            String str24 = "ロジャーはイエローキャブを暴走させてしまっているようです。";
            String str25 = "入り口の地面にはブレーキ痕も残されています。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[59], 30, 210, myFrame);
        } else if (num == 171) {
            String str1 = "スター・ツアーズ：ザ・アドベンチャーズ・コンティニュー";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 115, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "スタースピーダー1000に乗って、スリリングで予測不能な冒険の旅へ。";
            String str22 = "スター・ツアーズには現在384パターンのストーリー分岐が存在します！";
            String str23 = "乗るたびに訪れる惑星や出会えるキャラクターが変化するんです！";
            String str24 = "また、待ち列には、ヒッチハイクをするかのように、親指を横に突き出している3人組";
            String str25 = "ヒッチハイカー・ドロイドがいます。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[61], 30, 210, myFrame);
        } else if (num == 172) {
            String str1 = "スティッチ・エンカウンター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 115, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "いたずら好きのスティッチと、ユーモアたっぷりのおしゃべりを楽しもう！";
            String str22 = "ストーリーには、次の3つのパターンがあり、毎回違うストーリーを楽しめます。";
            String str23 = "①スティッチが家で歌っているとうるさいといわれたという発言から始まるストーリー ";
            String str24 = "②スティッチが怒っているリロと仲直りするストーリー ";
            String str25 = "③ガンドゥからスティッチを助けるストーリー";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[63], 30, 210, myFrame);
        } else if (num == 173) {
            String str1 = "スペース・マウンテン";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 115, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "銀河系や流星群の間をハイスピードで駆け抜けるスリリングな宇宙旅行。";
            String str22 = "このアトラクションは、3大マウンテンの中で唯一";
            String str23 = "1983年の開園当初からあるアトラクションです。";
            String str24 = "日本以外のスペース・マウンテンでは";
            String str25 = "ライドフォトが実施されています。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[65], 30, 210, myFrame);
        } else if (num == 174) {
            String str1 = "バズ・ライトイヤーのアストロブラスター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 115, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "スペースクルーザーに乗って、";
            String str22 = "光線銃で悪の帝王ザーグたちをやっつけろ！";
            String str23 = "このアトラクションでは、";
            String str24 = "待ち時間が30分前後になると";
            String str25 = "34分(ミッション)待ちになります。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[67], 30, 210, myFrame);
        } else if (num == 175) {
            String str1 = "ベイマックスのハッピーライド";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 115, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ケアロボットが引っ張るビークルに乗って、予測不能な動きを楽しもう！";
            String str22 = "イドを引っ張っているのは、ヒロが開発した";
            String str23 = "“ベイマックスそっくりのケア・ロボット”です。";
            String str24 = "アトラクションの入り口に立っているのが、";
            String str25 = "ヒロの兄「タダシ」が作った正真正銘のベイマックスです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[69], 30, 210, myFrame);
        } else if (num == 176) {
            String str1 = "モンスターズ・インク“ライド＆ゴーシーク！”";
            Font f1;
            int x1, y1;
            g.setColor(new Color(0, 115, 255));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "トラムに乗って、フラッシュライトでゆかいなモンスターたちを見つけよう！";
            String str22 = "司レストラン「ハリーハウゼン」の壁には、ニモのお父さんのマーリンが隠れています。";
            String str23 = "また、最後のシーン、ロズの後ろに注目してみてください。 ";
            String str24 = "湿ったものを引きずったような跡があります。これは、ロズの足跡。";
            String str25 = "「後ろの扉から出てきて、ここまで来た」ということをリアルに表す細かな演出です。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[71], 30, 210, myFrame);
        } else if (num == 211) {
            String str1 = "ソアリン：ファンタスティック・フライト";
            Font f1;
            int x1, y1;
            g.setColor(new Color(155, 80, 54));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ライドに乗って、世界中の名所や大自然をめぐる雄大な空の旅へ！";
            String str22 = "スタンバイの列を進むと階段を下りて屋内に入る前に中庭のような";
            String str23 = "場所を通ります。そこの壁には空を飛ぶことに尽力した";
            String str24 = "歴史上の偉人の壁画が並んでいます。";
            String str25 = "その中には誰もが知っているレオナルド・ダ・ヴィンチの絵も！";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[73], 30, 210, myFrame);
        } else if (num == 212) {
            String str1 = "フォートレス・エクスプロレーション";
            Font f1;
            int x1, y1;
            g.setColor(new Color(155, 80, 54));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "迷路のような要塞やガリオン船を探索。";
            String str22 = "この場所は探検家や科学者などが集まる学会";
            String str23 = "「S.E.A.(Society of Explorers and Adventures)」の活動拠点でした。";
            String str24 = "要塞の随所で彼らの功績や研究内容を見ることができるので、";
            String str25 = "冒険や探検がお好きな方にはたまらない施設となっています。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[75], 30, 210, myFrame);
        } else if (num == 213) {
            String str1 = "ヴェネツィアン・ゴンドラ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(155, 80, 54));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ゴンドラに乗って魅力的な運河の風景とロマンティックな雰囲気を。";
            String str22 = "3つ目の橋「ポンテ・デイ・ベンヴェヌーティー」。";
            String str23 = "この橋の下をくぐって行く時にお願いごとを";
            String str24 = "してみてください！";
            String str25 = "実際に願いが叶った！とう人もいる不思議な橋なんですよ。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[77], 30, 210, myFrame);
        } else if (num == 221) {
            String str1 = "タートル・トーク";
            Font f1;
            int x1, y1;
            g.setColor(new Color(230, 0, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "S.S.コロンビア号の海底展望室でウミガメのクラッシュと楽しくお話しよう！";
            String str22 = "クラッシュは海の世界しか知らないので、手の事をヒレと言ったり、";
            String str23 = "洋服の事をサンゴと言ったりします。";
            String str24 = "ドリー達に関する質問や好きな魚などを聞くと、ドリー達が";
            String str25 = "出てくる可能性があり、通常とは異なる演出を見ることができます！";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[79], 30, 210, myFrame);
        } else if (num == 222) {
            String str1 = "タワー・オブ・テラー";
            Font f1;
            int x1, y1;
            g.setColor(new Color(230, 0, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "エレベーターに乗って最上階へ。恐怖の体験が待ち受けているとも知らず…。";
            String str22 = "隣接するお土産ショップ「タワー・オブ・テラー・メモラビリア」は、ホテルが存命だった頃は";
            String str23 = "プールとして使われていた場所なのです。その後ニューヨーク市保存協会が";
            String str24 = "タワー・オブ・テラーのツアーを開催するにあたり、ツアー参加者が";
            String str25 = "お土産を買えるようにとプールを改装してお土産ショップを開きました。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[81], 30, 210, myFrame);
        } else if (num == 223) {
            String str1 = "ディズニーシー・エレクトリックレールウェイ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(230, 0, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "電動式トロリーに乗って、ポートディスカバリー、アメリカンウォーターフロントへ。";
            String str22 = "駅長室の近くには、エレクトリックレールウェイの行き先であるポートディスカバリーを";
            String str23 = "描いた大きな絵があります。";
            String str24 = "ポートディスカバリーはアメリカンウォーターフロントの人々が願った理想の未来、";
            String str25 = "つまりレトロフューチャーなのです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[83], 30, 210, myFrame);
        } else if (num == 224) {
            String str1 = "トイ・ストーリー・マニア！";
            Font f1;
            int x1, y1;
            g.setColor(new Color(230, 0, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "トラムに乗って、ウッディやバズたちと一緒にシューティングゲームを楽しもう！";
            String str22 = "室内に入ると、引き出しやベッドがとても大きいサイズで広がっていることがわかります。";
            String str23 = "つまり私たちが小さくなったんです。「アトラクションを通じておもちゃの一員になれる」";
            String str24 = "というのがこのアトラクションのメインなのです。ウッディを初めとするトイストーリーキャラクターの";
            String str25 = "おもちゃを持っているアンディ少年の部屋の中で繰り広げられるという設定です。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[85], 30, 210, myFrame);
        } else if (num == 231) {
            String str1 = "アクアトピア";
            Font f1;
            int x1, y1;
            g.setColor(new Color(230, 215, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "とつぜん方向を変えたり、くるくる回ったりするウォータービークル。";
            String str22 = "アクアトピアは大きく分けて2つのコースがあります。";
            String str23 = "「海側コース」と「陸側コース」です。";
            String str24 = "海側コースの見どころは洞窟です。コース中に洞窟があるのですが、実は中をくぐることができるのです。";
            String str25 = "陸側の見どころは大きな滝。滝の目の前までぐっと近づくことができます。目の前に迫る滝は迫力満点です。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[87], 30, 210, myFrame);
        } else if (num == 232) {
            String str1 = "ニモ＆フレンズ・シーライダー";
            Font f1;
            int x1, y1;
            g.setColor(new Color(230, 215, 0));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "潜水艇に乗り込んで、海の世界を冒険。ディズニーパークの中では、";
            String str22 = "時々「記号」や「数字」の言葉遊びが隠れている事がよくあります。同アトラクションにも";
            String str23 = "そんな小さなこだわりがあります。それはアトラクション建物の前に停泊している魚型の小型潜水艇の";
            String str24 = "尾ヒレのあたりに「120517」と言う数字が書かれています。これを逆に読んで「日付」に直すと、";
            String str25 = "「2017年5月12日」となります。これはこのアトラクションがグランドオープンとなった日付なのです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[89], 30, 210, myFrame);
        } else if (num == 241) {
            String str1 = "インディ・ジョーンズ・アドベンチャー： クリスタルスカルの魔宮";
            Font f1;
            int x1, y1;
            g.setColor(new Color(75, 140, 50));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "襲いかかる罠や守護神クリスタルスカルの呪いを、猛スピードですり抜ける！";
            String str22 = "クリスタルスカルが正面に見え怒りを露わにした直後、";
            String str23 = "急カーブする途中で右側の壁にキラキラと映る部屋の入口が";
            String str24 = "見えます。実はその先にあるのが「若さの泉」。";
            String str25 = "壁に映っているのは泉の水面が反射したものです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[91], 30, 210, myFrame);
        } else if (num == 242) {
            String str1 = "レイジングスピリッツ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(75, 140, 50));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "古代神の石像の発掘現場をかけ抜ける、360度ループコースター。";
            String str22 = "遺跡となったこの場所に遺跡発掘チームがやってきました。彼らは残された文書や資料を元に";
            String str23 = "発掘・復旧作業を始めますが，掟を知らなかった彼らは火の神と水の神を向かい合わせに";
            String str24 = "立たせてしまったのです。神々の怒りは";
            String str25 = "ホッパーカー（トロッコ）のレールにまで及び、レールが360度捻じ曲げられてしまったのです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[93], 30, 210, myFrame);
        } else if (num == 251) {
            String str1 = "キャラバンカルーセル";
            Font f1;
            int x1, y1;
            g.setColor(new Color(95, 60, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "宮殿の中庭にあるジーニーやラクダなどの2階建ての回転木馬。";
            String str22 = "アラビアの世界らしく、ラクダやランプの精ジーニーまで";
            String str23 = "設置されている少し風変りなメリーゴーランド。";
            String str24 = "ディズニーシーでしか体験できない";
            String str25 = "メリーゴーランドです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[95], 30, 210, myFrame);
        } else if (num == 252) {
            String str1 = "ジャスミンのフライングカーペット";
            Font f1;
            int x1, y1;
            g.setColor(new Color(95, 60, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "空飛ぶじゅうたんに乗って、ジャスミンの庭園の空中散歩を楽しもう。";
            String str22 = "「ジャスミン」なので、アトラクション内外には、";
            String str23 = "実際にジャスミンが植えられています。";
            String str24 = "カリフォルニアとフロリダのディズニーパークにも同タイプの";
            String str25 = "アトラクションが存在しますが、「ジャスミン」を冠するのは東京だけです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[97], 30, 210, myFrame);
        } else if (num == 253) {
            String str1 = "シンドバッド・ストーリーブック・ヴォヤッジ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(95, 60, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "シンドバッド、チャンドゥと一緒に冒険の航海へ。";
            String str22 = "冒険の旅を通じてさまざまな宝物をもらうシンドバッド。巨人を救ったりサルとセッションしたりする";
            String str23 = "場面において、宝物は物語のキーアイテムとしても役立っています。そんな宝物ですが、" ;
            String str24 = "物語がすすむにつれ、シンドバッドの乗るボートに載る量がどんどん増えていくんです！";
            String str25 = "財宝、魔法の羽根、バナナなど、贈り物のサイズやジャンルは様々。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[99], 30, 210, myFrame);
        } else if (num == 254) {
            String str1 = "マジックランプシアター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(95, 60, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "世界で一番偉大？なマジシャンと陽気なジーニーのマジックショー。";
            String str22 = "ゲストが建物に入ると、コブラのベキートが物語の";
            String str23 = "あらすじを説明してくれます。その映像の中で";
            String str24 = "一瞬だけ、ジャスミンとサルタン王が";
            String str25 = "登場する場面があるのです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[101], 30, 210, myFrame);
        } else if (num == 261) {
            String str1 = "アリエルのプレイグラウンド";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 145, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "アリエルの遊び場で宝箱をのぞいたり、洞窟を探険したり。";
            String str22 = "マーメイドラグーンには、自由散策型のアトラクション ";
            String str23 = "「アリエルのプレイグラウンド」があります。";
            String str24 = "ここは9つのエリアに分かれており、映画に登場した場所が再現されています。";
            String str25 = "お子さま向けのイメージがありますが、大人も映画の世界観に浸れるおすすめスポットです！";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[103], 30, 210, myFrame);
        } else if (num == 262) {
            String str1 = "ジャンピン・ジェリーフィッシュ";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 145, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "貝がらに乗ってクラゲと一緒にアップ・ダウン！";
            Font f2;
            int x2, y21;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            g.drawString(str21, x2, y21);
            g.drawImage(img[105], 30, 130, myFrame);
        } else if (num == 263) {
            String str1 = "スカットルのスクーター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 145, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "ヤドカリの背中に乗ってカモメのスカットルの周りをくるくる行進。";
            Font f2;
            int x2, y21;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            g.drawString(str21, x2, y21);
            g.drawImage(img[107], 30, 130, myFrame);
        } else if (num == 264) {
            String str1 = "フランダーのフライングフィッシュコースター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 145, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "潮だまりの上をトビウオに乗ってかけ抜けるかわいいコースター。";
            String str22 = "このアトラクションはフランダーが海底から";
            String str23 = "上がってくる人間たちのために、";
            String str24 = "何かスリリングなものをと考えて作りました。";
            Font f2;
            int x2, y21, y22, y23, y24;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawImage(img[109], 30, 210, myFrame);
        } else if (num == 265) {
            String str1 = "ブローフィッシュ・バルーンレース";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 145, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "貝がらに乗って、フグたちが輪になって泳ぐレースに参加。";
            String str22 = "人魚姫アリエルの父であり海の王、キング・トリトンは、人間のゲストに";
            String str23 = "特別な体験をプレゼントする為、マーメイドラグーンを造ることを決心しました。";
            String str24 = "トリトンの考えに、海の仲間達は大賛成。";
            String str25 = "ブローフィッシュ(フグ)達は訪れる人間のゲストを巻貝に乗せ、海中を散歩することにしました。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[111], 30, 210, myFrame);
        } else if (num == 266) {
            String str1 = "マーメイドラグーンシアター";
            Font f1;
            int x1, y1;
            g.setColor(new Color(255, 145, 165));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "まるで海底にいるかのような空間で、ディズニー映画『リトル・マーメイド』の";
            String str22 = "アリエルと仲間たちが贈る新しいミュージカルショーを楽しもう！";
            String str23 = "このアトラクションがあるマーメイドラグーンのうち、";
            String str24 = "「海底部分（アンダー・ザ・シー）」は、海の中の世界。実は、ゆらゆらと動く水のせいで、";
            String str25 = "いろいろなものが屈折して見え、まっすぐなものが存在していないのです。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[113], 30, 210, myFrame);
        } else if (num == 271) {
            String str1 = "海底2万マイル";
            Font f1;
            int x1, y1;
            g.setColor(new Color(50, 170, 170));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "小型潜水艇に乗って神秘的な海底探索の任務を体験。";
            String str22 = "海底2万マイルが存在するミステリアスアイランドのキャストは、ネモ船長の部下という設定。";
            String str23 = "研究員であり乗組員でもある彼らは、クルーと呼ばれます。";
            String str24 = "「モビリス」という言葉に「モビリ」と返答するのが、クルー同士のあいさつです。";
            String str25 = "クルーに「モビリス」とあいさつされたら、ぜひ「モビリ」と返してくださいね！";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[115], 30, 210, myFrame);
        } else if (num == 272) {
            String str1 = "センター・オブ・ジ・アース";
            Font f1;
            int x1, y1;
            g.setColor(new Color(50, 170, 170));
            f1 = new Font("TimesRoman", Font.ITALIC, (30));
            g.setFont(f1);
            x1 = 20;
            y1 = 80;
            g.drawString(str1, x1, y1);
            String str21 = "地底走行車に乗って探険中、予期せぬ危険に遭遇して突如猛スピードに…！";
            String str22 = "このアトラクションは、東京ディズニーシーのオープン当初からある絶叫系アトラクションです。";
            String str23 = "クライマックスで急上昇するときの最高速度は75km/hで、東京ディズニーリゾート最速です。";
            String str24 = "有名な科学者：ネモ船長が発見した地底世界を巡るツアーに参加するストーリーで、";
            String str25 = "フランスの小説家ジュール・ベルヌ作｢地底旅行」をモチーフに作られました。";
            Font f2;
            int x2, y21, y22, y23, y24, y25;
            g.setColor(Color.BLACK);
            f2 = new Font("TimesRoman", Font.PLAIN, (20));
            g.setFont(f2);
            x2 = 30;
            y21 = 110;
            y22 = 130;
            y23 = 150;
            y24 = 170;
            y25 = 190;
            g.drawString(str21, x2, y21);
            g.drawString(str22, x2, y22);
            g.drawString(str23, x2, y23);
            g.drawString(str24, x2, y24);
            g.drawString(str25, x2, y25);
            g.drawImage(img[117], 30, 210, myFrame);
        }
    }

    //　ウィンドウを閉じる動作で行う処理（変更不要）
    class SampleWindowListner extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {

            System.exit(0);
        }
    }
}
