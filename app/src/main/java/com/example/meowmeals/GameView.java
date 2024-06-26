package com.example.meowmeals;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {
    Stats stats = new Stats();

    private final int timerInterval = 30;
    public boolean fish_a = false;

    public int viewWidth; // экран
    public int viewHeight;
    public int e; // сдвиг
    public int gx = 500; // месторосположение gun
    public int gy; // месторосположение gun
    private int c = -500; // месторосположение cat

    public int points; // счёт
    public int pointsmax; // счёт макс
    public int Hp = 3; // жизни

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) { // экран
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    private Bitmap bitmap;

    public GameView(Context context) {
        super(context);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.img_fon);
        gy = viewHeight;
        Timer t = new Timer();
        t.start();
        if (Hp==0){t.onFinish();}
    }

    @Override
    protected void onDraw(Canvas canvas) { // Рисование
        image_gun.setY(viewHeight-200);

        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(image1,null,new Rect(0,0,viewWidth,viewHeight),null);
        for (int i = 0; i != Hp; i++) {
                canvas.drawBitmap(image_hp, null, image_hp1, null);
                image_hp1 = new Rect(30 + e, 30, hpW + e, hpH);
                e += hpW;
        }
        e = 0;
        gy = viewHeight;
        p.setAntiAlias(true);
        p.setTextSize(70.0f);
        p.setColor(Color.WHITE);
        canvas.drawText(points+"", viewWidth - 100, 100, p); // счёт
        p.setTextSize(50.0f);
        canvas.drawText(pointsmax+"",viewWidth - 100, 180, p); // рекорд
        image_gun.draw(canvas);
        image_cat.draw(canvas);
        if (fish_a){img_fish.draw(canvas);}
    }

    private Bitmap image1 = BitmapFactory.decodeResource(getResources(), R.drawable.img_fon); // фон


    private Bitmap image_hp = BitmapFactory.decodeResource(getResources(), R.drawable.img_hp); // жизни
    int hpW = image_hp.getWidth()*2;
    int hpH = image_hp.getHeight()*2;
    Rect image_hp1 = new Rect(30,30,hpW,hpH);

    Sprite image_gun = new Sprite(gx, gy, 0 , 0, BitmapFactory.decodeResource(getResources(),R.drawable.img_gun)); // сковородка
    //    Rect image_gun1 = new Rect(g,1750,image_gun.getWidth()+g,image_gun.getHeight()+1750);
//    Sprite image_cat = new Sprite(500, c,0,600,BitmapFactory.decodeResource(getResources(),R.drawable.img_cat)); // catssss
    Sprite img_fish = new Sprite(image_gun.getX(), 1860, 0, -1000, BitmapFactory.decodeResource(getResources(),R.drawable.img_fish));
    CatsSprite image_cat = new CatsSprite(500, c,0,600,BitmapFactory.decodeResource(getResources(),R.drawable.img_cat));




    class Timer extends CountDownTimer {
        public Timer() {super(Integer.MAX_VALUE, timerInterval);}
        @Override
        public void onTick(long millisUntilFinished) {update();}
        @Override
        public void onFinish() {}
    }

    private void tp (){
        image_cat.setX((int) (Math.random()*(viewWidth - image_cat.getBx())));
        image_cat.setY(-500);
    }

    private void kill(){
        img_fish = new Sprite(-1000, image_gun.getY(), 0, 0, BitmapFactory.decodeResource(getResources(),R.drawable.img_fish));
        fish_a = false;
    }

    protected void update () {
        if (points>=pointsmax) {pointsmax=points;}
        image_cat.update(timerInterval);
        img_fish.update(timerInterval);
        invalidate();
        if (image_cat.intersect(img_fish)&&fish_a){
//            image_cat.tp();
            points += 10;
            fish_a = false;
            kill();
        }
        if (image_cat.getY() > viewHeight) {
//            image_cat.tp();
            Hp -= 1;
            points = 0;
        }
        if (image_cat.intersect(image_gun)) {
//            image_cat.tp();
            Hp -= 1;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();
        image_gun.setX((int) event.getX() - 150);

        fish_a = true;
        img_fish = new Sprite(image_gun.getX()+image_gun.getBx()/5, image_gun.getY(), 0, -1000, BitmapFactory.decodeResource(getResources(),R.drawable.img_fish));
        return true;
    }
}