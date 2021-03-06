package seedu.booking.logic.commands;

import static seedu.booking.logic.commands.CommandShowType.COMMAND_SHOW_PREVIOUS;

import seedu.booking.logic.StatefulLogicManager;
import seedu.booking.model.Model;

/**
 * Exits prompting process
 */
public class PromptExitCommand extends Command {

    public static final String COMMAND_WORD = "exit_prompt";


    /**
     * Exits prompting process right away
     */
    public CommandResult execute(Model model) {

        StatefulLogicManager.setStateInactive();
        return new CommandResult("Prompting exited.", COMMAND_SHOW_PREVIOUS);
    }
}
