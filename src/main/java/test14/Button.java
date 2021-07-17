package test14;

// OKButton, NGButton のみサブクラスとなれる
public sealed class Button permits OKButton, NGButton {

  public String onPush() {
    return "ボタンが押ささった";
  }
}
