package me.stefan923.jocdesah.piese;

public class Pion implements PiesaSah {

    private final Team team;

    private int coordX;
    private int coordY;

    public Pion(int coordX, int coordY, Team team) {
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
        int direction = (team == Team.WHITE) ? -1 : 1;

        if (this.coordY == coordY && table[coordX][coordY] == null
                && !isObstacle(table, this.coordX, coordX, this.coordY, coordY)
                && (this.coordX - coordX == direction
                || (this.coordX - coordX == direction * 2
                && (team == Team.WHITE && this.coordX == 2
                || (team == Team.BLACK && this.coordX == 7))))) {
            this.coordX = coordX;
            this.coordY = coordY;

            return true;
        } else if (Math.abs(this.coordY - coordY) == 1
                && this.coordX - coordX == direction
                && table[coordX][coordY] != null
                && table[coordX][coordY].getTeam() != team) {
            this.coordX = coordX;
            this.coordY = coordY;

            return true;
        }

        return false;
    }
}
