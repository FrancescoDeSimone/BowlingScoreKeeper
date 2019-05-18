    package desi.bowling;

    import java.util.ArrayList;

    public class Game {
        public Game(ArrayList<Frame> frame) throws WrongGameNumberException {
            if(frame.size()<10 || frame.size()>11)
                throw new WrongGameNumberException();
            this.frames = frame;
        }

        public int game_score() {
            int score = 0;
            for (int i = 0 ; i < 10;i++) {
                    if (frames.get(i).is_strike())
                        score += frames.get(i).get_score() + frames.get(i + 1).get_score()
                                + (frames.get(i + 1).is_strike() && (i<=10-2)?frames.get(i + 2).first_throw():0);
                    else if (frames.get(i).is_spare()){
                        score += frames.get(i).get_score() + frames.get(i + 1).first_throw();
                    }
                else
                    score += frames.get(i).get_score();
            }
            return score;
        }

        private ArrayList<Frame> frames;
    }
