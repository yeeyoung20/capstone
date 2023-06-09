package com.example.ecoproject_android

import okhttp3.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.PathOverlay
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.widget.LocationButtonView
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import java.io.IOException


class Map : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mapView: MapView
    private val LOCATION_PERMISSTION_REQUEST_CODE: Int = 1000
    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        //뒤로가기
        val back = findViewById<Button>(R.id.back)

        back.setOnClickListener { finish() }

        locationSource = FusedLocationSource(this, LOCATION_PERMISSTION_REQUEST_CODE)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (locationSource.onRequestPermissionsResult(
                requestCode,
                permissions,
                grantResults
            )
        ) {
            if (!locationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap

        naverMap.locationSource = locationSource

        val uiSettings = naverMap.uiSettings
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
        uiSettings.isLocationButtonEnabled = false
        val locationButtonView = findViewById<LocationButtonView>(R.id.location)
        locationButtonView.map = naverMap

        val initialPosition = LatLng(37.506855, 127.066242)
        val cameraUpdate = CameraUpdate.scrollTo(initialPosition)
        naverMap.moveCamera(
            CameraUpdate.toCameraPosition(
                CameraPosition(
                    NaverMap.DEFAULT_CAMERA_POSITION.target,
                    NaverMap.DEFAULT_CAMERA_POSITION.zoom
                )
            )
        )

        /*여기서 부터 의류 수거함 마커*/
        // 마커들 위치 정의
        getVal()

        // 카메라 이동되면 호출되는 이벤트
        naverMap.addOnCameraChangeListener { reason, animated ->
            freeActiveMarkers()
// 정의된 마커 위치들 중
            // 가시 거리 내에 있는 것들만 마커 생성
            val currentPosition = getCurrentPosition(naverMap)
            for (markerPosition in markersPosition!!) {
                if (!withinSightMarker(currentPosition, markerPosition)) continue
                val marker = Marker()
                marker.isHideCollidedCaptions = true
                marker.isHideCollidedMarkers = true
                marker.position = markerPosition
                marker.map = naverMap
                activeMarkers?.add(marker)
            }

            // 현재 위치 변경 시 호출되는 메서드
            // 가장 가까운 마커를 찾고 경로 안내를 시작하는 메서드 호출
        }
    }

    // 마커 정보 저장할 변수 선언
    private var markersPosition: Vector<LatLng>? = null
    private var activeMarkers: Vector<Marker>? = null

    // 현재 카메라가 보고 있는 위치
    private fun getCurrentPosition(naverMap: NaverMap): LatLng {
        val cameraPosition = naverMap.cameraPosition
        return LatLng(cameraPosition.target.latitude, cameraPosition.target.longitude)
    }

    // 선택한 마커의 위치가 가시 거리(카메라가 보고 있는 위치 반경 3km 내)에 있는지 확인
    private val REFERANCE_LAT = 1 / 109.958489129649955
    private val REFERANCE_LNG = 1 / 88.74
    private val REFERANCE_LAT_X3 = 3 / 109.958489129649955
    private val REFERANCE_LNG_X3 = 3 / 88.74

    private fun withinSightMarker(currentPosition: LatLng, markerPosition: LatLng): Boolean {
        val withinSightMarkerLat =
            Math.abs(currentPosition.latitude - markerPosition.latitude) <= REFERANCE_LAT_X3
        val withinSightMarkerLng =
            Math.abs(currentPosition.longitude - markerPosition.longitude) <= REFERANCE_LNG_X3
        return withinSightMarkerLat && withinSightMarkerLng
    }

    // 지도상에 표시되고 있는 마커들을 지도에서 삭제
    private fun freeActiveMarkers() {
        if (activeMarkers == null) {
            activeMarkers = Vector()
            return
        }
        for (activeMarker in activeMarkers!!) {
            activeMarker.map = null
        }
        activeMarkers = Vector()
    }

    // 가장 가까운 마커를 찾고 경로 안내를 시작하는 메서드


    // 위경도 DB 가져오기
    private fun getVal() {
        val dbHelper = DataBaseHelper(this)
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM LatLng", null)
        markersPosition = Vector()
        while (cursor.moveToNext()) {
            markersPosition!!.add(
                LatLng(
                    cursor.getDouble(0),
                    cursor.getDouble(1)
                )
            )
        }
        cursor.close()
        dbHelper.close()
    }

    // 가장 가까운 마커를 찾고 경로 안내를 시작하는 메서드


}

