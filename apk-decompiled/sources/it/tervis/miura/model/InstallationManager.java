package it.tervis.miura.model;

import Y.b;

/* JADX INFO: loaded from: classes.dex */
public class InstallationManager {
    private static InstallationManager _instance;
    private Installation mCurrentInstallation = new Installation();

    public static InstallationManager getInstance() {
        if (_instance == null) {
            _instance = new InstallationManager();
        }
        return _instance;
    }

    public static void reset() {
        InstallationManager installationManager = _instance;
        if (installationManager != null) {
            installationManager.mCurrentInstallation.reset();
            _instance.mCurrentInstallation = null;
        }
        _instance = null;
    }

    public Installation getCurrentInstallation() {
        return this.mCurrentInstallation;
    }

    public void handleMessage(b bVar) {
        this.mCurrentInstallation.handleMessage(bVar);
        refresh();
    }

    public void refresh() {
    }
}
