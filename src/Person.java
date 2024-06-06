import java.util.*;

class Player implements Comparable<Player> {
    String name;
    String position;

    // Body measurements
    double height; // In inches
    int weight; // in lbs
    int wingspan; // In inches
    double handLength; // In Inches
    double handWidth; // In inches

    String team;

    // Quantitative Metrics
    double pointsPerGame;
    double reboundsPerGame;
    double assistsPerGame;
    double stealsPerGame;
    double fieldGoalPercentage;
    double threePointPercentage;
    double freeThrowPercentage;

    Player(String name, String position, int height, int weight, int wingspan, double handLength, String team,
           double pointsPerGame, double reboundsPerGame, double assistsPerGame, double stealsPerGame,
           double fieldGoalPercentage, double threePointPercentage, double freeThrowPercentage) {
        this.pointsPerGame = pointsPerGame;
        this.reboundsPerGame = reboundsPerGame;
        this.assistsPerGame = assistsPerGame;
        this.stealsPerGame = stealsPerGame;
        this.fieldGoalPercentage = fieldGoalPercentage;
        this.threePointPercentage = threePointPercentage;
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public int compareTo(Player other) {
        return Double.compare(other.calculateScore(), this.calculateScore());
    }

    public double calculateScore() {
        double score = 0;
        score += this.pointsPerGame * 0.4;
        score += this.reboundsPerGame * 0.15;
        score += this.assistsPerGame * .10;
        score += this.stealsPerGame * .10;
        score += this.fieldGoalPercentage * .20;
        score += this.threePointPercentage * .15;
        score += this.freeThrowPercentage * .05;
        score += this.height * .10;
        score += this.weight * .04;
        score += this.wingspan * .2;
        score += this.handLength * .02;
        score += this.handWidth * .02;
        return score;
    }

    // toString method to print player details
}