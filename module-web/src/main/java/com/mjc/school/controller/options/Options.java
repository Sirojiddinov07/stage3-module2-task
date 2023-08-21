package com.mjc.school.controller.options;

public class Options {
    private Options() {}

    public static final String START_MENU_TEXT = "Choose an option:\n" +
            "1 - View all news\n" +
            "2 - View all authors\n" +
            "3 - View news by ID\n" +
            "4 - View author by ID\n" +
            "5 - Create news\n" +
            "6 - Create author\n" +
            "7 - Update news\n" +
            "8 - Update author\n" +
            "9 - Delete news by ID\n" +
            "10 - Delete author by ID\n" +
            "0 - Exit";

    public static final String AUTHOR = "Author";
    public static final String NEWS = "News";

    public static final String ENTER_ID = "Enter news ID:";
    public static final String ENTER_TITLE = "Enter title:";
    public static final String ENTER_CONTENT = "Enter content:";
    public static final String ENTER_AUTHOR_ID = "Enter author ID:";
    public static final String ENTER_AUTHOR_NAME = "Enter author name:";

    public static final String OPERATION_VIEW_ALL = "Viewing all %s.";
    public static final String OPERATION_VIEW_BY_ID = "Viewing %s by ID.";
    public static final String OPERATION_CREATE = "Creating %s.";
    public static final String OPERATION_UPDATE = "Updating %s.";
    public static final String OPERATION_DELETE = "Deleting %s.";
    public static final String OPERATION_EXIT = "Goodbye!";
    public static final String OPERATION_ERROR = "Invalid command!";
}

