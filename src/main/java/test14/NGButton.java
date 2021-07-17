package test14;

public final class NGButton extends Button {

  @Override
  public String onPush() {
    doCancel();
    return "NGボタンが押ささった";
  }

  private void doCancel() {
    // 何かの（例えば、キャンセル）処理を進める
  }
}
