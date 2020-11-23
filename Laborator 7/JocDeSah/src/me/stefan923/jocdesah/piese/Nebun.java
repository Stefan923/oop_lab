package me.stefan923.jocdesah.piese;

public class Nebun implements PiesaSah {

    private final Team team;

    private int coordX;
    private int coordY;

    public Nebun(int coordX, int coordY, Team team) {
        this.coordX = coordX;
        this.coordY = coordY;

        this.team = team;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public int getCoordX() {
        return coordX;
    }

    @Override
    public int getCoordY() {
        return coordY;
    }

    @Override
    public boolean move(int coordX, int coordY, PiesaSah[][] table) {
        if (table[coordX][coordY] != null && table[coordX][coordY].getTeam() == team) {
            return false;
        }

        if (this.coordX != coordX && (this.coordX - this.coordY == coordX - coordY
                || this.coordX + this.coordY == coordX + coordY)) {
            return !isObstacle(table, this.coordX, coordX, this.coordY, coordY);
        }

        return false;
    }
}
