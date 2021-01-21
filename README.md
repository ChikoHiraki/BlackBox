# Black Box

ヒントを手がかりに暗闇に隠された３つのボールの位置を当てるゲームです。


## ルール

５×５の □ で表された盤面には３つのボールが隠されています。
盤面の周りに配置された記号（R,H,数字）は、その位置から発射された光線がどうなったかをを表しています。
この記号をヒントにボールの位置を推測してください。
一度間違えると解答を表示することができます。
ボールの位置を選択する際には、破線の外側の数字とアルファベットを指定して入力してください。


## 光線の進み方

1. 原則として光線は照射されたマスから直進する。
1. 光線がボールに正面から当たるとHitとなる（**Hと表示される**）。
1. 光線の進行方向の右斜め前のマスにボールがある場合90度左折し、左斜め前のマスにボールがある場合90度右折する
1. 光線を照射した位置と光線が終着した位置には**同じ数字が表示される**。
1. 光線が照射した位置と同じ位置に終着した場合**Rと表示される**。
1. 照射する位置のすぐ斜め前にボールがある場合は**Rと表示される**。


