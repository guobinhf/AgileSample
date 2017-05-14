/**
 * Created by togb on 2017/5/14.
 */
public class Game {

    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer itsScorer = new Scorer();

    public int score() {
        return scoreForFrame(getCurrentFrame() -1);
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
        if(firstThrowInFrame == true){
            if(adjustFrameForStrike(pins) == false){
                firstThrowInFrame = false;
            }else{
                firstThrowInFrame = false;
            }
        }else{
            firstThrowInFrame = true;
            advanceFrame();
        }
    }

    private boolean adjustFrameForStrike(int pins) {
        if(pins == 10){
            advanceFrame();
            return true;
        }
        return false;
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(11, itsCurrentFrame +1);
    }


    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
