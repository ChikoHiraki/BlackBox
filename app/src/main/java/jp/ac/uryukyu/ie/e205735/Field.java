package jp.ac.uryukyu.ie.e205735;

/**
 * フィールドクラス。
 * プレイヤーに表示する盤面を生成する。
 */
public class Field {

    /**
     * クラスフィールド。
     * int MASU;  //盤面の１辺のマスの数
     * String[][] boxStatus;　//マスの状態
     */
    private int MASU;
    private String[][] boxStatus;

    /**
     * コンストラクタ。
     * マスの数を指定する。
     * @param masu １辺のマスの数
     */
    public Field(int masu){
        MASU = masu;
        boxStatus = new String[MASU][MASU];
    }

    /**
     * 盤面の状態をリセットするメソッド。
     * boxStatusの全ての要素に"□"を代入する。
     */
    public void resetBoxStatus(){
        for (int j = 0; j < MASU ; j++){
            for (int i = 0; i< MASU ; i++){
                boxStatus[i][j] = "□";
            }
        }
    }

    public void setBoxStatus(int tate,int yoko){
        this.boxStatus[tate][yoko] = "●";
    }

    public String[][] getBoxStatus(){
        return boxStatus;
    }

}
