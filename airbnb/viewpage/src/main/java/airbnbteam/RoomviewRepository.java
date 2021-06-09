package airbnbteam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomviewRepository extends CrudRepository<Roomview, Long> {

    List<Roomview> findByRsvId(Long rsvId);
    List<Roomview> findByRsvId(Long rsvId);
    List<Roomview> findByPayId(Long payId);
    List<Roomview> findByMemId(Long memId);
    List<Roomview> findByMemId(Long memId);
    List<Roomview> findByOrdId(Long ordId);
    List<Roomview> findByOrdId(Long ordId);

}