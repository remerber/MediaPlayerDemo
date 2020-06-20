package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener {
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder mSurfaceHolder;
//    private String mPath="http://vfx.mtime.cn/Video/2019/06/16/mp4/190616155507259516.mp4";
    private String mPath2="http://vfx.mtime.cn/Video/2019/06/14/mp4/190614090849863188.mp4";
//    private String mPath1="http://vfx.mtime.cn/Video/2019/06/27/mp4/190627231412433967.mp4";
    private String mPath1="https://tv.youkutv.cc/2020/01/14/hI6cp3R3nOgQE9MI/playlist.m3u8";
    private Button btn_start_stop;
    private Button btn_seek;
    private int seekPosition=0;
    private Button btn_bit_small;
    private LinearLayout ll_container;
    private boolean isSmallScreen=false;
    private Button btn_next,btn_last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mediaPlayer = new MediaPlayer();
        initSurfaceviewStateListener();
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);


    }

    private void initView() {
        surfaceView=findViewById(R.id.surfaceView);
        btn_start_stop=findViewById(R.id.btn_start_stop);
        btn_start_stop.setOnClickListener(this);
        btn_seek=findViewById(R.id.btn_seek);
        btn_seek.setOnClickListener(this);
        btn_bit_small=findViewById(R.id.btn_bit_small);
        btn_bit_small.setOnClickListener(this);
        ll_container=findViewById(R.id.ll_container);
        btn_next=findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        btn_last=findViewById(R.id.btn_previous);
        btn_last.setOnClickListener(this);

    }

    private void initSurfaceviewStateListener() {
        mSurfaceHolder=surfaceView.getHolder();
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                setPlayVideo(mPath1);

            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("NewApi")
    private void setPlayVideo( String path) {
        try {
            mediaPlayer.setDisplay(mSurfaceHolder);
//            AssetFileDescriptor afd =  getAssets().openFd("Demo.mp4");
//            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepareAsync();//异步准备
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer player) {
                    Log.e("tag","====onPrepared");
                    Log.e("tag","长度====="+mediaPlayer.getDuration());

                     player.start();
                }
            });
        }catch (Exception e){

        }

    }


    private void startPlay(){

        if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }

    private void stopPlay(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }
    private void pausePlay(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start_stop:

              //   开始 暂停
                 if(mediaPlayer.isPlaying()){
                     //暂停
                     btn_start_stop.setText("开始");
                     pausePlay();
                 }else {
                     btn_start_stop.setText("暂停");
                     startPlay();
                 }
                break;
            case R.id.btn_seek:
                //快进
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+2000);
                break;
            case R.id.btn_bit_small:
                //大小屏幕切换
                if(isSmallScreen){
                    isSmallScreen=false;
                    SwitchBigScreen();
                }else {
                    isSmallScreen=true;
                    SwichSmallScreen();
                }

                break;
            case R.id.btn_next:
                //下一个视频
                mediaPlayer.reset();
                setPlayVideo(mPath2);

                break;
            case R.id.btn_previous:
                //上一个视频
                mediaPlayer.reset();
                setPlayVideo(mPath1);
                break;
        }
    }
    public  void SwitchBigScreen(){
        RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) ll_container.getLayoutParams();
        layoutParams.width= LinearLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height=LinearLayout.LayoutParams.MATCH_PARENT;
        ll_container.setLayoutParams(layoutParams);

    }
    public  void SwichSmallScreen(){
        RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) ll_container.getLayoutParams();
        layoutParams.width= 500;
        layoutParams.height=500;
        ll_container.setLayoutParams(layoutParams);
    }

    @Override   //  错误
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        Log.e("tag","onError=============");
        return false;
    }

    @Override //完成
    public void onCompletion(MediaPlayer mediaPlayer) {
        Log.e("tag","onCompletion=============");

    }

    @Override   //  缓存
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        Log.e("tag","onBufferingUpdate---"+i);
        Log.e("tag","onBufferingUpdate=============");
    }
}
