package com.taluttasgiran.pickermodule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Callback;

public class RNSpinnerAdapter extends RecyclerView.Adapter<RNSpinnerAdapter.MyViewHolder> {
    private String[] mDataset;
    RNSpinner rnSpinner;
    Callback callback;
    int selectedItemPosition;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;

        MyViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
        }
    }

    RNSpinnerAdapter(String[] myDataset, RNSpinner androidSpinner, Callback spinnerCallback, int selectedItem) {
        mDataset = myDataset;
        rnSpinner = androidSpinner;
        callback = spinnerCallback;
        selectedItemPosition = selectedItem;
    }

    @Override
    public RNSpinnerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spinner_item, parent, false);
        MyViewHolder vh = new MyViewHolder(linearLayout);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Button button = holder.linearLayout.findViewById(R.id.button);
        if (mDataSet[position] != null) {
            button.setText(mDataSet[position]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rnSpinner.hide();
                    callback.invoke(mDataSet[position], position);
                }
            });
        }else{
            button.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
