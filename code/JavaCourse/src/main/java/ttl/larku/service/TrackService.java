package ttl.larku.service;

import java.util.Arrays;
import java.util.List;

import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.inmemory.InMemoryTrackDAO;
import ttl.larku.domain.Track;

public class TrackService {

	private BaseDAO<Track> trackDAO;
	
	public TrackService() {
		trackDAO = new InMemoryTrackDAO();
	}
	
	public Track createTrack(String title) {
		Track track = new Track(title, null, null, null, null);
		track = trackDAO.create(track);
		return track;
	}

	public Track createTrack(String title, String artist, String album, String duration, String date) {
		//Track track = new Track(title, List.of(artist), album, duration, date);
		Track track = new Track(title, Arrays.asList(artist), album, duration, date);
		track = trackDAO.create(track);
		return track;
	}
	
	public Track createTrack(Track track) {
		track = trackDAO.create(track);
		
		return track;
	}
	
	public void deleteTrack(int id) {
		Track track = trackDAO.get(id);
		if(track != null) {
			trackDAO.delete(track);
		}
	}
	
	public void updateTrack(Track track) {
		trackDAO.update(track);
	}
	
	public Track getTrack(int id) {
		return trackDAO.get(id);
	}
	
	public List<Track> getAllTracks() {
		return trackDAO.getAll();
	}
	
	public BaseDAO<Track> getTrackDAO() {
		return trackDAO;
	}

	public void setTrackDAO(BaseDAO<Track> trackDAO) {
		this.trackDAO = trackDAO;
	}
	
	public void clear() {
		((InMemoryTrackDAO)trackDAO).deleteStore();
		((InMemoryTrackDAO)trackDAO).createStore();
	}
	
}
