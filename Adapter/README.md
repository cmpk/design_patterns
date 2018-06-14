# Adapter パターンの課題

ロギング機能のある既存のアプリをカスタマイズする案件があるとします。

カスタマイズしたアプリはお客様のシステムから呼ばれますが、そのシステムにはログ出力は以下の仕様を持ったインタフェースを介して呼ぶという決まりが既にあります。
* INFOログ
	* メソッド名 : printInformation
	* 引数 : ユーザー名とメッセージ
* ERRORログ
	* メソッド名 : printError
	* 引数 : ユーザー名とメッセージ

更に、お客様はユーザー名とメッセージを以下のように出力させたいとおっしゃっています。

`user : 田中, message : ユーザーがログインしました。`

既存のアプリには、ロギング用に既に以下のクラスがあります。

```
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class MyAppLogger {
    public static final String TIME_FORMAT = "yyyy/MM/dd hh:mm:ss";
    private SimpleDateFormat sdf = null;

    public MyAppLogger() {
        sdf = new SimpleDateFormat(TIME_FORMAT);
    }

    public void info(String msg) {
        System.out.println(getTime() + " INF " + msg);
    }

    public void error(String msg) {
        System.out.println(getTime() + " ERR " + msg);
    }

    private String getTime() {
        Calendar c = Calendar.getInstance();
        return sdf.format(c.getTime());
    }
}
```

ログは上述の既存のロギングクラスを使用して、お客様の要望を叶えるにはどのような実装をすればよいでしょうか？  
使用方法を説明するための実行可能なサンプルクラス(Mainクラス)と共に作ってみてください。

なお、MyAppLoggerについては、パッケージ名を付加しても構いませんが、それ以外の変更は付け加えないでください。
