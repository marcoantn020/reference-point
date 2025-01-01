package marcoantn020.referencepoint.repository;

import marcoantn020.referencepoint.entity.PintOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointOfInterestRepository extends JpaRepository<PintOfInterest, Long> {

    @Query("""
            SELECT p FROM PintOfInterest p
                        WHERE (p.x_axis >= :xMin AND p.x_axis <= :xMax AND p.y_axis >= :yMin AND p.y_axis <= :yMax)
            """)
    List<PintOfInterest> findNearMe(@Param("xMin") Long xMin,
                                    @Param("xMax")Long xMax,
                                    @Param("yMin")Long yMin,
                                    @Param("yMax")Long yMax);
}
