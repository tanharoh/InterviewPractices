package A04_DogCatQueue;

/**
 * Page 10
 * */
public class Main {
    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Cat());


        System.out.println(dogCatQueue.pollDog().getPetType());
        System.out.println(dogCatQueue.pollCat().getPetType());

        System.out.println("isDogCatQueueEmpty: " + dogCatQueue.isEmpty());
        System.out.println("isDogQueueEmpty: " + dogCatQueue.isDogQueueEmpty());
        System.out.println("isCatQueueEmpty: " + dogCatQueue.isCatQueueEmpty());

        System.out.println(dogCatQueue.pollAll().getPetType());
        System.out.println(dogCatQueue.pollAll().getPetType());


    }

}
