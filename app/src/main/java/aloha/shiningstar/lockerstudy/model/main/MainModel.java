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

package aloha.shiningstar.lockerstudy.model.main;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aloha <br>
 * -explain Model层处理数据操作，请求服务端，并将response 统一回调到 presenter 层。
 * @Date 2016/10/8 16:41
 */
public class MainModel implements IMainModel {

    /**
     * Created by Aloha <br>
     * -explain 发起网络请求，或者是获取本地数据库缓存
     * @Date 2016/10/9 10:10
     */
    @Override
    public void getMainCategory() {
        /*OkHttpRequest sendIdentifyingCodeRequest = new OkHttpRequest();
        sendIdentifyingCodeRequest.setAPIPath(ServiceAPIConstant.REQUEST_API_NAME_UTIL_IDENTIFYING_CODE);
        sendIdentifyingCodeRequest.setRequestID(ServiceAPIConstant.REQUEST_API_NAME_UTIL_IDENTIFYING_CODE);
        sendIdentifyingCodeRequest.addRequestFormParam(APIKey.USER_MOBILE, mobile);
        return sendIdentifyingCodeRequest;*/
    }
 /////
    @Override
    public void getSideCategory() {

    }
}
