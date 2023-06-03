package client.command;

import client.io.InputHandler;
import client.io.OutputHandler;
import client.transfer.Transfer;
import client.utils.SpaceMarineForm;
import common.command.CommandType;
import common.transfer.Request;
import common.transfer.Response;
import server.database.UserData;

public class InsertCommand extends CommandAbstract {
    public InsertCommand(OutputHandler outputHandler, Transfer transfer, UserData userData, InputHandler inputHandler) {
        super(outputHandler, transfer, userData, inputHandler);
    }

    @Override
    public void execute() {
        Request request = new Request(userData, CommandType.INSERT, new SpaceMarineForm(input, output).getSpaceMarine());
        serverConnection.send(request);
        Response response = serverConnection.receive();
        output.print(response.getMessage());
    }
}
