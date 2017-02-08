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

package aloha.shiningstar.lockerstudy.ui.activity.mainactivity.view;


import aloha.shiningstarbase.base.IBaseView;

/**
 * Created by Aloha <br>
 * -explain MainView
 * @Date 2016/9/30 15:26
 */
public interface MainView extends IBaseView {
    //定义view 接口 回调
    void getMainCategory();
    void showMessage(String message);

}
