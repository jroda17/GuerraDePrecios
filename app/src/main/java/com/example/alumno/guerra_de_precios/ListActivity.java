package com.example.alumno.guerra_de_precios;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Alumno on 31/10/2018.
 */

public class ListActivity extends AppCompatActivity {

    FloatingActionButton fabfilter,fab_worse,fab_better;
    Animation FabOpen,FabClose,FabRClockwise,FabRantiClockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        fabfilter = (FloatingActionButton)findViewById(R.id.fab_filter);
        fab_worse = (FloatingActionButton)findViewById(R.id.fab_worse);
        fab_better = (FloatingActionButton)findViewById(R.id.fab_best);

        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRantiClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        fabfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab_better.startAnimation(FabClose);
                    fab_worse.startAnimation(FabClose);
                    fabfilter.startAnimation(FabRantiClockwise);
                    fab_worse.setClickable(false);
                    fab_better.setClickable(false);
                    fab_better.setVisibility(View.INVISIBLE);
                    fab_worse.setVisibility(View.INVISIBLE);
                    isOpen=false;
                    fabfilter.setImageResource(R.drawable.filter);
                }
                else
                {
                    fab_better.startAnimation(FabOpen);
                    fab_worse.startAnimation(FabOpen);
                    fabfilter.startAnimation(FabRClockwise);
                    fab_worse.setClickable(true);
                    fab_better.setClickable(true);
                    fab_better.setVisibility(View.VISIBLE);
                    fab_worse.setVisibility(View.VISIBLE);
                    isOpen=true;
                    fabfilter.setImageResource(R.drawable.plus);
                }
            }
        });


    }
}