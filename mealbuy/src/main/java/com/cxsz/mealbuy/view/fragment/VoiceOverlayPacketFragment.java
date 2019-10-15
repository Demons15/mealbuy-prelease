package com.cxsz.mealbuy.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxsz.mealbuy.component.MealConstants;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.adapter.VoiceOverlayPacketRecycleAdapter;
import com.cxsz.mealbuy.base.BaseMainFragment;
import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.view.activity.MealDetailsActivity;

import java.util.List;

public class VoiceOverlayPacketFragment extends BaseMainFragment {
    RecyclerView voiceOverlayPackList;

    @Override
    protected int getLayoutId() {
        return R.layout.voice_overlay_pack_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        voiceOverlayPackList = rootView.findViewById(R.id.voice_overlay_pack_list);
        final List<MealGoodsBean.MealGoodsBodyBean> mealGoodsBodyBeanList = MealInfoHelper.getInstance().getVoiceMealGoodsList();
        if (mealGoodsBodyBeanList != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
            voiceOverlayPackList.setLayoutManager(gridLayoutManager);
            VoiceOverlayPacketRecycleAdapter voiceOverlayPacketRecycleAdapter = new VoiceOverlayPacketRecycleAdapter(getActivity(), mealGoodsBodyBeanList);
            voiceOverlayPackList.setAdapter(voiceOverlayPacketRecycleAdapter);
            voiceOverlayPacketRecycleAdapter.setItemClickListener(new VoiceOverlayPacketRecycleAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
//                    ToastUtil.show(getActivity(), "您点击的是语音叠加包:" + mealGoodsBodyBeanList.get(position).getGoodsName());
                    Intent intent = new Intent(getActivity(), MealDetailsActivity.class);
                    intent.putExtra(MealConstants.PACKET_INFO, mealGoodsBodyBeanList.get(position));
                    startActivity(intent);
                    getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    }

    @Override
    protected void lazyFetchData() {

    }

    public static VoiceOverlayPacketFragment getInstance() {
        VoiceOverlayPacketFragment childInfoFragment = new VoiceOverlayPacketFragment();
        return childInfoFragment;
    }

}
