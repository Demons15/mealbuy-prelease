package com.cxsz.mealbuy.model.net;
import com.cxsz.mealbuy.model.net.MealCodeData;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface MealRequestService {
    //套餐信息类
    //卡信息查询.
    //卡查询当前卡正使用以及未启用套餐接口
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/getSimByParam")
    Observable<MealCodeData> getSimByParam(@Body RequestBody cardInfo);

    //卡查询当前卡正使用以及未启用套餐接口
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/unactivePackage")
    Observable<MealCodeData> getSimPackage(@Body RequestBody cardInfo);

    //获取卡可购买套餐列表.
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/getGoodsRelevance")
    Observable<MealCodeData> getGoodsRelevance(@Body RequestBody body);


    //选号查询
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("queryChooseNumber")
    Observable<MealCodeData> queryChooseNumber(@Body RequestBody body);

    //选号确认
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("chooseNumber")
    Observable<MealCodeData> chooseNumber(@Body RequestBody body);

    //购买套餐
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/confirmOrder")
    Observable<MealCodeData> confirmOrder(@Body RequestBody body);

    //创建订单
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/createNewOrder")
    Observable<MealCodeData> createNewOrder(@Body RequestBody body);

    //支付订单
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST(" third/payOrder")
    Observable<MealCodeData> payOrder(@Body RequestBody body);


    //实名状态认证
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/realNameDiagnosis")
    Observable<MealCodeData> realNameDiagnosis(@Body RequestBody body);

    //卡套餐诊断
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/cardPackageDiagnosis")
    Observable<MealCodeData> cardPackageDiagnosis(@Body RequestBody body);

    //同步卡状态
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/synchronizationCardStatus")
    Observable<MealCodeData> synchronizationCardStatus(@Body RequestBody body);

    //更新语音数据
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/updateVoiceData")
    Observable<MealCodeData> updateVoiceData(@Body RequestBody body);

    //更新流量数据
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/updateTrafficData")
    Observable<MealCodeData> updateTrafficData(@Body RequestBody body);

    //流量检测
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/flowDetection")
    Observable<MealCodeData> flowDetection(@Body RequestBody body);

    //语音检测
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/speechDetection")
    Observable<MealCodeData> speechDetection(@Body RequestBody body);

    //白名单诊断
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/whiteListDiagnosis")
    Observable<MealCodeData> whiteListDiagnosis(@Body RequestBody body);

    //读取卡状态诊断
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("ai/readCardStatus")
    Observable<MealCodeData> readCardStatus(@Body RequestBody body);
}
