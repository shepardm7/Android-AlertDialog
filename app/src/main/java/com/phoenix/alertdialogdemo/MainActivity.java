package com.phoenix.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.button_dialog);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the actual dialog(alert dialog)
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                alertDialog.setTitle(getResources().getString(R.string.title));

                //To set an icon if you want.
                alertDialog.setIcon(android.R.drawable.btn_star_big_on);

                //To set the message we use an alternate way to access a string resource.
                alertDialog.setMessage(R.string.message);

                alertDialog.setCancelable(false);

                alertDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });
                alertDialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                //create the actual dialog
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });
    }
}
