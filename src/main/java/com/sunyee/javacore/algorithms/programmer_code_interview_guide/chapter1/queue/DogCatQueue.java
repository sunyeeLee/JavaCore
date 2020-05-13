package com.sunyee.javacore.algorithms.programmer_code_interview_guide.chapter1.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 *
 * 实现一种狗猫队列的结构，要求如下：
 * ● 用户可以调用add方法将cat类或dog类的实例放入队列中；
 * ● 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * ● 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 * ● 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 * ● 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * ● 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * ● 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *
 *
 * 在构造PetEnterQueue类时，pet是用户原有的实例，count就是这个实例的时间戳。
 * 我们实现的队列其实是 PetEnterQueue 类的实例。大体说来，首先有一个不断累加的数据项，
 * 用来表示实例进队列的时间；同时有两个队列，一个是只放dog类实例的队列dogQ，
 * 另一个是只放cat类实例的队列catQ。在加入实例时，如果实例是dog，就盖上时间戳，
 * 生成对应的PetEnterQueue类的实例，然后放入 dogQ；如果实例是 cat，就盖上时间戳，生成对应的 PetEnterQueue 类的实例，
 * 然后放入catQ。具体过程请参看如下 DogCatQueue类的add方法。只想弹出dog类的实例时，从dogQ里不断弹出即可，
 * 具体过程请参看如下 DogCatQueue类的pollDog方法。只想弹出 cat 类的实例时，从 catQ 里不断弹出即可，
 * 具体过程请参看如下 DogCatQueue类的pollCat方法。想按实际顺序弹出实例时，因为 dogQ的队列头表示所有 dog实例中最早进队列的实例，
 * 同时catQ的队列头表示所有的cat实例中最早进队列的实例。则比较这两个队列头的时间戳，谁更早，就弹出谁。
 * 具体过程请参看如下 DogCatQueue类的pollAll方法。

 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private Long count; //时间戳，记录进入的先后顺序

    public DogCatQueue(){
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        this.count = 0L;
    }

    public void add(Pet pet){
        if ("dog".equals(pet.getPetType())){
            this.dogQueue.add(new PetEnterQueue(pet, this.count++));
        } else if("cat".equals(pet.getPetType())){
            this.catQueue.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("illegal pet type, must dog or cat!");
        }
    }

    public Pet pollAll(){
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()){
            //比较count时间戳
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()){
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }
        } else if (!dogQueue.isEmpty()){
            return dogQueue.poll().getPet();
        } else if (!catQueue.isEmpty()){
            return catQueue.poll().getPet();
        } else {
            throw new RuntimeException("queue is empty!");
        }
    }

    public Pet pollDog(){
        if (!dogQueue.isEmpty()){
            return dogQueue.poll().getPet();
        }
        throw new RuntimeException("queue does not contains the dog!");
    }

    public Pet pollCat(){
        if (!catQueue.isEmpty()){
            return catQueue.poll().getPet();
        }
        throw new RuntimeException("queue does not contains the cat!");
    }

    public boolean isEmpty(){
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }

    public static void main(String[] args) {
        DogCatQueue queue = new DogCatQueue();
        Pet dog = new Dog();
        Pet dog1 = new Dog();
        Pet dog2 = new Dog();
        Pet dog3 = new Dog();
        Pet cat = new Cat();
        Pet cat1 = new Cat();
        queue.add(dog);
        queue.add(dog1);
        queue.add(dog2);
        queue.add(cat);
        queue.add(dog3);
        queue.add(cat1);
        System.out.println(queue.pollDog());
        System.out.println(queue.pollCat());
        System.out.println(queue.pollAll());

    }
}

/**【解答】
* ● cat队列只放cat实例，dog队列只放dog实例，再用一个总队列放所有的实例。错误原因：cat、dog以及总队列的更新问题。
* ● 用哈希表，key表示一个cat实例或dog实例，value表示这个实例进队列的次序。错误原因：不能支持一个实例多次进队列的功能需求，因为哈希表的key只能对应一个value值。
* ● 将用户原有的cat或dog类改写，加一个计数项来表示某一个实例进队列的时间。错误原因：不能擅自改变用户的类结构。
* 本题实现将不同的实例盖上时间戳的方法，但是又不能改变用户本身的类，所以定义一个新的类，具体实现请参看如下的PetEnterQueue类。
*/
class PetEnterQueue{

    private Pet pet;

    private Long count;

    public PetEnterQueue(Pet pet, Long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public Long getCount(){
        return this.count;
    }

    public String getPetEnterQueueType(){
        return this.pet.getPetType();
    }
}

class Pet{
    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }

    @Override
    public String toString(){
        return getPetType();
    }
}

class Dog extends Pet{

    public Dog() {
        super("dog");
    }
}

class Cat extends Pet{

    public Cat() {
        super("cat");
    }
}
