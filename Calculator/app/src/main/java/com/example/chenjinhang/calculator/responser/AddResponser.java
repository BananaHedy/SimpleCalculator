package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class AddResponser extends Responser {
    @Override
    public void onResponse(Memory memory) {
        //空不加
        if (memory.isEmpty()) {
            return;
        }
        //运算符后面不加
        int  lastItemType = memory.getLastInputType();
        if (lastItemType == InputType.type_operator) {
            memory.removeLastInput();
        }
        //剩余情况可以加
        memory.input(new InputItem(SymbolMap.getSymbol(getName()), InputType.type_operator));
    }
}
