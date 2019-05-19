package desi.bowling;

public class Frame {

    Frame(int first, int second, FRAME_TYPE throw_type) throws WrongScoreException {
        if(throw_type == FRAME_TYPE.NORMAL_THROW && first+second > 10)
            throw new WrongScoreException("Invalid normal throw");
        if(throw_type == FRAME_TYPE.SPARE_BONUS && (second != 0 || first > 10))
            throw new WrongScoreException("Invalid spare bonus throw");
        if(throw_type == FRAME_TYPE.STRIKE_BONUS && (first>10 || second > 10))
            throw new WrongScoreException("Invalid strike bonus throw");
        if( first < 0 || second < 0)
            throw new WrongScoreException("Negative score");

        this.first = first;
        this.second = second;
        this.throw_type = throw_type;
    }

    public Frame(int first, int second) throws WrongScoreException  {
        this(first,second,FRAME_TYPE.NORMAL_THROW);
    }

    public int first_throw() {
        return first;
    }

    public int second_throw() {
        return second;
    }

    public int get_score() {
        return first+second;
    }

    public boolean is_strike(){
        return first==10 && second == 0 && throw_type==FRAME_TYPE.NORMAL_THROW;
    }

    public boolean is_spare() {
        return ((first+second)==10 && first!=10 && throw_type==FRAME_TYPE.NORMAL_THROW);
    }

    public FRAME_TYPE get_throw_type() {
        return throw_type;
    }

    private int first, second;
    private FRAME_TYPE throw_type;
    public enum FRAME_TYPE {STRIKE_BONUS,SPARE_BONUS,NORMAL_THROW}

}
