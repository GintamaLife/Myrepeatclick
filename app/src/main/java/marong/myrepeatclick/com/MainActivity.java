package marong.myrepeatclick.com;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    public Activity mContext = null;
    private TextView mainTitle;
    private Button mainFastbutton;
    private Button mainNetbutton;
    private Button mainLoginbutton;
    private Button mainCustomerutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        initView();
        initListener();
    }

    private void initListener() {
       mainFastbutton.setOnClickListener(new OnClickFastListener() {
           @Override
           public void onFastClick(View V) {
               Toast.makeText(mContext, "您点击了快速点击测试网络按钮...", Toast.LENGTH_LONG).show();

           }
       });

        mainNetbutton.setOnClickListener(new OnClickNetworkListener() {
            @Override
            public void onNetworkClick(View v) {
                Toast.makeText(mContext, "当前设备有网络,执行后续操作...", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNONetworkClick(View v) {
                Toast.makeText(mContext, "当前设备没有网络...", Toast.LENGTH_LONG).show();
            }
        });
        mainLoginbutton.setOnClickListener(new OnClickLoginedListener(mContext) {
            @Override
            public void onNoLoginedClick(View v) {
                Toast.makeText(mContext, "设备未登陆,无法执行后续操作...", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onLoginedClick(View v) {
                Toast.makeText(mContext, "设备已登录,之后后续操作...", Toast.LENGTH_LONG).show();

            }

            @Override
            public boolean isLogined(Activity context, View v) {
                return false;
            }
        });

       mainCustomerutton.setOnClickListener(new OnClickCostomListener() {
           @Override
           public boolean isCorrect() {
               return false;
           }

           @Override
           public void onCorrectClient(View V) {
               Toast.makeText(mContext, "判断通过,执行后续操作...", Toast.LENGTH_LONG).show();
           }

           @Override
           public void onNoCorrectClient(View V) {
               Toast.makeText(mContext, "判断未通过,无法执行后续操作...", Toast.LENGTH_LONG).show();
           }
       });


    }

    private void initView() {

        mainTitle = (TextView) findViewById(R.id.main_title);
        mainFastbutton = (Button) findViewById(R.id.main_fastbutton);
        mainNetbutton = (Button) findViewById(R.id.main_Netbutton);
        mainLoginbutton = (Button) findViewById(R.id.main_loginbutton);
        mainCustomerutton = (Button) findViewById(R.id.main_customerutton);
    }


}
