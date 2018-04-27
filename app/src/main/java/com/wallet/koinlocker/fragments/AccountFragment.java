package com.wallet.koinlocker.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.wallet.koinlocker.AccountDetailsActivity;
import com.wallet.koinlocker.HomeActivity;
import com.wallet.koinlocker.R;
import com.wallet.koinlocker.adapters.AccountInfo;
import com.wallet.koinlocker.adapters.AccountsAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private ArrayList <AccountInfo> list = new ArrayList<AccountInfo>();
    AccountsAdapter adapt;

    public AccountFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_account, container, false);

        adapt = new AccountsAdapter(getActivity(),list);

        setItem("Account #1", "550000", "1.003 BTC");
        setItem("Account #2", "275000", "0.5056 BTC");

        ListView listview = (ListView) inflate.findViewById(R.id.accounts_list);
        listview.setAdapter(adapt);

        /*RelativeLayout accountsLayout = (RelativeLayout) inflate.findViewById(R.id.accounts_list_layout);
        accountsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AccountDetailsActivity.class);
                startActivity(intent);
            }
        });*/



        return inflate;
    }

    private void setItem(String account, String fiatBalance, String cryptoBalance){
        final AccountInfo item = new AccountInfo();
        item.setAccountName(account);
        item.setBalanceInFiatCurrency(fiatBalance);
        item.setBalanceInCryptoCurrency(cryptoBalance);
        list.add(item);
    }
}
