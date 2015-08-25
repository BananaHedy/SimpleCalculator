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
        MemoryReader memoryReader = new MemoryReader(memory);
        if(memoryReader.isEmpty()){
            return ;
        }
        //运算符后面不加
        int  lastItemType = memoryReader.readLastInputType();
        if (lastItemType == InputType.type_operator||lastItemType == InputType.type_point) {
            return;
        }
        //从后往前遇到运算符前有点不加
        memoryReader.moveIndexToLast();
        String lastUnit = memoryReader.readNextUnit(true);
        if(lastUnit.contains(SymbolMap.getSymbol("point"))){
            return ;
        }
        //剩余情况可以加
        memory.input(new InputItem(getName(),SymbolMap.getSymbol(getName()), InputType.type_point,false));
    }
}
