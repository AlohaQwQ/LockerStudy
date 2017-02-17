package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aloha.shiningstarbase.logger.LogUtil;

/*import cn.lebaodai.common.util.FormData.FieldData;
import cn.lebaodai.lbd.dao.impl.ActivityDao;
import cn.lebaodai.lbd.vo.Activity;*/

/**
 * Created by Aloha <br>
 * -explain 文件自动生成
 * @Date 2017/2/13 9:48
 */
public class AutoGenerationBean {

	static String[] list;

	//static List<FieldData> lf = new ArrayList<FieldData>();
	static List<String> lf = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args){
		String className = "Sample";

		String modelName = className+"Model";
		String viewName = className+"View";
		String viewActivityName = className+"Activity";
		String viewFragmentName = className+"Fragment";
		String presenterName = className+"Presenter";

		String modelPackage = "model/sample";
		String viewPackage = "ui/activity/sampleActivity/view";
		String presenterPackage = "ui/activity/sampleActivity/presenter";

		String iMoudel = createIMoudel(modelName,modelPackage.replaceAll("/","."));
		String moudel = createMoudel(modelName,modelPackage.replaceAll("/","."));
		String iView = createIView("I"+viewName,viewPackage.replaceAll("/","."));
		String view = createActivityView(viewActivityName,viewName,presenterName,viewPackage.replaceAll("/","."));
		String iPresenter = createIPresenter("I"+presenterName,presenterPackage.replaceAll("/","."));
		String presenter = createPresenter(presenterName,presenterPackage.replaceAll("/","."),viewActivityName,"I"+presenterName);

		saveFile("I"+modelName, iMoudel,modelPackage);
		saveFile(modelName, moudel,modelPackage);
		saveFile("I"+viewName, iView,viewPackage);
		saveFile(viewActivityName, view,viewPackage);
		saveFile("I"+presenterName, iPresenter,presenterPackage);
		saveFile(presenterName, presenter,presenterPackage);
	}

	public static  String createIMoudel(String className, String packageName){
		String text="";
		text+="package aloha.shiningstar.lockerstudy."+packageName+";      \r";
		text+="                                                            \r";
		text+="import aloha.shiningstarbase.base.IBaseModel"+";            \r";
		text+="                                                            \r";
		text+="/**                                                         \r";
		text+=" * @version 1.0                                             \r";
		text+=" */                                                         \r";
		text+="public interface I"+className+" extends IBaseModel"+" {      \r";
		text+="                                                            \r";
		text+="    void sampleFuntion();	                               \r";
		text+="                                                            \r";
		text+="}                                                           \r";
		return text;
	}

	public static  String createMoudel(String className,String packageName){
		String text="";
		text+="package aloha.shiningstar.lockerstudy."+packageName+";      \r";
		text+="                                                            \r";
		text+="/**                                                         \r";
		text+=" * @version 1.0                                             \r";
		text+=" */                                                         \r";
		text+="public class "+className+"implements I"+className+" {       \r";
		text+="                                                            \r";
		text+="    @Override	                                           \r";
		text+="    public void sampleFuntion() {                         \r";
		text+="                                                            \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="}                                                           \r";
		return text;
	}

	public static  String createIView(String className, String packageName){
		String text="";
		text+="package aloha.shiningstar.lockerstudy."+packageName+";      \r";
		text+="                                                            \r";
		text+="import aloha.shiningstarbase.base.IBaseView;;               \r";
		text+="                                                            \r";
		text+="/**                                                         \r";
		text+=" * @version 1.0                                             \r";
		text+=" */                                                         \r";
		text+="public interface I"+className+" extends IBaseView"+" {       \r";
		text+="                                                            \r";
		text+="    void showDataSampleFuntion();	                       \r";
		text+="                                                            \r";
		text+="}                                                           \r";
		return text;
	}

	public static  String createActivityView(String className,String implementsViewClassName,
					String presenterClassName,String packageName){
		String text="";
		text+="package aloha.shiningstar.lockerstudy."+packageName+";      \r";
		text+="	                                                           \r";
		text+="/**                                                         \r";
		text+=" * @version 1.0                                             \r";
		text+=" */                                                         \r";
		text+="public class "+className+" extends BaseActivity <"+ implementsViewClassName +", "+presenterClassName+"> " +
				"implements "+implementsViewClassName+" {                   \r";
		text+="                                                            \r";
		text+="    @Override	                                           \r";
		text+="    protected void init() {                                 \r";
		text+="                                                            \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="    @Override	                                           \r";
		text+="    protected BasePresenter CreatePresenter(){              \r";
		text+="        return new "+presenterClassName+"();                \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="    @Override	                                           \r";
		text+="    protected int getLayoutID() {                           \r";
		text+="         return R.layout.activity_main;                     \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="    @Override	                                           \r";
		text+="    public void showDataSampleFuntion() {                   \r";
		text+="                                                            \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="}                                                           \r";
		return text;
	}

	public static  String createIPresenter(String className, String packageName){
		String text="";
		text+="package aloha.shiningstar.lockerstudy."+packageName+";      \r";
		text+="	                                                           \r";
		text+="/**                                                         \r";
		text+=" * @version 1.0                                             \r";
		text+=" */                                                         \r";
		text+="public interface "+className+" {                            \r";
		text+="	                                                           \r";
		text+="    //定义presenter 接口回调                                  \r";
		text+="    void getDataSampleFuntion(String request);              \r";
		text+="	                                                           \r";
		text+="}                                                           \r";
		return text;
	}

	public static  String createPresenter(String className,String packageName,String anchorView,String implementsViewClassName){
		String text="";
		text+="package aloha.shiningstar.lockerstudy."+packageName+";      \r";
		text+="	                                                           \r";
		text+="/**                                                         \r";
		text+=" * @version 1.0                                             \r";
		text+=" */                                                         \r";
		text+="public class "+className+"extends BasePresenter<"+anchorView+"> implements "+implementsViewClassName+ " {                   \r";
		text+="                                                            \r";
		text+="    public "+className+"() {                                \r";
		text+="        //获取model                                          \r";
		text+="                                                            \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="  /**                                                        \r";
		text+="    * 实现presenter接口方法                                   \r";
		text+="    */                                                       \r";
		text+="    @Override	                                           \r";
		text+="    public void getDataSampleFuntion(String request){       \r";
		text+="                                                            \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="  /**                                                        \r";
		text+="    * Created by Aloha <br>                                  \r";
		text+="    * -explain Model层请求数据，BasePresent层统一做网络请求，回调到子类 presenter 监听                                  \r";
		text+="    * @Date 2017/01/01 12:00                                  \r";
		text+="    */                                                       \r";
		text+="    @Override	                                           \r";
		text+="    protected void gonResponseAsyncDeal(int status, String message, String result, String requestID) {    \r";
		text+="                                                            \r";
		text+="    }                                                       \r";
		text+="                                                            \r";
		text+="}                                                           \r";
		return text;
	}

	public static void saveFile(String classname, String text,String pageName) {
		LogUtil.biu("text:"+text);
		LogUtil.biu("创建java类：" + classname);
		String filepath = Thread.currentThread().getContextClassLoader()
				.getResource(".").getPath();

		LogUtil.biu("filepath:"+filepath);

		String[] fileP = filepath.split("target");
		LogUtil.biu(fileP[0]);

		File file = new File(fileP[0] + "/app/src/main/java/aloha/shiningstar/lockerstudy/"+pageName+"/"
				+ FormData.firstUpper(classname) + ".java");
		/* File file = new
		 File("F\:\lebaodai\myelicpseWs\trunk\src\main\java\cn\lebaodai\lbd\vo\Msg_push.java");*/

		if (file.exists()) {
			file.delete();
		}

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdir();
		}

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(
					new FileWriter(new File(file.getPath())));
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
