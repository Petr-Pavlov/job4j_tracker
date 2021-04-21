package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void WhenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Show all Items" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Show all items ====" + System.lineSeparator() +
                        "Хранилище еще не содержит заявок." + System.lineSeparator() +
                        "Menu:" + System.lineSeparator() +
                        "0. Show all Items" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void WhenByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Found item"));
        Input in = new StubInput(new String[]{"0", item.getName(), "1"});
        String message = item.toString();
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Find Items by Name" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Find items by name ====" + System.lineSeparator() +
                        message + System.lineSeparator() +
                        "Menu:" + System.lineSeparator() +
                        "0. Find Items by Name" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void WhenByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Found item"));
        String id = Integer.toString(item.getId());
        Input in = new StubInput(new String[]{"0", id, "1"});
        String message = item.toString();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Find Item by Id" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Find item by id ====" + System.lineSeparator() +
                        message + System.lineSeparator() +
                        "Menu:" + System.lineSeparator() +
                        "0. Find Item by Id" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }
}
