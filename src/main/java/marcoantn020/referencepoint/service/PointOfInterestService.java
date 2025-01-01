package marcoantn020.referencepoint.service;

import marcoantn020.referencepoint.controller.dto.PointInterestDto;
import marcoantn020.referencepoint.entity.PintOfInterest;
import marcoantn020.referencepoint.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointOfInterestService {

    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;

    public void createPointInterest(PointInterestDto dto) {
        pointOfInterestRepository.save(dto.toEntity());
    }

    public Page<PointInterestDto> all(PageRequest pageRequest) {
        return pointOfInterestRepository.findAll(pageRequest)
                .map(p -> new PointInterestDto(p.getName(), p.getX_axis(), p.getY_axis()));
    }


    public List<PintOfInterest> findNearMe(Long xAxis, Long yAxis, Long distance) {
        // quadrado
        var xMin = xAxis - distance;
        var xMax = xAxis + distance;
        var yMin = yAxis - distance;
        var yMax = yAxis + distance;

        // https://mundoeducacao.uol.com.br/matematica/distancia-entre-dois-pontos.htm
        return pointOfInterestRepository.findNearMe(xMin, xMax, yMin, yMax)
                .stream()
                .filter(p -> distanceBetweenPoints(xAxis, yAxis, p.getX_axis(), p.getY_axis()) <= distance)
                .toList();
    }

    private Double distanceBetweenPoints(Long x1, Long y1, Long x2, Long y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
