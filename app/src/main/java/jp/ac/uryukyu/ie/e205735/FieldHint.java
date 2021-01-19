package jp.ac.uryukyu.ie.e205735;

class FieldHint extends FieldAnswer{
    private String[] topLasers;
    private String[] leftLasers;
    private String[] rightLasers;
    private String[] underLasers;
    private int count = 1;
    private int countOut = 1;


    FieldHint(int masu){
        super(masu);
        topLasers = new String[5];
        leftLasers = new String[5];
        rightLasers = new String[5];
        underLasers = new String[5];
    }

    public void ballCheck(){
        for(int i= 0;i < 5;i++){
            ballCheckTop(i);
            if(topLasers[i] == "R" || topLasers[i] == "H"){
            }else{count++;}
        }
        for(int i= 0;i < 5;i++){
            ballCheckDown(i);
            if(topLasers[i] == "R" || topLasers[i] == "H"){
            }else{count++;}
        }
        for(int i= 0;i < 5;i++){
            ballCheckRight(i);
            if(topLasers[i] == "R" || topLasers[i] == "H"){
            }else{count++;}
        }
        for(int i= 0;i < 5;i++){
            ballCheckLeft(i);
            if(topLasers[i] == "R" || topLasers[i] == "H"){
            }else{count++;}
        }
    }

    public boolean laserCheck(String[] laser,int num){
        //レーザーの中に何も入っていなかったらtrueを返す。
        if(laser[num] == null){
            return true;
        }
        return false;
    }

    public void ballCheckTop(int yoko){
        int startTate = 0;
        int startYoko = yoko;
        if(laserCheck(topLasers,startYoko)){
                //エントリー
                if(getBoxAnswer()[startTate][startYoko] == "●"){
                    topLasers[startYoko] = "H";
                    return;
                }
                if(startYoko > 0){
                    if(getBoxAnswer()[startTate][startYoko-1] == "●"){
                    topLasers[startYoko] = "R";
                    return;
                    }
                }
                if(startYoko < 4){
                    if(getBoxAnswer()[startTate][startYoko+1] == "●"){
                        topLasers[startYoko] = "R";
                        return;
                    }
                }
                //エントリー完了　引数と方向ベクトルを渡す。

                //(0,yoko)エントリー。方向ベクトル(1,0)
                topLasers[startYoko] = bector_One_Zero(startTate, startYoko, count);
        }
    }

    public void ballCheckDown(int yoko){
        int startTate = 4;
        int startYoko = yoko;

        if(laserCheck(underLasers,startYoko)){
            //エントリー
            if(getBoxAnswer()[startTate][startYoko] == "●"){
                underLasers[startYoko] = "H";
                return;
            }
            if(startYoko > 0){
                if(getBoxAnswer()[startTate][startYoko-1] == "●"){
                underLasers[startYoko] = "R";
                return;
                }
            }
            if(startYoko < 4){
                if(getBoxAnswer()[startTate][startYoko+1] == "●"){
                    underLasers[startYoko] = "R";
                    return;
                }
            }
            //エントリー完了　引数と方向ベクトルを渡す。

            //(4,yoko)エントリー。方向ベクトル(-1,0)
            underLasers[startYoko] = bector_NegativeOne_Zero(startTate, startYoko ,count);
        }      
    }

    public void ballCheckLeft(int tate){
        int startTate = tate;
        int startYoko = 0;
        
        if(laserCheck(leftLasers,startTate)){

            //エントリー
            if(getBoxAnswer()[startTate][startYoko] == "●"){
                leftLasers[startTate] = "H";
                return;
            }
            if(startTate > 0){
                if(getBoxAnswer()[startTate-1][startYoko] == "●"){
                leftLasers[startTate] = "R";
                return;
                }
            }
            if(startTate < 4){
                if(getBoxAnswer()[startTate+1][startYoko] == "●"){
                    leftLasers[startTate] = "R";
                    return;
                }
            }
            //エントリー完了　引数と方向ベクトルを渡す。

            //(tate,0)エントリー。方向ベクトル(0,1)
            leftLasers[startTate] = bector_Zero_One(startTate, startYoko, count);
        }     
    }

    public void ballCheckRight(int tate){
        int startTate = tate;
        int startYoko = 4;
        
        if(laserCheck(rightLasers,startTate)){

            //エントリー
            if(getBoxAnswer()[startTate][startYoko] == "●"){
                rightLasers[startTate] = "H";
                return;
            }
            if(startTate > 0){
                if(getBoxAnswer()[startTate-1][startYoko] == "●"){
                rightLasers[startTate] = "R";
                return;
                }
            }
            if(startTate < 4){
                if(getBoxAnswer()[startTate+1][startYoko] == "●"){
                    rightLasers[startTate] = "R";
                    return;
                }
            }
            //エントリー完了　引数と方向ベクトルを渡す。

            //(tate,4)エントリー。方向ベクトル(0,-1)
            rightLasers[startTate] = bector_Zero_NegativeOne(startTate, startYoko, count);
        }
    }



    public String bector_One_Zero(int tateNow, int yokoNow ,int count){
        //方向ベクトル(1,0)のときに行う処理
        int bectorTate = 1;
        int bectorYoko = 0;
        int migi = -1;
        int hidari = 1;
        String hit = "H";

        //目の前にボールがあるかを調べる
        if(tateNow < 4){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + bectorYoko] == "●"){
                return hit;
            }
        }
        //進行方向に対して右側から調べる。
        if(tateNow < 4 && yokoNow > 0){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + migi] == "●"){
                return bector_Zero_One(tateNow,yokoNow,count);      //bector(0,1)
            }
        }
        //左側を調べる。
        if(tateNow < 4 && yokoNow < 4){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + hidari] == "●"){
                return bector_Zero_NegativeOne(tateNow, yokoNow,count);  //bector(0,-1)
            }
        }
        //前にボールがない場合、直進する
        if(tateNow < 4){
            return bector_One_Zero(tateNow + 1, yokoNow,count);
        }else{
            underLasers[yokoNow] = String.valueOf(count);
            return String.valueOf(count);
        }
    }

    public String bector_Zero_One(int tateNow, int yokoNow,int count){
        //方向ベクトル(0,1)のときに行う処理
        int bectorTate = 0;
        int bectorYoko = 1;
        int migi = 1;
        int hidari = -1;
        String hit = "H";
        
        //目の前にボールがあるかを調べる
        if(yokoNow < 4){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + bectorYoko] == "●"){
                return hit;
            }
        }
        //方向に対して右側から調べる。
        if(yokoNow < 4 && tateNow < 4){
            if(getBoxAnswer()[tateNow + migi][yokoNow + bectorYoko] == "●"){
                return bector_NegativeOne_Zero(tateNow, yokoNow,count);
                //bector(-1,0)
            }
        }
        //左側を調べる。
        if(yokoNow < 4 && tateNow > 0){
            if(getBoxAnswer()[tateNow + hidari][yokoNow + bectorYoko] == "●"){
                return bector_One_Zero(tateNow, yokoNow,count);
                //bector(1,0)
            }
        }
        //前にボールがない場合、直進する
        if(yokoNow < 4 ){
            return bector_Zero_One(tateNow, yokoNow + 1,count);
        }else{
            rightLasers[tateNow] = String.valueOf(count);
            return String.valueOf(count);
        }
    }

    public String bector_Zero_NegativeOne(int tateNow, int yokoNow,int count){
        //方向ベクトル(0,-1)のときに行う処理
        int bectorTate = 0;
        int bectorYoko = -1;
        int migi = -1;
        int hidari = 1;
        String hit = "H";

        //目の前にボールがあるかを調べる
        if(yokoNow > 0){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + bectorYoko] == "●"){
                return hit;
                //topLasers[3] = "R";
            }
        }
        //方向に対して右側から調べる。
        if(yokoNow > 0 && tateNow > 0){
            if(getBoxAnswer()[tateNow + migi][yokoNow + bectorYoko] == "●"){
                return bector_One_Zero(tateNow, yokoNow,count);
                //bector(1,0)
            }
        }
        //左側を調べる。
        if(yokoNow > 0 && tateNow < 4){
            if(getBoxAnswer()[tateNow + hidari][yokoNow + bectorYoko] == "●"){
                return bector_NegativeOne_Zero(tateNow, yokoNow,count);
                //bector(-1,0)
            }
        }
        //前にボールがない場合、直進する
        if(yokoNow > 0){
            return bector_Zero_NegativeOne(tateNow, yokoNow - 1,count);
        }else{
            leftLasers[tateNow] = String.valueOf(count);
            return String.valueOf(count);
        }
    }

    public String bector_NegativeOne_Zero(int tateNow, int yokoNow,int count){
        //方向ベクトル(-1,0)のときに行う処理
        int bectorTate = -1;
        int bectorYoko = 0;
        int migi = 1;
        int hidari = -1;
        String hit = "H";

        //目の前にボールがあるかを調べる
        if(tateNow > 0){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + bectorYoko] == "●"){
                return hit;
                //topLasers[3] = "R";
            }
        }
        //方向に対して右側から調べる。
        if(tateNow > 0 && yokoNow < 4){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + migi] == "●"){
                return bector_Zero_NegativeOne(tateNow, yokoNow,count);
                //bector(0,-1)
            }
        }
        //左側を調べる。
        if(tateNow > 0 && yokoNow > 0){
            if(getBoxAnswer()[tateNow + bectorTate][yokoNow + hidari] == "●"){
                return bector_Zero_One(tateNow, yokoNow,count);
                //bector(0,1)
            }
        }
        //前にボールがない場合、直進する
        if(tateNow > 0){
            return bector_NegativeOne_Zero(tateNow -1, yokoNow,count);
        }else{
            topLasers[yokoNow] = String.valueOf(count);
            return String.valueOf(count);
        }
    }

    public String[] getTopLasers(){
        return this.topLasers;
    }

    public String[] getLeftLasers(){
        return this.leftLasers;
    }

    public String[] getRightLasers(){
        return this.rightLasers;
    }

    public String[] getUnderLasers(){
        return this.underLasers;
    }

}