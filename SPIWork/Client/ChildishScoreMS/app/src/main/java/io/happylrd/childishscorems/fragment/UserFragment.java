package io.happylrd.childishscorems.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.model.Student;
import io.happylrd.childishscorems.utils.ShareUtil;
import io.happylrd.childishscorems.utils.StaticClass;

public class UserFragment extends Fragment {

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;

    private ImageView mAvatarImage;
    private TextView mRealnameText;
    private TextView mMobileText;
    private TextView mGenderText;
    private TextView mBirthdayText;
    private TextView mSchoolText;
    private TextView mMajorText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);

        initView(view);
        initData();

        return view;
    }

    private void initView(View view) {
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)
                view.findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mAvatarImage = (ImageView) view.findViewById(R.id.civ_avatar);
        mRealnameText = (TextView) view.findViewById(R.id.tv_realname);
        mMobileText = (TextView) view.findViewById(R.id.tv_mobile);
        mGenderText = (TextView) view.findViewById(R.id.tv_gender);
        mBirthdayText = (TextView) view.findViewById(R.id.tv_birthday);
        mSchoolText = (TextView) view.findViewById(R.id.tv_school);
        mMajorText = (TextView) view.findViewById(R.id.tv_major);
    }

    private void initData() {
        Student student = ShareUtil.getStudent(getActivity(),
                StaticClass.SHARE_CURRENT_USER, "");
        mRealnameText.setText(student.getRealname());
        mMobileText.setText(student.getMobile());
        mGenderText.setText(student.getGender());
        mBirthdayText.setText(student.getBirthday());
        mSchoolText.setText(student.getSchool());
        mMajorText.setText(student.getMajor());

        Glide.with(getActivity())
                .load(R.drawable.default_activitybean_image)
                .into(mAvatarImage);
    }
}
