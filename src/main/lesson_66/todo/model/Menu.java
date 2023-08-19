package main.lesson_66.todo.model;

public enum Menu {

    LIST(1), ADD(2), FIND(3), REMOVE(4), EXIT(5);

    private final int menuItem;

    // конструктор
    Menu(int menuItem) {
        this.menuItem = menuItem;
    }

    public int getMenuItem() {
        return menuItem;
    }

    public static void printMenu() {
        Menu[] menu = Menu.values();
        for (Menu value : menu) {
            System.out.print(value.menuItem + " - " + value + "|");
        }
    }
}
