package com.example.synctasktest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {  
    private Button button;  
    private ProgressBar progressBar;  
    private TextView textView;  
    private ProgressDialog progressDialog;
      
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
          
        button = (Button)findViewById(R.id.button03);  
        progressBar = (ProgressBar)findViewById(R.id.progressBar02);  
        textView = (TextView)findViewById(R.id.textView01);  
        progressBar.setVisibility(View.GONE);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Downloading");
        progressDialog.setMessage("Please");
          
        button.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
//                ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask(textView, progressDialog);  
            	AnotherAsyncTest asyncTask = new AnotherAsyncTest(progressDialog);  
                asyncTask.execute();  
//                progressDialog.show();
 //               asyncTask.execute(1000);  
            }  
        });  
    }  
}  