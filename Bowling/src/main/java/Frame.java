/**
 * Created by togb on 2017/5/14.
 */
public class Frame {

    private int itsScore;

    public int getScore() {
        return itsScore;
    }

    //不需要Throw类，Throw没有行为，只是data
    public void add(int pins) {
        itsScore += pins;
    }
}
