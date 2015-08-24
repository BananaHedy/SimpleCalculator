package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.MemoryReader;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by chenjinhang on 2015/8/24.
 */
public class SubtractResponser extends Responser {
    @Override
    public void onResponse(Memory memory) {
        MemoryReader memoryReader = new MemoryReader(memory);
        if(memoryReader.isEmpty()){
            return ;
        }
        //运算符后面替换
        int  lastItemType = memoryReader.readLastInputType();
        if (lastItemType == InputType.type_operator) {
            memory.removeLastInput();
        }
        //剩余情况可以加
        memory.input(new InputItem(getName(), SymbolMap.getSymbol(getName()), InputType.type_operator,true));
    }
}
