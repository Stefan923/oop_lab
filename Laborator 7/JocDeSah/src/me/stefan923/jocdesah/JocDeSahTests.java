package me.stefan923.jocdesah;

import me.stefan923.jocdesah.piese.PiesaSah;
import me.stefan923.jocdesah.piese.Pion;
import me.stefan923.jocdesah.piese.Regina;
import me.stefan923.jocdesah.piese.Team;

import org.junit.Assert;
import org.junit.Test;

public class JocDeSahTests {

    @Test
    public void testPiese() {
        PiesaSah[][] table = new PiesaSah[8][8];
        table[2][1] = new Pion(2, 1, Team.WHITE);
        table[3][1] = new Pion(3, 1, Team.BLACK);
        table[3][2] = new Pion(3, 2, Team.BLACK);
        table[5][4] = new Regina(5, 4, Team.BLACK);
        table[3][7] = new Regina(3, 7, Team.WHITE);

        Assert.assertFalse(table[2][1].move(3, 1, table));
        Assert.assertFalse(table[2][1].move(4, 1, table));
        Assert.assertFalse(table[2][1].move(1, 1, table));
        Assert.assertTrue(table[2][1].move(3, 2, table)); // captura
        table[3][2] = table[2][1];
        table[2][1] = null;

        Assert.assertFalse(table[3][7].move(3, 2, table)); // captura pe aceeasi echipa (nu se muta)
        Assert.assertTrue(table[5][4].move(3, 2, table)); // captura
        table[3][2] = table[5][4];
        table[5][4] = null;
        Assert.assertTrue(table[3][7].move(3, 2, table)); // captura
        table[3][2] = table[3][7];
        table[3][7] = null;
    }

}
