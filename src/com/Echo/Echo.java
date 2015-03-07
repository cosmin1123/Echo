package com.Echo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.Echo.R;


public class Echo extends Activity {
    /**
     * Called when the activity is first created.
     */

    public void setButtonListener() {
        Button butt1 = (Button) findViewById(R.id.answerButton);
        Button butt2 = (Button) findViewById(R.id.askButton);

        butt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(
                        Echo.this,
                        Answer.class);

                startActivity(i);
                overridePendingTransition(R.anim.animation_enter,
                        R.anim.animation_leave);

            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(
                        Echo.this,
                        Answer.class);

                startActivity(i);
                overridePendingTransition( android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }

    public void setFont() {
        Button butt1 = (Button) findViewById(R.id.answerButton);
        Button butt2 = (Button) findViewById(R.id.askButton);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Goffik-O.ttf");
        butt1.setTypeface(font);
        butt2.setTypeface(font);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setFont();
        setButtonListener();
    }
}
