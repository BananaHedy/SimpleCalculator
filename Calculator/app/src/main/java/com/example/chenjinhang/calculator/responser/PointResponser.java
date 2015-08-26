package com.example.chenjinhang.calculator.responser;

import com.example.chenjinhang.calculator.InputItem;
import com.example.chenjinhang.calculator.InputType;
import com.example.chenjinhang.calculator.Memory;
import com.example.chenjinhang.calculator.MemoryReader;
import com.example.chenjinhang.calculator.SymbolMap;

/**
 * Created by chenjinhang on 2015/8/21.
 */
public class PointResponser extends Responser {
    @Override
    public void onResponse(Memory memory) {
        MemoryReader memoryReader = new MemoryReader(memory,true);
        if(memoryReader.isEmpty()){
            return ;
        }

        if (!memory.isEmpty()) {
            InputItem item = memory.getLastInputItem();
            if (item.isSingleUnit() == true && item.getType() == InputType.type_number) {
                item.setIsSingleUnit(false);
            }
        }

        //运算符后面不加
        int  lastItemType = memoryReader.readIndexInputType();
        if (lastItemType == InputType.type_operator) {
            return;
        }
        //从后往前遇到运算符前有点不加
        memoryReader.preIndex();
        String lastUnit = memoryReader.readIndexUnit();
        if(lastUnit.contains(SymbolMap.getSymbol(getName()))){
            return ;
        }
        //剩余情况可以加
        memory.input(new InputItem(getName(),SymbolMap.getSymbol(getName()), InputType.type_number,false));
    }
}
