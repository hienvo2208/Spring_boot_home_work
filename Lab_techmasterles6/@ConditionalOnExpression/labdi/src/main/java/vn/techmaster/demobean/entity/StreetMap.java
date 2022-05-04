package vn.techmaster.demobean.entity;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class StreetMap {
    private static final String[] froms = {"1 Công xã Paris, Quận 1, Sài Gòn", "289 Hai Bà Trưng,phường 8, Quận 3", "2 Công xã Paris, Phường Bến Nghé, Quận1", "135 Nam Kỳ Khởi Nghĩa, Phường Bến Thành, Quận 1"};
    private static final String[] tos = {"Chợ Bến Thành", "Dinh Độc Lập", "Tòa Thị Chính Sài Gòn", "Nghĩa Dũng Đài", "Hồ Con rùa", "Vườn Tao Đàn"};

    private Random rand;
    private String route;

    public StreetMap(){
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.route ="From: <b>"+getRandomFromArrayString(froms)+"</b> -> To:<b>"+getRandomFromArrayString(tos)+"</b>";

    }
    public String getRoute(){
        return this.route = route;
    }

    private <T>T getRandomFromArrayString(T[] arr) {
        int index = this.rand.nextInt(arr.length);
        return arr[index];
    }
}
