package marong.myrepeatclick.com;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

/**
 * Created by marong on 2017/8/3.
 */

public abstract class OnClickNetworkListener  extends  BaseClickListener{

    @Override
    public void onClick(View v) {
        super.onClick(v);
        boolean isNetworkOk = isNetworkConnected(v.getContext());

        if (isNetworkOk) {
            onNetworkClick(v);
        } else {
            onNONetworkClick(v);
        }

    }

    /**
     * 网络连接是否正常
     *
     * @param context
     * @return
     */

    public static boolean isNetworkConnected(Context context){
        if(context !=null) {
            ConnectivityManager mConnectivityManager=(ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

            if(mNetworkInfo !=null) {
                return mNetworkInfo.isAvailable();

            }
        }
        return false;
    }

    //点击事件有网络 点击事件没网络

    public  abstract  void onNetworkClick(View v);
    //点击事件有网络 点击事件没网络

    public  abstract  void onNONetworkClick(View v);

}
