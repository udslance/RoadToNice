package cn.udslance.adapter;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-23 19:45
 **/
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
