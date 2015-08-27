package com.example.chenjinhang.calculator;

import java.util.LinkedList;

/**
 * Created by HappyBanana on 2015/8/24.
 *
 * Get and read is not safe,may throws Out of Bounds Exception.
 * Must use hasIndex() and get true before use them.
 *
 * Read method will move index while get method will not.
 */
public class MemoryReader {
    private Memory mMemory;
    private LinkedList<InputItem> mInputList;
    private int index = 0;
    private boolean mIsReverse;

    public MemoryReader(Memory memory, boolean isReverse) {
        mMemory = memory;
        mInputList = mMemory.getInputList();
        this.mIsReverse = isReverse;
        if (mIsReverse) {
            index = mInputList.size() - 1;
        }
    }

    public boolean isEmpty() {
        return mMemory.isEmpty();
    }

    public boolean hasIndex() {
        if (mIsReverse) {
            return index >= 0;
        } else {
            return index < mInputList.size();
        }
    }

    public int getIndexInputType() {
        int inputType = mInputList.get(index).getType();
        return inputType;
    }

    public int readIndexInputType() {
        int inputType = getIndexInputType();
        nextIndex();
        return inputType;
    }


    public InputItem getIndexItem() {
        InputItem item = mInputList.get(index);
        return item;
    }

    public InputItem readIndexItem() {
        InputItem item = getIndexItem();
        nextIndex();
        return item;
    }

    public String readIndexUnit() {
        InputItem item = getIndexItem();
        if (item.isSingleUnit()) {
            nextIndex();
            return item.getName();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (!item.isSingleUnit()) {
                stringBuilder.append(item.getSymbol());
                nextIndex();
                if (!hasIndex()) {
                    break;
                }
                item = getIndexItem();
            }
            return stringBuilder.toString();
        }
    }

    public void nextIndex() {
        if (mIsReverse) {
            index--;
        } else {
            index++;
        }
    }

    public void preIndex() {
        if (mIsReverse) {
            index++;
        } else {
            index--;
        }
    }
}
