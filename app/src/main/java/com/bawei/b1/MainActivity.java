package com.bawei.b1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.b1.presenter.PresenterI;
import com.bawei.b1.presenter.RegisPresenter3;
import com.bawei.b1.view.ViewI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewI {

    private EditText name;
    private EditText pwd;
    private Button dl;
    private Button zc;
    private PresenterI presenterI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenterI=new RegisPresenter3(this);
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        dl = (Button) findViewById(R.id.dl);
        zc = (Button) findViewById(R.id.zc);

        dl.setOnClickListener(this);
        zc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dl:
                String nameString = name.getText().toString().trim();
                String pwdString = pwd.getText().toString().trim();
                if (TextUtils.isEmpty(nameString)||TextUtils.isEmpty(pwdString)) {
                    Toast.makeText(this, "用户名：", Toast.LENGTH_SHORT).show();
                }else {
                    presenterI.startPresenter(nameString,pwdString);
                }
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);

                break;
            case R.id.zc:
                Intent intents=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intents);
                break;
        }
    }

    private void submit() {

    }

    @Override
    public void getData(String data) {
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show();
    }
}
