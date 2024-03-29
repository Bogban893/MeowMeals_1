package com.example.meowmeals;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.View;

public class GameView extends View {
    Stats stats = new Stats();

    public int viewWidth; // экран
    public int viewHeight;
    public int e; // сдвиг

    public int points; // счёт
    public int pointsmax; // счёт макс
    public int Hp=4; // жизни

    private Bitmap image1 = BitmapFactory.decodeResource(getResources(), R.drawable.img_fon); // фон
    int fonW = image1.getWidth()/2+200;
    int fonH = image1.getHeight()/2;
    Rect image_fon = new Rect(0,0,fonW,fonH);

    private Bitmap image_hp = BitmapFactory.decodeResource(getResources(), R.drawable.img_hp); // жизни
    int hpW = image_hp.getWidth()*2;
    int hpH = image_hp.getHeight()*2;
    Rect image_hp1 = new Rect(30,30,hpW,hpH);



    private Bitmap bitmap;

    public GameView(Context context) {
        super(context);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.img);
        int w = b.getWidth()/5;
        int h = b.getHeight()/3;
        Rect firstFrame = new Rect(0, 0, w, h);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) { // экран
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }
    @Override
    protected void onDraw(Canvas canvas) { // Рисование
        super.onDraw(canvas);
//        canvas.drawARGB(250, 127, 199, 255); // заливаем цветом
        Paint p = new Paint();
        canvas.drawBitmap(image1,null, image_fon ,null);
        for (int i = 0; i != Hp; i++){
            canvas.drawBitmap(image_hp,null,image_hp1,null);
            image_hp1 = new Rect(30+e,30,hpW+e,hpH);
            e += 100;
        }
        p.setAntiAlias(true);
        p.setTextSize(70.0f);
        p.setColor(Color.WHITE);
        canvas.drawText(points+"", viewWidth - 100, 100, p); // счёт
        p.setTextSize(50.0f);
        canvas.drawText(pointsmax+"",viewWidth - 100, 180, p); // рекорд
    }
}
