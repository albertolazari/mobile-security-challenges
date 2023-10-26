package com.example.victimapp;

import android.util.Base64;
import android.util.Log;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class FlagContainer implements Serializable {
    private static final long serialVersionUID = 1777556209636587368L;
    private String[] parts;
    private ArrayList<Integer> perm;

    public FlagContainer(String[] parts, ArrayList<Integer> perm) {
        this.parts = parts;
        this.perm = perm;
    }

    private String getFlag() {
        int n = parts.length;
        int i;
        String b64 = new String();
        for (i=0; i<n; i++) {
            b64 += parts[perm.get(i)];
        }

        byte[] flagBytes = Base64.decode(b64, Base64.DEFAULT);
        String flag = new String(flagBytes, Charset.defaultCharset());

        return flag;
    }
}
