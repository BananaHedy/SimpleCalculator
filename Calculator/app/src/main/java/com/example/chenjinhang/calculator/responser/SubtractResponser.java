package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.MemoryReader;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by HappyBanana on 2015/8/24.
 */
public class SubtractResponser extends Responser {
    @Override
    public void onResponse(Memory memory) {
        //空输入时当作负号
        if (memory.isEmpty()) {
            memory.input(new InputItem("negative", SymbolMap.getSymbol("negative"), InputType.type_operator, false));
            return;
        } else {
            //数字后面是减号
            if (memory.getLastInputItem().getType() == InputType.type_number) {
                memory.input(new InputItem("subtract", SymbolMap.getSymbol("subtract"), InputType.type_operator, true));
                return;
            }

            //替换末尾不是乘号或除号的运算符
            while (memory.isEmpty() == false) {
                InputItem item = memory.getLastInputItem();
                if (item.getType() == InputType.type_operator) {
                    if ("divide".equals(item.getName()) || "multiply".equals(item.getName())) {
                        memory.input(new InputItem("negative", SymbolMap.getSymbol("negative"), InputType.type_operator, false));
                        return;
                    } else {
                        memory.removeLastInput();
                    }
                }else{
                    break;
                }
            }
            memory.input(new InputItem("subtract", SymbolMap.getSymbol("subtract"), InputType.type_operator, true));
        }


    }
}
