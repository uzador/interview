package stack_and_queue.animal_shelter;

import java.util.LinkedList;

public class AnimalShelter {
    private final LinkedList<Animal> all = new LinkedList<>();
    private final LinkedList<Dog> dogs = new LinkedList<>();
    private final LinkedList<Cat> cats = new LinkedList<>();

    void enqueue(Animal animal) {
        all.offerLast(animal);
        if (animal instanceof Dog) {
            dogs.offerLast((Dog) animal);
        } else {
            cats.offerLast((Cat) animal);
        }
    }

    Animal dequeueAny() {
        if (isEmpty()) {
            throw new EmptyAnimalShelterException();
        }

        final Animal animal = all.pollFirst();
        if (animal instanceof Dog) {
            dogs.pollFirst();
        } else {
            cats.pollFirst();
        }

        return animal;
    }

    Dog dequeueDog() {
        if (isDogsEmpty()) {
            throw new NoDogsException();
        }

        all.pollFirst();
        return dogs.pollFirst();
    }

    Cat dequeueCat() {
        if (isCatsEmpty()) {
            throw new NoCatsException();
        }

        all.pollFirst();
        return cats.pollFirst();
    }

    private boolean isEmpty() {
        return all.size() == 0;
    }

    private boolean isDogsEmpty() {
        return dogs.size() == 0;
    }

    private boolean isCatsEmpty() {
        return cats.size() == 0;
    }
}
