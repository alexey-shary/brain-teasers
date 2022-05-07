package xyz.my;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BasketballTeams {
    public Set<TeamPair> allTeams(String[] players) {
        Set<TeamPair> pairs = new HashSet<>();
        selectTeam(pairs, players, new HashSet<>(), new HashSet<>(), 0);
        return pairs;
    }

    private void selectTeam(Set<TeamPair> pairs, String[] players, Set<String> first, Set<String> second, int index) {
        if (index == players.length) {
            if (Math.abs(first.size() - second.size()) <= 1) {
                pairs.add(new TeamPair(first, second));
            }
            return;
        }
        first.add(players[index]);
        selectTeam(pairs, players, first, second, index + 1);
        first.remove(players[index]);
        if (index != 0) { // small optimization of putting the first player to the first team only
            second.add(players[index]);
            selectTeam(pairs, players, first, second, index + 1);
            second.remove(players[index]);
        }
    }
}

class TeamPair {
    Set<String> firstTeam;
    Set<String> secondTeam;

    public TeamPair(Set<String> firstTeam, Set<String> secondTeam) {
        this.firstTeam = new HashSet<>(firstTeam);
        this.secondTeam = new HashSet<>(secondTeam);
    }

    public boolean equals(Object obj) {
        TeamPair pair = (TeamPair) obj;
        return firstTeam.equals(pair.firstTeam) && secondTeam.equals(pair.secondTeam) || firstTeam.equals(pair.secondTeam) && secondTeam.equals(pair.firstTeam);
    }

    public int hashCode() {
        return firstTeam.hashCode() ^ secondTeam.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team 1: ");
        sb.append(firstTeam.stream().collect(Collectors.joining(" & ")));
        sb.append(" VS Team 2: ");
        sb.append(secondTeam.stream().collect(Collectors.joining(" & ")));
        return sb.toString();
    }
}