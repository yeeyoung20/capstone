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
            findNearestMarkerAndNavigate(locationSource.lastLocation)
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
    private fun findNearestMarkerAndNavigate(lastLocation: android.location.Location?) {
        if (lastLocation != null && markersPosition != null && markersPosition!!.isNotEmpty()) {
            val currentPosition = LatLng(lastLocation.latitude, lastLocation.longitude)
            var nearestMarker: Marker? = null
            var shortestDistance = Double.MAX_VALUE

            for (marker in activeMarkers!!) {
                val markerPosition = marker.position
                val distance = calculateDistance(currentPosition, markerPosition)
                if (distance < shortestDistance) {
                    shortestDistance = distance
                    nearestMarker = marker
                }
            }

            // 가장 가까운 마커가 존재하면 해당 마커까지 경로 안내 시작
            if (nearestMarker != null) {
                navigateToMarker(nearestMarker.position)
            }
        }
    }

    // 두 위치간 거리 계산
    private fun calculateDistance(position1: LatLng, position2: LatLng): Double {
        val latDiff = Math.toRadians(position2.latitude - position1.latitude)
        val lngDiff = Math.toRadians(position2.longitude - position1.longitude)
        val a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) +
                Math.cos(Math.toRadians(position1.latitude)) * Math.cos(Math.toRadians(position2.latitude)) *
                Math.sin(lngDiff / 2) * Math.sin(lngDiff / 2)
        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        val earthRadius = 6371 // 지구 반지름 (단위: km)
        return earthRadius * c
    }

    // 선택한 마커까지 경로 안내 시작
    private fun navigateToMarker(markerPosition: LatLng) {
        val currentPosition = locationSource.lastLocation
        if (currentPosition != null) {
            val start = LatLng(currentPosition.latitude, currentPosition.longitude)
            val end = markerPosition

            // 경로 안내 생성
            val request = createDirectionRequest(start, end)
            sendDirectionRequest(request)
        }
    }

    // 경로 안내를 위한 Direction API 요청 생성
    private fun createDirectionRequest(start: LatLng, end: LatLng): Request {
        val url = "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving"
        val clientId = "gltf29rywr" // 본인의 네이버 클라이언트 ID 입력
        val clientSecret = "pp0hbjM5trHLFo0r1lazxHTDI7se0njR8o1opx9V" // 본인의 네이버 클라이언트 시크릿 입력

        val requestUrl = "$url?start=${start.longitude},${start.latitude}&goal=${end.longitude},${end.latitude}"
        val request = Request.Builder()
            .url(requestUrl)
            .header("gltf29rywr", clientId)
            .header("pp0hbjM5trHLFo0r1lazxHTDI7se0njR8o1opx9V", clientSecret)
            .build()

        return request
    }

    // 경로 안내를 위한 Direction API 요청 전송
    private fun sendDirectionRequest(request: Request) {
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // 요청 실패 시 처리
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                // 요청 성공 시 처리
                response.body?.let { responseBody ->
                    val responseData = responseBody.string()
                    try {
                        val jsonObject = JSONObject(responseData)
                        val route = jsonObject.getJSONArray("route").getJSONObject(0)
                        val path = route.getJSONObject("summary").getString("path")
                        runOnUiThread {
                            drawPath(path)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }

    // 경로 그리기
    private fun drawPath(path: String) {
        val pathCoordinates = parsePathCoordinates(path)

        val pathOverlay = PathOverlay()
        pathOverlay.coords = pathCoordinates
        pathOverlay.map = naverMap
    }

    // 경로 좌표 파싱
    private fun parsePathCoordinates(path: String): List<LatLng> {
        val coordinates = path.split(";")
        val pathCoordinates = mutableListOf<LatLng>()

        for (coordinate in coordinates) {
            val latLng = coordinate.split(",")
            if (latLng.size == 2) {
                val lat = latLng[1].toDouble()
                val lng = latLng[0].toDouble()
                pathCoordinates.add(LatLng(lat, lng))
            }
        }

        return pathCoordinates
    }
}

