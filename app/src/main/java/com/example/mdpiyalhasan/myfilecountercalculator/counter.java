package com.example.mdpiyalhasan.myfilecountercalculator;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import static java.lang.System.exit;

public class counter extends AppCompatActivity{
    Button pdfbt;
    Button docbt;
    Button mp3bt;
    Button mp4bt;
    Button htmlbt;
    Button imgbt;
    Button exitbt;
    TextView resutl;
    int c = 0;
    String item;
    ArrayList<File> f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        pdfbt = (Button) findViewById(R.id.pdfbt);
        docbt = (Button) findViewById(R.id.docbt);
        imgbt = (Button) findViewById(R.id.jpgbt);
        htmlbt = (Button) findViewById(R.id.htmlbt);
        mp3bt = (Button) findViewById(R.id.mp3bt);
        mp4bt = (Button) findViewById(R.id.mp4bt);
        exitbt = (Button) findViewById(R.id.exitbt);
        resutl = (TextView) findViewById(R.id.textView);
        pdfbt.setOnClickListener(this);
        docbt.setOnClickListener(this);
        htmlbt.setOnClickListener(this);
        mp4bt.setOnClickListener(this);
        mp3bt.setOnClickListener(this);
        imgbt.setOnClickListener(this);
        exitbt.setOnClickListener(this);
        f= findfile(Environment.getExternalStorageDirectory());

    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jpgbt: {
                Toast.makeText(counter.this, "button click", Toast.LENGTH_SHORT).show();
                item = ".jpg";
                resutl.setText(String.valueOf(c));
                resutl.setText("");
                c = 0;
                break;
            }
            case R.id.pdfbt: {
                item = ".pdf";
                resutl.setText(String.valueOf(c));
                resutl.setText("");
                c = 0;
                break;
            }
            case R.id.docbt: {
                item = ".doc";
                resutl.setText(String.valueOf(c));
                resutl.setText("");
                c = 0;
                break;
            }
            case R.id.htmlbt: {
                item = ".html";
                resutl.setText(String.valueOf(c));
                resutl.setText("");
                c = 0;
                break;
            }
            case R.id.mp3bt: {
                item = ".mp3";
                resutl.setText(String.valueOf(c));
                resutl.setText("");
                c = 0;
                break;
            }
            case R.id.mp4bt: {
                item = ".mp4";
                resutl.setText(String.valueOf(c));
                resutl.setText("");
                c = 0;
                break;
            }
            case R.id.exitbt: {
                resutl.setText("");
                item = "";
                c = 0;
                exit(0);
                break;
            }
        }
    }
    public ArrayList<File> findfile(File root) {
        ArrayList<File> a = new ArrayList<>();
        File[] files = root.listFiles();
        for (File singlefile : files) {
            if (singlefile.isDirectory() || singlefile.isHidden()) {
                a.addAll(findfile(singlefile));
            } else {
                if (singlefile.getName().endsWith(item)) {
                    c++;
                    a.add(singlefile);
                }
            }
        }
        return a;
    }
}


