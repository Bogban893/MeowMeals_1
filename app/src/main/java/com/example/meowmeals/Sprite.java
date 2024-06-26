package com.example.meowmeals;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprite {
    private Bitmap bitmap;
    private int x,y,velocityX,velocityY;
    private int padding;
    public Sprite (int x, int y, int velocityX, int velocityY, Bitmap bitmap){
        this.x=x;
        this.y=y;
        this.velocityX=velocityX;
        this.velocityY=velocityY;
        this.bitmap = bitmap;
        this.padding = 30;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setB(Bitmap b) {
        this.bitmap = b;
    }
    public int getVx() {
        return velocityX;
    }
    public void setVx(int velocityX) {
        this.velocityX = velocityX;
    }
    public int getVy() {
        return velocityY;
    }
    public void setVy(int velocityY) {
        this.velocityY = velocityY;
    }
    public int getBx() {
        return bitmap.getWidth();
    }
    public int getBy() {
        return bitmap.getHeight();
    }



    public void update (int ms) {
        x =  (x + velocityX * ms/1000);
        y = y + velocityY * ms/1000;
    }
    public void draw (Canvas canvas) {
        Paint p = new Paint();
//        Rect destination = new Rect((int)x, (int)y, (int)(x + bitmap.getWidth()), (int)(y + bitmap.getHeight()));
        canvas.drawBitmap(bitmap, x, y,p);
    }
    public Rect getBoundingBoxRect () {
        return new Rect((int)x+padding, (int)y+padding, (int)(x + bitmap.getWidth() - 2 * padding), (int)(y + bitmap.getHeight() - 2 * padding));
    }
    public boolean intersect (Sprite s) {
        return getBoundingBoxRect().intersect(s.getBoundingBoxRect());
    }
    public void tp (){
        this.x = (int) (Math.random()*(velocityY - velocityX));
        this.y = (-500);
    }
}
