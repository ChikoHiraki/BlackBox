package jp.ac.uryukyu.ie.e205735;

import java.util.ArrayList;
import java.util.Collections;

/**
 * フィールドアンサークラス。
 * 正解となる盤面を生成する。
 */
public class FieldAnswer {

    /**
     * クラスフィールド。
     * int MASU;  //盤面の１辺のマスの数
     * int BALL= 3;  //ボールの数
     * String[][] boxAnswer;  //正解となる盤面のマスの状態
     */
    private int MASU;
    private int BALL= 3;
    private String[][] boxAnswer;

    /**
     * コンストラクタ。マスの数を指定する。
     * @param masu １辺のマスの数
     */
    public FieldAnswer(int masu){
        this.MASU = masu;
        this.boxAnswer  = new String[MASU][MASU];
    }

    public void ballInstallation(){
        ArrayList<HavingTwoNumber> list1 = new ArrayList<HavingTwoNumber>();
        for(int i=0; i<MASU; i++){
            for(int j=0; j<MASU; j++){
                list1.add(twoNumberInOneBag(i,j));
                this.boxAnswer[i][j] = "□";
            }
        }
        Collections.shuffle(list1);
        for(int i=0; i<BALL; i++){
            this.boxAnswer[list1.get(i).tate][list1.get(i).yoko] = "●";
        }
    }

    public HavingTwoNumber twoNumberInOneBag(int _num1, int _num2){
        var bag = new HavingTwoNumber();
        bag.tate = _num1;
        bag.yoko = _num2;
        return bag;
    }

    public String[][] getBoxAnswer(){
        return this.boxAnswer;
    }


}
