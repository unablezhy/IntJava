package ttl.larku.app;

import ttl.larku.domain.Track;

/**
 * @author whynot
 */
public class TrackApp {

    public static void main(String[] args) {
        Track t = new Track();
        t.setDuration("5:00");
        t.setAlbum("Joy to Life");


        Track t2 = new Track.TrackBuilder()
                .duration("5:00")
                .album("Joy to Life")
                .build();

        System.out.println(t2);
    }
}
