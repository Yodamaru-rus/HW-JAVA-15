import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {

        if (!players.containsKey(playerName1)) {
            throw new NotFoundException("User with id: " + playerName1 + " Not registered.");
        } else if (!players.containsKey(playerName2)) {
            throw new NotFoundException("User with id: " + playerName2 + " Not registered.");
        }

        if (players.get(playerName1).getStrength() > players.get(playerName2).getStrength()) {
            return 1;
        } else if (players.get(playerName1).getStrength() < players.get(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
