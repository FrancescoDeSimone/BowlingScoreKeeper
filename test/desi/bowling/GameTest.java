package desi.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    @Test(expected = WrongGameNumberException.class)
    public void testGameExcessScore() throws WrongScoreException, WrongGameNumberException{
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
                new Frame(7,0, Frame.FRAME_TYPE.SPARE_BONUS)
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
                new Frame(7,2, Frame.FRAME_TYPE.STRIKE_BONUS)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(92,score);
    }

    @Test
    public void testAllSpare() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,0, Frame.FRAME_TYPE.SPARE_BONUS)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(190,score);
    }

    @Test(expected = WrongScoreException.class)
    public void testIllegalLastSpare() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1),
                new Frame(9,1, Frame.FRAME_TYPE.SPARE_BONUS)
        ));
        new Game(frame);
    }

    @Test
    public void testStrikeSecondToLast() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(4,1),
                new Frame(1,1),
                new Frame(5,1),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(9,1),
                new Frame(10,0),
                new Frame(1,1)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(71,score);
    }

    @Test
    public void testStrikeTwoStrikeAtTheEnd() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(4,1),
                new Frame(1,1),
                new Frame(5,1),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(9,1),
                new Frame(10,0),
                new Frame(10,0),
                new Frame(7,2, Frame.FRAME_TYPE.STRIKE_BONUS)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(103,score);
    }


    @Test
    public void testBonusIsAStrikeAfterStrike() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(4,1),
                new Frame(1,1),
                new Frame(5,1),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(9,1),
                new Frame(7,2),
                new Frame(10,0),
                new Frame(10,0, Frame.FRAME_TYPE.STRIKE_BONUS)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(83,score);
    }

    @Test
    public void testStrikeInTheMiddle() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(4,1),
                new Frame(1,1),
                new Frame(5,1),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(10,0),
                new Frame(7,1),
                new Frame(3,1),
                new Frame(9,1),
                new Frame(1,1)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(68,score);
    }

    @Test
    public void testBonusIsAStrikeAfterSpare() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(10,0,Frame.FRAME_TYPE.SPARE_BONUS)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(93,score);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testInvalidBonusThrowNotSpare() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(2,7),
                new Frame(10,0, Frame.FRAME_TYPE.SPARE_BONUS)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testInvalidBonusThrowNotStrike() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(9,0),
                new Frame(10,1, Frame.FRAME_TYPE.STRIKE_BONUS)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testScoreStrikeBonusDontThrow() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(10,0)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testScoreSpareBonusDontThrow() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(8,2)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testInvalidBonusAsNormalFrame() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(8,2),
                new Frame(3,2)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testInvalidStrikeBonusPreempt() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,5),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(10,0),
                new Frame(8,1, Frame.FRAME_TYPE.STRIKE_BONUS),
                new Frame(8,2),
                new Frame(3,2)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testInvalidStrikeBonusWithNoReason() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(10,0),
                new Frame(8,2, Frame.FRAME_TYPE.STRIKE_BONUS)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testInvalidSpareBonusPreempt() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(1,5),
                new Frame(3,6),
                new Frame(7,2),
                new Frame(3,6),
                new Frame(4,4),
                new Frame(5,3),
                new Frame(3,3),
                new Frame(9,1),
                new Frame(9,0, Frame.FRAME_TYPE.SPARE_BONUS),
                new Frame(8,2),
                new Frame(3,2)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testInvalidSpareBonusWithNoReason() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(8,2),
                new Frame(8,0, Frame.FRAME_TYPE.SPARE_BONUS)
        ));
        new Game(frame);
    }

    @Test(expected = WrongGameNumberException.class)
    public void testBonusPassAsNormalThrow() throws WrongScoreException, WrongGameNumberException {
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
                new Frame(8,2),
                new Frame(10,0)
        ));
        new Game(frame);
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
                new Frame(10,10, Frame.FRAME_TYPE.STRIKE_BONUS)
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
                new Frame(10,0, Frame.FRAME_TYPE.SPARE_BONUS)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(135,score);
    }

    @Test
    public void testStrikeAndSpareInterchange() throws WrongScoreException, WrongGameNumberException {
        ArrayList<Frame> frame = new ArrayList<>();
        frame.addAll(Arrays.asList(
                new Frame(5,5),
                new Frame(10,0),
                new Frame(5,5),
                new Frame(10,0),
                new Frame(5,5),
                new Frame(10,0),
                new Frame(5,5),
                new Frame(10,0),
                new Frame(5,5),
                new Frame(10,0),
                new Frame(5,5, Frame.FRAME_TYPE.STRIKE_BONUS)
        ));
        Game g = new Game(frame);
        int score = g.game_score();
        assertEquals(200,score);
    }
}
