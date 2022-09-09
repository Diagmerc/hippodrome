import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    void exeptionWhenConstructorArgNull(){
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
    }
    @Test
    void messageWhenConstructorArgNull(){
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }
    @Test
    void exeptionWhenConstructorArgListEmpty(){
        List<Horse> horses = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(horses));
    }
    @Test
    void messageWhenConstructorArgListEmpty(){
        List<Horse> horses = new ArrayList<>();
        IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(horses));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        assertIterableEquals(testHorses, hippodrome.getHorses());
    }

    @Test
    void move() {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (Horse hors : horses) {
            verify(hors).move();
        }
    }

    @Test
    void getWinner() {
        Horse django = new Horse("Django", 1.4);
        Horse saharok = new Horse("Saharok", 2.5,6);
        Horse black = new Horse("Black", 3.6,3);
        Horse fire = new Horse("Fire", 4.7,7);
        Horse lobster = new Horse("Lobster", 5.8,8);
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(django);
        horses.add(saharok);
        horses.add(black);
        horses.add(fire);
        horses.add(lobster);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(lobster, hippodrome.getWinner());
    }
}