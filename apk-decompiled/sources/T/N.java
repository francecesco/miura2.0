package T;

import it.tervis.miura.model.Peripheral;

/* JADX INFO: loaded from: classes.dex */
public abstract class N {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static O f177A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static O f178B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static O f179C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private static O f180D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static O f181E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static O f182F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static O f183G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private static O f184H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static O f185I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static O f186J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static O f187K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static O f188L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static O f189M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static O f190N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static O f191O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static O f192P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static O f193Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static O f194R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static O f195a = O.f("analytics.service_enabled", false, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static O f196b = O.f("analytics.service_client_enabled", true, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static O f197c = O.e("analytics.log_tag", "GAv4", "GAv4-SVC");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static O f198d = O.d("analytics.max_tokens", 60, 60);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static O f199e = O.b("analytics.tokens_per_sec", 0.5f, 0.5f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static O f200f = O.c("analytics.max_stored_hits", 2000, 20000);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static O f201g = O.c("analytics.max_stored_hits_per_app", 2000, 2000);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static O f202h = O.c("analytics.max_stored_properties_per_app", 100, 100);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static O f203i = O.d("analytics.local_dispatch_millis", 1800000, 120000);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static O f204j = O.d("analytics.initial_local_dispatch_millis", 5000, 5000);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static O f205k = O.d("analytics.min_local_dispatch_millis", 120000, 120000);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static O f206l = O.d("analytics.max_local_dispatch_millis", 7200000, 7200000);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static O f207m = O.d("analytics.dispatch_alarm_millis", 7200000, 7200000);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static O f208n = O.d("analytics.max_dispatch_alarm_millis", 32400000, 32400000);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static O f209o = O.c("analytics.max_hits_per_dispatch", 20, 20);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static O f210p = O.c("analytics.max_hits_per_batch", 20, 20);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static O f211q = O.e("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static O f212r = O.e("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static O f213s = O.e("analytics.simple_endpoint", "/collect", "/collect");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static O f214t = O.e("analytics.batching_endpoint", "/batch", "/batch");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static O f215u = O.c("analytics.max_get_length", 2036, 2036);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static O f216v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static O f217w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static O f218x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static O f219y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static O f220z;

    static {
        EnumC0100x enumC0100x = EnumC0100x.BATCH_BY_COUNT;
        f216v = O.e("analytics.batching_strategy.k", enumC0100x.name(), enumC0100x.name());
        String strName = B.GZIP.name();
        f217w = O.e("analytics.compression_strategy.k", strName, strName);
        f218x = O.c("analytics.max_hits_per_request.k", 20, 20);
        f219y = O.c("analytics.max_hit_length.k", Peripheral.EXPANSION_5, Peripheral.EXPANSION_5);
        f220z = O.c("analytics.max_post_length.k", Peripheral.EXPANSION_5, Peripheral.EXPANSION_5);
        f177A = O.c("analytics.max_batch_post_length", Peripheral.EXPANSION_5, Peripheral.EXPANSION_5);
        f178B = O.e("analytics.fallback_responses.k", "404,502", "404,502");
        f179C = O.c("analytics.batch_retry_interval.seconds.k", 3600, 3600);
        f180D = O.d("analytics.service_monitor_interval", 86400000L, 86400000L);
        f181E = O.c("analytics.http_connection.connect_timeout_millis", 60000, 60000);
        f182F = O.c("analytics.http_connection.read_timeout_millis", 61000, 61000);
        f183G = O.d("analytics.campaigns.time_limit", 86400000L, 86400000L);
        f184H = O.e("analytics.first_party_experiment_id", "", "");
        f185I = O.c("analytics.first_party_experiment_variant", 0, 0);
        f186J = O.f("analytics.test.disable_receiver", false, false);
        f187K = O.d("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
        f188L = O.d("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
        f189M = O.d("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
        f190N = O.d("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
        f191O = O.d("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
        f192P = O.d("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
        f193Q = O.d("analytics.initialization_warning_threshold", 5000L, 5000L);
        f194R = O.f("analytics.gcm_task_service", false, false);
    }
}
