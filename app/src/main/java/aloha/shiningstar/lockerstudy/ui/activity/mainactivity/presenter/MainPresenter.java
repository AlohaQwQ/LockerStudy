/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package aloha.shiningstar.lockerstudy.ui.activity.mainactivity.presenter;


import aloha.shiningstar.lockerstudy.model.main.IMainModel;
import aloha.shiningstar.lockerstudy.model.main.MainModel;
import aloha.shiningstar.lockerstudy.ui.activity.mainactivity.view.MainView;
import aloha.shiningstarbase.base.BasePresenter;

/**
 * Created by Aloha <br>
 * -explain Presenter 实现类，并实现持有Model 数据请求回调监听
 * @Date 2016/9/30 15:27
 */
public class MainPresenter extends BasePresenter<MainView> implements IMainPresenter {

    //传递Model
    private IMainModel mainModel;
    //private Model1 model1;
    //private Model2 model2;

    public MainPresenter() {
        //获取model
        mainModel = new MainModel();
    }

    @Override
    public void onItemClicked(int position) {
        if (getContentView() != null) {
            getContentView().showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void setCurrentItem(int position){

    }


    /**
     * Created by Aloha <br>
     * -explain presenter 层获取View 层操作，做分发处理
     * @Date 2016/10/9 10:06
     */
    @Override
    public void getMainCategory() {
        mainModel.getMainCategory();
    }



    /**
     * Created by Aloha <br>
     * -explain Model层请求数据，BasePresent层统一做网络请求，回调到子类 presenter 监听
     * @Date 2016/10/8 17:39
     */
    @Override
    protected void onResponseAsyncDeal(int status, String message, String result, String requestID) {

    }
}
