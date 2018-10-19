package stack_and_queue.animal_shelter;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog: " + name;
    }
}
