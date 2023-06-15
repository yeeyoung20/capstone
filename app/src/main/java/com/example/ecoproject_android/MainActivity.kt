package com.example.ecoproject_android

import ViewPagerAdapter
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.util.FusedLocationSource
import me.relex.circleindicator.CircleIndicator3
import java.util.Vector


class MainActivity : AppCompatActivity() , OnMapReadyCallback{

    private var banner = mutableListOf<Int>()
    private val LOCATION_PERMISSTION_REQUEST_CODE: Int = 1000
    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap
    private var currentLocation: LatLng? = null
    private var markersPosition: Vector<LatLng>? = null
    private var activeMarkers: Vector<Marker>? = null

    private lateinit var adapter: PostAdapter
    private lateinit var listView: ListView
    private lateinit var database: FirebaseDatabase
    private lateinit var postsRef: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener
    private var postList: MutableList<Post> = mutableListOf() // 초기화 변경

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search=findViewById<ImageButton>(R.id.searchid)
        val viewpager = findViewById<ViewPager2>(R.id.viewpager)
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        var mainmap = findViewById<MapView>(R.id.mainmapView)

        locationSource = FusedLocationSource(this, LOCATION_PERMISSTION_REQUEST_CODE)
        mainmap.onCreate(savedInstanceState)
        mainmap.getMapAsync(this);


        val main1_1=findViewById<Button>(R.id.main1_1)
        val main1_2=findViewById<Button>(R.id.main1_2)
        val main1_3=findViewById<Button>(R.id.main1_3)
        val main1_4=findViewById<Button>(R.id.main1_4)
        val main1_5=findViewById<Button>(R.id.main1_5)
        val main1_6=findViewById<Button>(R.id.main1_6)
        val main1_7=findViewById<Button>(R.id.main1_7)
        val main1_8=findViewById<Button>(R.id.main1_8)
        val main1_9=findViewById<Button>(R.id.main1_9)
        val main1_10=findViewById<Button>(R.id.main1_10)
        val main1_11=findViewById<Button>(R.id.main1_11)
        val main2_1=findViewById<Button>(R.id.main2_1)
        val main2_2=findViewById<Button>(R.id.main2_2)
        val main2_3=findViewById<Button>(R.id.main2_3)
        val main2_4=findViewById<Button>(R.id.main2_4)

        postToList()
        viewpager.adapter = ViewPagerAdapter(this,banner)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        indicator.setViewPager(viewpager)



        //메인화면에서 카테고리 이미지버튼 클릭했을 때 화면전환

        search.setOnClickListener{
            val intent= Intent(this, search_page::class.java)
            startActivity(intent)
        }

        main1_1.setOnClickListener{
            val intent= Intent(this, CategoryMain1::class.java)
            startActivity(intent)
        }
        main1_2.setOnClickListener{
            val intent= Intent(this, CategoryMain2::class.java)
            startActivity(intent)
        }
        main1_3.setOnClickListener{
            val intent= Intent(this, CategoryMain3::class.java)
            startActivity(intent)
        }
        main1_4.setOnClickListener{
            val intent= Intent(this, CategoryMain4::class.java)
            startActivity(intent)
        }
        main1_5.setOnClickListener{
            val intent= Intent(this, CategoryMain5::class.java)
            startActivity(intent)
        }
        main1_6.setOnClickListener{
            val intent= Intent(this, CategoryMain6::class.java)
            startActivity(intent)
        }
        main1_7.setOnClickListener{
            val intent= Intent(this, CategoryMain7::class.java)
            startActivity(intent)
        }
        main1_8.setOnClickListener{
            val intent= Intent(this, CategoryMain8::class.java)
            startActivity(intent)
        }
        main1_9.setOnClickListener{
            val intent= Intent(this, CategoryMain9::class.java)
            startActivity(intent)
        }
        main1_10.setOnClickListener{
            val intent= Intent(this, CategoryMain10::class.java)
            startActivity(intent)
        }
        main1_11.setOnClickListener{
            val intent= Intent(this, CategoryMain11::class.java)
            startActivity(intent)
        }
        main2_1.setOnClickListener {
            val intent = Intent(this, CommunityMain::class.java)
            startActivity(intent)
        }
        main2_2.setOnClickListener {
            val intent = Intent(this, ChattingMain::class.java)
            startActivity(intent)
        }
        main2_3.setOnClickListener {
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }
        main2_4.setOnClickListener{
            val intent= Intent(this, MainActivityMorepage::class.java)
            startActivity(intent)
        }
        mainmap.setOnClickListener{
            val intent= Intent(this, MainActivityMorepage::class.java)
            startActivity(intent)
        }



        postList = mutableListOf()
        listView = findViewById(R.id.listview)

        adapter = PostAdapter(this, R.layout.activity_list_item_layout, postList)
        listView.adapter = adapter

        database = FirebaseDatabase.getInstance()
        postsRef = database.getReference("posts")
        val builder = AlertDialog.Builder(this)


        val user = FirebaseAuth.getInstance().currentUser
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if(user!=null){
                val post = postList[position] // 선택된 게시물 객체

                // CommunityDetail 액티비티로 전환하고 선택된 게시물의 정보를 전달
                val intent = Intent(this, CommunityDetail::class.java)
                intent.putExtra("title", post.title)
                intent.putExtra("change", post.change)
                intent.putExtra("content", post.content)
                intent.putExtra("userNickname", post.userNickname)
                intent.putExtra("date", post.date)
                intent.putExtra("imageUrl", post.imageUrl)
                intent.putExtra("postId", post.postId)
                intent.putExtra("email", post.email)
                startActivity(intent)
            }else{
                builder.setMessage("로그인 후 이용해주세요!")
                    .setPositiveButton("확인") { dialog, id ->
                        val intent = Intent(this, SignIn::class.java)
                        startActivity(intent)
                    }
                    .setNegativeButton("취소") { dialog, id ->

                    }
                    .create()
                    .show()
            }

        }

        valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                postList.clear()
                adapter.clear()

                for (postSnapshot in dataSnapshot.children) {
                    val post = postSnapshot.getValue(Post::class.java)
                    post?.let {
                        postList.add(it)
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
                // ...
            }
        }

    }

    override fun onStart() {
        super.onStart()
        postsRef.addValueEventListener(valueEventListener)
    }

    override fun onStop() {
        super.onStop()
        postsRef.removeEventListener(valueEventListener)
    }





    private fun addToList(bnimag:Int){
        banner.add(bnimag)
    }
    private fun postToList(){

            addToList(R.drawable.banner)
            addToList(R.drawable.bannertmoney)
            addToList(R.drawable.bannerreadencfile)
            addToList(R.drawable.bannerreadencfile2)

    }

    override fun onMapReady(p0: NaverMap) {
        this.naverMap = p0

        //현재위치
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow

        //네이버맵 ui 현재위치 버튼등
        // 카메라 초기 위치 설정
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
        getVal()//db가져오는 메소드드


        // 카메라 이동 되면 호출 되는 이벤트
        naverMap.addOnCameraChangeListener { reason, animated -> freeActiveMarkers()
            // 정의된 마커위치들중 가시거리 내에있는것들만 마커 생성
            val currentPosition = getCurrentPosition(naverMap)
            for (markerPosition in markersPosition!!) {
                if (!withinSightMarker(currentPosition, markerPosition)) continue
                val marker = Marker()
                marker.isHideCollidedCaptions = true //마커 겹치게하는 메소드
                marker.isHideCollidedMarkers = true  //마커 겹치게하는 메소드
                marker.position = markerPosition
                marker.map = naverMap
                activeMarkers?.add(marker)
            }
        }

        naverMap.addOnLocationChangeListener { location ->
            currentLocation = LatLng(location.latitude, location.longitude)
        }
    }
    fun getCurrentPosition(naverMap: NaverMap): LatLng {
        val cameraPosition = naverMap.cameraPosition
        return LatLng(cameraPosition.target.latitude, cameraPosition.target.longitude)
    }
    // 선택한 마커의 위치가 가시거리(카메라가 보고있는 위치 반경 3km 내)에 있는지 확인
    val REFERANCE_LAT = 1 / 109.958489129649955
    val REFERANCE_LNG = 1 / 88.74
    val REFERANCE_LAT_X3 = 3 / 109.958489129649955
    val REFERANCE_LNG_X3 = 3 / 88.74
    fun withinSightMarker(currentPosition: LatLng, markerPosition: LatLng): Boolean {
        val withinSightMarkerLat =
            Math.abs(currentPosition.latitude - markerPosition.latitude) <= REFERANCE_LAT_X3
        val withinSightMarkerLng =
            Math.abs(currentPosition.longitude - markerPosition.longitude) <= REFERANCE_LNG_X3
        return withinSightMarkerLat && withinSightMarkerLng
    }

    // 지도상에 표시되고있는 마커들 지도에서 삭제
    private fun freeActiveMarkers() {
        if (activeMarkers == null) {
            activeMarkers = Vector<Marker>()
            return
        }
        for (activeMarker in activeMarkers!!) {
            activeMarker.map = null
        }
        activeMarkers = Vector<Marker>()
    }

    /*여기까지 보이는 화면 부분만 마커 표시*/

    //위경도 db블러옴
    open fun getVal() {
        val dbHelper = DataBaseHelper(this)
        val db = dbHelper.readableDatabase
        val cursor: Cursor =
            db.rawQuery("SELECT * FROM LatLng", null)
        //" and name = ?",new String[]{"홍길동"});
        markersPosition = Vector()
        while (cursor.moveToNext()) {
            val latitude = cursor.getDouble(0)
            val longitude = cursor.getDouble(1)
            markersPosition!!.add(LatLng(latitude, longitude))
        }
        cursor.close()
        dbHelper.close()
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}