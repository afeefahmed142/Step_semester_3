import java.util.Arrays;

public class FantasyLeague {

    static class Player implements Comparable<Player> {

        // Encapsulation
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(String name,
                      int matchesPlayed,
                      double battingAverage,
                      boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Overloaded method 1
        static boolean isDraftable(int matchesPlayed) {

            return matchesPlayed >= 10;
        }

        // Overloaded method 2
        static boolean isDraftable(int matchesPlayed,
                                    boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        // Fantasy points
        double getFantasyPoints() {

            return matchesPlayed * battingAverage;
        }

        // Sort in descending order
        @Override
        public int compareTo(Player other) {

            return Double.compare(
                other.getFantasyPoints(),
                this.getFantasyPoints()
            );
        }

        public String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable =
                new Player[players.length];

        int count = 0;

        // Find draftable players
        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                           player.matchesPlayed,
                           player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        // Create exact-size array
        Player[] finalList =
                Arrays.copyOf(draftable, count);

        // Sort using compareTo()
        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result +
                     (i + 1) + ". " +
                     finalList[i].getName();

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
            draftAndRank(players)
        );
    }
}