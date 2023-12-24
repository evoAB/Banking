package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance-5000, 5000);
        this.tradeLicenseId=tradeLicenseId.toUpperCase();
        if(balance<5000)
            throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if (isValidLicenseId(tradeLicenseId)) {
            // Valid License Id, do nothing
            return;
        }

        throw new Exception("Valid License can not be generated");
    }
    private boolean generateValidLicenseId(String licenseId) throws Exception {
        char[] idChars = licenseId.toCharArray();
        Arrays.sort(idChars);

        int n = idChars.length;
        char[] result = new char[n];

        int evenIndex = 0, oddIndex = 1;

        for (char ch : idChars) {
            if (oddIndex < n) {
                result[oddIndex] = ch;
                oddIndex += 2;
            } else {
                result[evenIndex] = ch;
                evenIndex += 2;
            }
        }

        String generatedLicenseId = new String(result);

        if (!isValidLicenseId(generatedLicenseId)) {
            return false;
        }

        return true;
    }

    private boolean isValidLicenseId(String licenseId) {
        for (int i = 0; i < licenseId.length() - 1; i++) {
            if (licenseId.charAt(i) == licenseId.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
