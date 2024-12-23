package itmo.proga.item;

import itmo.proga.interfaces.Breakable;

import java.util.Objects;

public abstract class Item implements Breakable {
    private final String title;
    private boolean isBroken;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void breakItem() {
        this.isBroken = true;
        System.out.print("Трах-та-ра-рах! ");
    }

    @Override
    public boolean isBroken() {
        return isBroken;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", isBroken=" + isBroken +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return isBroken() == item.isBroken() && Objects.equals(getTitle(), item.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), isBroken());
    }
}
