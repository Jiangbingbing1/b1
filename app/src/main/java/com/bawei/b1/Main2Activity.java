package com.bawei.b1;

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

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, ViewI {

    private EditText name1;
    private EditText pwd1;
    private Button zc1;
    private PresenterI presenterI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        presenterI=new RegisPresenter3(this);
    }

    private void initView() {
        name1 = (EditText) findViewById(R.id.name1);
        pwd1 = (EditText) findViewById(R.id.pwd1);
        zc1 = (Button) findViewById(R.id.zc1);

        zc1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zc1:
                String name1String = name1.getText().toString().trim();
                String pwd1String = pwd1.getText().toString().trim();
                if (TextUtils.isEmpty(name1String)||TextUtils.isEmpty(pwd1String)){
                    Toast.makeText(this, "用户名：", Toast.LENGTH_SHORT).show();
                }
                else {
                    presenterI.startPresenter(name1String,pwd1String);
                }
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
