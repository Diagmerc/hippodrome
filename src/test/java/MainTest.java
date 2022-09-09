import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Test disabled")
class MainTest {

    @Test
    @Timeout(22)
    void main() throws Exception {
        Main.main(null);
    }
}