package jp.ac.uryukyu.ie.e205735;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

/**
 * ゲームマスタークラス。
 */
public class GameMaster {

    /**
     * クラスフィールド。
     * private int MASU;  //盤面の１辺のマスの数
     * int BALL= 3;  //ボールの数
     * Field ban;
     * FieldAnswer banAns;
     */
    private int MASU;
    private int BALL= 3;
    private Field ban;
    private FieldHint banAns;

    /**
     * コンストラクタ。マスの数を指定する。
     * @param masu １辺のマスの数
     */
    public GameMaster(int masu){
        this.MASU = masu;
        ban = new Field(this.MASU);
        ban.resetBoxStatus();
        banAns = new FieldHint(this.MASU);
        banAns.ballInstallation();
    }

    /**
     * 盤面を出力するメソッド。
     * 破線の外側に選択するための英数字を表示し、内側に各マスの状態とレーザーの結果を表示する。
     */
    public void fieldStatus(){
        banAns.ballCheck();
        //1列目
        char c = 'a';
        System.out.print("  |   ");
        for(int j = 0; j < this.MASU ; j++){
            System.out.print(c + " ");
            c++ ;
        }
        System.out.println();
        System.out.println("ーーーーーーーーーー");

        //2列目
        System.out.print("  |   ");
        for (int j = 0; j < MASU ; j++){
            System.out.print(banAns.getTopLasers()[j]+" ");
        }
        System.out.println();

        //3~7列目
        for (int tate = 0; tate < MASU ; tate++){
            System.out.print(tate+" | ");
            System.out.print(banAns.getLeftLasers()[tate]+" ");
            for (int yoko = 0; yoko< MASU ; yoko++){
                System.out.print(ban.getBoxStatus()[tate][yoko]+" ");
            }
            System.out.print(banAns.getRightLasers()[tate]+" ");
            System.out.println();
        }

        //最後の列
        System.out.print("  |   ");
        for (int j = 0; j < MASU ; j++){
            System.out.print(banAns.getUnderLasers()[j]+" ");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * プレイヤーが入力したボールの位置を受け取るメソッド。
     * 
     */
    public void receiveInput(){
        Scanner scanner = new Scanner(System.in);
        int choiceNumber;
        char choiceEiji;
        int changeInt;

        for(int i = 0; i<BALL; i++){
            System.out.println((i+1) + "つ目のボールの位置を選択してください");
            System.out.print("数字（0~4）を入力：");
            while(true){
                try{
                    choiceNumber = scanner.nextInt();
                    break;
                }catch(Exception e){
                    System.out.println("入力エラー：数字を入力してください");
                    System.out.print("数字（0~4）を入力：");
                    scanner.next();
                }
            }

            System.out.print("アルファベット（a~e）を入力：");
            while(true){
                try{
                    choiceEiji = scanner.next().charAt(0);
                    changeInt = choiceEiji - 'a';
                    ban.setBoxStatus(choiceNumber, changeInt);
                    break;
                }catch(Exception e){
                    System.out.println("入力エラー：アルファベットを入力してください");
                    System.out.print("アルファベット（a~e）を入力：");
                }
            }
            System.out.println();
            this.fieldStatus();
        }
    }

    /**
     * 正誤判定を行うメソッド。
     * @return boolean型 
     */
    public boolean compareBallPosition(){
        if(Arrays.deepEquals(banAns.getBoxAnswer(),ban.getBoxStatus())){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 答えを表示するメソッド。
     */
    public void openAnswer(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(banAns.getBoxAnswer()[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * プレイヤーに解答を表示するか尋ねるメソッド
     */
    public void askOpenAnswer(){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("解答を表示して終了しますか？");
        System.out.println("１：表示して終了　　　２：続ける");
        if(scanner2.nextInt() == 1){
            openAnswer();
            System.exit(0);
        }
        System.out.println();
    }

    /**
     * 正解するまで回答を繰り返すメソッド。
     */
    public void repeatAnswer(){
        int count =1;

        System.out.println("ーーーー " +count+ " turn ーーーー");
        System.out.println();
        receiveInput();
        compareBallPosition();
        count++;
        while(compareBallPosition()){
            System.out.println("回答が異なります");
            System.out.println();
            askOpenAnswer();
            System.out.println("ーーーー " +count+ " turn ーーーー");
            System.out.println();
            ban.resetBoxStatus();
            this.fieldStatus();
            receiveInput();
            compareBallPosition();
            count++;
        }
        System.out.println("G A M E  C L E A R  ! !");
        System.out.println();
    }




    

}
