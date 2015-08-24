package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class SimpleResponser extends Responser {

    @Override
    public void onResponse(Memory memomry) {
        memomry.input(new InputItem(getName(),SymbolMap.getSymbol(getName()), InputType.type_number,false));
    }


}
