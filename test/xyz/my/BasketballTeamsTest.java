package xyz.my;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;

public class BasketballTeamsTest {
    @Test
    //@Disabled
    public void testAllTeamsRecursive() {
        long start = Instant.now().toEpochMilli();
        BasketballTeams bt = new BasketballTeams();
        String[] players = new String[]{ "Alexey", "Олександр", "Andriy", "Misha", "Vasyl", "Svetlana", "Bogdan", "Victoria", "Aleksei", "Pavel" };
        Set<TeamPair> result = bt.allTeamsRecursive(players);
        //for (TeamPair tp : result) {
            //System.out.println(tp);
        //}
        System.out.println("Total number of all possible games with every distinct team: " + result.size() + " (for " + players.length + " players)");
        System.out.println("testAllTeamsRecursive: " + (Instant.now().toEpochMilli() - start) + " milliseconds");
    }

    @Test
    //@Disabled
    public void testAllTeamsIterative() {
        long start = Instant.now().toEpochMilli();
        BasketballTeams bt = new BasketballTeams();
        String[] players = new String[]{ "Alexey", "Олександр", "Andriy", "Misha", "Vasyl", "Svetlana", "Bogdan", "Victoria", "Aleksei", "Pavel" };
        Set<TeamPair> result = bt.allTeamsIterative(players);
        //for (TeamPair tp : result) {
            //System.out.println(tp);
        //}
        System.out.println("Total number of all possible games with every distinct team: " + result.size() + " (for " + players.length + " players)");
        System.out.println("testAllTeamsIterative: " + (Instant.now().toEpochMilli() - start) + " milliseconds");
    }
}
