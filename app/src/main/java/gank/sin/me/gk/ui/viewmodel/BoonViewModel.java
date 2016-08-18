package gank.sin.me.gk.ui.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import gank.sin.me.gk.BR;
import gank.sin.me.gk.data.model.Gank;
import gank.sin.me.gk.ui.adapter.GankAdapter;

/**
 * Created by sin on 2016/8/15.
 */

public class BoonViewModel extends BaseObservable {

    private Provider<LinearLayoutManager> mLinearProvider;
    private GankAdapter mGankAdapter;
    private List<Gank> mGanks = new ArrayList<>();
    private boolean mIsEmpty;

    @Inject
    public BoonViewModel(Provider<LinearLayoutManager> linearProvider, GankAdapter gankAdapter) {
        mLinearProvider = linearProvider;
        mGankAdapter = gankAdapter;
    }

    public void setGanks( List<Gank> list) {
        mIsEmpty = list!= null && list.size() == 0 ? true : false;
        mGanks.addAll(list);
        mGankAdapter.setGanks(mGanks);
////        notifyPropertyChanged(BR._all);
//        notifyPropertyChanged(BR.desc);
//        notifyPropertyChanged(BR.who);
//        notifyPropertyChanged(BR.publishedAt);
    }

    public void refresh(){
        mGanks.clear();
    }

    @Bindable
    public LinearLayoutManager getLinearLayoutManager() {
        return mLinearProvider.get();
    }

    @Bindable
    public boolean isEmpty() {
        return mIsEmpty;
    }

    public GankAdapter getAdapter() {
        return mGankAdapter;
    }
}