package client.command;

import client.io.InputHandler;
import client.io.OutputHandler;
import client.transfer.Transfer;
import client.utils.SpaceMarineForm;
import common.command.CommandType;
import common.models.SpaceMarine;
import common.transfer.Request;
import common.transfer.Response;
import server.database.UserData;

public class UpdateCommand extends CommandAbstract {
    Long id;
    public UpdateCommand(OutputHandler outputHandler, Transfer transfer, UserData userData, InputHandler inputHandler) {
        super(outputHandler, transfer, userData, inputHandler);
    }

    public void setId(String command) {
        String[] c = command.trim().split("\\s+");
        if (c.length == 2) {
            try {
                id = Long.parseLong(c[1]);
            } catch (NumberFormatException ignore) {}
        }
    }

    @Override
    public void execute() {
        if (id != null) {
            SpaceMarine spaceMarine = new SpaceMarineForm(input, output).getSpaceMarine();
            spaceMarine.setId(id);
            Request request = new Request(userData, CommandType.UPDATE, spaceMarine);
            serverConnection.send(request);
            Response response = serverConnection.receive();
//            output.print(response.getMessage());
        } else {
            output.printMessage("no_id");
        }
    }
}
