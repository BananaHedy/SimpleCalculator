package com.example.chenjinhang.calculator;

import java.util.LinkedList;

/**
 * Created by HappyBanana on 2015/8/23.
 */
public class Memory {
    private LinkedList<InputItem> inputList = new LinkedList<>();
    private int index = 0;
    public void deleteLast() {
        inputList.removeLast();
    }

    public boolean hasNextUnit(){
        return index < inputList.size();
    }
    public boolean isNextNumber(){
        return inputList.get(index).getType()!=InputType.type_operator;
    }

    public String getNext(){
        InputItem item = inputList.get(index);
        if(item.isSingleUnit()){
            index++;
            return item.getName();
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            while ()
        }

    }
    public void reset() {
        index = 0;
        inputList.clear();
    }

    public boolean isEmpty() {
        return inputList.isEmpty();
    }

    public void input(InputItem item) {
        inputList.add(item);
    }

    public InputItem getLastInput() {
        return inputList.getLast();
    }

    public InputItem removeLastInput() {
        return inputList.removeLast();
    }

    public int getLastInputType() {
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
