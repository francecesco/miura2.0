package com.google.android.gms.dynamite;

import com.google.android.gms.common.util.DynamiteApi;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class DynamiteModule$DynamiteLoaderClassLoader {

    @GuardedBy("DynamiteLoaderClassLoader.class")
    public static ClassLoader sClassLoader;
}
