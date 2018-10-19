package stack_and_queue.animal_shelter

import spock.lang.Specification

class AnimalShelterTest extends Specification {
    def shelter
    def dog1, dog2, dog3, cat1, cat2, cat3

    def setup(){
        shelter = new AnimalShelter()
        dog1 = new Dog("dog1")
        dog2 = new Dog("dog2")
        dog3 = new Dog("dog3")
        cat1 = new Cat("cat1")
        cat2 = new Cat("cat2")
        cat3 = new Cat("cat3")
    }

    def "emptyAll"() {
        when:
        shelter.dequeueAny()

        then:
        thrown(EmptyAnimalShelterException.class)
    }

    def "emptyDogs"() {
        when:
        shelter.dequeueDog()

        then:
        thrown(NoDogsException.class)
    }

    def "emptyCats"() {
        when:
        shelter.dequeueCat()

        then:
        thrown(NoCatsException.class)
    }

    def "dequeueAny"() {
        when:
        shelter.enqueue(dog1)
        shelter.enqueue(cat1)
        shelter.enqueue(dog2)
        shelter.enqueue(cat2)
        shelter.enqueue(dog3)
        shelter.enqueue(cat3)

        then:
        dog1 == shelter.dequeueAny()
        cat1 == shelter.dequeueAny()
        dog2 == shelter.dequeueAny()
        cat2 == shelter.dequeueAny()
        dog3 == shelter.dequeueAny()
        cat3 == shelter.dequeueAny()
    }

    def "dequeueDogs"() {
        when:
        shelter.enqueue(dog1)
        shelter.enqueue(cat1)
        shelter.enqueue(dog2)
        shelter.enqueue(cat2)
        shelter.enqueue(dog3)
        shelter.enqueue(cat3)

        then:
        dog1 == shelter.dequeueDog()
        dog2 == shelter.dequeueDog()
        dog3 == shelter.dequeueDog()
    }

    def "dequeueCats"() {
        when:
        shelter.enqueue(dog1)
        shelter.enqueue(cat1)
        shelter.enqueue(dog2)
        shelter.enqueue(cat2)
        shelter.enqueue(dog3)
        shelter.enqueue(cat3)

        then:
        cat1 == shelter.dequeueCat()
        cat2 == shelter.dequeueCat()
        cat3 == shelter.dequeueCat()
    }
}
