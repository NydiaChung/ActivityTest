package com.example.chapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button button31=(Button)findViewById(R.id.button_31);
        button31.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Button button32=(Button)findViewById(R.id.button_32);
        button32.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v){
                Intent intent1=new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:10086"));
                startActivity(intent1);
            }
        });

        Button button33=(Button)findViewById(R.id.button_33);
        button33.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.899533,-77.036476"));
                startActivity(intent);
            }
        });

        Button button34=(Button)findViewById(R.id.button_34);
        button34.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri smsUri = Uri.parse("tel:10086");
                Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
                intent.putExtra("sms_body", "直接发送短信");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });

        Button button35=(Button)findViewById(R.id.button_35);
        button35.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri smsToUri = Uri.parse("smsto://100861");
                Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
                intent.putExtra("sms_body", "直接发邮件");
                startActivity(intent);
            }
        });

        Button button36=(Button)findViewById(R.id.button_36);
        button36.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Intent.ACTION_DELETE);
                intent.setData(Uri.fromParts("package","QQ" ,null));
                startActivity(intent);
            }
        });
    }
}
