package com.velus.interpreter.commands;


import com.velus.datatransfer.DataTransference;
import com.velus.datatransfer.Request;
import com.velus.datatransfer.Response;
import com.velus.datatransfer.Utils;
import com.velus.interpreter.Interpreter;
import com.velus.lab.Position;
import com.velus.lab.Worker;

import java.util.HashMap;

public class RemoveAllByPosition extends InterpreterCommand{

    public RemoveAllByPosition(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        if(inputManager.getWords().size() < 2 ){ outputManager.println("Неверное количество аргументов"); return;}
        String pos = inputManager.getWords().get(1);
        if(Worker.Params.position.parse(pos)){
            Position position = Worker.Params.position.get();
            HashMap<String, DataTransference<?>> arguments = new HashMap<>();
            arguments.put("position", new DataTransference<Position>(Position.class, position));
            Request rq = new Request("remove_all_by_position", arguments);
            if(client.sendRequest(rq)){
                Response resp = client.receive();
                Utils.printResponseMessages(resp);
            }
        }
        else{
            outputManager.println("Синтаксическая ошибка. проверьте корректность аргументов"); return;
        }


    }
    @Override
    public String info(){
        return "Удаляет из коллекции рабочих, должность которых совпадает с заданной. remove_all_by_position <position>";
    }
}
