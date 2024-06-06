import java.util.*;

class Player implements Comparable<Player> {
    String name;
    String position;

    // Body measurements
    double height; // In inches
    double weight; // in lbs
    double wingspan; // In inches
    double handLength; // In Inches
    double handWidth; // In inches
    double standingReach; // In inches

    String team;

    // Quantitative Metrics
    double pointsPerGame;
    double reboundsPerGame;
    double assistsPerGame;
    double stealsPerGame;
    double blocksPerGame;
    double fieldGoalPercentage;
    double threePointPercentage;
    double freeThrowPercentage;

    Player(String name, String position, double height, double weight, double wingspan, double handLength, double handWidth, double standingReach,
           double pointsPerGame, double reboundsPerGame, double assistsPerGame, double stealsPerGame, double blocksPerGame,
           double fieldGoalPercentage, double threePointPercentage, double freeThrowPercentage) {
        this.name = name;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.wingspan = wingspan;
        this.handLength = handLength;
        this.handWidth = handWidth;
        this.standingReach = standingReach;
        this.pointsPerGame = pointsPerGame;
        this.reboundsPerGame = reboundsPerGame;
        this.assistsPerGame = assistsPerGame;
        this.stealsPerGame = stealsPerGame;
        this.blocksPerGame = blocksPerGame;
        this.fieldGoalPercentage = fieldGoalPercentage;
        this.threePointPercentage = threePointPercentage;
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public int compareTo(Player other) {
        return Double.compare(other.calculateScore(), this.calculateScore());
    }

    public double calculateScore() {
        double score = 0;
        score += this.pointsPerGame * 0.261;
        score += this.reboundsPerGame * 0.098;
        score += this.assistsPerGame * .065;
        score += this.stealsPerGame * .065;
        score += this.fieldGoalPercentage * .131;
        score += this.threePointPercentage * .098;
        score += this.freeThrowPercentage * .033;
        score += this.height * .065;
        score += this.weight * .026;
        score += this.wingspan * .131;
        score += this.handLength * .013;
        score += this.handWidth * .013;
        return score;
    }

    // toString method to print player details
    @Override
    public String toString() {
        return name + " (" + position + ") " + " Draft Score: " + calculateScore();
    }

    public String name() {
        return this.name;
    }


    // Main
    public static void main(String[] args) {
        Player wemby = new Player("Victor Wembanyama", "C", 89, 210,96,11,12, 116,
                21.4, 10.6, 3.9, 1.2,3.6,  46.5, 32.5, 79.6);

        Player rob = new Player("Rob Dillingham", "PG", 73, 164.2,75, 8, 8.25,95,
                15.2, 2.9, 3.9, 1.0, .1, 47.5, 44.4, 79.6);

        Player alex = new Player("Alexandre Sarr", "C", 83.75, 224.2, 88.25, 9, 10, 110,
                9.7, 4.4, 0.9, .5, 1.3, 52.0, 29.8, 71.4);

        Player zach = new Player("Zach Edey", "C", 87.75, 299, 94.75, 10, 10.75, 115,
                25.2, 12.2, 2,.3, 2.2, 62.3, 50.0, 71.1);

        ArrayList<Player> players = new ArrayList<>();
        players.add(wemby);
        players.add(rob);
        players.add(alex);
        players.add(zach);

        // Display list of players
        for (Player prospect : players) {
            System.out.println(prospect.toString());
        }

        // Player comparison
        System.out.println(comparePlayers(alex, zach));
    }

    public static String comparePlayers(Player p1, Player p2) {
        if (p1.calculateScore() > p2.calculateScore()) {
            return p1.name() + " has a higher draft score than " + p2.name;
        } else {
            return p2.name + " has a higher draft score than " + p1.name;
        }
    }
}