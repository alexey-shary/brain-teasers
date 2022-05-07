package xyz.my;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;

public class BasketballTeamsTest {
    @Test
    public void testAllPairs() {
        long start = Instant.now().toEpochMilli();
        BasketballTeams bt = new BasketballTeams();
        String[] players = new String[]{ "Alexey", "Олександр", "Andriy", "Misha", "Vasyl", "Svetlana", "Bogdan", "Victoria", "Aleksei", "Pavel"};
        // for (int i = 0; i < 10000; i++) {
            Set<TeamPair> result = bt.allTeams(players);
        // }
        for (TeamPair tp : result) {
            System.out.println(tp);
        }
        System.out.println("\nTotal number of all possible games with every distinct team: " + result.size() + " (for " + players.length + " players)");
        System.out.println(Instant.now().toEpochMilli() - start + " milliseconds");
    }
}
