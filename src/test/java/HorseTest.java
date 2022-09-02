import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void construtorTestWhenFirstParameterNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 2);
        });
    }
    @Test
    void messageTestWhenFirstParameterNull(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 2);
        });
        assertEquals("Name cannot be null.", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "    "})
    void TestWhenFirstParameterWhiteSpace(String str){
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(str, 2);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "    "})
    void messageTestWhenFirstParameterWhiteSpace(String str){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(str, 2);
        });
        assertEquals("Name cannot be blank.", illegalArgumentException.getMessage());
    }
    @Test
    void construtorTestWhenSecondParameterNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Bruno", -2);
        });
    }
    @Test
    void construtorTestWhenThirdParameterNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Bruno", 2,-3);
        });
    }
    @Test
    void messageTestWhenThirdParameterNegative(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Bruno", 2,-3);
        });
        assertEquals("Distance cannot be negative.", illegalArgumentException.getMessage());
    }

    @Test
    void getName() {
        assertEquals("Black" ,new Horse("Black", 2.0, 3).getName());
    }

    @Test
    void getSpeed() {
        assertEquals(2.0, new Horse("Black", 2.0, 3).getSpeed());
    }

    @Test
    void getDistance() {
        assertEquals(3, new Horse("Black", 2.0, 3).getDistance());
        assertEquals(0, new Horse("Black", 2.0)
                .getDistance());
    }

    @Test
    void returnValueForMoveTest() {// TODO: 24.08.2022 тут дописать 
        try (MockedStatic<Horse>horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse("Bruno", 2);
            horseMockedStatic.when(horse::move).thenReturn(10);
            assertEquals(10,Horse.getRandomDouble(0.2,0.9));
        }
    }
    @Test
    void invokeStaticMethodForMoveTest() {
        try (MockedStatic<Horse>horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse("Bruno", 2);
            horse.move();
            horseMockedStatic.verify(()->Horse.getRandomDouble(0.2,0.9));
        }
    }
}