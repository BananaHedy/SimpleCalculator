package com.example.chenjinhang.calculator;

import java.util.LinkedList;

/**
 * Created by chenjinhang on 2015/8/24.
 */
public class MemoryReader {
    private Memory mMemory;
    private LinkedList<InputItem> mInputList;
    private int index = 0;

    public MemoryReader(Memory memory) {
        mMemory = memory;
        mInputList = mMemory.getInputList();
    }

    public boolean isEmpty() {
        return mMemory.isEmpty();
    }

    public boolean hasNext(boolean isReverse) {
        if (isReverse) {
            return index >= 0;
        } else {
            return index < mInputList.size();
        }
    }

    public boolean isIndexOperator() {
        return mInputList.get(index).getType() == InputType.type_operator;
    }
    public InputItem readNextItem(boolean isReverse){
        InputItem item = mInputList.get(index);
        moveIndex(isReverse);
        return item;
    }
    public String readNextUnit(boolean isReverse) {
        InputItem item = mInputList.get(index);
        if (item.isSingleUnit()) {
            moveIndex(isReverse);
            return item.getName();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (!item.isSingleUnit()) {
                stringBuilder.append(item.getSymbol());
                moveIndex(isReverse);
                if (!hasNext(isReverse)) {
                    break;
                }
                item = mInputList.get(index);
            }
            return stringBuilder.toString();
        }
    }

    private void moveIndex(boolean isReverse) {
        if (isReverse) {
            index--;
        } else {
            index++;
        }
    }

    public int readLastInputType() {
        if (isEmpty()) {
            return InputType.type_non_input;
        }
        return mInputList.getLast().getType();
    }

    public void indexToFirst() {
        index = 0;
    }

    public void moveIndexToLast() {
        index = mInputList.size() - 1;
    }
}
