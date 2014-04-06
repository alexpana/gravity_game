package org.vertexarmy.gravity.desktop;

/**
 * Created by Alex on 4/6/2014.
 */
@SuppressWarnings("UnusedDeclaration")
public class Resolution {
    public final static Resolution FULLSCREEN = new Resolution(1920, 1080);
    public final static Resolution GALAXY_S3 = new Resolution(1280, 720);
    public final static Resolution EVO3D = new Resolution(960, 540);
    public final static Resolution NEXUS_ONE = new Resolution(800, 480);
    public final static Resolution SMALL_PHONE = new Resolution(480, 320);
    public final static Resolution BIG_WINDOW = new Resolution(1440, 900);

    public final int width;
    public final int height;

    public Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
