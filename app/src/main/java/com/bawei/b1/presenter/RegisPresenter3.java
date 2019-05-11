package com.bawei.b1.presenter;

import com.bawei.b1.model.ModelSI;
import com.bawei.b1.model.RegisModel;
import com.bawei.b1.view.ViewI;

public class RegisPresenter3 implements PresenterI{

    private ViewI viewI;
    private ModelSI modelSI;

    public RegisPresenter3(ViewI viewI){
              modelSI=new RegisModel();
              this.viewI=viewI;
    }
    @Override
    public void onAttach(ViewI viewI) {
             this.viewI=viewI;
    }

    @Override
    public void startPresenter(String userName, String pwd) {
        modelSI.FromData(userName, pwd, new ModelSI.Callback() {
            @Override
            public void getData(String s) {
                viewI.getData(s);
            }
        });
    }


    @Override
    public void onDeAttach() {
           if (modelSI!=null){
               modelSI=null;
           }
           if (viewI!=null){
                viewI=null;
           }
    }
}
