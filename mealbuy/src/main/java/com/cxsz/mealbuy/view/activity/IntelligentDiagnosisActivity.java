package com.cxsz.mealbuy.view.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.R2;
import com.cxsz.mealbuy.base.BaseActivity;
import com.cxsz.mealbuy.bean.MealInfoBean;
import com.cxsz.mealbuy.component.LogUtil;
import com.cxsz.mealbuy.component.MealConstants;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.component.ToastUtil;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.presenter.presenterImpl.IntelligentDiagnosisPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterImpl.MineMealPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterInterface.IntelligentDiagnosisPresenter;
import com.cxsz.mealbuy.presenter.presenterInterface.MineMealPresenter;
import com.cxsz.mealbuy.view.viewInterface.IntelligentDiagnosisView;
import com.cxsz.mealbuy.view.viewInterface.MineMealView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 智能诊断界面
 */
public class IntelligentDiagnosisActivity extends BaseActivity implements IntelligentDiagnosisView, MineMealView, View.OnClickListener {

    @BindView(R2.id.base_left_iv)
    View leftArea;

    @BindView(R2.id.card_number)
    TextView cardNumber;

    @BindView(R2.id.icc_id_number)
    TextView iccIdNumber;

    @BindView(R2.id.search_anim)
    ImageView searchAnim;

    @BindView(R2.id.status)
    TextView status;

    @BindView(R2.id.re_diagnosis)
    TextView reDiagnosis;


    @BindView(R2.id.diagnosis_scroll_area)
    NestedScrollView diagnosis_scroll_area;

    @BindView(R2.id.real_name_authentication_notice)
    TextView realNameAuthenticationNotice;
    @BindView(R2.id.real_name_authentication)
    ImageView realNameAuthentication;

    @BindView(R2.id.diagnosis_of_card_package_notice)
    TextView diagnosisOfCardPackageNotice;
    @BindView(R2.id.diagnosis_of_card_package)
    ImageView diagnosisOfCardPackage;

    @BindView(R2.id.activation_state_notice)
    TextView activationStateNotice;
    @BindView(R2.id.activation_state)
    ImageView activationState;

    @BindView(R2.id.update_voice_data_notice)
    TextView updateVoiceDataNotice;
    @BindView(R2.id.update_voice_data)
    ImageView updateVoiceData;

    @BindView(R2.id.speech_usage_detection_notice)
    TextView speechUsageDetectionNotice;
    @BindView(R2.id.speech_usage_detection)
    ImageView speechUsageDetection;

    @BindView(R2.id.update_traffic_data_notice)
    TextView updateTrafficDataNotice;
    @BindView(R2.id.update_traffic_data)
    ImageView updateTrafficData;

    @BindView(R2.id.flow_usage_detection_notice)
    TextView flowUsageDetectionNotice;
    @BindView(R2.id.flow_usage_detection)
    ImageView flowUsageDetection;

    @BindView(R2.id.white_list_diagnosis_notice)
    TextView whiteListDiagnosisNotice;
    @BindView(R2.id.white_list_diagnosis)
    ImageView whiteListDiagnosis;

    @BindView(R2.id.card_diagnosis_notice)
    TextView cardDiagnosisNotice;
    @BindView(R2.id.card_diagnosis)
    ImageView cardDiagnosis;

    @BindView(R2.id.real_name_authentication_result_area)
    View real_name_authentication_result_area;
    @BindView(R2.id.real_name_authentication_result)
    TextView real_name_authentication_result;

    @BindView(R2.id.diagnosis_of_card_package_result_area)
    View diagnosis_of_card_package_result_area;
    @BindView(R2.id.diagnosis_of_card_package_result)
    TextView diagnosis_of_card_package_result;

    @BindView(R2.id.activation_state_result_area)
    View activation_state_result_area;
    @BindView(R2.id.activation_state_result)
    TextView activation_state_result;

    @BindView(R2.id.update_voice_data_result_area)
    View update_voice_data_result_area;
    @BindView(R2.id.update_voice_data_result)
    TextView update_voice_data_result;

    @BindView(R2.id.speech_usage_detection_result_area)
    View speech_usage_detection_result_area;
    @BindView(R2.id.speech_usage_detection_result)
    TextView speech_usage_detection_result;

    @BindView(R2.id.update_traffic_data_result_area)
    View update_traffic_data_result_area;
    @BindView(R2.id.update_traffic_data_result)
    TextView update_traffic_data_result;

    @BindView(R2.id.flow_usage_detection_result_area)
    View flow_usage_detection_result_area;
    @BindView(R2.id.flow_usage_detection_result)
    TextView flow_usage_detection_result;

    @BindView(R2.id.white_list_diagnosis_result_area)
    View white_list_diagnosis_result_area;
    @BindView(R2.id.white_list_diagnosis_result)
    TextView white_list_diagnosis_result;

    @BindView(R2.id.card_diagnosis_notice_result_area)
    View card_diagnosis_notice_result_area;
    @BindView(R2.id.card_diagnosis_notice_result)
    TextView card_diagnosis_notice_result;

    @BindView(R2.id.result_normal_area)
    View result_normal_area;

    @BindView(R2.id.result_unusual_area)
    View result_unusual_area;
    private MineMealPresenter mineMealPresenter;
    IntelligentDiagnosisPresenter intelligentDiagnosisPresenter;
    private MealInfoBean.BodyBean bodyBean;

    //记录所有接口返回值
    private StringBuffer states = new StringBuffer();

    @Override
    protected int getLayoutId() {
        return R.layout.intelligent_diagnosis_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this);
        mineMealPresenter = new MineMealPresenterImpl(this);
        intelligentDiagnosisPresenter = new IntelligentDiagnosisPresenterImpl(this, this);
        if (MealInfoHelper.getInstance().getNumber() != null) {
            //查询卡的基本信息
            mineMealPresenter.RequestSimCardMealInfo(IntelligentDiagnosisActivity.this, MealInfoHelper.getInstance().getNumber());
            diagnosis();
        }
        leftArea.setOnClickListener(this);
        reDiagnosis.setOnClickListener(this);
        cardNumber.setText(MealInfoHelper.getInstance().getNumber());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.base_left_iv) {
            finish();
        } else if (view.getId() == R.id.re_diagnosis) {
            diagnosis();
        }
    }

    @Override
    public <T> void ResponseSimCardMealInfo(T t) {
        bodyBean = (MealInfoBean.BodyBean) t;
        if (null != iccIdNumber) {
            iccIdNumber.setText(bodyBean.getIccid());
        }
        reDiagnosis.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        reDiagnosis.getPaint().setAntiAlias(true);
        diagnosisAnim();
    }

    @Override
    public <T> void ResponseSimCardMealList(T t) {

    }

    @Override
    public <T> void ResponseRealNameDiagnosis(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == realNameAuthenticationNotice || null == realNameAuthentication
                || null == real_name_authentication_result_area || null == real_name_authentication_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        realNameAuthenticationNotice.setVisibility(View.GONE);
        realNameAuthentication.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            real_name_authentication_result_area.setVisibility(View.GONE);
            realNameAuthentication.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                realNameAuthentication.setImageResource(R.mipmap.failure_icon);
            } else {
                realNameAuthentication.setImageResource(R.mipmap.problem_icon);
            }
            real_name_authentication_result_area.setVisibility(View.VISIBLE);
            real_name_authentication_result.setText(codeData.getMessage() + "");
            finishDiagnosis(0);
        }
        intelligentDiagnosisPresenter.RequestCardPackageDiagnosis(MealInfoHelper.getInstance().getNumber());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseCardPackageDiagnosis(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == diagnosisOfCardPackageNotice || null == diagnosisOfCardPackage
                || null == diagnosis_of_card_package_result_area || null == diagnosis_of_card_package_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        diagnosisOfCardPackageNotice.setVisibility(View.GONE);
        diagnosisOfCardPackage.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            diagnosis_of_card_package_result_area.setVisibility(View.GONE);
            diagnosisOfCardPackage.setImageResource(R.mipmap.success_icon);

        } else {
            if (codeData.getCode() == 0) {
                diagnosisOfCardPackage.setImageResource(R.mipmap.failure_icon);
            } else {
                diagnosisOfCardPackage.setImageResource(R.mipmap.problem_icon);
            }
            diagnosis_of_card_package_result_area.setVisibility(View.VISIBLE);
            diagnosis_of_card_package_result.setText(codeData.getMessage() + "");
            finishDiagnosis(1);
        }
        intelligentDiagnosisPresenter.RequestSynchronizationCardStatus(MealInfoHelper.getInstance().getNumber());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseSynchronizationCardStatus(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == activationStateNotice || null == activationState
                || null == activation_state_result_area || null == activation_state_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        activationStateNotice.setVisibility(View.GONE);
        activationState.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            activation_state_result_area.setVisibility(View.GONE);
            activationState.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                activationState.setImageResource(R.mipmap.failure_icon);
            } else {
                activationState.setImageResource(R.mipmap.problem_icon);
            }
            finishDiagnosis(2);
            activation_state_result_area.setVisibility(View.VISIBLE);
            activation_state_result.setText(codeData.getMessage() + "");
        }
        intelligentDiagnosisPresenter.RequestUpdateVoiceData(MealInfoHelper.getInstance().getNumber());
        states.append(codeData.getCode());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseUpdateVoiceData(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == updateVoiceDataNotice || null == updateVoiceData
                || null == update_voice_data_result_area || null == update_voice_data_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        updateVoiceDataNotice.setVisibility(View.GONE);
        updateVoiceData.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            update_voice_data_result_area.setVisibility(View.GONE);
            updateVoiceData.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                updateVoiceData.setImageResource(R.mipmap.failure_icon);
            } else {
                updateVoiceData.setImageResource(R.mipmap.problem_icon);
            }
            finishDiagnosis(3);
            update_voice_data_result_area.setVisibility(View.VISIBLE);
            update_voice_data_result.setText(codeData.getMessage() + "");
        }
        intelligentDiagnosisPresenter.RequestUpdateTrafficData(MealInfoHelper.getInstance().getNumber());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseUpdateTrafficData(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == speechUsageDetectionNotice || null == speechUsageDetection
                || null == speech_usage_detection_result_area || null == speech_usage_detection_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        speechUsageDetectionNotice.setVisibility(View.GONE);
        speechUsageDetection.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            speech_usage_detection_result_area.setVisibility(View.GONE);
            speechUsageDetection.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                speechUsageDetection.setImageResource(R.mipmap.failure_icon);
            } else {
                speechUsageDetection.setImageResource(R.mipmap.problem_icon);
            }
            finishDiagnosis(4);
            speech_usage_detection_result_area.setVisibility(View.VISIBLE);
            speech_usage_detection_result.setText(codeData.getMessage() + "");
        }
        intelligentDiagnosisPresenter.RequestFlowDetection(MealInfoHelper.getInstance().getNumber());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseFlowDetection(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == updateTrafficDataNotice || null == updateTrafficData
                || null == update_traffic_data_result_area || null == update_traffic_data_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        updateTrafficDataNotice.setVisibility(View.GONE);
        updateTrafficData.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            update_traffic_data_result_area.setVisibility(View.GONE);
            updateTrafficData.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                updateTrafficData.setImageResource(R.mipmap.failure_icon);
            } else {
                updateTrafficData.setImageResource(R.mipmap.problem_icon);
            }
            finishDiagnosis(5);
            update_traffic_data_result_area.setVisibility(View.VISIBLE);
            update_traffic_data_result.setText(codeData.getMessage() + "");
        }
        intelligentDiagnosisPresenter.RequestSpeechDetection(MealInfoHelper.getInstance().getNumber());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseSpeechDetection(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == flowUsageDetectionNotice || null == flowUsageDetection
                || null == flow_usage_detection_result_area || null == flow_usage_detection_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        flowUsageDetectionNotice.setVisibility(View.GONE);
        flowUsageDetection.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            flow_usage_detection_result_area.setVisibility(View.GONE);
            flowUsageDetection.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                flowUsageDetection.setImageResource(R.mipmap.failure_icon);
            } else {
                flowUsageDetection.setImageResource(R.mipmap.problem_icon);
            }
            finishDiagnosis(6);
            flow_usage_detection_result_area.setVisibility(View.VISIBLE);
            flow_usage_detection_result.setText(codeData.getMessage() + "");
        }
        intelligentDiagnosisPresenter.RequestWhiteListDiagnosis(MealInfoHelper.getInstance().getNumber());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseWhiteListDiagnosis(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == whiteListDiagnosisNotice || null == whiteListDiagnosis
                || null == white_list_diagnosis_result_area || null == white_list_diagnosis_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        whiteListDiagnosisNotice.setVisibility(View.GONE);
        whiteListDiagnosis.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            white_list_diagnosis_result_area.setVisibility(View.GONE);
            whiteListDiagnosis.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                whiteListDiagnosis.setImageResource(R.mipmap.failure_icon);
            } else {
                whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);
            }
            finishDiagnosis(7);
            white_list_diagnosis_result_area.setVisibility(View.VISIBLE);
            white_list_diagnosis_result.setText(codeData.getMessage() + "");
        }
        intelligentDiagnosisPresenter.RequestReadCardStatus(MealInfoHelper.getInstance().getNumber());
        LogUtil.setTagE("Diagnosis", codeData.toString());
    }

    @Override
    public <T> void ResponseReadCardStatus(T t) {
        MealCodeData codeData = (MealCodeData) t;
        if (null == states || null == cardDiagnosisNotice || null == cardDiagnosis
                || null == card_diagnosis_notice_result_area || null == card_diagnosis_notice_result || null == intelligentDiagnosisPresenter) {
            return;
        }
        states.append(codeData.getCode());
        cardDiagnosisNotice.setVisibility(View.GONE);
        cardDiagnosis.setVisibility(View.VISIBLE);
        if (codeData.getCode() == 1) {
            card_diagnosis_notice_result_area.setVisibility(View.GONE);
            cardDiagnosis.setImageResource(R.mipmap.success_icon);
        } else {
            if (codeData.getCode() == 0) {
                cardDiagnosis.setImageResource(R.mipmap.failure_icon);
            } else {
                cardDiagnosis.setImageResource(R.mipmap.problem_icon);
            }
            card_diagnosis_notice_result_area.setVisibility(View.VISIBLE);
            card_diagnosis_notice_result.setText(codeData.getMessage() + "");
        }
        LogUtil.setTagE("Diagnosis", codeData.toString());
        finishDiagnosis(8);
    }

    //诊断结果右侧状态的显示
    private void diagnosis() {
        result_normal_area.setVisibility(View.GONE);
        result_unusual_area.setVisibility(View.GONE);


        realNameAuthenticationNotice.setVisibility(View.VISIBLE);
        realNameAuthentication.setVisibility(View.GONE);

        diagnosisOfCardPackageNotice.setVisibility(View.VISIBLE);
        diagnosisOfCardPackage.setVisibility(View.GONE);

        activationStateNotice.setVisibility(View.VISIBLE);
        activationState.setVisibility(View.GONE);

        updateVoiceDataNotice.setVisibility(View.VISIBLE);
        updateVoiceData.setVisibility(View.GONE);

        updateTrafficDataNotice.setVisibility(View.VISIBLE);
        updateTrafficData.setVisibility(View.GONE);

        flowUsageDetectionNotice.setVisibility(View.VISIBLE);
        flowUsageDetection.setVisibility(View.GONE);

        speechUsageDetectionNotice.setVisibility(View.VISIBLE);
        speechUsageDetection.setVisibility(View.GONE);

        whiteListDiagnosisNotice.setVisibility(View.VISIBLE);
        whiteListDiagnosis.setVisibility(View.GONE);

        cardDiagnosisNotice.setVisibility(View.VISIBLE);
        cardDiagnosis.setVisibility(View.GONE);

        diagnosisAnim();
        intelligentDiagnosisPresenter.RequestRealNameDiagnosis(MealInfoHelper.getInstance().getNumber());
    }

    private void diagnosisAnim() {
        Animation animation = AnimationUtils.loadAnimation(IntelligentDiagnosisActivity.this, R.anim.search_anim);
        if (null != searchAnim) {
            searchAnim.startAnimation(animation);
        }
        if (null != status) {
            status.setText("智能诊断中…");
        }
        reDiagnosis.setVisibility(View.GONE);
    }

    private void finishDiagnosis(int errorLevel) {
        if (states.toString().isEmpty() || states.toString().contains("0") || states.toString().contains("-1")) {
            result_normal_area.setVisibility(View.GONE);
            result_unusual_area.setVisibility(View.VISIBLE);
        } else {
            result_normal_area.setVisibility(View.VISIBLE);
            result_unusual_area.setVisibility(View.GONE);
        }
        if (errorLevel == 0) {
            diagnosisOfCardPackageNotice.setVisibility(View.GONE);
            diagnosisOfCardPackage.setVisibility(View.VISIBLE);
            diagnosisOfCardPackage.setImageResource(R.mipmap.problem_icon);

            activationStateNotice.setVisibility(View.GONE);
            activationState.setVisibility(View.VISIBLE);
            activationState.setImageResource(R.mipmap.problem_icon);

            updateVoiceDataNotice.setVisibility(View.GONE);
            updateVoiceData.setVisibility(View.VISIBLE);
            updateVoiceData.setImageResource(R.mipmap.problem_icon);

            speechUsageDetectionNotice.setVisibility(View.GONE);
            speechUsageDetection.setVisibility(View.VISIBLE);
            speechUsageDetection.setImageResource(R.mipmap.problem_icon);

            updateTrafficDataNotice.setVisibility(View.GONE);
            updateTrafficData.setVisibility(View.VISIBLE);
            updateTrafficData.setImageResource(R.mipmap.problem_icon);

            flowUsageDetectionNotice.setVisibility(View.GONE);
            flowUsageDetection.setVisibility(View.VISIBLE);
            flowUsageDetection.setImageResource(R.mipmap.problem_icon);

            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);

            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        } else if (errorLevel == 1) {
            activationStateNotice.setVisibility(View.GONE);
            activationState.setVisibility(View.VISIBLE);
            activationState.setImageResource(R.mipmap.problem_icon);

            updateVoiceDataNotice.setVisibility(View.GONE);
            updateVoiceData.setVisibility(View.VISIBLE);
            updateVoiceData.setImageResource(R.mipmap.problem_icon);

            speechUsageDetectionNotice.setVisibility(View.GONE);
            speechUsageDetection.setVisibility(View.VISIBLE);
            speechUsageDetection.setImageResource(R.mipmap.problem_icon);

            updateTrafficDataNotice.setVisibility(View.GONE);
            updateTrafficData.setVisibility(View.VISIBLE);
            updateTrafficData.setImageResource(R.mipmap.problem_icon);

            flowUsageDetectionNotice.setVisibility(View.GONE);
            flowUsageDetection.setVisibility(View.VISIBLE);
            flowUsageDetection.setImageResource(R.mipmap.problem_icon);

            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);

            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        } else if (errorLevel == 2) {
            updateVoiceDataNotice.setVisibility(View.GONE);
            updateVoiceData.setVisibility(View.VISIBLE);
            updateVoiceData.setImageResource(R.mipmap.problem_icon);

            speechUsageDetectionNotice.setVisibility(View.GONE);
            speechUsageDetection.setVisibility(View.VISIBLE);
            speechUsageDetection.setImageResource(R.mipmap.problem_icon);

            updateTrafficDataNotice.setVisibility(View.GONE);
            updateTrafficData.setVisibility(View.VISIBLE);
            updateTrafficData.setImageResource(R.mipmap.problem_icon);

            flowUsageDetectionNotice.setVisibility(View.GONE);
            flowUsageDetection.setVisibility(View.VISIBLE);
            flowUsageDetection.setImageResource(R.mipmap.problem_icon);

            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);

            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        } else if (errorLevel == 3) {
            speechUsageDetectionNotice.setVisibility(View.GONE);
            speechUsageDetection.setVisibility(View.VISIBLE);
            speechUsageDetection.setImageResource(R.mipmap.problem_icon);

            updateTrafficDataNotice.setVisibility(View.GONE);
            updateTrafficData.setVisibility(View.VISIBLE);
            updateTrafficData.setImageResource(R.mipmap.problem_icon);

            flowUsageDetectionNotice.setVisibility(View.GONE);
            flowUsageDetection.setVisibility(View.VISIBLE);
            flowUsageDetection.setImageResource(R.mipmap.problem_icon);

            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);

            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        } else if (errorLevel == 4) {
            updateTrafficDataNotice.setVisibility(View.GONE);
            updateTrafficData.setVisibility(View.VISIBLE);
            updateTrafficData.setImageResource(R.mipmap.problem_icon);

            flowUsageDetectionNotice.setVisibility(View.GONE);
            flowUsageDetection.setVisibility(View.VISIBLE);
            flowUsageDetection.setImageResource(R.mipmap.problem_icon);

            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);

            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        } else if (errorLevel == 5) {
            flowUsageDetectionNotice.setVisibility(View.GONE);
            flowUsageDetection.setVisibility(View.VISIBLE);
            flowUsageDetection.setImageResource(R.mipmap.problem_icon);

            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);

            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        } else if (errorLevel == 6) {
            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.problem_icon);

            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        } else if (errorLevel == 7) {
            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.problem_icon);
        }
        String info = "诊断完成！";
        refreshDiagnosis(info);
    }

    private void refreshDiagnosis(String info) {
        if (null != searchAnim) {
            searchAnim.clearAnimation();
        }
        if (null != status) {
            status.setText("诊断完成！");
        }
        if (null != reDiagnosis) {
            reDiagnosis.setVisibility(View.VISIBLE);
        }
        diagnosis_scroll_area.scrollTo(0, NestedScrollView.FOCUS_DOWN);
    }

    @Override
    public void showLoadingView() {
//        startProgressDialog();
    }

    @Override
    public void closeLoadingView() {
//        stopProgressDialog();
    }

    @Override
    public void showErrorInfo(String info) {

    }

    @Override
    public void showErrorInfo(String tag, String info) {
//        ToastUtil.show(IntelligentDiagnosisActivity.this, info);
        if (tag.equals(MealConstants.RESPONSE_REAL_NAME_DIAGNOSIS)) {
            finishDiagnosis(0);
            real_name_authentication_result_area.setVisibility(View.VISIBLE);
            real_name_authentication_result.setText(getResources().getString(R.string.real_name_authentication) + info + "");
            realNameAuthenticationNotice.setVisibility(View.GONE);
            realNameAuthentication.setVisibility(View.VISIBLE);
            realNameAuthentication.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_CARD_PACKAGE_DIAGNOSIS)) {
            finishDiagnosis(1);
            diagnosis_of_card_package_result_area.setVisibility(View.VISIBLE);
            diagnosis_of_card_package_result.setText(getResources().getString(R.string.diagnosis_of_card_package) + info + "");
            diagnosisOfCardPackageNotice.setVisibility(View.GONE);
            diagnosisOfCardPackage.setVisibility(View.VISIBLE);
            diagnosisOfCardPackage.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_SYNCHRONIZATION_CARD_STATUS)) {
            finishDiagnosis(2);
            activation_state_result_area.setVisibility(View.VISIBLE);
            activation_state_result.setText(getResources().getString(R.string.activation_state) + info + "");
            activationStateNotice.setVisibility(View.GONE);
            activationState.setVisibility(View.VISIBLE);
            activationState.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_UPDATE_VOICE_DATA)) {
            finishDiagnosis(3);
            update_voice_data_result_area.setVisibility(View.VISIBLE);
            update_voice_data_result.setText(getResources().getString(R.string.update_voice_data) + info + "");
            updateVoiceDataNotice.setVisibility(View.GONE);
            updateVoiceData.setVisibility(View.VISIBLE);
            updateVoiceData.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_UPDATE_TRAFFIC_DATA)) {
            finishDiagnosis(4);
            update_traffic_data_result_area.setVisibility(View.VISIBLE);
            update_traffic_data_result.setText(getResources().getString(R.string.update_traffic_data) + info + "");
            updateTrafficDataNotice.setVisibility(View.GONE);
            updateTrafficData.setVisibility(View.VISIBLE);
            updateTrafficData.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_FLOW_DETECTION)) {
            finishDiagnosis(5);
            flow_usage_detection_result_area.setVisibility(View.VISIBLE);
            flow_usage_detection_result.setText(getResources().getString(R.string.speech_usage_detection) + info + "");
            flowUsageDetectionNotice.setVisibility(View.GONE);
            flowUsageDetection.setVisibility(View.VISIBLE);
            flowUsageDetection.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_SPEECH_DETECTION)) {
            finishDiagnosis(6);
            speech_usage_detection_result_area.setVisibility(View.VISIBLE);
            speech_usage_detection_result.setText(getResources().getString(R.string.speech_usage_detection) + info + "");
            speechUsageDetectionNotice.setVisibility(View.GONE);
            speechUsageDetection.setVisibility(View.VISIBLE);
            speechUsageDetection.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_WHITE_LIST_DIAGNOSIS)) {
            finishDiagnosis(7);
            white_list_diagnosis_result_area.setVisibility(View.VISIBLE);
            white_list_diagnosis_result.setText(getResources().getString(R.string.white_list_diagnosis) + info + "");
            whiteListDiagnosisNotice.setVisibility(View.GONE);
            whiteListDiagnosis.setVisibility(View.VISIBLE);
            whiteListDiagnosis.setImageResource(R.mipmap.failure_icon);
        } else if (tag.equals(MealConstants.RESPONSE_READ_CARD_STATUS)) {
            finishDiagnosis(8);
            card_diagnosis_notice_result_area.setVisibility(View.VISIBLE);
            card_diagnosis_notice_result.setText(getResources().getString(R.string.card_diagnosis) + info + "");
            cardDiagnosisNotice.setVisibility(View.GONE);
            cardDiagnosis.setVisibility(View.VISIBLE);
            cardDiagnosis.setImageResource(R.mipmap.failure_icon);
        }
        refreshDiagnosis(info);
    }

}
