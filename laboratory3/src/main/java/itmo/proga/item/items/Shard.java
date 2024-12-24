package itmo.proga.item.items;

import itmo.proga.entity.Entity;
import itmo.proga.item.Item;

import java.util.Objects;

public final class Shard extends Item {
    public Shard(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Shard{" +
                "title='" + this.getTitle() + '\'' +
                ", isBroken=" + this.isBroken() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shard shard = (Shard) obj;
        return isBroken() == shard.isBroken() && Objects.equals(getTitle(), shard.getTitle());
    }

    public void hook(Entity entity) {
        System.out.print(this.getTitle() + " зацепить " + entity.getName() + " ");
    }

    public void crack(Entity entity) {
        System.out.print(this.getTitle() + " треснуть " + entity.getName() + " ");
    }
}
