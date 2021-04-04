package seedu.booking.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.booking.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.booking.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.booking.testutil.Assert.assertThrows;
import static seedu.booking.testutil.TypicalIndexes.INDEX_FIRST;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.booking.logic.commands.AddPersonCommand;
import seedu.booking.logic.commands.ClearCommand;
import seedu.booking.logic.commands.DeleteCommand;
import seedu.booking.logic.commands.EditCommand;
import seedu.booking.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.booking.logic.commands.ExitCommand;
import seedu.booking.logic.commands.FindCommand;
import seedu.booking.logic.commands.HelpCommand;
import seedu.booking.logic.commands.ListPersonCommand;
import seedu.booking.logic.parser.exceptions.ParseException;
import seedu.booking.model.person.NameContainsKeywordsPredicate;
import seedu.booking.model.person.Person;
import seedu.booking.testutil.EditPersonDescriptorBuilder;
import seedu.booking.testutil.PersonBuilder;
import seedu.booking.testutil.PersonUtil;

public class BookingSystemParserTest {

    private final BookingSystemParser parser = new BookingSystemParser();

    @Test
    public void parseCommand_clear() throws Exception {
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_list() throws Exception {
        assertTrue(parser.parseCommand(ListPersonCommand.COMMAND_WORD) instanceof ListPersonCommand);
        assertTrue(parser.parseCommand(ListPersonCommand.COMMAND_WORD + " 3") instanceof ListPersonCommand);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
            -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}
