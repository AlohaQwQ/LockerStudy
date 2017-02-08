package aloha.shiningstar.lockerstudy.ui.activity.mainactivity.view;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import aloha.shiningstar.lockerstudy.R;
import aloha.shiningstar.lockerstudy.ui.activity.mainactivity.presenter.MainPresenter;
import aloha.shiningstarbase.base.BaseActivity;
import aloha.shiningstarbase.base.MyApplication;

/**
 * Created by Aloha <br>
 * -explain View层初始化数据或者是获取用户操作，交付presenter 层处理逻辑。处理完毕后再回调到View层处理下一步逻辑。
 * @Date 2016/10/8 17:50
 */
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {


    private boolean isAppExit = false;

    private PagerAdapter mAdapter;


    @Override
    protected void init() {
        //toolbar.setTitle(" ");

    }

    @Override
    protected MainPresenter CreatePresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
       // presenter.onResume();//3 将生命周期回调传给Presenter
    }


    /**
     * Created by Aloha <br>
     * -explain 数据初始化，交付 Presenter层处理数据逻辑
     * @Date 2016/10/8 17:50
     */
    @Override
    public void getMainCategory() {
        mPresenter.getMainCategory();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //取消Activity对menu 的拦截，fragment才能接收到menu操作
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    /**
     * @param keyCode
     * @param event
     * @explain 捕捉用户Back键操作。按2次退出应用。
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AppExit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void AppExit() {
        if (!isAppExit) {
            isAppExit = true;
            Toast.makeText(this, "Game Over！", Toast.LENGTH_SHORT).show();
            // 利用handler延迟2秒发送更改状态信息
            handler.sendEmptyMessageDelayed(0, 2000);
        } else {
            //如果在发送消息间隔的2秒内，用户再次按了BACK键，则再次执行exit方法，此时isExit的值已为 true，则会执行退出的方法。
            //ActivityCollector.finishAll();
            MyApplication.getApplicationInstance().finishAllActivity();
        }
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    isAppExit = false;
                    break;
                default:
                    break;
            }
        }
    };

}
