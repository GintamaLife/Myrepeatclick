package marong.myrepeatclick.com;

import android.view.View;

/**
 * Created by marong on 2017/8/3.
 */

public abstract class OnClickFastListener extends BaseClickListener  {



    //防止快速点击默认等待时长为900ms
    private  long DELAY_Time = 900;
    private static long lastClickTime;
    private boolean isFastDoubleClick(){

        long time =System.currentTimeMillis();
        long timeD =time - lastClickTime;
        if(0 < timeD &&timeD<DELAY_Time) {
            return true;
        }
        lastClickTime =time;
        return false;


    }

    @Override
    public void onClick(View v) {
        // 判断当前点击事件与前一次点击事件时间间隔是否小于阙值
      if(isFastDoubleClick()) {
          return;

      }
      onFastClick(v);
    }
    /*
    * 设置默认快速点击事件时间间隔
    */
    public  OnClickFastListener setLastClickTime(long delay_time){
        this.DELAY_Time =delay_time;
        return this;
    }

    /*
    * 快速点击事件的回调方法
    */

    public abstract  void onFastClick(View V);
}
