package com.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();

    private Button mStartAnimationBtn;
    private TextView mAnimTextTv;

    private final String START_ANIM = "Start Animation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_main);
        initViews();

        // add onclick listener
        mStartAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String btnStatus = mStartAnimationBtn.getText().toString();
                Log.d(TAG, "onClick: START_ANIM");
                // load Animation
                final Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_blink);
                // Start animation
                mAnimTextTv.startAnimation(fadeInAnimation);
                // Set animation listener
                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mAnimTextTv.setVisibility(TextView.VISIBLE);
                        mAnimTextTv.startAnimation(fadeInAnimation);    // Start animation when it ends
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
    }

    // This will initialise view
    private void initViews() {
        mStartAnimationBtn = (Button) findViewById(R.id.button_start);
        mAnimTextTv = (TextView) findViewById(R.id.textView);
    }
}



