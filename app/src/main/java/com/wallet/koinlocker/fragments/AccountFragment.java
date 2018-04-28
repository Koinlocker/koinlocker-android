package com.wallet.koinlocker.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.wallet.koinlocker.AccountDetailsActivity;
import com.wallet.koinlocker.KoinSettingsActivity;
import com.wallet.koinlocker.R;
import com.wallet.koinlocker.adapters.AccountInfo;
import com.wallet.koinlocker.adapters.AccountsAdapter;

import java.util.ArrayList;

public class AccountFragment extends Fragment {

    private ArrayList<AccountInfo> accountList = new ArrayList<AccountInfo>();
    AccountsAdapter adapt;

    public AccountFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_account, container, false);

        ImageButton koinSettingsButton = (ImageButton) inflate.findViewById(R.id.koinSettings);
        koinSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KoinSettingsActivity.class);
                startActivity(intent);
            }
        });

        adapt = new AccountsAdapter(getActivity(), accountList);

        setAccount("Account #1", "550000", "1.003 BTC");
        setAccount("Account #2", "275000", "0.5056 BTC");
        setAccount("Account #3", "275000", "0.5056 BTC");
        setAccount("Account #4", "275000", "0.5056 BTC");
        setAccount("Account #5", "275000", "0.5056 BTC");

        ListView listview = (ListView) inflate.findViewById(R.id.accounts_list);
        listview.setAdapter(adapt);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), AccountDetailsActivity.class);
                intent.putExtra("click_position",position + 1);
                startActivity(intent);
            }
        });

        return inflate;
    }

    private void setAccount(String accountName, String fiatBalance, String cryptoBalance) {
        final AccountInfo account = new AccountInfo();
        account.setAccountName(accountName);
        account.setBalanceInFiatCurrency(fiatBalance);
        account.setBalanceInCryptoCurrency(cryptoBalance);
        accountList.add(account);
    }


}
