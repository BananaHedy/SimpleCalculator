package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by HappyBanana on 2015/8/27.
 */
public class SimpleOperatorResponser extends Responser {
    @Override
    public void onResponse(Memory memory) {
        if(memory.isEmpty()){
            return ;
        }
        //替换末尾运算符
        while (memory.isEmpty() == false) {
            InputItem item = memory.getLastInputItem();
            if (item.getType() == InputType.type_operator) {
                memory.removeLastInput();
            }else{
                break;
            }
        }

        memory.input(new InputItem(getName(), SymbolMap.getSymbol(getName()), InputType.type_operator,true));

    }
}
