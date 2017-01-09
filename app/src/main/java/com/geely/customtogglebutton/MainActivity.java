package com.geely.customtogglebutton;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_thumb;
    private Interpolator accelerateDecelerateInterpolator;
    private float translationX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();

        tv_thumb = (TextView) findViewById(R.id.tv_thumb);
        final LinearLayout lin_back = (LinearLayout) findViewById(R.id.lin_back);

        lin_back.post(new Runnable() {
            @Override
            public void run() {
                translationX = lin_back.getRight() - tv_thumb.getRight();
            }
        });

        findViewById(R.id.tv_01).setOnClickListener(this);
        findViewById(R.id.tv_02).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_01:
                tv_thumb.animate().translationX(0).setDuration(300).setInterpolator(accelerateDecelerateInterpolator).setListener(new SimpleAnimatorListener(){
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        tv_thumb.setText("现在");
                    }
                });
                break;

            case R.id.tv_02:
                tv_thumb.animate().translationX(translationX).setDuration(300).setInterpolator(accelerateDecelerateInterpolator).setListener(new SimpleAnimatorListener(){
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        tv_thumb.setText("预约");
                    }
                });
                break;

            default:
                break;
        }
    }

    private static class SimpleAnimatorListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationStart(Animator animator) {

        }

        @Override
        public void onAnimationEnd(Animator animator) {

        }

        @Override
        public void onAnimationCancel(Animator animator) {

        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
    }
}
