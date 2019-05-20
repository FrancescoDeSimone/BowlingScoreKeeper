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
        new Frame(11,-1);
    }

    @Test(expected = WrongScoreException.class)
    public void testBothScoreWrong() throws WrongScoreException{
        new Frame(-11,-1);
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
    public void testBonusStrikeIsNotSpare() throws WrongScoreException{
        Frame f = new Frame(7,3, Frame.FRAME_TYPE.STRIKE_BONUS);
        boolean strike = f.is_strike();
        assertFalse(strike);
    }

    @Test
    public void testBonusStrikeIsNotStrike() throws WrongScoreException{
        Frame f = new Frame(10,0, Frame.FRAME_TYPE.STRIKE_BONUS);
        boolean strike = f.is_strike();
        assertFalse(strike);
    }

    @Test
    public void testBonusSpareIsNotStrike() throws WrongScoreException{
        Frame f = new Frame(10,0, Frame.FRAME_TYPE.SPARE_BONUS);
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
    public void testIsNotSpare2() throws WrongScoreException{
        Frame f = new Frame(10,0);
        boolean strike = f.is_spare();
        assertFalse(strike);
    }

    @Test
    public void testLastFrameStrikeBonus() throws WrongScoreException{
        Frame f = new Frame(10,10, Frame.FRAME_TYPE.STRIKE_BONUS);
        int score = f.get_score();
        assertEquals(20,score);
    }


    @Test
    public void testLastFrameSpareBonus() throws WrongScoreException{
        Frame f = new Frame(10,0, Frame.FRAME_TYPE.SPARE_BONUS);
        int score = f.get_score();
        assertEquals(10,score);
    }

    @Test
    public void testGetThrowTypeNormal() throws WrongScoreException {
        Frame f = new Frame(3,4);
        Frame.FRAME_TYPE normal = f.get_throw_type();
        assertEquals(Frame.FRAME_TYPE.NORMAL_THROW,normal);
    }


    @Test(expected = WrongScoreException.class)
    public void testIllegalThrowTypeNormal() throws WrongScoreException {
        new Frame(13,4);
    }

    @Test
    public void testGetThrowTypeStrikeBonus() throws WrongScoreException {
        Frame f = new Frame(10,5, Frame.FRAME_TYPE.STRIKE_BONUS);
        Frame.FRAME_TYPE strike = f.get_throw_type();
        assertEquals(Frame.FRAME_TYPE.STRIKE_BONUS,strike);
    }

    @Test(expected = WrongScoreException.class)
    public void testIllegalThrowTypeStrikeBonus() throws WrongScoreException {
        new Frame(11,1, Frame.FRAME_TYPE.STRIKE_BONUS);
    }

    @Test
    public void testGetThrowTypeSpareBonus() throws WrongScoreException {
        Frame f = new Frame(10,0, Frame.FRAME_TYPE.SPARE_BONUS);
        Frame.FRAME_TYPE spare = f.get_throw_type();
        assertEquals(Frame.FRAME_TYPE.SPARE_BONUS,spare);
    }

    @Test(expected = WrongScoreException.class)
    public void testIllegalThrowTypeSpareBonus() throws WrongScoreException {
        new Frame(7,2, Frame.FRAME_TYPE.SPARE_BONUS);
    }
}
