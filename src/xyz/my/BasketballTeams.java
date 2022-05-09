package xyz.my;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class BasketballTeams {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkAllTeamsRecursive(BenchmarkState benchmarkState) {
        allTeamsRecursive(benchmarkState.players);
    }

    /**
     * Solved by me.
     */
    public Set<TeamPair> allTeamsRecursive(String[] players) {
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

    /* ############################################################################################################# */

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkAllTeamsIterative(BenchmarkState benchmarkState) {
        allTeamsIterative(benchmarkState.players);
    }

    /**
     * Solved by Vladimir.
     */
    public Set<TeamPair> allTeamsIterative(String[] players) {
        Set<TeamPair> result = new HashSet<>();
        final int N = players.length - 1;
        int[] teamAIndexes = new int[players.length / 2];
        int[] teams = new int[players.length];
        for (int i = 0; i < teamAIndexes.length; i++)
            teamAIndexes[i] = i;
        int offset, index, value;
        int limit_for_first_A_player_index = players.length % 2 == 0 ? 1 : N / 2 + 2;
        while (teamAIndexes[0] < limit_for_first_A_player_index) {
            Set<String> teamAPlayers = new HashSet<>();
            Set<String> teamBPlayers = new HashSet<>();
            Arrays.fill(teams, 0);
            for (int i = 0; i < teamAIndexes.length; i++)
                teams[teamAIndexes[i]] = 1;
            for (int i = 0; i < teams.length; i++)
                if (teams[i] == 1)
                    teamAPlayers.add(players[i]);
                else
                    teamBPlayers.add(players[i]);
            result.add(new TeamPair(teamAPlayers, teamBPlayers));

            if (teamAIndexes[teamAIndexes.length - 1] < N) {
                teamAIndexes[teamAIndexes.length - 1]++;
                continue;
            }
            offset = 0;
            while (teamAIndexes[teamAIndexes.length - 1 - offset] == N - offset && teamAIndexes.length - 1 - offset > 0)
                offset++;
            index = teamAIndexes.length - 1 - offset;
            teamAIndexes[index]++;
            value = teamAIndexes[index] + 1;
            for (int i = index + 1; i < teamAIndexes.length; i++) {
                teamAIndexes[i] = value++;
            }
        }
        return result;
    }

    @State(Scope.Thread)
    public static class BenchmarkState {
        String[] players;

        @Setup(Level.Iteration)
        public void setup() {
            players = new String[]{ "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10" };
        }

        @TearDown(Level.Iteration)
        public void tearDown() {
            players = null;
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