public class TestAnimals {
    public static void main(String[] args) {
        // Test Cat
        Cat cat = new Cat("Whiskers");
        cat.greets();
        
        // Test Dog
        Dog dog1 = new Dog("Buddy");
        Dog dog2 = new Dog("Max");
        dog1.greets();
        dog1.greets(dog2);
        
        // Test BigDog
        BigDog bigDog1 = new BigDog("Bear");
        BigDog bigDog2 = new BigDog("Titan");
        bigDog1.greets();
        bigDog1.greets(dog1);
        bigDog1.greets(bigDog2);
        
        // Polymorphism demonstration
        Animal[] animals = {
            new Cat("Mittens"),
            new Dog("Rex"),
            new BigDog("King")
        };
        
        System.out.println("\nPolymorphic greetings:");
        for (Animal animal : animals) {
            animal.greets();
        }
    }
}