package com.example.meowmeals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class CatsSprite extends Sprite{
    private int x,y,Vx,Vy ;
    private Bitmap bitmap;
    Paint paint = new Paint();

    public CatsSprite(int x, int y, int Vx, int Vy,Bitmap b){
        super(x,y,Vx,Vy,b);
        this.bitmap = b;
    }
    public void draw(Canvas canvas){canvas.drawBitmap(bitmap, x, y-bitmap.getHeight(), paint);}

    public void getRect(){return new Rect(this.x,this.y-bitmap.getHeight(),this.x+bitmap.getWidth(),this.y);}
}
