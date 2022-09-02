import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    List<Horse> testHorses = List.of(
            new Horse("Django", 1.4),
            new Horse("Saharok", 2.5),
            new Horse("Black", 3.6),
            new Horse("Fire", 4.7),
            new Horse("Lobster", 5.8),
            new Horse("Pegas", 6.9),
            new Horse("Cherry", 7),
            new Horse("Butterfly", 8,20),
            new Horse("Ball", 9),
            new Horse("Grey", 10),
            new Horse("Beauty", 11),
            new Horse("Green", 12),
            new Horse("Vasya", 13),
            new Horse("Pepel", 14),
            new Horse("Novosibirsk", 15,10),
            new Horse("Labrador", 16),
            new Horse("Cahalin", 17),
            new Horse("FireFly", 18),
            new Horse("Victory", 19),
            new Horse("Bombei", 20),
            new Horse("Polermo", 21),
            new Horse("Topol", 22),
            new Horse("Plotva", 23),
            new Horse("Totilas", 24,3),
            new Horse("Vasilek", 25,8),
            new Horse("Carbon", 26),
            new Horse("Mercedes", 27),
            new Horse("Pinto", 28),
            new Horse("Crab", 29),
            new Horse("Buket", 30)
    );
    Hippodrome hippodrome = new Hippodrome(testHorses);

    @Test
    void getHorses() {
        assertIterableEquals(testHorses, hippodrome.getHorses());
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
        assertEquals(20, hippodrome.getWinner());
    }
}