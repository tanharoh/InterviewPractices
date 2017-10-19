package A04_DogCatQueue;

public class Main {
    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(new Pet("cat"));
        dogCatQueue.add(new Pet("dog"));
        dogCatQueue.add(new Pet("dog"));
        dogCatQueue.add(new Pet("cat"));

        System.out.println(dogCatQueue.pollDog().getPetType());
        System.out.println(dogCatQueue.pollCat().getPetType());

        System.out.println("Is DogCatQueue Empty: " + dogCatQueue.isEmpty());
        System.out.println("Is DogQueue Empty: " + dogCatQueue.isDogQueueEmpty());
        System.out.println("Is CatQueue Empty: " + dogCatQueue.isCatQueueEmpty());


    }

}
