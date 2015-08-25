package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.MemoryReader;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by chenjinhang on 2015/8/25.
 */
public class NegativeResponser extends Responser {
    @Override
    public void onResponse(Memory memory) {
        if (!memory.isEmpty()) {
            //数字后面不加
            if (memory.getLastInputItem().getType()==InputType.type_number) {
                return;
            }
            //从后往前遇到运算符前有自己不加
            MemoryReader memoryReader = new MemoryReader(memory);
            memoryReader.moveIndexToLast();
            String lastUnit = memoryReader.readNextUnit(true);
            if (lastUnit.contains(SymbolMap.getSymbol(getName()))) {
                return;
            }
        }

        memory.input(new InputItem(getName(), SymbolMap.getSymbol(getName()), InputType.type_operator,false));
    }
}
