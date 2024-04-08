package com.example.meowmeals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;


public class CatsSprite extends Sprite{
    private int x,y,Vx,Vy ;
    private Bitmap bitmap;
    Paint paint = new Paint();

    public CatsSprite(int x, int y, int Vx, int Vy,Bitmap b){
        super(x,y,Vx,Vy,b);
        this.x = x;
        this.Vy=Vy;
        this.y=y;
        this.bitmap = b;
    }
    public void update (int ms) {
//        x =  (x + velocityX * ms/1000);
        this.y = y + 20;
    }
//    public Rect getBoundingBoxRect(){
//        return new Rect(this.x,this.y-bitmap.getHeight(),this.x+bitmap.getWidth(),this.y);
//    }
//    public void tp (){
//        this.x = (int) (Math.random()*(Vy - Vx));
//        this.y = (-500);
//        Log.d("TP","TPPPP");
//    }
    public void draw(Canvas canvas) {
        Paint p = new Paint();
        Log.d("DRAW",x+ " "+y);
        canvas.drawBitmap(bitmap, this.x, this.y,p);
    }

}
