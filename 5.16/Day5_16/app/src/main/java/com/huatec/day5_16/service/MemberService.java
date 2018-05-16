package com.huatec.day5_16.service;


import com.huatec.day5_16.model.HttpResult;
import com.huatec.day5_16.model.MemberEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by think on 2018/5/16.
 */

public interface MemberService {

    @GET("member/{}")
    Call<HttpResult<MemberEntity>> getMemberInfo();
}
