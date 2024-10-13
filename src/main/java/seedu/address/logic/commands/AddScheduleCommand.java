package seedu.address.logic.commands;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Adds a new schedule to the specified person in the address book.
 * The schedule contains an event name, date, and time.
 */
public class AddScheduleCommand extends Command {
    public static final String COMMAND_WORD = "add-schedule";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a schedule to a contact. "
            + "Parameters: c/CONTACT_INDEX n/NAME d/DATE t/TIME\n"
            + "Example: " + COMMAND_WORD + " c/1 n/Dinner d/10-10-2024 t/1800";

    public static final String MESSAGE_SUCCESS = "New schedule added: %1$s";
    public static final String MESSAGE_INVALID_DATE = "Date must be in the format DD-MM-YYYY.";
    public static final String MESSAGE_INVALID_TIME = "Time must be in the format HHmm (24-hour).";
    public static final String MESSAGE_DUPLICATE_SCHEDULE = "This schedule conflicts with an existing schedule.";

    private final int contactIndex;
    private final String name;
    private final LocalDate date;
    private final LocalTime time;

    /**
     * Creates an AddScheduleCommand to add a schedule for a specified person.
     * The schedule includes an event name, date, and time.
     *
     * @param contactIndex The index of the person in the filtered person list.
     * @param name The name or description of the event.
     * @param date The date of the event in LocalDate format.
     * @param time The time of the event in LocalTime format.
     */
    public AddScheduleCommand(int contactIndex, String name, LocalDate date, LocalTime time) {
        this.contactIndex = contactIndex;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (contactIndex < 0 || contactIndex >= lastShownList.size()) {
            throw new CommandException("The contact index provided is invalid.");
        }

        Person person = lastShownList.get(contactIndex);

        // Check for duplicate schedule or time conflict here (to be implemented)
        // Example: if (model.hasScheduleConflict(person, date, time))
        // { throw new CommandException(MESSAGE_DUPLICATE_SCHEDULE); }

        // Add the schedule to the model (to be implemented)
        // Example: model.addSchedule(person, name, date, time);

        return new CommandResult(String.format(MESSAGE_SUCCESS, name + " on " + date + " at " + time));
    }

}
