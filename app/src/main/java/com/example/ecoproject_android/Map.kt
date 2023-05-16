package com.example.ecoproject_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.util.FusedLocationSource

class Map : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var naverMap:NaverMap
    private lateinit var locationSource : FusedLocationSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val back=findViewById<Button>(R.id.back)

        //뒤로가기
        back.setOnClickListener{finish()}


    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode!= LOCATION_PERMISSION_REQUEST_CODE){
            return
        }
        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }



    override fun onMapReady(map: NaverMap) {
       naverMap = map
        naverMap.maxZoom = 18.0
        naverMap.minZoom = 10.0

        val uiSetting = naverMap.uiSettings
        uiSetting.isLocationButtonEnabled=true

        locationSource =
            FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)
        naverMap.locationSource = locationSource
    }
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1004
    }
}

