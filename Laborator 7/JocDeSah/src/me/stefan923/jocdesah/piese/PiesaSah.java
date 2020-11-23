package me.stefan923.jocdesah.piese;

public interface PiesaSah {

    boolean move(int coordX, int coordY, PiesaSah[][] table);

    Team getTeam();

    int getCoordX();

    int getCoordY();

    default boolean isObstacle(PiesaSah[][] table, int x1, int x2, int y1, int y2) {
        if (y1 == y2) {
            for (int i = Math.min(x1, x2) + 1; i < Math.max(x1, x2); ++i)
                if (table[i][y1] != null)
                    return true;
        } else if (x1 == x2) {
            for (int i = Math.min(y1, y2) + 1; i < Math.max(y1, y2); ++i)
                if (table[x1][i] != null)
                    return true;
        } else while (true) {
            if (x1 > x2)
                --x1;
            else
                ++x1;
            if (y1 > y2)
                --y1;
            else
                ++y1;
            if (x1 == x2)
                break;
            if (table[x1][y1] != null)
                return true;
        }
        return false;
    }

}
