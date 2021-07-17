package test14;

// 継承する側はfinalになる
public final class OKButton extends Button {

  @Override
  public String onPush() {
    doIt();
    return "OKボタンが押ささった";
  }

  private void doIt() {
    // 何かの処理を進める
  }
}
