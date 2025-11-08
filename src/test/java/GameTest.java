import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player user1 = new Player(1, "almost_awake", 5);
    Player user2 = new Player(2, "pixel.noise", 10);
    Player user3 = new Player(3, "casual_vibes", 2);
    Player user4 = new Player(4, "low.battery", 1);
    Player user5 = new Player(5, "not_a.bot", 12);
    Player user6 = new Player(6, "loading.zone", 4);
    Player user7 = new Player(7, "brain_buffering", 5);
    Player user8 = new Player(8, "soft.focus", 10);
    Player user9 = new Player(9, "good_enough", 17);
    Player user10 = new Player(10, "logic_404", 20);

    Game reg = new Game();

    @BeforeEach
    public void setup() {
        reg.register(user1);
        reg.register(user2);
        reg.register(user3);
        reg.register(user4);
        reg.register(user5);
        reg.register(user6);
        reg.register(user7);
        reg.register(user8);
        reg.register(user9);
        reg.register(user10);


    }

    @Test
    public void roundFirstPositive() {
        int expected = 1;

        int actual = reg.round("brain_buffering", "low.battery");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundSecondPositive() {
        int expected = 2;

        int actual = reg.round("not_a.bot", "good_enough");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundDrawPositive() {
        int expected = 0;

        int actual = reg.round("pixel.noise", "soft.focus");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundFirstError() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            reg.round("almast_awake", "loading.zone");
        });
    }

    @Test
    public void roundSecondError() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            reg.round("logic_404", "casual_vibies");
        });

    }


}
