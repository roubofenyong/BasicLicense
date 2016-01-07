package com.esri.arcgis.android.samples.basiclicense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.android.runtime.ArcGISRuntime;
import com.esri.core.runtime.LicenseLevel;
import com.esri.core.runtime.LicenseResult;

public class MainActivity extends AppCompatActivity {
    private static final String CLIENT_ID = "q2hTSkLt114Z3wBs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LicenseResult licenseResult = ArcGISRuntime.setClientId(CLIENT_ID);
        LicenseLevel licenseLevel = ArcGISRuntime.License.getLicenseLevel();
        if(licenseResult == LicenseResult.VALID && licenseLevel == LicenseLevel.BASIC)
        {
            MessageDialogFragment.showMessage(getString(R.string.basic_license_succeeded),getFragmentManager());
        }
        else
        {
            MessageDialogFragment.showMessage(getString(R.string.valid_client_id_required),getFragmentManager());
        }
        setContentView(R.layout.activity_main);
    }
}
