package com.cxsz.mealbuy.model.net;

import com.cxsz.mealbuy.bean.ConfirmOrderBean;
import com.cxsz.mealbuy.component.MealCommonUtils;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.component.NetSignUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MealNetRequestModelImpl implements MealNetRequestModel {
    private static final int DEFAULT_TIMEOUT = 15;

    private Retrofit retrofit;
    private MealRequestService networkService;

    private MealNetRequestModelImpl() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(MealInfoHelper.getInstance().getHostUrl())
                .build();
        networkService = retrofit.create(MealRequestService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final MealNetRequestModelImpl INSTANCE = new MealNetRequestModelImpl();
    }

    //获取单例
    public static MealNetRequestModelImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void getSimByParam(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.getSimByParam(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getSimPackage(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.getSimPackage(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getGoodsRelevance(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.getGoodsRelevance(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void queryChooseNumber(MealProgressSubscriber<MealCodeData> subscriber, String tempIccid, String number, String pageNum, String pageSize) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("tempIccid", tempIccid);
        map.put("number", number);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.queryChooseNumber(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void chooseNumber(MealProgressSubscriber<MealCodeData> subscriber, String tempIccid, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("tempIccid", tempIccid);
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.chooseNumber(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    @Override
    public void confirmOrder(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber, String goodsId) {
        List<ConfirmOrderBean.GoodsRelevanceBean> goodsRelevanceBeanList = new ArrayList<ConfirmOrderBean.GoodsRelevanceBean>();
        ConfirmOrderBean.GoodsRelevanceBean goodsRelevanceBean = new ConfirmOrderBean.GoodsRelevanceBean();
        goodsRelevanceBean.setGoodsId(goodsId);
        goodsRelevanceBeanList.add(goodsRelevanceBean);
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        map.put("goodsRelevance", new Gson().toJson(goodsRelevanceBeanList));
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.confirmOrder(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void createNewOrder(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber,
                               String dealMode, String packageEndTime, String packageEndTimeNew, String goodsId, String goodsDescribe) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        map.put("dealMode", dealMode);
        if (packageEndTime == null) {
            map.put("packageEndTime", "");
        } else {
            map.put("packageEndTime", packageEndTime);
        }
        map.put("packageEndTimeNew", packageEndTimeNew);
        map.put("goodsId", goodsId);
        map.put("goodsDescribe", goodsDescribe);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.createNewOrder(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void payOrder(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        NetSignUtil.writeData(2, sign);
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.payOrder(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void realNameDiagnosis(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.realNameDiagnosis(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void cardPackageDiagnosis(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.cardPackageDiagnosis(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void synchronizationCardStatus(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.synchronizationCardStatus(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void updateVoiceData(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.updateVoiceData(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void updateTrafficData(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.updateTrafficData(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void flowDetection(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.flowDetection(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void speechDetection(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.speechDetection(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void whiteListDiagnosis(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.whiteListDiagnosis(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void readCardStatus(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("cardNumber", cardNumber);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.readCardStatus(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void queryVoiceWhiteList(MealProgressSubscriber<MealCodeData> subscriber, String type, String msisdn) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("type", type);
        map.put("msisdn", msisdn);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.queryVoiceWhiteList(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /***
     *
     * @param subscriber
     * @param type  传入的参数类型：1 物联网卡号 2 imei 3 imsi
     * @param msisdn 物联网卡号
     * @param operType  add 新增  del 删除
     * @param phone  添加的白名单的手机号码多个以”,”隔开
     * @return
     */
    public void addOrDelVoiceWhiteManager(MealProgressSubscriber<MealCodeData> subscriber, String type, String msisdn, String operType, String phone) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("type", type);
        map.put("msisdn", msisdn);
        map.put("operType", operType);
        map.put("phone", phone);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.addOrDelVoiceWhiteManager(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void queryAddWhiteCount(MealProgressSubscriber<MealCodeData> subscriber, String type, String msisdn) {
        Map<String, String> map = new HashMap<>();
        map.put("appId", MealInfoHelper.getInstance().getMealAppId());
        map.put("timestamp", MealCommonUtils.getTime());
        map.put("signature", "");
        map.put("nonceStr", MealInfoHelper.getInstance().getMealNonceStr());
        map.put("type", type);
        map.put("msisdn", msisdn);
        List<String> ignoreParamNames = new ArrayList<>();
        ignoreParamNames.add("signature");
        String sign = NetSignUtil.sign(map, ignoreParamNames, MealInfoHelper.getInstance().getMealSecret());
        map.put("signature", sign);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(map));
        networkService.queryAddWhiteCount(body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
