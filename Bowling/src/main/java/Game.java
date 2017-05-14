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
            if(pins == 10){
                itsCurrentFrame ++;
            }else{
                firstThrowInFrame = false;
            }
        }else{
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }






    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
