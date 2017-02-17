package aloha.shiningstarbase.net;

import android.os.AsyncTask;
import android.util.Log;

import com.aloha.starworld.base.MyApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 加载网络图片异步类
 * @author Susie
 */
public class AsyncLoadNetworkPic extends AsyncTask<String, Integer, Void> {

	/**网络图片name，图片存放位置*/
    private String pictrueName = null;

    /**处理完成后需要向外部返回处理好的图片*/
    //private Handler handler =  new Handler();
    private File file = null;

	public AsyncLoadNetworkPic(String pictrueName){
		this.pictrueName = pictrueName;
		//this.handler = handler;
	}

    @Override
    protected Void doInBackground(String... params) {
    	/**加载网络图片*/
        String urlpath = params[0];
        /*文件路径记得相应变化*/
        file = new File(MyApplication.DOWNLOAD_PATH + "exam_picture/", pictrueName);
        InputStream in = null;
        FileOutputStream out = null;
        try {
            URL url = new URL(urlpath);
            HttpURLConnection connUrl = (HttpURLConnection) url.openConnection();
            connUrl.setConnectTimeout(5000);
            connUrl.setRequestMethod("GET");
            if(connUrl.getResponseCode() == 200) {
                in = connUrl.getInputStream();
                out = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int len;
                while((len = in.read(buffer))!= -1){
                    out.write(buffer, 0, len);
                }
            } else {
                Log.i("QAQ", "下载图片-connUrl.getResponseCode()-"+connUrl.getResponseCode() + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
    	// TODO Auto-generated method stub
    	super.onPostExecute(result);
    }

   /* @Override
    protected void onPostExecute(File result) {
        // 当执行完成后，会将图片存储到本地，所以需要再次为其设置一次
        //fragment_content.setText(Html.fromHtml(content, mImageGetter, null));
    	if(result!=null){
			Message msg = new Message();
			msg.obj = result;
			handler.sendMessage(msg);
			//System.out.println("result!=null..."+result);
		}else {
			System.out.println("onPostExecute...执行失败");
		}
		super.onPostExecute(result);
    }*/

}