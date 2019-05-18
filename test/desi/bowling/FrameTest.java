package desi.bowling;

import org.junit.Test;

import static org.junit.Assert.*
        ;

public class FrameTest {

    @Test
    public void testFirstScore() throws WrongScoreException {
        Frame f = new Frame(10,0);
        int score = f.first_throw();
        assertEquals(10,score);
    }

    @Test
    public void testSecondScore() throws WrongScoreException {
        Frame f = new Frame(0,10);
        int score = f.second_throw();
        assertEquals(10,score);
    }

    @Test(expected = WrongScoreException.class)
    public void testWrongScore() throws WrongScoreException {
        new Frame(1,10);
    }

    @Test(expected = WrongScoreException.class)
    public void testFirstScoreWrong() throws WrongScoreException{
        new Frame(-1,4);
    }

    @Test(expected = WrongScoreException.class)
    public void testSecondScoreWrong() throws WrongScoreException{
        new Frame(1,-4);
    }

    @Test
    public void testFirstScoreWithVariable() throws WrongScoreException{
        Frame f = new Frame(4,0);
        int score = f.first_throw();
        assertEquals(4,score);
    }

    @Test
    public void testSecondScoreWithVariable() throws WrongScoreException{
        Frame f = new Frame(0,4);
        int score = f.second_throw();
        assertEquals(4,score);
    }

    @Test
    public void testGetScore() throws WrongScoreException{
        Frame f = new Frame(6,4);
        int score = f.get_score();
        assertEquals(10,score);
    }

    @Test
    public void testGetScore2() throws WrongScoreException{
        Frame f = new Frame(3,4);
        int score = f.get_score();
        assertEquals(7,score);
    }

    @Test
    public void testIsStrike() throws WrongScoreException{
        Frame f = new Frame(10,0);
        boolean strike = f.is_strike();
        assertTrue(strike);
    }

    @Test
    public void testIsNotStrike() throws WrongScoreException{
        Frame f = new Frame(0,10);
        boolean strike = f.is_strike();
        assertFalse(strike);
    }


    @Test
    public void testIsSpare() throws WrongScoreException{
        Frame f = new Frame(6,4);
        boolean strike = f.is_spare();
        assertTrue(strike);
    }

    @Test
    public void testIsNotSpare() throws WrongScoreException{
        Frame f = new Frame(0,1);
        boolean strike = f.is_spare();
        assertFalse(strike);
    }

    @Test
    public void testLastFrame() throws WrongScoreException{
        Frame f = new Frame(10,10,true);
        int score = f.get_score();
        assertEquals(20,score);
    }
}
