package itmo.proga;

import itmo.proga.entity.character.Character;
import itmo.proga.entity.character.characters.*;
import itmo.proga.enums.unusable.*;
import itmo.proga.exceptions.NoMoreSeatsAvailable;
import itmo.proga.item.Item;
import itmo.proga.item.items.Shard;
import itmo.proga.item.items.vehicle.Vehicle;

// вариант 345346.8
public class Main {
    public static void main(String[] args) throws NoMoreSeatsAvailable {
        // TODO Make Main
        Vehicle vehicle1 = new Vehicle("Машина", 50);

        Character vintik = new Character("Винтик") {
            @Override
            public boolean isCanDrive() {
                return false;
            }
        };
        Character shpuntik = new Character("Шпунтик") {
            @Override
            public boolean isCanDrive() {
                return false;
            }
        };
        Driver toropishka = new Driver("Торопыжка");
        vehicle1.setDriver(toropishka);
        Passenger syropchik = new Passenger("Сиропчик");
        vehicle1.addPassenger(syropchik);
        Driver neznaika = new Driver("Незнайка");

        Shorty shorty = new Shorty("Коротышки");
        shorty.addCharacter(new Character("Знайка") {
            @Override
            public boolean isCanDrive() {
                return false;
            }
        });
        shorty.addCharacter(new Character("Авоська") {
            @Override
            public boolean isCanDrive() {
                return false;
            }
        });
        shorty.addCharacter(new Character("доктор Пилюлькин") {
            @Override
            public boolean isCanDrive() {
                return false;
            }
        });
        shorty.addCharacter(vintik);

        Item booth = new Item("Будка");
        Item gazebo = new Item("Беседка");
        Shard board1 = new Shard("Доска");
        Shard board2 = new Shard("Доска");
        Dog dog = new Dog("Булька");

        vehicle1.setDriver(toropishka);
        System.out.println("" + Words.BIG_SUCH + vehicle1.getTypeCar() + " автомобили " + Words.WERE + Words.VERY + "распространены среди коротышек" + PunctuationMarks.DOT);
        System.out.println("" + Words.BIG_BUT + Words.IN + vehicle1.getTitle() + PunctuationMarks.COMMA + "который " + vintik.build() + vintik.getName() + Words.AND + shpuntik.getName() + PunctuationMarks.COMMA + Words.HAD + Words.ONE + Words.VERY + "важное усовершентсвование: сбоку к баку " + Words.WAS + " приделана гибкая резиновая трубка с краником" + PunctuationMarks.COMMA + "для того чтобы можно было попить " + (vehicle1.getFuelType().isEdible() ? "можно было попить " + vehicle1.getFuelType() : "нельзя было попить " + vehicle1.getFuelType()) + "на ходу" + PunctuationMarks.COMMA + "не " + vehicle1.stop() + vehicle1.getTitle() + PunctuationMarks.DOT);
        System.out.println(toropishka.learnDrive() + PunctuationMarks.COMMA + Words.AND + PunctuationMarks.COMMA + Words.IF + Words.SOMEONE + "хотелось покататься " + PunctuationMarks.COMMA + toropishka.drive() + Words.AND + Words.NOBODY + "не "+ toropishka.decline() + PunctuationMarks.DOT);
        System.out.println("Больше всех " + syropchik.love() + Words.ON + vehicle1.getTitle() + PunctuationMarks.COMMA + Words.BECAUSE + "во время поездки он " + (vehicle1.getFuelType().isEdible() ? syropchik.can() + syropchik.drink() : "не " + syropchik.can() + syropchik.drink()) + "сколько угодно " + vehicle1.getFuelType() + PunctuationMarks.DOT);

        vehicle1.removePassenger(syropchik);

        System.out.println(neznaika.getName() + Words.TOO + neznaika.love() + neznaika.ride() + Words.ON + vehicle1.getTitle() + PunctuationMarks.COMMA + Words.AND + "часто его " + toropishka.drive() + PunctuationMarks.DOT);
        System.out.println(Words.BIG_BUT + neznaika.getName() + neznaika.wantTo() + neznaika.learnDrive() + PunctuationMarks.COMMA + Words.AND + "он " + neznaika.ask(toropishka) + PunctuationMarks.COLON + Words.BIG_ONCE + PunctuationMarks.COMMA + "когда " + toropishka.getName() + "не " + Words.WAS + "дома" + PunctuationMarks.COMMA + neznaika.getName() + neznaika.getIntoCar(vehicle1) + PunctuationMarks.COMMA + "который стоял во дворе " + PunctuationMarks.COMMA + Words.AND + (neznaika.becomeDriver().pullLevers() + Words.AND + neznaika.becomeDriver().pressPedals()) + PunctuationMarks.DOT);

        Driver neznaikaDriver = neznaika.becomeDriver();
        vehicle1.setDriver(neznaikaDriver);

        System.out.println(Words.BIG_FIRSTLY + "у него " + Words.NOTHING + "не " + neznaikaDriver.workingOut() + Words.THEN + Words.SUDDENLY + vehicle1.getTitle() + vehicle1.snort() + vehicle1.drive() + PunctuationMarks.DOT);
        System.out.println("Коротышки " + shorty.see() + "это " + Words.IN + "окно " + Words.AND + shorty.runOut() + Words.FROM + "дома" + PunctuationMarks.DOT);
        System.out.println(booth.breakItem() + booth.getTitle() + "рассыпалась в щепки" + PunctuationMarks.DOT);
        System.out.println("Хорошо " + Words.MORE + PunctuationMarks.COMMA + "что " + dog.name() + dog.jumpOut() + PunctuationMarks.COMMA + Words.A + "то " + vehicle1.crush(dog) + PunctuationMarks.DOT);
        System.out.println(neznaikaDriver.getName() + neznaikaDriver.frightened() + PunctuationMarks.COMMA + neznaikaDriver.wantTo() + vehicle1.stop() + vehicle1.getTitle() + Words.AND + neznaikaDriver.pullLevers() + PunctuationMarks.DOT);
        System.out.println(Words.BIG_BUT + vehicle1.getTitle() + PunctuationMarks.COMMA + Words.INSTEADOF + "того чтобы " + vehicle1.stop() + PunctuationMarks.COMMA + vehicle1.accelerate() + PunctuationMarks.DOT);
        System.out.println("На дороге попалась " + gazebo.getTitle() + PunctuationMarks.DOT);
        System.out.println(gazebo.breakItem() + gazebo.getTitle() + "рассыпалась на кусочки " + PunctuationMarks.DOT);
        System.out.println(neznaikaDriver.getName() + "с ног до головы забросало щепками" + PunctuationMarks.DOT);
        System.out.println("Одна " + board1.getTitle() + board1.crack(neznaikaDriver) + PunctuationMarks.COMMA + board2.hook(neznaikaDriver) + PunctuationMarks.DOT);
        System.out.println(neznaikaDriver.grabSteeringWheel() + Words.AND + neznaikaDriver.turn() + PunctuationMarks.DOT);
        System.out.println(vehicle1.getTitle() + vehicle1.accelerate() + "по двору" + PunctuationMarks.COMMA + Words.A + neznaikaDriver.getName() + neznaikaDriver.shout() + PunctuationMarks.COLON + "Коротышки " + syropchik.openFence() + PunctuationMarks.COMMA + neznaikaDriver.drive() + "со двора " + Words.AND + vehicle1.accelerate() + "по улице" + PunctuationMarks.DOT);
        System.out.println("Услышав шум" + PunctuationMarks.COMMA + "со всех дворов " + shorty.runOut() + shorty.getName() + PunctuationMarks.DOT);
        System.out.println(shorty.getCharacter("Знайка").getName() + PunctuationMarks.COMMA + shorty.getCharacter("Авоська").getName() + PunctuationMarks.COMMA + shorty.getCharacter("Винтик").getName() + PunctuationMarks.COMMA + shorty.getCharacter("доктор Пилюлькин").getName() + Words.AND + "другие " + shorty.getName() + shorty.runOut() + "за ним" + PunctuationMarks.DOT);
        System.out.println(Words.BIG_BUT + "где там" + PunctuationMarks.EXCLAMATION_MARK);
        System.out.println("Они не " + shorty.can() + "его " + shorty.catchUp() + PunctuationMarks.DOT);
//        System.out.println(syropchik.consume(10));
    }
}