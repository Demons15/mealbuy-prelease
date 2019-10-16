package com.cxsz.mealbuy.view.viewInterface;

import com.cxsz.mealbuy.model.net.MealCodeData;

public interface ContactView extends BaseView {
    void ResponseAddOrDelVoiceWhiteManager(MealCodeData t);

    void ResponseQueryVoiceWhiteList(MealCodeData t);

    void ResponseQueryAddWhiteCount(MealCodeData t);

    void showSuccessInfo(String info);
}
