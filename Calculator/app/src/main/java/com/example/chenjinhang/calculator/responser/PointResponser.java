package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.MemoryReader;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by HappyBanana on 2015/8/21.
 */
public class PointResponser extends Responser {
    @Override
    public void onResponse(Memory memory) {
        MemoryReader memoryReader = new MemoryReader(memory, true);
        if (memoryReader.isEmpty()) {
            return;
        }
        //非数字不考虑加
        int lastItemType = memoryReader.getIndexInputType();
        if (lastItemType != InputType.type_number) {
            return;
        }
        //数字单元里有点不加
        String lastUnit = memoryReader.readIndexUnit();
        if (lastUnit.contains(SymbolMap.getSymbol(getName()))) {
            return;
        }
        //独立单元且是数字的一定是运算结果，将结果设为非独立
        InputItem item = memory.getLastInputItem();
        if (item.isSingleUnit() == true && item.getType() == InputType.type_number) {
            item.setIsSingleUnit(false);
        }

        memory.input(new InputItem(getName(), SymbolMap.getSymbol(getName()), InputType.type_number, false));
    }
}
