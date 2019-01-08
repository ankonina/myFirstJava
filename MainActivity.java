package com.exemple.morganeankonina.myfirstapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**private ImageView play;*/
    private LinearLayout myLayout;
    private MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.activity=this;
        this.myLayout=(LinearLayout)findViewById(R.id.myDynamicLayout);


       /** this.play=(ImageView)findViewById(R.id.play);

       /** play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), CookieActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
        */
       ImageView image= new ImageView(this);
       ViewGroup.LayoutParams params=new ActionBar.LayoutParams(100, 100);
       image.setLayoutParams(params);
       image.setBackgroundResource(R.drawable.salut);
       myLayout.addView(image);

       TextView text=new TextView(this);
       text.setText("ceci est un text");
       text.setTextColor(getResources().getColor(R.color.colorRed));
       text.setTextSize(25);
       myLayout.addView(text);

       int textSize=10;

       for(int i=0; i<6; i++)
       {
       Button button= new Button(this);
       button.setText("Button "+i);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               /**AlertDialog.Builder myPopup= new AlertDialog.Builder(activity);
               myPopup.setTitle("Salut:)");
               myPopup.setMessage("Salut, c'est Morgane");
               myPopup.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getApplicationContext(),"Vous avez cliqué sur OUI!", Toast.LENGTH_SHORT).show();
                   }
               });
               myPopup.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getApplicationContext(),"Vous avez cliqué sur NON :(",Toast.LENGTH_SHORT).show();;
                   }
               });

               myPopup.show();
           }
                */
               final CustomPopup customPopup=new CustomPopup(activity);
               customPopup.setTitle("Bonne annéee 2019");
               customPopup.setSubTitle("Télechargez c'est gratuit:)");
               customPopup.getYesButton().setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Toast.makeText(getApplicationContext(), "oui!", Toast.LENGTH_SHORT).show();
                       customPopup.dismiss();
                   }
               });
               customPopup.getNonButton().setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       customPopup.dismiss();
                   }
               });
               customPopup.build();
           }

       });


       button.setTextSize(textSize);
       myLayout.addView(button);
       textSize+=5;
       }
    }
}
