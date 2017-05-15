/**
 * Created by togb on 2017/5/14.
 */
public class Game {

    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer itsScorer = new Scorer();

    public int score() {
        return scoreForFrame(getCurrentFrame());
    }

    public int scoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
    }

    //不需要Throw类，Throw没有行为，只是data
    public void add(int pins) {
        itsScorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if(strike(pins) || !firstThrowInFrame){
            advanceFrame();
        }else{
            firstThrowInFrame = false;
        }
    }

    private boolean strike(int pins) {
        return (firstThrowInFrame && pins ==10);
    }

    private boolean adjustFrameForStrike(int pins) {
        if(pins == 10){
            advanceFrame();
            return true;
        }
        return false;
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame +1);
    }


    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
