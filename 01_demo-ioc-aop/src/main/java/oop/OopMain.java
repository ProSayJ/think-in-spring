package oop;

import oop.support.Dog;
import oop.support.Horse;
import oop.support.Pig;

/**
 * OOP三⼤特征：封装、继承和多态
 * oop是⼀种垂直继承体系
 * OOP编程思想可以解决⼤多数的代码重复问题，但是有⼀些情况是处理不了的，⽐如下⾯的在顶级⽗类
 * Animal中的多个⽅法中相同位置出现了重复代码，OOP就解决不了。AOP实现是可以做到的
 * <p>
 * 在不改变原有业务逻辑情况下，增强横切逻辑代码，根本上解耦合，避免横切逻辑代码重复
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class OopMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.run();

        Horse horse = new Horse();
        horse.eat();
        horse.run();

        Pig pig = new Pig();
        pig.eat();
        pig.run();
    }
}
