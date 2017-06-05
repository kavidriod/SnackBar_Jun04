package com.example.kavitha.snackbar_jun04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CoordinatorLayout coordinatorLayout;
    private Button btnSimpleSnackbar, btnActionCallback, btnCustomView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(mToolbar);

        btnSimpleSnackbar = (Button) findViewById(R.id.buttonSimpleSnackBar);
        btnActionCallback = (Button) findViewById(R.id.buttonWithActionCallback);
        btnCustomView = (Button) findViewById(R.id.buttonCustomColor);


        btnSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,"Hello SnackBar", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        btnActionCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout,"Message is deleted",Snackbar.LENGTH_LONG)
        .setAction("Undo", new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Snackbar snackbar1 =  Snackbar.make(coordinatorLayout,"Message is Restored",Snackbar.LENGTH_SHORT);
        snackbar1.show();
    }
});
                snackbar.show();
            }
        });

        btnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(coordinatorLayout,"No internet connection !",Snackbar.LENGTH_LONG)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                // Changing Action Button text color
                snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));


                // Changing message text color
                View buttonView = snackbar.getView();
                TextView textView =  (TextView) buttonView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);

                snackbar.show();
            }
        });
    }
}
