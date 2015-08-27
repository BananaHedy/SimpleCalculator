package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by HappyBanana on 2015/8/21.
 */
public class SimpleNumberResponser extends Responser {

    @Override
    public void onResponse(Memory memory) {
        if (!memory.isEmpty()) {
            InputItem item = memory.getLastInputItem();
            if (item.isSingleUnit() == true && item.getType() == InputType.type_number) {
                memory.removeLastInput();
            }
        }
        memory.input(new InputItem(getName(), SymbolMap.getSymbol(getName()), InputType.type_number, false));
    }


}
