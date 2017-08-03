package marong.myrepeatclick.com;

import android.view.View;

/**
 * Created by marong on 2017/8/3.
 */

public abstract class OnClickCostomListener extends BaseClickListener {


    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (isCorrect()) {
            onCorrectClient(view);

        } else {
            onNoCorrectClient(view);
        }


    }


    /**
     * 判断是否逻辑通过
     */
    public abstract boolean isCorrect();

    /**
     * 逻辑通过
     */
    public abstract void onCorrectClient(View V);

    /**
     * 逻辑没通过
     */
    public abstract void onNoCorrectClient(View V);


}
