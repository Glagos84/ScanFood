package com.desafiolatam.scanfood.login;

/**
 * Created by Gabriel on 16-12-2017.
 */

public interface SessionCallback {

    void requiredField();
    void mailFormat();
    void success();
    void failure();

}
