import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.java.basic.io.App;

public class AppTest {

  @Test
  public void testMain() {
    Assertions.assertDoesNotThrow(() -> {
      App.main(new String[]{});
    });
  }
}
