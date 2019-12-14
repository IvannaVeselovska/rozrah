package commands;

import java.io.IOException;

public interface Command {
    void Execute() throws IOException;
}
