package com.likeorhate.likeorhate.servlet.mvc.models;

/**
 * Created by Anton on 2016.03.26..
 */
public class MVCModel {

    private String view;
    private Object data;

    public MVCModel(String view, Object data){
        this.view = view;
        this.data = data;
    }

    public MVCModel(String view){
        this.view = view;
        this.data = new Object();
    }

    public String getView() {
        return view;
    }

    public Object getData() {
        return data;
    }

}
