package desi.bowling;
import java.util.ArrayList;

public class Game {

    public Game(ArrayList<Frame> frames) throws WrongGameNumberException {
        if(frames.size() == 10 && (frames.get(9).is_spare() || frames.get(9).is_strike()))
            throw new WrongGameNumberException("Bonus is missing");
        if(frames.size() == 11 && (!frames.get(9).is_spare() && !frames.get(9).is_strike()))
            throw new WrongGameNumberException("Incorrect bonus throws");
        if(frames.size() < 10 || frames.size() > 11  )
            throw new WrongGameNumberException("Incorrect frame size");
        if(frames.size() == 11 && (frames.get(10).get_throw_type() == Frame.FRAME_TYPE.NORMAL_THROW))
            throw new WrongGameNumberException("Incorrect type of throw");
        this.frames = frames;
    }

    public int game_score() {
        int score = 0;
        for (int i = 0 ; i < 10;i++)
            if (frames.get(i).is_strike())
                score += frames.get(i).get_score() + frames.get(i+1).get_score()
                        + (frames.get(i+1).is_strike() && (i<=8)?frames.get(i+2).first_throw():0);
            else if (frames.get(i).is_spare())
                score += frames.get(i).get_score() + frames.get(i+1).first_throw();
            else
                score += frames.get(i).get_score();

        return score;
    }

    private ArrayList<Frame> frames;
}
