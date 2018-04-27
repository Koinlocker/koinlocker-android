package com.wallet.koinlocker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wallet.koinlocker.R;

import java.util.ArrayList;

public class AccountsAdapter extends ArrayAdapter<AccountInfo> {

    private Context context;
    private ArrayList<AccountInfo> accountList;

    public AccountsAdapter(@NonNull Context context, ArrayList<AccountInfo> accountList) {
        super(context, R.layout.accounts_list, accountList);
        this.context = context;
        this.accountList = accountList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AccountItemHolder holder = null;
        if(convertView == null){
            // Inflate row layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.accounts_list, parent, false);
            holder = new AccountItemHolder();
            holder.accountNameTextView = (TextView) convertView.findViewById(R.id.account_name);
            holder.fiatBalanceTextView = (TextView) convertView.findViewById(R.id.account_in_fiat_currency);
            holder.cryptoBalanceTextView = (TextView) convertView.findViewById(R.id.account_in_crypto_currency);

            convertView.setTag(holder);
        }
        else
            holder = (AccountItemHolder) convertView.getTag();
        /*holder.accountNameTextView.setText("Account #1");
        holder.fiatBalanceTextView.setText("550000");
        holder.cryptoBalanceTextView.setText("1.003 BTC");*/

        holder.accountNameTextView.setText(accountList.get(position).getAccountName());
        holder.fiatBalanceTextView.setText(accountList.get(position).getBalanceInFiatCurrency());
        holder.cryptoBalanceTextView.setText(accountList.get(position).getBalanceInCryptoCurrency());
        return convertView;
    }
}