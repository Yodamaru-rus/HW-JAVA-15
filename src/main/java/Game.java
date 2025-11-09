import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) == -1) {
            throw new NotFoundException("User with id: " + playerName1 + " Not registered.");
        } else if (findByName(playerName2) == -1) {
            throw new NotFoundException("User with id: " + playerName2 + " Not registered.");
        }

        if (players.get(findByName(playerName1)).getStrength() > players.get(findByName(playerName2)).getStrength()) {
            return 1;
        } else if (players.get(findByName(playerName1)).getStrength() < players.get(findByName(playerName2)).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public int findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return players.indexOf(player);
            }
        }
        return -1;
    }
}
