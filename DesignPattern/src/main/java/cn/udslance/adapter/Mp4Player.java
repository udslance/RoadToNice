package cn.udslance.adapter;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-23 19:47
 **/
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
