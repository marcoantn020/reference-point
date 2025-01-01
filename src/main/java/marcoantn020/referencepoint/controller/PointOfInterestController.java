package marcoantn020.referencepoint.controller;

import marcoantn020.referencepoint.controller.dto.PointInterestDto;
import marcoantn020.referencepoint.entity.PintOfInterest;
import marcoantn020.referencepoint.service.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("points-of-interest")
public class PointOfInterestController {

    @Autowired
    private PointOfInterestService pointOfInterestService;

    @PostMapping
    public ResponseEntity<Void> createPointInterest(@RequestBody PointInterestDto dto) {
        pointOfInterestService.createPointInterest(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<PointInterestDto>> getAllPoints(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                               @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize) {
        var points = pointOfInterestService.all(PageRequest.of(page,pageSize));
        return ResponseEntity.ok(points);
    }

    @GetMapping("near-me")
    public ResponseEntity<List<PintOfInterest>> nearMe(@RequestParam("x_axis") Long x_axis,
                                                       @RequestParam("y_axis") Long y_axis,
                                                       @RequestParam("distance") Long distance) {
        var res = pointOfInterestService.findNearMe(x_axis, y_axis, distance);
        return ResponseEntity.ok(res);
    }
}
