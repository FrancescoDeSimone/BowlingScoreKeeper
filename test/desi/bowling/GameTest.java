package desi.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    @Test(expected = WrongGameNumberException.class)
    public void testGameFewScore() throws WrongScoreException, WrongGameNumberException{
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1)
        ));
        new Game(frame);
    }

    @Test
    public void testGameScore() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1),
                new Frame(1,1)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(20,score);

    }

    @Test
    public void testGameScore2() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,5),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(1,8),
                new Frame(2,6)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(81,score);

    }

    @Test
    public void testStrike() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(10,0),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(2,6)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(94,score);
    }

    @Test
    public void testSpare() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,9),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(2,6)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(88,score);
    }

    @Test
    public void testStrikeAndSpare() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(10,0),
                new Frame(4,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(2,6)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(103,score);
    }

    @Test
    public void testTwoStrikeInARow() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(10,0),
                new Frame(10,0),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(2,6)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(112,score);
    }

    @Test
    public void testTwoSpareInARow() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(8,2),
                new Frame(5,5),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(2,6)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(98,score);
    }

    @Test
    public void testSpareAsLastFrame() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,5),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(2,8),
                new Frame(7,0)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(90,score);
    }

    @Test
    public void testStrikeAsLastFrame() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,5),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(10,0),
                new Frame(7,2)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(92,score);
    }

    @Test
    public void testBonusIsAStrike() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,5),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(4,5),
                new Frame(8,1),
                new Frame(2,8),
                new Frame(10,0)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(93,score);
    }

    @Test
    public void testBestScore() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(10,10,true)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(300,score);
    }
    @Test
    public void testRealGame() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(6,3),
                new Frame(7,1),
                new Frame(8,2),
                new Frame(7,2),
                new Frame(10,0),
                new Frame(6,2),
                new Frame(7,3),
                new Frame(10,0),
                new Frame(8,0),
                new Frame(7,3),
                new Frame(10,0,true)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(135,score);
    }
}
