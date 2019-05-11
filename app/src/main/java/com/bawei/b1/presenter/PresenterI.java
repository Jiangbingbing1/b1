package com.bawei.b1.presenter;

import com.bawei.b1.model.ModelSI;
import com.bawei.b1.view.ViewI;

public interface PresenterI {
    void onAttach(ViewI viewI);
    void startPresenter(String userName, String pwd);
    void onDeAttach();
}
