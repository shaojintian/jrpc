package com.sjt.jrpc;

public class Add implements IAdd{

    @Override
    public int add(int a,int b){
        return a+b;
    }

}
