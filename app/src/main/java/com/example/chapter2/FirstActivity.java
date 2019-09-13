package com.example.chapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //隐式intent，跳转到second activity
        Button button1=(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent("com.example.chapter2.ACTION_START");
                startActivity(intent);
            }
        });

        //跳转到外部网页
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);
            }
        });
        //跳转到thirdactivity 其他协议
        Button button3=(Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(FirstActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });


        //向下一个活动传递数据,传递到secondactivity
        Button button4=(Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data="Hello SecondActivity";
                Intent intent3=new Intent(FirstActivity.this,SecondActivity.class);
                intent3.putExtra("extra_data",data);
                startActivity(intent3);
            }
        });

        //从secondacticity中获取返回数据
        Button button5=(Button)findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent4,1);
            }
        });
        //启动NormalActivity
        Button button6=(Button)findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(FirstActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        //启动DialogActivity
        Button button7=(Button)findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(FirstActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    //secondactivity被销毁后回回调上一个活动的onActivityResult()方法
    public void onActivityReenter(int requestCode,int resultCode, Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnData=data.getStringExtra("data_return");
                    Log.d(".FirstActivity",returnData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked ADD",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    protected void OnStart(){
        super.onStart();
        Log.d(".FirstActivity","OnStart");
    }
    protected void OnResume(){
        super.onResume();
        Log.d(".FirstActivity","OnResume");
    }
    protected void OnPause(){
        super.onPause();
        Log.d(".FirstActivity","OnPause");
    }
    protected void OnStop(){
        super.onStop();
        Log.d(".FirstActivity","OnStop");
    }
    protected void OnDestroy(){
        super.onDestroy();
        Log.d(".FirstActivity","OnDestroy");
    }
    protected void OnRestart(){
        super.onRestart();
        Log.d(".FirstActivity","OnRestart");
    }
}
