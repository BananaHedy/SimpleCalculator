package com.example.chenjinhang.calculator;

import java.util.LinkedList;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class Memory {
    private LinkedList<InputItem> inputList = new LinkedList<>();

    public boolean isEmpty() {
        return inputList.isEmpty();
    }

    public void input(InputItem item) {
        inputList.add(item);
    }

    public InputItem removeLastInput() {
        if(isEmpty()==true){
            return null;
        }
        return inputList.removeLast();
    }

    public void reset(){
        inputList.clear();
    }

    public LinkedList<InputItem> getInputList() {
        return inputList;
    }

    public InputItem getLastInputItem(){
        return inputList.getLast();
    }
    public int size(){
        return inputList.size();
    }
    @Override
    public String toString() {
        if(isEmpty()){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (InputItem item : inputList) {
            stringBuilder.append(item.getSymbol());
        }
        return stringBuilder.toString();
    }
}
