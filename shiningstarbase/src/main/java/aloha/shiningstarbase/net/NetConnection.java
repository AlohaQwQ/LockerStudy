package aloha.shiningstarbase.net;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * 网络通信的基类,其他通信功能都以此来扩展。接收信息与发送信息。
 * @author Aloha
*/

public class NetConnection{

	/**
     * 定义网络 监听回调
     */
    public interface OnNetConnectionCallBack {
        /**
         * Success 监听回调
         */
        void onSuccess(String response);
        /**
         * Error 监听回调
         */
        void onError(String error);
    }

	public static void sendRequest(final String url,final OnNetConnectionCallBack onNetConnectionCallBack){
		/**
		 * @param String   表示在执行AsyncTask的时候传入的参数
		 * @param Integer  表示使用整型数据来作为进度显示单位
		 * @param String   使用String来反馈执行结果
		 */
		//防止HTTP通信阻塞主线程,使用异步任务	AsyncTask<Params, Progress, Result>()
		new AsyncTask<Void, Void, String>() {

			//任务开始执行之前调用，用于进行一些界面上的初始化操作
			protected void onPreExecute() {
				//pd.setMessage("Dead!!!");
				//pd.show();
			}

			/**
			 * 处理耗时任务。完成任务之后通过return语句返回执行结果。
			 */
			@Override
			protected String doInBackground(Void... params) {
			/*//参数对
			StringBuffer paramsStr = new StringBuffer();
			for(int i=0;i<kvs.length;i+=2){
				//通过键值对的方式存储参数对,第一位为key,第二位为value,中间以=连接。参数对之间以&分割,以此类推。
				paramsStr.append(kvs[i]).append("=").append(kvs[i+1]).append("&");
				System.out.println(paramsStr.toString());
			}*/

				// 执行网络连接,上传数据到服务器
				// 在内部类中是无法访问到url的,因此需要限定为final
				// 通过URL来打开一个网络连接
				HttpURLConnection connection = null;
				StringBuilder response = new StringBuilder();
				try {
					System.out.println("打开网络连接成功");
					connection = (HttpURLConnection) new URL(url).openConnection();
					System.out.println("Request Url:"+connection.getURL());
					System.out.println("Url"+url);
                    /**Get Post 方式*/
					//connection.setRequestMethod("GET");
					connection.setRequestMethod("POST");
					connection.setConnectTimeout(4000);
					connection.setReadTimeout(4000);
				    /*URLEncoder.encode(name, "UTF-8");*/
					//method为POST,往服务器端输出数据,打开一个Output
					connection.setDoInput(true);
					connection.setDoOutput(true);

					// 下面对获取到的输入流进行读取
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
						//System.out.println("response.append(line);"+response);
					}
					System.out.println("通信完毕");
					//返回服务器端结果result
					//System.out.println("NetConnection return..."+response.toString());
				} catch (ProtocolException e) {
                    onNetConnectionCallBack.onError("ProtocolException 导致通信失败");
					System.out.println("ProtocolException 导致通信失败");
					e.printStackTrace();
				} catch (MalformedURLException e) {
                    onNetConnectionCallBack.onError("MalformedURLException 导致通信失败");
					System.out.println("MalformedURLException 导致通信失败");
					e.printStackTrace();
				} catch (IOException e) {
                    onNetConnectionCallBack.onError("IOException 导致通信失败");
					System.out.println("IOException 导致通信失败");
					e.printStackTrace();
				} finally{
					if(connection!=null){
						//关闭HTTP连接
						connection.disconnect();
					}
				}
				return response.toString();
			}

			/**
			 * 发送数据到外部链接
			 * onPostExecute()是在doInBackground()方法执行完毕之后,会将doInBackground()的返回值(服务器端返回数据)作为该方法的传入参数传入。
			 */
			@Override
			protected void onPostExecute(String result) {
				//关闭进度框
				//pd.dismiss();
				if(result!=null){
					/*Message msg = new Message();
					msg.obj = result;
					handler.sendMessage(msg);*/
                    onNetConnectionCallBack.onSuccess(result);
					//System.out.println("result!=null..."+result);
				}else {
                    onNetConnectionCallBack.onError("onPostExecute...执行失败");
					System.out.println("onPostExecute...执行失败");
				}
				super.onPostExecute(result);
			}
			//执行AsyncTask异步任务
		}.execute();
	}
}
