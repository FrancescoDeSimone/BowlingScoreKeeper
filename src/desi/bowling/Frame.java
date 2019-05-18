package desi.bowling;

public class Frame {

    Frame(int first, int second) throws WrongScoreException {
        if((first+second)>10 || first < 0 || second < 0)
            throw new WrongScoreException();
        this.first = first;
        this.second = second;
    }

    public Frame(int first, int second, boolean b) throws WrongScoreException  {
        if(first < 0 || second < 0)
            throw new WrongScoreException();
        this.first = first;
        this.second = second;

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
        return first==10 && second == 0;
    }

    public boolean is_spare() {
        return (first+second)==10;
    }

    private int first, second;

}
