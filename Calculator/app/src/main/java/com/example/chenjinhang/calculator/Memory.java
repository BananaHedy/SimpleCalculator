package com.example.chenjinhang.calculator;

import java.util.LinkedList;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class Memory {
    private LinkedList<InputItem> inputList = new LinkedList<>();

    public void deleteLast() {
        inputList.removeLast();
    }

    public void clear() {
        inputList.clear();
    }

    public boolean isEmpty(){
        return inputList.isEmpty();
    }

    public void input(InputItem item){
        inputList.add(item);
    }
    public InputItem getLastInput(){
        return inputList.getLast();
    }
    public InputItem removeLastInput(){
        return inputList.removeLast();
    }

    public int getLastInputType(){
        return inputList.getLast().getType();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (InputItem item : inputList) {
            stringBuilder.append(item.getSymbol());
        }
        return stringBuilder.toString();
    }
}
