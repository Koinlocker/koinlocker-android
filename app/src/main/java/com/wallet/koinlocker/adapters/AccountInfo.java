package com.wallet.koinlocker.adapters;

import java.io.Serializable;

public class AccountInfo implements Serializable {

    private String accountName;
    private String balanceInFiatCurrency;
    private String balanceInCryptoCurrency;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBalanceInFiatCurrency() {
        return balanceInFiatCurrency;
    }

    public void setBalanceInFiatCurrency(String balanceInFiatCurrency) {
        this.balanceInFiatCurrency = balanceInFiatCurrency;
    }

    public String getBalanceInCryptoCurrency() {
        return balanceInCryptoCurrency;
    }

    public void setBalanceInCryptoCurrency(String balanceInCryptoCurrency) {
        this.balanceInCryptoCurrency = balanceInCryptoCurrency;
    }
}