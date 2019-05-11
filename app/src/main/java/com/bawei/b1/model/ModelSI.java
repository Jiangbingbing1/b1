package com.bawei.b1.model;

import javax.security.auth.callback.Callback;

public interface ModelSI {
    void FromData(String userName, String pwd, Callback callback);

    interface Callback{
        void getData(String s);
    }
}
